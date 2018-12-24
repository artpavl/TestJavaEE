package logic.Observer;

import java.io.IOException;

public interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers() throws IOException;
}
