package desafio.seplag.controller;

import desafio.seplag.model.ServidorTemporario;
import desafio.seplag.model.Unidade;
import desafio.seplag.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public List<Unidade> listar() {
        return unidadeService.ListarTodos();
    }

    @PostMapping
    public Unidade criar(@RequestBody Unidade unidade) {
        return unidadeService.salvar(unidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable Integer id, @RequestBody Unidade unidade) {
        Unidade atualizado = unidadeService.atualizar(id, unidade);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
