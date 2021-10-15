package com.lzw.linked_list;


import jdk.nashorn.internal.objects.NativeError;

import java.util.Stack;

/**
 * @author: a5071
 * @date: 2021/9/14 18:22
 * @description: 单链表
 */
public class SingleList{
    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1, "张玉", "First love");
        HeroNode hero2 = new HeroNode(2, "周祥涛", "Friend");
        HeroNode hero3 = new HeroNode(3, "曹聚", "Idiot");
        HeroNode hero4 = new HeroNode(4, "叶玉稳", "Female friend");
        HeroNode hero5 = new HeroNode(5, "岩心及", "My son");

        SingleLinkedList list = new SingleLinkedList();
        // 按照给定的顺序添加
        // list.add(hero1);
        // list.add(hero2);
        // list.add(hero3);
        // list.add(hero4);


        // 按照编号添加
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.addByOrder(hero5);

        // 测试修改节点的代码
        // HeroNode node = new HeroNode(2, "周祥涛", "Best friend");
        // HeroNode node1 = new HeroNode(3, "曹聚", "the most famous idiot");
        // list.update(node);
        // list.update(node1);

        // 删除节点
        // list.delete(1);

        list.list();

        // 面试题测试一
        System.out.println("有效节点个数： " + getLength(list.getHead()));

        // 面试题测试二
        HeroNode res = findLastIndexNode(list.getHead(), 5);
        System.out.println("res: " + res);

        // 面试题测试三
        System.out.println("反转之后的链表");
        reverseList(list.getHead());
        list.list();

        // 面试题测试四
        System.out.println("逆序打印之后的链表");
        reversePrint(list.getHead());
    }

    /**
     * @author: a5071
     * @description: 面试题四：逆序打印单链表
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }


    /**
     * @author: a5071
     * @description: 面试题三：单链表的反转
     */
    public static void reverseList(HeroNode head){
        // 如果链表为空 或者链表只有一个节点
        if (head.next == null || head.next.next == null){
            return;
        }
        // 遍历原来的链表
        HeroNode cur = head.next;
        // 指向 cur节点的下一个节点 相当于最开始的head.next.next
        HeroNode next = null;
        // 遍历原来的链表 将原链表的数据放在reverse链表中
        HeroNode reveser = new HeroNode(0, "", "");
        while (cur != null){
            next = cur.next; // 保存当前节点的下一个节点
            cur.next = reveser.next; // 将cur的下一个节点指向新的链表的最前端
            reveser.next = cur; // 将cur链接到新链表中
            cur = next; // cur 后移
        }
        // 将head.next指向reverse.next
        head.next = reveser.next;
    }

    /**
     * @author: a5071
     * @description: 面试题二: 查找单链表倒数第k个节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        // 判断链表是否为空
        if (head.next == null) {
            return null;
        }
        // 获取链表有效个数
        int size = getLength(head);
        // 判断想要查找的值是否有效
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * @author: a5071
     * @description: 面试题一：获取有效节点个数（去掉头节点
     */
    public static int getLength(HeroNode head){
        // 空链表
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }


}

class SingleLinkedList{
    // 初始化头节点 不能更改
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead(){
        return head;
    }


    /**
     * @author: a5071
     * @description: 添加节点   到单链表： 原链表的尾部next指向新的head节点
     * （没有考虑编号 输出内容按照添加顺序输出）
     */
    public void add(HeroNode heroNode){
        // 因为头节点不能动，需要一个空temp辅助遍历
        HeroNode temp = head;
        // 遍历链表 找到最后的next
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    /**
     * @author: a5071
     * @description: 有编号的单链 类似插入链表 next-->插入的head| next -->下一个head
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        // 插入的编号是否存在
        boolean flag = false;
        while (true) {
            // 说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 位置找到 就在temp后面插入
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * @author: a5071
     * @description: 修改链表
     */
    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHeroNode.no);
        }
    }


    /**
     * @author: a5071
     * @description: 删除链表
     */
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到要删除的节点%d\n", no);
        }
    }

    /**
     * @author: a5071
     * @description: 遍历链表
     */
    public void list(){
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 头节点需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 将next后移
            temp = temp.next;
        }
    }

}


// 每一个HeroNode就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString(){
        // 不能带上next 否则会把内容都输出出来
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}