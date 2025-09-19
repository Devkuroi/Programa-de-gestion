package com.programagestion;

import com.programagestion.igu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.programagestion.igu.Menu.inicioSesion;
import static com.programagestion.igu.Menu.menuprincipal;

@SpringBootApplication
public class ProgramaGestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgramaGestionApplication.class, args);

        menuprincipal();
    }

}
