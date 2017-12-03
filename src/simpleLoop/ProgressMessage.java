package simpleLoop;
/**
 * ProgressMessage creates a ProgressMessage object from the Message interface.
 * A ProgressMessage is added last into the queue while the progress bar is loading
 * and its progressValue data is used to update the progressPercentage in ProcessWidget.
 *
 */
public class ProgressMessage implements Message {
    /**
     * The double progressValue for the ProgressnMessage.
     */
    private double progressValue;
    /**
     * The String result for the ProgressMessage
     */
    private String result;
    /**
     * Creates a new ProgressMessage with the given progressValue
     */
    ProgressMessage(double progressValue){

        this.progressValue=progressValue;
    }
    /**
     * Returns the progressValue
     * @return progressValue The progressValue that will be used
     * to update the progressPercentage in ProcessWidget.
     */
    public double getProgressValue(){
        return this.progressValue;
    }
    /**
     * Returns the result String
     * @return result The ProgressMessage that will be used
     * to notify the user that the progress bar is finished.
     */
    public String getResult(){
        return this.result;
    }
}