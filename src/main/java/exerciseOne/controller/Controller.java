package exerciseOne.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private Text txtResult;
    @FXML
    private TextField txtFieldWord;

    private static char findFirstNonRepeatingChar(String string) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        if (nonRepeating.size() != 0)
            return nonRepeating.get(0);
        return '\0';
        //throw new RuntimeException("didn't find any non repeated Character");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    protected void button_find() {
        String temp = txtFieldWord.getText();
        temp = temp.toLowerCase();
        char character = findFirstNonRepeatingChar(temp);
        if (character != '\0') txtResult.setText(String.valueOf(character));
        else txtResult.setText("NO NON-REPEATABLE");
        txtResult.setVisible(true);
    }

    @FXML
    public void enter_pressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            button_find();
        }
    }
}
