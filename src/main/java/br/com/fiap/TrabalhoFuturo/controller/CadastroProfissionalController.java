package br.com.fiap.TrabalhoFuturo.controller;

import br.com.fiap.TrabalhoFuturo.domain.dto.CadastroProfissionalDTO;
import br.com.fiap.TrabalhoFuturo.domain.entity.CadastroProfissional;
import br.com.fiap.TrabalhoFuturo.service.CadastroProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cadastro-profissional")
public class CadastroProfissionalController {

    @Autowired
    private CadastroProfissionalService cadastroProfissionalService;
    
    @PostMapping
    public ResponseEntity<CadastroProfissional> cadastrarProfissional(@RequestBody CadastroProfissionalDTO cadastroProfissionalDTO) {
        CadastroProfissional cadastroProfissional = cadastroProfissionalService.cadastrarProfissional(cadastroProfissionalDTO);
        return new ResponseEntity<>(cadastroProfissional, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CadastroProfissional>> getAllProfissionais() {
        List<CadastroProfissional> profissionais = cadastroProfissionalService.getAllProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CadastroProfissional>> searchProfissionais(
            @RequestParam Optional<Long> cargoId,
            @RequestParam Optional<Long> tipoDeficienciaId) {

        List<CadastroProfissional> profissionais = cadastroProfissionalService.searchProfissionais(cargoId, tipoDeficienciaId);
        return ResponseEntity.ok(profissionais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroProfissional> updateProfissional(
            @PathVariable Long id, 
            @RequestBody CadastroProfissionalDTO cadastroProfissionalDTO) {

        CadastroProfissional updatedProfissional = cadastroProfissionalService.updateProfissional(id, cadastroProfissionalDTO);
        return ResponseEntity.ok(updatedProfissional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id) {
        cadastroProfissionalService.deleteProfissional(id);
        return ResponseEntity.noContent().build();
    }
}
