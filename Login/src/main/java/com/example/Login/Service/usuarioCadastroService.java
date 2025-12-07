package com.example.Login.Service;

import com.example.Login.Model.User;
import com.example.Login.Repository.UsuarioCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioCadastroService {

    @Autowired
    private UsuarioCadastroRepository repository;

    public User cadastrar(User usuario) {
        if (repository.existsByCpf(usuario.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        return repository.save(usuario);
    }
}
