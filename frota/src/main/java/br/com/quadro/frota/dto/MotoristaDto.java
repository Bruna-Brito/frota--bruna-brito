package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Motorista;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDto {
    private Long id;
    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private String matricula;

    public MotoristaDto() {
    }
    public MotoristaDto(Motorista motorista) {
        this.id = motorista.getId();
        this.nome = motorista.getNome();
        this.matricula = motorista.getMatricula();
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

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static Motorista converterMotoristaDtoParaMotorista(MotoristaDto dto){
        Motorista motorista = new Motorista();
        motorista.setId(dto.getId());
        motorista.setNome(dto.getNome());
        motorista.setMatricula(dto.getMatricula());
        return motorista;
    }

    public static MotoristaDto converterMotoristaParaMotoristaDto(Motorista motorista){
        MotoristaDto dto = new MotoristaDto();
        dto.setId(motorista.getId());
        dto.setNome(motorista.getNome());
        dto.setMatricula(motorista.getMatricula());
        return dto;
    }

    public static List<MotoristaDto> coverterListaMotoristaDto(List<Motorista> motoristas){
        List<MotoristaDto> dtos = new ArrayList<>();
        motoristas.stream().forEach(motorista -> {MotoristaDto dto = new MotoristaDto(motorista);
        dtos.add(dto);
        });
        return dtos;
    }
    public static List<Motorista> converterListaMotorista(List<MotoristaDto> dtos){
        List<Motorista> motoristas = new ArrayList<>();
        dtos.stream().forEach(motoristaDto -> {Motorista motorista = new Motorista(motoristaDto);
        motoristas.add(motorista);});
        return motoristas;
    }
}
