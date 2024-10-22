package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

//Book 클래스
class Book implements Serializable {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getISBN() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "title="+title+", author="+author+", publicationYear="+publicationYear+", isbn="+isbn;
	}
	
}

class Library implements Serializable{ 
    static final int CAPACITY = 5;  // 기본 용량을 5로 설정
    private Book[] books; 
    private int top;
    
    public Library() {
    	books = new Book[CAPACITY];
	}
  
    public void sortBooksByTitle(){
        Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    }

    public void sortBooksByISBN(){
        Arrays.sort(books, 0, top, (b1, b2) -> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));
    }

    public Book searchBookByTitle(String title) {
    	for(int i=0; i < top; i++) {
			if(books[i].getTitle().equals(title)) {
				return books[i];
			}
		}
		return null;
       
    }

	public void addBook(Book book) {
		books[top] = book;
		top++;
		
	}

	public void printBooks(String string) {
		System.out.println(string);
		
		for(Book b : books) {
			System.out.println(b.toString());
		}
		
	}
}
public class 과제12 {
	
	private static void saveLibrary(Library library, String filename) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(library);
			System.out.println("write");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static Library loadLibrary(String string) {
		Library lib1 = new Library();
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(string))) {
			lib1 = (Library) in.readObject();
			System.out.println("read");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lib1;
	}
	
    public static void main(String[] args) {

        Library library = new Library();

        // 5개의 Book 객체 배열 저장
        library.addBook(new Book("자바", "강감찬", 1995, "12"));
        library.addBook(new Book("파이썬", "이순신", 2008, "9"));
        library.addBook(new Book("자바스크립트", "을지문덕", 2008, "8"));
        library.addBook(new Book("자료구조", "연개소문", 1994, "45"));
        library.addBook(new Book("리액트", "김춘추", 1999, "7"));
            
        // 현재 도서 목록 출력
        library.printBooks("현재 도서 목록:");

        // 라이브러리 저장
        //library.dat에 파일 기록
        saveLibrary(library, "library.dat");

        System.out.println("-".repeat(80));
        //library.dat에 기록된 파일 읽고
        Library lib = loadLibrary("library.dat");
        
        // 최종 도서 목록 출력
        lib.printBooks("최종 도서 목록:");
    }
}