/**
 * The Main class provides a simple program to determine the largest prime palindrome under
 * 1000. It takes no arguments and just prints the largest prime palindrome to the screen.
 * 
 * @author Todd Wallentine todd AT wallentine com
 */
public class Main {
	
	private static final int MAX = 1000;

	public static void main(final String[] args) {
		for(int i = MAX; i > 1; i--) {
			if(isPrime(i) && isPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	/**
	 * Determine if the given number is prime.
	 * 
	 * @param num The number to test.
	 * @return True if the number is prime and false otherwise.
	 */
	protected static boolean isPrime(final int num) {
		boolean isPrime = true;
		
		if(num == 1 || num == 2) {
			isPrime = true;
		} else if(num > 2) {
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					// evenly divisible by i so it is not a prime number
					isPrime = false;
					break;
				}
			}
		}
		
		return isPrime;
	}
	
	/**
	 * Determine if the given number is a palindrome (the same backwards as it is forwards).
	 * 
	 * @param num The number to test.
	 * @return True if the number given is a palindrom and false otherwise.
	 */
	protected static boolean isPalindrome(final int num) {
		boolean isPalindrome = false;
		
		if(num < 10) {
			isPalindrome = true;
		} else {
			String numAsString = String.valueOf(num);
			String reverseNumAsString = reverseString(numAsString);
			isPalindrome = numAsString.equals(reverseNumAsString);
		}
		
		return isPalindrome;
	}
	
	/**
	 * Reverse the given String.
	 * 
	 * @param s The String to reverse.
	 * @return The reversed version of the String.
	 */
	protected static String reverseString(final String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			sb.append(c);
		}
		
		return sb.toString();
	}
}