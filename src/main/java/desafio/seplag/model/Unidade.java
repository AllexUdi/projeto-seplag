package desafio.seplag.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unidId;
    private String unidNome;
    private String unidSigla;

    @OneToMany
    @JoinColumn(name = "unid_id")
    private Lotacao lotacao;

    @OneToMany
    @JoinColumn(name = "unid_id")
    private UnidadeEndereco unidadeEndereco;

    public Integer getUnidId() {
        return unidId;
    }

    public void setUnidId(Integer unidId) {
        this.unidId = unidId;
    }

    public String getUnidNome() {
        return unidNome;
    }

    public void setUnidNome(String unidNome) {
        this.unidNome = unidNome;
    }

    public String getUnidSigla() {
        return unidSigla;
    }

    public void setUnidSigla(String unidSigla) {
        this.unidSigla = unidSigla;
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
