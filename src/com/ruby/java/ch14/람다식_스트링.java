package com.ruby.java.ch14;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface MediaBook {
	String getMediaType();
}
class Library<T extends MediaBook> {
	private ArrayList<T> items; 
	private int capacity;
	public void sortItems() {
		items.sort((a, b) -> {
			if (a instanceof Book && b instanceof Book) {
				return ((Book) a).getPublicationYear() - ((Book) b).getPublicationYear(); 
			} else if (a instanceof CD && b instanceof CD) {
				return ((CD) a).getCatalogNumber().compareTo(((CD) b).getCatalogNumber()); 
			} else if (a instanceof USB && b instanceof USB) { 
				return Integer.compare(((USB) a).getCapacityGB(), ((USB) b).getCapacityGB()); 
			}
			return 0; 
		});
	}

	public List<T> filterByYear(int year) {	 // 출판 연도에 따른 필터링
		return items.stream()
					.filter(item -> item instanceof Book && ((Book) item).getPublicationYear() == year)
					.collect(Collectors.toList());
	} 
	public void sortByTitleOrAuthor() { 		 // 제목 또는 저자 이름에 따른 정렬
		items = items.stream() 
				.sorted((a, b) -> {
					if (a instanceof Book && b instanceof Book) {
						return ((Book) a).getTitle().compareTo(((Book) b).getTitle());
					} else if (a instanceof CD && b instanceof CD) { 
						return ((CD) a).getArtist().compareTo(((CD) b).getArtist()); 
					} return 0;
				}) 
		.collect(Collectors.toList()); 
		}
	}


public class 람다식_스트링 {
	public static void main(String[] args) {
		// 출판 연도에 따른 필터링 (예: 2008년도 출판) 
		List<MediaBook> filteredBooks = library.filterByYear(2008); 
		filteredBooks.forEach(System.out::println); 

		// 제목 또는 저자 이름에 따른 정렬 
		library.sortByTitleOrAuthor(); 
		library.printItems(); 
	}
}

}
