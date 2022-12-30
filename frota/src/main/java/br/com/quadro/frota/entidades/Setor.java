package br.com.quadro.frota.entidades;

import br.com.quadro.frota.dto.SetorDto;

import javax.persistence.*;

@Entity
public class Setor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    public Setor() {
    }
    public Setor(SetorDto setorDto) {
        this.id = setorDto.getId();
        this.nome = setorDto.getNome();
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
}

