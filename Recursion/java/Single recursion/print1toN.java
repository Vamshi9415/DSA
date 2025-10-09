public class print1toN {
    public static void f(int i, int n){
        if (i > n){
            return;
        }
        System.out.println(i);
        f(i+1,n);
    }
    public static void main(String args[]){
        f(1,100);
    }
}
