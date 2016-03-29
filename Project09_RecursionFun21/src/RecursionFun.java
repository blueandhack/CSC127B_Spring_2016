/*
 * CSc 127B Spring 2016, Project 09
 *
 * Project Name: RecursionFun21
 *
 * SL Letter: C 
 * Author: Yujia Lin 
 * SL Name: Cody Jensen
 *
 * ---
 * This project asks you to solve 21 problems using recursive solutions. 
 * In each, the method must call other invocations of the same method in order to find the solution.
 */
public class RecursionFun {

	/*
	 * 1. Complete recursive method combinations that returns from n choose k.
	 * Method combinations is described in 17-SimpleRecursion.ppt slides 17..22
	 * from lecture. The following recursive definition is correct for
	 * combinations (but called c here for brevity's sake). This reads that when
	 * k == 1 return n, when n == k, return 1, and c(5, 2) would return c(4, 1)
	 * + c(4, 2).
	 */
	public int combinations(int n, int k) {
		if (k < 1 || n < k) {
			return 0;
		}
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	/*
	 * 2. Implement factorial to return n! that is defined as n * n-1 * n-2 *
	 * n-3 * 2 * 1. 1! And 0! Are both defined as 1. Use recursion, no loop.
	 */
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	/*
	 * 3. Complete recursive method addReciprocals(int) that takes an integer as
	 * a parameter and returns the sum of the first n reciprocals. Use
	 * recursion; do not use a loop. addReciprocals(n) returns
	 * (1.0+1.0/2.0+1.0/3.0+ ... + 1.0/n).
	 */
	public double addReciprocals(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return 1.0 / n + addReciprocals(n - 1);
	}

	/*
	 * 4.Implement the Greatest Common Divisor algorithm as public recursive
	 * method GCD.Use recursion. Do not use a loop. If only one argument is 0,
	 * GCD should return the other argument. GCD is undefined when both
	 * arguments are 0 (we have no tests for this undefined case). Because the %
	 * operator does not work with negative integers, you will need to convert
	 * the arguments to their absolute value with Math.abs(int).
	 */
	public int GCD(int m, int n) {
		if (n == 0) {
			return Math.abs(m);
		}
		if (m == 0) {
			return Math.abs(n);
		}
		return GCD(n, Math.abs(m) % Math.abs(n));
	}

	/*
	 * 5.The first 9 Fibonacci numbers are 1 1 2 3 5 8 13 21 34. Each Fibonacci
	 * number is the sum of the preceding two (except for the first two, which
	 * are both 1). Implement a recursive method named fibonacci that returns
	 * the nth Fibonacci number.Use recursion, no loops.
	 */
	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	/*
	 * 6.Given a string, compute recursively a new string where identical chars
	 * that are adjacent in the original string are separated from each other by
	 * a "_". Use recursion, no loops.
	 */
	public String underScore(String str) {
		if (str.length() == 0) {
			return "";
		}
		if (str.length() == 1) {
			return str;
		}

		if (str.substring(0, 1).equals(str.substring(1, 2))) {
			return str.substring(0, 1) + "_" + underScore(str.substring(1));
		} else {
			return str.substring(0, 1) + underScore(str.substring(1));
		}
	}

	/*
	 * 7.Given a string, return true if it is a nesting of zero or more pairs of
	 * parenthesis, like "(())" or "((()))". Suggestion: check the first and
	 * last chars, and then recur on what's inside them. Use recursion, no
	 * loops.
	 */
	public boolean nestParen(String str) {
		return nestParen(str, 0, str.length() - 1);
	}

	// private method for nestParen, and it is a helper method
	private boolean nestParen(String str, int index, int lastIndex) {
		if (str.length() == 0) {
			return true;
		}
		if (str.length() % 2 == 1) {
			return false;
		}
		if (str.charAt(index) != '(' && str.charAt(lastIndex) != ')') {
			return false;
		}
		if (index == lastIndex - 1) {
			return true;
		}
		return nestParen(str, index + 1, lastIndex - 1);
	}

	/*
	 * 8.Complete recursive method noAdjacents that when given a string,
	 * recursively returns a string where adjacent chars that are the same have
	 * been reduced to a single char.
	 */
	public String noAdjacents(String str) {
		return noAdjacents(str, 0);
	}

	// private method for noAdjacents, and it is a helper method
	private String noAdjacents(String str, int index) {
		if (str.length() == 0) {
			return "";
		}
		if (index == 0) {
			return str.substring(index, index + 1) + noAdjacents(str, index + 1);
		}
		if (index == str.length() - 1) {
			if (!str.substring(index - 1, index).equals(str.substring(index))) {
				return str.substring(index);
			} else {
				return "";
			}
		}
		if (str.substring(index - 1, index).equals(str.substring(index, index + 1))) {
			return noAdjacents(str, index + 1);
		}
		return str.substring(index, index + 1) + noAdjacents(str, index + 1);
	}

	/*
	 * 9.Complete recursive method noAdjacents that when given a string,
	 * recursively returns a string where adjacent chars that are the same have
	 * been reduced to a single char.
	 */
	public String convert(int num, int base) {
		if (num == 0) {
			return "";
		}
		return convert(num / base, base) + (num % base);
	}

	/*
	 * 10.Complete recursive method intWithCommas that returns the argument as a
	 * String with commas in the correct places. The convert method from lecture
	 * with hexadecimal numbers provides a pattern.
	 */
	public String intWithCommas(int n) {
		return intWithCommas("" + n, 1);
	}

	// private method for intWithCommas, and it is a helper method
	private String intWithCommas(String str, int index) {
		if (str.length() - index == 0) {
			return str.substring(0, 1);
		}
		if (index % 3 == 0) {
			return intWithCommas(str, index + 1) + "," + str.substring(str.length() - index, str.length() - index + 1);
		}
		return intWithCommas(str, index + 1) + str.substring(str.length() - index, str.length() - index + 1);
	}

	/*
	 * 11.Complete recursive method sumArray that returns the sum of all the int
	 * elements in the given range of indexes. Use recursion, do not use a loop.
	 * You must have a recursive call in your answer.
	 */
	public int sumArray(int[] nums, int beginIndex, int endIndex) {
		if (beginIndex > endIndex || beginIndex < 0 || endIndex > nums.length - 1 || endIndex < 0
				|| beginIndex > nums.length - 1) {
			return 0;
		}
		if (beginIndex == endIndex) {
			return nums[beginIndex];
		}
		return nums[beginIndex] + sumArray(nums, beginIndex + 1, endIndex);
	}

	/*
	 * 12.Write recursive method sumArray that returns the sum of all integers
	 * in the given array x. Use recursion, do not use any loops. T
	 */
	public int sumArray(int[] nums) {
		return sumArray(nums, 0);
	}

	// private method for sumArray, and it is a helper method
	private int sumArray(int[] nums, int index) {
		if (nums.length == 0) {
			return 0;
		}
		if (index > nums.length - 1) {
			return 0;
		}
		return nums[index] + sumArray(nums, index + 1);
	}

	/*
	 * 13.Write recursive method reverseArray that reverses the array elements
	 * in a filled array of ints. Use recursion. Do not use a loop.
	 */
	public void reverseArray(int[] nums) {
		reverseArray(nums, 0);
	}

	// private method for reverseArray, and it is a helper method
	private void reverseArray(int[] nums, int index) {

		if (index == nums.length / 2) {
			return;
		}
		int temp = nums[nums.length - 1 - index];
		nums[nums.length - 1 - index] = nums[index];
		nums[index] = temp;
		reverseArray(nums, index + 1);
	}

	/*
	 * 14.Write recursive method arrayRange that returns the maximum integer
	 * minus the minimum integer in the filled array of ints. Use recursion; do
	 * not use a loop. The following assertions must pass. Notice the shortcut
	 * way to pass a reference to a new array--it saves your writing a bit of
	 * code.
	 */
	public int arrayRange(int[] nums) {
		return arrayRange(nums, nums[0], nums[0], 0);
	}

	// private method for arrayRange, and it is a helper method
	private int arrayRange(int[] nums, int max, int min, int index) {
		if (nums.length < 2) {
			return 0;
		}
		if (nums[index] > max) {
			max = nums[index];
		}
		if (nums[index] < min) {
			min = nums[index];
		}
		if (index == nums.length - 1) {
			return max - min;
		}
		return arrayRange(nums, max, min, index + 1);
	}

	/*
	 * 15.Complete method isSorted to return true if the given array of ints is
	 * sorted in ascending order. Return false if not completely sorted. By
	 * definition, an empty array is sorted.
	 */
	public boolean isSorted(int[] nums) {
		return isSorted(nums, 0);
	}

	// private method for isSorted, and it is a helper method
	private boolean isSorted(int[] nums, int index) {
		if (nums.length == 0) {
			return true;
		}
		if (index != 0 && nums[index - 1] > nums[index]) {
			return false;
		}
		if (index == nums.length - 1) {
			return true;
		}
		return isSorted(nums, index + 1);
	}

	/*
	 * 16.Complete method found to return true if search is found in the array
	 * strs. If searchValue is not found, return false.
	 */
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	// private method for found, and it is a helper method
	private boolean found(String search, String[] strs, int index) {
		if (strs[index].equals(search)) {
			return true;
		}
		if (index == strs.length - 1) {
			return false;
		}
		return found(search, strs, index + 1);
	}

	/*
	 * 17.Complete recursive method binarySearch to return the index of the
	 * first String that equals searchValue. Use recursion, do not use a loop.
	 * Use the binary search algorithm so it run O(log n). Use a sorted array of
	 * unique strings to test binarySearch. If searchValue is not found, return
	 * -1.
	 */
	public int binarySearch(String searchValue, String[] strings) {
		return binarySearch(searchValue, strings, 0);
	}

	// private method for binarySearch, and it is a helper method
	private int binarySearch(String searchValue, String[] strings, int index) {
		if (strings[index].equals(searchValue)) {
			return index;
		}
		if (index == strings.length - 1) {
			return -1;
		}
		return binarySearch(searchValue, strings, index + 1);
	}

}
