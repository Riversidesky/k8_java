package com.ruby.java.ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface MediaBook {
	String getMediaType();
}

class Book1 implements MediaBook, Comparable<MediaBook> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	public Book1(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book ["+"title="+title+", author="+author+", publicationYear="+publicationYear+", isbn="+isbn+"]";
	}
	
	@Override
	public int compareTo(MediaBook mbook) {
		return 0;
	}

	@Override
	public String getMediaType() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getTitle() {
		return title;
	};
}

class CDBook implements MediaBook, Comparable<MediaBook> {
	private String title;
	private String artist;
	private String catalogNumber;
	
	public CDBook(String title, String artist, String catalogNumber) {
		this.title = title;
		this.artist = artist;
		this.catalogNumber = catalogNumber;
	}
	
	@Override
	public String toString() {
		return "CDBook ["+"title="+title+", artist="+artist+", catalogNumber="+catalogNumber+"]";
	}
	
	@Override
	public int compareTo(MediaBook mbook) {
		return 0;
	}

	@Override
	public String getMediaType() {
		// TODO Auto-generated method stub
		return null;
	};
	
	public String getArtist() {
		return artist;
	};
}

class USBBook implements MediaBook, Comparable<MediaBook> {
	private String title;
	private int capacity;
	private String serialNumber;
	
	public USBBook(String title, int capacity, String serialNumber) {
		this.title = title;
		this.capacity = capacity;
		this.serialNumber = serialNumber;
	}
	
	@Override
	public String toString() {
		return "USBBook ["+"title="+title+", capacity="+capacity+", serialNumber="+serialNumber+"]";
	}

	@Override
	public int compareTo(MediaBook mbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMediaType() {
		// TODO Auto-generated method stub
		return null;
	}
}	

class Library<T extends MediaBook> {
	private ArrayList<T> items;
	private int capacity;

	public Library () {
		items = new ArrayList<T>();
	}

	//항목 추가
	public void addItem(T item) {
		items.add(item);
	}

	//항목 삭제
	public void removeItem() {
		items.remove(items.size()-1); //인덱스값
	}

	public void printItems() {
		for (T item : items) {
			System.out.println(item.toString());
		}
	}

	public List<MediaBook> filterByYear(int year) {
		return items.stream()
				.filter(item -> item instanceof Book1 && ((Book1) item).getPublicationYear() == year)
				.collect(Collectors.toList());
	}

	public void sortByTitleOrAuthor() {
		items = (ArrayList<T>) items.stream() 
				.sorted((a, b) -> {
					if (a instanceof Book1 && b instanceof Book1) {
						return ((Book1) a).getTitle().compareTo(((Book1) b).getTitle());
					} else if (a instanceof CDBook && b instanceof CDBook) { 
						return ((CDBook) a).getArtist().compareTo(((CDBook) b).getArtist()); 
					} return 0;
				}) 
		.collect(Collectors.toList()); 
	}
}
	
public class 람다식_스트링 {

	public static void main(String[] args) {

		Library<MediaBook> library = new Library<MediaBook>(); 

		// 5개의 item 객체 초기화 및 추가
		library.addItem(new Book1("자바", "강감찬", 1995, "1234567890"));
		library.addItem(new Book1("파이썬", "이순신", 2008, "1234567891")); 
		library.addItem(new Book1("자바스크립트", "을지문덕", 2008, "1234567892"));
		library.addItem(new Book1("자료구조", "연개소문", 1994, "1234567893")); 
		library.addItem(new Book1("리액트", "김춘추", 1999, "1234567894"));		
		library.addItem(new CDBook("노래1", "나훈아", "3333"));
		library.addItem(new CDBook("노래2", "남진", "2222"));
		library.addItem(new CDBook("노래3", "홍길동", "1111"));
		library.addItem(new USBBook("데이터1", 2000, "ABCD1234"));
		library.addItem(new USBBook("데이터2", 1000, "ABCD1235"));
		library.addItem(new USBBook("데이터3", 3000, "ABCD1235"));
		
		library.printItems();
		System.out.println("=".repeat(80));

		// 출판 연도에 따른 필터링 (예: 2008년도 출판) 
		List<MediaBook> filteredBooks = library.filterByYear(2008); 
		filteredBooks.forEach(System.out::println); 
		
		System.out.println("=".repeat(80));
		
		// 제목 또는 저자 이름에 따른 정렬 
		library.sortByTitleOrAuthor(); 
		library.printItems(); 

	}
}


