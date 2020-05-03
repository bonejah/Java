package br.com.deitel.cap.seventheen;

public class ReadSequentialFileTest {
	public static void main(String[] args) {
		ReadSequentialFile application = new ReadSequentialFile();
		application.opeFile();
		application.readRecords();
		application.closeFile();
	}
}
