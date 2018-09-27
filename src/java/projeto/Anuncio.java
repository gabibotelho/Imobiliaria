package projeto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Anuncio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String cidade;
    @Column(length = 2)
    private String estado;
    @Column(length = 50)
    private String bairro;
    @Column (length = 255)
    private String imagem;
    private int numbanheiros;
    private int numquartos;
    private int numsuites;
    private int areaterreno;
    private int vagasgaragem;
    private double preco;
    
    @ManyToOne(optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name="cliente")
    private Cliente cliente;
    @ManyToOne(optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name="administrador")
    private Administrador administrador;

    public Anuncio() {
    }
    
    public Anuncio(String cidade, String estado, String bairro, int numbanheiros, int numquartos, int numsuites, int areaterreno, int vagasgaragem, double preco, String imagem, Cliente cliente, Administrador administrador){
        id=0;
        this.cidade= cidade;
        this.estado= estado;
        this.bairro=bairro;
        this.numbanheiros=numbanheiros;
        this.numquartos=numquartos;
        this.numsuites=numsuites;
        this.areaterreno=areaterreno;
        this.vagasgaragem=vagasgaragem;
        this.preco= preco;
        this.imagem=imagem;
        this.cliente=cliente;
        this.administrador=administrador;   
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getId());
        hash = 67 * hash + Objects.hashCode(this.getCidade());
        hash = 67 * hash + Objects.hashCode(this.getEstado());
        hash = 67 * hash + Objects.hashCode(this.getBairro());
        hash = 67 * hash + this.getNumbanheiros();
        hash = 67 * hash + this.getNumquartos();
        hash = 67 * hash + this.getNumsuites();
        hash = 67 * hash + this.getAreaterreno();
        hash = (int) (67 * hash + this.getPreco());
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
        final Anuncio other = (Anuncio) obj;
        if (this.getNumbanheiros() != other.getNumbanheiros()) {
            return false;
        }
        if (this.getNumquartos() != other.getNumquartos()) {
            return false;
        }
        if (this.getNumsuites() != other.getNumsuites()) {
            return false;
        }
        if (this.getAreaterreno() != other.getAreaterreno()) {
            return false;
        }
        if (this.getVagasgaragem() != other.getVagasgaragem()) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        return Objects.equals(this.getId(), other.getId());
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumbanheiros() {
        return numbanheiros;
    }

    public void setNumbanheiros(int numbanheiros) {
        this.numbanheiros = numbanheiros;
    }

    public int getNumquartos() {
        return numquartos;
    }

    public void setNumquartos(int numquartos) {
        this.numquartos = numquartos;
    }

    public int getNumsuites() {
        return numsuites;
    }

    public void setNumsuites(int numsuites) {
        this.numsuites = numsuites;
    }

    public int getAreaterreno() {
        return areaterreno;
    }

    public void setAreaterreno(int areaterreno) {
        this.areaterreno = areaterreno;
    }

    public int getVagasgaragem() {
        return vagasgaragem;
    }

    public void setVagasgaragem(int vagasgaragem) {
        this.vagasgaragem = vagasgaragem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
    
    
    
}
