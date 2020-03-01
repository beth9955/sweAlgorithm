package oi.algorithm;

import oi.algorithm.march.March5th;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {

    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\hjmin\\Downloads\\input.txt"), StandardCharsets.UTF_8));
        ) {

            /** SW Expert Academy 3월 5일 **/
            March5th march5th = new March5th(br);
            march5th.no1228();
            //1291

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
