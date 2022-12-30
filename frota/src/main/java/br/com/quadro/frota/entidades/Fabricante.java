package br.com.quadro.frota.entidades;


import br.com.quadro.frota.dto.FabricanteDto;

import javax.persistence.*;

@Entity
public class Fabricante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fipeName;

    public Fabricante() {
    }
    public Fabricante(FabricanteDto fabricanteDto) {
        this.id = fabricanteDto.getId();
        this.name = fabricanteDto.getName();
        this.fipeName = fabricanteDto.getFipeName();
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
}
