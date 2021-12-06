package com.lzw.shiyan_05;

import java.util.ArrayList;


public class Student {

	private String name;
	private int bonus = 0;
	private ArrayList<Rental> rentals = new ArrayList<Rental>(10);

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public ArrayList<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(ArrayList<Rental> rentals) {
		this.rentals = rentals;
	}



	public void addBonus(int reward){
		bonus += reward;
	}


	public String returnedMessage() {
		double totalAmount = 0;
		double finedAmount = 0;
		int bonus = 0;
		String message = new String();
		for (Rental aRental : rentals) {
			bonus = 0;
			finedAmount = 0;
			switch (aRental.getBook().getCategory()) {
				case Book.TEXT_BOOK:
					if (aRental.getDaysRented() > 30) {
						finedAmount += (aRental.getDaysRented() - 30) * aRental.getBook().getPrice() * 0.001;
						finedAmount += 1;
					} else {
						bonus = 1;
					}
					break;
				case Book.REFERENCE:
					if (aRental.getDaysRented() > 30) {
						finedAmount += (aRental.getDaysRented() - 30) * aRental.getBook().getPrice() * 0.005;
						finedAmount += 1.5;
					} else {
						bonus = 2;
					}
					break;
				case Book.NEW_BOOK:
					if (aRental.getDaysRented() > 30) {
						finedAmount += (aRental.getDaysRented() - 30) * aRental.getBook().getPrice() * 0.01;
						finedAmount += 3;
					} else {
						bonus = 3;
					}
					break;
			}
			addBonus(bonus);
			totalAmount += finedAmount;
			while(getBonus() >= 7 && totalAmount > 1) {
				addBonus(-7);
				totalAmount--;
			}
			message += aRental+"\n";
		}

		message += String.format("缴纳罚金：%.2f元.\n", totalAmount);
		message += "还书奖励："+getBonus()+"点.\n";
		return message;
	}
}

class Book {
	public final static int TEXT_BOOK = 1;
	public final static int REFERENCE = 3;
	public final static int NEW_BOOK = 5;
	private String title;
	private double price;
	private int category = NEW_BOOK;


	public Book(String title,double price,int category){
		this.title = title;
		this.price =  price;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}

class Rental {
	private Book book;
	private int daysRented = 30;
	private Student borrower;


	public Rental(Book book,int daysRented,Student borrower) {
		this.book = book;
		this.daysRented = daysRented;
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	public Student getBorrower() {
		return borrower;
	}

	public void setBorrower(Student borrower) {
		this.borrower = borrower;
	}

	public String toString() {
		String type = new String();
		switch (book.getCategory()) {
			case Book.TEXT_BOOK:
				type = new String("教材");
				break;
			case Book.REFERENCE:
				type = new String("参考书");
				break;
			case Book.NEW_BOOK:
				type = new String("新书");
				break;
		}
		return type + book.getTitle() + "借阅了" + daysRented + "天。";
	}
}