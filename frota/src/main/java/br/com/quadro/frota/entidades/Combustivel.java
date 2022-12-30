package br.com.quadro.frota.entidades;

import br.com.quadro.frota.dto.CombustivelDto;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Combustivel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double preco;

    public Combustivel(){}
    public Combustivel(CombustivelDto combustivelDto) {
        this.id = combustivelDto.getId();
        this.descricao = combustivelDto.getDescricao();
        this.preco = combustivelDto.getPreco();
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

    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}


}

