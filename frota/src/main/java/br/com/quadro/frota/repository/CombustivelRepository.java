package br.com.quadro.frota.repository;

import br.com.quadro.frota.entidades.Combustivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {

}
