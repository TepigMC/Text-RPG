package tepigmc.textrpg;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextRpgUI {
  private JFrame frame;
  private JTextArea mapTextArea;
  private JTextArea outputTextArea;
  private JTextField inputTextField;

  public TextRpgUI() {
    frame = new JFrame("Text RPG");

    mapTextArea = new JTextArea();
    mapTextArea.setRows(15);
    mapTextArea.setColumns(15);
    mapTextArea.setEditable(false);
    mapTextArea.setFocusable(false);
    mapTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
    frame.getContentPane().add(mapTextArea, BorderLayout.WEST);

    outputTextArea = new JTextArea();
    outputTextArea.setRows(15);
    outputTextArea.setColumns(30);
    outputTextArea.setEditable(false);
    outputTextArea.setFocusable(false);
    frame.getContentPane().add(outputTextArea, BorderLayout.CENTER);

    inputTextField = new JTextField();
    inputTextField.setColumns(10);
    frame.getContentPane().add(inputTextField, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Sets the map text area to the given map
   * @param map the map to display
   */
  public void setMap(String map) {
    mapTextArea.setText(map);
  }

  /**
   * Appends a String to the output
   * @param text the text to append
   */
  public void appendText(String text) {
    outputTextArea.append(text);
  }

  /**
   * Creates a user interface for the game
   */
  public void init() {
    // TODO create UI

    // TODO create text management class
    appendText("Text RPG says \"Hello World\"\n");

    refresh();
  }

  /**
   * Refreshes the data in the user interface; Called whenever an event in the
   * EventManager fires
   */
  public void refresh() {
    String map = TextRpg.renderCurrentRoom();
    setMap(map);
    System.out.println(map);
    System.out.println();
  }
}
