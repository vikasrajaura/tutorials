package com.vik.cj06;


	abstract class Account {
	    Person accHolder; 
	    Integer accNum; 
	    Integer balance; 
	    String accountType;
	    //declare a static hashmap variable with name "accounts" with key as Integer and value which can store both objects of type SavingsAccount and CurrentAccount 
	    
	    public abstract void setAccountDetails(Person accHolder, Integer accNum, Integer balance);
	    public abstract void setBalance(Integer balance);
	    public abstract Integer getBalance(); public abstract String debit(Integer amount);
	    public abstract String credit(Integer amount); 
	    
	    public static String createSavingsAccount(Person accHolder, Integer accNum, Integer balance){ 
	        //write code to create a savings account object every time this method is called and add the account number as key and object as value to a HashMap of type <Integer,Account> 
	        //use setAccountDetails method in SavingsAccount class to set the values
	        //if the balance while creating an account is >=1000 then return "Savings Account SuccessFully Created!" or return "Validation Failed!" 
	        //if validation fails then set all the fields and SavingsAccount object to null 
	    } 
	        
	    public static String createCurrentAccount(Person accHolder, Integer accNum, Integer balance){ 
	        //write code to create a current account object every time this method is called and add the account number as key and object as value to the Accounts.account variable 
	        //use setAccountDetails method in CurrentAccount class to set the values 
	        //if the balance while creating an account is >=10000 then return "Current Account SuccessFully Created!" or return "Validation Failed!"
	        //if validation fails then set all the fields and SavingsAccount object to null 
	    } 
	} 

	class SavingsAccount extends Account { 
	    public void setAccountDetails(Person accHolder, Integer accNum, Integer balance){
	        //write code here to set the accHolder(account holder),accNum(account number),balance and accountType fields 
	        synchronized(this) {
		        this.accHolder=accHolder;
		        this.accNum=accNum;
		        this.balance=balance;
	        }
	    } 
	    //write a toString() method to to generate account details when the hashmap's "accounts.get(accNum)" method is used to print all the user details in the below format 
	    //"Name : Arjun Age : 21 City : Bangalore Account Number : 12345 Balance : 1000 Account Type : Savings" (without quotes) 
	    //write setter and getter methods to set and get balance with return type Integer 
	    
	    public String debit(Integer amount){ 
	        //write code here to handle debiting(withdrawal) from an account 
	        //if the withdrawal amount makes the balance lesser than zero then return "Cannot deduct more than available balance!" 
	        //if the withdrawal amount makes the balance lesser than minimum balance(1000) and greater than zero then return ex: "500 Rs. has been successfully debited and the balance is 500 Rs. and minimum balance is not present in account: 1234"
	        //else return ex: "2000 Rs. has been successfully debited and the balance is 1500 Rs. in account: 1234"
	        synchronized(this) {
	            if(this.balance<amount)
	                return "Cannot deduct more than available balance!";
	            if(this.balance-amount<1000) {
	            	balance=balance-amount;
	            	return amount+" Rs. has been successfully debited and the balance is "+balance+" Rs. and minimum balance is not present in account: "+accNum;
	            }
                else {
                	balance=balance-amount;
                	return balance+" Rs. has been successfully debited and the balance is "+balance+" Rs. in account: "+this.accNum;
                }
	        }
	    }
	    
	    public String credit(Integer amount){ 
	        //write code here to handle crediting(deposit) to an account
	        //update the balance in the hashmap variable Account.accounts 
	        //return ex: "1000 Rs. has been successfully credited and the balance is 2000 Rs. in account: 1234"
	    } 
	} 

	class CurrentAccount extends Account{ 
	    public void setAccountDetails(Person accHolder, Integer accNum, Integer balance){ 
	        //write code here to set the accHolder(account holder),accNum(account number),balance and accountType fields 
	    } 
	        
	    //write a toString() method to to generate account details when the hashmap's "accounts.get(accNum)" method is used to print all the user details in the below format 
	    //"Name : Arjun Age : 21 City : Bangalore Account Number : 12345 Balance : 1000 Account Type : Current" (without quotes) 
	    //write setter and getter methods to set and get balance with return type Integer 
	    
	    public String debit(Integer amount){ //write code here to handle debiting(withdrawal) from an account 
	        //update the balance in the hashmap variable Account.accounts
	        //if the withdrawal amount makes the balance lesser than minimum balance(10000) then return ex: "500 Rs. has been successfully debited and the balance is 9500 Rs. and amount is overdrawn in account: 1234" 
	        //else return ex: "2000 Rs. has been successfully debited and the balance is 13000 Rs. in account: 1234" 
	    } 
	    
	    public String credit(Integer amount){
	        //write code here to handle crediting(deposit) to an account 
	        //update the balance in the hashmap variable Account.accounts 
	        //then return ex: "1000 Rs. has been successfully credited and the balance is 11000 Rs. in account: 1234"
	    } 
	                
	} 
	            
	class Person{ 
	    //declare three variables for name,city and age of a person and also a parameterized constructor 
	 	private String name;
		private String city;
		private int age;
		public Person(String name, String city, int age) {
			super();
			this.name = name;
			this.city = city;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	    
	} 
	 
	 
	public class Source {
	    public static void main(String[] args){
	        //Implement main() function to check your code...
	        //don't remove the main() function you will get error in RUN CODE.
	    }
	}
