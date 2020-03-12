package oi.algorithm.march.problem_1240;

import java.util.Scanner;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static class Descrytor {
        public Map<String, Number> decryptor;
        public  Descrytor() {
            this.decryptor = new HashMap<>();
            decryptor.put("0100011", 4);
            decryptor.put("0101111", 6);
            decryptor.put("0110001", 5);
            decryptor.put("0110111", 8);
            decryptor.put("0111011", 7);
            decryptor.put("0111101", 3);
            decryptor.put("0010011", 2);
            decryptor.put("0011001", 1);
            decryptor.put("0001011", 9);
            decryptor.put("0001101", 0);
        }


    }
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        Descrytor descrytor = new Descrytor();

        // 암호 추출

        int first1Index = 0;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int lines = sc.nextInt();
            int codeCount = sc.nextInt();
            String originalText = "";

            for(int i=0; i<lines; i++) {
                String text = sc.nextLine();
                int findIndex = text.indexOf("1");
                if (findIndex < 0 ){
                    continue;
                } else {
                    if (originalText.length() > 0) {
                        continue;
                    }
                    originalText = text;
                    first1Index  = findIndex;

                }
            }


            // 첫번째 1의 인덱스
            int startIndex = 0;
            for(int i=1; i<=3; i++) {
                startIndex = first1Index- i;
                String candidate = originalText.substring(startIndex, startIndex+7);
                if(descrytor.decryptor.get(candidate) != null){
                    break;
                }
            }


            // 첫번째 숫자를 찾고 그다음 8개씩 잘라서 암호 추출
            int total = 0;
            int oddTotal = 0;
            for (int i=0; i<8; i++) {
                int eachStartIndex = startIndex+(7*i);
                String candidate = originalText.substring(eachStartIndex, eachStartIndex+7);
                int num = descrytor.decryptor.get(candidate).intValue();
                if (i % 2 ==0) {
                    total += num;
                } else {
                    oddTotal += num;
                }

            }
            if (((total*3) + oddTotal) % 10 == 0) {
                System.out.println("#"+test_case+" " + (total+oddTotal));
            } else {
                System.out.println("#"+test_case+" 0");
            }
            sc.next();
        }
    }
}