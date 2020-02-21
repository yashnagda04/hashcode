package hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.javafx.image.impl.IntArgb;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jdk.internal.dynalink.beans.StaticClass;
import sun.java2d.pipe.OutlineTextRenderer;

public class Solution {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String[] totalsArr = in.nextLine().split(" ");
		//getting totals
		long totalBooks=Long.parseLong(totalsArr[0]);
		long totalLibrary=Long.parseLong(totalsArr[1]);
		long totalDays=Long.parseLong(totalsArr[2]);
		
		//creation of books
		ArrayList<Book> booksArrayList=new ArrayList<Book>();
		String[] bookArrStr = in.nextLine().split(" ");
		for(int i=0;i<bookArrStr.length;i++) {
			long score=Long.parseLong(bookArrStr[i]);
			booksArrayList.add(new Book(i, score, false));
		}
		
		//creation of library
		ArrayList<Library> libraryArrayList=new ArrayList<Library>();
		for(int i=0;i<totalLibrary;i++) {
			String[] libraryArrStr = in.nextLine().split(" ");
			int id=i;
			int numBooks=Integer.parseInt(libraryArrStr[0]); 
			int signUpDays=Integer.parseInt(libraryArrStr[1]);
			int shipCap=Integer.parseInt(libraryArrStr[2]);
			
			int[] libBooksArr=new int[numBooks];
			String[] libBookArrStr = in.nextLine().split(" ");
			for(int j=0;j<libBookArrStr.length;j++) {
				libBooksArr[j]=Integer.parseInt(libBookArrStr[j]);
			}
			libraryArrayList.add(new Library(id, numBooks, signUpDays, shipCap, libBooksArr));
		}
		
		//starting the logic here
		int currentLib=0;
		HashMap<Integer,HashMap<Integer,Integer>> outputList=new HashMap<Integer, HashMap<Integer,Integer>>();
		outputList.put(currentLib,new HashMap<Integer,Integer>());
		for(long day=0;day<totalDays;day++) {
			//null check
			if(currentLib>libraryArrayList.size()) return;
			Library library=libraryArrayList.get(currentLib);
			if(library.signUpDays==0) {
				currentLib++;
				outputList.put(currentLib,new HashMap<Integer,Integer>());
				
				//null check
				if(currentLib>libraryArrayList.size()) return;
				library=libraryArrayList.get(currentLib);
			}
			library.signUpDays--;
			setupBooks();
			
			
			int[] mBookarr=library.booksArr;
			for(int m=0;m<library.shipCap;m++) {
				 HashMap<Integer,Integer> outputBooks=outputList.get(currentLib);
				 outputBooks.put(m,mBookarr[m]);
				 outputList.put(currentLib,outputBooks);
			}
			
		}
		
		for(int i=0;i<outputList.size();i++)
		{
			System.out.println(outputList. + " " + outputList.get(i).getValue().length);
			for(int j = 0; j<outputList.get(i).getValue().length;j++) {
				System.out.print(outputList.get(i).getValue().get(j) + " ");
			}
		}
	}
	
	private static void setupBooks() {
		// TODO Auto-generated method stub
		
	}

	static class Book {
		public int id;
		public long score;
		boolean isSubmit;
		public Book(int id, long score, boolean isSubmit){
			this.id = id;
			this.score = score;
			this.isSubmit=isSubmit;
		}
	}
	
	static class Library{
		public int id, numBooks, signUpDays, shipCap;
		public int[] booksArr;
		
		Library(int id, int numBooks, int signUpDays, int shipCap, int[] booksArr){
			this.id = id;
			this.numBooks = numBooks;
			this.signUpDays = signUpDays;
			this.shipCap = shipCap;
			this.booksArr = booksArr;
		}
	}
}
