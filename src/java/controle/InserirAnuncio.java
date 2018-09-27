package controle;

import dao.Dao;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.MultipartConfig;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;
import projeto.Administrador;
import projeto.Anuncio;
import projeto.Cliente;

@MultipartConfig
@ManagedBean (name="inserirAnuncio")
@ViewScoped
public class InserirAnuncio implements Serializable{
    private Anuncio anuncio;
    private Dao<Anuncio> dao;
    private UploadedFile uploadedFile;
    
    public InserirAnuncio(){
        anuncio = new Anuncio();
        dao = new Dao(Anuncio.class);
    }
    
    public void novoAnuncio(){
        if(this.uploadedFile.getSize()>0){
            try {
                Path pasta = Paths.get("C:\\Users\\gabri\\Documents\\NetBeansProjects\\Imobiliaria\\web\\anuncio\\imagens");
                String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());
                String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
                Path file = Files.createTempFile(pasta, filename + "-", "." + extension);
                try(InputStream input = uploadedFile.getInputstream()){
                    Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
                }
                this.anuncio.setAdministrador(new Administrador());
                this.anuncio.setCliente(new Cliente());
                this.anuncio.setImagem(file.getFileName().toString());
                dao.inserir(this.anuncio);
                this.anuncio = new Anuncio();
                FacesContext.getCurrentInstance().addMessage(
                           null, new FacesMessage("Anuncio cadastrado", 
                           "Anuncio cadastrado com sucesso!"));
            } catch(IOException e) {
                FacesContext.getCurrentInstance().addMessage(
                          null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
            }
        }
    }
    
    public Anuncio getAnuncio() {
        return anuncio;
    }


    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    
    public UploadedFile getUploadedFile() {
        return this.uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
