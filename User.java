package SAMPLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Pattern;
public class User {

	/*public static void main(String[] args) throws Exception {
		user();

	}*/
	public static void user() throws Exception,SQLException{
		try {
			System.out.println("please wait conectiong to Database..!"); 
		 System.out.println("WELCOME TO USER  Portal");
		 Scanner sc=new Scanner(System.in);
		 
			
			Connection con=ConnectionDb.getCon();
			System.out.println(" connected with user data base");
			
			System.out.println(" press 1. Registration 2.Booking slot ");
			int steps =sc.nextInt();
			//Candidate_name, Age,DOB , pincode, Address, email, ph_no, aadhar_no, PWD, 
	
			switch(steps) {
			
			case 1: //Registeration 
				System.out.println("performing Registration  operation   ");
				String  Candidate_name = null;
				String email = null;
				String ph_no = null;
				String aadhar_no = null;
				int Age = 0;
				String mail=null;String phno=null;String AAno=null;
				String  DOB=null, pincode=null,Address=null,PWD = null;
				
				System.out.println("enter Candidate_name ");
					String name =sc.next();
					boolean b =Pattern.matches("[A-Za-z]{2,}", name);
					
					 		if(b==true) {
								 Candidate_name= name;
								System.out.println(" proper name...");
								
								System.out.println("enter Person_Age ");
								// sc.next();
									Age = sc.nextInt();
								
							}
							else {System.err.println("please enter name in   proper way ");}
							 
					 		
								if(Age>=18) {
									System.out.println(" you can go for vaccine ");
									
									System.out.println("enter DOB in yyyy-mm-dd ");
									 DOB =sc.next();
									 
									 System.out.println("enter  valid 6-digits pincode ");
									 pincode =sc.next();
								
								}
									else {System.err.println(" not eligble for vaccine ");}
								
								 boolean b11 =Pattern.matches("[1-9]{1}+[0-9]{5}", pincode); 
								 if(b11==true)
								 {
									 System.out.println("vaild pincode");
									 
									 System.out.println("enter  Address ");
									 Address =sc.next();
									 
									 System.out.println("enter email address xxxx@gmail.com  ");
									 mail =sc.next();
								 }
								 
								 else System.err.println("Please enter a valid pincode");
								
								 		boolean b1=Pattern.matches("[a-zA-z0-9]*+[@]+gmail.com", mail);
										if(b1==true) {
											email= mail;
											System.out.println("valid email");
											
											System.out.println("enter 10 digits valid  ph_no  ");
											phno =sc.next();//[1-9]{1}+[0-9]{5}
										}
										else System.err.println("please register with valid email address");
										
										boolean b2=Pattern.matches("[6789]{1}+[0-9]{9}", phno);
											if(b2==true) {
												 ph_no=phno;
												System.out.println("valid phone number ");
												
												 System.out.println("enter  valid 12-digits aadhar_no  ");
												  AAno =sc.next();
											}
									else System.err.println("pelase register with valid phone number");
									
											boolean b3=Pattern.matches("[1-9]{1}+[0-9]{11}", AAno);
											if(b3==true) {
													aadhar_no=AAno;
													System.out.println(" valid Addhar no ");
													
													System.out.println("enter PWD  ");
													 PWD =sc.next();
										}
									else System.err.println("pelase enter valid aadhar number");
					try {
				 
					PreparedStatement ps1=con.prepareStatement("insert into  users values(?,?,?,?,?,?,?,?,?)");
					//Candidate_name, Age,DOB , pincode, Address, email, ph_no, aadhar_no, PWD
					if(Candidate_name!=null) {
					ps1.setString(1,Candidate_name);
					}
					if(Age>=18) {
						ps1.setInt(2,Age);  
					
					}if(DOB!=null) {
					ps1.setString(3,DOB); 
					}
					if(  pincode!= null) {
					ps1.setString(4,pincode); }
					if(Address!= null) {
					ps1.setString(5,Address); }
					if(email!=null) {
					ps1.setString(6,email);}
					if(ph_no!=null) {
					ps1.setString(7,ph_no); }
					if(aadhar_no!=null) {
					ps1.setString(8,aadhar_no); }
					if(PWD!=null) {
					ps1.setString(9,PWD);
					}else {
						System.err.println("please fill all details as correct mentoned in your addhar card");
					}
					//78965421315
					
					int i1=ps1.executeUpdate();  
					if(i1>0) {  
					System.out.print("You are successfully Register...");  
					      }   
					
					else {
						System.err.print("Sorry Register Again ...");
					}
					}catch(NullPointerException e ) {
						System.err.println("please fill all detais in proerway \n\n as per mentoned in your addhar card ");
					}
					
				break;
				
			case 2: //to book slot
				
				System.out.println("hey login to Book your vaccine slot ...");
				
				System.out.println("Enter userName");
				String Candidate_name1 = sc.next();
				
				System.out.println("Enter aadhar no");
				String aadhar_no1 = sc.next();
				//checking in Adiminstrator user Booked a slot or not
				//V_Booking.
				//cheching user details
				Admin.check_user(Candidate_name1, aadhar_no1);
				
				
			break;
			
				
			}		
			
			
			con.close();	
	}catch(Exception e1) {
		System.out.println(" please fill all mandatory record as per Aadhar\n Try agian.....! ");
	}
				
	}
					
}
			
			
				

	

