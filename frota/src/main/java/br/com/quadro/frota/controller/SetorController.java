package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.SetorDto;
import br.com.quadro.frota.entidades.Setor;
import br.com.quadro.frota.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public List<SetorDto> setorList() {
        List<Setor> setor = setorRepository.findAll();
        return SetorDto.converterListaSetorDto(setor);
    }

    @GetMapping("/{id}")
    public SetorDto findById(@PathVariable Long id) {
        Optional<Setor> setor = setorRepository.findById(id);
        if (setor.isPresent()) {
            return SetorDto.converterSetorParaSetorDto(setor.get());
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        setorRepository.deleteById(id);
    }

    @PostMapping
    public SetorDto save(@RequestBody SetorDto dto) {
        Setor setor = SetorDto.converterSetorDtoParaSetor(dto);
        setor = setorRepository.save(setor);
        return SetorDto.converterSetorParaSetorDto(setor);
    }

    @PutMapping("/{id}")
    public SetorDto atualizar(@PathVariable Long id, @RequestBody SetorDto dto) {
        Setor setor = SetorDto.converterSetorDtoParaSetor(dto);

        setor.setNome(dto.getNome());

        setor.setId(id);
        setorRepository.save(setor);
        return SetorDto.converterSetorParaSetorDto(setor);
    }
}
