package thething.util;

import javax.swing.JOptionPane;

public final class MessageBox {
  private MessageBox() {
  }
  
  public static void show(String message, String title, int messageType) {
    JOptionPane.showMessageDialog(null, message, title, messageType);
  }
}
