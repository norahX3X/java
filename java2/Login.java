import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Date;
import java.util.*;

public class Login extends JFrame implements ActionListener  {
   /*general=menue+..*/
   JTabbedPane MenuBar;/*=new JTabbedPane(JTabbedPane.WRAP_TAB_LAYOUT );
   
   /*save and load*/
   ImageIcon ExportImportIcon ;
   JLabel general,loadevent,saveevent;  
   JTextField load,save;   
   JButton loadb,saveb;
   JComponent panel1;
   
   /*reminder*/
   JLabel remindingLabel;
   ImageIcon remindIcon ;
     
   /*add event*/
   JComponent addevent;
   JPanel addEventPanel;
   JPanel radioPanel,radioPane2;
   JLabel titleLabel,desLabel;
   JButton addEventButton;
   JTextField titleText,desText,durationText;
   JSpinner dateSpin1,dateSpin2;
   JRadioButton[] radioButton,radioButton2;
   String[] yn={"Yes","No"};
   String[] dmy={"Daily","Weekly","Monthly"};
   ButtonGroup bGroup,yGroup;
   ImageIcon addIcon;   
          
          
   /*find event*/ 
   JComponent  findevent ;/*=new panel or any other component you want*/
   JButton find, cancel, agenda;
   JTextField t;
   JTextArea area;
   JLabel dis;
   JLabel image;
   ImageIcon findIcon;
   //Planner obj;
        
        

