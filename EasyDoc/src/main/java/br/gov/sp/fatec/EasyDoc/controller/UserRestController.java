package br.gov.sp.fatec.EasyDoc.controller;

import br.gov.sp.fatec.EasyDoc.model.User;
import br.gov.sp.fatec.EasyDoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository ur;

    // Consultar todos os usuários
    @GetMapping("/consultar")
    public List<User> listar() {
        return ur.findAll();
    }

    // Criar novos usuários
    @PostMapping("/cadastrar")
    public User criar(@RequestBody User user) {
        return ur.save(user);
    }

    // Atualizar dados do usuário
    @PutMapping("/atualizar/{email}")
    public ResponseEntity<User> atualizar(@PathVariable String email, @RequestBody User dados) {
        return ur.findByEmail(email).map(user -> {
            user.setNome(dados.getNome());
            user.setEmail(dados.getEmail());
            user.setSenha(dados.getSenha());

            return ResponseEntity.ok(ur.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Deletar usuários
    @DeleteMapping("/deletar/{email}")
    public ResponseEntity<Void> deletar(@PathVariable String email) {
        return ur.findByEmail(email).<ResponseEntity<Void>>map(user -> {
            ur.delete(user);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // Retorna um texto na página web
    @GetMapping("/teste")
    public String teste() {
        return "API funcionando";
    }
}
