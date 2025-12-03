package com.example.Login.Service;

import com.example.Login.Model.User;
import com.example.Login.Repository.usuarioLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioLoginService {
    @Autowired
    private usuarioLoginRepository repository;
        // public User authenticate(String cpf, String SenhaUser)

}
