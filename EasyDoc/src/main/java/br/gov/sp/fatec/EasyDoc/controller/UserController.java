package br.gov.sp.fatec.EasyDoc.controller;

import br.gov.sp.fatec.EasyDoc.model.User;
import br.gov.sp.fatec.EasyDoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository ur;

    // PÁGINA INICIAL

    @GetMapping("/home")
    public String home() {
        System.out.println("Página Inicial");
        return "home";
    }

    // CADASTRAR NOVOS USUÁRIOS

    @GetMapping("/cadastro")
    public String cadastrar(Model model) {
        System.out.println("Página de cadastro");
        model.addAttribute("user", new User());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute User user) {
        ur.save(user);
        System.out.println("Novo Usuário Salvo");
        return "redirect:/user/cadastro";
    }

    // FAZER LOGIN DE USUARIOS

    @GetMapping("/login")
    public String login() {
        System.out.println("Página de Login");
        return "login";
    }

    @PostMapping("/login")
    public String verificarLogin(@RequestParam String email,
                                 @RequestParam String senha,
                                 Model model) {

        User user = ur.findByEmail(email).orElse(null);

        if (user != null && user.getSenha().equals(senha)) {
            model.addAttribute("userLogado", user);
            System.out.println("Usuáiro Logado com Sucesso");
            return "redirect:/home";
        } else {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            System.out.println("Erro ao Executar o Login");
            return "login";
        }
    }
}