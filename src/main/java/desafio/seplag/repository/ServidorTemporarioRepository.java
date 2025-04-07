package desafio.seplag.repository;

import desafio.seplag.model.ServidorTemporario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServidorTemporarioRepository extends JpaRepository<ServidorTemporario, Integer> {


}
