package br.com.quadro.frota.controller;

import br.com.quadro.frota.dto.VeiculoDto;
import br.com.quadro.frota.entidades.*;
import br.com.quadro.frota.repository.CombustivelRepository;
import br.com.quadro.frota.repository.FabricanteRepository;
import br.com.quadro.frota.repository.MotoristaRepository;
import br.com.quadro.frota.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private CombustivelRepository combustivelRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping
    public List<VeiculoDto> findAll(VeiculoDto dto) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return VeiculoDto.converterListaVeiculoDto(veiculos) ;
    }
    @GetMapping("/{id}")
    public VeiculoDto findById(@PathVariable Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
        return VeiculoDto.converterVeiculoParaVeiculoDto(veiculo);

    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }

    @PostMapping
    public VeiculoDto save(@RequestBody @Validated VeiculoDto dto) {

        Fabricante fabricante = fabricanteRepository.findById(dto.getFabricante().getId()).orElse(null);
        Combustivel combustivel = combustivelRepository.findById(dto.getCombustivel().getId()).orElse(null);
        Motorista motorista = motoristaRepository.findById(dto.getMotorista().getId()).orElse(null);

        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante(fabricante);
        veiculo.setMotorista(motorista);
        veiculo.setCombustivel(combustivel);
        veiculo.setPlaca(dto.getPlaca());

        veiculo =  veiculoRepository.save(veiculo);
        return VeiculoDto.converterVeiculoParaVeiculoDto(veiculo);
    }
    @PutMapping("/{id}")
    public VeiculoDto atualizar(@PathVariable Long id, @RequestBody VeiculoDto dto){

        Fabricante fabricante = fabricanteRepository.findById(dto.getFabricante().getId()).orElse(null);
        Combustivel combustivel = combustivelRepository.findById(dto.getCombustivel().getId()).orElse(null);
        Motorista motorista = motoristaRepository.findById(dto.getMotorista().getId()).orElse(null);

        Veiculo veiculo = VeiculoDto.converterVeiculoDtoParaVeiculo(dto);

        veiculo.setPlaca(dto.getPlaca());
        veiculo.setCombustivel(combustivel);
        veiculo.setMotorista(motorista);
        veiculo.setFabricante(fabricante);

        veiculo.setId(id);
        veiculoRepository.save(veiculo);
        return VeiculoDto.converterVeiculoParaVeiculoDto(veiculo);
    }


}
