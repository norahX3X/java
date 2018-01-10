/*
 */
import java.io.*;
import java.util.*;

public class RatingManager {
//LinkedList<LinkedList<Rating>> RatingsList;// linked list for items
   BST<BST<Rating>> usersTree;
   BST<BST<Rating>> items;
// n is number of users, m number of items 
   int n, m;

	// Constructor
   public RatingManager(){
      usersTree=new BST<BST<Rating>>();
      items=new BST<BST<Rating>>();
      n=0;
      m=0;
   }
	
	// Read ratings from a file and create a RatingManager object that stores these ratings. The ratings must be inserted in their order of appearance in the file.
   public static RatingManager read(String fileName) throws IOException{
   
      RatingManager fileNameRatingManager = new RatingManager();
   
      File file= new File(fileName);
      Scanner input= new Scanner(file);
     
      String line = null;
      int userId, itemId, value;
      String[]  arr;
   
      LinkedList<Rating> tmpList;
      while (input.hasNext()) {
         line=input.nextLine();
         
         arr = line.split("\\t");
         userId=Integer.parseInt(arr[1]);
         itemId=Integer.parseInt(arr[2]);
         value=Integer.parseInt(arr[3]);
         fileNameRatingManager.addRating(new Rating(userId, itemId, value));
      }
   /*to get num of user and num of items in total
         if(rm.userExists(userId)){
            tmpList = fileNameRatingManager.userList.retrieve();
            tmpList.insert(rating);
         }//end if
         else{
            tmpList= new LinkedList<Rating>();
            tmpList.insert(rating);
            fileNameRatingManager.userList.insert(tmpList);
            fileNameRatingManager.n= fileNameRatingManager.n +1;
         }//end else
         
         if(rm.itemExists(itemId)){
            tmpList = rm.itemList.retrieve();
            tmpList.insert(rating);
         }//end if
         else{
            tmpList= new LinkedList<Rating>();
            tmpList.insert(rating);
            rm.itemList.insert(tmpList);
            rm.m= rm.m +1;
         }//end else 
         
      }// end while*/
      input.close();
      return fileNameRatingManager;
   }//end read method
   
	// Add a rating
   public void addRating(Rating rating){
      BST<Rating> tmp;
   
      if(usersTree.findKey(rating.getUserId())){
         tmp = usersTree.retrieve();
         tmp.insert(rating.getItemId(),rating);
      }//end if
      else{
         tmp= new BST<Rating> ();
         tmp.insert(rating.getItemId(),rating);
         usersTree.insert(rating.getUserId(),tmp);
         n++;
      }//end else
      
      if(items.findKey(rating.getItemId())){
         tmp = items.retrieve();
         tmp.insert(rating.getUserId(),rating);
      }//end if
      else{
         tmp= new BST<Rating> ();
         tmp.insert(rating.getUserId(),rating);
         items.insert(rating.getItemId(),tmp);
         m++;
      }//end else
         
   }//end addRating
	
   	// Return all ratings given by user i. 

   public LinkedList<Rating> getUserRatings(int i){
      BST<Rating> temp;
      if(usersTree.findKey(i)){
         temp=usersTree.retrieve();
         return temp.getAllData();
      }//if not found 
      return new LinkedList <Rating> () ;
   }
	
	// Return all ratings given to item j
   public LinkedList<Rating> getItemRatings(int j){
      BST<Rating> temp=null;
      if(items.findKey(j)){
         temp=items.retrieve();
         return temp.getAllData();}
      return new LinkedList <Rating> () ;
      
   }
	// Return the average rating of item j. If i has no ratings, -1 is returned
   public double getAverageItemRating(int j){
   
      LinkedList <Rating> itemRatings= getItemRatings(j);
   
      if(itemRatings.empty())
         return -1;
   
      itemRatings.findFirst();
      int count=1;
      double sum=0;
      while(!itemRatings.last()){
         sum+=itemRatings.retrieve().getValue();
         count++;
         itemRatings.findNext();
      }
      sum+=itemRatings.retrieve().getValue();
      return sum/((double)count);
   }  
   
