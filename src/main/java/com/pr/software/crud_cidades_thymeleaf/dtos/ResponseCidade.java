/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Record responsável retornar as informações de uma cidade</p>
 * <p>Retorna a 'ID' de cadastro, nome e estado</p>
 *
 * @author Paulo Ricardo Soares
 */


package com.pr.software.crud_cidades_thymeleaf.dtos;

public record ResponseCidade(
        Long id,
        String nome,
        String estado
) {
}
