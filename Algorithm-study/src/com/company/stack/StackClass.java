package com.company.stack;

import java.util.Stack;

public class StackClass {

    private static String  solution1(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(c == '(') stack.push(c);
            if(c == ')') {
                if(stack.empty()) return "NO";
                Character peek = stack.peek();
                if(peek != '(') return "NO";
                else stack.pop();
            }
        }
        if(!stack.empty()) return "NO";
        return "YES";
    }


    private static String  solution2(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c != ')') stack.push(c);
            if(c == ')') {
                Character peek = stack.peek();
                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        while(!stack.empty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    static Stack<Integer> basket = new Stack<>();
    private static int  solution3(int n, int [][] board, int m, int [] moves) {
        int answer = 0;
        for(int k = 0; k < m; ++k) {
            int number = moves[k];
            for (int i = 0; i < n; ++i) {
                int doll = board[i][number - 1];
                if(doll != 0){
                    if(basket.empty()) {
                        basket.push(doll);
                        board[i][number-1] = 0;
                        break;
                    }
                    if(basket.peek() != doll) basket.push(doll);
                    else{
                        answer += boomDollCnt(doll);
                    }
                    board[i][number-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    // 같은 숫자가 나왔을떄를 전제로 한다.
    private static int boomDollCnt(int doll) {
        int answer = 1;
        while(doll == basket.peek()) {
            basket.pop();
            answer++;
        }
        return answer;
    }


    private static int  solution4(String s) {

        Stack<Integer> st = new Stack<>();

        for (Character c : s.toCharArray()) {
            if(Character.isDigit(c)) st.push(Integer.valueOf(c.toString()));
            else{
                int val1 = st.pop();
                int val2 = st.pop();
                int result = 0;
                if(c == '+') result = val2 + val1;
                else if(c == '-') result = val2 - val1;
                else if(c == '*') result = val2 * val1;
                else result = val2 / val1;
                st.push(result);
            }
        }

        return st.pop();
    }

    private static final Character OPEN = '(';
    private static final Character CLOSE = ')';
    private static int  solution5(String s) {


        //  ()(((()())(())()))(())

        /**
         *     (()())
         *
         *
         *      3 + 4 + 4 + 3 + 2 + 3 + 2 + 2 + 1 + 0 + 1 + 1 + 0
         *
         */
        Stack<Character> stack = new Stack<>();

        // 3 + 3 + 2 + 3 + 2 + 2 + 1 + 0 + 1
        int answer = 0;

        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); ++i){
            if(chars[i] == OPEN) stack.push(chars[i]);
            else{
                if(chars[i-1] == CLOSE)  {
                    answer += 1;
                    stack.pop();
                }else{
                    stack.pop();
                    answer += stack.size();
                }
            }
        }
        return answer;
    }


}
