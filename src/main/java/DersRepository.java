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











































































































































}
