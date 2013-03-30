package data;

import java.util.Vector;

public class Corpus {
	
	private ReadData.fileType type;
	private String fileName;
	private Vector<THPair> pairs;
	
	private Corpus(){};
	
	public Corpus(ReadData.fileType _type, String _fileName) {
		type = _type;
		fileName = _fileName;
		pairs = new Vector<THPair>();
	}
	
	public ReadData.fileType getFileType() {
		return type;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public Vector<THPair> getPairs() {
		return pairs;
	}

}
