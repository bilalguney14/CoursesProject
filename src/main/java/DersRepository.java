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
