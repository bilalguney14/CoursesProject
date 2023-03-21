public class Ders {
    //ders fieldlari ders kodu, ders adi, ders kredisi, dersi alan ogrenci sayisi,dersin ogretmen ismi

    private int dersKodu;

    private String dersAdi;

    private String kredi;

    private String ogrSayisi;

    private String ogrAdi;

    public Ders() {
    }

    public Ders(String dersAdi, String kredi, String ogrSayisi, String ogrAdi) {
        this.dersAdi = dersAdi;
        this.kredi = kredi;
        this.ogrSayisi = ogrSayisi;
        this.ogrAdi = ogrAdi;
    }

    public int getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(int dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {

        this.dersAdi = dersAdi;
    }

    public String getKredi() {
        return kredi;
    }

    public void setKredi(String kredi) {
        this.kredi = kredi;
    }

    public String getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(String ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public String getOgrAdi() {
        return ogrAdi;
    }

    public void setOgrAdi(String ogrAdi) {
        this.ogrAdi = ogrAdi;
    }

    @Override
    public String toString() {
        return "dersKodu=" + dersKodu +
                ", DersAdi='" + dersAdi + '\'' +
                ", Kredi='" + kredi + '\'' +
                ", ogrSayisi='" + ogrSayisi + '\'' +
                ", ogrAdi='" + ogrAdi + '\'' ;
    }
}
