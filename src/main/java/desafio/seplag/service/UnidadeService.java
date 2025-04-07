package desafio.seplag.service;

import desafio.seplag.model.ServidorTemporario;
import desafio.seplag.model.Unidade;
import desafio.seplag.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> ListarTodos(){
        return unidadeRepository.findAll();
    }

    public Unidade salvar(Unidade unidade){
        return unidadeRepository.save(unidade);
    }

    public Unidade atualizar(Integer id, Unidade unidade) {
        if (unidadeRepository.existsById(id)) {
            unidade.setUnidId(id);
            return unidadeRepository.save(unidade);
        }
        return null;
    }

    public void deletar(Integer id){
        unidadeRepository.deleteById(id);
    }

}
