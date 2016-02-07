package thething.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class UIOutputStream extends OutputStream {
  private JTextArea textArea;
  
  public UIOutputStream(JTextArea textArea) {
    this.textArea = textArea; 
  }
  
  @Override
  public void write(int b) throws IOException {
    textArea.append(String.valueOf((char)b));
    textArea.setCaretPosition(textArea.getDocument().getLength());
  }

}
