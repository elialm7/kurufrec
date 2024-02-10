package View.ViewState;

public interface StateListener<T> {
    void handleStateChanged(T toHandle);
}
