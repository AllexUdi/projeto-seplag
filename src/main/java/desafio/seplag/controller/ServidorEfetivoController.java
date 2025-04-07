package desafio.seplag.controller;

import desafio.seplag.model.ServidorEfetivo;
import desafio.seplag.projection.ServidorEfetivoProjection;
import desafio.seplag.service.ServidorEfetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ServidorEfetivoController {

    @Autowired
    private ServidorEfetivoService servidorEfetivoService;

    @GetMapping("/unidade/{unidId}")
    public ResponseEntity<Page<ServidorEfetivoProjection>> buscarPorUnidade(@PathVariable Integer unidId, Pageable pageable) {
        Page<ServidorEfetivoProjection> servidores = servidorEfetivoService.buscarPorUnidade(unidId, pageable);
        return servidores.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(servidores);

    }

    @GetMapping("/buscar-endereco")
    public ResponseEntity<Page<ServidorEfetivo>> buscarEnderecoFuncionalPorNome(@RequestParam String nome,Pageable pageable){
        Page<ServidorEfetivo> servidores = servidorEfetivoService.buscarEnderecoFuncionalPorNome(nome, pageable);
        return servidores.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(servidores);

    }

    @PostMapping
    public ResponseEntity<ServidorEfetivo> criar(@RequestBody ServidorEfetivo servidorEfetivo){
        return ResponseEntity.ok(servidorEfetivoService.salvar(servidorEfetivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorEfetivo> atualizar(@PathVariable Integer id, @RequestBody ServidorEfetivo servidorEfetivo) {
        ServidorEfetivo atualizado = servidorEfetivoService.atualizar(id, servidorEfetivo);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }


}
