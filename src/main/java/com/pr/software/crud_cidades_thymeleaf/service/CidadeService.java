/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Classe responsável por validar a regra de negócio do projeto</p>
 * <p>Essa classe faz o tratamento de dados para Salvar, Alterar, Excluir e Listar as cidades do Banco</p>
 *
 * @author Paulo Ricardo Soares
 */

package com.pr.software.crud_cidades_thymeleaf.service;

import com.pr.software.crud_cidades_thymeleaf.dtos.RequestCidade;
import com.pr.software.crud_cidades_thymeleaf.dtos.ResponseCidade;
import com.pr.software.crud_cidades_thymeleaf.model.Cidade;
import com.pr.software.crud_cidades_thymeleaf.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    //Salvando a nova cidade no banco de dados
    public ResponseCidade salvaCidade (RequestCidade requestCidade){
        Cidade cidade = new Cidade();
        cidade.setNome(requestCidade.nome());
        cidade.setEstado(requestCidade.estado());
        Cidade novaCidade = cidadeRepository.save(cidade);
        return toResponseCidade(novaCidade);
    }

    //Listando todas as cidades que tem no banco de dados
    public List<ResponseCidade> listarTodos(){
        return cidadeRepository.
                findAll()
                .stream()
                .map(this::toResponseCidade)
                .toList();
    }

    //Buscando as cidades por 'ID'
    public ResponseCidade buscarPorId(Long id){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        return toResponseCidade(cidade);
    }

    //Editando as cidades
    public ResponseCidade editarCidade(Long id, RequestCidade requestCidade){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        cidade.setNome(requestCidade.nome());
        cidade.setEstado(requestCidade.estado());

        Cidade  atualizarCidade = cidadeRepository.save(cidade);

        return toResponseCidade(atualizarCidade);
    }

    //Excluindo as Cidades
    public void excluirCidade(Long id){
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        cidadeRepository.delete(cidade);
    }


    private ResponseCidade toResponseCidade(Cidade cidade) {
        return new ResponseCidade(cidade.getId(), cidade.getNome(), cidade.getEstado());
    }
}
