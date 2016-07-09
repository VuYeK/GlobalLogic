package exerciseThree.model.obserwator;


import exerciseThree.model.obserwowany.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class PieChartModel implements IObservator {
    private javafx.scene.chart.PieChart chart;

    public PieChartModel(javafx.scene.chart.PieChart chart) {
        this.chart = chart;
    }

    @Override
    public void update(ObservableList<Student> students) {
        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Student student : students) {
            String name = student.getName();
            double mark = student.getMark();
            pieChartData.add(new javafx.scene.chart.PieChart.Data(name, mark));
        }

        this.chart.setData(pieChartData);
    }

    @Override
    public void rollback() {
        ObservableList<Student> students;
        List<Student> studentList = new ArrayList<>();
        students = FXCollections.observableArrayList(studentList);

        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Student student : students) {
            String name = student.getName();
            double mark = student.getMark();
            pieChartData.add(new javafx.scene.chart.PieChart.Data(name, mark));
        }

        this.chart.setData(pieChartData);
    }
}
