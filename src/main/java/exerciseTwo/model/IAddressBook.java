package exerciseTwo.model;

import java.util.ArrayList;


public interface IAddressBook {

    void dodaj_kontakt(Contact contact);

    ArrayList<Contact> wyswietl_kontakty();

    void usun_kontakt(Contact contact);
}
