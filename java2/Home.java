import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Home extends JFrame implements ActionListener  {
/*general*/
   JPanel text,loginp,rgesp,radio;
   ButtonGroup RBG;
   JRadioButton login ,regs;
   JLabel text1;
   static JLabel exp;//not need

/*for login*/
   JLabel usern,pass;
   JTextField use;
   JPasswordField pw;
   JButton log;
  
/*for register*/
   JLabel fname,lname,uname,password,email;
   JTextField f,l,u,e;
   JPasswordField p;
   JButton reg;

/*data*/
   static Planner data;
   static Login loginpage;
   public static void main (String[]args)throws IOException,ClassNotFoundException{
   
      File file;
      User[] u=null;
      ObjectInputStream readoldusers=null;
      try{
         file =new File("data.data");
         readoldusers=new ObjectInputStream(new FileInputStream(file));
         u=(User[])readoldusers.readObject();
         System.out.println(u[0]);//for debuging
      }
      catch(FileNotFoundException e){
         System.out.println("we didn't find old users data");}
      catch(EOFException e){
         readoldusers.close();}
      data=new Planner(u);
   
      boolean flag=true;
      do{
         try{
            Home frame=new Home();
            frame.setVisible(true);
            flag=false;
         }
         catch(InputMismatchException e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
         } 
         catch(IOException e){
         }
      }while(flag);
   
   }//end main 
   
   
   public Home()throws IOException{
      setVisible(true);
      setSize(350, 700);
      setResizable(false);
   //setPreferredSize(new Dimension(300, 300));
   //save and close 
      addWindowListener(
         new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
               int confirm = JOptionPane.showOptionDialog(
                  null, "Are You Sure to Close Application?", 
                  "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                  JOptionPane.QUESTION_MESSAGE, null, null, null);
               if (confirm == JOptionPane.OK_OPTION)
                  saveUsers("data.data");
            }
         });
   
   
      setTitle("our perfect project ~<3");
      setBackground(Color.RED);
      setLocationRelativeTo(null);
      setLayout(new FlowLayout()/*new GridLayout(4,1,5,10)*/);//!!
      text=new JPanel();
      loginp=new JPanel(new GridLayout(3,2,0,0));//change layout
      //  loginp.setBounds(1000, 650, 100, 1000);
      loginp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      rgesp=new JPanel(new GridLayout(6,2,5,10));
      //what about borders and title 
      loginp.setBackground(Color.WHITE);
      loginp.setBorder (BorderFactory.createTitledBorder("login"));
      rgesp.setBackground(Color.WHITE);
      rgesp.setBorder (BorderFactory.createTitledBorder("register"));
      text.setBackground(Color.magenta);
      Container contentPane;
      //setResizable(false);
      //setLocation(400,250);
      contentPane=getContentPane();
      //contentPane.setLayout(new GridLayout(4,1,5,10)/*new FlowLayout(FlowLayout.LEFT)*/);
      //general
      BufferedImage pic = ImageIO.read(new File("home.png"));
      ImageIcon image=new ImageIcon(pic);
      //to change size!!
      //Image scaleImage = image.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
      JLabel picLabel = new JLabel(image);
      //image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
      text.add(picLabel);
      text1=new JLabel("hii it\'s our program ");
      text.add(text1);
      text.setSize(300,300);
      RBG = new ButtonGroup( );
      login = new  JRadioButton("login");
      regs =new  JRadioButton("register");
      login.setMnemonic(KeyEvent.VK_B);
      login.setActionCommand("login");
      login.setSelected(true);
      //regs.setMnemonic(KeyEvent.VK_B);
      regs.setActionCommand("reg");
      RBG.add(login);
      RBG.add(regs);
      login.addActionListener(this);//!!
      regs.addActionListener(this);
    
      contentPane.add(text);
      //contentPane.add(RBG);
      radio=new JPanel();
      radio.add(login);
      radio.add(regs);
      radio.setBackground(Color.WHITE);
      contentPane.add(radio);
   
   
      //login 
      usern= new JLabel("user name =>");
      pass=new JLabel("pass word =>");
      use=new JTextField();
      pw=new JPasswordField();
      pw.setColumns(10);
      log=new JButton("log in ");
      use.setColumns(10);
      loginp.add(usern);
      loginp.add(use);
      loginp.add(pass);
      loginp.add(pw);
      loginp.add(log);
      //setSize(100,25);
      log.setActionCommand("login");
      log.addActionListener(this); 
      
      
      //register 
      fname=new JLabel("frist name:");
      lname=new JLabel("Last name:");
      uname=new JLabel("user name:");
      password=new JLabel("pass word:");
      email=new JLabel("email:");
      f=new JTextField();
      f.setColumns(10);
      l=new JTextField(); 
      l.setColumns(10);
      u=new JTextField();
      u.setColumns(10);
      e=new JTextField();
      e.setColumns(10);
      p=new JPasswordField();
      p.setColumns(10);
      reg=new JButton("register");
      rgesp.add(fname);
      rgesp.add(f);
      rgesp.add(lname);
      rgesp.add(l);
      rgesp.add(email);
      rgesp.add(e);
      rgesp.add(uname);
      rgesp.add(u);
      rgesp.add(password);
      rgesp.add(p);
      rgesp.add(reg);
      reg.addActionListener(this); 
      
      /*contentPane.*/
      add(loginp);
      contentPane.add(rgesp);
      setEnabledAll(rgesp, false);
      exp=new JLabel();
      add(exp);
      //  rgesp.setEnabled(false);
      // rgesp.setHonorsVisibility(false);
   }
   
   
   //actions
   public void actionPerformed(ActionEvent event){
      if(event.getSource() instanceof JButton){
         if(event.getActionCommand().equals("login")){
            String u1=use.getText();
            String p1=pw.getText();
            if ( data.login(u1,p1) ){
               menu2(data.find(u1,p1));
               this.setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "try to rigistr");
         }
         else{
            if( data.registerUser(f.getText(),l.getText(),u.getText(),p.getText(),e.getText()) ){
            //exp.setText("you can login now");
               JOptionPane.showMessageDialog(null, "you can login now");
            //clear jtextfalid
            }
            else JOptionPane.showMessageDialog(null, "registration is fill,try again or login");
         }
      }
      else if(event.getSource() instanceof JRadioButton){
         if(event.getActionCommand().equals("login")){
            setEnabledAll(rgesp, false);
            setEnabledAll(loginp, true);
         }
         else{
            setEnabledAll(rgesp, true);
            setEnabledAll(loginp, false);
         }
      }
   }
   
   // public void jRadioButtonactionPerformed(ActionEvent event){
   //event.get+ e.getActionCommand() 
   // lablelogin.setAvilbilty(true);//!!
   
   public void menu2(User user){
      exp.setText("login sucssusful you can go to other frame");
      try{
         loginpage=new Login(user);
         loginpage.setVisible(true);
      }
      catch(IOException e){
         exp.setText("can't login ");
      }
   // loginpage.theuser(data.find(u1,p1));
   
   }
   public static void saveUsers(String fname)
   {
      try{
         File f= new File(fname);
         FileOutputStream fs= new FileOutputStream(f);
         ObjectOutputStream oos= new ObjectOutputStream(fs);
         oos.writeObject(data.getUsres());
      }
      catch (Exception e){}
      //System.exit(1);
      System.exit(0);
   // setDefaultCloseOperation( EXIT_ON_CLOSE);
   }
   public void setEnabledAll(/*Object object*/JPanel panel, boolean state) {
      for (Component c : panel.getComponents()) c.setEnabled(state);
   //if we want to pass other object E:button, textviwe....
   /* if (object instanceof Container) {
        Container c = (Container)object;
        Component[] components = c.getComponents();
        for (Component component : components) {
            setEnabledAll(component, state);
            component.setEnabled(state);
        }
    }
    else {
        if (object instanceof Component) {
            Component component = (Component)object;
            component.setEnabled(state);
        }
    }*/
   }
}//end Home