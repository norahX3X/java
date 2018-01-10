//norah alkhunifer  435201094
import java.util.*;//import from libry 
public class Project2//class name
{static Scanner read=new Scanner (System.in);
public static void main (String[]args){
String course,name1st,name2ed,advisor,fullname,email,level,mail,emailid,id,course2,name1st2,name2ed2,advisor2,fullname2,email2,level2,emailid2,id2;//diclerd
double score,score2;
int graduate,level1,graduate2,level12 ;
char grade,grade2 ;
boolean freshman,sophomore,senior,junior,vemail,freshman2,sophomore2,senior2,junior2,vemail2;
System.out.print("enter frist name");//read from user
name1st=read.next();
System.out.print("enter second mame");
name2ed=read.next();
System.out.print("enter course code such as csc111");
course=read.next();
System.out.print("enter the acadimic advisor");
advisor=read.next();
System.out.print("enter the ID fro 9 number");
id=read.next();
System.out.print("enter score of 100");
score=read.nextDouble();
System.out.print("enter grade A-F");
grade=read.next().charAt(0);
mail=("@ksu.edu.sa");//divine
course=course.toUpperCase();//to make it capital letter 
fullname=name1st.concat(name2ed);//to + with ech other 
email=id+mail;
email=email.toUpperCase();
emailid=email.substring(0,9);
vemail=emailid.equals(id);
level=course.substring(5);//to get level form course 
level1=Integer.parseInt(level);// to use it as integer 
graduate=10-level1;// to now how many still to graduate 
freshman=(level1>=1)&&(level1<=2);
sophomore=(level1>=3)&&(level1<=5);
junior=(level1>=6)&&(level1<=8);
senior=(level1>=9)&&(level1<=10);//boolean take level then ><=.with numbers

System.out.print ("for other student ");//for other studint to prin it out 
System.out.print("enter frist name");//read from user
name1st2=read.next();
System.out.print("enter second mame");
name2ed2=read.next();
System.out.print("enter course code such as csc111");
course2=read.next();
System.out.print("enter the acadimic advisor");
advisor2=read.next();
System.out.print("enter the ID fro 9 number");
id2=read.next();
System.out.print("enter score of 100");
score2=read.nextDouble();
System.out.print("enter grade A-F");
grade2=read.next().charAt(0);
course2=course2.toUpperCase();//to make it capital letter 
fullname2=name1st2.concat(name2ed2);//to + with ech other 
email2=id2+mail;
email2=email2.toUpperCase();
emailid2=email2.substring(0,9);
vemail2=emailid2.equals(id2);
level2=course2.substring(5);//to get level form course 
level12=Integer.parseInt(level2);// to use it as integer 
graduate2=10-level12;// to now how many still to graduate 
freshman2=(level12>=1)&&(level12<=2);
sophomore2=(level12>=3)&&(level12<=5);
junior2=(level12>=6)&&(level12<=8);
senior2=(level12>=9)&&(level12<=10);//boolean take level then ><=.with numbers
//final form
System.out.println("\t\t\t\tKing Saud University (KSU) -Riyadh");//print like form 
System.out.println("\t\t\t\t\tFALL 2015/2016");
System.out.println("\t\t\t\tfrist studint informasion ");
System.out.println();
System.out.print("Course Code:"+course+"\t\t");
System.out.println("Academic Advisor:\""+advisor+"\"");//print
System.out.print("Student ID:"+id+"\t\t");
System.out.print("Studentname:"+fullname+"\n");
System.out.printf("Student score:%.1f",score);// just one noumber after point  
System.out.println("\t\tStudent grade:"+grade);
System.out.print ("Valid Email:"+vemail);
System.out.println("\t\tStudent email:"+email);
System.out.print("Student Level:"+level1);//level from cours code
System.out.println("\t\tNumber of Levels to Graduate:"+graduate);//levels to graduate
System.out.print("Freshman:"+freshman);
System.out.println("\t\tSophomore:"+sophomore);
System .out.print("Junior:"+junior);
System.out.print("\t\tSenior:"+senior);//4 catogry 
//for othe studint
System.out.println("\t\t\tKing Saud University (KSU) -Riyadh");//print like form 
System.out.println("\t\t\t\t\tFALL 2015/2016");
System.out.println("\t\t\t\tsecond studint informasion ");
System.out.println();
System.out.print("Course Code:"+course2+"\t\t");
System.out.println("Academic Advisor:\""+advisor2+"\"");//print
System.out.print("Student ID:"+id2+"\t\t");
System.out.print("Studentname:"+fullname2+"\n");
System.out.printf("Student score:%.1f",score2);// just one noumber after point  
System.out.println("\t\tStudent grade:"+grade2);
System.out.print ("Valid Email:"+vemail2);
System.out.println("\t\tStudent email:"+email2);
System.out.print("Student Level:"+level12);//level from cours code
System.out.println("\t\tNumber of Levels to Graduate:"+graduate2);//levels to graduate
System.out.print("Freshman:"+freshman2);
System.out.println("\t\tSophomore:"+sophomore2);
System .out.print("Junior:"+junior2);
System.out.print("\t\tSenior:"+senior2);//4 catogry 
}}//end 
