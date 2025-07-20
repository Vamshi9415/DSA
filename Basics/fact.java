public class fact{
    public static int fact(int n){

        if(n == 0 || n == 1){
            return 1;
        }
        int fact = 1;
        for(int i=2;i<=n;i++){
            fact = fact*i;
        }
        return fact;
    }
    public static void main(String[] args) {
        int number = 5; 
        int result = fact(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}