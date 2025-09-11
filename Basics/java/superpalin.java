// Java implementation of the
// above approach
import java.lang.*;

class GFG
{

// check if a number is a palindrome
public static boolean ispalindrome(int x)
{
	int ans = 0;
	int temp = x;
	while (temp > 0)
	{
		ans = 10 * ans + temp % 10;
		temp = temp / 10;
	}
	return ans == x;
}

// Function to return required 
// count of palindromes
public static int SuperPalindromes(int L, 
								int R)
{
	// Range [L, R]

	// Upper limit
	int LIMIT = 100000;

	int ans = 0;

	// count odd length palindromes
	for (int i = 0 ;i < LIMIT; i++)
	{

		// if s = '1234'
		String s = Integer.toString(i);

		StringBuilder rs = new StringBuilder();
		rs.append(s.substring(0,
					Math.max(1, s.length() - 1)));
		String srs = rs.reverse().toString();

		// then, t = '1234321'
		String p = s + srs;
		int p_sq = (int)(Math.pow(
						Integer.parseInt(p), 2));
		if (p_sq > R)
		{
			break;
		}
		if (p_sq >= L && ispalindrome(p_sq))
		{
			ans = ans + 1;
		}
	}

	// count even length palindromes
	for (int i = 0 ;i < LIMIT; i++)
	{

		// if s = '1234'
		String s = Integer.toString(i); 

		StringBuilder rs = new StringBuilder();
		rs.append(s);
		rs = rs.reverse();

		String p = s + rs; // then, t = '12344321'
		int p_sq = (int)(Math.pow(
						Integer.parseInt(p), 2));
		if (p_sq > R)
		{
			break;
		}
		if (p_sq >= L && ispalindrome(p_sq))
		{
			ans = ans + 1;
		}
	}

	// Return count of super-palindromes
	return ans;
}

// Driver program
public static void main(String [] args)
{
	String L = "4";
	String R = "1000";

	// function call to get required answer
	System.out.println(SuperPalindromes(
	Integer.parseInt(L), Integer.parseInt(R)));
}
}


