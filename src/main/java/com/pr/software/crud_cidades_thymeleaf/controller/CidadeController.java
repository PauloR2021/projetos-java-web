/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * Controller responsável por receber e tratar as requisições HTTP
 * relacionadas às operações de Cidade.
 *
 * <p>Fornece endpoints para cadastro, alteração, listagem
 * e exclusão de cidades.</p>
 *
 * @author Paulo Ricardo Soares
 */


package com.pr.software.crud_cidades_thymeleaf.controller;
import com.pr.software.crud_cidades_thymeleaf.dtos.RequestCidade;
import com.pr.software.crud_cidades_thymeleaf.service.CidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CidadeController {
    private final CidadeService  cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    //Endpoint para criar cidades
    @PostMapping("/cidades")
    public String salvar(@ModelAttribute RequestCidade requestCidade,
                         RedirectAttributes redirectAttributes)
    {
        cidadeService.salvaCidade(requestCidade);

        //Redireciona a mensagem se a cidade foi cadastrada com sucesso
        redirectAttributes.addFlashAttribute(
                "mensagem",
                "Cidade cadastrada com sucesso!"
        );

        //Redireciona a página para a Home quando a cidade é cadastrada
        return "redirect:/";

    }

}
