package br.gov.sp.fatec.EasyDoc.service;

import br.gov.sp.fatec.EasyDoc.model.User;
import br.gov.sp.fatec.EasyDoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public Optional<User> findByEmail(String email) {
        return ur.findByEmail(email);
    }
}
