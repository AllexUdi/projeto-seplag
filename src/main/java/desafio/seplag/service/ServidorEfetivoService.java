package desafio.seplag.service;


import desafio.seplag.model.ServidorEfetivo;
import desafio.seplag.projection.ServidorEfetivoProjection;
import desafio.seplag.repository.ServidorEfetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.Period;

public class ServidorEfetivoService {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;

    public Page<ServidorEfetivoProjection> buscarPorUnidade(Integer unidId, Pageable pageable) {
        return servidorEfetivoRepository.buscarPorUnidade(unidId, pageable);
    }

    public Page<ServidorEfetivo> buscarEnderecoFuncionalPorNome(String nome, Pageable pageable) {
        return servidorEfetivoRepository.findByPessoaPesNomeContaining(nome, pageable);
    }

    public ServidorEfetivo salvar(ServidorEfetivo servidorEfetivo) {
        return servidorEfetivoRepository.save(servidorEfetivo);
    }

    public ServidorEfetivo atualizar(Integer id, ServidorEfetivo servidorEfetivo){
        return servidorEfetivoRepository.findById(id).map(existing -> {
            servidorEfetivo.setId(id);
            return servidorEfetivoRepository.save(servidorEfetivo);
        }).orElse(null);
    }

    public int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
