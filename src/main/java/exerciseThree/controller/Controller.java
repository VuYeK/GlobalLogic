package exerciseThree.controller;


import exerciseThree.model.obserwator.AllChartsModel;
import exerciseThree.model.obserwator.BarChartModel;
import exerciseThree.model.obserwator.IObservator;
import exerciseThree.model.obserwator.PieChartModel;
import exerciseThree.model.obserwowany.CollectionOfStudents;
import exerciseThree.model.obserwowany.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    TableColumn<Student, String> COL_STUDENT;
    @FXML
    TableColumn<Student, String> COL_MARK;
    @FXML
    CheckBox CB_CHART_1, CB_CHART_2;
    private CollectionOfStudents collectionOfStudents;
    private BarChartModel barChart;
    private PieChartModel pieChart;
    private AllChartsModel allCharts;
    private ObservableList<Student> students;
    private List<Student> studentList = new ArrayList<>();
    @FXML
    private TextField ID_TF_NUMBER;
    @FXML
    private TableView<Student> ID_TABLE_VIEW;
    //Wykresy
    @FXML
    private BarChart<String, Integer> ID_BAR_CHART;
    @FXML
    private CategoryAxis ID_BAR_CHART_AXIS_X;
    @FXML
    private PieChart ID_PIE_CHART;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collectionOfStudents = new CollectionOfStudents();
        pieChart = new PieChartModel(ID_PIE_CHART);
        barChart = new BarChartModel(ID_BAR_CHART, ID_BAR_CHART_AXIS_X);
        IObservator[] array = {barChart, pieChart};
        allCharts = new AllChartsModel(array);

        CB_CHART_1.setSelected(true);
        CB_CHART_2.setSelected(true);

        //Ustawienie TableView
        COL_STUDENT.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        COL_MARK.setCellValueFactory(new PropertyValueFactory<Student, String>("mark"));
        setStudentsArray();
    }

    private void setStudentsArray() {
        students = FXCollections.observableArrayList(studentList);
        ID_TABLE_VIEW.setItems(students);
    }

    //Sprawdzenie czy podana wartość jest liczbą
    private boolean validateInteger(String text) {
        if (text.matches("\\d*"))
            return false;
        else if (text.matches("\"\"")) {
            return true;
        } else {
            return true;
        }

    }

    //Generowanie losowych danych o studentach i ocenach
    private void generateListOfStudents() {
        if (ID_TF_NUMBER.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText("Podaj właściwe dane!");
            alert.setContentText("Wpisz liczbę studentów dla których będą wygenerowane losowe oceny i wyświetlone wykresy.");

            alert.showAndWait();
            return;
        }

        if (validateInteger(ID_TF_NUMBER.getText())) {
            JOptionPane.showMessageDialog(null, "Prosze uzyj liczby calkowitej w polu \"Liczba studentow\"");
            ID_TF_NUMBER.setPromptText("Tylko liczby calkowite!");
            return;
        }

        Integer quantityOfStudent = Integer.valueOf(ID_TF_NUMBER.getText());
        if (ID_TF_NUMBER.getText().isEmpty()) {
            quantityOfStudent = 0;
        }

        studentList.clear();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < quantityOfStudent; i++) {
            int mark = Math.abs(random.nextInt(6) + 1);
            Student student = new Student("Student " + String.valueOf(i + 1), mark);
            studentList.add(student);
        }
    }

    //Sprawdzenie które checkboxy są zaznaczone (które wykresy rysować/jakich Listenerów dodać)
    private boolean whichCheckBoxesAreSelected() {
        boolean flag = false;

        if (CB_CHART_1.isSelected() && CB_CHART_2.isSelected()) {
            flag = true;
            collectionOfStudents.attachToAll(allCharts);
            return flag;
        } else {
            collectionOfStudents.detachToAll(allCharts);
        }

        if (CB_CHART_1.isSelected()) {
            flag = true;
            collectionOfStudents.attachToAll(barChart);
        } else {
            collectionOfStudents.detachToAll(barChart);
        }
        if (CB_CHART_2.isSelected()) {
            flag = true;
            collectionOfStudents.attachToAll(pieChart);
        } else {
            collectionOfStudents.detachToAll(pieChart);
        }
        return flag;
    }

    //Obsługa przycisku generowania wykresów
    @FXML
    protected void generateBtn() {
        generateListOfStudents();
        setStudentsArray();
        if (whichCheckBoxesAreSelected()) {
            collectionOfStudents.notifyAllObservers(students);
        } else {
            JOptionPane.showMessageDialog(null, "Nie zaznaczono zadnego wykresu");
        }
    }

    //Obsługa przycisku czyszczenia danych
    @FXML
    protected void clearBtn() {
        studentList.clear();
        setStudentsArray();
        if (whichCheckBoxesAreSelected()) {
            collectionOfStudents.notifyAllObserversRollback();
        }
    }

}
