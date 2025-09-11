class palindrome{
    public static boolean isPalin(int x){
        int rev = 0;

        int temp = x;
        //int temp = Math.abs(x);
        while(temp!=0){
            rev = rev*10 + temp%10;

            temp/=10;
        }

        return (rev == Math.abs(x));
    }
    public static void main(String[] args) {
        int number = -121; 
        if (isPalin(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }
}