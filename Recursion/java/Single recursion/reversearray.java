class reversearray{

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void general_reverse(int[] arr){
        int l = 0;
        int r = arr.length -1;
        while(l<=r){
            swap(arr,l,r);
            l++;
            r--;
        }
    }
    static void recursion_reverse(int[] arr, int l , int r){
            if(l>=r) return;

           swap(arr,l,r); 
            recursion_reverse(arr, l+1, r-1);

    }

    static void recursionwithonevariable(int[] arr, int i){
        int n = arr.length;
        if(i>=n/2){
            return;
        }

        swap(arr, i, n-1-i);

        recursionwithonevariable(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        general_reverse(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        
        int[] arr2 = {1, 2, 3, 4, 5};
        recursion_reverse(arr2, 0, arr2.length - 1);
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();

        
        int[] arr3 = {1, 2, 3, 4, 5};
        recursionwithonevariable(arr3, 0);
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}