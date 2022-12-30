package br.com.quadro.frota.entidades;

import br.com.quadro.frota.dto.AbastecimentoDto;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Abastecimento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Veiculo veiculo;

    private Double valor;
    @ManyToOne
    private Combustivel combustivel;

    private LocalDate localDate;

    public Abastecimento() {
    }
    public Abastecimento(AbastecimentoDto abastecimentoDto) {
        this.id = abastecimentoDto.getId();
        this.valor = abastecimentoDto.getValor();
        this.veiculo = abastecimentoDto.getVeiculo();
        this.combustivel = abastecimentoDto.getCombustivel();
        this.localDate = abastecimentoDto.getLocalDate();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
