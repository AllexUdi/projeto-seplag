package desafio.seplag.service;

import desafio.seplag.model.Lotacao;
import desafio.seplag.repository.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotacaoService {
    
    #
    @Autowired
    private LotacaoRepository lotacaoRepository;

    public List<Lotacao> ListarTodos(){
        return lotacaoRepository.findAll();
    }

    public Lotacao salvar(Lotacao lotacao){
        return lotacaoRepository.save(lotacao);
    }

    public Lotacao atualizar(Integer id, Lotacao lotacao) {
        if (lotacaoRepository.existsById(id)) {
            lotacao.setLotId(id);
            return lotacaoRepository.save(lotacao);
        }
        return null;
    }

    public void deletar(Integer id){
        lotacaoRepository.deleteById(id);
    }
}
