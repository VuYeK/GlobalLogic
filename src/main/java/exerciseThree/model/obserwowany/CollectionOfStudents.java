package exerciseThree.model.obserwowany;


import exerciseThree.model.obserwator.IObservator;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class CollectionOfStudents implements IObservable {
    //private List<Student> students = new ArrayList<>();
    private List<IObservator> observers = new ArrayList<>();

    public CollectionOfStudents() {
    }


    //Observe method
    @Override
    public void attachToAll(IObservator observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detachToAll(IObservator observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers(ObservableList<Student> students) {
        for (IObservator observer : observers) {
            observer.update(students);
        }
    }

    @Override
    public void notifyAllObserversRollback() {
        for (IObservator observer : observers) {
            observer.rollback();
        }
    }

}
