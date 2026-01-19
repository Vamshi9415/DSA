class sum_subbarray_min{

public static void main(String args[]){

	int[] a = new int[]{3,1,2,4};
	int sum =0;
	int min = -1;
	for(int i=0;i<a.length;i++){
		min = a[i];
		for(int j=0;j<=i;j++){
			min = Math.min(min,a[j]);
		}
		sum = sum +min;
	}
	System.out.println(sum);
}
}