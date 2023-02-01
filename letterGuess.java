import java.util.Scanner;
import java.util.Random;

public class letterGuess {

  public static class player {
    String playerName;
    int score;
    int guesses = 15;
    int roundsWon = 0;
    int roundGuesses = 0;
  }

  public static void main(String[] args) {
    Scanner ask = new Scanner(System.in);
    String[] insultsArr = {"dick", "bitch", "cunt", "asshole", "fart face", "dickhead", "loser", "fuckface", "dipshit", "squazznain", "motherfucker", "cheese-wain", "flarnchalarnchagus", "scrub", "tasteless fool", "Garfunkel", "Captain Pee-Pants", "ya cunt", "ya squankelton"};
    String[] backTalkArr = {"That's fine, guess I'll just go f*ck myself then.", "Yeah, I'm sure you totally have better things to do.", "Fine! Go ahead! Leave! See if I care...", "You've really hurt my feelings today...", "I see how it is.", "WOOOOOW. Ok. Fine.", "Just gonna use me up and toss me out, is that it?", "Whatever, you lost anyway.", "Like I care. You suck at this game!", "I was tired of looking at your ugly mug anyway!", "Fuck you."};
    String[] lettersArr =  {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    final String DIVIDER_LINE = "=====================================";
    boolean isPlaying = true;
    String insult;
    String backTalk;
    String currentLetter;
    String userName;
    String response;
    String guess;
    player user = new player();
    Random rand = new Random();
    int randNum;

    System.out.println(DIVIDER_LINE);
    System.out.println("~*~*~*~*~*!!LETTER GUESS!!*~*~*~*~*~");
    System.out.println(" ----!AN ALPHABETICAL GOOD TIME!----");
    System.out.println(DIVIDER_LINE);

    // GETS PLAYER NAME
    System.out.println("Enter player name: ");
    user.playerName = ask.nextLine();
    
    // VERIFIES PLAYER NAME
    System.out.println("Is '" + user.playerName + "' correct? (Enter yes/no): ");
    response = ask.nextLine();
    while (!response.equalsIgnoreCase("yes")) {
      if (!response.equalsIgnoreCase("no")) {
        while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
        System.out.println("Invalid input.");
        System.out.println("Is '" + user.playerName + "' correct? (Enter yes/no): ");
        response = ask.nextLine();
        }
      } else {
        System.out.println("Enter player name: ");
        user.playerName = ask.nextLine();
        System.out.println("Is '" + user.playerName + "' correct? (Enter yes/no): ");
        response = ask.nextLine();
      }

      
    }
    userName = user.playerName;

    //GAME DESCRIPTION
    System.out.println(DIVIDER_LINE);
    System.out.println("--Welcome to the game, " + userName + "!--");
    System.out.println(DIVIDER_LINE);
    System.out.println("This is a guessing game.");
    System.out.println("Try to guess the random letter ");
    System.out.println("before your guesses run out.");
    System.out.println("If you guess the letter correctly, ");
    System.out.println("you win the round and receive points ");
    System.out.println("equivalent to your remaining guesses ");
    System.out.println("and +5 guesses for the next round.");
    System.out.println("If your guesses run out, you lose!");
    System.out.println(DIVIDER_LINE);
    System.out.println("------------- HAVE FUN! -------------");
    

    System.out.println("A letter has been randomly selected.");
    System.out.println("You have " + user.guesses + " guesses remaining.");
    
    //SETS THE RANDOM LETTER
    randNum = rand.nextInt(lettersArr.length);
    currentLetter = lettersArr[randNum];
    
    while (isPlaying) {

      //REPORTS SCORES AT THE START OF EACH ROUND
      if (user.roundGuesses == 0) {
        System.out.println(DIVIDER_LINE);
        System.out.println("Current Round: " + (user.roundsWon + 1));
        System.out.println("Rounds Won: " + user.roundsWon);
        System.out.println("Current Score: " + user.score);
        System.out.println(DIVIDER_LINE);
      }

      //PLAYER RUNS OUT OF GUESSES
      if (user.guesses == 0) {
        System.out.println(DIVIDER_LINE);
        System.out.println("You are out of guesses.");
        System.out.println("!!!GAME OVER!!!");
        System.out.println(DIVIDER_LINE);
        System.out.println(user.playerName + "'s Final Scores:");
        System.out.println(DIVIDER_LINE);
        System.out.println("Rounds Won: " + user.roundsWon);
        System.out.println("Score: " + user.score);
        System.out.println("Thanks for playing, " + user.playerName + "!");
        System.out.println(DIVIDER_LINE);
        
        //PLAY AGAIN??
        System.out.println("Would you like to play again?");
        System.out.println(" (Enter 'yes' or 'no'):");
        response = ask.next();
        
        //IF !YES/!NO ENTERED
        if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
          while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
            System.out.println("Please enter either 'yes' or 'no'.");
            System.out.println("Would you like to play again?:");
            response = ask.next();
          }
        }

        //IF YES OR NO ENTERED
        if (response.equalsIgnoreCase("yes")) {
          user.score = 0;
          user.guesses = 15;
          user.roundsWon = 0;
          randNum = rand.nextInt(lettersArr.length);
          currentLetter = lettersArr[randNum];
          System.out.println(DIVIDER_LINE);
          System.out.println("---------- GAME RESET ----------");
          System.out.println(DIVIDER_LINE);
          System.out.println("A letter has been randomly selected.");
          System.out.println("You have " + user.guesses + " guesses remaining.");
        } else {
          isPlaying = false;
          break;
        }

        
      }
      
