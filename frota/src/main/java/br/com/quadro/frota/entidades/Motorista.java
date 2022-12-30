package br.com.quadro.frota.entidades;

import br.com.quadro.frota.dto.MotoristaDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Motorista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    public Motorista() {
    }
    public Motorista(MotoristaDto motoristaDto) {
        this.id = motoristaDto.getId();
        this.nome = motoristaDto.getNome();
        this.matricula = motoristaDto.getMatricula();
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
}
