package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import projeto.Anuncio;
import util.JpaUtil;

public class AnuncioDao implements Serializable {
    
    public boolean inserir(Anuncio anuncio){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(anuncio);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Anuncio> buscarTodos() {
        List<Anuncio> temp = new ArrayList<Anuncio>();
        EntityManager manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Anuncio a";
        TypedQuery<Anuncio> query = manager.createQuery(sql, Anuncio.class);
        try {
            temp = query.getResultList();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
            System.out.println("e");
        } finally {
            manager.close();
        } 
        System.out.println(temp);
        return temp;
    }
    
}
