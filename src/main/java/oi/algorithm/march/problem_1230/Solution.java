package oi.algorithm.march.problem_1230;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;


class Solution
{

    // 암호 collection
    public static class EncryptList {
        public List<String> list = new LinkedList<>();

        public EncryptList() {
        }

        public EncryptList(String[] seed) {
            this.list = new LinkedList<>(Arrays.asList(seed) );
        }

        //추가
        public void add(int index, int many, String[] candidates){
            try {
                this.list.addAll(index, Arrays.asList(candidates) );
            } catch(Exception e) {

            }
        }

        // 삭제
         public void delete(int start, int end) {
            try {
               this.list.subList(start, start+end).clear();
           } catch(Exception e) {

           }
         }

       // 마지막에 추가
        public void addToEnd(String[] candidates) {
           this.list.addAll(this.list.size()-1, Arrays.asList(candidates));
        }


    }


    public static void main(String args[]) throws Exception {
        //	System.setIn(new FileInputStream("res/input.txt"));

        /*
           표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T =10;
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

        EncryptList list = null;
        int originalSourceLength = 0;
        String[] originalSource = {};
        int counter  =0;

        // 원본 암호화된 코드 만들기
       for(int test_case = 1; test_case <= T; test_case++)
        {
            originalSourceLength = sc.nextInt();
            originalSource = new String[originalSourceLength];
            for(int i=0; i<originalSourceLength; i++){
            originalSource[i] = sc.next();
        }

        // 암호 콜렉션 만들기
        list = new EncryptList(originalSource);

        // 암호 수정 시작
        counter = sc.nextInt();
        String ha = ""; // 암호 명령기
        int startIndex = 0; // 시작 인덱스
        int endIndex = 0; // 마지막 인덱스
        String[] candidate = {}; // 명령에 사용될 코드

        for(int k=0; k< counter; k++){
            ha = sc.next();
            startIndex = sc.nextInt();

            if (ha.equals("D")) {
                // 삭제
                 endIndex = sc.nextInt();
                 list.delete(startIndex, endIndex );
            } else if (ha.equals("A")){
                // 마지막에 추가
                  endIndex = startIndex;
                  candidate = new String[endIndex];
                  for(int j = 0; j< endIndex; j++){
                    candidate[j] = sc.next();
                 }
                 list.addToEnd(candidate);
            } else {
                // 추가
                 endIndex = sc.nextInt();
                 candidate = new String[endIndex];
                  for(int j = 0; j< endIndex; j++){
                    candidate[j] = sc.next();
                 }
                 list.add(startIndex, endIndex, candidate);
            }
        }

            // 출력
            System.out.println("#"+test_case +" " + String.join(" ", list.list.subList(0, 10)));
        }
    }
}