      //GETS GUESS FROM USER
      System.out.println("Guess a letter: ");
      guess = ask.next().toUpperCase();

      //CHECKS/ENSURES THAT GUESS IS ONLY ONE CHARACTER
      while (guess.length() > 1) {
        System.out.println("Please enter a single character.");
        System.out.println("Guess a letter: ");
        guess = ask.next().toUpperCase();
      }
      
      //IF GUESS IS CORRECT, ADDS POINTS TO SCORE AND ADDS GUESSES
      if (guess.equals(currentLetter)) {
        user.roundsWon++;
        user.score += user.guesses;
        user.roundGuesses = 0;
        System.out.println("You guessed correctly!");
        System.out.println(user.guesses + " points have been added to your score.");
        user.guesses += 5;
        System.out.println("Current Score: " + user.score);
        System.out.println(DIVIDER_LINE);

        //ASKS USER IF THEY WANT TO CONTINUE TO THE NEXT ROUND
        System.out.println("Would you like to continue playing?");
        response = ask.next();
        
        //VERIFIES IF RESPONSE IS EITHER YES OR NO
        if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
          while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
            System.out.println("Please enter either 'yes' or 'no'.");
            System.out.println("Would you like to continue playing?");
            response = ask.next();
          }
        }
        
        //IF USER ENTERED NO, ENDS GAME
        if (response.equalsIgnoreCase("no")) {
          isPlaying = false;
          System.out.println(DIVIDER_LINE);
          System.out.println("Final Score:");
          System.out.println("Rounds Won: " + user.roundsWon);
          System.out.println("Score: " + user.score);
          System.out.println(DIVIDER_LINE);
          
          //IF USER ENTERED YES, RESETS CURRENT LETTER AND STARTS NEXT ROUND
        } else if (response.equalsIgnoreCase("yes")) {
          user.roundGuesses = 0;
          System.out.println("A letter has been randomly selected.");
          System.out.println("You have " + user.guesses + " guesses remaining.");
          System.out.println(DIVIDER_LINE);
          randNum = rand.nextInt(lettersArr.length);
          currentLetter = lettersArr[randNum];
        }

        //IF GUESS IS WRONG, SUBTRACTS 1 POINT AND CONTINUES THE ROUND
      } else {
        user.guesses--;
        user.roundGuesses++;
        System.out.println("Incorrect.");
        System.out.println("Guesses remaining: " + user.guesses);
      }
    }

    if (!isPlaying) {
      randNum = rand.nextInt(backTalkArr.length);
      backTalk = backTalkArr[randNum];
      System.out.println(backTalk);
      randNum = rand.nextInt(insultsArr.length);
      insult = insultsArr[randNum];
      System.out.println("Later, " + insult + "!");
      System.out.println("--program ended with sadness and resentment--");
      System.out.println(DIVIDER_LINE);
      ask.close();
      System.exit(0);
    }
  }
}