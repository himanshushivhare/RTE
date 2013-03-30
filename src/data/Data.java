package data;

import java.util.Vector;

public class Data {
	private String rawString;
	private Vector<Token> tokens;
	
	public Data() {
		rawString = "";
		tokens = new Vector<Token>();
	}
	
	public Data(String val) {
		rawString = val;
		tokens = new Vector<Token>();
	}
	
	public String rawString() {
		return rawString;
	}
	
	public Vector<Token> tokens() {
		return tokens;
	}
	
	public void setRawString(String val) {
		rawString = val;
	}
}
