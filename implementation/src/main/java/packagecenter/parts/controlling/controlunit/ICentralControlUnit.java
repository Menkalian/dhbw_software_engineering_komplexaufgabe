package packagecenter.parts.controlling.controlunit;

public interface ICentralControlUnit extends IControlUnit {

    /**
     * 
     * @param subscriber
     */
    void subscribe(Subscriber subscriber);

    /**
     * 
     * @param event
     */
    void publish(Object event);

}