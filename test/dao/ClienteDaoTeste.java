package dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import projeto.Administrador;
import projeto.Anuncio;
import projeto.Cliente;

public class ClienteDaoTeste {
    
     @Test
    public void testInserirCliente(){
        ClienteDao dao = new ClienteDao();
        List anuncios = new ArrayList<>();
        Cliente cliente = new Cliente("Gabriela", "gabibotelho@gmail.com", "018996087063", "tenho interesse", anuncios);
        Administrador adm = new Administrador("TICO", "Tico Silva", "1234", anuncios);
        Anuncio anuncio = new Anuncio("Assis", "SP", "Vila Gloria", 2, 3, 1, 200, 2, 200000,"", cliente,adm);
        anuncios.add(anuncio);
    }
    
}
