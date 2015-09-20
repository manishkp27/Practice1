package com.design;

//http://javarevisited.blogspot.in/2012/12/inversion-of-control-dependency-injection-design-pattern-spring-example-tutorial.html
//IOC and DI, both words used interchangeably in Java world but Inversion of Control is more general concept 
//and Dependency Injection is a concrete design pattern.

public class DI_IOC_Demo {
	public static void main(String[] args) {
	}
}

//Dependency problem: In this class object 'auditDao' is having depensdency problem
class AuditServiceImpl implements AuditService{
    private AuditDAO auditDao = new AuditDAO();
    @Override
    public boolean audit (String message) {
       return auditDao.store(message);
    }
  
}

//Dependency Injecton pattern: dependency problem of object 'auditDao' is fixed in this method
class AuditServiceImpl1 implements AuditService{
    private AuditDAO auditDao; 
    public void setAuditDao(AuditDAO auditDao) {
		this.auditDao = auditDao;
	}
    
    @Override
    public boolean audit (String message) {
       return auditDao.store(message);
    }
}


//supporting classes
interface AuditService{
	boolean audit (String message);
}
class AuditDAO{
	public boolean store(String msg){
		return true;}
}


