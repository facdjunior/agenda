package DAO;

import Bean.ContatoBean;
import Utilitario.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Junior 23/07/2015
 */
public class ContatoDAO {
 private Conexao Con;

    public ContatoDAO() {
        Con = new Conexao();
    }
 
    //METODO SALVAR
    public boolean salvarContato(ContatoBean contato){
     try {
         String sql = "INSERT INTO CONTATO(NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL)"
                 +"VALUES(?,?,?,?,?,?,?)";
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, contato.getNome());
         stm.setString(2, contato.getEndereco());
         stm.setString(3, contato.getCidade());
         stm.setString(4, contato.getUF());
         stm.setString(5, contato.getTelefone());
         stm.setString(6, contato.getCelular());
         stm.setString(7, contato.getEmail());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //METODO EDITAR
    public boolean editarContato(ContatoBean contato){
     try {
         String sql = "UPDATE CONTATO SET NOME =?, ENDERECO=?, CIDADE=?, UF=?, TELEFONE=?, CELULAR=?, EMAIL=? WHERE ID= ?;"
                 +"VALUES(?,?,?,?,?,?,?)";
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setString(1, contato.getNome());
         stm.setString(2, contato.getEndereco());
         stm.setString(3, contato.getCidade());
         stm.setString(4, contato.getUF());
         stm.setString(5, contato.getTelefone());
         stm.setString(6, contato.getCelular());
         stm.setString(7, contato.getEmail());
         stm.setInt(9, contato.getId());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //metodo Excluir
    public boolean excluirContato(ContatoBean contato){
     try {
         String sql = "DELETE FROM CONTATO WHERE ID = ?;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         stm.setInt(1, contato.getId());
         
         stm.execute();
         Con.getConnection().commit();
         
    return true;
         
     } catch (SQLException ex) {
         Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }
    
    //metodo Listar
    public List<ContatoBean> listarContato(){
        List<ContatoBean> lista = new ArrayList<ContatoBean>();
     try {
         String sql = "SELECT * FROM CONTATO ORDER BY NOME;";
                 
         PreparedStatement stm = Con.getConnection().prepareStatement(sql);
         
         ResultSet rs = stm.executeQuery();
         
         while (rs.next()) {
             
             ContatoBean contato = new ContatoBean();
             contato.setId(rs.getInt("ID"));
             contato.setNome(rs.getString("nome"));
             contato.setEndereco(rs.getString("endereco"));
             contato.setCidade(rs.getString("cidade"));
             contato.setUF(rs.getString("uf"));
             contato.setTelefone(rs.getString("telefone"));
             contato.setCelular(rs.getString("celular"));
             contato.setEmail(rs.getString("email"));
             lista.add(contato);
         }
    }  catch (SQLException ex) {
         Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista;
    }
}
