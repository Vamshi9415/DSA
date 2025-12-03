public class isPrime {
    public static boolean isaPrime(int number){

        if(number <=1){
            return false;
        }

        for(int i=2; i<=(int)Math.sqrt(number); i++){
            if(number%i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int num = 29; 
        if (isaPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
