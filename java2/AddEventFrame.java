import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
public class AddEventFrame extends JFrame
{
private static final int HEIGHT=600;
private static final int WIDTH=500;
private static final int xORIGIN=300;
private static final int yORIGIN=500;
public static void main (String[]args)
{
AddEventFrame EventFrame=new AddEventFrame();
EventFrame.setVisible(true);

}

JPanel radioPanel,radioPane2;
JButton addEventButton;
JTextField titleText,desText,durationText;
JSpinner dateSpin1,dateSpin2;
JRadioButton[] radioButton,radioButton2;
String[] yn={"Yes","No"};
String[] dmy={"Daily","Weekly","Monthly"};
ButtonGroup bGroup,yGroup;
public AddEventFrame()
{
Container contentPane;
setTitle("Tests' Planner");
setResizable(false);
setSize(WIDTH,HEIGHT);
setLocation(xORIGIN,yORIGIN);

addEventButton=new JButton("Add Event");

titleText=new JTextField();
titleText.setColumns(20);
JLabel titleLabel = new JLabel("Event Title:");
desText=new JTextField();
JLabel desLabel = new JLabel("Event Description:");
desText.setPreferredSize( new Dimension( 220, 144) );
//
JLabel dateLabel=new JLabel("Start Date:");
JLabel dateLabe2=new JLabel("End Date:");
SpinnerDateModel spinMod=new SpinnerDateModel();
dateSpin1=new JSpinner(spinMod);
dateSpin2=new JSpinner(spinMod);
dateSpin1.setValue(new Date());
dateSpin1.setEditor(new JSpinner.DateEditor(dateSpin1,"dd.MM.yyyy"));
dateSpin2.setValue(new Date());
dateSpin2.setEditor(new JSpinner.DateEditor(dateSpin1,"dd.MM.yyyy"));
//create and place radio buttons
        radioPanel = new JPanel(new GridLayout(0,5,5,10));
        radioPanel.setBorder(BorderFactory.createTitledBorder("Is it a Recurrent event?"));
        bGroup = new ButtonGroup();
        radioButton = new JRadioButton[2];
//
 radioPane2 = new JPanel(new GridLayout(0,2,5,10));
        radioButton2 = new JRadioButton[3];
                yGroup = new ButtonGroup();
                
durationText=new JTextField();
durationText.setColumns(20);
JLabel durationLabel = new JLabel("Duration:");

   
//
contentPane=getContentPane();
contentPane.setLayout(new FlowLayout());
contentPane.add(titleLabel,BorderLayout.WEST);
contentPane.add(titleText,BorderLayout.CENTER);
contentPane.add(desLabel,BorderLayout.WEST);
contentPane.add(desText,BorderLayout.CENTER);
contentPane.add(dateLabel,BorderLayout.WEST);
contentPane.add(dateSpin1,BorderLayout.CENTER);
contentPane.add(dateLabe2,BorderLayout.WEST);
contentPane.add(dateSpin2,BorderLayout.CENTER);

     for (int i = 0; i < radioButton.length; i++) {
            radioButton[i] = new JRadioButton(yn[i]);
           // radioButton[i].addItemListener(this);
            bGroup.add(radioButton[i]);
            radioPanel.add(radioButton[i]);}
            
           //
            for (int i = 0; i < radioButton2.length; i++) {
            radioButton2[i] = new JRadioButton(dmy[i]);
            yGroup.add(radioButton2[i]);
            radioPane2.add(radioButton2[i]);}
             radioPane2.add(durationLabel);
            radioPane2.add(durationText);
           radioPane2.setEnabled(false);
          
contentPane.add(radioPanel, BorderLayout.CENTER);
contentPane.add(radioPane2, BorderLayout.EAST);
contentPane.add(addEventButton,BorderLayout.CENTER);
setDefaultCloseOperation(EXIT_ON_CLOSE);


}
public void ActionPerformed(ActionEvent event)
{
String title,desc;
Date startDate,endDate;
boolean reEvent;
char recurrent;
int duration;
if(event.getSource() == titleText)
{
title=titleText.getText();
}
else if (event.getSource()==desText)
{
desc=desText.getText();
}//////
else if(event.getSource()==dateSpin1)
{
startDate=(Date)dateSpin1.getValue();
}else if (event.getSource()==dateSpin2)
{
endDate=(Date)dateSpin2.getValue();
}///////
else if(event.getSource()==radioButton)
{
if(bGroup.getSelection().getActionCommand().equals("Yes"))
{reEvent=true;
radioPane2.setEnabled(true);}
else if(bGroup.getSelection().getActionCommand().equals("No"))
reEvent=false;

}
else if(event.getSource()==radioButton2)
{
if(yGroup.getSelection().getActionCommand().equals("Daily"))
{recurrent='D';}
if(yGroup.getSelection().getActionCommand().equals("Monthly"))
{recurrent='M';}
if(yGroup.getSelection().getActionCommand().equals("Yearly"))
{recurrent='Y';}
}
else if (event.getSource()==durationText)
{
duration=Integer.parseInt(durationText.getText());
}
else if(event.getSource()==addEventButton)
{
u.addEvent(new Event(title,desc,startDate,endDate);
}
}
}