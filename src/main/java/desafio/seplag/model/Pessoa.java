package desafio.seplag.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name= "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pesId;
    private String pesNome;

    @Temporal(TemporalType.DATE)
    private Date pessDataNascimento;

    private String pesSexo;
    private String pesMae;
    private String pesPai;

    @OneToMany
    @JoinColumn(name = "pes_id")
    private FotoPessoa fotoPessoa;

    @OneToMany
    @JoinColumn(name = "pes_id")
    private PessoaEndereco pessoaEndereco;

    @OneToMany
    @JoinColumn(name = "pes_id")
    private ServidorTemporario servidorTemporario;

    @OneToMany
    @JoinColumn(name = "pes_id")
    private ServidorEfetivo servidorEfetivo;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Lotacao lotacao;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private UnidadeEndereco unidadeEndereco;

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public Date getPessDataNascimento() {
        return pessDataNascimento;
    }

    public void setPessDataNascimento(Date pessDataNascimento) {
        this.pessDataNascimento = pessDataNascimento;
    }

    public String getPesSexo() {
        return pesSexo;
    }

    public void setPesSexo(String pesSexo) {
        this.pesSexo = pesSexo;
    }

    public String getPesMae() {
        return pesMae;
    }

    public void setPesMae(String pesMae) {
        this.pesMae = pesMae;
    }

    public String getPesPai() {
        return pesPai;
    }

    public void setPesPai(String pesPai) {
        this.pesPai = pesPai;
    }

    public FotoPessoa getFotoPessoa() {
        return fotoPessoa;
    }

    public void setFotoPessoa(FotoPessoa fotoPessoa) {
        this.fotoPessoa = fotoPessoa;
    }

    public PessoaEndereco getPessoaEndereco() {
        return pessoaEndereco;
    }

    public void setPessoaEndereco(PessoaEndereco pessoaEndereco) {
        this.pessoaEndereco = pessoaEndereco;
    }

    public ServidorTemporario getServidorTemporario() {
        return servidorTemporario;
    }

    public void setServidorTemporario(ServidorTemporario servidorTemporario) {
        this.servidorTemporario = servidorTemporario;
    }

    public ServidorEfetivo getServidorEfetivo() {
        return servidorEfetivo;
    }

    public void setServidorEfetivo(ServidorEfetivo servidorEfetivo) {
        this.servidorEfetivo = servidorEfetivo;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public UnidadeEndereco getUnidadeEndereco() {
        return unidadeEndereco;
    }

    public void setUnidadeEndereco(UnidadeEndereco unidadeEndereco) {
        this.unidadeEndereco = unidadeEndereco;
    }
}
