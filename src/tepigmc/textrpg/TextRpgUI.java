package tepigmc.textrpg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

import tepigmc.textrpg.managers.EventManager;
import tepigmc.textrpg.managers.TextManager;

/**
 * The user interface for the Text RPG
 * @author Andrew Archibald
 */
public class TextRpgUI {
  private JFrame frame;
  private JScrollPane outputScrollPane;
  private JTextArea roomTextArea;
  private JTextArea outputTextArea;
  private JTextField inputTextField;
  private boolean isTyping = false;

  public TextRpgUI() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e1) {
      e1.printStackTrace();
    }

    frame = new JFrame("Text RPG");

    roomTextArea = new JTextArea(15, 15);
    roomTextArea.setEditable(false);
    roomTextArea.setFocusable(false);
    roomTextArea.setRequestFocusEnabled(false);
    roomTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
    frame.getContentPane().add(roomTextArea, BorderLayout.WEST);

    outputTextArea = new JTextArea(15, 50);
    outputTextArea.setEditable(false);
    outputTextArea.setFocusable(false);
    outputTextArea.setRequestFocusEnabled(false);
    outputTextArea.setWrapStyleWord(true);
    outputTextArea.setLineWrap(true);
    // outputTextArea.update(outputTextArea.getGraphics());
    // Updating; see http://stackoverflow.com/questions/629315/
    Thread thread = new Thread(() -> outputTextArea.validate());
    thread.start();
    // Scrolling to bottom as text is added
    DefaultCaret caret = (DefaultCaret) outputTextArea.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    outputScrollPane = new JScrollPane(outputTextArea);
    outputScrollPane.setBorder(null);
    frame.getContentPane().add(outputScrollPane, BorderLayout.CENTER);

    inputTextField = new JTextField();
    inputTextField.setColumns(10);
    frame.getContentPane().add(inputTextField, BorderLayout.SOUTH);

    inputTextField.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent event) {
        EventManager.keyTyped(event);
      }

      public void keyPressed(KeyEvent event) {
        EventManager.keyPressed(event);
      }

      public void keyReleased(KeyEvent event) {
        EventManager.keyReleased(event);
      }
    });

    frame.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        inputTextField.requestFocusInWindow(); // inputTextField.requestFocus();
      }
    });

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setIconImage(new ImageIcon(getClass().getResource("resources/icon.png"))
        .getImage());
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }

  /**
   * Sets the room text area to the given rendered room
   * @param roomText the rendered room to display
   */
  public void setRoom(String roomText) {
    roomTextArea.setText(roomText);
    System.out.println(roomText);
    System.out.println();
    TextRpg.out.println(roomText);
    TextRpg.out.println();
  }

  /**
   * Displays the next message in the output
   * @param message the text to display
   */
  public void displayMessage() {
    if (!this.isTyping && TextManager.hasNextMessage())
      typeMessage(TextManager.nextMessage());
  }

  /**
   * Displays a message in the output
   * @param message the text to display
   */
  private void typeMessage(String message) {
    System.out.println("typing");
    this.isTyping = true;
    if (message != null)
      for (int i = 0; i < message.length(); i++) {
        outputTextArea.append(message.substring(i, i + 1));
        TextRpg.sleep(25);
      }
    outputTextArea.append("\n");
    TextRpg.sleep(500);
    this.isTyping = false;
    displayMessage();
  }

  /**
   * Creates a user interface for the game
   */
  public void init() {
    refresh();
    TextManager.addMessage("Text RPG says \"Hello World\"\n");
    TextManager.addMessage("\n\n\n\n\nPlayer says \"Hello\" to the world");
    TextManager.addMessage("\n\n\n\n\nThe world says \"Hello\" to you");
    TextManager.addMessage("\n\n\n\n\nBye!");
  }

  /**
   * Refreshes the data in the user interface; Called whenever an event in the
   * EventManager fires
   */
  public void refresh() {
    setRoom(TextRpg.renderCurrentRoom());
  }
}
