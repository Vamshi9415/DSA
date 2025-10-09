public class printNto1 {
    public static void f(int i, int n){
        if (i<1){
            return;
        }
        System.out.println(i);
        f(i-1,n);
    }
    public static void main(String args[]){
        int n = 100;
        f(n,n);
    }
}
