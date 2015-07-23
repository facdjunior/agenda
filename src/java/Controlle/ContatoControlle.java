package Controlle;

import Bean.ContatoBean;
import DAO.ContatoDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Francisco Junior 23/07/2015
 */
@ManagedBean
@SessionScoped
public class ContatoControlle implements Serializable{
    private ContatoBean contatoB;
    private DataModel listaContatos;

    public ContatoControlle() {
    contatoB = new ContatoBean();
    }

    public ContatoBean getContatoB() {
        return contatoB;
    }

    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }

    public DataModel getListaContatos() {
        ContatoDAO cd = new ContatoDAO();
        listaContatos = new ListDataModel(cd.listarContato());
        return listaContatos;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    public void novoContato(){
        contatoB = new ContatoBean();
    }
    
    public void selecionarContato(){
        contatoB = (ContatoBean) listaContatos.getRowData();
    }
    
    public String salvaContato(){
        ContatoDAO cd = new ContatoDAO();
        if(cd.salvarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso",""));
            return "listacontatos";
        }
        return "erro";
    }
    
    public String editarContato(){
        ContatoDAO cd = new ContatoDAO();
        if(cd.editarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado alterado com Sucesso",""));
            return "listacontatos";
        }
        return "erro";
    }
    
    public String excluirContato(){
        ContatoDAO cd = new ContatoDAO();
        if(cd.excluirContato(contatoB)){ 
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado excluído com Sucesso",""));
            return "listacontatos";
        } 
        return "erro";
    }
    
    
}
