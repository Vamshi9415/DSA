class fib{
    public static int fib(int n){
        if(n<=1){
             return 1;
        }

        int curr = 0;
        int prev1= 1;
        int prev2 = 0;

        for ( int i=2;i<=n;i++) {
            curr = prev1 +prev2;
            prev2 = prev1;
            prev1 = curr;
            System.out.println(curr);
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 10; // Example value
        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));
    }
}