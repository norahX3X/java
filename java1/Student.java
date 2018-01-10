class Student {
private int ID;
private String  name,email,academicAdvisor;
private double score;
private char grade ;
public Student(){//defult constructor 
 ID= 435000000;
 name= "-";
 email= "-";
 score=0.0;
 grade= '-';
 academicAdvisor= "-";
}
//setter and getter mwthods 
public void SetStudent(int id,String  n,double s,String mail,char g,String  aa){
ID= id;
 name= n;
 email= mail;
 score=s;
 grade= g;
 academicAdvisor= aa;
}
public String getname (){
return ( name );
}
public String getemail (){
return ( email );
}
public String getacademicAdvisor (){
return (academicAdvisor  );
}
public int getID (){
return ID;
}
public double getscore (){
return score ;
}
public char getgrade (){
return grade ;
}
public void printStudentInfo(){

System.out.println("Student name: "+name);
System.out.println("Student ID: "+ID);
System.out.println("Email: "+email);
System.out.println(" score: "+score);
System.out.println("Grade: "+grade);
System.out.println("Academic advisor: "+academicAdvisor);
}
}//end of class 