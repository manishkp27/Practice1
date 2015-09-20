package com.manish;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class Keyboard {

	public static void main(String[] args) throws UnsupportedFlavorException, IOException {
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		System.out.println((String)clipboard.getData(DataFlavor.stringFlavor));*/
		//System.out.println((String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.maxMemory() +" " +runtime.totalMemory()+" " +runtime.availableProcessors());
	}

}
