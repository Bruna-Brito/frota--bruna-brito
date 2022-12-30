package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Abastecimento;
import br.com.quadro.frota.entidades.Combustivel;
import br.com.quadro.frota.entidades.Motorista;
import br.com.quadro.frota.entidades.Veiculo;
import br.com.quadro.frota.repository.CombustivelRepository;
import br.com.quadro.frota.repository.MotoristaRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDto {
     private Long id;

     private Double valor;
     private Veiculo veiculo;
     private Combustivel combustivel;
     private LocalDate localDate;

    public AbastecimentoDto(){}
    public AbastecimentoDto(Abastecimento abastecimento) {
        this.id = abastecimento.getId();
        this.valor = abastecimento.getValor();
        this.veiculo = abastecimento.getVeiculo();
        this.combustivel = abastecimento.getCombustivel();
        this.localDate = abastecimento.getLocalDate();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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


    public static Abastecimento converterAbastecimentoDtoParaAbastecimento(AbastecimentoDto dto){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setId(dto.getId());
        abastecimento.setCombustivel(dto.getCombustivel());
        abastecimento.setLocalDate(dto.getLocalDate());
        abastecimento.setValor(dto.getValor());
        abastecimento.setVeiculo(dto.getVeiculo());
        return abastecimento;
    }

    public static AbastecimentoDto converterAbastecimentoParaAbastecimentoDto (Abastecimento abastecimento){
        AbastecimentoDto dto = new AbastecimentoDto();
        dto.setId(abastecimento.getId());
        dto.setCombustivel(abastecimento.getCombustivel());
        dto.setLocalDate(abastecimento.getLocalDate());
        dto.setValor(abastecimento.getValor());
        dto.setVeiculo(abastecimento.getVeiculo());
        return dto;
    }
    public static List<AbastecimentoDto> converterListaAbastecimentoDto(List<Abastecimento> abastecimentos){
        List<AbastecimentoDto> dtos = new ArrayList<>();
        abastecimentos.stream().forEach(abastecimento -> {AbastecimentoDto dto = new AbastecimentoDto(abastecimento);
        dtos.add(dto);});
        return dtos;
    }

    public static List<Abastecimento> converterListaAbastecimento(List<AbastecimentoDto> dtos){
        List<Abastecimento> abastecimentos = new ArrayList<>();
        dtos.stream().forEach(abastecimentoDto -> {Abastecimento abastecimento = new Abastecimento(abastecimentoDto);
        abastecimentos.add(abastecimento);});
        return abastecimentos;
    }

}

