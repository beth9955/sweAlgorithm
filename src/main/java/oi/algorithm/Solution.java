package oi.algorithm;

import oi.algorithm.march.March5th;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {

    public static void main(String[] args) {
        String file = "";
//        file = "C:\\Users\\hjmin\\Downloads\\input1228.txt";
//        file = "C:\\Users\\hjmin\\Downloads\\input1229.txt";
        file = "C:\\Users\\hjmin\\Downloads\\input1230.txt";

        try (
                BufferedReader br = new BufferedReader
                                        (new InputStreamReader
                                            (new FileInputStream(file), StandardCharsets.UTF_8));
        ) {

            /** SW Expert Academy 3월 5일 **/
            March5th march5th = new March5th(br);
//            march5th.no1228();
//            march5th.no1229();
            march5th.no1230();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
