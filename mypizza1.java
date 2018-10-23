import java.util.*;
import java.io.*;

class mobileno extends Exception
{
	public mobileno(String s)
	{
		if(s.equals("n"))
			System.out.println("\n Please enter a valid number");
	}
}


interface pizzahut
{
	void reg() throws mobileno, IOException;
	void odr();
	void pymnt();
}

class customer implements pizzahut
{
	String name,add;
	long no;
	int p,size,t1,t2,cost,tcost;
	
	public void reg()throws mobileno, IOException
	{
		Scanner scan = new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter your details below... ");
		System.out.print("Name: ");
		name = br.readLine();
		System.out.print("Address: ");
		add = br.readLine();
	
		System.out.print("Mobile Number: ");
		no = scan.nextLong();
		String n=String.valueOf(no);
				
		try
		{
			if(n.length() != 10)
				throw new mobileno("n");			
		}
		catch(mobileno e)
		{
			System.out.println(e.getMessage());
			System.out.print("Mobile Number: ");
			no = scan.nextLong();
		}  
	}

	public void odr()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("\n\t1. Margherita   2. CheeseCorn \n\t3. FreshVeggie  4. FarmHouse \n\t5. Extravaganza 6. VeggieParadise \n\t7. LoadedVeg ");
		System.out.print("Select your pizza : ");
		p = scan.nextInt();
		

		System.out.println("\t1.Regular - 200 Rs. \n\t2.Medium 300 Rs. \n\t3.Large  - 400 Rs. \nSelect size: ");
		size = scan.nextInt();
		switch(size)
		{
		case 1: cost = 200;
				break;
		case 2: cost = 300;
				break;
		case 3: cost = 400;
				break;
		default: System.out.println("Your pizza will come in medium size....  ");
   				 cost = 300;
				 break;
		}

		System.out.println("1. Black Olive 2. Jalapeno 3. Extra Cheese 4. Red Paprika 5. Grilled Mushroom  ");
		System.out.print("Select extra toppings:  ");
		t1 = scan.nextInt();
		System.out.print("How many toppings you want? 30 rs each:  ");
		t2 = scan.nextInt();
		
		tcost = t2 * 30;
	}
 
	public void pymnt()
	{
		System.out.println("\nThank you for ordering...  Please pay "+ (cost+tcost) + " rs...");
	}
}

public class mypizza1
{
	
	public static void main(String[] args) throws IOException 
	{
		
		pizzahut pz = new customer();
		
		System.out.println("- - - - - - - - - - - - Wel Come to Pizza-Hut - -  - - - - - - - - - -");
	
		try
		{
			pz.reg();
		}
		catch(mobileno e)
		{
			System.out.println(e.getMessage());
		}
		
		pz.odr();
		pz.pymnt();
	}

}

