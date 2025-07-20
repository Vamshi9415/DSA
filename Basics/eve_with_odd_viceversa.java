// Count of integers in a range which have even number of odd digits and odd number of even digits
// Last Updated : 25 Feb, 2022
// Given a range [L, R], the task is to count the numbers which have even number of odd digits and odd number of even digits. For example, 

// 8 has 1 even digit and 0 odd digit – Satisfies the condition since 1 is odd and 0 is even.
// 545 has 1 even digit and 2 odd digits – Satisfies the condition since 1 is odd and 2 is even.
// 4834 has 3 even digits and 1 odd digit – Does not satisfy the condition since there are odd numbers(i.e 1) of odd digits.
class eve_with_odd_viceversa{

    static boolean isfun(int x){
        int n = x;
        int evencount =0, oddcount =0;
        while(n!=0){
            int remainder = n%10;

            if(remainder%2 == 0){
                evencount++;
            }else{
                oddcount++;
            }
            n/=10;
        
        
        }
        if(oddcount%2 == 0 && evencount%2!=0){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        int count=0;
        int L = 1;
        int R = 10000000;
        for(int i=L;i<=R;i++){
            if(isfun(i)){
                count++;
                System.out.println(i);
            }
        }
        System.out.println("couunt is "+count);
    }
}