package com.example.cp3_java.service;

import com.example.cp3_java.DTO.BrinquedoDTO;
import com.example.cp3_java.exception.BrinquedoNotFoundException;
import com.example.cp3_java.model.Brinquedo;
import com.example.cp3_java.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    @Autowired
    BrinquedoRepository brinquedoRepository;

    public Brinquedo adicionarBrinquedo(BrinquedoDTO dto){
        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setNome(dto.getNome());
        brinquedo.setTipo(dto.getTipo());
        brinquedo.setClassificacao(dto.getClassificacao());
        brinquedo.setTamanho(dto.getTamanho());
        brinquedo.setPreco(dto.getPreco());
        return brinquedoRepository.save(brinquedo);
    }

    public Optional<Brinquedo> retornarPorId(Long id){
        return brinquedoRepository.findById(id);
    }

    public List<Brinquedo> retornarTodos(){
        return brinquedoRepository.findAll();
    }

    public Brinquedo atualizarBrinquedoPorId(Long id, BrinquedoDTO brinquedoNovo)
            throws BrinquedoNotFoundException {

        Brinquedo brinquedo = brinquedoRepository.findById(id)
                .orElseThrow(() -> new BrinquedoNotFoundException(id));

        brinquedo.setClassificacao(brinquedoNovo.getClassificacao());
        brinquedo.setNome(brinquedoNovo.getNome());
        brinquedo.setPreco(brinquedoNovo.getPreco());
        brinquedo.setTamanho(brinquedoNovo.getTamanho());
        brinquedo.setTipo(brinquedoNovo.getTipo());

        return brinquedoRepository.save(brinquedo);
    }

    public void deletarBrinquedoPorId(Long id) throws BrinquedoNotFoundException {
        Optional<Brinquedo> brinquedoExistente = brinquedoRepository.findById(id);
        if (brinquedoExistente.isPresent()){
            brinquedoRepository.deleteById(id);
        }else {
            throw new BrinquedoNotFoundException(id);
        }
    }
}