	// Return the average rating given by user i. If i has no ratings, -1 is returned
   public double getAverageUserRating(int i){
   
      LinkedList <Rating> ratingavg=getUserRatings(i);
      
      if(ratingavg.empty())
         return -1;
      
      ratingavg.findFirst();
      int count=1;
      double sum=0;
      while(!ratingavg.last()){
         sum+=ratingavg.retrieve().getValue();
         count++;
         ratingavg.findNext();  
      }
      sum+=ratingavg.retrieve().getValue();
      if (sum==0)
         return -1;
      else{
         return   sum/((double)count);
      }
   }
   ///new methods
    // Return the rating of user i for item j. If there is no rating, -1 is returned.*/
   public int getRating(int i, int j){
      if (usersTree.findKey (i)){
         BST <Rating> temp=usersTree.retrieve();
         if (temp.findKey (j))
            return temp.retrieve().getValue();}
      return  -1;
   }
   public LinkedList<Integer> getHighestRatedItems(){
   
      LinkedList<BST<Rating>> itemsList= new LinkedList<BST<Rating>>();
      itemsList = items.getAllData();
      LinkedList<Integer> High = new LinkedList<Integer>();
      double [] avgs = new double [m];
      int i=0;
      int id;
      if(itemsList.empty())
         return High;
   // possessing avgs
      itemsList.findFirst();
      while ( true ) {
         id = itemsList.retrieve().retrieve().getItemId();
         avgs[i++]= getAverageItemRating (id); 
         if (itemsList.last())
            break;
         itemsList.findNext();
      }
   
   // find max
      itemsList.findFirst();
      double max = avgs[0];
      for ( i=1; i<avgs.length; i++)
         if (max < avgs[i] )
            max = avgs [i];
   //return max; 
   
   // possessing max avgs
      itemsList.findFirst();
      int j=0;
      for (i=0; i<avgs.length; i++){
         if ( avgs[i] == max ) {
            itemsList.findFirst();
            for (int k=0; k<i; k++)
               itemsList.findNext();
            High.insert(itemsList.retrieve().retrieve().getItemId());
         }
      } 
   
      return High; 
   
   }
	// Return the number of keys to compare with in order to find the rating of user i for item j.
   public int nbComp(int i, int j){
      int u= usersTree.nbComp (i);
      if (usersTree.findKey (i)){
         BST <Rating> temp=usersTree.retrieve();
         return temp.nbComp(j)+u;}
      return  u;
    
   }

	// Compute the distance between the two users ui and uj. If ui and uj have no common item in their ratings, then Double.POSITIVE_INFINITY is returned.
   public double getDist(int ui, int uj){
      LinkedList<Rating> uiItems=  new LinkedList<Rating> ();
      LinkedList<Rating> ujItems=  new LinkedList<Rating> (); 
      boolean nocommn=true;
       
      if(usersTree.findKey(ui)){
          //BST<Rating> s=usersTree.retrieve();
         // if(s.empty()){System.out.print("empty BST");
         uiItems= usersTree.retrieve().getAllData() ;
      }
   
      if(usersTree.findKey(uj)){  
         ujItems= usersTree.retrieve().getAllData() ;
      }
    
      if(uiItems.empty()||ujItems.empty())
         return Double.POSITIVE_INFINITY;

      uiItems.findFirst ();
      Rating tempi= uiItems.retrieve();
      int n=0;
      double exp=0;
   
      while(true){
         ujItems.findFirst();
         Rating tempj= ujItems.retrieve () ;
         while(true){
            if(tempi.getItemId()==tempj.getItemId()){
               exp+=Math.pow((tempi. getValue()-tempj. getValue()),2);
               n++;
               nocommn=false;
            }
            if (ujItems.last())
               break;
            ujItems.findNext () ;
            tempj=ujItems.retrieve () ; 
         }
         if (uiItems.last())
            break;
         uiItems.findNext () ;
         tempi=uiItems.retrieve () ;
      }
       
      if(nocommn)
         return Double.POSITIVE_INFINITY; 
      else{
         return Math.sqrt(exp)/((double)n);
                  
                  
      }
           // LinkedList<Ratinng> like=  sameItem(uiList,ujList,new LinkedList<Ratinng>());
   //new INTRGER send with method 
   }

