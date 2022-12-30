package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.FabricanteDto;
import br.com.quadro.frota.entidades.Fabricante;
import br.com.quadro.frota.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping
    public List<FabricanteDto> fabricanteList() {
        List<Fabricante> fabricante = fabricanteRepository.findAll();
        return FabricanteDto.converterListaFabricanteDto(fabricante);
    }

    @GetMapping("/{id}")
    public FabricanteDto findById(@PathVariable Long id){
        Fabricante fabricante = fabricanteRepository.findById(id).orElse(null);
        return FabricanteDto.converterFabricanteParaFabricanteDto(fabricante);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){ fabricanteRepository.deleteById(id);}

    @PostMapping
    public FabricanteDto save(@RequestBody FabricanteDto dto){
        Fabricante fabricante = FabricanteDto.converterFabricanteDtoParaFabricante(dto);
        fabricante = fabricanteRepository.save(fabricante);
        return FabricanteDto.converterFabricanteParaFabricanteDto(fabricante);
    }

    @PutMapping("/{id}")
    public FabricanteDto atualizar(@PathVariable Long id, @RequestBody FabricanteDto dto) {
        Fabricante fabricante = FabricanteDto.converterFabricanteDtoParaFabricante(dto);
        fabricante.setId(id);
        fabricanteRepository.save(fabricante);
        return FabricanteDto.converterFabricanteParaFabricanteDto(fabricante);
    }
}

