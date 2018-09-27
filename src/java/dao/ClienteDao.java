package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import projeto.Cliente;
import util.JpaUtil;

public class ClienteDao implements Serializable{
    
    public boolean inserir(Cliente cliente){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(cliente);
        tx.commit();
        manager.close();
        return true;
    }
    
}
