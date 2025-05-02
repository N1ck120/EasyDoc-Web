package br.gov.sp.fatec.EasyDoc.service;

import br.gov.sp.fatec.EasyDoc.model.Usuario;
import br.gov.sp.fatec.EasyDoc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    @Service
    Serve como uma camada intermediária entre o Controller e o Repository. Ele cria a lógica de acesso de dados e a
    manipulação dos usuários em uma única classe.
*/
@Service
public class UsuarioService {

    /*
        @Autowired
        Indica que o Repository deve ser injetado automaticamente na variável usuarioRepository
    */
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Salva um novo usuário
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Busca um usuário pelo e-mail
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.buscarUsuarioPorEmail(email);
    }

    //Excluir usuário
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
