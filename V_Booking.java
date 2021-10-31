package SAMPLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class V_Booking {
		/*public static void main (String[] args)  throws Exception{
			Booking("Raghu" ,"123456789001");
		}*/
		
	public static  void Cbooking(String Candidate_name1,String aadhar_no1) throws Exception {
			Connection con=ConnectionDb.getCon();
			System.out.println(" connecting  to user  data base");
			String name =Candidate_name1;
			String No =aadhar_no1;
			PreparedStatement ps1=con.prepareStatement("select * from Booking where CandidateName=? and aadhar_no=?");  
			ps1.setString(1,Candidate_name1);
			ps1.setString(2,aadhar_no1);  
			      
			ResultSet rsb=ps1.executeQuery();
			
			if(rsb.next()) {
				System.out.println("*Candidate already Booked a Slot");
				//CandidateName, aadhar_no, Vaccine_name, status, 1st_dose, 2nd_dose
				System.out.println(rsb.getString(1)+" "+rsb.getString(2)+" "+rsb.getString(3)+" "+rsb.getString(4)+" " +rsb.getDate(5)+" "+rsb.getDate(6)+" ");
			}
			else {
				
				System.out.println("choose options  1.COVAXIN 2.COVISHIELD 3.Sputhinik ");
				
				//it updates the vaccines accroding to user chosen option
				Admin.update_vaccine( );
				
				//method for booking slot date
				DateSlot.Date_slot();
				System.out.println("pealse enter details agian to book time slots");
				Booking(name,No);
				System.out.println("you have completed your registation process!...");
				System.out.println();
				/* Application no logic*/
				 Application_Num.app();
			}
		}
			
			
			
		public static void  Booking(String name , String no) throws Exception {
			Connection con=ConnectionDb.getCon();
			//System.out.println(" connecting  to   vaccine stock ");
			Scanner sc=new Scanner(System.in);
			// System.out.println("enter name ");
			 String  vaccinename = null,staus = null;
			 //int aa_no =0;
			//Sno, CandidateName, aadhar_no, Vaccine_name, status, 1st_dose, 2nd_dose

			 int sno =0;
			// System.out.println("name");
			String name1 =name;
			 //sc.next();
			// System.out.println("AA");
			 String aa_no =no;
			// sc.nextLine();
			 System.out.println("vaccine name 1.COVAXIN 2.Covishiled 3.sputhinik");
			 int n = sc.nextInt();
			 
			 switch (n) {
			 case 1 :
				 System.out.println("Avialble time slots are  1.10AM-1PM  2. 2PM-5PM");
				 short c=sc.nextShort();
				 	//For time slots;	
				 	switch(c) {
			 		case 1:
			 			System.out.println("you are choosen time slot 10AM-1PM");
			 			break;
			 		case 2:
			 			System.out.println("you are choosen time slot 2PM-5PM ");
			 			break;
			 			}
				 vaccinename = "COVAXIN";
				 break;//case1 end 
				 
			 case 2: 
				 System.out.println("Avialble time slots are  1.10AM-1PM  2. 2PM-5PM");
				 short c1=sc.nextShort();
				 	//For time slots;	
				 	switch(c1) {
			 		case 1:
			 			System.out.println("you are choosen time slot 10AM-1PM");
			 			break;
			 		case 2:
			 			System.out.println("you are choosen time slot 2PM-5PM ");
			 			break;
			 			}
				 vaccinename="Covishiled";
				 break;//case 2 end
			 case 3:
				 System.out.println("Avialble time slots are  1.10AM-1PM  2. 2PM-5PM");
				 short c3=sc.nextShort();
				 	//For time slots;	
				 	switch(c3) {
			 		case 1:
			 			System.out.println("you are choosen time slot 10AM-1PM");
			 			break;
			 		case 2:
			 			System.out.println("you are choosen time slot 2PM-5PM ");
			 			break;
			 			}
				 vaccinename ="sputhinik";
				 break;//case 3 end
			 }
			sc.nextLine();
			 System.out.println("status");
			 staus=sc.nextLine();
			 
			 System.out.println("enter  1st slot date format to yyyy-MM-dd");
			 String d1 = sc.next();
			 
			System.out.println("enter  2nd slot date format yyyy-MM-dd");
			 String d2 = sc.next();
			 
			 SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date f_d=sd1.parse(d1);
			 
			 long ms =f_d.getTime();
			 java.sql.Date s_f_d=new java.sql.Date(ms);
			 
			 SimpleDateFormat sd11 = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date f_d1=sd11.parse(d2);
			 
			 long ms1 =f_d1.getTime();
			 java.sql.Date s_f_d1=new java.sql.Date(ms1);
			 
			 System.out.println(" connecting  to Admin   data base");
				
				
			//Sno, CandidateName, aadhar_no, Vaccine_name, status, 1st_dose, 2nd_dose
				try { 
					PreparedStatement ps1 = con.prepareStatement("insert into Booking( CandidateName, aadhar_no,Vaccine_name, status, 1st_dose, 2nd_dose) values(?,?,?,?,?,?)");
					ps1.setString(1,name);
					ps1.setString(2, aa_no);
					ps1.setString(3,vaccinename);
					ps1.setString(4,staus);
					ps1.setDate(5,s_f_d);
					ps1.setDate(6,  s_f_d1);
					
					int i1=ps1.executeUpdate();  
					if(i1>0) {  
					System.out.print("You are Booking details sucessfully saved in Admin portal... Thank u !");  
					      }   
					
					else {
						System.err.print("Sorry Book  Again ...");
						
					}
				}catch(Exception e) {
					System.out.println("entere inccorrect values"+e);
				}
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		}
}
