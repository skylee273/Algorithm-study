package com.company.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TwoPointersClass {

    private static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        ArrayList<Integer>[] list = new ArrayList[101];
        for(int i = 0; i < 101; i++){
            list[i] = new ArrayList<Integer>();
        }
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i){
            int num = Integer.parseInt(st.nextToken());
            list[num].add(num);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; ++i){
            int num = Integer.parseInt(st.nextToken());
            list[num].add(num);
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < list[i].size(); ++j){
                int answer = list[i].get(j);
                if(answer != 0) System.out.print(answer + " ");
            }
        }
    }

    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            long num = Long.parseLong(st.nextToken());
            list.add(num);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; ++i){
            long num = Long.parseLong(st.nextToken());
            list.add(num);
        }

        Collections.sort(list);

        long current = 0;
        for(long answer : list){
            if(answer == current) {
                System.out.print(answer + " ");
            }
            current = answer;
        }
    }

    // 해설 강의
    private static ArrayList<Integer> solution2 (int n, int m, int [] a, int [] b){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int pos1 = 0, pos2 = 0;

        while(pos1 < n && pos2 < m){
            if(a[pos1] == b[pos2]) {
                answer.add(a[pos1++]);
                pos2++;
            }
            else if(a[pos1] < b[pos2]) pos1++;
            else pos2++;
        }
        return answer;
    }

}
