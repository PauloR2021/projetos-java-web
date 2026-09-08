/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Record responsável por enviar o JSON de requisição das informações para cadastrar uma nova Cidade</p>
 *
 * @author Paulo Ricardo Soares
 */


package com.pr.software.crud_cidades_thymeleaf.dtos;

public record RequestCidade(
        String nome,
        String estado
) {
}
