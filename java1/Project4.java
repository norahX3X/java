//norah alkunifer 435201094
import java.util.*;//import from packeg 
class Project4{//class name 
   static Scanner read=new Scanner (System.in);//to read from user 
   public static void main (String[]args){//main class
      final String mail="@ksu.edu.sa";
      int []idar=new int[26];//diclrition
      double[]score=new double[26];
      String[][]course=new String[26][3];
      char []grade=new char [26];
      int chose=0,n=0,j=0,i=0,id=0,flag=0,sumadvisor=0,nstudent=-1,sum=0,trace,tracenum;
      String want,done,advisor;
      char sgrade;
      double num;
   //menu
      do{
         System.out.println("1/Add a student to the set of students in the course.");
         System.out.println("2/Remove a student from the set of students in the course.");
         System.out.println("3/ Find the information about a student given her ID.");
         System.out.println("4/ Return the total number of students for a specific academic advisor.");
         System.out.println("5/ Find information about the lowest, average, highest score in the course.");
         System.out.println("6/  Print all the students");
         System.out.println("7/ Print all the students with the same letter grade (such as A, B, C, D).");//by switch letter case a..
         System.out.println("8/  Count the total number of students in the course.");
         chose=read.nextInt();
         switch (chose){//menu prosasing by switch statment
            case 1:
               while(n<26){
               read.nextLine();
                  System.out.print("enter student name");//read and save information in array 
                  course[n][0]=read.nextLine();
                  System.out.print("enter student advisor name");
                  course[n][1]=read.nextLine();
                  System.out.print("enter student id");
                  idar[n]=read.nextInt();
                  System.out.println("enter student score");
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
                  trace=idar[n];
                 while (trace!=0) {//to chick if it from 0-9
                      tracenum=trace % 10;
                      trace=trace/10;
                       switch(tracenum){
                       case 0 : case 1: case 2: case 3: case 4: case 5:case 6: case 7: case 8: 
                       case 9 :break;
                       default :System.out.println(" student id contain saymbols try again");
                       idar[n]=read.nextInt();
                       trace=idar[n];
                     }
                      }
                      //chick uniqnis of id !!
                    for(j=n-1;-1<j;j--){
                    if(idar[n]==idar[j]){
                    System.out.println("id is previously existing try agin ");
                    System.out.print("enter student id");
                    idar[n]=read.nextInt();
                    j=n;}
                      }
                  while((String.valueOf(idar[n]).length())!=9){// chick if it 9 digits long
                     System.out.println(" student id more or less than 9 try again");
                     idar[n]=read.nextInt();}
                  nstudent++;
                  n++;
                  System.out.print("do you want to add other student yes or no ?");  
                  done=read.next();
                  if ((done.equals("no")) ||(done.equals("No"))){
                     break;}
               }
               break;
            case 2:
               System.out.println("enter student id that you want to delet her information");
               id=read.nextInt();
               for(j=0;j<26;j++){
                  if ( (idar[j]==id)&&(j!=n)){
                     while(j<nstudent){
                        course[j][0]=course[j+1][0];
                        course[j][1]=course[j+1][1];
                        course[j][2]=course[j+1][2];
                        idar[j]=idar[j+1];
                        score[j]=score[j+1];
                        grade[j]=grade[j+1];
                        flag=-1;
                        j++;
                     }
                     n--;}
                    else if ((idar[j]==id)&&(j==n)) { 
                     n--;
                     flag=-1;} 
               }
               if (flag!=-1){
                  System.out.println("not found");}
               else if(flag==-1){
                   System.out.println("delet compleated");}
               break;
            case 3:
               System.out.println("enter student id to find her information");
               id=read.nextInt();
               for(j=0;j<26;j++){
                  if (idar[j]==id){
                     System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
                     System.out.println("student noumber : "+(j+1));
                     System.out.println("Student name: "+course[j][0]);
                     System.out.println("Student ID: "+idar[j]);
                     System.out.println("Email: "+course[j][2]);
                     System.out.println("Total score: "+score[j]);
                     System.out.println("Grade: "+grade[j]);
                     System.out.println("Academic advisor: "+course[j][1]);
                     flag=-2;
                     break;}
               }
               if (flag!=-2)
                  System.out.println("not found");
               break;
            case 4:
            read.nextLine();
               System.out.print("enter acadimic advisor name");
               advisor=read.nextLine();
               for(j=0;j<n;j++){
                  if (course[j][1].equals(advisor)){// problim chck nex line from teacher
                     sumadvisor++;
                     }
               }
               System.out.println("nomber of studentes whith  acadimic advisor is "+sumadvisor);
               break;
            case 5:
              for(j=1;j<n;j++){
                  num=score[j];
                  for(i=j-1;(i>=0)&&(score[i]>num);i--){
                     score[i+1]=score[i];}
                  score[i+1]=num;}
               System.out.println("the lowest score is  "+score[0]);
               System.out.println("the highest score is  "+score[nstudent]);
               for(j=0;j<n;j++){
                  sum+=score[j];}
               System.out.println("average score is "+(sum/n));
               break;
            case 6:
            if (n==0){
            System.out.println("no student to print it for you");}
            else {
               System.out.println("\t\t\tKing Saud University (KSU) – Riyadh\n\t\t\tFALL 2015/2016\n\t\t\tStudent Information");
               for (j=0;j<n;j++){
                  System.out.println("student noumber : "+(j+1));
                  System.out.println("Student name: "+course[j][0]);
                  System.out.println("Student ID: "+idar[j]);
                  System.out.println("Email: "+course[j][2]);
                  System.out.println("Total score: "+score[j]);
                  System.out.println("Grade: "+grade[j]);
                  System.out.println("Academic advisor: "+course[j][1]);}
                  }
               break;
            case 7 :
            read.nextLine();
                     System.out.println("student with A grade ");
                     for (j=0;j<nstudent;j++){
                        if (grade[j]==('A'))
                           System.out.println(course[j][0]);}
                      System.out.println("student with B grade ");
                     for (j=0;j<nstudent;j++){
                        if (grade[j]==('B'))
                           System.out.println(course[j][0]);}
                     System.out.println("student with C grade ");
                     for (j=0;j<nstudent;j++){
                        if (grade[j]==('C'))
                           System.out.println(course[j][0]);}
                     System.out.println("student with D grade ");
                     for (j=0;j<nstudent;j++){
                        if (grade[j]==('D'))
                           System.out.println(course[j][0]);}
                     System.out.println("student with F grade ");
                     for (j=0;j<nstudent;j++){
                        if (grade[j]==('F'))
                           System.out.println(course[j][0]);}
               break;
            case 8:
               System.out.println("the total noumber of student is "+n);
            default: System.out.println("the nomber you choose it is not avilible ");}
         System.out.println(" do you want other think yes or no");
         want=read.next();}
      while(!(want.equals("no")) ||(want.equals("No")));
   }}//end