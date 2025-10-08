// Print the message "vamshi bachu" exactly N times using recursion.

public class printNTimes {
    public static void f(int i, int n){
            if(i>n){
                return;
            }

            System.out.println("vamshi bachu");
            f(i+1,n);
        }

    public static void main(String args[]){

        int n = 5;

        f(1,n);
    }
}
