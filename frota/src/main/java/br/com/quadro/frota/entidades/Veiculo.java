package br.com.quadro.frota.entidades;

import br.com.quadro.frota.dto.VeiculoDto;

import javax.persistence.*;

@Entity
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    @ManyToOne
    private Fabricante fabricante;
    @ManyToOne
    private Motorista motorista;
    @ManyToOne
    private Combustivel combustivel;
    public Veiculo() {
    }
    public Veiculo(VeiculoDto veiculoDto) {
        this.id = veiculoDto.getId();
        this.placa = veiculoDto.getPlaca();
        this.fabricante = veiculoDto.getFabricante();
        this.combustivel = veiculoDto.getCombustivel();
        this.motorista = veiculoDto.getMotorista();
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
}
