package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Hanoi {
    ArrayList<Stack<Integer>> rods = new ArrayList<Stack<Integer>>();
    int absHeight;

    Hanoi() {
        absHeight = 8;
        makeHanoi();
        print();
        solution(8,0,1,2);
    }

    Hanoi(int amount) {
        absHeight = amount;
        makeHanoi();
        print();
        solution(amount,0,1,2);
    }

    Hanoi(Hanoi hanoi) {
        absHeight = hanoi.absHeight;
        for (Stack<Integer> rod:hanoi.rods
             ) {
            rods.add((Stack<Integer>)rod.clone());
        }

    }

    private void makeHanoi() {
        rods.add(new Stack<Integer>());
        rods.add(new Stack<Integer>());
        rods.add(new Stack<Integer>());
        for (int i = 0; i < absHeight; i++) {
            rods.get(0).push(absHeight - i);
        }
    }

    void print() {
        Hanoi buf = new Hanoi(this);
        String exitStr;
        for (int i = 0; i < absHeight; i++) {
            exitStr = "";
            if(buf.rods.get(0).size() == absHeight-i){
                exitStr += buf.rods.get(0).pop();
            }
            else exitStr += " ";
            exitStr += "    ";
            if(buf.rods.get(1).size() == absHeight-i){
                exitStr += buf.rods.get(1).pop();
            }
            else exitStr += " ";
            exitStr += "    ";
            if(buf.rods.get(2).size() == absHeight-i){
                exitStr += buf.rods.get(2).pop();
            }
            else exitStr += " ";
            System.out.println(exitStr);
        }
        System.out.println();
    }

    void move(int from, int to){
        rods.get(to).push(rods.get(from).pop());
        print();
    }

    boolean isCompleted(){
        return rods.get(2).size() == absHeight;
    }

    void solution(int n, int from, int mid, int to){
        if(n==1){
            move(from,to);
            return;
        }
        solution(n-1,from,to,mid);
        move(from,to);
        solution(n-1,mid,from,to);
    }


}
