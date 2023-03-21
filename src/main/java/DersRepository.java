import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
