/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Classe responsável faz a gestão de alguns tratamento de SQL dentro do banco de dados </p>
 * <p>Faz os Selects formatados, para não tratar diretamente no Service</p>
 *
 * @author Paulo Ricardo Soares
 */

package com.pr.software.crud_cidades_thymeleaf.repository;

import com.pr.software.crud_cidades_thymeleaf.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
