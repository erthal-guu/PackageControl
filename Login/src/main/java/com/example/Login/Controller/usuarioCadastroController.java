package com.example.Login.Controller;

import com.example.Login.Model.User;
import com.example.Login.Service.usuarioCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class usuarioCadastroController {
    @Autowired
    private usuarioCadastroService Service;
    @PostMapping("/cadastrar")
    public User cadastrar(@RequestBody User usuario){
        return Service.cadastrar(usuario);
    }


}


