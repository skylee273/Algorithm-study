package com.company.string.lhn;

import java.util.ArrayList;
import java.util.Locale;

public class StringClass {

    //string branch
    public  static int solution1(String str, char c){
        int cnt = 0;
        for(Character s : str.toLowerCase(Locale.ROOT).toCharArray()){
            if(c == s) cnt++;
        }
        return cnt;
    }

    public static String solution2(String str){
        // TODO : 대문자 -> 소문자 , 소문자 -> 대문자
        // 1. 아스키 코드를 이용
        // 2. 바꿔주는 먼가 함수가 있을거 같다. => Character
        StringBuilder answer = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)) answer.append(Character.toUpperCase(c));
            else answer.append(Character.toLowerCase(c));
        }
        return answer.toString();
    }

    public static String solution3(String str){
        // TODO : 한개의 문장에서 가장 긴 단어를 출력해라.
        // IDEA 1 : split 빈칸으로 자르고 -> 배열 -> 가장긴거 출력
        /*  해설 솔루션
            띄어쓰기 -> split
            가장작은 수 -> Integer.MIN_VALUE
            indexOf, subString 활용 -> ' ' 띄어쓰기를 이용해 pos 찾고, subString str 가져옴
            while((pos = str.indexOf(' ')) != -1)
            but 마지막 문자 처리 해야함
         */
        int maxLength = 0;
        String answer = "";
        String [] array = str.split(" ");
        for(String x : array){
            if(x.length() > maxLength) {
                answer = x;
                maxLength = x.length();
            }
        }
        return answer;
    }
    public static ArrayList<String> solution4(String [] str){
        // TODO : N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하라.
        // IDEA 1 : StringBuilder -> reverse 가능
        // 못푼점 :  while(n >= 0 ) n-- 이렇게 푸니깐 Runtime 결국 한번더 돌기 떄문에 메모리를 더 사용하는거 같음 for-> 바꾸니깐 해결
        /**
         *   for(int i = 0; i < n; i++){
         *            String ans = new StringBuilder(in.next()).reverse().toString();
         *             System.out.println(ans);
         *   }
         */

        // 강의해설 : StringBuilder 쓰는건 같음 ArrayList 추가로사용
        // 두번쨰 -> reverse 직접 구현 lt , tr 이용

        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String temp = new StringBuilder(x).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }


    private static String solution(String str){

        // IDEA : 특수문자 비교 -> Character.isLetter로 확인

        char[] c = str.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {

            if(!Character.isLetter(c[start])) start++;
            if(!Character.isLetter(c[end])) end--;

            if (Character.isLetter(c[start]) && Character.isLetter(c[end])) {
                char tmp = c[start];
                c[start] = c[end];
                c[end] = tmp;
                start++;
                end--;
            }

        }
        return String.valueOf(c);
    }
}
