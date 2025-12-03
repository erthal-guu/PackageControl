package com.example.Login.Repository;

import com.example.Login.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCadastroRepository extends JpaRepository<User, Long> {
    boolean existsByCpf(String cpf);
}
