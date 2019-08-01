package com.code.offer.offer7;

import java.util.Stack;

public class Offer7<E> {

    /*
     * 用两个栈实现队列
     */
    public static void main(String[] args) {

        Offer7<Integer> test = new Offer7<>();

        test.appendTail(1);
        test.appendTail(2);
        test.appendTail(3);
        test.appendTail(4);
        test.appendTail(5);

        test.deleteHead();
        test.deleteHead();

        test.appendTail(10);

        System.out.println();
        test.print();
    }

    private Stack<E> push = new Stack<>();
    private Stack<E> pop = new Stack<>();

    //尾部添加元素
    private synchronized void appendTail(E e) {
        System.out.print(e.toString() + ",");
        push.push(e);
    }

    //移除头部
    private synchronized E deleteHead() {
        System.out.print("_< ");
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        while (!pop.isEmpty()) {
            sb.append(pop.pop()).append(",");
        }

        while (!push.isEmpty()) {
            pop.push(push.pop());
        }

        while (!pop.isEmpty()) {
            sb.append(pop.pop()).append(",");
        }

        System.out.println("print >> " + sb.toString());

    }
}
