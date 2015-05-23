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
  private MapPane mapPane;
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
    mapTextArea.setRequestFocusEnabled(false);
    mapTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
    frame.getContentPane().add(mapTextArea, BorderLayout.EAST);
    
    mapPane = new MapPane("\u2588\u2588\u2588\u2588\u2588\n\u2588\u2588\u2588\u2588\u2588");
    frame.getContentPane().add(mapPane, BorderLayout.WEST);

    outputTextArea = new JTextArea();
    outputTextArea.setRows(15);
    outputTextArea.setColumns(30);
    outputTextArea.setEditable(false);
    outputTextArea.setFocusable(false);
    outputTextArea.setRequestFocusEnabled(false);
    frame.getContentPane().add(outputTextArea, BorderLayout.CENTER);

    inputTextField = new JTextField();
    inputTextField.setColumns(10);
    frame.getContentPane().add(inputTextField, BorderLayout.SOUTH);

    frame.addWindowListener(new WindowAdapter(){ 
      public void windowOpened(WindowEvent e){ 
        inputTextField.requestFocusInWindow(); //inputTextField.requestFocus();
      } 
    });
    
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Sets the map text area to the given map
   * @param map the map to display
   */
  public void setMap(String map) {
    mapTextArea.setText(map);
    mapPane = new MapPane(map);
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

  /**
   * An attempt to make the map text square
   * @author http://stackoverflow.com/questions/14670805/how-to-stretch-text-horizontally-in-java
   * TODO try http://stackoverflow.com/questions/8281886/stretch-a-jlabel-text
   */
  public class MapPane extends JPanel {
    private static final long serialVersionUID = 2970550539872323526L;
    private BufferedImage image;

    public MapPane(String text) {
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
