package PROJECTS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

class HiLo {


  Scanner sc=new Scanner(System.in);
  private final Random generator;
  private int generatedNumber;
  private int numberOfAttempts;
  BufferedReader reader = null;
  public String name;
  private int attempts=10;

  public HiLo() {
    generator = new Random();
    reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public void start() throws IOException {

    boolean wantToPlay = false;
    boolean firstTime = true;

    Calendar calendar=Calendar.getInstance();
        System.out.println("Date: "+calendar.get(Calendar.DATE)+"-"+(calendar.get((Calendar.MONTH))+1 )+"-"+calendar.get(Calendar.YEAR));
        System.out.println("Time: "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));

        System.out.print("Enter your Name : ");
        name=sc.nextLine();

    do {
      System.out.println("\n\nWant to play the game of High and Low ??");

      if (wantToPlay = prompt()) {
        generatedNumber = generateSecretNumber();
        numberOfAttempts = 0;
        if (firstTime) {
          describeRules();
          firstTime = false;
        }
        playGame();
      }

    } while (wantToPlay);

    System.out.println("\nThanks for playing the game. Hope you loved it !!");
    reader.close();
  }

  private void describeRules() {

    System.out.println("\nOnly 2 Rules:");
    System.out.println("1) Guess the secret number in maximum 10 tries.");
    System.out.println("2) The secret number is an integer between 1 and 100, inclusive :-)\n\n");
  }

  private int generateSecretNumber() {
    return (generator.nextInt(100) + 1);
  }

  private void playGame() throws IOException {

    while (numberOfAttempts < 10) {

      System.out.println("You have only "+attempts+" chance.");
      System.out.println();

      int guess = getNextGuess();

      if (guess > generatedNumber) {
        System.out.println("HIGH");
      } else if (guess < generatedNumber) {
        System.out.println("LOW");
      } else {
        System.out.println("Brave Soul, You guessed the right number!! Congratulations !!");
        return;
      }
      attempts--;
      numberOfAttempts++;
    }

    System.out.println("Sorry, you didn't guess the right number in TEN attempts !!");
    System.out.println("The secret number was " + generatedNumber);

  }

  private boolean prompt() {

    boolean answer = false;

    try {

      boolean inputOk = false;
        
      while (!inputOk) {
        
        
        System.out.print("Y / N : ");
        String input = reader.readLine();
        if (input.equalsIgnoreCase("y")) {
          inputOk = true;
          answer = true;
        } else if (input.equalsIgnoreCase("n")) {
          inputOk = true;
          answer = false;
        } else {
          System.out.println(
              "Ohh come on. Even Mr."+name+" knows where are 'y' and 'n' in the keyboard?? Please try again:");
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(-1);
    }

    return answer;
  }

  private int getNextGuess() throws IOException {

    boolean inputOk = false;
    int number = 0;
    String input = null;
    while (!inputOk) {
      try {

        System.out.print("Please guess the secret number: ");
        input = reader.readLine();
        number = Integer.parseInt(input);
        if (number >= 1 && number <= 100) {
          inputOk = true;
        } else {
          System.out.println(
              "Really? You didn't read the rules boy. Your number is not between 1 and 100 ("
                  + number + ").");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input (" + input + ")");
      }
    }

    return number;
  }
}


public class GuessingGame {
    public static void main(String[] args) {
         HiLo hiLo = new HiLo();
    try {
      hiLo.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
}
