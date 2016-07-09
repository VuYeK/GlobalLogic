package exerciseThree.model.obserwator;

import exerciseThree.model.obserwowany.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;


public class BarChartModel implements IObservator {
    private javafx.scene.chart.BarChart<String, Integer> chart;
    private CategoryAxis categoryAxis;

    public BarChartModel(javafx.scene.chart.BarChart<String, Integer> chart, CategoryAxis categoryAxis) {
        this.chart = chart;
        this.categoryAxis = categoryAxis;
    }

    @Override
    public void update(ObservableList<Student> students) {
        this.chart.getData().clear();

        //ustawianie nazw X
        ObservableList<String> names = FXCollections.observableArrayList();
        for (Student student : students) {
            names.add(student.getName());
        }
        this.categoryAxis.setCategories(names);

        //ustalanie Y dla kazdego osobnego X.
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (Student student : students) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(student.getName(), student.getMark());
            series.getData().add(value);
        }

        this.chart.getData().add(series);
    }

    @Override
    public void rollback() {
        this.chart.getData().clear();
        ObservableList<Student> students;
        List<Student> studentList = new ArrayList<>();
        students = FXCollections.observableArrayList(studentList);

        //ustawianie nazw X
        ObservableList<String> names = FXCollections.observableArrayList();
        for (Student student : students) {
            names.add(student.getName());
        }
        this.categoryAxis.setCategories(names);

        //ustalanie Y dla kazdego osobnego X.
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (Student student : students) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(student.getName(), student.getMark());
            series.getData().add(value);
        }

        this.chart.getData().add(series);
    }

}