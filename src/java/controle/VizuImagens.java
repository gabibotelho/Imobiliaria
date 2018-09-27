package controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class VizuImagens {

    private List<String> imagens;

    @PostConstruct
    public void init() {
        imagens = new ArrayList<String>();

        imagens.add("sala.jpg");
        imagens.add("salas.jpg");
        imagens.add("cozinha.jpg");
        imagens.add("quarto1.jpg");
        imagens.add("quarto2.jpg");
        imagens.add("quarto3.jpg");
        imagens.add("ambiente.jpg");   
    }

    public List<String> getImagens() {
        return imagens;
    }
}
