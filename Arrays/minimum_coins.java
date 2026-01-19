class minimum_coins{
	public static void main(String args[]){
			int coins[] = {1,2,5,10,20,50,100,500,1000};

			int v = 70;
			int rem = v;
			int count =0;
			for(int i=coins.length-1;i>=0;i--){
				if(coins[i]<v){
					while(rem>=coins[i]){
						System.out.println(rem);

						rem = rem - coins[i];
						count++;
					}
				}
			}
									System.out.println(count);


	}
}