   User u;
   
   
   public Login(User user)throws IOException{
      this.u=user;
      MenuBar=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT );
      setTitle(u.getname()+"Planner");
      setSize(700, 700);
      // setResizable(false);
      setLocationRelativeTo(null);
      //closing
      WindowListener exitListener = 
         new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               home();
               dispose();
            }};
      addWindowListener(exitListener);
   
   
   // Laod and Save:
      panel1 = new JPanel();
      Font font=new Font("Tahoma",Font.BOLD,28);//design ;)
      general=new  JLabel("import and export Events from files");
      JLabel general1=new  JLabel("\n-----------------------------------");
      general.setFont(font);
      general1.setFont(font);
      JPanel g=new  JPanel(new GridLayout(2, 1, 10, 10));
      g.add(general);
      g.add(general1);
      loadevent=new JLabel("load events from file >> ");
      saveevent=new  JLabel("save events to file >>"); 
      JPanel text=new  JPanel( new GridLayout(2, 1, 10, 10));
      text.add(loadevent);
      text.add(saveevent);
      load=new JTextField();
      load.  setColumns(10);
      save=new JTextField(); 
      save. setColumns(10);  
      loadb=new JButton("load");
      loadb. setActionCommand("loud");
      saveb=new JButton("save");
      saveb.setActionCommand("save");
      JPanel test=new JPanel ( new GridLayout(2, 1, 10, 10));
      test.add(load);
      test.add(save);
      JPanel but=new JPanel ( new GridLayout(2, 1, 10, 10));
      but.add(loadb);
      but.add(saveb);
      panel1.add(g);
      panel1.add(text);
      panel1.add(test);
      loadb.addActionListener(this); 
      panel1.add(but);
      saveb.addActionListener(this); 
      ExportImportIcon = new ImageIcon("file.png");
   
   
   // Reminders:
      Event[] All = u.remindAll();
      String S="<html>";
      for (int i=0; i<All.length; i++)
         S+=All[i]+" <br> ";
      remindingLabel = new JLabel(S+"<html>");
      
      remindIcon = new ImageIcon("remind.png");
   
   
   // Add Event:
      addEventButton=new JButton("Add Event");
      addEventButton.setActionCommand("addevent");
      titleText=new JTextField();
      titleText.setColumns(20);
      titleLabel = new JLabel("Event Title:");
      desText=new JTextField();
      desLabel = new JLabel("Event Description:");
      desText.setPreferredSize( new Dimension( 220, 144) );

      JLabel dateLabel=new JLabel("Start Date:");
      JLabel dateLabe2=new JLabel("End Date:");
      SpinnerDateModel spinMod=new SpinnerDateModel();
      SpinnerDateModel spinMod2=new SpinnerDateModel();
   
      dateSpin1=new JSpinner(spinMod);
      dateSpin2=new JSpinner(spinMod2);
      dateSpin1.setValue(new Date());
      dateSpin1.setEditor(new JSpinner.DateEditor(dateSpin1,"dd.MM.yyyy"));
      dateSpin2.setValue(new Date());
      dateSpin2.setEditor(new JSpinner.DateEditor(dateSpin2,"dd.MM.yyyy"));
      
      //create and place radio buttons
      radioPanel = new JPanel(new GridLayout(0,5,5,10));
      radioPanel.setBorder(BorderFactory.createTitledBorder("Is it a Recurrent event?"));
      bGroup = new ButtonGroup();
      radioButton = new JRadioButton[2];
   
      radioPane2 = new JPanel(new GridLayout(2,3,0,0));
      radioButton2 = new JRadioButton[3];
      yGroup = new ButtonGroup();
                
      durationText=new JTextField();
      durationText.setColumns(20);
      JLabel durationLabel = new JLabel("Duration:");
   
      for (int i = 0; i < radioButton.length; i++) {
         radioButton[i] = new JRadioButton(yn[i]);
         // radioButton[i].addItemListener(this);
         bGroup.add(radioButton[i]);
         radioPanel.add(radioButton[i]);
         radioButton[i].addActionListener(this);//!!
      }
            
      for (int i = 0; i < radioButton2.length; i++) {
         radioButton2[i] = new JRadioButton(dmy[i]);
         yGroup.add(radioButton2[i]);
         radioPane2.add(radioButton2[i]);
         radioButton2[i].addActionListener(this);
      }
      radioPane2.add(durationLabel);
      radioPane2.add(durationText);
      // radioPane2.setEnabled(false);
      addEventPanel=new JPanel(new FlowLayout());
      addEventPanel.setSize(300,300);
      addEventPanel.add(titleLabel/*BorderLayout.WEST*/);
      addEventPanel.add(titleText/*BorderLayout.CENTER*/);
      addEventPanel.add(desLabel/*BorderLayout.WEST*/);
      addEventPanel.add(desText/*BorderLayout.CENTER*/);
      addEventPanel.add(dateLabel/*BorderLayout.WEST*/);
      addEventPanel.add(dateSpin1/*BorderLayout.CENTER*/);
      addEventPanel.add(dateLabe2/*,BorderLayout.WEST*/);
      addEventPanel.add(dateSpin2/*,BorderLayout.CENTER*/);
      addEventPanel.add(radioPanel/*, BorderLayout.CENTER*/);
      addEventPanel.add(radioPane2/*, BorderLayout.EAST*/);
      addEventPanel.add(addEventButton/*,BorderLayout.CENTER*/);
      addEventButton.addActionListener(this);
      radioButton[1].setSelected(true);
      setEnabledAll(radioPane2,false);
      addIcon = new ImageIcon("add.png");
   
   
   // Find And Cancel: 
      t = new JTextField();
      area = new JTextArea();
      area.setColumns(30);
      area.	setLineWrap(true);
      area. setWrapStyleWord(true);
      area.  setRows(30);
      image = new JLabel(new ImageIcon("C:\\Users\\hp\\Dropbox\\project\\final\\images.jpg"));
      findevent=new JPanel(/*new GridBagLayout()*/);
      /* GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);*/
      
      JLabel label1 = new JLabel("Event ID");
      label1.setBounds(3, 0, 100, 100);//!!
      // constraints.gridx = 0;
      // constraints.gridy = 0;  
      findevent.add(label1/*constraints*/);   
         
      t.setColumns(15);
      t.setBounds(50, 42, 60, 20);
      //constraints.gridx = 1;
      findevent.add(t/*,constraints*/);
      JScrollPane bar = new JScrollPane(area);
      bar.setBounds(20, 110, 240, 300);
       
      /* constraints.gridx = 0;
      constraints.gridy = 1; */
      findevent.add(bar/*,constraints*/);    
      find = new JButton("Find");
      find.addActionListener(this);
      find.setBounds(15, 70, 60, 30);
      // constraints.gridx = 1;
      findevent.add(find/*,constraints*/);
      
      cancel = new JButton("Cancel");
      cancel.setBounds(80, 70, 75, 30);
      cancel.addActionListener(this);
      /* constraints.gridx = 0;
      constraints.gridy = 2;
      constraints.gridwidth = 2;
      constraints.anchor = GridBagConstraints.CENTER;*/
      findevent.add(cancel/*,constraints*/);
        
      AgendaBoutton();
      setLable2();
      setImage();
      findIcon = new ImageIcon("search.png"); 
      
      
      // Add All components to the panel:
      MenuBar.addTab("Export,Import", ExportImportIcon, panel1, "Does nothing");
      MenuBar.addTab("Add Event",addIcon, addEventPanel);
      MenuBar.addTab("Reminder",remindIcon,remindingLabel);
      MenuBar.addTab("Find Event",findIcon, findevent);
      add(MenuBar); 
      setLocationRelativeTo(null);
   }
   
   public void actionPerformed(ActionEvent e){
   // sara
      Date startDate=new Date();
      Date endDate=new Date(1);
      boolean reEvent=false;
      char recurrent='x';
      int duration=0;
      String title=titleText.getText();
      titleText.setText("");
      String desc=desText.getText();
      desText.setText("");
      //else if(e.getSource()==dateSpin1)
      //{
      startDate=(Date)dateSpin1.getValue();
      //}else if (e.getSource()==dateSpin2)
      //{
      endDate=(Date)dateSpin2.getValue();
      if(e.getSource() instanceof JRadioButton)
      {
         if(e.getActionCommand().equals("Yes"))
         {
            setEnabledAll(radioPane2,true);
            reEvent=true;
         }
         else if(e/*bGroup.getSelection()*/.getActionCommand().equals("No")){
            setEnabledAll(radioPane2,false);
            reEvent=false;}
         //else if(e.getSource()==radioButton2)
         //{
         else if(e.getActionCommand().equals("Daily"))
         {recurrent='D';
         //for trasing ;)JOptionPane.showMessageDialog(null, "waaw ");
         }
         else if(e/*yGroup.getSelection()*/.getActionCommand().equals("Monthly"))
         {recurrent='M';}
         else if(e.getActionCommand().equals("Yearly"))
         {recurrent='Y';}
      }
      else if(e.getSource() instanceof JButton){
         if(e.getActionCommand().equals("loud")){
            try{
               this.u.importEvents(load.getText());
               JOptionPane.showMessageDialog(null, "loud is done");}
            catch(IOException exc){
               JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            catch(ClassNotFoundException exc){
               JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            load.setText("");
         }
         else if(e.getActionCommand().equals("save")){
            try{
               this.u.exportEvents(save.getText());
               JOptionPane.showMessageDialog(null, "save complete");}
            catch(IOException exc){
               JOptionPane.showMessageDialog(null, exc.getMessage());
            }
            save.setText("");
         }
         else if(e.getActionCommand().equals("addevent"))
         {
            if(reEvent){
               try{
                  duration=Integer.parseInt(durationText.getText());}
               catch(InputMismatchException ex){
                  JOptionPane.showMessageDialog(null, "duration must be number !!");
               }
               catch(NumberFormatException ex){
                  JOptionPane.showMessageDialog(null, "duration must be number !!");
               }
               durationText.setText("");
            
               //add RecurrentEvent
               try{
                  u.addEvent(new RecurrentEvent(title,desc,startDate,endDate,Integer.parseInt(durationText.getText()),recurrent));
                  JOptionPane.showMessageDialog(null, "add is complete ");}
               catch(InputMismatchException ex){
                  JOptionPane.showMessageDialog(null, "duration must be number !!");
               }
               catch(NumberFormatException ex){
                  JOptionPane.showMessageDialog(null, "duration must be number !!");
               }
            }
            else{
            //add normal event 
               u.addEvent(new Event(title,desc,startDate,endDate));
               JOptionPane.showMessageDialog(null, "add is complete ");
            
            }
         //find and canceland agenda button 
         }//end if for add event button
      
      }//end if for JButton
   
      String a = t.getText();
      try {
         int id = Integer.parseInt(a);
         JButton temp = (JButton) e.getSource();
        if (temp.equals(find)) {
           int index= u.findEvent(id);
            area.append(u.getEvent(index)+"");
         }
         else if (temp.equals(cancel))
         {
         if (u.cancelEvent(id))
            {
                  dis.setText("");
               if(u.getNumOfEvents() > 0 )
               for (int i = 0; i < u.getNumOfEvents(); i++)
               {
                  dis.setText(dis.getText() + "<html>" + "Title: " + u.getEventList()[i].getTitle() + "   -   " + "<html>" + "ID# " + (u.getEventList()[i].getId() - u.getEventList()[0].getId()) + " <br> ");
               }
               else
               dis.setText("");
            
               JOptionPane.showMessageDialog(this, "event is canceled");
            }
         }
         else if (temp.equals(agenda)) {
            u.saveAgenda();
            JOptionPane.showMessageDialog(this, "agenda has been saved");
         }
      }
      catch(NumberFormatException n)
      {
         JOptionPane.showMessageDialog(this, "please enter a number");
      }
   
   }//end actionPerformed 
   public static void home( ){
      try{
         Home h=new Home();
         h.setVisible(true);}
      catch(IOException e){
      }
   }
   public void setEnabledAll(JPanel panel, boolean state) {
      for (Component c : panel.getComponents()) c.setEnabled(state);}

   public void AgendaBoutton() {
      agenda = new JButton("Save Agenda");
      agenda.setBounds(85, 420, 120, 30);
      findevent.add(agenda);
      agenda.addActionListener(this);
   }

   public void setImage()
   {
      image.setBounds(160,-100,330,300);
      findevent.add(image);
      image.setVisible(true);
   
   }
   public void setLable2() {
      dis = new JLabel("");
      dis.setBounds(300,70,150,300);
      findevent.add(dis);
      for (int i = 0; i <u.getNumOfEvents() ; i++)
      {
        
         dis.setText(dis.getText()+"<html>"+"Title: "+u.getEventList()[i].getTitle()+" - "+"<html>"+"ID# "+(u.getEventList()[i].getId()-u.getEventList()[0].getId()) + " <br> " );
      }
   }

}
