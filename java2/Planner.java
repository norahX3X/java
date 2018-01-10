public class Planner {

//attribuites 
   private int numOfUsers=0;
   private transient User[] usersList;
   public User currentUser;
   
//constructor
   public Planner(User[] users) {
   if (users==null){
   usersList=new User[100];}
   else{
      int size= users.length;
      usersList=new User[size+1];//+1 
      //System.out.println(size);
      int j=0;
      for (int i=0; i<size; i++) 
         if (users[i] != null) {
            usersList[j++]=users[i]; 
            //usersList[numOfUsers++]=users[i]; 
            numOfUsers++;}
            }
   }
   
   
//method register user
   public boolean registerUser(String fName,String lName,String uName,String password,String email) {
      if ( usersList.length > numOfUsers ) {
      //check if the user alredy regitered!
         for(int i=0; i<=numOfUsers; i++){
         if(usersList[i]!=null){
                     if (!(uName.equals(usersList[i].getUserName()))){
               usersList[numOfUsers++]=new User(fName,lName,uName,password,email);
               return true; }}
             else {usersList[numOfUsers++]=new User(fName,lName,uName,password,email);
             return true;
             }}
             }
      return false;  }
   
   
//method log in
   public boolean login(String uName,String password) {
      for(int i=0; i<numOfUsers; i++) {
         if ( (usersList[i].getUserName().equals(uName)) && (usersList[i].getPssword().equals(password)) ) {
            System.out.println("Successfully logged in");
               currentUser=new User(usersList[i]);
            return true; }}
      System.out.println("Either username or password is wrong.");
      return false; }

   public User[] getUsres() {return usersList;}
  // public void dec(){numOfUsers--;}
  //to now witch user login
     public User find(String uName,String password) {
      for(int i=0; i<numOfUsers; i++) 
         if ( (usersList[i].getUserName().equals(uName)) && (usersList[i].getPssword().equals(password)) ) {
            return usersList[i]; }
      return null; }

} //End of Planner class