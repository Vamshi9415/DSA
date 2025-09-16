import java.util.Arrays;

class reverse_words_sentence{
    public static void main(String[] args){
        String str = "apple,vfbg;fgfn";
        String[] parts = str.split("[;,]");
        
        System.out.println(Arrays.toString(parts));

        for(int i=0;i<parts.length;i++){
            parts[i] = new StringBuilder(parts[i]).reverse().toString();
        }
        System.out.println(Arrays.toString(parts));
    }
}