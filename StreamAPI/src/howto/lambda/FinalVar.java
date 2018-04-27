package howto.lambda;

import javax.swing.JButton;

public class FinalVar{

  public static void main(String[] args) throws Exception {
  }

  public void capturingVariable() {
    String name = getUserName();
    JButton button = new JButton();
    button.addActionListener(event -> System.out.println("hi " + name));
  }

  public void capturingVariableError() {
    // fails to compile
    String name="adsfdfd"; // this var is affective final variable
//    name = "asdf";
    JButton button = new JButton();
     button.addActionListener(event -> System.out.println("hi " + name));
  }

  private String getUserName() {
    return "Test";
  }

}