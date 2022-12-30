package br.com.quadro.frota.repository;

import br.com.quadro.frota.entidades.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
