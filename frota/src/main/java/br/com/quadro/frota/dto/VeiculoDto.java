package br.com.quadro.frota.dto;

import br.com.quadro.frota.entidades.Combustivel;
import br.com.quadro.frota.entidades.Fabricante;
import br.com.quadro.frota.entidades.Motorista;
import br.com.quadro.frota.entidades.Veiculo;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String placa;
    private Fabricante fabricante;
    private Motorista motorista;
    private Combustivel combustivel;

    public VeiculoDto() {
    }

    public VeiculoDto(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.fabricante = veiculo.getFabricante();
        this.motorista = veiculo.getMotorista();
        this.combustivel = veiculo.getCombustivel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Motorista getMotorista() {
        return motorista;
    }
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }


    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public static Veiculo converterVeiculoDtoParaVeiculo(VeiculoDto dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(dto.getId());
        veiculo.setCombustivel(dto.getCombustivel());
        veiculo.setFabricante(dto.getFabricante());
        veiculo.setMotorista(dto.getMotorista());
        veiculo.setPlaca(dto.getPlaca());
        return veiculo;
    }

    public static VeiculoDto converterVeiculoParaVeiculoDto(Veiculo veiculo) {
        VeiculoDto dto = new VeiculoDto();
        dto.setId(veiculo.getId());
        dto.setCombustivel(veiculo.getCombustivel());
        dto.setFabricante(veiculo.getFabricante());
        dto.setMotorista(veiculo.getMotorista());
        dto.setPlaca(veiculo.getPlaca());
        return dto;
    }

    public static List<VeiculoDto> converterListaVeiculoDto(List<Veiculo> veiculos) {
        List<VeiculoDto> dtos = new ArrayList<>();
        veiculos.stream().forEach(veiculo -> {
            VeiculoDto dto = new VeiculoDto(veiculo);
            dtos.add(dto);
        });
        return dtos;
    }

    public static List<Veiculo> converterListaVeiculo(List<VeiculoDto> dtos) {
        List<Veiculo> veiculos = new ArrayList<>();
        dtos.stream().forEach(veiculoDto -> {
            Veiculo veiculo = new Veiculo(veiculoDto);
            veiculos.add(veiculo);
        });
        return veiculos;
    }
}
