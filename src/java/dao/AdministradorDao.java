package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import projeto.Administrador;
import util.JpaUtil;

public class AdministradorDao implements Serializable{
    
    public boolean inserir(Administrador adm){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(adm);
        tx.commit();
        manager.close();
        return true;
    }
    
    public Administrador autenticar(Administrador adm){
        Administrador temp = null; // administrador retornado na consulta ao banco
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Administrador> query = manager.createQuery("SELECT a FROM Administrador as a  WHERE a.login = :login AND a.senha = :senha", Administrador.class); 
        query.setParameter("login", adm.getLogin());
        query.setParameter("senha", adm.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ 
            System.out.println(e);
            
        }     
        finally{
            manager.close();
        } 
        return temp;
    }
        
}
    

