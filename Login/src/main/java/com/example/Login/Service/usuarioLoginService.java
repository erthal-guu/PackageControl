package com.example.Login.Service;

import com.example.Login.Model.User;
import com.example.Login.Repository.usuarioLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioLoginService {

    @Autowired
    private usuarioLoginRepository repository;

    public User verificarLogin(String cpf, String senhaUser) {

        User usuario = repository.findByCpf(cpf);

        if (usuario == null) {
            return null;
        }
        if (!usuario.getSenha().equals(senhaUser)) {
            return null;
        }

        return usuario;
    }
}
