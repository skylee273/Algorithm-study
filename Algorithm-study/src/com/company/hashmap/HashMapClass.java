package com.company.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

}
