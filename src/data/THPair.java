package data;

public class THPair {
	private String goldResult;
	private String sysResult;
	private int id;
	private Data T;
	private Data H;
	
	public THPair() {
		goldResult = "";
		sysResult = "";
		id = 0;
		T = new Data();
		H = new Data();
	}
	
	public THPair(int _id) {
		goldResult = "";
		sysResult = "";
		id = _id;
		T = new Data();
		H = new Data();
	}
	
	public THPair(int _id, String _goldResult) {
		goldResult = _goldResult;
		sysResult = "";
		id = _id;
		T = new Data();
		H = new Data();
	}
	
	public Data T() {
		return T;
	}
	
	public Data H() {
		return H;
	}
	
}
