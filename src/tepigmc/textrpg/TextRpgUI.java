package tepigmc.textrpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextRpgUI {
  private JFrame frame;
  // private RoomPane roomPane;
  private JTextArea roomTextArea;
  private JTextArea outputTextArea;
  private JTextField inputTextField;

  public TextRpgUI() {
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
    frame.getContentPane().add(outputTextArea, BorderLayout.CENTER);

    // roomPane = new RoomPane("\u2588\u2588\u2588\n\u2588\u2588\u2588");
    // frame.getContentPane().add(roomPane, BorderLayout.EAST);

    inputTextField = new JTextField();
    inputTextField.setColumns(10);
    frame.getContentPane().add(inputTextField, BorderLayout.SOUTH);

    frame.addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        inputTextField.requestFocusInWindow(); // inputTextField.requestFocus();
      }
    });

    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Sets the room text area to the given rendered room
   * @param roomText the rendered room to display
   */
  public void setRoom(String roomText) {
    roomTextArea.setText(roomText);
    // roomPane = new RoomPane(roomText);
  }

  /**
   * Appends a String to the output
   * @param text the text to append
   */
  public void appendText(String text) {
    for (int i = 0; i < text.length(); i++) {
      outputTextArea.append(text.substring(i, i + 1));
      TextRpg.sleep(25);
    }
    outputTextArea.append("\n");
    TextRpg.sleep(500);
  }

  /**
   * Creates a user interface for the game
   */
  public void init() {
    // TODO create UI

    // TODO create text management
    refresh();
    appendText("Text RPG says \"Hello World\"\n");
    appendText("\n\n\n\n\nPlayer says \"Hello\" to the world");
    appendText("\n\n\n\n\nThe world says \"Hello\" to you");
    appendText("\n\n\n\n\nBye!");
  }

  /**
   * Refreshes the data in the user interface; Called whenever an event in the
   * EventManager fires
   */
  public void refresh() {
    String roomText = TextRpg.renderCurrentRoom();
    setRoom(roomText);
    System.out.println(roomText);
    System.out.println();
  }

  /**
   * An attempt to make the room text square
   * @author http://stackoverflow.com/questions/14670805/how-to-stretch-text-
   *         horizontally-in-java TODO try
   *         http://stackoverflow.com/questions/8281886/stretch-a-jlabel-text
   */
  public class RoomPane extends JPanel {
    private static final long serialVersionUID = 2970550539872323526L;
    private BufferedImage image;

    public RoomPane(String text) {
      Font font = new Font("Courier New", Font.PLAIN, 14);
      FontMetrics fontMetrics = getFontMetrics(font);
      int width = fontMetrics.stringWidth(text);
      int height = fontMetrics.getHeight();
      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      Graphics2D graphics2d = image.createGraphics();
      graphics2d.setColor(Color.BLACK);
      graphics2d.drawString(text, 0, fontMetrics.getAscent());
      graphics2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      Graphics2D graphics2d = (Graphics2D) graphics;
      graphics2d.drawImage(image, 0, 0, getWidth(), image.getHeight(), this);
      graphics2d.dispose();
    }
  }
}
