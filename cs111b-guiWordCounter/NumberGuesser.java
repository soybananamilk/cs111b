import java.util.ArrayList;


public class NumberGuesser {

  protected int low;
  protected int high;

  private int originalLow;
  private int originalHigh;
  
  private ArrayList<Integer> guessHistory;
  private int guess; 


  public NumberGuesser(int low, int high) {
    this.originalHigh = high;
    this.high = high;

    this.originalLow = low;
    this.low = low;
    ArrayList<Integer> guessHistory = new ArrayList<Integer>();
    //insert arraylist to constructor
    
  }

  public int getCurrentGuess() {
    guess = (low + high) / 2;

    // every guess is added to array
    return guess;
    
  }
  public ArrayList<Integer> getGuessHistory(){
    return new ArrayList<Integer>(this.guessHistory);
      }

  public void higher() throws NumberGuesserIllegalStateException {
    checkForCheating();
    low = getCurrentGuess() + 1;
  }

  public void lower() throws NumberGuesserIllegalStateException {
    checkForCheating();
    high = getCurrentGuess() - 1;
  }

  public void reset() {
    low = originalLow;
    high = originalHigh;
  }

  private void checkForCheating() throws NumberGuesserIllegalStateException {
    if (this.low >= this.high) {
      throw new NumberGuesserIllegalStateException("No guesses left");
    }
  }
}