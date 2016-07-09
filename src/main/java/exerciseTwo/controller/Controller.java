package exerciseTwo.controller;


import exerciseTwo.model.AddressBook;
import exerciseTwo.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    private AddressBook ksiazka = AddressBook.getInstance();

    @FXML
    private TextField textImie, textNazwisko, textWojewodztwo, textUlica, textKodPocztowy, textMiasto;
    @FXML
    private ListView<Contact> listaKontaktow;
    @FXML
    private Text ileKontaktow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListViewAndCounter();
    }

    protected void setListViewAndCounter() {
        //Pobieranie danych do ListView
        ArrayList<Contact> contacts = new ArrayList<>(ksiazka.wyswietl_kontakty());
        ObservableList<Contact> data = FXCollections.observableArrayList(contacts);
        listaKontaktow.setItems(data);

        if (!contacts.isEmpty()) {
            ileKontaktow.setText(String.valueOf(contacts.size()));
        } else {
            ileKontaktow.setText(String.valueOf(0));
        }

        listaKontaktow.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
            @Override
            public ListCell<Contact> call(ListView<Contact> param) {
                ListCell<Contact> cell = new ListCell<Contact>() {
                    @Override
                    protected void updateItem(Contact item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(String.valueOf(contacts.indexOf(item) + 1) + ". " + item.getImie() + " " + item.getNazwisko() + ", "
                                    + item.getWojewodztwo() + ", " + item.getUlica() + ", "
                                    + item.getKodPocztowy() + ", " + item.getMiasto());
                        }
                    }
                };
                return cell;
            }
        });
    }

    //Obsluga w fxml przycisku usuwania
    @FXML
    protected void usun_kontakt_z_bazy() {
        final int selectedIdx = listaKontaktow.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
            Contact contactToRemove = listaKontaktow.getSelectionModel().getSelectedItem();

            ksiazka.usun_kontakt(contactToRemove);

        }
        setListViewAndCounter();

    }

    //Obsluga w fxml przycisku dodawania
    @FXML
    public void dodaj_kontakt_do_bazy() {
        ArrayList<String> atributes = new ArrayList<>();
        atributes.add(textImie.getText());
        atributes.add(textNazwisko.getText());
        atributes.add(textWojewodztwo.getText());
        atributes.add(textUlica.getText());
        atributes.add(textKodPocztowy.getText());
        atributes.add(textMiasto.getText());
        Contact contact;
        if (atributes.size() != 0) { //nie wypelnione ZADNE pole.
            for (String string : atributes) {   //sprawdzam czy wypelnione WSZYSTKIE pola
                if (string.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Prosze wypelnic wszystkie pola");
                    return;
                }
            }
            contact = new Contact(atributes.get(0), atributes.get(1), atributes.get(2), atributes.get(3), atributes.get(4), atributes.get(5));

            ksiazka.dodaj_kontakt(contact);  //BD
        } else {
            JOptionPane.showMessageDialog(null, "Prosze wypelnic wszystkie pola");
            return;
        }
        setListViewAndCounter();
    }
}
