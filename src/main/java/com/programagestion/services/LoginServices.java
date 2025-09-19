package com.programagestion.services;

import com.programagestion.entities.Cliente;
import com.programagestion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean login(String username, String password) {
        return clienteRepository.findByNombre(username).map(usuario -> usuario.equals(password)).orElse(false);
    }


}
