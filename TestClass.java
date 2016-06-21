// Author: Roshan Koirala
//         Computer Science - Sophomore
//         University of Louisiana at Monroe
// Date: 10/21/2014
// Programming Assignment for Crimson's Software Development Intern 2015

// A test class to test the Scoring interface, and Bowling class.


public class TestClass
{
   public static void main(String[] args)
   {
   
      Scoring g = new Bowling(); 
      
   
      System.out.println("\nThe current frame number is "+g.getCurrentFrame());
      System.out.println("The total number of throw attempt is "+g.getTotalThrows());
      System.out.println("The frame score for the given frame is "+g.frameScore(2));
      System.out.println("The total score of the game is "+ g.getTotalScore());
   
      System.out.println("Your Scoreboard is below :\n");
      g.displayScoreBoard();
   
   
   
   
   }
}