package desafio.seplag.controller;

import desafio.seplag.model.Lotacao;
import desafio.seplag.model.ServidorTemporario;
import desafio.seplag.service.LotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoService lotacaoService;

    @GetMapping
    public List<Lotacao> listar() {
        return lotacaoService.ListarTodos();
    }

    @PostMapping
    public Lotacao criar(@RequestBody Lotacao lotacao) {
        return lotacaoService.salvar(lotacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lotacao> atualizar(@PathVariable Integer id, @RequestBody Lotacao lotacao) {
        Lotacao atualizado = lotacaoService.atualizar(id, lotacao);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        lotacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
