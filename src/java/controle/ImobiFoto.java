package controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImobiFoto {
    private List<String> imagens;
     
    @PostConstruct
    public void init() {
        imagens = new ArrayList<String>();
        
        imagens.add("atende2.jpg");
        imagens.add("atende3.jpg");
        imagens.add("atendimento.jpg");
        imagens.add("gerente.jpg");
    }
 
    public List<String> getImagens() {
        return imagens;
    }
    
}
