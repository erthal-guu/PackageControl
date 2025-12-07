package com.example.Login.Controller;

import com.example.Login.Model.User;
import com.example.Login.Service.usuarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class usuarioLoginController {

    @Autowired
    private usuarioLoginService service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody User usuario) {

        User userLogado = service.verificarLogin(usuario.getCpf(), usuario.getSenha());

        if (userLogado == null) {
            return ResponseEntity.status(401).body("Login inválido");
        }

        return ResponseEntity.ok(userLogado);
    }
}

