import java.util.*;
import java.io.*;
public class User implements Serializable {
public static final long serialVersionUID = 4527015071857793162L;
//public static final long serialVersionUID = -5541440109843298133L;
   private String fName, lName, uName, email, password;
   private int numOfEvents;
   private transient Event[] eventList;

//constructor
   public User (String fName, String lName, String uName, String password,String email){
      this.fName=fName;
      this.lName=lName;
      this.uName=uName;
      this.email=email;
      this.password=password;
      eventList= new Event [100];
      numOfEvents=0;    } 
//Serializer.serialize(date);


//method FindEvent
   public int findEvent (int id){
      for (int i=0; i<numOfEvents; i++)
         if ( eventList[i].getId() == id )
            return i;
      return -1;  }


//method addEvent
   public void addEvent (Event e){
      if (numOfEvents < 100){
         eventList[numOfEvents++]=e;// new RecurrentEvent (e.getTitle(), e.getDescription(), e.getStartD(), e.getEndD(), ((RecurrentEvent)e).getDuration() , ((RecurrentEvent)e).getRecurrence() );
      System.out.println("add event complete ");}
        else System.out.println("your schedule is full :\"|");
         /*
         because class Event id abstract we had to choose RecurrentEvent constracter
         then we cast the methods in class RecurrentEvent that don't exist in 
         class Event
         */    }


//method cancelEvent
   public boolean cancelEvent(int ID)
   {
      int indx= findEvent(ID);
      if (indx!=-1)
      {
         for (int i= indx; i<numOfEvents-1; i++)
         {
            eventList[i]= eventList[i+1];
         }
         eventList[--numOfEvents]=null;
         return true;
      }
      return false;
   }

//method importEvents
   public void importEvents (String file) throws IOException , ClassNotFoundException{//it muust to throw CNFE because it's going to read
   ObjectInputStream DIF=null;
     try{ File F = new File (file);
           if(!(F.canRead()&&F.exists()))throw new IOException("the file is missing or can't read from it");
      FileInputStream FIS = new FileInputStream (F);
      DIF = new ObjectInputStream(FIS);
      while(numOfEvents<eventList.length){
      try{
      Event e=(Event)DIF.readObject();
      if (e!=null)
      eventList[numOfEvents++]=e;}
      catch(ClassNotFoundException e){
      throw e;
      }}
      }//end outer try
      catch(EOFException e){
      System.out.println(" done ");
      DIF.close();
      }
      
      /* Lama comment
      File f = new File (file);
      FileInputStream ff = new FileInputStream(f);
      ObjectInputStream in = new ObjectInputStream(ff);
      Event a = null;
      a=(RecurrentEvent)in.readObject();
      addEvent(a);
      in.close();
      */
         //for(i=numofevent;i<events.length;i++)
   
   }


//method exportEvents
   public void exportEvents (String file) throws IOException{
      File F = new File (file);
     // if(!(F.canWrite()&&F.exists()))throw new IOException("the file is missing or can't write on it");
      FileOutputStream FOS = new FileOutputStream (F);
     ObjectOutputStream OOS = new ObjectOutputStream (FOS);
      for( int i=0 ; i<numOfEvents ;i++)
         OOS.writeObject(eventList[i]);
         OOS.close();
     /* Lama comments
      File f = new File(file);
      FileOutputStream ff = new FileOutputStream (f);
      ObjectOutputStream out = new ObjectOutputStream(ff);
      for( int i=0 ; i<numOfEvents ;i++){
         out.writeObject(eventList[i]);
      }
         out.close();
      */
   }


//method displayAll
   public void displayAll (){
      for (int i=0; i<numOfEvents; i++)
         System.out.println(eventList[i]+"\n");    }
         public String toString (){
     return "First Name: "+fName+"\nLast Name  :"+lName+"\nUsername  :"+uName+"\nEmail  :"+email+"\nPassword  :"+password;
}

//method saveAgenda
   public void saveAgenda (){
try{
FileOutputStream FOF = new FileOutputStream (new File(uName+".text"),true);
PrintWriter pd=new PrintWriter(FOF);
pd.println(fName+" "+lName);
pd.println(email); 
pd.println(password);
pd.println(numOfEvents);
for(int i=0;i<numOfEvents;i++)
pd.println(eventList[i]);//or sepreat events attribute
pd.close();
System.out.println("saved Agenda"); 
}
catch(IOException e){
System.out.println("there is problem with save information in the file ");
 }
}
//method remindAll  
   public Event[] remindAll (){
      int counter=0;
      // loop to take size
      for (int i=0; i<numOfEvents; i++)
         if (eventList[i].remind())
            counter++;
         
      Event[] remindAll = new Event [counter];
     counter=0;
      // loop to fill the new array (remindAll)   
      for (int i=0; i<numOfEvents; i++)
         if (eventList[i].remind())
            remindAll[counter++]=eventList[i];
   
      return remindAll;    }
   
   
   public String getUserName(){
   return uName;}
   
   public String getPssword(){
   return password;}
   
   public Event getEvent (int index){
   return eventList[index]; }
   
   public String getname(){
   return uName; }
   
   //by lama

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getuName() {
        return uName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getNumOfEvents() {
        return numOfEvents;
    }

    public Event[] getEventList() {
        return eventList;
    }
     public User(User u)
    {
        this(u.uName, u.email, u.password, u.fName, u.lName);

        for (int i=0; i<u.numOfEvents; i++)
        {
            // we used this constructor so that events will have new ID
            if ((u.eventList[i]) instanceof RecurrentEvent)

                eventList[numOfEvents++]=new RecurrentEvent(((RecurrentEvent)(u.eventList[i])).title,((RecurrentEvent)(u.eventList[i])).description, ((RecurrentEvent)(u.eventList[i])).getSDate()   ,((RecurrentEvent)(u.eventList[i])).getEDate()   ,((RecurrentEvent)(u.eventList[i])).getDuration()   ,((RecurrentEvent)(u.eventList[i])).getRecurrence());
            else
                eventList[numOfEvents++]=new Event((u.eventList[i]).title, (u.eventList[i]).description, (u.eventList[i]).getSDate(), (u.eventList[i]).getEDate());
        }
    }
} //End of User class