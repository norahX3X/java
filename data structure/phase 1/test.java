import java.util.*;
import java.lang.Math;
import java.io.*;
import java.util.ArrayList;


public class test {

   public static void main(String []args)throws IOException {
   
      RatingManager manager = RatingManager.read("ratings.txt"); //new ();
     //manager=  manager.read("ratings.txt");
      
      System.out.println();
      System.out.println("///////// 1 /////////");
      System.out.println("test method addRating");
      // 1
      manager.addRating(new Rating(12345, 32, 3));
      manager.addRating(new Rating(12345, 4323, 1));
      manager.addRating(new Rating(12345, 53, 5));
      manager.addRating(new Rating(12345, 9, 4));
      manager.addRating(new Rating(12345, 9, 3));
      manager.addRating(new Rating(12345, 5464, 2));
      manager.addRating(new Rating(342, 5464, 2));
      manager.addRating(new Rating(74, 4323, 4));
      manager.addRating(new Rating(74, 5464, 3));
      manager.addRating(new Rating(100, 5464, 3));
      manager.addRating(new Rating(212, 5464, 4));
      manager.addRating(new Rating(304, 5464, 5));

      System.out.println("add manager: "+manager.toString());
      
      
      
      System.out.println();
      System.out.println("///////// 2 /////////");
      System.out.println("test method getUserRatings");
      //2
      LinkedList<Rating> UserRatings = manager.getUserRatings(12345);
      if (UserRatings.empty())
      System.out.println("UserRatings is empty");
      else {
      UserRatings.findFirst();
      while ( ! UserRatings.last() ){
      System.out.println("UserRatings: "+UserRatings.retrieve().toString());
      UserRatings.findNext();} /*last*/System.out.println("UserRatings: "+UserRatings.retrieve().toString());
      }
      
      
      System.out.println();
      System.out.println("///////// 3 /////////");
      System.out.println("test method getItemRatings");
      //3
      LinkedList<Rating> ItemRatings = manager.getItemRatings(5464);
      if (ItemRatings.empty())
      System.out.println("ItemRatings is empty");
      else {
      ItemRatings.findFirst();
      while ( ! ItemRatings.last() ){
      System.out.println("ItemRatings: "+ItemRatings.retrieve().toString());
      ItemRatings.findNext();} /*last*/System.out.println("ItemRatings: "+ItemRatings.retrieve().toString());
      }
      
      
      System.out.println();
      System.out.println("///////// 4 /////////");
      System.out.println("test method getAverageItemRating");
      //4
      System.out.println("AverageItemRating for item number 324234 is: " + manager.getAverageItemRating(324234));
      System.out.println("AverageItemRating for item number 9 is: " + manager.getAverageItemRating(9));
      System.out.println("AverageItemRating for item number 53 is: " + manager.getAverageItemRating(53));
      System.out.println("AverageItemRating for item number 5464 is: " + manager.getAverageItemRating(5464));
      
      
      
      System.out.println();
      System.out.println("///////// 5 /////////");
      System.out.println("test method getAverageUserRating");
      //5
      System.out.println("AverageUserRating for user number 54321 is: " + manager.getAverageUserRating(54321));
      System.out.println("AverageUserRating for user number 74 is: " + manager.getAverageUserRating(74));
      System.out.println("AverageUserRating for user number 100 is: " + manager.getAverageUserRating(100));
      System.out.println("AverageUserRating for user number 12345 is: " + manager.getAverageUserRating(12345));
      
      
      
      System.out.println();
      System.out.println("///////// 6 /////////");
      System.out.println("test method getHighestRatedItems");
      //6
      LinkedList<Integer> HighestRatedItems = manager.getHighestRatedItems();
      if (HighestRatedItems.empty())
      System.out.println("HighestRatedItems is empty");
      else {
      HighestRatedItems.findFirst();
      while ( ! HighestRatedItems.last() ){
      System.out.println("HighestRatedItems: "+HighestRatedItems.retrieve().toString());
      HighestRatedItems.findNext();} /*last*/System.out.println("HighestRatedItems: "+HighestRatedItems.retrieve().toString());
      }
      
      }}
   
