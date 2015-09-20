package com.design;
public class BehavChainOfResp {
	static AbstractLogger getChainOfLogger(){
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
	public static void main(String[] args) {
		AbstractLogger  loggerChain = getChainOfLogger();
		loggerChain.logMessage(AbstractLogger.INFO, "This is info log");
		System.out.println("----------------------");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is info debug");
		System.out.println("----------------------");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is info error");
	}
}
abstract class AbstractLogger {
	   public static int INFO = 1;
	   public static int DEBUG = 2;
	   public static int ERROR = 3;
	   protected int level;
	   protected AbstractLogger nextLogger;
	   public void setNextLogger(AbstractLogger nextLogger){
	      this.nextLogger = nextLogger;
	   }
	   public void logMessage(int level, String message){
	      if(this.level <= level){
	         write(message);
	      }
	      if(nextLogger !=null){
	         nextLogger.logMessage(level, message);
	      }
	   }
	   abstract protected void write(String message);
}

class ConsoleLogger extends AbstractLogger{
	ConsoleLogger(int level){
		this.level=level;
	}
	protected void write(String msg) {
		System.out.println("console:"+msg);
	}
}
class ErrorLogger extends AbstractLogger{
	ErrorLogger(int level){
		this.level=level;
	}
	protected void write(String msg) {
		System.out.println("Error:"+msg);
	}
}
class FileLogger extends AbstractLogger{
	FileLogger (int level){
		this.level=level;
	}
	protected void write(String msg) {
		System.out.println("File:"+msg);
	}
}

