
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RecurrentEvent extends Event {
 //   Scanner input = new Scanner (System.in);
    private int duration;//once, twice....
    private char recurrence; //weekly , Daily , monthly
 

    public RecurrentEvent(String title , String des , Date start , Date end , int duration , char recurrence)
    {
        super(title,des,start,end);
        this.duration=duration;
        this.recurrence=Character.toUpperCase(recurrence);//
        if(!(this.recurrence=='D'||this.recurrence=='W'||this.recurrence=='M'))throw new IllegalArgumentException("you can choose only D,W,M");//
    }
    
    public RecurrentEvent(RecurrentEvent ob)
    {
        super(ob.getTitle(),ob.getDescription(),ob.getSDate(),ob.getEDate());
        duration=ob.duration;
        recurrence=ob.recurrence;
    }
    
    
    
    public int getDays(Date a ,Date b)
    {
        /*
        this method to return how many days between the start and
        the end , this method use long data type so , after the
        subtract i cast the result into integer
         */
        long dif = b.getTime() - a.getTime();

        int days = (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

        return days;
    }

    public int recurrenceNumber()
    {
        /*
        this method to set the recurrence number after the user
        enters the recurrence character
        i needed recurrence number to assign it to the
        variable increment in the method below
         */
        if (recurrence == 'D' )//
            return 1;
        else if (recurrence == 'W')//
            return 7;
        else if (recurrence == 'M')//
                    return 30;//some month is less or more than 30 !!
                    //we could use calender right!!

        return -1;
    }
    public String printEvents()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");

        int count = 0;
        String event="";
        int increment = recurrenceNumber();
        getSDate().setDate(getSDate().getDate() - 1);

        int length = getDays(getSDate(),getEDate());

        Date s = new Date(getSDate().getTime());

        Date e = new Date(getSDate().getTime());

        e.setDate(e.getDate() + duration - 1);

        for (int i = 1; count <=length ; i=increment) {

            s.setDate(s.getDate() + i);
            e.setDate(e.getDate() + i);

            event += ft.format(s)+" - "+ft.format(e)+"\n";
            count = count + increment;
        }

        return event;

    }
    public boolean remind()
    {
        int count = 0;
        int increment = recurrenceNumber();

        getSDate().setDate(getSDate().getDate() - 1);

        int length = getDays(getSDate(),getEDate());


        Date s = new Date(getSDate().getTime());
        Date c = new Date(); // this object to take the current date

        c.setDate(c.getDate() -  1);

        for (int i = 1; count <=length ; i=increment) {
            s.setDate(s.getDate() + i);
            // method after is a predefined method in class date
            if (s.after(c)) // startDate after currentDate
                return true;

            count = count + increment;
        }
        return false;
    }

    public String toString()
    {
        return super.toString()+"\n\n"+printEvents();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public char getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(char recurrence) {
        this.recurrence = recurrence;
    }

}
