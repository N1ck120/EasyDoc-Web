package br.gov.sp.fatec.EasyDoc.controller;

import br.gov.sp.fatec.EasyDoc.model.Usuario;
import br.gov.sp.fatec.EasyDoc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
    @Controller
    Indica que esta classe é um controller da URL na web para redirecionar
    o usuário para as páginas existentes
*/
@Controller
public class HomeController {

    /*
        @Autowired
        Indica que o Service deve ser injetado automaticamente na variável usuarioService
    */
    @Autowired
    private UsuarioService usuarioService;

    /*
        @GetMapping
        Idica para qual página HTML redirecionar de acordo com a URL
    */
    @GetMapping("/")
    public String home() {
        System.out.println("Página home");
        return "index";
    }

    //Cadastro de Usuários
    @GetMapping("/cadastro")
    public String cadastro() {
        System.out.println("Página cadastro");
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public void salvarUsuario(Usuario usuario, Model model) {
        usuarioService.salvarUsuario(usuario);
        model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Página login");
        return "login";
    }
}