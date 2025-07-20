import java.util.Arrays;

class sorting{
    void selectionSort(int[] a) {
       int n = a.length;
       
       for(int i=0;i<=n-2;i++){
           int min = i;
           for(int j=i+1;j<=n-1;j++){
               if(a[j]<a[min]){
                   min = j;
               }
           }
           int temp =a[min];
           a[min]=a[i];
           a[i]= temp;
          
       }  
    }

    void bubblesort(int[] a){
        int n = a.length;

        for(int i=n-1;i>=1;i--){
            for(int j=0;j<=i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        sorting sorter = new sorting();
        int[] array = {64, 25, 12, 22, 11};
        // sorter.selectionSort(array);
        sorter.bubblesort(array);
        System.out.println(Arrays.toString(array));
    }
}