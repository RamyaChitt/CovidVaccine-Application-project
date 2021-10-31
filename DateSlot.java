package SAMPLE;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

public class DateSlot {

	
	//public static void main(String[] args) {
	public static void Date_slot() {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter 1.Covaxin ,2.Covishiled,3.sputhink too book date slots ");
		
		String option =sc.nextLine();
		switch(option) {
		case "1": //1.Covaxin
		System.out.println("enter current/Today's  date format to book slot yyyy-MM-dd");
		
		String d = sc.nextLine();
		LocalDate d1= LocalDate.parse(d);
		
		System.out.println("After how many days u r choosing to book slots please enter only days");
		 int Days = sc.nextInt(); 
		
		 d1=d1.plusDays(Days);
		System.out.println("your  Dose1 vaccination date is\t"+d1+"\n\n Consult your near local area hospital");
		
		System.out.println("Your  next dose2 to will be\t"+d1.plusDays(30));
		break;
		
		case "2": //2.Covishiled
			System.out.println("enter current/Today's  date format to book slot yyyy-MM-dd");
			
			String d2 = sc.nextLine();
			LocalDate d11= LocalDate.parse(d2);
			
			System.out.println("After how many days u r choosing to book slots please enter only days");
			 int Day = sc.nextInt(); 
			
			 d11=d11.plusDays(Day);
			System.out.println("your  Dose1 vaccination date is\t"+d11+"\n\n Consult your near local area hospital");
			
			System.out.println("Your  next dose2 to will be\t"+d11.plusDays(84));
			break;
			
			
			
		case "3": //2.Covishiled
			System.out.println("enter current/Today's  date format to book slot yyyy-MM-dd");
			
			String d3 = sc.nextLine();
			LocalDate d13= LocalDate.parse(d3);
			
			System.out.println("After how many days u r choosing to book slots please enter only days");
			 int Day1 = sc.nextInt(); 
			
			 d13=d13.plusDays(Day1);
			System.out.println("your  Dose1 vaccination date is\t"+d13+"\n\n Consult your near local area hospital");
			
			System.out.println("Your  next dose2 to will be\t"+d13.plusDays(45));
			break;
		}

	}

}


