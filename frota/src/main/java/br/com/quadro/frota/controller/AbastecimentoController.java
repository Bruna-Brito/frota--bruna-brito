package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.AbastecimentoDto;
import br.com.quadro.frota.dto.CombustivelDto;
import br.com.quadro.frota.entidades.Abastecimento;
import br.com.quadro.frota.entidades.Combustivel;
import br.com.quadro.frota.entidades.Veiculo;
import br.com.quadro.frota.repository.AbastecimentoRepository;
import br.com.quadro.frota.repository.CombustivelRepository;
import br.com.quadro.frota.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {
    @Autowired
    private AbastecimentoRepository abastecimentoRepository;
    @Autowired
    private CombustivelRepository combustivelRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<AbastecimentoDto> findAll(AbastecimentoDto abastecimentosDto) {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();
        return AbastecimentoDto.converterListaAbastecimentoDto(abastecimentos);
    }

    @GetMapping("/{id}")
    public AbastecimentoDto findById(@PathVariable Long id) {
        Abastecimento abastecimento = abastecimentoRepository.findById(id).orElse(null);
        return AbastecimentoDto.converterAbastecimentoParaAbastecimentoDto(abastecimento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        abastecimentoRepository.deleteById(id);
    }

    @PostMapping
    public AbastecimentoDto save(@RequestBody @Validated AbastecimentoDto dto) {
        Combustivel combustivel = combustivelRepository.findById(dto.getCombustivel().getId()).orElse(null);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculo().getId()).orElse(null);

        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setCombustivel(combustivel);
        abastecimento.setVeiculo(veiculo);
        abastecimento.setValor(dto.getValor());
        abastecimento.setLocalDate(dto.getLocalDate());
        abastecimento = abastecimentoRepository.save(abastecimento);
        return AbastecimentoDto.converterAbastecimentoParaAbastecimentoDto(abastecimento);
    }
    @PutMapping("/{id}")
    public AbastecimentoDto atualizar(@PathVariable Long id, @RequestBody AbastecimentoDto dto){
        Combustivel combustivel = combustivelRepository.findById(dto.getCombustivel().getId()).orElse(null);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculo().getId()).orElse(null);

        Abastecimento abastecimento = AbastecimentoDto.converterAbastecimentoDtoParaAbastecimento(dto);

        abastecimento.setCombustivel(combustivel);
        abastecimento.setVeiculo(veiculo);
        abastecimento.setValor(dto.getValor());
        abastecimento.setLocalDate(dto.getLocalDate());

        abastecimento.setId(id);
        abastecimentoRepository.save(abastecimento);
        return AbastecimentoDto.converterAbastecimentoParaAbastecimentoDto(abastecimento);
    }
}
