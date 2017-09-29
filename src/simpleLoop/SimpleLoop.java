package simpleLoop;


import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleLoop {
  private boolean isRunning = true;
  private ProcessWidget processWidget;
  private static ConcurrentLinkedQueue<Thread> clq = new ConcurrentLinkedQueue<Thread>();

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
      //t1.run();
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

  Thread t1 = new Thread(new Runnable() { //thread that runs aVeryLongTask
    @Override
    public void run() {
      aVeryLongTask();
    }
  });

  void aVeryLongTask(){ //this method is to be put into a thread...?
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