		/* Return a list of at most k nearest neighbors to user i from a list of users. 
      User i and users at infinite distance should not be included 
      (the number of users returned can therefore be less than k). */
   public  LinkedList<Integer> kNNUsers(int i, LinkedList<Integer> users, int k){
      LinkedList<Integer> nUsers=new LinkedList<Integer>();
      if (users.empty ())
         return nUsers;
      users.findFirst();
      int n=1;//what if nothing ?
      while(!users.last()){
         users.findNext();
         n++;}
    //  System.out.print(n);
      PQ<PQElem<Integer>> dist=new PQ<PQElem<Integer>>(n);//k//+1??
     //LinkedList<Rating> rating;
      double test=0;
      users.findFirst();
      while(!users.last())
      
      {
         test=getDist(i,users.retrieve());//??
         if(test!=Double.POSITIVE_INFINITY)
            dist.enqueue(test,new PQElem<Integer>(test,users.retrieve()));
         users.findNext();
      }
      test=getDist(i,users.retrieve());//??
      if(test!=Double.POSITIVE_INFINITY)
         dist.enqueue(test,new PQElem<Integer>(test,users.retrieve()));
      while (dist.length()>k){
         dist.serve();
      }
              
      while(dist.length()!=0)
         nUsers.insert (dist.serve().data.data);
      
      return nUsers;
   }

	/* Return the average rating given to item j by a list of users. 
   If the list users is empty or non of the users it contains rated item j, 
   then the global average rating of item j 
   (as computed by getAverageItemRating(j)) is returned. */
   public double getAverageRating(int j, LinkedList<Integer> users){
   
      LinkedList<Rating> itemsList= new LinkedList<Rating>();
      itemsList = getItemRatings(j);
   
      if ( users.empty() || itemsList.empty() )
         return getAverageItemRating(j);
   
      users.findFirst();
      int rated=0;
      int userIDusers, userIDitems;
      LinkedList<Integer> rates= new LinkedList<Integer>();
   
      while (true){ 
         userIDusers=users.retrieve();
         itemsList.findFirst();
         while (true){
            userIDitems=itemsList.retrieve().getUserId();
            
            if ( userIDitems == userIDusers ){
               rated++;
               rates.insert( itemsList.retrieve().getValue() ); 
               break;}
            
            if(itemsList.last())
               break;
            itemsList.findNext(); }
      
         if(users.last())
            break;
         users.findNext(); }
   
   
      if (rated==0)
         return getAverageItemRating(j);
   
      double sum=0;
      rates.findFirst();
      while (true){
      
         sum+=rates.retrieve();
         if ( rates.last())
            break;
         rates.findNext(); }
    
    
      return sum/rated; }
    
	// Return an estimation of the rating given by user i for item j using k nearest neighbor users.
   public double getEstimatedRating(int i, int j, int k) {
      int r = getRating(i, j);
      if (r != -1) {
         return r;
      }
      LinkedList<Rating> ratings = getItemRatings(j);
      LinkedList<Integer> users = new LinkedList<Integer>();
      if ((ratings != null) && !ratings.empty()) {
         ratings.findFirst();
         while (!ratings.last()) {
            users.insert(ratings.retrieve().getUserId());
            ratings.findNext();
         }
         users.insert(ratings.retrieve().getUserId());
      }
      LinkedList<Integer> knn = kNNUsers(i, users, k);
      return getAverageRating(j, knn);
   }

}//end class
