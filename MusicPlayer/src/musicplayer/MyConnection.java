/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author VIQRI
 */
public class MyConnection {
    
    Connection conn = null;
    
    public MyConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Musik", "root", "");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void insertLagu(Lagu m){
        if(m != null){
            try {
                PreparedStatement p = conn.prepareStatement("insert into DaftarMusik "
                        + "(id, nama_lagu, lokasi_lagu) values (?, ?, ?)");
                p.setString(1, m.getIdLagu());
                p.setString(2, m.getNamaLagu());
                p.setString(3, m.getAlamatLagu());
                p.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteLagu(Lagu m){
        if(m != null){
            try {
                PreparedStatement p = conn.prepareStatement("delete from DaftarMusik "
                        + "where id = ? ");
                p.setString(1, m.getIdLagu());
                p.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<Lagu> findAllLagu(){
        ArrayList<Lagu> lsMahasiswa = new ArrayList<Lagu>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from DaftarMusik");
            while(rs.next()){
                Lagu m = new Lagu();
                m.setIdLagu(rs.getString(1));
                m.setNamaLagu(rs.getString(2));
                m.setAlamatLagu(rs.getString(3));
                lsMahasiswa.add(m);
            }
        } catch (SQLException ex) { 
        }
        return lsMahasiswa;
    }
    
}
