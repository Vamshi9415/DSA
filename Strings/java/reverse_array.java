import java.util.Arrays;

public class reverse_array {
   public static void reverse_array(String[] arr){
    int left = 0;
    int right = arr.length -1;

    while(left < right){
        String temp = arr[left];
        arr[left]= arr[right];
        arr[right] = temp;

        left ++;
        right--;
    }
   }

   public static void main(String[] args){
    String str = "fkjdsbf,gfdg,dggd,gdg,dgd";
    String[] parts = str.split("[,]");

    reverse_array(parts);
    System.out.println(Arrays.toString(parts));

    StringBuilder sb = new StringBuilder();

    // for(int i =0;i<parts.length;i++){
    //     sb.append(parts[i]);
    //     sb.append(" ");
    // }
    // System.out.println(sb.toString());

    String result = String.join(" ",parts);
    System.out.println(result);
   }
}
