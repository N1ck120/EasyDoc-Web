package br.gov.sp.fatec.EasyDoc.repository;

import br.gov.sp.fatec.EasyDoc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    Esta interface, repositório, é responsável pelas operações que ocorrem no banco de dados. O Spring Data JPA gera
    automaticamente a implementação dessa interface (criar, ler, atualizar, excluir dados) em tempo de execução.
*/
@Repository
// extends JpaRepository<Usuario = Classe da entidade que está sendo manipulada, Long = Tipo do identificador (chave primária)> = Oferecem mais recursos
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /*
        Herda métodos prontos de:
        - save(Usuario usuario): Salva um novo usuário ou atualiza um existente;
        - findById(Long id): Busca um usuário pelo id;
        - findAll(): Retorna todos os usuários cadastrados;
        - deleteById(Long id): Deleta um usuário pelo id;
     */

    // É possivel adicionar consultas personalizadas
    Usuario buscarUsuarioPorEmail(String email);
}
