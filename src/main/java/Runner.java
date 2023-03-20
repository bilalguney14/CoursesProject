import java.util.Scanner;

public class Runner {
    /*
Proje:Student Management System
     -1-Herhangi bir eğitim kurumu için öğrenci yönetim uygulaması geliştiriniz.
     -2-Kullanıcı
              -C -ders kayıt
              -R -ders veya dersleri görüntüleme
              -U -ders kodu ile ders güncelleme
              -D -ders kodu ile ders silme
              -R  -filtreleme
              ders fieldlari ders kodu, ders adi, ders kredisi, dersi alan ogrenci sayisi,dersin ogretmen ismi
       işlemlerini yapabilmeli.


 */
    public static void main(String[] args) {
        start();
    }

    public static void start() {

        Scanner inp = new Scanner(System.in);
        int select;
        do {
            System.out.println("Kurs Yonetim Paneli");
            System.out.println("1-Ders Kayit ");
            System.out.println("2-Ders ve Dersleri  Goruntuleme");
            System.out.println("3-Ders Kodu ile Ders Guncelleme");
            System.out.println("4-Ders kodu ile Ders Silme");
            System.out.println("5-Ders Filtreleme");
            System.out.println("0-CIKIS");
            select = inp.nextInt();
            switch (select){
                case 1:
                    //ders kayit
                    break;
                case 2:
                    //ders goruntuleme
                    break;
                    case 3:
                    //ders guncelleme
                    break;
                    case 4:
                    //ders silme
                    break;
                    case 5:
                    //ders filtreleme
                    break;
                    case 0:
                        System.out.println("İyi Gunler");
                    break;
                default:
                    System.out.println("Hatali Gİris");
                    break;
            }

        } while (select != 0);
    }
}