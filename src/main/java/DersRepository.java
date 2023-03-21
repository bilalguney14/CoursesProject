import java.sql.ResultSet;
import java.sql.SQLException;

public class DersRepository {


































    private void getPreparedStatement(String sql) {
        try {
            this.prst = conn.prepareStatement(sql);
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
































    public void findAll(){
        getConnection();
        getStatement();
        String sql = "select * from t_ders";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("+"+"-".repeat(70)+"+");
        System.out.printf("| %-11s | %-15s | %-13s | %-5s | %-15s | \n",
                "Ders Kodu","Ders Adi","Ders Kredisi","Ogr. Sayisi","Ogretmen");
        try {
            while (rs.next()){
                System.out.printf("| %-11s | %-15s | %-13s | %-5s | %-15s | \n",
                        rs.getInt("dersKodu"),rs.getString("dersAdi"),rs.getDouble("kredi"),
                        rs.getInt("ogrSayisi"),rs.getString("ogrAdi"));
            }
            System.out.println("+"+"-".repeat(70)+"+");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }













































































































































































}
