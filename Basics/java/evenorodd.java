class evenorodd{
    public static int isevenorodd(int x){
        System.out.println(x%2);
        return x%2;
    }

    public static void main(String args[]){
        // int x = 45;
        
        if(args.length >0){
            int x = Integer.parseInt(args[0]);

            if(isevenorodd(x) == 0){
                System.out.println("it is even");
            }else{
                System.out.println("it is odd");
    
            }
        }
    }
}