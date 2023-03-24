
import java.util.Scanner;

import java.util.List;


public class DersServis {


    Scanner inp = new Scanner(System.in);

    DersRepository repository = new DersRepository();

    public void createTable() {
        repository.createTable();
    }

    //11-öğrenci kaydetme
    public void saveDers() {
        System.out.println("Ders Adi : ");
        String dersAdi = inp.nextLine().trim();
        System.out.println("Kredi : ");
        String kredi = inp.nextLine();
        System.out.println("Ogrenci Sayisi : ");
        String ogrSayisi = inp.next();
        inp.nextLine();
        System.out.println("Ogrenci Adi : ");
        String ogrAdi = inp.nextLine().trim();
        Ders newDers = new Ders(dersAdi, kredi, ogrSayisi, ogrAdi);
        repository.save(newDers);
    }

    //13-tüm dersleri listeleme
    public void getAll() {
        repository.findAll();
    }


    public void updateDers(int dersKodu) {
        Ders ders = getDersById(dersKodu);
        if (ders == null) {
            System.out.println("Ders bulunamadi!");
        } else {
            System.out.println("Ders Adi: ");
            String dersAdi = inp.nextLine();
            System.out.println("Kredi: ");
            String kredi = inp.nextLine();
            System.out.println("Ogrenci sayisi: ");
            String ogrSayisi = inp.nextLine();
            System.out.println("Ogrenci Adi: ");
            String ogrAdi = inp.nextLine();


            ders.setDersAdi(dersAdi);
            ders.setKredi(kredi);
            ders.setOgrSayisi(ogrSayisi);
            ders.setOgrAdi(ogrAdi);
            repository.update(ders);
        }
    }

    public void deleteDers(int dersKodu) {

        repository.delete(dersKodu);

    }


    public Ders getDersById(int dersKodu) {
        Ders ders = repository.findDersById(dersKodu);
        return ders;
    }


    public void listDersByeNameOrLastname() {
        System.out.println("Ders Adı:");
        String dersAd = inp.nextLine();
        List<Ders> dersList = repository.findDersByNameOrLastname(dersAd);
        if (dersList.size() == 0) {
            System.out.println("Bu ders bulunamadı!");
        } else {
            dersList.forEach(System.out::println);
        }


    }


}

