package br.com.fiap.TrabalhoFuturo.service;

import br.com.fiap.TrabalhoFuturo.domain.dto.CadastroProfissionalDTO;
import br.com.fiap.TrabalhoFuturo.domain.entity.CadastroProfissional;
import br.com.fiap.TrabalhoFuturo.domain.entity.CargoEntity;
import br.com.fiap.TrabalhoFuturo.domain.entity.TipoDeficienciaEntity;
import br.com.fiap.TrabalhoFuturo.exception.ProfissionalNotFoundException;
import br.com.fiap.TrabalhoFuturo.repository.CadastroProfissionalRepository;
import br.com.fiap.TrabalhoFuturo.repository.CargoRepository;
import br.com.fiap.TrabalhoFuturo.repository.TipoDeficienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CadastroProfissionalService {

    @Autowired
    private CadastroProfissionalRepository cadastroProfissionalRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private TipoDeficienciaRepository tipoDeficienciaRepository;

    public List<CadastroProfissional> getAllProfissionais() {
        return cadastroProfissionalRepository.findAll();
    }

    public List<CadastroProfissional> searchProfissionais(Optional<Long> cargoId, Optional<Long> tipoDeficienciaId) {
        if (cargoId.isPresent() && tipoDeficienciaId.isPresent()) {
            return cadastroProfissionalRepository.findByCargoIdAndTipoDeficienciaId(cargoId.get(), tipoDeficienciaId.get());
        } else if (cargoId.isPresent()) {
            return cadastroProfissionalRepository.findByCargoId(cargoId.get());
        } else if (tipoDeficienciaId.isPresent()) {
            return cadastroProfissionalRepository.findByTipoDeficienciaId(tipoDeficienciaId.get());
        } else {
            return getAllProfissionais();
        }
    }

    public CadastroProfissional updateProfissional(Long id, CadastroProfissionalDTO cadastroProfissionalDTO) {
        CadastroProfissional profissionalExistente = cadastroProfissionalRepository.findById(id)
                .orElseThrow(() -> new ProfissionalNotFoundException("Profissional com id " + id + " não encontrado"));

        CargoEntity cargo = cargoRepository.findById(cadastroProfissionalDTO.getCargoId())
                                           .orElseThrow(() -> new ProfissionalNotFoundException("Cargo não encontrado"));
        TipoDeficienciaEntity tipoDeficiencia = tipoDeficienciaRepository.findById(cadastroProfissionalDTO.getTipoDeficienciaId())
                                                                         .orElseThrow(() -> new ProfissionalNotFoundException("Tipo de Deficiência não encontrado"));

        profissionalExistente.setNome(cadastroProfissionalDTO.getNome());
        profissionalExistente.setCargo(cargo);
        profissionalExistente.setIdade(cadastroProfissionalDTO.getIdade());
        profissionalExistente.setTipoDeficiencia(tipoDeficiencia);
        return cadastroProfissionalRepository.save(profissionalExistente);
    }

    public void deleteProfissional(Long id) {
        CadastroProfissional profissional = cadastroProfissionalRepository.findById(id)
                .orElseThrow(() -> new ProfissionalNotFoundException("Profissional não encontrado"));
        cadastroProfissionalRepository.delete(profissional);
    }

    public CadastroProfissional cadastrarProfissional(CadastroProfissionalDTO cadastroProfissionalDTO) {
        CargoEntity cargo = cargoRepository.findById(cadastroProfissionalDTO.getCargoId())
                                           .orElseThrow(() -> new ProfissionalNotFoundException("Cargo não encontrado"));
        TipoDeficienciaEntity tipoDeficiencia = tipoDeficienciaRepository.findById(cadastroProfissionalDTO.getTipoDeficienciaId())
                                                                         .orElseThrow(() -> new ProfissionalNotFoundException("Tipo de Deficiência não encontrado"));

        CadastroProfissional novoProfissional = new CadastroProfissional();
        novoProfissional.setNome(cadastroProfissionalDTO.getNome());
        novoProfissional.setCargo(cargo);
        novoProfissional.setIdade(cadastroProfissionalDTO.getIdade());
        novoProfissional.setTipoDeficiencia(tipoDeficiencia);
        novoProfissional.setDataCriacao(LocalDateTime.now());

        return cadastroProfissionalRepository.save(novoProfissional);
    }
}
