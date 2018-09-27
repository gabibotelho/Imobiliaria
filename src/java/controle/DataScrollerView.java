package controle;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import projeto.Anuncio;
 
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
     
    private List<Anuncio> anuncios;
         
    @ManagedProperty("#{anunciosService}")
    private AnunciosService service;
     
    @PostConstruct
    public void init() {
        anuncios = service.getAnuncios();
    }
 
    public List<Anuncio> getAnuncios() {
        return anuncios;
    }
    public void setService(AnunciosService service) {
        this.service = service;
    }
}