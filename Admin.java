package SAMPLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

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
public class Admin {

	/*public static void main(String[] args) throws Exception{
		update_vaccine( );
	}*/
	
	public static void admin() throws Exception{
		System.out.println("------------------------");
		 System.out.println("WELCOME TO Admin  Portal");
		 System.out.println("------------------------");
		 Scanner sc=new Scanner(System.in);
		 System.out.println("---------------*************Login***************-------------");
	
			
			  System.out.println("Enter  Admin Name:"); String admin =sc.nextLine();
			  System.out.println("Enter Login password"); String login_id =sc.nextLine();
			  
			  if(login_id.equalsIgnoreCase("Admin")) {
			 
				  System.out.println("Login Sucess");
				  System.out.println("Welcome "+admin+" to the Admin Section ");
				  System.out.println();
				  System.out.println("perform Admin table operations   ");
				  System.out.println();
				  //System.out.println("do u want to  to exit ,\n press 0)");
				  System.out.println(" To Use Administration operation Press below options.\n\n 1.Insert vaccines 2.View vaccine stock \n\n 3.View Registered candidates for vacination  4.Booking candidates view ");
				  int values =sc.nextInt();


				  Connection con=ConnectionDb.getCon();
				  System.out.println("Got connected with Covid19 vaccination  Database");



				  switch(values) {


				  case 1 :

					  System.out.println("enter sno ");
					  int S_n0 =sc.nextInt();
					  sc.nextLine();
					  System.out.println("enter vaccine name ");
					  String VACCINE_NAME=sc.nextLine();

					  System.out.println("enter avialbe vaccines");
					  int avialable_Vaccine= sc.nextInt();

					  PreparedStatement a1=con.prepareStatement("insert into administration values(?,?,?)");
					  a1.setInt(1,S_n0);  
					  a1.setString(2,VACCINE_NAME);  
					  a1.setInt(3,avialable_Vaccine);  

					  int i=a1.executeUpdate();  
					  if(i>0) {  
						  System.out.print("You are successfully inserted...");  
					  }


					  break;//Admin case1

				  case 2:
					  sc.nextLine();

					  System.out.print("Avialable vaccine data..."); 
					  System.out.println();
					  Statement stmt =con.createStatement();
					  ResultSet rs =stmt.executeQuery("select* from administration" );

					  while(rs.next()) {
						  System.out.println(rs.getInt("S_n0")+"\t"+rs.getString("Vaccine_Name")+"\t\t\t "+rs.getInt("avialable_Vaccine"));

					  }
					  break;

				  case 3:
					  sc.nextLine();

					  System.out.print("\n\nregistered candidate vaccine data..."); 
					  System.out.println();
					  Statement stmt1 =con.createStatement();
					  ResultSet rs1 =stmt1.executeQuery("select* from users " );
					  //Candidate_name, Age, DOB, pincode, Address,																									 email, ph_no, aadhar_no, PWD
					  while(rs1.next()) {

						  System.out.println(rs1.getString("Candidate_name")+"\t "+rs1.getInt("Age")+"\t "+rs1.getString("DOB")+"\t "+rs1.getString("pincode")+"\t "+rs1.getString("Address")+"\t "+rs1.getString("email")+"\t "+rs1.getString("ph_no")+"\t "+rs1.getString("aadhar_no")+"\t "+rs1.getString("PWD")+"\t ");

					  }
					  break;
				  case 4:
					  sc.nextLine();

					  System.out.print("\n\n  SLot Booking candidates data..."); 
					  System.out.println();
					  Statement stmt2 =con.createStatement();
					  ResultSet rs2 =stmt2.executeQuery("select* from Booking " );
					  //Candidate_name, Age, DOB, pincode, Address,																									
					  while(rs2.next()) {
						  //CandidateName, aadhar_no, Vaccine_name, status, 1st_dose, 2nd_dose
						  System.out.println(rs2.getString("CandidateName")+"\t "+rs2.getString("aadhar_no")+"\t "+rs2.getString("Vaccine_name")+"\t "+rs2.getString("status")+"\t "+rs2.getDate("1st_dose")+"\t "+rs2.getDate("2nd_dose")+"\t ");

					  }
					  break;

				  case  0 :
					  System.out.println("exit");
					  //con.close();

					  break;//Admin case2
				  }  
		}
		 
			else {
				 System.err.println("Sorry your Login UnSucess please enter valid password");
			 }
	} 			
 
	// these methods check login detalis matching to the data base or not
public static void check_user( String Candidate_name1,String aadhar_no1) throws Exception {
		
							Connection con=ConnectionDb.getCon();
				String Name =Candidate_name1;
				String AA=aadhar_no1;
				System.out.println(" connecting  to user  data base");
				PreparedStatement ps=con.prepareStatement("select * from users where Candidate_name=? and aadhar_no=?");  
				ps.setString(1,Name);
				ps.setString(2,AA);  
				      
				ResultSet rs=ps.executeQuery();  
				
			
				if(rs.next()) {
					System.out.println("Login sucess full....\n Your Details");
					System.out.println();
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" ");
				System.out.println();
				/* BOOKING VACCINE CHECK LOGIC*/
				V_Booking.Cbooking(Name,AA);
				System.out.println();
				
				/* Application no logic
				 Application_Num.app();
			     */
				System.out.println("Maintain Social distance and dont forget to wear a Mask... \n\t stay safe take care.. "+Candidate_name1);
				}
				else {
					System.out.println("entered details not matched ");
					System.err.print("please register first.... \n Try again.....!");
					//To repeat the process
					Landing_covidportal.chain();
				}
				
				
				
	
}
//these method updates vacines count accoridng to user choosen options

public static void update_vaccine( ) throws Exception {
		Connection con=ConnectionDb.getCon();
			System.out.println(" connecting  to   vaccine stock ");
			Scanner sc=new Scanner(System.in);
		 String ch =sc.next();
		switch(ch) {
		
		case "1":
			PreparedStatement a1=con.prepareStatement("update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='COVAXIN' and  avialable_Vaccine > 0");
			int i=a1.executeUpdate();  
			if(i>0) {  
			System.out.println("You are choosen option 1 'COVAXIN'...");  
			}
			else {
				System.out.print("Sorry vaccine stock not avialable ..."); 
			}
			break;
			
		case "2":
			PreparedStatement a11=con.prepareStatement("update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='COVISHIELD' and  avialable_Vaccine > 0");
			int i1=a11.executeUpdate();  
			if(i1>0) {  
			System.out.print("You are choosen option 2 'COVISHIELD'...");  
		
		
			}
			else {
				System.out.print("Sorry vaccine stock not avialable ..."); 
			}
			break;
		case "3":
			//Sputhinik
			PreparedStatement a111=con.prepareStatement("update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='Sputhinik' and  avialable_Vaccine > 0");
			int i11=a111.executeUpdate();  
			if(i11>0) {  
			System.out.print("You are choosen option 3 'Sputhinik'...");  
			
			
			}
			else {
				System.out.print("Sorry vaccine stock not avialable ..."); 
			}
			break;
			
		}
	}
}
