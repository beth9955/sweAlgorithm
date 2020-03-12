
package oi.algorithm.march.problem_1228;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

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
   }


	public static void main(String args[]) throws Exception
	{
	    //	System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10;
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
                candidate = new String[endIndex];
                for(int j = 0; j< endIndex; j++){
                    candidate[j] = sc.next();
                }
                list.add(startIndex, endIndex, candidate);
            }
            System.out.println("#"+test_case +" " + String.join(" ", list.list.subList(0, 10)));
		}
	}
}