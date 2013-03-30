package data;

public class Token {
	
	private String val;
	private String pos;
	
	public Token() {
		val = "";
		pos = "";
	}
	
	public Token(String _val, String _pos ) {
		val = _val;
		pos = _pos;
	}
	
	public String val() {
		return val;
	}
	
	public String pos() {
		return pos;
	}
	
	public void setVal(String _val) {
		val = _val;
	}
	
	public void setPos(String _pos) {
		pos = _pos;
	}
}
