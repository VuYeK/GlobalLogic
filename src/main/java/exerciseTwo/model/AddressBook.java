package exerciseTwo.model;


import exerciseTwo.base.ConnectDB;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AddressBook implements IAddressBook {
    //Polaczenie z baza
    public static ConnectDB baza = ConnectDB.getInstance();

    private static volatile AddressBook instance = null;

    //Konstruktor
    private AddressBook() {
    }

    /**
     * Singleton ktory tworzy tylko 1 instancje klasy na wszystkich watkach(synchronized).
     */
    public static AddressBook getInstance() {
        if (instance == null) {
            synchronized (AddressBook.class) {
                if (instance == null) {
                    instance = new AddressBook();
                }
            }
        }
        return instance;
    }

    /**
     * Metody
     */
    //Dodawanie kontaktu do bazy
    public void dodaj_kontakt(Contact contact) {
        try {

            baza.prepareStmt = baza.polaczenie.prepareStatement("INSERT INTO kontakty VALUES (null, ?, ?, ?, ?, ?, ?);");

            int i = 0;
            baza.prepareStmt.setString(++i, contact.getImie());
            baza.prepareStmt.setString(++i, contact.getNazwisko());
            baza.prepareStmt.setString(++i, contact.getWojewodztwo());
            baza.prepareStmt.setString(++i, contact.getUlica());
            baza.prepareStmt.setString(++i, contact.getKodPocztowy());
            baza.prepareStmt.setString(++i, contact.getMiasto());

            baza.prepareStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }


    //Pobieranie kontaktów z bazy
    public ArrayList<Contact> wyswietl_kontakty() {

        ResultSet result = null;
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            baza.prepareStmt = baza.polaczenie.prepareStatement("SELECT * FROM kontakty");
            result = baza.prepareStmt.executeQuery();
            int id_kontaktu;
            String imie, nazwisko, wojewodztwo, ulica, kodPocztowy, miasto;

            for (int i = 0; result.next(); i++) {
                id_kontaktu = result.getInt("id_kontaktu");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                wojewodztwo = result.getString("wojewodztwo");
                ulica = result.getString("ulica");
                kodPocztowy = result.getString("kodPocztowy");
                miasto = result.getString("miasto");
                contacts.add(new Contact(id_kontaktu, imie, nazwisko, wojewodztwo, ulica, kodPocztowy, miasto));
            }
            return contacts;

        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1);
            e1.printStackTrace();
            return null;
        }

    }


    //Usuwanie kontaktow z bazy
    public void usun_kontakt(Contact contact) {
        try {
            baza.prepareStmt = baza.polaczenie.prepareStatement("DELETE FROM kontakty " + "WHERE imie = ? AND nazwisko = ? AND miasto = ?");

            int i = 0;
            baza.prepareStmt.setString(++i, contact.getImie());
            baza.prepareStmt.setString(++i, contact.getNazwisko());
            baza.prepareStmt.setString(++i, contact.getMiasto());

            baza.prepareStmt.execute();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1);
            e1.printStackTrace();
        }
    }
}