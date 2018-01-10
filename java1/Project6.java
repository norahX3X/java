//norah alkhunifer 435201094
import java.util.*;//import from packeg 
class Project5{//class name 
 Scanner read=new Scanner (System.in);//to read from user 
   //diclrition
   public static void main (String[]args){//main class
     student[] students =new Student[25];
  int n=0,i;
      boolean add,remov,compleat;
      int total,id,chose,found,totalstudent;
      String nameofh="",want;
      double low,avr,high;
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
      String done;
      boolean valid; 
     do{
         read.nextLine();
         System.out.printf("enter student %d name ",n+1+" ,advisor name"+" ,id"+" ,score");//read and save information in array 
        id =read.nextInt()
        name=read.nextLine()
       score= read.nextDouble()
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
      compleat=addStudent(id,name,score,id+mail,grade,read.nextLine());
   System.out.println("   do you want to add other student");
         done=read.next();
         }
                valid =vid(idar[n]);
         while (!valid){
            System.out.print("the length of id should be 9 and should contain only digits try agin");
            idar[n]=read.nextInt();
            valid =vid(idar[n]);
         }
            n++;
        }  while (!done.equle("no"))
        if (n==24)
         return(true);
      else 
       return(false);
      } 
              if (compleat)
               System.out.println(" the adding is completed successfully");
               else   System.out.println("the adding is dosent complet ");
               break;
            case 2:
               boolean remove;
               System.out.println("enter student id that you want to delet her information");
               id=read.nextInt();
               remove=remove(id);
               if (remove)
                  System.out.println("delet compleated");
               else System.out.println("not founde");            
               break;
            case 3:
               read.nextLine();
               System.out.print("enter academic advisor name");
               nameofh=read.nextLine();
               total=advisor(nameofh);
               if (total!=0)
                  System.out.println("nomber of studentes whith  acadimic advisor is "+total);
               else System.out.println("no student with advisor");
               break;
            case 4:
               System.out.print("enter id for student to find her information");
               id=read.nextInt();
               found= find(id);
               if (found==-1)
                  System.out.println("not found");
               break;
            case 5:
               grades();
               break;
            case 6:
               printall();
               break;
            case 7 :
               samegrade();
               break;
            case 8:
               totalstudent=total();
               System.out.println("the total noumber of student is "+totalstudent);
               break;
            default: System.out.println("the nomber you choose it is not avilible ");}
         System.out.println(" do you want other think yes or no");
         want=read.next();}
      while(!(want.equals("no")) ||(want.equals("No")));
   }//end the main 
   


public static boolean add ( int ID, String name, double score, String email, char grade, String academicAdvisor){//obtion 1
              if (n==24)
               return(false);
                for(int j=n-1;-1<j;j--){//chick uniqnis of id !!
            if(ID==students[j].getID()){
               System.out.println("id is previously existing try agin ");
               System.out.printf("enter student %d id",n+1);
               id=read.nextInt();
               j=n;}//we dont use n-1 becose j--
               else {
               //add
         }
              
   }
  public int findStudent(int ID)//find student method 
  {
  for (i=0;i<students.length;i++){
  if (students[i].getID()==ID)
  return (i);
  }
  return(-1);
  }
   public boolean isValidID(int id){
      int tracenum,flag=0,trace=id;
      if(!(id/1000000000==0))// chick if it 9 digits long
         return(false);
      while (trace!=0) {//to chick if it from 0-9
         tracenum=trace % 10;
         trace=trace/10;
         switch(tracenum){
            case 0 : case 1: case 2: case 3: case 4: case 5:case 6: case 7: case 8: 
              case 9 :
               break;
            default :
               return(false);}
      }
      return (true);
   }
   public boolean removeStudent(String ID)){//obtion 2
      for(i=0;i<students.length;i++){
         if (students[i].getID==id){
         students[i].SetStudent(-1,"*", -1, '*', "*", "*")
            return(true);
         }}
      return(false);
   }
   public int NumStudentAdvisor(String advisor)){//noumber of student with acadimic advisor 3
      int sum=0,j;
      for(j=0;j<students.length;j++){
         if (students[j].getacademicAdvisor().equals(advisor))
            sum++;
      }
      return(sum);
   }
   public void findStudentInfo(String id){//obtion 4
      for(i=0;i<students.length;i++){
          if (students[i].getID==id){//by get method
            System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
            System.out.println("Student name: "+students[i].getName());
            System.out.println("Student ID: "+students[i].getID());
            System.out.println("Email: "+students[i].getemail());
            System.out.println(" score: "+students[i].getscore());
            System.out.println("Grade: "+students[i].getgrade());
            System.out.println("Academic advisor: "+students[i].getAcademicadvisor());
         }
      }
   }
   public void calculateGrade(){//obtion 5
      double num,sum=0;
      for(j=1;j<students.length;j++){
         num=students[j].getscore();
         for(i=j-1;(i>=0)&&(students[i].getscore()>num);i--){
            students[i+1].setscore()=students[i].getscore();}
       students[i+1].setscore()=num;}
      System.out.println("the lowest score is  "+students[0].getscore());
      System.out.println("the highest score is  "+students[24].getscore());
      for(j=0;j<students.length;j++)
         sum=sum+students[j].getscore();
      System.out.printf("average score is %.2f",(sum/25));
   }
   public static void printAll( ){//obtion 6
         for(i=0;i<students.length;i++){
      System.out.println("Student name: "+students[i].getName());
      System.out.println("Student ID: "+students[i].getID());
       System.out.println("Email: "+students[i].getemail())
       System.out.println(" score: "+students[i].getscore());
       System.out.println("Grade: "+students[i].getgrade());
       System.out.println("Academic advisor: "+students[i].getAcademicadvisor());
   }
   }
   public void printAll(char grade){//obtion 7 over writing
      switch (grade){
         case 'A':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('A'))
                  System.out.println(students[i].getName());}
            break;
         case 'B':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('B'))
                  System.out.println(students[i].getName()]);}
            break;
         case 'C':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('C'))
                  System.out.println(students[i].getName());}
            break;
         case 'D':
          for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('D'))
                  System.out.println(students[i].getName());}
            break;
         case 'F':
            for (i=0;i<students.length;i++){
               if (students[i].getgrade()==('F'))
                  System.out.println(students[i].getName());}
         default :System.out.println("raseb");}
   }
   public static int total (){//obtion 8
   int j;
      for (j=0;j<course.length;j++){
      if ( course[j][0].equals(null))
      return(j);
}
 return(j+1);
   }

}//end