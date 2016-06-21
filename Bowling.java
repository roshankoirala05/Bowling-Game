// Author: Roshan Koirala
//         Computer Science - Sophomore
//         University of Louisiana at Monroe
// Date: 10/21/2014
// Programming Assignment for Crimson's Software Development Intern 2015
// Program Description: A program that implements game state display of a lane monitor during a Bowling Game

import java.util.Scanner;                // importing required utilities


/**
   A Bowling class that implements scoring interface to compute  
   data that is displayed in a lane monitor during a Bowling game
 */ 
public class Bowling implements Scoring
{
   
   private int currentFrameNumber;
   private boolean firstThrowInFrame;
   private int roll;
   private  int[] Throws;
   private int currentThrowNumber;
   private Scanner keyboard = new Scanner(System.in);
   
 
 
 /**
   The constructor  initializes all the data fields, and starts playing the bowling game
  */
   public Bowling()
   {
      currentFrameNumber = 0;
      firstThrowInFrame = true;
      Throws = new int[21];
      currentThrowNumber = 0;
      play();
   }
   
  
  
  /**
     Gives back the current frame number where the user is at
     @return The value of the data field currentFrameNumber
   */
   public int getCurrentFrame()
   {
      return currentFrameNumber;
   }
   
   
   
   /**
     Gives back the total number of throws attempt a user has made 
     @return The value of the data field currentThrowNumber which equals to the total number of throws made
   */
   public int getTotalThrows()
   {
      return currentThrowNumber;
   }
   
   
   
   /**
     Calculates the total score of a given frame 
     @param FrameNumber The number of the frame whose score is to be calculated
     @return The value of the data field points which is the total score of a given frame
   */
   public int frameScore(int FrameNumber)
   {
      roll = 0;
      int points=0;
      for (int frameCounter = 0;frameCounter < FrameNumber;frameCounter++)
      {
         if (strike())
            points += 10 + Throws[roll] + Throws[roll+1];
         else if (spare())
            points += 10 + Throws[roll];
         else
         { points += Throws[roll] + Throws[roll+1];
            roll+=2; }
      }
      return points;
   
   }

   
   
   /**
     Calculates and returns the total score of a bowling game 
     @return The value obtained by calling frameScore method with final frame number as argument
   */
   public int getTotalScore()
   {
      return frameScore(currentFrameNumber);
   }

   
   
   /**
     Displays the scoreboard of a lane monitor during a Bowling game 
     including the number of pins down in every throw, the frame score, 
     the frame progression, and the total score of the game 
   */
   public void displayScoreBoard()
   {
      System.out.println("\n********************************************* BOWLING SCOREBOARD ***********************************************");
      System.out.print("  Frame ");
      for( int i = 0; i<21; i++)
      {
         if( Throws[i]==10)
            System.out.print("STRIKE  ");
                  
         else 
            System.out.print(Throws[i]+"   ");
      }
      
      System.out.print("\n  Score  ");
      for( int i = 1; i<=10; i++)
      {
         System.out.print(frameScore(i)+"\t ");
      }
      System.out.println("\n****************************************************************************************************************");
   }

   
   
   /**
    Gives option to play a complete Bowling game ( 10 Frames), or to play just few throws
   */
   private void play()
   {
      System.out.println("------------------------Welcome to Roshan's Bowling Alley-------------------------------------");
      System.out.println("Enter C to play complete Bowling Game ( 10 Frames ), or Enter F to play just few throws");
      String response = (String)keyboard.next();
      
      if ( response.equalsIgnoreCase("C"))
         completePlay();
      
      else if( response.equalsIgnoreCase("F"))
         fewThrowsPlay();
      
      else
         play();
   }
   
   
   
   /**
     Starts a complete Bowling game with 10 frames
   */
   private void completePlay()
   {
      int lastFrameCheckForSpare=0;
      printGameRules();
      System.out.println("\nEnter the number of pins down each time you throw.\n");
            
      for ( int i = 0; i<21; i++)
      {
         System.out.println("How many pins down in this throw ?");
         int pinsDown = keyboard.nextInt();
         
         addThrow(pinsDown);
        
        // Skipping a throw in a frame if it is a Strike, except for the last frame        
         if(pinsDown ==10 && i!=18 && i!=19 && i!=20)
            i++;
         
         if( i ==18)
            lastFrameCheckForSpare = pinsDown;
         
         // Skippinng the last throw in the last frame, if the frame is not a Strike or a spare
         if ( i == 19 && (lastFrameCheckForSpare+pinsDown) < 10 )
            i++;
      }
   }
   
   
   
   /**
     Starts a Bowling game, and allows user to play few throws
   */
   private void fewThrowsPlay()
   {
      printGameRules();
      System.out.println("\nHow many frames you wanna play ?");
      int number = keyboard.nextInt();
      System.out.println("\nEnter the number of pins down each time you throw.\n");
      
      for ( int i = 0; i< (number*2); i++)
      {
         System.out.println("How many pins down in this throw ?");
         int pinsDown = keyboard.nextInt();
         addThrow(pinsDown);
         
         //Skipping a throw in a frame if it is a Strike
         if(pinsDown ==10 )
            i++;
      }
   }

   
   
   /**
     Adds in the number of pins downs in each throw,and updates the current frame each time a throw is added
   */
   private void addThrow(int numberOfPinsDown)
   {
      Throws[currentThrowNumber] = numberOfPinsDown;
      currentThrowNumber++;
      
      //Updating the current frame each time a throw is added
      
      if (firstThrowInFrame == true)
      {
         if (numberOfPinsDown == 10)
            progressFrame();
         
         else
            firstThrowInFrame = false;
      }
      else
      {
         firstThrowInFrame=true;
         progressFrame();
      }
   }
   
   
   
   /**
     Advances the current frame when throws are added
   */
   private void progressFrame()
   {
      currentFrameNumber = currentFrameNumber + 1; 
      
      // Making sure the current frame number doesn't exceed 10
      if( currentFrameNumber>=10)
         currentFrameNumber = 10;
   }

  
  
  /**
     Checks if a throw is a Strike or not
     @return True if a throw is a Strike, false otherwise
   */
   private boolean strike()
   {
      if (Throws[roll] == 10)
      {
         roll++;
         return true;
      }
      return false;
   }

  
  
  /**
     Checks if a frame is a spare or not
     @return True if a frame is a spare, false otherwise
   */
   private boolean spare()
   {
      if ((Throws[roll] + Throws[roll+1]) == 10)
      {
         roll += 2;
         return true;
      }
      return false;
   }

      
   
   /**
      Prints the rule for Bowling game 
   */
   private void printGameRules()
   {
      System.out.println("**********************************Game Rules******************************");
      System.out.println("Please keep in mind that the maximum number of pins down in every ");
      System.out.println("second throw of a frame is the number of pins remaining after first throw.");
      System.out.println("Remember to put the valid no. of pins down in every second throw.");
   }
}