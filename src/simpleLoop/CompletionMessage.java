package simpleLoop;
/**
 * CompletionMessage creates a CompletionMessage object from the Message interface.
 * A CompletionMessage is added last into the queue and prints its result parameter
 * when the progress bar finishes.
 *
 */
public class CompletionMessage implements Message {
    /**
     * The String result for the Completion Message
     */
    private String result;
    /**
     * The double progressValue for the CompletionMessage.
     */
    private double progressValue;
    /**
     * Creates a new CompletionMessage with the given result.
     */
    CompletionMessage(String result){

        this.result=result;
    }/**
     * Returns the progressValue
     * @return progressValue The progressValue that will be used
     * to update the progressPercentage in ProcessWidget.
     */
    public double getProgressValue() {
        return this.progressValue;

    }
    /**
     * Returns the result String
     * @return result The CompletionMessage that will be used
     * to notify the user that the progress bar is finished.
     */
    public String getResult(){

        return this.result;
    }

}