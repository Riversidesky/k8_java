package home1_1;



import java.util.ArrayList;
import java.util.Arrays;

class Book implements Comparable<Book>{

	private String title;

	private String author;

	private int publicationYear;

	private String isbn;
	
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}
	
	public String getISBN() {
		return isbn;
	}
	
	@Override
	
	public String toString() {
		return "title="+title+", author="+author+", publicationYear="+publicationYear+", isbn="+isbn;
	}

	@Override
	public int compareTo(Book o) { // ??????????
		Book other = (Book) o;
		return this.title.compareTo(other.title); // 같으면 0 this.title이 크면 양수 작으면 음수
	}

}



// Library 클래스

class Library {

	private ArrayList<Book> books;
	public Library() {
		books = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void sortBooksByTitle() { 
		books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}

	public Book searchBookByTitle(String title) {
		for(int i = 0; i < books.size(); i++) {
//			if(books.get(i).getTitle().equals(title)) {
			if (books.get(i).getTitle().compareTo(title) == 0) {
				return books.get(i);
			}
		}
//        for (Book book : books) {
//        	 if (book.getTitle().equals(title)) {
//                return book;
//            }
//        }
        return null;
    }
	
	public void sortBooksByISBN() {
		books.sort((b1, b2) -> Integer.compare(Integer.parseInt(b1.getISBN()), Integer.parseInt(b2.getISBN())));
		
	}
	
	public void printBooks(String msg) {
		System.out.println(msg + " 도서숫자 = " + books.size());
		for(int i =0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
		
	}
}



public class 실습10_컬렉션API_과제 {

	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화

		// 5개의 책 객체 초기화

		Book book1 = new Book("자바", "강감찬", 1995, "12");

		Book book2 = new Book("파이썬", "이순신", 2008, "9");

		Book book3 = new Book("자바스크립트", "을지문덕", 2008, "8");

		Book book4 = new Book("자료구조", "연개소문", 1994, "45");

		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 책 추가

		library.addBook(book1);

		library.addBook(book2);

		library.addBook(book3);

		library.addBook(book4);

		library.addBook(book5);

		// 도서 목록 출력

		library.printBooks("\n제목정렬전");

		// 도서 목록 정렬

		library.sortBooksByTitle();

		// 정렬된 도서 목록 출력

		library.printBooks("\n제목정렬후");

		// 특정 제목으로 도서 검색

		library.printBooks("\nISBN정렬전");

		// 도서 목록 정렬

		library.sortBooksByISBN();

		// 정렬된 도서 목록 출력

		library.printBooks("\nISBN정렬후");

		// 특정 제목으로 도서 검색

		String searchTitle = "자바";

		Book foundBook = library.searchBookByTitle(searchTitle);

		if (foundBook == null)

			System.out.println("\n자바 책이 없다");

		else

			System.out.println("\n도서명으로 검색한 도서\n" + foundBook.toString());

	}

}
