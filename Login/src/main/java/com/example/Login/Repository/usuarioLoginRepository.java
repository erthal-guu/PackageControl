package com.example.Login.Repository;

import com.example.Login.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioLoginRepository  extends JpaRepository< User, Long>{
    User findByCpf(String cpf);
    boolean existsByCpf(String cpf);

}
