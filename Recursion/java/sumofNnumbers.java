public class sumofNnumbers {
    
    public static void sum(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }

        sum(i-1, sum+i);
    }

    public static int sum2(int n)
    {
        if(n == 0){
            return 0;
        }

        return n +sum2(n-1);
    }

    public static void main(String[] args) {
        sum(100, 0);

        System.out.println(sum2(100));
    }

}
