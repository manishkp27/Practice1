package com.java7;

import java.io.*;

public class TryWithResource {

	public static void main(String[] args) {

	}
	
	/**
	 * The try-with-resources statement ensures that each resource is closed at
	 * the end of the statement. Any object that implements the
	 * java.lang.AutoCloseable or java.io.Closeable interface can be used as a
	 * resource.
	 * e.g java.sql.Connection, BufferedReader etc. 
	 */
	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
}
