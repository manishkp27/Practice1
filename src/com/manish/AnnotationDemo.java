package com.manish;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class AnnotationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
@SuppressWarnings(value={"serial","rawtypes","unused"})
class SuppressWarningsTest implements Serializable {
    public void openFile () {
        ArrayList a = new ArrayList ();
		File file = new File ("D:/doc.txt");
    }
}