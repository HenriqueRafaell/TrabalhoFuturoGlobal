package br.com.fiap.TrabalhoFuturo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.TrabalhoFuturo.domain.dto.AvaliacaoPostoTrabalhoDTO;
import br.com.fiap.TrabalhoFuturo.domain.entity.AvaliacaoPostoTrabalho;
import br.com.fiap.TrabalhoFuturo.service.AvaliacaoPostoTrabalhoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoPostoTrabalhoController {

    private final AvaliacaoPostoTrabalhoService service;

    public AvaliacaoPostoTrabalhoController(AvaliacaoPostoTrabalhoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoPostoTrabalho> salvar(
            @Valid @RequestBody AvaliacaoPostoTrabalhoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoPostoTrabalho>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoPostoTrabalho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
