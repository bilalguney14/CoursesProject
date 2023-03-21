import java.sql.*;

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
