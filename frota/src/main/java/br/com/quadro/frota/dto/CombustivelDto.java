package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Combustivel;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class CombustivelDto {
    private Long id;
    @NotEmpty
    private String descricao;

    private Double preco;

    public CombustivelDto(Combustivel combustivel) {
        this.id = combustivel.getId();
        this.descricao = combustivel.getDescricao();
        this.preco = combustivel.getPreco();
    }
    public CombustivelDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public static Combustivel converterCombustivelDtoParaCombustivel(CombustivelDto dto) {
        Combustivel combustivels = new Combustivel();
        combustivels.setId(dto.getId());
        combustivels.setDescricao(dto.getDescricao());
        combustivels.setPreco(dto.getPreco());
        return combustivels;
    }

    public static CombustivelDto converterCombustivelParaCombustivelDto(Combustivel combustivel) {
        CombustivelDto dtos = new CombustivelDto();
        dtos.setId(combustivel.getId());
        dtos.setDescricao(combustivel.getDescricao());
        dtos.setPreco(combustivel.getPreco());
        return dtos;
    }
    public static List<CombustivelDto> converterListaCombustivelDto(List<Combustivel> combustivels){
       List<CombustivelDto> dtos = new ArrayList<>();
       combustivels.stream().forEach(combustivel -> {CombustivelDto dto = new CombustivelDto(combustivel);
         dtos.add(dto);
       });
       return dtos ;
    }
   public static List<Combustivel> converterListaCombustivel(List<CombustivelDto> combustivelDtos){
        List<Combustivel> combustivels = new ArrayList<>();
        combustivelDtos.stream().forEach(combustivelDto -> {Combustivel combustivel = new Combustivel(combustivelDto);
        combustivels.add(combustivel);});
        return combustivels;
   }
}
