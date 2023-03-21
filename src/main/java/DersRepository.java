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




    //Ders ekleme repository
    public void save(Ders ders) {
        getConnection();
        String sql = "INSERT INTO t_ders(dersAdi,kredi,ogrSayisi,ogrAdi) VALUES(?,?,?,?)";
        getPreparedStatement(sql);
        try {
            prst.setString(1,ders.getDersAdi());
            prst.setString(2,ders.getKredi());
            prst.setString(3,ders.getOgrSayisi());
            prst.setString(4,ders.getOgrAdi());
            prst.executeUpdate();
            System.out.println("Ders ekleme işlemi başarıyla gerçekleşti..");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                prst.close();
                conn.close();
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }












































































































































































































}