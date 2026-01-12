class pattern {
    public static void print1(){
        for ( int i = 0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void print2(int n){
        for ( int i = 0;i<4;i++){
            char x = 'A';
            for(int j=0;j<=i;j++){
                System.out.print(x);
                x= (char)(x + 1);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print2(6);
    }
}