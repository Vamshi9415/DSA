import java.util.*;

class sub_string{
    public static void main(String[] args) {
        
        List<String> strlist = new ArrayList<>();

        String str = "abc";

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                strlist.add(str.substring(i,j));
            }
        }
        System.out.println(strlist);

    }
}