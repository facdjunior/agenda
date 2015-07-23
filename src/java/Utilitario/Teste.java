package Utilitario;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Junior 23/07/2015
 */
public class Teste {
    
    

    public static void main(String[] args) {
  
        try {
            Conexao Con = new Conexao();
            PreparedStatement stm = (PreparedStatement) Con.getConnection().prepareStatement("select * from contato;");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("NOME"));
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
