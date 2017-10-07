package simpleLoop;


import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleLoop {
  private boolean isRunning = true;
  private ProcessWidget processWidget;
  private static ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>(); //clq is a queue for string 'messages'...?

  public static void main(String[] args) {
    SimpleLoop loop = new SimpleLoop();
    ProgressMessage pm = new ProgressMessage(0);//object of ProgressMessage class
      t.start();//aVeryLongTask thread is running in the background, update() is unaffected
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
      //aVeryLongTask();
      Thread.sleep(20);
    }
  }

  private void update(){
    System.out.print("\r" + processWidget.display() + " " + new Date());
  }

  void onProgressUpdate(float f) {//this method updates processWidget
    double d = f;
    processWidget.setProgress(d);
  }
  void onComplete() {
    System.out.println("Task Complete!");
  }

  static Thread t = new Thread(new Runnable() { //worker thread that runs aVeryLongTask
    @Override                                   //calls ProgressMessage and CompletionMessage class obj?
    public void run() {
      aVeryLongTask();
    }
  });

  static void aVeryLongTask(){ //this method fills the progress bar in ProcessWidget...?
    for(int i = 0 ; i < 100; i++){
      final float progess = (float)i/100;
        //System.out.println("progress: " + progess*100 + "%");

      try {
        Thread.sleep(30);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
