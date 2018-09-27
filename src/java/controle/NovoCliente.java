package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import projeto.Cliente;

@ManagedBean (name="novoCliente")
@ViewScoped
public class NovoCliente implements Serializable {
    private Cliente cliente;
    private Dao<Cliente> dao;
    
    public NovoCliente(){
        cliente = new Cliente();
        dao = new Dao(Cliente.class);
    }
    
    public void salvarCliente(){
        dao.inserir(this.cliente);
        this.cliente = new Cliente();
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",  "Cliente cadastrado.") );
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}