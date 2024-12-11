package org.example;

public class FibNumber {
    public static void main(String[] args){
        int n= 10;
        // Print 5 Fib numbers
        int start = 0;
        int next = 1;
        // Handle the case for the first term
        if (n >= 1) {
            System.out.println(start + " ");
        }

        // Handle the case for the second term
        if (n >= 2) {
            System.out.println(next + " ");
        }
        for(int i=1;i<=n;i++){
            int newnext=start+next;
            System.out.println("FIBNo.="+newnext);
            start=next;
            next=newnext;
        }
    }
}
