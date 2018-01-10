import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Event implements Serializable{

protected int id; 
protected String title;
protected String description;

private Date startD;
private Date endD;
private static int counter;



public Event(String title, String des, Date stD, Date endD) 
{
   if (stD.after(endD))
      throw new IllegalArgumentException();
   id= counter++;
   this.title=title;
   description=des;
   startD=stD;
   this.endD=endD;
}

public Event(Event e) // use it to copy the object with the same ID
{
   id = e.id;
   title=e.title;
   description = e.description;
   startD = e.startD;
   endD = e.endD;
}

public boolean remind()
{
   return startD.after(new Date());
}

public String toString()
{
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // to print Date object in this format

   return String.format("Event #%d: %s\n\t%s\nStarts: %s\nEnds: %s\n\n",id, title, description, sdf.format(startD), sdf.format(endD));
}

public int getID()
{return id;}

public Date getSDate()
{return startD;}

public Date getEDate()
{return endD;}
 // by lama
   public int getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }
   
   public String getDescription() {
        return description;
    }

}//Event