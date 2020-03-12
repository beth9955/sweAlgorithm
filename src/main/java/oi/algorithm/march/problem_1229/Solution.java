package oi.algorithm.march.problem_1229;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    public static class EncriptList {
    public List<String> list = new LinkedList<>();

    public EncriptList() {}

    public EncriptList(String[] seed) {
        this.list = new LinkedList<>(Arrays.asList(seed) );
    }

    public void add(int index, int many, String[] candidates){
        try {
            this.list.addAll(index, Arrays.asList(candidates) );
        } catch(Exception e) {

        }
    }

     public void delete(int start, int end) {
        try {
           this.list.subList(start, start+end).clear();
       } catch(Exception e) {

       }
    }
}


public static void main(String args[]) throws Exception
{
    //	System.setIn(new FileInputStream("res/input.txt"));

    /*
       표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
     */
    Scanner sc = new Scanner(System.in);
    int T =10;
    /*
       여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    */

    EncriptList list = null;
    int originalSourceLength = 0;
    String[] originalSource = {};
    int counter  =0;
    for(int test_case = 1; test_case <= T; test_case++)
    {
        originalSourceLength = sc.nextInt();
        originalSource = new String[originalSourceLength];
        for(int i=0; i<originalSourceLength; i++){
        originalSource[i] = sc.next();
    }

        list = new EncriptList(originalSource);
        counter = sc.nextInt();
        String ha = "";
        int startIndex = 0;
        int endIndex = 0;
        String[] candidate = {};

        for(int k=0; k< counter; k++){
        ha = sc.next();
        startIndex = sc.nextInt();
        endIndex = sc.nextInt();
        if (ha.equals("D")) {
             list.delete(startIndex, endIndex );
        } else {
             candidate = new String[endIndex];
              for(int j = 0; j< endIndex; j++){
            	candidate[j] = sc.next();
       		 }
       		 list.add(startIndex, endIndex, candidate);
        }
    }
        System.out.println("#"+test_case +" " + String.join(" ", list.list.subList(0, 10)));
    }
}
}