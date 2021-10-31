package SAMPLE;


import java.util.Scanner;

public class Landing_covidportal   {

	public static void main(String[] args) throws Exception {
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		 System.out.println("WELCOME TO COVID19 Portal");
		 System.out.println("-------------------------------------------------------------------------------------------------------");
		   Scanner sc=new Scanner(System.in); 
		System.out.println("Hello");   
		

		System.out.println("Choose options to perform Operations    \n 1.Admin 2.User 0.Exit  ");
			String digit = sc.nextLine();
			
			/* while(true) { */
				
			switch (digit){
			case "1":
				//admin();
				Admin.admin();
				System.out.println("-----------------------------------------------------------------------------------------------------");
				System.out.println();
				
				chain();
				break;
				
			case "2":
				//user portal
				System.out.println("------------------------**************************************************-----------------------------------------------");
				System.out.println("WELCOME TO COVID19 User Portal"); 
				System.out.println("------------------------**************************************************-----------------------------------------------");
				System.out.println("pelase wait coneectiong to Database..!"); 
				System.out.println(" ");
				System.out.println("please fill all details to complete Registration "); 
				
				User.user();//'COVAXIN''COVISHIELD''Sputhinik'
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				
				//select date to vaccine 
				chain();
				break;
				
			case "0" :
				System.out.println("Exit  from operation");
				System.out.println("------------------------");
				System.out.println();
			//	chain();
				
				
				default:
					chain();
					
			}
			
			
		
				
			
	}
	
	public static void chain() throws Exception {
		//chain process for repating process
		System.out.println("Choose options to perform Operations    \n 1.Admin 2.User 0.Exit  ");
		Scanner sc =new Scanner(System.in);
		String digit = sc.nextLine();
		
		
			
		switch (digit){
		case "1":
			//admin();
			
			Admin.admin();
			System.out.println("------------------------");
			System.out.println();
			 
			chain();
			break;
			
		case "2":
			
			System.out.println("------------------------***********************-----------------------------------------------");
			System.out.println("WELCOME TO COVID19 User Portal"); 
			System.out.println("------------------------**********************------------------------------------------------");
			
			System.out.println(" ");
			System.out.println("please fill all details to complete Registration "); 
			User.user();//'COVAXIN''COVISHIELD''Sputhinik'
			System.out.println("------------------------");
			System.out.println();
			
			//select date to vaccine 
			chain();
			break;
			
		case "0" :
			System.out.println("Exit  from operation");
			System.out.println("------------------------");
			System.out.println();
			chain();
			
			
			
				
		}
		
	
	
	}

}
