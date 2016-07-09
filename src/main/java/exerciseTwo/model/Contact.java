package exerciseTwo.model;


public class Contact {

    int id_kontaktu;
    String imie, nazwisko, wojewodztwo, ulica, kodPocztowy, miasto;

    //Konstruktor z ID
    public Contact(int id_kontaktu, String imie, String nazwisko, String wojewodztwo, String ulica, String kodPocztowy, String miasto) {
        this.id_kontaktu = id_kontaktu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wojewodztwo = wojewodztwo;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    //Konstruktor bez ID
    public Contact(String imie, String nazwisko, String wojewodztwo, String ulica, String kodPocztowy, String miasto) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wojewodztwo = wojewodztwo;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    /*GETTERS*/
    public int getId_kontaktu() {
        return id_kontaktu;
    }

    /*SETTERS*/
    public void setId_kontaktu(int id_kontaktu) {
        this.id_kontaktu = id_kontaktu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
}
