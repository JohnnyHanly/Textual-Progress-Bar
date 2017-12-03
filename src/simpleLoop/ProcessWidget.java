package simpleLoop;

public class ProcessWidget {

  private double progressPercentage = 0;


  public void setProgress(double progressPercentage) {

    this.progressPercentage = progressPercentage;
  }

  public String display() {
    final int width = 100;
    String output = "[";
    int i = 0;
    for (; i <= (int) (this.progressPercentage * width); i++) {
      output += ".";
    }
    for (; i < width; i++) {
      output += " ";
    }
    output += "]";
    return output;
  }
}