import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

public class FindAndCancel extends JFrame implements ActionListener {

    Container con;
    JButton find, cancel, agenda;
    JTextField t;
    JTextArea area;
    JLabel dis;
    JLabel image;
    Planner obj;
    public FindAndCancel(Planner planerData) {
        t = new JTextField();
        area = new JTextArea();
        image = new JLabel(new ImageIcon("C:\\Users\\hp\\Dropbox\\project\\final\\images.jpg"));
        obj = planerData;
        setFrame();
        setLable();
        setField();
        setTextArea();
        FindButton();
        CancelButton();
        AgendaBoutton();
       setLable2("");
        setImage();
        setVisible(true);
    }

    public void setFrame() {
        setSize(500, 500);
        setLocation(450, 150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test's planner");
        con = getContentPane();
        setLayout(null);
    }

    public void setLable() {
        JLabel label1 = new JLabel("Event ID");
        label1.setBounds(3, 0, 100, 100);
        con.add(label1);

    }

    public void setField() {

        t.setColumns(15);
        t.setBounds(50, 42, 60, 20);
        con.add(t);

    }

    public void FindButton() {
        find = new JButton("Find");
        find.addActionListener(this);
        find.setBounds(15, 70, 60, 30);
        con.add(find);
    }

    public void CancelButton() {
        cancel = new JButton("Cancel");
        cancel.setBounds(80, 70, 75, 30);
        con.add(cancel);
        cancel.addActionListener(this);
    }

    public void AgendaBoutton() {
        agenda = new JButton("Save Agenda");
        agenda.setBounds(85, 420, 120, 30);
        con.add(agenda);
        agenda.addActionListener(this);
    }

    public void setImage()
    {
        image.setBounds(160,-100,330,300);
        con.add(image);
        image.setVisible(true);

    }

    public void setTextArea() {

        JScrollPane bar = new JScrollPane(area);
        bar.setBounds(20, 110, 240, 300);
        con.add(bar);
    }

    public void setLable2(String a) {
        dis = new JLabel("");
        dis.setBounds(300,70,150,300);
        con.add(dis);
        for (int i = 0; i <obj.currentUser.getNumOfEvents() ; i++)
        {
            dis.setText(dis.getText()+"<html>"+"Title: "+obj.currentUser.getEventList()[i].getTitle()+"    -    "+"<html>"+"ID# "+(obj.currentUser.getEventList()[i].getId()-obj.currentUser.getEventList()[0].getId()) + " <br> " );
        }
    }
    public void actionPerformed(ActionEvent e) {
        String a = t.getText();
        try {
            int id = Integer.parseInt(a);
            JButton temp = (JButton) e.getSource();
            int indexOfTheDeletedEvent;
            if (temp.equals(find)) {
                obj.currentUser.findEvent(id);
                area.append(obj.currentUser.getEvent(id)+"");
            }
            else if (temp.equals(cancel))
            {
                indexOfTheDeletedEvent=id+obj.currentUser.getNumOfEvents();
                if (obj.currentUser.cancelEvent(indexOfTheDeletedEvent))
                {
                    for (int i = 0; i < obj.currentUser.getNumOfEvents(); i++)
                    {
                        dis.setText("");
                    }
                    for (int i = 0; i < obj.currentUser.getNumOfEvents(); i++)
                    {
                        if(i < indexOfTheDeletedEvent)
                        dis.setText(dis.getText() + "<html>" + "Title: " + obj.currentUser.getEventList()[i].getTitle() + "   -   " + "<html>" + "ID# " + (obj.currentUser.getEventList()[i].getId() - obj.currentUser.getEventList()[0].getId()) + " <br> ");
                        else
                         dis.setText(dis.getText() + "<html>" + "Title: " + obj.currentUser.getEventList()[i].getTitle() + "   -   " + "<html>" + "ID# " + (obj.currentUser.getEventList()[i].getId() - obj.currentUser.getEventList()[1].getId()) + " <br> ");

                    }

                    JOptionPane.showMessageDialog(this, "event is canceled");
                }
            } else if (temp.equals(agenda)) {
                obj.currentUser.saveAgenda();
                JOptionPane.showMessageDialog(this, "agenda has been saved");
            }
        }catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(this, "please enter a number");
        }
    }
}

class test {
    public static void main(String[] args)throws NullPointerException {

        Event FirstObject = new RecurrentEvent("pray", "magrib", new Date(2016-1900, 10-1, 1), new Date(2016-1900, 11-1, 1),1,'w');
        Event SecondtObject = new Event("pray", "jumah", new Date(2016-1900, 10-1, 1), new Date(2016-1900, 11-1, 1));
        Event three = new Event("game", "Footbal", new Date(2016-1900, 10-1, 1), new Date(2016-1900, 11-1, 1));
        Event four = new Event("party", "BirthDay", new Date(2016-1900, 10-1, 1), new Date(2016-1900, 11-1, 1));

        User[] arr = new User[1];

        arr[0] = new User("a", "a", "a", "a", "a");

        arr[0].addEvent(FirstObject);
        arr[0].addEvent(SecondtObject);
        arr[0].addEvent(three);
       arr[0].addEvent(four);

        Planner p = new Planner(arr);

        p.login("a","a");

        FindAndCancel f = new FindAndCancel(p);

    }
}


