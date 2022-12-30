package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Setor;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class SetorDto {

    private Long id;
    @NotEmpty
    @NotNull
    private String nome;

    public SetorDto() {
    }

    public SetorDto(Setor setor) {
        this.id = setor.getId();
        this.nome = setor.getNome();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Setor converterSetorDtoParaSetor(SetorDto dto) {
        Setor setor = new Setor();
        setor.setId(dto.getId());
        setor.setNome(dto.getNome());
        return setor;
    }

    public static SetorDto converterSetorParaSetorDto(Setor setor) {
        SetorDto dto = new SetorDto();
        dto.setId(setor.getId());
        dto.setNome(setor.getNome());
        return dto;
    }

    public static List<SetorDto> converterListaSetorDto(List<Setor> setors) {
        List<SetorDto> dtos = new ArrayList<>();
        setors.stream().forEach(setor -> {
            SetorDto dto = new SetorDto(setor);
            dtos.add(dto);
        });
        return dtos;
    }

    public static List<Setor> converterListaSetor(List<SetorDto> dtos) {
        List<Setor> setors = new ArrayList<>();
        dtos.stream().forEach(setorDto -> {
            Setor setor = new Setor(setorDto);
            setors.add(setor);
        });
        return setors;
    }
}
