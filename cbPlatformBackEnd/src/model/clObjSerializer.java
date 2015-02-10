package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class clObjSerializer {

	
	public void writeToFile(String path, Object obj) throws Exception{
		FileOutputStream fOutStream;
		ObjectOutputStream outStream;
		fOutStream = new FileOutputStream(path);
		outStream = new ObjectOutputStream(fOutStream);
		outStream.writeObject(obj);
		outStream.close();
	}
	
	public Object readFromFile(String path) throws Exception{
		FileInputStream fInStream;
		ObjectInputStream inStream;
		fInStream = new FileInputStream(path);
		inStream = new ObjectInputStream(fInStream);
		return inStream.readObject();
	}
}