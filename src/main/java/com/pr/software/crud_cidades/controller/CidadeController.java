package com.pr.software.crud_cidades.controller;

import com.pr.software.crud_cidades.dtos.RequestCidade;
import com.pr.software.crud_cidades.dtos.ResponseCidade;
import com.pr.software.crud_cidades.service.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController (CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @PostMapping("/cidades")
    public String salvar ( RequestCidade novaCidade) {
        cidadeService.salvar(novaCidade);

        return "redirect:/?sucesso=true";
    }
}
