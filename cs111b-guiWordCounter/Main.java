//cs111b catherine montano
// GUI Word Counter
/**
 * Fork this repl to use as the starting point
 * for your project
 *
 * You will be modifying the actionPerformed method
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class Main extends JFrame implements ActionListener  {

  private JLabel guessLabel;
  private JTextField guessField;
  private JButton lowerButton;
  private JButton higherButton;
  private JButton correctButton;
  private JButton resetButton;
  private NumberGuesser RNG;

  public Main() {
    RNG = new NumberGuesser(1, 100);
    // Used to specify GUI component layout
    GridBagConstraints positionConst = null;

    // Set frame's title
    setTitle("Word Counter");

    // Create the display for the guess
    guessLabel = new JLabel("File Name: ");

    guessField = new JTextField(15);
    guessField.setEditable(false);
    guessField.setText(String.valueOf(RNG.getCurrentGuess()));

    //instantiate?
    lowerButton = new JButton("Lower");
    higherButton = new JButton("Higher");
    correctButton = new JButton("Correct");
    resetButton = new JButton("Reset");
    
    // Use "this" class to handle button presses
    lowerButton.addActionListener(this);
    higherButton.addActionListener(this);
    correctButton.addActionListener(this);
    resetButton.addActionListener(this);

    // Use a GridBagLayout
    setLayout(new GridBagLayout());
    positionConst = new GridBagConstraints();

    // 10 pixels vert, 5 horizontal around components
    positionConst.insets = new Insets(10, 5, 10, 5);

    // Add component using the specified constraints
    positionConst.gridx = 0;
    positionConst.gridy = 0;
    add(guessLabel, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 0;
    add(guessField, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 0;
    add(resetButton, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 2;
    add(lowerButton, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 2;
    add(higherButton, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 2;
    add(correctButton, positionConst);
  }

  /*
   * Method is automatically called when a button is pressed
   * 
   * It needs some work. The logic here doesn't play a guessing game. It just
   * provides some examples that you can use.
   */
  //wi
  @Override
  public void actionPerformed(ActionEvent event) {
      String action = event.getActionCommand();
      try {
        
        
        if (action == "Higher") {
          RNG.higher();      
        } else if (action == "Lower"){
          RNG.lower();
        } else if (action == "Reset") {
          RNG.reset();
        } else if (action == "Correct") {
          dispose();
        }
        guessField.setText(String.valueOf(RNG.getCurrentGuess()));   
          
      }
        //write exception
      catch (NumberGuesserIllegalStateException e) {
          JOptionPane.showMessageDialog(this, "Stop cheating!");
        }
        
  }

  public static void main(String[] args) {
    Main myFrame = new Main();

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.pack();
    myFrame.setVisible(true);
  }
}