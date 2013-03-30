package driver;

import data.Corpus;
import data.ReadData;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Corpus corpus = ReadData.LoadFile(ReadData.fileType.dev);
		System.out.println(corpus.getPairs());
	}

}
