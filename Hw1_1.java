//***********************************************************
//Class: Hw1_1.java
//Name: James Henson
//Description: Read file, add line number, print file as txt
//***********************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Hw1_1 {

	public static void main(String[] args) {
		System.out.println("Enter filename ");

		Scanner sc = new Scanner(System.in);
		String fileName = sc.next();

		if(fileName!=null && fileName.trim().length()>0){
			BufferedReader br = null;
			BufferedWriter bw = null;
			//try catch block for exception handling
			try {
				br = new BufferedReader(new FileReader(new File(fileName.trim())));
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName.trim().concat(".txt"))))); //add .txt file extension
				String line = null;
				int count = 1;
				while ((line = br.readLine()) != null) {
				   bw.write("["+getLineNumber(count++)+"]"+line+"\n");
				}
				System.out.println("Data written at file " + fileName.trim().concat(".txt"));
			} catch (FileNotFoundException e) {
				System.err.println("File Not Found Exception: " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("File Not Found Exception: " + e.getMessage());
				e.printStackTrace();
			}finally{
				//close BufferedReader
				if(br!=null){
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//close BufferedWriter
				if(bw!=null){
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			System.out.println("File in not valid");
		}

	}
//create method to add leading zeroes
	private static String getLineNumber(int no){
		Integer i = new Integer(no);
		if(no < 100){
		  if(i.toString().length() == 1){
			  return ("00"+i.toString());
		  }else {
			  return ("0"+i.toString());
		  }
		}
		return i.toString();
	}

}

public class C {
	public static final int A = 100;
	public static final int B = 200;

	private int mX;
	private int mY;

	public C() {
		mX= -1;
	}
	public C(int pX) {
		setX(pX);
	}
	public int getX() {
		return mX;
	}
	public int getY() {
		return mY;
	}
	public void setX(int pX) {
		mX = pX;
	}
	public void setY(int pY) {
		mY = pY;
	}
}