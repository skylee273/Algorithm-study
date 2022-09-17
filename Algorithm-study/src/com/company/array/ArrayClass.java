package com.company.array;

import java.util.ArrayList;
import java.util.Locale;

public class ArrayClass {
    private static ArrayList<Integer> solution1(int n, int [] arr){

        // IDEA : 맨처음 수는 저장후에 앞뒤 문자 비교하여 저장
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]) list.add(arr[i]);
        }

        return list;
    }

    private static ArrayList<Integer> solution2(int n, int [] arr){

        // IDEA : 맨처음수 max 저장 더크면 max 교체
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(max < arr[i]) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        return list;
    }

    private static ArrayList<String> solution3(int n, int [] A, int [] B){

        // IDEA : 2(바위) > 1(가위), 1(가위) > 3(보), 3(보) > 2(바위)
        // 먼가 좀더 쉬운 방법이 있을거 같음
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(A[i] == B[i]) list.add("D");
            else if (A[i] == 1 && B[i] == 3) list.add("A");
            else if (B[i] == 1 && A[i] == 3) list.add("B");
            else if (A[i] > B[i]) list.add("A");
            else if (B[i] > A[i]) list.add("B");
        }

        return list;
    }

    private static int [] solution4(int n){

        // IDEA : 첫번쨰, 두번쨰 저장하고 나머지 부터 더하기

        int [] fibo = new int [n];

        fibo[0] = 1;
        fibo[1] = 1;

        for(int i = 2; i < n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        return fibo;
    }
    private static boolean []  solution5(int n){
        boolean [] number = new boolean[n+1];

        // IDEA : 2 처음 방문 했다 -> 소수다라고 가정하자 -> 2의 배수를 모두 지우자 24 6 8 10
        // 3 처음 방문했다 -> 소수가정 ->  3의 배수를 모두 지우자 3 6 9 12 15
        // 5 처음 -> 소수가정 -> 5의 배수를 모두 지우자 -> 5 -> 10 -> 15 -> 20
        int answer = 0;
        for(int i = 2; i <= n; i++){
            if(number[i]) continue;;
            for(int j = 2* i; j <= n; j += i){
                number[j] = true;
            }
        }

        return number;
    }

    private static boolean isPrime(int prime){
        int temp = 0;
        for(int i = prime; i > 0; i--){
            if(prime % i == 0)  temp++;
            if(temp > 2) return false;
        }
        return temp == 2;
    }
    private static ArrayList<Integer> solution6(int n, String [] array){

        // IDEA : 소수 자기 자신과 1 이외에 나누어지지 않는 수

        StringBuilder buffer = new StringBuilder();
        ArrayList<Integer> answer = new ArrayList<>();
        for(String data :  array){
            buffer = new StringBuilder(data);
            int prime = Integer.parseInt(buffer.reverse().toString());
            if(isPrime(prime)) answer.add(prime);
        }

        return answer;
    }

    private static int solution7(int n, int [] score){

        // IDEA : 피보나치 한것처럼 맨처음거 저장후 다음거 부터 1인경우 이전 데이터랑 합
        int sum = score[0];
        for(int i = 1; i < n; i++){
            if(score[i] == 1) {
                score[i] += score[i-1];
                sum += score[i];
            }
        }

        return sum;
    }

    private static ArrayList<Integer> solution8(int n, int [] number){

        // IDEA : 나보다 큰수가 있으면 내 랭킹을 +1
        ArrayList<Integer> rankList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int rank = 1;
            for(int j = 0; j < n; ++j){
                if(number[i] < number[j]) rank++;
            }
            rankList.add(rank);
        }
        return rankList;
    }

    private static int solution9(int n, int [][] array){

        // IDEA : 각 행의 합 돌리고 -> 각 열의 합 돌리고 -> 각 대각선의 합
        int max = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        int rightCrossSum = 0;
        for(int i = 0 ; i < n; i++){
            int colSum = 0;
            int rowSum = 0;
            leftCrossSum += array[i][i];
            rightCrossSum += array[i][n-i-1];
            for(int j = 0; j < n; j++){
                //각 행의 합
                colSum += array[i][j];
                rowSum += array[j][i];
            }
            int sum = Math.max(colSum, rowSum);
            if(max < sum) max = sum;
        }

        int sum = Math.max(leftCrossSum, rightCrossSum);
        if(max < sum) max= sum;

        return max;
    }


    static int [] x = {-1, 0,  0, 1};
    static int [] y = { 0, 1, -1, 0};

    private static boolean isPeaks(int X, int Y, int [][] array){
        int max = array[X][Y];
        for(int i = 0; i < 4; ++i){
            int r = X + x[i];
            int c = Y + y[i];
            if( max <= array[r][c] ) return false;
        }
        return true;
    }
    private static int solution10(int n, int [][] array){
        /**
         *  각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
         *  -> 상하 좌우 비교하자
         *  int [] y = { 0, 1, -1, 0};
         *  격자의 가장자리는 0으로 초기화 되었다고 가정한다.
         *  -> 배열의 시작 위치를 정해준다 5*5 -> 4 *4 만 돌자
         */

        int peaks = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n-1; j++){
                if(isPeaks(i,j,array)) {
                    peaks++;
                }
            }
        }
        return peaks;
    }



    private static boolean[][] isSame(int x, int y, int [][] array, int n, boolean [][] visit){

        // 4  1,2,3,4,5
        int grade = array[x][y];
        for(int i = 0; i < n; i++){
            if(i == x) continue;
            if(visit[x][i]) continue;;
            if(array[i][y] == grade) {
                visit[x][i] = true;
            }
        }
        return visit;
    }
    private static int solution11 (int n, int [][] grade){

        /**
         * IDEA -> i 번쨰 학생의 k학년과 -> j번학생들의 k학년이 같은지 구하자
         * -> 못푼이유. 2차원 배열까지 사용하고 list에 담아서 하려고 함 -> Runtime 뜸
         * -> 그냥 3차원 배열사용하는것이 메모리 더 작게 듬 ->
         */
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; ++i){
            int cnt = 0;
            for(int j = 1; j <= n; ++j){
                for(int k = 1; k <= 5; ++k){
                    if(grade[i][k] == grade[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if( cnt > max){
                max = cnt;
                answer = i;
            }
        }


        return answer;
    }

    private static int solution12 (int n, int m, int [][] arr){

        /**
         *  선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
         *  -> M번
         * 3 4 1 2 => 3 -> 4, 1, 2 , 4 -> 1,2  | 1 -> 2
         * 4 3 2 1 => 4 -> 3, 2, 1 , 3 -> 2,1 | 2 -> 1
         * 3 1 4 2 =>
         *
         * n * n
         *   1 2 3 4
         * 1 0 0 0 0
         * 2 0 0 0 0
         * 3 T T T T
         * 4 T 0 0 T
         */
        boolean [][] visit = new boolean[n+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; ++j){
                int currentStudentNumber = arr[i][j];
                for(int k = j; k <= n; ++k){
                    int otherStudent = arr[i][k];
                    visit[currentStudentNumber][otherStudent] = true;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(!visit[i][j]) answer++;
            }
        }
        return answer;
    }

}
