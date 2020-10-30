import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel degressFahrenheit;
  JLabel degressCelsius;

  JTextField fahrenheit;
  JTextField celcius;

  JButton celciusToFahrenheit;
  JButton fahrenheitToCelcius;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize the mainJPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);
    //create the labels
    degressFahrenheit = new JLabel("Degrees Fahrenheit");
    degressCelsius = new JLabel("Degrees Celsius");
    //layout the labels by setting the cordinate and size
    degressFahrenheit.setBounds(10,10,200,20);
    degressCelsius.setBounds(10,40,200,20);
    //add labels to main panel
    mainPanel.add(degressFahrenheit);
    mainPanel.add(degressCelsius);
    //initialize the text fields
    fahrenheit = new JTextField();
    celcius = new JTextField();
    //layout the text fiels by setting cordinates and size
    fahrenheit.setBounds(160,10,100,20);
    celcius.setBounds(160,40,100,20);
    //add text fields to main panel
    mainPanel.add(fahrenheit);
    mainPanel.add(celcius);
    //initialize the buttons
    fahrenheitToCelcius = new JButton("F --> C");
    celciusToFahrenheit = new JButton("C --> F");
    //layout the buttons by setting cordinate and size
    fahrenheitToCelcius.setBounds(270,10,100,15); 
    celciusToFahrenheit.setBounds(270,40,100,15);
    //add an action listener to the buttons
    fahrenheitToCelcius.addActionListener(this);
    celciusToFahrenheit.addActionListener(this);
    //set the action command on the buttons
    fahrenheitToCelcius.setActionCommand("fahrenheit");
    celciusToFahrenheit.setActionCommand("celcius");
    //add buttons to panel
    mainPanel.add(fahrenheitToCelcius);
    mainPanel.add(celciusToFahrenheit);
    //add the panel to the window
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    if(command.equals("fahrenheit")){
      //get text from fahrenheit box
      String firstText = fahrenheit.getText();
      //change string into integer
      int fah = Integer.parseInt(firstText);
      //calculate users result in celcius
      int cel = (fah - 32) * 5/9;
      //tell user their result
      celcius.setText("" + cel);

    }
    if(command.equals("celcius")){
      //get text from fahrenheit box
      String firstText = celcius.getText();
      //change string into integer
      int cel = Integer.parseInt(firstText);
      //calculate users result in celcius
      int fah = (cel * 9)/5 + 32;
      //tell user their result
      fahrenheit.setText("" + fah);

    }


  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
