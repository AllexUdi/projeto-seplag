package desafio.seplag.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servidor_efetivo")
public class ServidorEfetivo {

    @Id
    @OneToMany
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    private String seMatricula;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSeMatricula() {
        return seMatricula;
    }

    public void setSeMatricula(String seMatricula) {
        this.seMatricula = seMatricula;
    }


    public void setId(Integer id) {
    }
}
