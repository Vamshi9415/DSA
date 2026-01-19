import java.util.*;
class nge{

	public static  int[]nge(int[] a){

		int n = a.length-1;
		int[] nge = new int[a.length];
		Stack<Integer> st = new Stack<>();
		for(int i=n;i>=0;i--){
			while(st.isEmpty() == false && st.peek() <= a[i]){
				st.pop();
			}
			if(st.isEmpty() == false){
				nge[i] = st.peek();
			}else{
				nge[i] = -1;
			}
			st.push(a[i]);


		}
		return nge;
	}

//previous smallest element
	public static int[]pse(int[] a){
		int n = a.length - 1;
		int[] pse = new int[a.length];
		Stack<Integer> st = new Stack<>();

		for(int i=0;i<=n;i++){
			while(st.isEmpty() == false && st.peek()>=a[i]){
				st.pop();
			}
			if(st.isEmpty() == false){
				pse[i] = st.peek();
			}else{
				pse[i] = -1;
			}
			st.push(a[i]);
		}
		return pse;
	}

//nexgt smallest element

	public static int[]nse(int[] a){
		int n = a.length - 1;
		int[] nse = new int[a.length];
		Stack<Integer> st = new Stack<>();

		for(int i=n;i>=0;i--){
			while(st.isEmpty() == false && st.peek()>=a[i]){
				st.pop();
			}
			if(st.isEmpty() == false){
				nse[i] = st.peek();
			}else{
				nse[i] = -1;
			}
			st.push(a[i]);
		}
		return nse;
	}

	//previous greater element

	public static int[]pge(int[] a){
		int n = a.length - 1;
		int[] pge = new int[a.length];
		Stack<Integer> st = new Stack<>();

		for(int i=0;i<=n;i++){
			while(st.isEmpty() == false && st.peek()<=a[i]){
				st.pop();
			}
			if(st.isEmpty() == false){
				pge[i] = st.peek();
				System.out.println(st.peek());
			}else{
				pge[i] = -1;
			}
			st.push(a[i]);

		}
		return pge;
	}


	public static void main(String args[]){
			int a[] = {5,7,1,2,6,0};

			int a2[] = nge(a);
			int a3[] = pse(a);
			int a4[] = nse(a);
			int a5[] = pge(a);
			System.out.println(Arrays.toString(a2));
			System.out.println(Arrays.toString(a3));
			System.out.println(Arrays.toString(a4));
			System.out.println(Arrays.toString(a5));
	}
}