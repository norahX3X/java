
import java.util.*;
import java.io.*;

public class RatingManager {
   LinkedList <Rating> RatingsList;

	// Constructor
   public RatingManager(){
      RatingsList = new LinkedList <Rating>();
   }
   
   // Read ratings from a file and create a RatingManager object that stores these ratings
   public static RatingManager read(String fileName)throws IOException {
      RatingManager fileNameRatingManager = new RatingManager();
      File file = new File (fileName);
      Scanner input = new Scanner (file);
      
      String line = null;
      int userId, itemId, value;
      String[]  arr;
   
      while (input.hasNext()) {
         line=input.nextLine();
         
         arr = line.split("\\t");
         userId=Integer.parseInt(arr[1]);
         itemId=Integer.parseInt(arr[2]);
         value=Integer.parseInt(arr[3]);
      
         fileNameRatingManager.addRating(new Rating(userId, itemId, value));
      }
   
      input.close();
      return fileNameRatingManager;
   }   
	
   // Add a rating
   public void addRating(Rating rating){
   if(rating==null)return;
      RatingsList.insert(rating);}
   	
	// Return all ratings given by user i. Search should be efficient. 
	//error
   public LinkedList<Rating> getUserRatings(int i){
      LinkedList<Rating> UserRatings = new LinkedList<Rating>();
   
      RatingsList.findFirst();
   
   
   while ( ! RatingsList.last() ){
   if ( RatingsList.retrieve().getUserId() == i )
   UserRatings.insert( RatingsList.retrieve() );
   RatingsList.findNext();
   }
   if ( RatingsList.retrieve().getUserId() == i ) // for the last element
   UserRatings.insert( RatingsList.retrieve() );
   
      return UserRatings; 
   }
	
	
   // Return all ratings given to item j. Search should be efficient.
   //error !!
   public LinkedList<Rating> getItemRatings(int j){
      LinkedList<Rating> ItemRatings = new LinkedList<Rating>();
    if(RatingsList.empty())//!!!
   return ItemRatings;
      RatingsList.findFirst();
   
      
   while ( ! RatingsList.last() ){
   if ( RatingsList.retrieve().getItemId() == j )
   ItemRatings.insert( RatingsList.retrieve() );
   RatingsList.findNext();
   }
   if ( RatingsList.retrieve().getItemId() == j ) // for the last element
   ItemRatings.insert( RatingsList.retrieve() );
  
   
      return ItemRatings; 
   }
	
	// Return the average rating of item j. If i has no ratings, -1 is returned
   public double getAverageItemRating(int j){
      double AverageItemRating = 0;//
      double numOfRatings = 0;
      LinkedList<Rating> ItemRatings = getItemRatings(j);
      if ( ItemRatings.empty() )
         return -1;//AverageItemRating;
   
      ItemRatings.findFirst();
      while (! ItemRatings.last() ) {
         AverageItemRating += ItemRatings.retrieve().getValue();
         ItemRatings.findNext(); 
         numOfRatings++;}
      AverageItemRating += ItemRatings.retrieve().getValue(); // for the last element in ItemRatings list.
      numOfRatings++;
   
      return (AverageItemRating/numOfRatings) ;
   }
	
	// Return the average rating given by user i. If i has no ratings, -1 is returned
   public double getAverageUserRating(int i){
      double AverageUserRating= 0;//-1;
      double numOfRatings = 0;
   
      LinkedList<Rating> UserRatings = getUserRatings (i);
   
      if ( UserRatings.empty() )
         return -1;//AverageUserRating;
   
      UserRatings.findFirst();
      while (! UserRatings.last() ) {
         AverageUserRating += UserRatings.retrieve().getValue();
         UserRatings.findNext(); 
         numOfRatings++;}
      AverageUserRating += UserRatings.retrieve().getValue(); // for the last element in ItemRatings list.
      numOfRatings++;
   
      return (AverageUserRating/numOfRatings) ;
   }
	
	// Return the list of all items having the highest average rating (for example if the highest average rating is 4.9, the method should return all items with average rating 4.9)
   public LinkedList<Integer> getHighestRatedItems(){//error 
      LinkedList<Integer> HighestRatedItems = new LinkedList<Integer>();
      LinkedList<Integer> done = new LinkedList<Integer>();
       
      if ( RatingsList.empty() ) 
         return null; // HighestRatedItems will be empty too.
   
      RatingsList.findFirst();
      done.insert(RatingsList.retrieve().getItemId());
      double max=getAverageItemRating(RatingsList.retrieve().getItemId());//RatingsList.retrieve().getValue(); 
      

      RatingsList.findFirst();
      while ( ! RatingsList.last() ){
      boolean found=false;
      if(!done.empty())
       
      {    done.findFirst();
      while(!done.last())
      {   if(done.retrieve() == RatingsList.retrieve().getItemId() )
      {found = true;
      break;
      }
      done.findNext();}
      if(done.retrieve() == RatingsList.retrieve().getItemId() )
      found = true;}
      
      if(!found)
      {  int id=RatingsList.retrieve().getItemId();
          done.insert(id);
      double ave=getAverageItemRating(id);
          if ( max < ave )
            max = ave; 
            RatingsList.findFirst();}
         RatingsList.findNext();
      }
      //  if ( max < getAverageItemRating(RatingsList.retrieve().getItemId()) )//lastone
         //   max = getAverageItemRating(RatingsList.retrieve().getItemId());
   LinkedList<Integer> done2 = new LinkedList<Integer>();
      RatingsList.findFirst();
     while ( ! RatingsList.last() ){
      boolean found=false;
            if(!done2.empty())
        
            {  done2.findFirst();
      while(!done2.last())
      {   if(done2.retrieve() == RatingsList.retrieve().getItemId() )
      {found = true;
      break;
      }
      done2.findNext();}
      if(done2.retrieve() == RatingsList.retrieve().getItemId() )
      found = true;
            }
      if(!found)
      { int id=RatingsList.retrieve().getItemId();
          done2.insert(id);
      double ave= getAverageItemRating(id) ;
          if ( max == ave)
            HighestRatedItems.insert(id); 
            RatingsList.findFirst();}
         RatingsList.findNext();
      }
  
            
            return HighestRatedItems; 
            
        // RatingsList.findNext(); 
      }        // for the last element
 // if ( max == getAverageItemRating(RatingsList.retrieve().getItemId())){
    //     if(!found(HighestRatedItems,RatingsList.retrieve().getItemId()))
      //      HighestRatedItems.insert(RatingsList.retrieve().getItemId());}
      
 
   
   public boolean found(LinkedList<Integer> t,int id){
   if(!t.empty()){
   t.findFirst();
    while ( ! t.last() ){
         if ( id == t.retrieve() )
         return true;
         t.findNext(); 
      }       
    if ( id == t.retrieve() )//last one 
         return true;}
   return false;
   }
}