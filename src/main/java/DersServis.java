
import java.util.Scanner;

import java.util.List;


public class DersServis {


    Scanner inp = new Scanner(System.in);




//13-tüm dersleri listeleme
public void getAllStudents(){
    repository.findAll();
}






       //11-öğrenci kaydetme
       public void saveDers() {

        System.out.println("Ders Adi: ");
        String dersAdi = inp.nextLine().trim();
        System.out.println("Kredi: ");
        String kredi = inp.nextLine();
        System.out.println("Ogrenci Sayisi: ");
        String ogrSayisi = inp.next();
        System.out.println("Ogrenci Adi : ");
        String ogrAdi = inp.nextLine().trim();
        inp.nextLine();
        Ders newDers = new Ders(dersAdi, kredi, ogrSayisi, ogrAdi);
        //   DersRepository repository = new DersRepository();
        repository.save(newDers);
    }



















   
   
   
   
   
   
   
   
   
   
   
   
   
   


public void deleteDers(int id){
        //bu code ile ders var mı??-->best practice
        repository.delete(id);
    }


public Ders getDersById(int dersKodu){
    Ders ders=repository.findDersById(id);
    return ders;
}










public void listDersByeNameOrLastname(){
        System.out.println("Ders adı:");
        String dersAd = inp.nextLine();
        List<Ders> dersList = repository.findDersByNameOrLastname(dersAd );
        if (dersList.size()==0){
            System.out.println("Bu ders adı bulunamadı");
        }else {
            dersList.forEach(System.out::println);
        }


    }









































































































































































































}