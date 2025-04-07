package desafio.seplag.controller;

import desafio.seplag.model.ServidorTemporario;
import desafio.seplag.service.ServidorTemporarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servidor-temporario")
public class ServidorTemporarioController {

    @Autowired
    private ServidorTemporarioService servidorTemporarioService;

    @GetMapping
    public List<ServidorTemporario> listar() {
        return servidorTemporarioService.ListarTodos();
    }

    @PostMapping
    public ServidorTemporario criar(@RequestBody ServidorTemporario servidorTemporario) {
        return servidorTemporarioService.salvar(servidorTemporario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorTemporario> atualizar(@PathVariable Integer id, @RequestBody ServidorTemporario servidorTemporario) {
        ServidorTemporario atualizado = servidorTemporarioService.atualizar(id, servidorTemporario);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servidorTemporarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
