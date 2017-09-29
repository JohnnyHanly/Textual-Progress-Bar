package simpleLoop;


import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleLoop {
  private boolean isRunning = true;
  private ProcessWidget processWidget;
  private static ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue<Thread>();

  public static void main(String[] args) {
    SimpleLoop loop = new SimpleLoop();

    try {
      loop.run();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public SimpleLoop(){
    processWidget = new ProcessWidget();
  }

  void run() throws InterruptedException {
    while (isRunning) {
      update();
      // aVeryLongTask();
      Thread.sleep(20);
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
