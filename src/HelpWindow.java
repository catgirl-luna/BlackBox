package blackBox;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * Creates a self-contained help window. The HTML contents and all images are
 * loaded from the source directory "resource". The build configuration places
 * the resources in the JAR file at the top level. After loading the help HTML
 * from the resource the tags %...% are replaced with the image names using
 * their absolute path from their URLs.
 * 
 * @author noah
 */
public class HelpWindow extends JFrame {

  private static final long serialVersionUID = 1L;

  /**
   * Run the help window for testing purposes.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new HelpWindow(100, 50);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Open the help window at the specified location.
   * 
   * @param x X location
   * @param y Y location
   */
  public HelpWindow(int x, int y) {
    setTitle("BlackBox Help");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setLocation(x, y);
    setSize(560, 450);
    initialize();
    pack();
    setVisible(true);
  }

  /**
   * Initialize the help window.
   */
  private void initialize() {
    JPanel panel = new JPanel(new BorderLayout());
    JEditorPane jEditorPane = new JEditorPane();
    jEditorPane.setEditable(false);
    URL url = HelpWindow.class.getResource("/Help.html");
    jEditorPane.setContentType("text/html");
    jEditorPane.setText(getURL(url));

    // Add hyperlink listener for traversing the internal page links.
    jEditorPane.addHyperlinkListener(new HyperlinkListener() {
      @Override
      public void hyperlinkUpdate(final HyperlinkEvent event) {
        if (HyperlinkEvent.EventType.ACTIVATED == event.getEventType()) {
          String reference = event.getDescription();
          if (reference != null && reference.startsWith("#")) {
            reference = reference.substring(1);
            jEditorPane.scrollToReference(reference);
          }
        }
      }
    });

    JScrollPane jScrollPane = new JScrollPane(jEditorPane);
    jScrollPane.setPreferredSize(new Dimension(540, 400));
    panel.add(jScrollPane, BorderLayout.CENTER);
    jEditorPane.setCaretPosition(0);

    getContentPane().add(panel);

    JPanel btnPanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    panel.add(btnPanel, BorderLayout.SOUTH);

    JButton btnCloseButton = new JButton("Close");
    btnCloseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        close();
      }
    });
    btnPanel.add(btnCloseButton);
  }

  /**
   * Closes the window when invoked by the close button.
   */
  private void close() {
    setVisible(false);
    dispose();
  }

  /**
   * Read in the URL text and replace the tags %...% with the appropriate paths
   * to the actual images.
   * 
   * @param url help page URL
   * @return The help page with the correct image locations.
   */
  @SuppressWarnings ({
      "null"
  })
  private String getURL(URL url) {
    // Read the help text into the string buffer.
    StringBuilder sb = new StringBuilder();
    URLConnection urlConn = null;
    InputStreamReader in = null;
    try {
      urlConn = url.openConnection();
      if (urlConn != null)
        urlConn.setReadTimeout(60 * 1000);
      if (urlConn != null && urlConn.getInputStream() != null) {
        in = new InputStreamReader(urlConn.getInputStream(),
            Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(in);
        if (bufferedReader != null) {
          int cp;
          while ( (cp = bufferedReader.read()) != -1) {
            sb.append((char) cp);
          }
          bufferedReader.close();
        }
      }
      in.close();
    } catch (Exception e) {
      return "Exception while calling URL: \n" + e.getMessage();
    }

    // Replace the tags with the image URLs.
    String html = sb.toString();
    String imgsrc = HelpWindow.class.getResource("/Board.png").toString();
    html = html.replaceFirst("%BOARD%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/Hit.png").toString();
    html = html.replaceFirst("%HIT%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/Deflection.png").toString();
    html = html.replaceFirst("%DEFLECTION%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/Reflection.png").toString();
    html = html.replaceFirst("%REFLECTION%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/DoubleDeflection.png").toString();
    html = html.replaceFirst("%DOUBLE-DEFLECTION%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/Miss.png").toString();
    html = html.replaceFirst("%MISS%", imgsrc);
    imgsrc = HelpWindow.class.getResource("/Detour.png").toString();
    html = html.replaceFirst("%DETOUR%", imgsrc);
    return html;
  }
}
