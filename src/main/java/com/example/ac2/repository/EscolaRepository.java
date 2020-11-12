package com.example.ac2.repository;

import java.util.List;
import java.util.Optional;

import com.example.ac2.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    private List <Escola> escolas;
    private int nextCodigo=1;

    public List<Escola> getAllEscolas(){
        return escolas;
    }

    public Optional<Escola> getEscolaByCodigo(int codigo){
        for(Escola aux: escolas){
            if(aux.getCodigo() == codigo){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola save(Escola escola){
        escola.setCodigo(nextCodigo++);
        escolas.add(escola);
        return escola;
    }

    public void remove(Escola escola){
        escolas.remove(escola);
    }

    public Escola update(Escola escola){
        Escola aux = getEscolaByCodigo(escola.getCodigo()).get();

        if(aux != null){
            aux.setEndereco(escola.getEndereco());
            aux.setTelefone(escola.getTelefone());
        }
        return aux;
    }
}
