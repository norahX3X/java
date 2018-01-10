//norah alkhunifer 435201094
import java.util.*;//import from packeg 
class Course {//class name 
public static int totalStudents,i;//diclrition
public static int courseStudents;
public static Student[] students =new Student[25];
public static  int n=0;
static Scanner read=new Scanner (System.in);//to read from user 
   public static void main (String[]args){//main class
   for (i=0;i<students.length;i++){
   students[i]=new Student();}
      int total,id,chose,found,totalstudent;
      String done,want,name;
      double score;
      char grade;
   //menu
      do{
         System.out.println("1/Add a student ");
         System.out.println("2/Remove a student ");
        System.out.println("3/ Find and print the information of a student ");
         System.out.println("4/ List all the students");
         System.out.println("5/ List all the students for a given grade ");//by switch letter case a..
         System.out.println("6/ calculate the lowest, average, highest score in the course.");
         System.out.println("7/total number of students for a given academic advisor.");
          System.out.println("8/ total number of students in the course.");
         chose=read.nextInt();
         switch (chose){//menu prosasing by switch statment
            case 1:
final String mail="@ksu.edu.sa";
     do{
         read.nextLine();
         System.out.println("enter student "+(totalStudents+1)+" id,name,score ,advisor name ");//read and save information in array 
        id =read.nextInt();
          while (!isValidID(""+id)){
            System.out.print("the length of id should be 9 and should contain only positive noumber  try agin");
            id=read.nextInt();}
        name=read.nextLine();
        read.nextLine();
       score= read.nextDouble();
       switch ((int)score/10){//to get grade from user
            case 10: case 9: grade='A';
               break;
            case 8 : grade='B';
               break;
            case 7:grade='C';
               break;
            case 6:grade='D';
               break;
            default : grade='F';}
            read.nextLine();
              if (addStudent(id,name,score,id+mail,grade,read.nextLine())){
       totalStudents++;
n++;
               System.out.println(" the adding is completed successfully");
                }
   else   System.out.println("the adding is dosent complet ");
   System.out.println("   do you want to add other student");
         done=read.next();
        }  while (!done.equals("no")||(done.equals("No")));
               break; 
            case 2:
               System.out.println("enter student id that you want to delet her information");
               if (removeStudent(read.nextInt()))
                  System.out.println("delet compleated");
               else System.out.println("not founde");            
               break;
            case 3:
               System.out.print("enter id for student to find her information");
               findStudentInfo(read.nextInt());
               break;
            case 4:
            if (totalStudents<=0)
            System.out.println("listis empty ");
            printAll();
        break;
            case 5:
            System.out.println("enter grade that you  want see students take it  ");
              printAll(read.next().charAt(0));
               break;
            case 6:
             if (totalStudents<=0)
            System.out.println("listis empty ");
             calculateGrade();
               break;
            case 7 : 
            if (totalStudents<=0)
            System.out.println("listis empty ");
                read.nextLine();
               System.out.print("enter academic advisor name");
              total=NumStudentAdvisor(read.nextLine());
               if (total!=0)
                  System.out.println("nomber of studentes whith  acadimic advisor is "+total);
               else System.out.println("no student with advisor");
               break;    
            case 8: if (totalStudents<=0)
            System.out.println("listis empty ");
               totalstudent=total();
               System.out.println("the total noumber of student is "+totalstudent);
               break;
            default: System.out.println("the nomber you choose it is not avilible ");}
         System.out.println(" do you want other think yes or no");
         want=read.next();}
      while(!(want.equals("no")) ||(want.equals("No")));
   }//end the main 
     public static boolean addStudent ( int id, String name, double score, String email, char grade, String academicAdvisor){//obtion 1
              if (total()==students.length)
               return(false);
               else {
                for(int j=totalStudents-1;-1<j;j--){//chick uniqnis of id !!
            if(findStudent(id)!=-1){
               System.out.println("id is previously existing try agin ");
               System.out.printf("enter student %d id",n+1);
               id=read.nextInt();
               j=totalStudents;}//we dont use totalStudents-1 becose j--
               }
               students[n].SetStudent( id,  name, score, email, grade, academicAdvisor);
               return true;
         }
   }//end of add student
  public static int findStudent(int ID){//find student method 
  for (i=0;i<students.length;i++){
  if (students[i].getID()==ID)
  return (i);
  }
  return(-1);
  }
   public static boolean isValidID(String id){
      if(id.length()!=9)// chick if it 9 digits long
         return(false);
    for(i=0;i<id.length();i++) {//to chick if it from 0-9
         switch(id.charAt(i)){
            case '0' : case '1': case '2': case '3': case '4': case '5':case '6': case '7': case '8': 
              case '9' :
               break;
            default :
               return(false);}
      }
      return (true);
   }
   public static boolean removeStudent(int ID){//obtion 2
   int i;
   if (totalStudents==25)
               return(false);
               else {
               i=findStudent( ID);
         if (i!=-1){
         students[i].SetStudent(-1,"*", -1,  "*",'*', "*");
            return(true);
         }}      return(false);
   }
   public static void findStudentInfo(int ID){//obtion 3
   if (totalStudents<=0)
   System.out.println("the list is empty");
i=findStudent( ID);
          if (i!=-1 ){//by get method
            System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
          students[i].printStudentInfo();
         }
else  System.out.println("not found");
   }
   public static void printAll( ){//obtion 4
read.nextLine();
         for(i=0;i<totalStudents;i++){
students[i].printStudentInfo();
   }
   }//end method print all
   public static void printAll(char grade){//obtion 5 over writing
   for (i=0;i<totalStudents;i++){
   if (Character.toUpperCase(grade)==students[i].getgrade())
   System.out.println("student name"+students[i].getname());}
   /*
      switch (Character.toUpperCase(grade)){
         case 'A':
            for (i=0;i<students.length;i++){//<total of students 
               if (students[i].getgrade()==('A')){
                  System.out.println(students[i].getname());}}
            break;
         case 'B':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('B'))
                  System.out.println(students[i].getname());}
            break;
         case 'C':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('C'))
                  System.out.println(students[i].getname());}
            break;
         case 'D':
          for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('D'))
                  System.out.println(students[i].getname());}
            break;
         case 'F':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('F'))
                  System.out.println(students[i].getname());}
         default :System.out.println("the grade is not exist in KSU");}*/
   }
      public static void calculateGrade(){//obtion 6
       double low = 100,high = 0,sum=0;
       //if total >0
      for (i=0;i < totalStudents;i++){
             if(students[i].getscore()<= low) {
                low =students[i].getscore();
            }
            if(students[i].getscore()> high) {
                high =students[i].getscore();
            }
        }
       System.out.println("the lowest score is  "+low);
      System.out.println("the highest score is  "+high);
      for(i=0;i<students.length;i++)
         sum=sum+students[i].getscore();
      System.out.printf("average score is %.2f",(sum/totalStudents));
      //else no sgrades to culculate
   }
    public static int NumStudentAdvisor(String advisor){//noumber of student with acadimic advisor 7
      int sum=0,j;
      for(j=0;j<students.length;j++){
         if (students[j].getacademicAdvisor().equals(advisor))
            sum++;
      }
      return(sum);
   }
   public static int total (){//obtion 8
      for (i=0;i<students.length;i++){
      if ( students[i].getname().equals("-"))
      return(i);
}
 return(i);
   }
}//end