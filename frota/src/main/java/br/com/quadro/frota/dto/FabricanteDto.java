package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Fabricante;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class FabricanteDto {

    private Long id;
    @NotEmpty  @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String fipeName;

    public FabricanteDto(){}
    public FabricanteDto(Fabricante fabricante) {
        this.id = fabricante.getId();
        this.name = fabricante.getName();
        this.fipeName = fabricante.getFipeName();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFipeName() {
        return fipeName;
    }
    public void setFipeName(String fipeName) {
        this.fipeName = fipeName;
    }

    public static Fabricante converterFabricanteDtoParaFabricante(FabricanteDto dto){
        Fabricante fabricante = new Fabricante();
        fabricante.setId(dto.getId());
        fabricante.setName(dto.getName());
        fabricante.setFipeName(dto.getFipeName());
        return fabricante;
    }

    public static FabricanteDto converterFabricanteParaFabricanteDto(Fabricante fabricante){
        FabricanteDto dto = new FabricanteDto();
        dto.setId(fabricante.getId());
        dto.setName(fabricante.getName());
        dto.setFipeName(fabricante.getFipeName());
        return dto;
    }

    public static List<FabricanteDto> converterListaFabricanteDto(List<Fabricante> fabricantes){
        List<FabricanteDto> dtos = new ArrayList<>();
        fabricantes.stream().forEach(fabricante -> {FabricanteDto dto = new FabricanteDto(fabricante);
        dtos.add(dto);});
        return dtos;
    }
    public static List<Fabricante> converterListaFabricante(List<FabricanteDto> dtos){
        List<Fabricante>  fabricantes = new ArrayList<>();
        dtos.stream().forEach(fabricanteDto -> {Fabricante fabricante = new Fabricante(fabricanteDto);
        fabricantes.add(fabricante);});
        return fabricantes;
    }

}
