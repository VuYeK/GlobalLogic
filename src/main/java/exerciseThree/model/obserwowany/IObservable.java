package exerciseThree.model.obserwowany;

import exerciseThree.model.obserwator.IObservator;
import javafx.collections.ObservableList;


public interface IObservable {
    void attachToAll(IObservator observer);

    void detachToAll(IObservator observer);

    void notifyAllObservers(ObservableList<Student> students);

    void notifyAllObserversRollback();
}
