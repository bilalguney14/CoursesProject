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

    private void getStatement(){
        try {
            this.st=conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

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



































































































































































































































