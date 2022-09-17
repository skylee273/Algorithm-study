package com.company.string;

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


    private static String solution5(String str){

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

    private static String solution6(String x){

        // IDEA : 우선 소문자는 25개이니깐 배열 25개
        // 소문자가 나오면 해당 배열에 값을 저장하고 true로 바꿈

        // 풀이에서는 indexOf 사용했음
        // str.indexOf(str.charAt(i) == i) answer += str.chaAt(i);

        // 석현 -> contains -
        StringBuilder answer = new StringBuilder();

        boolean[] alphabet = new boolean[25];

        for(Character c : x.toCharArray()){
            int index = c - 'a';
            if(!alphabet[index]){
                answer.append(c);
                alphabet[index] = true;
            }

        }
        return answer.toString();
    }

    private static Boolean solution7(String x){

        // IDEA :  우선 전체 대문자나, 소문자로 만들자
        // -> left, right left 가 right보다 커지거나, 둘이 같을 떄까지 비교한다.
        // 해설 -> 좀더 빠른 방법인듯 다 비교 안하고 반으로 잘라서 처음 끝 비교하면서 한번이라도 틀리면 no
        // 문법 이용하는 법 -> Strinbuilder reverse -> 둘이 equals 해서 같으면 TES
        int left = 0;
        int right = x.length()-1;
        boolean success = true;
        char [] array = x.toCharArray();
        while(left < right){
            if(array[left] != array[right]) {
                success = false;
                left = right;
            }else{
                left++;
                right--;
            }
        }

        return success;
    }

    private static boolean isNumberOrLetter(int ascii){
        if(ascii >= 48 && ascii <= 57) return true;
        if(ascii >= 65 && ascii <= 90) return true;
        if(ascii >= 97 && ascii <= 122) return true;
        return false;
    }

    private static Boolean solution8(String x){

        // IDEA :  우선 전체 대문자나, 소문자로 만들자
        // -> left, right left 가 right보다 커지거나, 둘이 같을 떄까지 비교한다.

        // -> 숫자가 있으면 isLetter 안됨 숫자를 포함할수 있는 아스키코드표로..하자
        // 해설 -> 정규식 사용 -> replaceAll("[^A-Z]", "")

        // 석현 -> 문자 받고 -> 대문자 또는 소문자 -> compare a, b isLeetter앞, 뒤
        // -> Strinbuilder -> reverse -> equals -> 그럼 맞는지 바로
        int left = 0;
        int right = x.length()-1;
        boolean success = true;
        char [] array = x.toCharArray();


        while(left < right){

            if(!isNumberOrLetter(array[left])) {
                left++;
                continue;
            }
            if(!isNumberOrLetter(array[right])) {
                right--;
                continue;
            }

            if(array[left] != array[right]) {
                success = false;
                left = right;
            }else{
                left++;
                right--;
            }
        }

        return success;
    }

    private static Integer solution9(int n, String x){

        //해설 Character.isDigit(x) -> 숫자만 확인하는게 있었다.
        StringBuilder answer = new StringBuilder();

        for(Character c : x.toCharArray()){
            if(c >= 48 && c <= 57) answer.append(c);
        }
        return Integer.parseInt(answer.toString());
    }

    private static int [] solution10(String s, char t){

        // IDEA : e가 나올때까지 left 길이 증가
        // e가 나오면 left 길이 저장
        // e위치를 기억 -> 다음 e가 나올때까지 e 위치와 길이 체크
        // 다음 e가 나오면 left와 right 비교


         /*    0 1 2 3 4 5 6 7 8 9 10
            t e a c h e r m o d e d f
            1 0 1 2 1 0 1 2 2 1
    pos     0 1 0 0 0 1 0 0 0 0 1 0 0
    left    1 0 1 2 3 0 1 2 3 4 0 1 2
    right   1 0 3 2 1 0 4 3 2 1 0  1001
    */

        // 석현 ->  for 2중 -> e나올떄마다 -> abs 최소값 갱신

        int value = 1000;
        int [] result = new int [s.length()];

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t) {
                value = 0;
                result[i] = value;
            }
            else{
                value++;
                result[i] = value;
            }
        }

        value = 1000;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == t) value = 0;
            else{
                value++;
                result[i] = Math.min(result[i], value);
            }
        }


        return result;
    }


    private static String solution11(String s){

        // 맨처음 문자 기억
        StringBuilder answer = new StringBuilder();
        char startLetter = s.charAt(0);
        int count = 0;
        for(char c : s.toCharArray()){
            if(startLetter == c) count++;
            else {
                answer.append(startLetter);
                if(count != 1) {
                    answer.append(count);
                }
                count = 1;
                startLetter = c;
            }
        }
        if(s.charAt(s.length()-1) == startLetter) {
            answer.append(startLetter);
            if(count != 1) {
                answer.append(count);
            }
        }
        return answer.toString();
    }
    private static String solution12(int n, String x){

        // IDEA : 7개씩 끊자
        // [4][7] 2차원 배열 만들자
        // 2 차원 배열 1행  -> 7개 숫자 -> 1의 자리수는 그냥 1인지 체크후  + 1
        // 다음부터 1이면 *2



        int[][] asciiArray = new int[n][7];
        char[] origin = x.toCharArray();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; ++j){
                if(origin[i*7 + j] == '#') asciiArray[i][j] = 1;
                else asciiArray[i][j] = 0;
            }
        }

        StringBuilder answer = new StringBuilder();

        int two = 1;
        int ans = 0;
        for(int i = 0; i < n; ++i){
            if(asciiArray[i][6] == 1) {
                ans += 1;
            }
            for(int j = 5; j >= 0; --j){
                two *= 2;
                if(asciiArray[i][j] == 1) {
                    ans += (two * asciiArray[i][j]);
                }
            }
            answer.append((char) ans);
            two = 1;
            ans = 0;
        }


        return answer.toString();
    }
}
