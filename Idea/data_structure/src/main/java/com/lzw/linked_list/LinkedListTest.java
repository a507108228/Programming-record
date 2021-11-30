package com.lzw.linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author a5071
 * @since 2021/11/29 10:59
 * description 单链表
 */
public class LinkedListTest{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入3位学生的信息：");
        LinkedList list = new LinkedList();
        for (int i = 0; i < 2; i++) {
            System.out.println("请输入学号：");
            int number = Integer.parseInt(br.readLine());
            System.out.println("请输入姓名：");
            String name = br.readLine();
            System.out.println("请输入成绩：");
            int score = Integer.parseInt(br.readLine());
            list.insert(number, name, score);
        }
        System.out.println("学生成绩：");
        System.out.println("学号==姓名==成绩");
        list.print();
    }
}

class LinkedList{
    private Node first;
    private Node last;

    // 定义判空方法
    public boolean isEmpty(){
        return first == null;
    }

    // 打印方法
    public void print(){
        Node current = first;
        while (current != null) {
            System.out.println("[" + current.num + " " + current.name + " " + current.score + "]");
            current = current.next;
        }
        System.out.println(" ");
    }

    // 插入的方法
    public void insert(int num, String name, int score){
        Node node = new Node(num, name, score);
        if (this.isEmpty()){
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

}


class Node{
    int num;
    String name;
    int score;
    Node next;

    public Node(int num, String name, int score){
        this.num = num;
        this.name = name;
        this.score = score;
        this.next = null;
    }

    @Override
    public String toString(){
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
