package com.vecika.zadatak.Pojo;

/**
 * Created by vecika on 05/05/2016.
 */
public class Mjesto {

    private String naziv;
    private String titula;
    private String zupanija;
    private int thumb,slika1,slika2,slika3;
    private String opis;
    private float rating;

    public Mjesto(String naziv, String titula, String zupanija, int thumb, int slika1, int slika2, int slika3, String opis,float rating) {
        this.naziv = naziv;
        this.titula = titula;
        this.zupanija = zupanija;
        this.thumb = thumb;
        this.slika1 = slika1;
        this.slika2 = slika2;
        this.slika3 = slika3;
        this.opis = opis;
        this.rating = rating;
    }
    public int getSlika1() {
        return slika1;
    }
    public int getSlika2() {
        return slika2;
    }
    public int getSlika3() {
        return slika3;
    }
    public String getOpis() {
        return opis;
    }
    public String getNaziv() {
        return naziv;
    }
    public String getTitula() {
        return titula;
    }
    public String getZupanija() {
        return zupanija;
    }
    public int getThumb() {
        return thumb;
    }
    public float getRating() {
        return rating;
    }
}
