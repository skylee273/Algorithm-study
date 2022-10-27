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

        /**
         * list 2차원
         * 1 -> 1
         * 2 - > 2
         * 3 -> 3 3
         *
         * visit[101][1]
         * int visit[3][0]++;
         * visit[1][0] +1
         * visit[3][0] +1 +1 = 2
         */
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

    private static int solution3 (int n, int k, int [] arr){

        int max = Integer.MIN_VALUE;
        // n -> 10, k = 3
        for(int i = 0; i <= n - k; i++) {
            int sum = 0;
            for(int j = 0; j < k; ++j){
                sum += arr[i+j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    private static int solution4 (int n, int m, int [] arr){
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; ++j){
                sum += arr[j];
                if(sum > m) break;
                if(sum == m) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    private static int solution5 (int n) {
        /**
         *                        p1 p1 p1
         *                     p1 p1 p1 p1
         *  15           p1 p1 p1 p1 p1 p1
         *               p0 p0 p0 p0
         *               1  2  3  4  5  6  7
         *  N(15)
         *  sum          1  3  6  10 15
         *  sum2            2  5  9  14 20
         *  sum3               3  7  12 18
         *  sum4                  4  9  15
         *  cnt          1
         *
         *  7 + 8 = 15
         *  4 + 5 + 6 = 15
         *  1 + 2 + 3 + 4 + 5 = 15
         */

        int answer = 0;
        for(int i = 1; i <= n/2; ++i) {
            int sum = 0;
            for(int j = i; j < n; ++j) {
                sum += j;
                if(sum > n) break;
                else if(sum == n) answer++;
            }
        }
        return answer;
    }


    private static int solution6 (int n, int k, int [] arr){
        int max = 0, cnt = 0, p0 = 0;
        for(int p1 = 0; p1 < n; p1++) {
            if(arr[p1] == 0) cnt++;
            while(cnt > k) {
                if(arr[p0] == 0) cnt--;
                p0++;
            }
            max = Math.max(max, p1-p0+1);
        }
        return max;
    }

}
