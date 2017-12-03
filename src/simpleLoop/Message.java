package simpleLoop;
/**
 * Creates a Message Object whose methods are used in CompletionMessage
 * and ProgressMessage. Message objects will be stored in the queue.
 *
 */
public interface Message{
    /**
     * a method used to retrieve the progressValue in
     * CompletionMessage and ProgressMessage
     */
    double getProgressValue();
    /**
     * a method used to retrieve the result in
     * CompletionMessage and ProgressMessage
     */
    String getResult();
}