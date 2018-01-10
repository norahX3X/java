/* name nora alkhunifer
id 435201094
*/

import java.util.*;//import from libry 
public class Rigester {static Scanner read =new Scanner(System.in);
public static void main (String[]args)//main class
{String name,email,advisor,coursecode,name2,email2,advisor2,coursecode2;//values 
double id,id2;
int score,score2 ;
char grade,grade2;
System.out.print("enter your course code");//comand 
coursecode = read.next();//read from input divais "user"
System.out.print("enter your name");
name= read.next();
System.out.print("enter your Email");
email= read.next();
System.out.print("enter your  academic advisor");
advisor= read.next();
System.out.print("enter your ID");
id= read.nextDouble();
System.out.print("enter your score from 100 ");
score= read.nextInt();
System.out.print("enter your grade A-F");
grade= read.next().charAt(0);

System.out.println("for athor studint " );
System.out.print("enter your course code");//2ed student  
coursecode2 = read.next();
System.out.print("enter your name");
name2= read.next();
System.out.print("enter your Email");
email2= read.next();
System.out.print("enter your  academic advisor");
advisor2= read.next();
System.out.print("enter your ID");
id2= read.nextDouble();
System.out.print("enter your score from 100 ");
score2= read.nextInt();
System.out.print("enter your grade A-F");
grade2=read.next().charAt(0);


System.out.println
("\t\t\t\tKing Saud University (KSU) -Riyadh");
System.out.println("\t\t\t\t\tFALL 2015/2016");
System.out.println();
System.out.println("\t\t\t\t\tAcademic Advisor:"+advisor+"\t2ed student"+advisor2);
System.out.print("Course Code:\t"+coursecode+"\t2ed student"+coursecode2+"\t\t");
System.out.print("Studentname:"+name+"\t2ed student"+name2+"\n");
System.out.print("Student ID:\t"+id+"\t2ed student"+id2+"\t\t");
System.out.println("Student email:"+email+"\t2ed student"+email2);
System.out.print("Student score:\t"+score+"\t2ed student"+score2+"\t\t");
System.out.println("Student grade:"+grade+"\t2end studint"+grade2);

}}