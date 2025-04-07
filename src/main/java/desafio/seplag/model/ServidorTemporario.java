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
@Table(name = "servidor_temporario")
public class ServidorTemporario {

    @Id
    @OneToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @Temporal(TemporalType.DATE)
    private Date stDataAdmissao;

    @Temporal(TemporalType.DATE)
    private Date stDataDemissao;


    public void setPesId(Integer id) {

    }
}
