package dao;
 

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import projeto.Administrador;
import projeto.Anuncio;
import projeto.Cliente;

public class AdministradorDaoTest {
    
    @Test
    public void testInserir(){
        AdministradorDao dao = new AdministradorDao();
        List anuncios = new ArrayList<>();
        Administrador adm = new Administrador("TICO", "Tico Silva", "1234", anuncios);
        Cliente cliente = new Cliente("Gabriela", "gabibotelho@gmail.com", "018996087063", "tenho interesse", anuncios);
        Anuncio anuncio = new Anuncio("Assis", "SP", "Vila Gloria", 2, 3, 1, 200, 2, 200000, "", cliente,adm);
        anuncios.add(anuncio);
        
        dao.inserir(adm);   
    }

    
}
