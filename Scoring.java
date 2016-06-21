// Author: Roshan Koirala
//         Computer Science - Sophomore
//         University of Louisiana at Monroe
// Date: 10/21/2014
// Programming Assignment for Crimson's Software Development Intern 2015


/**
  An interface to model a scoreboard controller for bowling game
*/
public interface Scoring
{
   
   
   /**
     Retrieves the current frame where the user is at
     @return an integer representing the current frame number
   */
   int getCurrentFrame();
   
   
   
   /**
     Retrieves the the total number of throws attempt a user has made
     @return an integer representing the total number of throws
   */
   int getTotalThrows();
   
   
   
   /**
     Calculates the total score of a given frame 
     @param FrameNumber The number of the frame whose score is to be calculated
     @return an integer representing the total score of the frame
   */
   int frameScore(int FrameNumber);
   
   
   /**
     Calculates and returns the total score of a bowling game 
     @return an integer representing the total score of the bowling game
   */
   int getTotalScore();
   
   
   
   /**
     Displays the scoreboard of a lane monitor during a Bowling game including the number of pins down in every throw, the frame score, the frame progression, and the total score of the game 
   */
   void displayScoreBoard();

}