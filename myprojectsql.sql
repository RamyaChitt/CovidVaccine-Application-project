use covid19;

##############Admin table
select * from administration;
#S_n0, VACCINE_NAME, avialable_Vaccine
 #delete from  administration  where S_n0=4;
 #update administration set avialable_Vaccine=150 where VACCINE_NAME='COVISHIELD';
 
# VACCINE_NAME='COVAXIN','COVISHIELD', 'Sputhinik'

# update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='COVAXIN' and  avialable_Vaccine > 0;

update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='COVISHIELD' and  avialable_Vaccine > 0;

update administration set avialable_Vaccine =avialable_Vaccine -1 where VACCINE_NAME='Sputhinik' and  avialable_Vaccine > 0;

#############
#Vaccine Booking table,  Sno int(200) auto_increment primary key ,

drop table Booking;
create table Booking( CandidateName varchar(100) ,aadhar_no bigint(100),Vaccine_name varchar(100),
 status varchar(100), 1st_dose date, 2nd_dose date );

#insert into Booking( CandidateName, aadhar_no,Vaccine_name, status, 1st_dose, 2nd_dose)
# values ('Kavyakumari',347895120640,'COVISHILED','1St DOSE','2021-09-09','2021-11-22');

select * from Booking;
desc Booking;
#Candidate_name, Age, DOB, pincode, Address, email, ph_no, aadhar_no, PWD
################User table
create  table users( Candidate_name varchar(100), Age int(100) not null, DOB varchar(100) , pincode varchar(100), 
Address varchar(100), email varchar(100), ph_no bigint(100) unique   not null, aadhar_no bigint(100) , 
PWD varchar(100) not null,  
constraint pk_users primary key(aadhar_no));

select * from users;
 desc  users;
#DROP TABLE USERS;

insert into users ( Candidate_name, Age, DOB, pincode, Address, email, ph_no, aadhar_no, PWD )
 value('Ramya',22,'1999-08-15',506101,'MHBD','ramya@gmail.com',9988223366,12345689,'ramya');

select * FROM USERS where  aadhar_no='12345689';


#delete from  users where Address='mmm'; 

#show tables;
# for showing vaccine data

select * from administration;

#for showing Registered candidates
select * from users;
desc users;

#it shows slot booking candidates

select * from Booking;