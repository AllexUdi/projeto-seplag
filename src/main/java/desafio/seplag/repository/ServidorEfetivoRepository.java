package desafio.seplag.repository;

import desafio.seplag.model.ServidorEfetivo;
import desafio.seplag.projection.ServidorEfetivoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Integer> {

    Page<ServidorEfetivo> findByPessoaPesNomeContaining(String nome, Pageable pageable);

    @Query("""
        SELECT 
            s.pessoa.pesNome AS nome,
            FUNCTION('timestampdiff', YEAR, s.pessoa.pessDataNascimento, CURRENT_DATE) AS idade,
            l.unidade.unidNome AS unidade,
            f.fpHash AS fotografia
        FROM ServidorEfetivo s
        JOIN Lotacao l ON l.pessoa.pesId = s.pessoa.pesId
        LEFT JOIN FotoPessoa f ON f.pessoa.pesId = s.pessoa.pesId
        WHERE l.unidade.unidId = :unidId
    """)
    Page<ServidorEfetivoProjection> buscarPorUnidade(Integer unidId, Pageable pageable);


}
