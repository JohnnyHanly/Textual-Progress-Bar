package simpleLoop;


import java.util.Date;

public class SimpleLoop {
  private boolean isRunning = true;
  private ProcessWidget processWidget;

  public static void main(String[] args) {
    SimpleLoop loop = new SimpleLoop();
    loop.run();
  }

  public SimpleLoop(){
    processWidget = new ProcessWidget();
  }

  void run(){
    while (isRunning) {
      update();
      // aVeryLongTask();
      try {
        Thread.sleep(30);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void update(){
    System.out.print("\r" + processWidget.display() + " " + new Date());
  }

  void onProgressUpdate() {
  }

  void onComplete() {
  }

  void aVeryLongTask(){
    for(int i = 0 ; i < 100; i++){
      final float progess = (float)i/100;
      try {
        Thread.sleep(30);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
