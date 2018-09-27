package util;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil implements Serializable {
    private static final EntityManagerFactory factory;
    static{
        factory = Persistence.createEntityManagerFactory("ImobiliariaPU");
    }
    
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    
}
