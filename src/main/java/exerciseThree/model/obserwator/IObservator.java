package exerciseThree.model.obserwator;

import exerciseThree.model.obserwowany.Student;
import javafx.collections.ObservableList;


public interface IObservator {
    void update(ObservableList<Student> students);
    void rollback();

}
