//norah alkhunifer 435201094
import java.util.*;//import from packeg 
class Project5{//class name 
   static Scanner read=new Scanner (System.in);//to read from user 
   static int []idar=new int[25];//diclrition
   static double[]score=new double[25];
   static String[][]course=new String[25][3];
   static char []grade=new char [25];
   static int n=0;
   public static void main (String[]args){//main class
      boolean add,remov,compleat;
      int total,id,chose,found,totalstudent;
      String nameofh="",want;
      double low,avr,high;
   //menu
      do{
         System.out.println("1/Add a student to the set of students in the course.");
         System.out.println("2/Remove a student from the set of students in the course.");
         System.out.println("3/total number of students for a specific academic advisor.");
         System.out.println("4/ Find and print the information about a student given her ID.");
         System.out.println("5/ Find information about the lowest, average, highest score in the course.");
         System.out.println("6/  Print all the students");
         System.out.println("7/ Print all the students with the same letter grade ");//by switch letter case a..
         System.out.println("8/  Count the total number of students in the course.");
         chose=read.nextInt();
         switch (chose){//menu prosasing by switch statment
            case 1:
              compleat=add();
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
   public  static boolean add ( ){//obtion 1
         final String mail="@ksu.edu.sa";
      boolean valid;
      String done;
      if (n==24)
      return(false);
      else {
      while(n<course.length){
         read.nextLine();
         System.out.printf("enter student %d name ",n+1);//read and save information in array 
         course[n][0]=read.nextLine();
         System.out.printf("enter student %d advisor name",n+1);
         course[n][1]=read.nextLine();
         System.out.printf("enter student %d id",n+1);
         idar[n]=read.nextInt();
         for(int j=n-1;-1<j;j--){//chick uniqnis of id !!
            if(idar[n]==idar[j]){
               System.out.println("id is previously existing try agin ");
               System.out.printf("enter student %d id",n+1);
               idar[n]=read.nextInt();
               j=n;}//we dont use n-1 becose j--
         }
         valid =vid(idar[n]);
         while (!valid){
            System.out.print("the length of id should be 9 and should contain only digits try agin");
            idar[n]=read.nextInt();
            valid =vid(idar[n]);
         }
         System.out.printf("enter student %d score",n+1);
         score[n]=read.nextDouble();
         switch ((int)score[n]/10){//to get grade from user
            case 10: case 9: grade[n]='A';
               break;
            case 8 : grade[n]='B';
               break;
            case 7:grade[n]='C';
               break;
            case 6:grade[n]='D';
               break;
            default : grade[n]='F';}
         course[n][2]=idar[n]+mail;
         n++;
        } 
        if (n==24)
         return(true);
      else 
       return(false);
      } 
   }
   public static boolean vid( int id ){
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
   public static boolean remove (int id){//obtion 2
      int j;
      for(j=0;j<course.length;j++){
         if (idar[j]==id){
            course[j][0]="*";
            course[j][1]="*";
            course[j][2]="*";
            idar[j]=-1;
            score[j]=-1;
            grade[j]='*';
            return(true);
         }}
      return(false);
   }
   public static int advisor (String adname){//noumber of student with acadimic advisor 3
      int sum=0,j;
      for(j=0;j<course.length;j++){
         if (course[j][1].equals(adname))
            sum++;
      }
      return(sum);
   }
   public static int find (int id){//obtion 4
      int j,flag=0;
      for(j=0;j<course.length;j++){
         if (idar[j]==id){
            System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
            System.out.println("Student name: "+course[j][0]);
            System.out.println("Student ID: "+idar[j]);
            System.out.println("Email: "+course[j][2]);
            System.out.println(" score: "+score[j]);
            System.out.println("Grade: "+grade[j]);
            System.out.println("Academic advisor: "+course[j][1]);
            return(j);
         }
      }
      return(-1);
   }
   public static void grades (){//obtion 5
      int j,i;
      double num,sum=0;
      for(j=1;j<score.length;j++){
         num=score[j];
         for(i=j-1;(i>=0)&&(score[i]>num);i--){
            score[i+1]=score[i];}
         score[i+1]=num;}
      System.out.println("the lowest score is  "+score[0]);
      System.out.println("the highest score is  "+score[24]);
      for(j=0;j<score.length;j++)
         sum=sum+score[j];
      System.out.printf("average score is %.2f",(sum/25));
   }
   public static void printall( ){//obtion 6
      int j;
      System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
      for (j=0;j<course.length;j++){
         System.out.println("Student name: "+course[j][0]);
         System.out.println("Student ID: "+idar[j]);
         System.out.println("Email: "+course[j][2]);
         System.out.println("Total score: "+score[j]);
         System.out.println("Grade: "+grade[j]);
         System.out.println("Academic advisor: "+course[j][1]);}
   }
   public static void samegrade ( ){//obtion 7
      int j;
      char g;
      read.nextLine();
      System.out.println("enter the grade (such as A,B,C,D)to print students name for grade ");
      g=read.next().charAt(0);
      g=Character.toUpperCase(g);
      switch (g){
         case 'A':
            for (j=0;j<grade.length;j++){
               if (grade[j]==('A'))
                  System.out.println(course[j][0]);}
            break;
         case 'B':
            for (j=0;j<grade.length;j++){
               if (grade[j]==('B'))
                  System.out.println(course[j][0]);}
            break;
         case 'C':
            for (j=0;j<grade.length;j++){
               if (grade[j]==('C'))
                  System.out.println(course[j][0]);}
            break;
         case 'D':
            for (j=0;j<grade.length;j++){
               if (grade[j]==('D'))
                  System.out.println(course[j][0]);}
            break;
         case 'F':
            for (j=0;j<grade.length;j++){
               if (grade[j]==('F'))
                  System.out.println(course[j][0]);}
         default :System.out.println("the grade is not avilible in universty");}
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