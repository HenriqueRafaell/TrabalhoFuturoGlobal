package br.com.fiap.TrabalhoFuturo.repository;

import br.com.fiap.TrabalhoFuturo.domain.entity.CadastroProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CadastroProfissionalRepository extends JpaRepository<CadastroProfissional, Long> {

    List<CadastroProfissional> findByCargoId(Long cargoId);
    List<CadastroProfissional> findByTipoDeficienciaId(Long tipoDeficienciaId);
    List<CadastroProfissional> findByCargoIdAndTipoDeficienciaId(Long cargoId, Long tipoDeficienciaId);
}
