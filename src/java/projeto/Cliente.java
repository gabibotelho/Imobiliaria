package projeto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cliente implements Serializable {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10)
    private String nome;
    @Column(length = 100)
    private String email;
    @Column(length = 15)
    private String telefone;
    @Column(length = 255)
    private String mensagem;
    
    @OneToMany(mappedBy = "cliente")
    private List<Anuncio> anuncios;

    public Cliente() {
    }
    
    public Cliente(String nome, String email, String telefone, String mensagem, List<Anuncio> anuncios){
        id=0;
        this.nome= nome;
        this.email= email;
        this.telefone=telefone;
        this.mensagem=mensagem;
        this.anuncios=anuncios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.getId());
        hash = 71 * hash + Objects.hashCode(this.getNome());
        hash = 71 * hash + Objects.hashCode(this.getEmail());
        hash = 71 * hash + Objects.hashCode(this.getTelefone());
        hash = 71 * hash + Objects.hashCode(this.getMensagem());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        return Objects.equals(this.getId(), other.getId());
    }     

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the anuncios
     */
    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    /**
     * @param anuncios the anuncios to set
     */
    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
    
}


