/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Classe responsável por mapear a tabela do banco de dados</p>
 * <p>Faz o mapeamento de como a tabela vai se comportar no banco de dados</p>
 *
 * @author Paulo Ricardo Soares
 */


package com.pr.software.crud_cidades_thymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidades_tb")
@Getter @Setter
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String estado;
}
