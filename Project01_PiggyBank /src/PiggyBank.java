/*
 * CSc 127B Spring 2016, Project 01
 *
 * SL Letter: C
 * Author:  Yujia Lin
 * SL Name: Cody Jensen
 *
 * ---
 * The file is a class, and we can use the class to create a object.
 * Also, the object is like a bank, and the bank's name is PiggyBank.
 * PiggyBank can store three types coin, so the class has three instance variables.
 * The bank has some functions, we can see those functions at the below.
 */
public class PiggyBank {

	// There are all of instance variables for the object. The PiggyBank should
	// store pennies, nickels and/or dimes, so we need create those variables.
	private int pennies;
	private int nickels;
	private int dimes;

	// The construct method creates an empty PiggyBank, so we should initialize
	// all of attributes.
	public PiggyBank() {
		this.pennies = 0;
		this.nickels = 0;
		this.dimes = 0;
	}

	// The method can be get total coins currently in the bank that the coins
	// can be of any type.
	// And the method return a integer type of number.
	public int getTotalNumberOfCoins() {
		return this.pennies + this.nickels + this.dimes;
	}

	// The method should return the total amount of cash in the bank, as we
	// know, Pennies are $0.01, nickels are $0.05, and dimes
	// are $0.10, then we just need to calculate the number of coins after we
	// can get the balance. So, it returns a double value.
	public double getTotalCashInBank() {
		return this.pennies * 0.01 + this.nickels * 0.05 + this.dimes * 0.10;
	}

	// The method can add the given number of pennies to this PiggyBank
	public void addPennies(int penniesEntered) {
		this.pennies += penniesEntered;

	}

	// The method adds the given number of nickels to this PiggyBank
	public void addNickels(int numberOfNickels) {
		this.nickels += numberOfNickels;
	}

	// The method adds the given number of dimes to this PiggyBank
	public void addDimes(int numberOfDimes) {
		this.dimes += numberOfDimes;
	}

	// The method drain the bank, so all of the money out of the bank,
	// the quantity of each kind of coin equals zero.
	public void drainTheBank() {
		this.pennies = 0;
		this.nickels = 0;
		this.dimes = 0;
	}

}
