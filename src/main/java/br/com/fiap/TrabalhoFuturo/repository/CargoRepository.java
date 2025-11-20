package br.com.fiap.TrabalhoFuturo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.TrabalhoFuturo.domain.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
}
