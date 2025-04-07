package desafio.seplag.service;

import desafio.seplag.model.Pessoa;
import desafio.seplag.model.ServidorTemporario;
import desafio.seplag.repository.PessoaRepository;
import desafio.seplag.repository.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorTemporarioService {

    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;

    public List<ServidorTemporario> ListarTodos(){
        return servidorTemporarioRepository.findAll();
    }

    public ServidorTemporario salvar(ServidorTemporario servidorTemporario){
        return servidorTemporarioRepository.save(servidorTemporario);
    }

    public ServidorTemporario atualizar(Integer id, ServidorTemporario servidorTemporario) {
        if (servidorTemporarioRepository.existsById(id)) {
            servidorTemporario.setPesId(id);
            return servidorTemporarioRepository.save(servidorTemporario);
        }
        return null;
    }

    public void deletar(Integer id){
        servidorTemporarioRepository.deleteById(id);
    }

}
