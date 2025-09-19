package com.programagestion;

import com.programagestion.entities.Cliente;
import com.programagestion.igu.Menu;
import com.programagestion.repository.ClienteRepository;
import com.programagestion.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ProgramaGestionApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private LoginServices loginServices;

    public static void main(String[] args) {
        SpringApplication.run(ProgramaGestionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(clienteRepository.count() == 0) {
            clienteRepository.save(Cliente.builder().usuario("Juan").contrasena("1234").build());
        }
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                1. Iniciar sesion
                2. Registrarse
                0. Salir
                """);
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.println("Usuario: ");
                String usuario = sc.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = sc.nextLine();
                Optional<Cliente> usuarioExiste = clienteRepository.findByNombre(usuario);
            }
        }
    }
}
