import java.util.ArrayList;
import java.util.Collections;

public class printallDivisiors {

    static ArrayList<Integer> printAllDivisiors(int number){
ArrayList<Integer> divisors = new ArrayList<Integer>();

for (int i =1 ;i<=(int)(Math.sqrt(number));i++){
    if(number % i == 0){
        divisors.add(i);
        if(i != (number/i)){
            divisors.add(number/i);
        }
    }
}
Collections.sort(divisors);

        return divisors;
    }
    public static void main(String[] args) {
        int number = 36; // Example number
        ArrayList<Integer> divisors = printAllDivisiors(number);
        System.out.println("Divisors of " + number + ": " + divisors);
    }

}
