
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DersRepository {
    private Connection conn;
    private Statement st;
    private PreparedStatement prst;
    
    private void  getConnection(){
        try {
            this.conn=DriverManager.getConnection("jdbc:postgrsql://localhost:5432/jdbc_db","dev_user","password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private void getPreparedStatement(String sql) {
        try {
            this.prst = conn.prepareStatement(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   private void getStatement(){
 
        try {
            this.st=conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createTable() {
        getConnection();
        getStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS t_ders (dersKodu SERIAL, dersAdi VARCHAR(50), kredi INT, ogrSayisi INT , ogrAdi VARCHAR(50)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}




























































    //20-veri güncelleme
    public void update(Ders ders) {
        getConnection();
        String sql="UPDATE t_ders SET dersAdi=?,kredi=?,ogrSayisi=?,ogrAdi=? WHERE dersKodu=?";
        getPreparedStatement(sql);
        try {
            prst.setString(1,ders.getDersAdi());
            prst.setString(2,ders.getKredi());
            prst.setString(3,ders.getOgrSayisi());
            prst.setString(4,ders.getOgrAdi());
            prst.setInt(5,ders.getDersKodu());
            int updated=prst.executeUpdate();
            if(updated>0){
                System.out.println("Ders başarıyla güncellendi.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}











    public void delete(int id) {
        getConnection();
        String sql="DELETE FROM t_ders WHERE dersKodu=?";
        getPreparedStatement(sql);
        try {
            prst.setDersKodu(1,dersKodu);
            int deleted=prst.executeUpdate();
            if (deleted>0){
                System.out.println("dersKodu:"+dersKodu+" olan kayıt başarıyla silinmiştir");
            }else{
                System.out.println("dersKodu:"+dersKodu+" bulunamadı");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }








public Ders dersbul(int kod) {
        Connection con;
        Statement st;
        Ders ders = null;
        try {
            con = DriverManager.getConnection("jbdc:postgresql://localhost:5432/database", "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "Select * from t_ders where dersKodu=" + kod;
        try {
            ResultSet rS = st.executeQuery(sql);
            rS.next();
            ders.setDersKodu(kod);
            ders = new Ders(rS.getString("dersAdi"), rS.getString("kredi"),
                    rS.getString("ogrSayisi"), rS.getString("ogrAdi"));


        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }

        }

        return ders;


    }










    public static List<Ders> findDersByNameOrLastname(String nameOrLastname){
        List<Ders> list=new ArrayList<>();
        getConnection();
        String searched="%"+nameOrLastname+"%";
        String sql="SELECT * FROM t_ders WHERE dersAdi ILIKE ? OR ogrAdi ILIKE ?";
        getPreparedStatement(sql);
        try {
            prst.setString(1,searched);
            prst.setString(2,searched);
            ResultSet result=prst.executeQuery();
            while (result.next()){
                Ders ders=new Ders();
                ders.setDersKodu(result.getInt("dersKodu"));
                ders.setDersAdi(result.getString("dersAdi"));
                ders.setKredi(result.getString("kredi"));
                ders.setOgrSayisi(result.getString("ogrSayisi"));
                ders.setOgrAdi(result.getString("ogrAdi"));
                list.add(ders);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                prst.close();
                conn.close();
                private void getPreparedStatement(String sql) {
                    try {
                        this.prst = conn.prepareStatement(sql);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
                return list;
            }






































































}

