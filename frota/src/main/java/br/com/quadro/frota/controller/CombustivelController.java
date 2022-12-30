package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.AbastecimentoDto;
import br.com.quadro.frota.dto.CombustivelDto;
import br.com.quadro.frota.entidades.Combustivel;
import br.com.quadro.frota.repository.CombustivelRepository;
import br.com.quadro.frota.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/combustiveis")
public class CombustivelController {
    @Autowired
    private CombustivelRepository combustivelRepository;

    @GetMapping
    public List<CombustivelDto> findAll(CombustivelDto combustivelsDto) {
        List<Combustivel> combustivel = combustivelRepository.findAll();
        return CombustivelDto.converterListaCombustivelDto(combustivel);
    }

    @GetMapping("/{id}")
    public CombustivelDto findById(@PathVariable Long id) {
        Combustivel combustivel = combustivelRepository.findById(id).orElse(null);
        return CombustivelDto.converterCombustivelParaCombustivelDto(combustivel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        combustivelRepository.deleteById(id);
    }

    @PostMapping
    public CombustivelDto save(@RequestBody @Validated CombustivelDto dto) {
        Combustivel combustivel = CombustivelDto.converterCombustivelDtoParaCombustivel(dto);
        combustivel = combustivelRepository.save(combustivel);
        return CombustivelDto.converterCombustivelParaCombustivelDto(combustivel);
    }

    @PutMapping("/{id}")
    public CombustivelDto atualizar(@PathVariable Long id, @RequestBody CombustivelDto dto){
      Combustivel combustivel = CombustivelDto.converterCombustivelDtoParaCombustivel(dto);
      combustivel.setId(id);
      combustivelRepository.save(combustivel);
      return CombustivelDto.converterCombustivelParaCombustivelDto(combustivel);
    }

}
