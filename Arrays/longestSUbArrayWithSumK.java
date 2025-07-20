class longestSUbArrayWithSumK{
    public static int brute(int[] arr, int target){
        int n = arr.length;
        int highest = -1;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum+arr[i];
                if(sum == target){
                    highest = Math.max(highest,j-i+1);
                }
            }
        }
   
return highest;
    }

    public static void main(String args[]){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int brute = brute(arr,9);
        System.out.println("answer with brute is "+ brute);
    }


}