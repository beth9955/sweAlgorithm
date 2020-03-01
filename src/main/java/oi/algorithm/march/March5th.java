package oi.algorithm.march;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class March5th {
    private BufferedReader br;

    public March5th(BufferedReader br) {
        this.br = br;
    }

    /**
     * SW Expert Academy 1228번
     * @throws Exception
     */
    public void no1228 () throws Exception{
        try {
            for (int i = 0; i < 10; i++) {

                /** 문제읽기 **/
                int inital = Integer.parseInt(br.readLine());
                Stream<String> stream = Stream.of(br.readLine().split(" "));
                int commands = Integer.parseInt(br.readLine());
                List<String> commandList = Arrays.asList(br.readLine().split("I "));

                /** 문제의 암호화 **/
                List<String> result = stream.collect(Collectors.toList()); //Arrays.asList하면 addAll이 exception
                for (int j = 1; j <= commands; j++) {
                    result = encrypt(result, commandList.get(j).trim());
                }

                /** 답 프린트 **/
                System.out.printf("#%d", i+1);
                for(int n=0; n < 10; n++){
                    System.out.print(" " + result.get(n));
                }
                System.out.println();

            }
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * SW Expert Academy 1228번
     * @throws Exception
     */
    public static List<String> encrypt(List<String> result, String commands) throws Exception {
        try {
            List<String> list = Arrays.asList(commands.split(" "));
            int pos = Integer.parseInt(list.get(0));
            int count = Integer.parseInt(list.get(1));
            int max = count + 2;

            List<String> temp = new ArrayList<>();
            for (int i = 2; i < max; i++) {
                temp.add(list.get(i));
            }

            result.addAll(pos, temp);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    /**
     * SW Expert Academy 1229번
     * @throws Exception
     */
    public void no1229 () throws Exception{
        try {

        } catch (Exception e){

        }
    }

    /**
     * SW Expert Academy 1230번
     * @throws Exception
     */
    public void no1230 () throws Exception{
        try {

        } catch (Exception e){

        }
    }


}
