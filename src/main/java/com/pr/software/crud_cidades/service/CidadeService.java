package com.pr.software.crud_cidades.service;

import com.pr.software.crud_cidades.dtos.RequestCidade;
import com.pr.software.crud_cidades.dtos.ResponseCidade;
import com.pr.software.crud_cidades.model.Cidade;
import com.pr.software.crud_cidades.repository.CidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    private final CidadeRepository  cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public ResponseCidade salvar(RequestCidade requestCidade){
        System.out.println(requestCidade);
        Cidade novaCidade = new Cidade();

        novaCidade.setNome(requestCidade.nome());
        novaCidade.setEstado(requestCidade.estado());

        Cidade cidadeSalvar = cidadeRepository.save(novaCidade);

        return toResponseCidade(cidadeSalvar);
    }

    private ResponseCidade toResponseCidade (Cidade cidade){
        return  new ResponseCidade(
                cidade.getId(),
                cidade.getNome(),
                cidade.getEstado()
        );
    }
}
