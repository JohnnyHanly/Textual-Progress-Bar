package simpleLoop;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * The SimpleLoop program updates a progress bar with data stored in Messages passed
 * through a ConcurrentLinkedQueue. The data is loaded into the queues with a background thread while the
 * main thread updates the progress bar.
 * @author  Johnny Hanly, Richard Wong
 * @version 1.0
 * @since   2017-10-11
 */
public class SimpleLoop {
  private boolean isRunning = true;
  private ProcessWidget processWidget;
  private static ConcurrentLinkedQueue<Message> queue = new ConcurrentLinkedQueue<>();

  public static void main(String[] args) {
    SimpleLoop loop = new SimpleLoop();
    workerThread.start();
    try {
      loop.run();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public SimpleLoop(){
    processWidget = new ProcessWidget();
  }
  /**
   * Checks the contents of the queue, and calls the onProgress method is the queue
   * contains two or more Messages. This method also calls the update class while the boolean
   * isRunning is true. If the queue contains exactly one Message, the onComplete method is called
   * and isRunning is set to false, which ends the method.
   * @see SimpleLoop update() onProgress() onComplete()
   */
  void run() throws InterruptedException {

    while (isRunning) {
      while (!queue.isEmpty()) {
        onProgress();
        if (queue.size()==1){
          onComplete();
          isRunning=false;
        }
        if(isRunning==true) {
          update();
        }
        Thread.sleep(20);

      }

    }

  }
  /**
   * Prints the display method in ProcessWidget which makes the progress bar move.
   * @see ProcessWidget
   */
  private void update(){

    System.out.print("\r" + processWidget.display() + " " + new Date());
  }
  /**
   * Checks the value of the Message im the ConcurrentLinkedQueue and sets the
   * progressPercentage in ProcessWidget equal to the Message's progressValue. If the
   * value of the Message does not contain a String result, then the updated float progressValue
   * is assigned to the progressPercentage.
   *
   */
  void onProgress() {
    if (queue.peek().getResult()==null) {
      processWidget.setProgress(queue.poll().getProgressValue());
    }
  }
  /**
   * Prints the final Message in the queue which contains the completion message.
   * Adds one more blank Message to the queue to cease the display() method in ProcessWidget.
   *
   */
  void onComplete() {
    System.out.println(queue.peek().getResult());
    queue.add(new CompletionMessage("blank"));
  }
  /**
   * Creates a new Thread to run aVeryLongTask()
   * @see SimpleLoop aVeryLongTask()
   */
  static Thread workerThread = new Thread(() -> aVeryLongTask());
  /**
   * Increments a float value and adds them into the queue as progressValues in
   * ProgressMessage objects. When the progress float is done incrementing, a final
   * ProgessMessage is added to the queue with a completion message.
   * @see Message
   * @see ProgressMessage
   */
  static void aVeryLongTask(){
    for(int i = 0 ; i < 100; i++){
      final float progress = (float)i/100;

      queue.add(new ProgressMessage(progress));
      try {
        Thread.sleep(30);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    queue.add(new CompletionMessage("  Task Complete!"));

  }

}