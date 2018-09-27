package controle;
 
import dao.AnuncioDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import projeto.Anuncio;
 
@ManagedBean(name = "anunciosService")
@ApplicationScoped
public class AnunciosService {
     
    public List<Anuncio> getAnuncios() {
        List<Anuncio> list = new ArrayList<Anuncio>();
        AnuncioDao dao = new AnuncioDao();
   
        list = dao.buscarTodos();

        return list;
    }
}
