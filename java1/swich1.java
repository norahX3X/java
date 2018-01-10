//norah alkunifer 435201094
import java.util.*;//import from packeg 
class Project3{//class name 
static Scanner read=new Scanner (System.in);//to read from user 
public static void main (String[]args){//main class
String code,name,advisor,code2,name2,advisor2,advisorname,mail="@ksu.edu.sa";
int id,choose,id2,studentid,lengthid,lengthid2;//diclrition
double score,score2;
char grade,grade2;
boolean vid,vcode,vscore,vid2,vcode2,vscore2;
System.out.print("enter course code for student 1");//read form user to student 1
code=read.next();
System.out.print("enter student ID");
id=read.nextInt();
System.out.print("enter student name");
name=read.nextLine();
read.nextLine();
System.out.print("enter course score (out of 100)");
score=read.nextDouble();
System.out.println("enter Student academic advisor");
advisor=read.nextLine();
read.nextLine();
System.out.println("enter course code for student 2");//student2
code2=read.next();
System.out.println("enter student ID");
id2=read.nextInt();
System.out.println("enter student name");
name2=read.nextLine();
read.nextLine();
System.out.println("enter course score (out of 100)");
score2=read.nextDouble();
System.out.println("enter Student academic advisor");
advisor2=read.nextLine();
read.nextLine();
//chick vildity 
vid=9==(lengthid=String.valueOf(id).length());//!!
vcode=6==(code.length());
vscore=(0<=score)&&(100<=score);//try to but 1and 2in one statmint 
vid2=9==(lengthid2=String.valueOf(id).length());
vcode2=6==(code.toString().length());
vscore2=(0<=score)&&(100<=score);
System.out.print(vid);
System.out.print(vid2);
if((vid=false)&&(vid2=false)&&(vcode=false)&&(vcode2=false)&&(vscore=false)&&(vscore2=false))
System.out.print("some thing rong in id or score or code please try agin");
else
//menu
System.out.println("1/ Compare the levels of the two students");
System.out.println("2/ Print the minimum course score");
System.out.println("3/ Print the maximum course score");
System.out.println("4/ Print the average course score");
System.out.println("5/ number of students supervised by each academic advisor");
System.out.println("6/  Print a student’s information");
choose=read.nextInt();
switch (choose){
case 1:
if ((code.charAt(3))==(code2.charAt(3)))//=becose ots int 
System.out.print("the students are on the same level ");
else System.out.print("the students are not on the same level ");
break;
case 2:
if (score>score2)
System.out.print("the minimum score is "+score2);
else if (score<score2)
System.out.print("the minimum score is "+score);
else System.out.print("the scores are equals");
break;
case 3:
if (score>score2)
System.out.print("the maximum score is "+score);
else if (score<score2)
System.out.print("the maximum score is "+score2);
else System.out.print("the scores are equals");
break;
case 4:
System.out.print((score+score2)/2);
break;
case 5:
System.out.print("enter student advisor");
advisorname=read.nextLine();
read.nextLine();
if ((advisor.equals(advisorname))&&(advisor2.equals(advisorname)))
System.out.print("she is has tow students");
else if ((advisor.equals(advisorname))||(advisor2.equals(advisorname)))
System.out.print("she is has one students");
else System.out.print("she is has no students");
break;
case 6:
System.out.print("enter student ID ");
studentid=read.nextInt();
if (studentid==id)
{System.out.println("Student name :"+name);
System.out.println("Student ID:"+id);
System.out.println("Student email"+(id+mail));//!!
System.out.println("course code: "+code);
switch ((int)score/10){
case 10: case 9: grade='A';break;
case 8 : grade='B';break;
case 7:grade='C';break;
case 6:grade='D';break;
default : grade='F';}
System.out.println("Course grade:"+grade);
System.out.printf("Course score :%2.0f%n",score);
System.out.println("Academic advisor:"+advisor);
System.out.println("Student level:"+(code.charAt(3)));}
else if (studentid==id2)
{System.out.println("Student name :"+name2);
System.out.println("Student ID:"+id2);
System.out.println("Student email"+(id2+mail));
System.out.println("course code: "+code2);
switch ((int)score2/10){
case 10: case 9: grade2='A';break;
case 8 : grade2='B';break;
case 7:grade2='C';break;
case 6:grade2='D';break;
default : grade2='F';}
System.out.println("Course grade:"+grade2);
System.out.printf("Course score :%2.0f",score2);
System.out.println("Academic advisor:"+advisor2);
System.out.println("Student level:"+(code2.charAt(3)));}
else System.out.print ("the ID is not not found");
break;
default: System.out.print("the nomber you choose it is not avilible ");}
}}//end