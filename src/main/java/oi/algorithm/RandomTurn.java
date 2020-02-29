package oi.algorithm;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class RandomTurn {

    public static enum Participants {
        p1("민희정"),
        p2("정승훈"),
        p3("김여진"),
        p4("서지희");

        private String name;

        Participants(String name) {
            this.name = name;
        }
    }

    public static enum Assign {
        Assignment1(1, "개념"),
        Assignment2(2, "문제1"),
        Assignment3(3, "문제2"),
        Assignment4(4, "문제3");
        public int num;
        private String assignment;

        Assign(int num, String assignment) {
            this.num = num;
            this.assignment = assignment;
        }
    }

    public static List<Integer> draw(){
        boolean toAssign = true;
        List<Integer> list = new ArrayList<>();

        while(toAssign){
            int num = (int) (Math.random() * 4 + 1);
            if(!list.contains(num)){
                list.add(num);
            }
            if (list.size() == 4) {
                toAssign = false;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        try {
            List<Integer> list = draw();
            List<Integer> part = draw();

            for(int i : list){
                EnumSet.allOf(Assign.class).forEach(assign -> {
                    if(assign.num == i){
                        System.out.println(assign.assignment + " : " + Participants.valueOf("p"+part.get(i-1)).name);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
