package br.com.fiap.TrabalhoFuturo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.TrabalhoFuturo.domain.dto.AvaliacaoPostoTrabalhoDTO;
import br.com.fiap.TrabalhoFuturo.domain.entity.AvaliacaoPostoTrabalho;
import br.com.fiap.TrabalhoFuturo.domain.entity.CadastroProfissional;
import br.com.fiap.TrabalhoFuturo.repository.AvaliacaoPostoTrabalhoRepository;
import br.com.fiap.TrabalhoFuturo.repository.CadastroProfissionalRepository;

@Service
public class AvaliacaoPostoTrabalhoService {

    private final AvaliacaoPostoTrabalhoRepository repository;
    private final CadastroProfissionalRepository cadastroRepository;

    public AvaliacaoPostoTrabalhoService(
            AvaliacaoPostoTrabalhoRepository repository,
            CadastroProfissionalRepository cadastroRepository) {
        this.repository = repository;
        this.cadastroRepository = cadastroRepository;
    }

    @Transactional
    public AvaliacaoPostoTrabalho salvar(AvaliacaoPostoTrabalhoDTO dto) {

        CadastroProfissional cadastro = cadastroRepository.findById(dto.getCadastroId())
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado com o ID informado"));

        AvaliacaoPostoTrabalho avaliacao = new AvaliacaoPostoTrabalho();
        avaliacao.setCadastroProfissional(cadastro);
        avaliacao.setAcessoRampa(dto.getAcessoRampa());
        avaliacao.setSoftwareLeitorTela(dto.getSoftwareLeitorTela());
        avaliacao.setMesaErgonomicaAjustada(dto.getMesaErgonomicaAjustada());
        avaliacao.setDataAnalise(LocalDateTime.now());

        return repository.save(avaliacao);
    }

    public List<AvaliacaoPostoTrabalho> listar() {
        return repository.findAll();
    }

    public AvaliacaoPostoTrabalho buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não encontrada"));
    }

    @Transactional
    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Avaliação não encontrada");
        }
        repository.deleteById(id);
    }
}
