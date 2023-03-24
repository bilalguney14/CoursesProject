

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DersRepository {
    private Connection conn;
    private Statement st;
    private PreparedStatement prst;

    private void getConnection() {
        try {
            this.conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_study","user_db","123456");
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

    private void getStatement() {

        try {
            this.st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createTable() {
        getConnection();
        getStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS t_ders (dersKodu SERIAL, dersAdi VARCHAR(50), kredi VARCHAR(5), ogrSayisi VARCHAR(5) , ogrAdi VARCHAR(50))");
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
            prst.setString(1, ders.getDersAdi());
            prst.setString(2, ders.getKredi());
            prst.setString(3, ders.getOgrSayisi());
            prst.setString(4, ders.getOgrAdi());
            prst.executeUpdate();
            System.out.println("Ders ekleme işlemi başarıyla gerçekleşti...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void findAll() {
        getConnection();
        getStatement();
        String sql = "select * from t_ders";
        try {
            ResultSet rs = st.executeQuery(sql);
            System.out.println("+" + "-".repeat(89) + "+");
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | \n",
                    "Ders Kodu", "Ders Adi", "Ders Kredisi", "Ogr. Sayisi", "Ogrenci Adi");

            while (rs.next()) {
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | \n",
                        rs.getInt("dersKodu"), rs.getString("dersAdi"), rs.getString("kredi"),
                        rs.getInt("ogrSayisi"), rs.getString("ogrAdi"));
            }
            System.out.println("+" + "-".repeat(89) + "+");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //20-veri güncelleme
    public void update(Ders ders) {
        getConnection();
        String sql = "UPDATE t_ders SET dersAdi=?,kredi=?,ogrSayisi=?,ogrAdi=? WHERE dersKodu=?";
        getPreparedStatement(sql);
        try {
            prst.setString(1, ders.getDersAdi());
            prst.setString(2, ders.getKredi());
            prst.setString(3, ders.getOgrSayisi());
            prst.setString(4, ders.getOgrAdi());
            prst.setInt(5, ders.getDersKodu());
            int updated = prst.executeUpdate();
            if (updated > 0) {
                System.out.println("Ders başarıyla güncellendi.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }




    public void delete(int dersKodu) {
        getConnection();
        String sql = "DELETE FROM t_ders WHERE dersKodu=?";
        getPreparedStatement(sql);
        try {
            prst.setInt(1, dersKodu);
            int deleted = prst.executeUpdate();
            if (deleted > 0) {
                System.out.println("dersKodu:" + dersKodu + " olan kayıt başarıyla silinmiştir");
            } else {
                System.out.println("dersKodu:" + dersKodu + " bulunamadı");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

/*
student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setLastname(resultSet.getString("lastname"));
                student.setCity(resultSet.getString("city"));
                student.setAge(resultSet.getInt("age"));
 */
    public Ders findDersById(int dersKodu) {
        Ders ders = null;
        getConnection();
        String sql = "Select * from t_ders where dersKodu = ?";
        getPreparedStatement(sql);
        try {
            prst.setInt(1,dersKodu);
            ResultSet rS = prst.executeQuery();
            if(rS.next()) {
                ders=new Ders();
                ders.setDersKodu(rS.getInt("dersKodu"));
                ders.setDersAdi(rS.getString("dersAdi"));
                ders.setKredi(rS.getString("kredi"));
                ders.setOgrSayisi(rS.getString("ogrSayisi"));
                ders.setOgrAdi(rS.getString("ogrAdi"));
            }
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
        return ders;
    }


    public  List<Ders> findDersByNameOrLastname(String nameOrLastname) {
        List<Ders> list = new ArrayList<>();
        getConnection();
        String searched = "%" + nameOrLastname + "%";
        String sql = "SELECT * FROM t_ders WHERE dersAdi ILIKE ? OR ogrAdi ILIKE ?";
        getPreparedStatement(sql);
        try {
            prst.setString(1, searched);
            prst.setString(2, searched);
            ResultSet result = prst.executeQuery();
            while (result.next()) {
                Ders ders = new Ders();
                ders.setDersKodu(result.getInt("dersKodu"));
                ders.setDersAdi(result.getString("dersAdi"));
                ders.setKredi(result.getString("kredi"));
                ders.setOgrSayisi(result.getString("ogrSayisi"));
                ders.setOgrAdi(result.getString("ogrAdi"));
                list.add(ders);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }

        }
        return list;
    }


}





















