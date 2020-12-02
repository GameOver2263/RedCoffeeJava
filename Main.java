/* 
*  Welcome to RedCoffee your personal finance manager, website may be found here:  
*  https://gameover2263.github.io/RedCoffee/#
*  Made by: GameOver
*  Finished December 1, 2020.
*/ 

import java.io.*; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;

class Main {

	public static void login()throws Exception{
		Scanner myObj = new Scanner(System.in);
		clear();
		System.out.println("Welcome to RedCoffee, your personal financial manager! Let's start by logging you in!");
		System.out.println("");
		System.out.print("Enter username: ");
		String userName = myObj.nextLine();
		System.out.print("Enter password: ");
		String passName = myObj.nextLine();
        File file = new File("login.txt"); 
         BufferedReader br = new BufferedReader(new FileReader(file));
         String st; 
         while ((st = br.readLine()) != null){
        	if(st.equals(userName)){
				st = br.readLine();
				if(st.equals(passName)){
					System.out.println("");
					System.out.println("Login successful!");
				} else {
					while(!st.equals(passName)){
						clear();
						System.out.println("Welcome to RedCoffee, your personal financial manager! Let's start by logging you in!");
						System.out.println("");
						System.out.println("We found your username, but your password wasn't correct!");
						System.out.println("");
						System.out.println("Enter username: " + userName);
						System.out.print("Enter password: ");
						passName = myObj.nextLine();
					
					}
					System.out.println("");
					System.out.println("Login successful!");
				}
			}
			if((st = br.readLine()) == null){
				System.out.println("");
				System.out.println("Login failed, username not found! (Check Capitilization!)");
				System.exit(0);
		 }
         }
	}


	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void waer() {
		wait(1000);
		clear();
	}

	public static boolean checky(String n){
		if(n.equals("")){
			return false;
		} else if(n == null){
			return false;
		}else if(n.matches("[0-9]+") && n.length() >= 1) {
        	return true;
      	} else {
			return false;
		}
	}

	public static int makesure(long n){
		int max = 2147483646;
		int min = 0;
		if(n >= max){
			n = max-1;
		} else if (n < min){
			n = min;
		}
		int s = (int)n;
		return s;
	}

    public static void main(String[] args)throws Exception{
		float total = 0.0f; 
		float save = 0.0f;
		float savings = 0.0f;
		float three = 0.3f;
		float two = 0.15f;
		float one = 0.05f;
		Scanner myObj = new Scanner(System.in);
		clear();
		login();
		waer();
		System.out.print("Please input your current monthly income: $");
		String salary1 = myObj.nextLine();
		if(checky(salary1) == false){
			if(!salary1.equals("0")){
				while(checky(salary1) == false){
					if(salary1.equals("0")){
						System.out.println("RedCoffee needs a monthly income to give suggested investments.");
						System.exit(0);
					}
				System.out.println("");
				System.out.println("That's not valid!");
				waer();	
				clear();
				System.out.print("Please input your current monthly income: $");
				salary1 = myObj.nextLine();
				}
			}else if (salary1.equals("0")){
				System.out.println("");
				System.out.println("RedCoffee needs a monthly income to give suggested investments.");
				System.exit(0);
			}else if(salary1 < 0){
				System.out.println("");
				System.out.println("RedCoffee needs a valid monthly income to give suggested investments.");
				System.exit(0);
			}
		}
		clear();
		long salary = Long.parseLong(salary1);
		salary = makesure(salary);
		System.out.print("Please input your current debt/loans: $");
		String loans1 = myObj.nextLine();
		if(checky(loans1) == false){
			if(!loans1.equals("0")){
				while(checky(loans1) == false){
					System.out.println("");
					System.out.println("That's not valid!");
					waer();	
					clear();
					System.out.print("Please input your current debt/loans: $");
					loans1 = myObj.nextLine();
				}
			}
		}
		clear();
		long loans = Long.parseLong(loans1);
		loans = makesure(loans);
		String[] cats = {"Auto", "Bills/Utilities", "Education", "Food and Drink", "Gas", "Groceries", "Health", "Personal", "Shopping", "Travel", "Miscellaneous"};
		ArrayList<Float> store = new ArrayList<Float>();
		for(int count = 0; count<=10; count++){
			System.out.println("In the next few questions, please enter the amount of money in USD you spend in that category monthly.");
			System.out.println("");
			System.out.print("How much do you spend in " + cats[count] + ": ");
			String doubl = myObj.nextLine();
			clear();
			if(checky(doubl) == false){
				if(!doubl.equals("0")){
				while(checky(doubl) == false){
					System.out.println("");
					System.out.println("That's not valid!");
					waer();
					System.out.println("In the next few questions, please enter the amount of money in USD you spend in that category monthly.");
					System.out.println("");
					System.out.print("How much do you spend in " + 	cats[count] + ": ");
					doubl = myObj.nextLine();
				}
				}
				clear();
			}
			long num = Long.parseLong(doubl);
			num = makesure(num);
			float num1 = num;
			store.add(num1);
			System.out.println("");
			total = total + num;
		}
		savings = salary - total;
		total = savings + total;
		clear();
		System.out.println("In the next few questions, please enter the rank of importance each category is financially to you. 1 being the most, 2 being average, 3 being least important.");
		System.out.println("");
		ArrayList<Integer> ranks = new ArrayList<Integer>();
		for(int count = 0; count<=10; count++){
			System.out.print("Rank of importance for " + cats[count] + ": ");
			String doubl = myObj.nextLine();
			if(checky(doubl) == false){
			while(checky(doubl) == false){
				System.out.println("");
				System.out.println("That's not valid!");
				waer();	
				System.out.println("In the next few questions, please enter the rank of importance each category is financially to you. 1 being the most, 2 being average, 3 being least important.");
				System.out.println("");
				System.out.print("Rank of importance for " + cats[count] + ": ");
				doubl = myObj.nextLine();
				}
			}
			long num1 = Long.parseLong(doubl);
			int num = makesure(num1);
			if(num<1){
				num = 1;
				System.out.println("Setting rank as 1.");
			} else if(num>3){
				num = 3;
				System.out.println("Setting rank as 3.");
			}
			ranks.add(num);
			clear();
		}
		waer();
		System.out.println("-----------");
		System.out.println("| SAVINGS |");
		System.out.println("-----------");
		System.out.println(" ");
		ArrayList<Float> cave = new ArrayList<Float>();
		for(int count = 0; count<11; count++){
			if(ranks.get(count).equals(3)){
				float num = (store.get(count)*three);
				cave.add(num);
				save = num + save;
			}else if(ranks.get(count).equals(2)){
				float num = (store.get(count)*two);
				cave.add(num);
				save = num + save;
			}else if(ranks.get(count).equals(1)){
				float num = (store.get(count)*one);
				cave.add(num);
				save = num + save;
			}
			float roundit = (float)Math.round((cave.get(count)*100))/100;
			System.out.println("For the " + cats[count] + " category, RedCoffee suggests spending only $" + roundit + ", based off your rank of '" + ranks.get(count) + "'.");
			System.out.println("");
		}
		save = total - save;
		System.out.println("Your total savings are: $" + save + ", which can be used on your total debt of $" + loans + ".");
		if(save<loans){
			System.out.println("");
			System.out.println("Unfortunately, you are currently unable to pay off your debt, but may in the future with RedCoffee!");
		}
		if(save > loans){
			System.out.println(" ");
			System.out.println("Congratulations, you're able to pay off your debt! You will be left with $" + (save - loans) + ".");
		}
  } 
}
