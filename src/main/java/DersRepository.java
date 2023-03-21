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





































































































































}

