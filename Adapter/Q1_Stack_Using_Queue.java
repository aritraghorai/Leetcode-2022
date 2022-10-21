package Adapter;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:05/05/2022
 ?Program Details:225. Implement Stack using Queues
 *https://leetcode.com/problems/implement-stack-using-queues/
   */
public class Q1_Stack_Using_Queue {

}


class MyStack {
    LinkedList<Integer> qu;

    public MyStack() {
        qu = new LinkedList<>();
    }

    public void push(int x) {
        qu.offer(x);
    }

    public int pop() {
        LinkedList<Integer> temp = new LinkedList<>();
        while (this.qu.size() > 1) {
            temp.offer(this.qu.poll());
        }
        int tempInt = this.qu.pop();
        this.qu = temp;
        return tempInt;
    }

    public int top() {
        LinkedList<Integer> temp = new LinkedList<>();
        while (this.qu.size() > 1) {
            temp.offer(this.qu.poll());
        }
        int tempInt = this.qu.poll();
        temp.offer(tempInt);
        this.qu = temp;
        return tempInt;
    }

    public boolean empty() {
        return this.qu.size() == 0;
    }

}
