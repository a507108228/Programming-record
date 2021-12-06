package com.lzw.shiyan_05;


import java.util.ArrayList;

public class Test{

    public static void main(String[] args){

        Book zBook = new Book("Python进阶", 35.5, 5);
        Book aBook = new Book("JAVA导论", 37.5, 1);
        Book bBook = new Book("C#秘笈", 41.7, 3);
        Book cBook = new Book("软件构造", 29.8, 3);

        Student s = new Student();

        ArrayList<Rental> rentList = new ArrayList<Rental>(10);

        Rental r1 = new Rental(aBook, 45, s);
        Rental r2 = new Rental(bBook, 38, s);
        Rental r3 = new Rental(cBook, 28, s);
        Rental r4 = new Rental(zBook, 12, s);

        rentList.add(r1);
        rentList.add(r2);
        rentList.add(r3);
        rentList.add(r4);

        s.setRentals(rentList);

        s.setName("小明");

        test_case_one(s);
    }

    private static void test_case_one(Student student){

        System.out.println(student.returnedMessage());
    }
}
