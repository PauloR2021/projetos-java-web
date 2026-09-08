/**
 * Linguagem: Java 25
 * IDE: IntelliJ IDEA
 * <p>Classe responsável por gerir os Endpoints para o utilizador.</p>
 * <p>Vai armazenar os endpoints que redireciona as páginas HTML</p>
 * @author Paulo Ricardo Soares
 */

package com.pr.software.crud_cidades_thymeleaf.visaoController;
import com.pr.software.crud_cidades_thymeleaf.dtos.ResponseCidade;
import com.pr.software.crud_cidades_thymeleaf.service.CidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CidadeVisaoController {

    private final CidadeService cidadeService;;

    public CidadeVisaoController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    //Endpoint de Index, para chamar o HTML da página principal
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");

        //Através do Thymeleaf já consigo chamar a lista de cidades e mostrar no Index
        mv.addObject("cidades", cidadeService.listarTodos());
        return mv;
    }

    //Endpoint para ser redirecionado ao HTML de editar
    @GetMapping("/cidades/editar/{id}")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("alterar_cidade"); //Chama a página de Editar

        ResponseCidade cidade = cidadeService.buscarPorId(id); //Passa para o Service qual é o 'ID' para Editar

        mv.addObject("cidade", cidade); //Retornar a Cidade com o 'ID'
        return mv;
    }

}
