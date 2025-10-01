package com.programagestion.igu;

import com.programagestion.entities.Cliente;
import com.programagestion.repository.ClienteRepository;
import com.programagestion.services.LoginServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// por el momento no se usa nada de aqui ya que se paso a la clase main aunque se considera pasarlo aqui en clases separadas
public class Menu {
    static List<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private LoginServices loginServices;
    private ClienteRepository clienteRepository;

    public Menu(LoginServices loginServices, ClienteRepository clienteRepository) {
        this.loginServices = loginServices;
        this.clienteRepository = clienteRepository;
    }

    static public void menuprincipal() {
        while (true) {
            System.out.println("* * * ¿QUE DESEAS HACER? * * *");
            System.out.println("1: Iniciar sesion");
            System.out.println("2: Registrarse");
            System.out.println("0: Salir");

            String opcion = sc.nextLine();

            if (opcion.equals("2")) {
                registrarse();
                break;
            }
            if (opcion.equals("0")) {
                System.out.println("Cerrando la aplicacion...");
                break;
            }
            else {
                System.out.println("Opcion no valida.");
            }
        }
    }

    private static void MenuClientes() {
        while (true) {
            System.out.println("* * * MENU CLIENTES * * *");
            System.out.println("1: Ver productos");
            System.out.println("2: Comprar productos");
            System.out.println("0: Salir");
            String opcion = sc.nextLine();

            if(opcion.equals("0")) {
                System.out.println("Cerrando la aplicacion...");
            }
        }

    }

    static public void registrarse() {
        System.out.println("* * * REGISTRATE * * *");
        System.out.println("Usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        Cliente cliente = Cliente.builder().usuario(usuario).contrasena(password).build();
        clientes.add(cliente);
    }
}
