package com.company.sorting;

public class SortingClass {

    //선택 정렬
    private static String  solution1(int n, int [] arr){

        StringBuilder sb = new StringBuilder();

        int pos;

        for(int i = 0; i < n-1; ++i) {
            pos = i;
            int min = arr[i];
            for (int j = i+1; j < n; ++j) {
                if(arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            if( i != pos) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }

        }

        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

    // 버블정료ㅕㄹ
    private static String  solution2(int n, int [] arr){

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; ++i) {
            for (int j = 0; j < n-i-1; ++j) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString();
    }

}
