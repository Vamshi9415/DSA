public class palindrome0fstring {
    static boolean general(String str){
        int r = str.length() -1;
        
        int l =0;
       
        while(l<=r){
            if(str.charAt(l) != str.charAt(r) ) return false ;
            l++;
            r--;
        }
    return true;
    }

    static boolean recursion(String str, int i){
        int n = str.length();

        if(i>= n/2) return true;

        if(str.charAt(i) != str.charAt(n-1-i)) return false;

        return recursion(str,i+1);



    }
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(general(s));                   
        System.out.println(recursion(s, 0)); 
    }

}
