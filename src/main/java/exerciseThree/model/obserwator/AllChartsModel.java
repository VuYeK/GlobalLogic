package exerciseThree.model.obserwator;


import exerciseThree.model.obserwowany.Student;
import javafx.collections.ObservableList;

public class AllChartsModel implements IObservator {
    IObservator[] array;

    public AllChartsModel(IObservator[] array) {
        this.array = array;
    }

    @Override
    public void update(ObservableList<Student> students) {
        for (IObservator temp : array)
            temp.update(students);
    }

    @Override
    public void rollback() {
        for (IObservator temp : array)
            temp.rollback();
    }
}
