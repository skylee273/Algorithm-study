package com.company.queue;

import com.company.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QueueClass {

    private static int  solution6(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();


        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int startNumber = 1;
        while(queue.size() != 1){
            Integer poll = queue.poll();
            if(startNumber % n != k) queue.add(poll);
            else startNumber = 0;
            startNumber++;
        }

        return queue.poll();
    }

    private static int  solution7(int n, int m, Queue<Patient> queue, Patient patient){

        while(!queue.isEmpty()) {
            Patient poll = queue.poll();
            for (Patient x : queue) {
                if (x.point > poll.point) {
                    queue.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                if (patient.equals(poll)) return n - queue.size();
            }
        }

        return 0;
    }


    private static class Patient {
        int pos;
        int point;

        Patient(int pos, int point) {
            this.pos = pos;
            this.point = point;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "pos=" + pos +
                    ", point=" + point +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Patient patient = (Patient) o;
            return pos == patient.pos && point == patient.point;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos, point);
        }

    }
    public static void main7(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Patient> queue = new LinkedList<>();
        Patient patient = new Patient(0, 0);
        for(int i = 0; i < n; ++i) {
            int point = Integer.parseInt(st.nextToken());
            if(i == m) patient = new Patient(i, point);
            queue.offer(new Patient(i,point));
        }

      /*  while (!queue.isEmpty())
            System.out.println(queue.poll());*/

        System.out.println(solution7(n, m, queue, patient));

        return;
    }

}
