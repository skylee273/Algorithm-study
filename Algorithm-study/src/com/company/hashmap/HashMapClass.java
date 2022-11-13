package com.company.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HashMapClass {

    private static int solution1 (int n, int []arr) {
        /**
         *  hashMap Or 아스키
         */
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 5; ++i) {
            if(max < arr[i]) {
                answer = i;
                max = arr[i];
            }
        }
        return answer;
    }

    private static Character solution1_1(Map<Character, Integer> map){
        Character answer = null;
        int max = Integer.MIN_VALUE;
        Character [] characters = {'A', 'B', 'C', 'D', 'E'};
        for(int i = 0; i < map.size(); ++i) {
            Integer cnt = map.getOrDefault(characters[i], 0);
            if(max < cnt) {
                max = cnt;
                answer = characters[i];
            }
        }
        return answer;
    }

    public static void main_1(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String paper = st.nextToken();
        Map<Character, Integer> student = new HashMap<>();
        for(char c : paper.toCharArray()){
            student.put(c, student.getOrDefault(c, 0) + 1);
        }
        System.out.println(solution1_1(student));

        return;
    }

    private static String solution2(Map<Character, Integer> map1, Map<Character, Integer> map2){

        for(Character c : map1.keySet()) {
            Integer cnt1 = map1.get(c);
            Integer cnt2 = map2.getOrDefault(c, 0);
            if(!cnt1.equals(cnt2)) return "NO";
        }

        return "YES";
    }

    private static String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main_2(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String str2 = st.nextToken();
        Map<Character, Integer> anaGramMap1 = new HashMap<>();
        Map<Character, Integer> anaGramMap2 = new HashMap<>();
        for(Character c1 : str1.toCharArray()){
            anaGramMap1.put(c1,anaGramMap1.getOrDefault(c1, 0) + 1);
        }
        for(Character c2 : str2.toCharArray()){
            anaGramMap2.put(c2,anaGramMap2.getOrDefault(c2, 0) + 1);
        }
        System.out.println(solution2(anaGramMap1, anaGramMap2));

        return;
    }

    private static String solution3(int n, int k, int[] arr) {

        /**
         *
         * p0     p0
         * p1
         *                 p1
         *        20 12 20 10 23 17 10
         *        0  1  2  3
         *  map(20) -> 2 , map(12) -> 1, map(10) -> 1 => size 3
         */

        final String BLANK = " ";
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k-1; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int p0 = 0;
        for(int j = k-1; j < n; ++j) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            answer.append(map.size()).append(BLANK);
            map.put(arr[p0], map.get(arr[p0])- 1);
            if(map.get(arr[p0]) == 0) map.remove(arr[p0]);
            p0++;

        }
        return answer.toString();
    }

    public static void main3(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution3(N,K, arr));

        return;
    }

    private static int solution4(String s1, String s2) {

        int answer = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(Character c : s2.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s2.length()-1; ++i) {
            sMap.put(s1.charAt(i), sMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int p0 = 0;
        for(int j = s2.length()-1; j < s1.length(); ++j) {
            int cnt = 0;
            sMap.put(s1.charAt(j), sMap.getOrDefault(s1.charAt(j), 0) + 1);
            //비교
            for(Character c : tMap.keySet()) {
                if(sMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))) cnt++;
            }
            if(cnt == sMap.size()) answer++;
            sMap.put(s1.charAt(p0), sMap.get(s1.charAt(p0))- 1);
            if(sMap.get(s1.charAt(p0)) == 0) sMap.remove(s1.charAt(p0));
            p0++;
        }
        return answer;
    }

    private static int solution5(int n, int k, int [] arr) {

        /**
         * 0   1  2  3 4  5  6  7       8  9
         * 11 13 15 23 27 33 34 42  || 45 65
         *                33
         * n -k = 7 - 3 = 4
         */
        Arrays.sort(arr);
        int answer = 0;
        for(int i = n-1; i > n-k; --i) {
            answer += arr[i];
        }
        if(n - k - k + 1  < 0) return -1;
        answer += arr[n - 2 * k + 1];
        /*int p0 = n-k;
        while(k > 0) {
            answer += arr[p0--];
            k--;
        }*/
        return answer;
    }

    private static int solution5_1(int n, int k, int [] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; ++i) {
            for(int j = i+1; j < n; ++j){
                for(int l = j+1; l < n; l++){
                    treeSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (int x : treeSet) {
            cnt ++;
            if(cnt == k) return x;
        }
        return -1;
    }




}
