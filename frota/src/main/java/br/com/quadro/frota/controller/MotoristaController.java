package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.MotoristaDto;
import br.com.quadro.frota.entidades.Motorista;
import br.com.quadro.frota.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping
    public List<MotoristaDto> findAll(){
        List<Motorista> motoristas = motoristaRepository.findAll();
        return MotoristaDto.coverterListaMotoristaDto(motoristas);
    }

    @GetMapping("/{id}")
    public MotoristaDto findById(@PathVariable Long id){
        Motorista motorista = motoristaRepository.findById(id).orElse(null);
        return MotoristaDto.converterMotoristaParaMotoristaDto(motorista);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){motoristaRepository.deleteById(id);}

    @PostMapping
    public MotoristaDto save(@RequestBody MotoristaDto dto){
        Motorista motorista = MotoristaDto.converterMotoristaDtoParaMotorista(dto);
        motorista = motoristaRepository.save(motorista);
        return MotoristaDto.converterMotoristaParaMotoristaDto(motorista);}

    @PutMapping("/{id}")
    public MotoristaDto atualizar(@PathVariable Long id, @RequestBody MotoristaDto dto){
        Motorista motorista = MotoristaDto.converterMotoristaDtoParaMotorista(dto);
        motorista.setId(id);
        motoristaRepository.save(motorista);
        return MotoristaDto.converterMotoristaParaMotoristaDto(motorista);
    }
}
