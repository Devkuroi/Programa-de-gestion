package com.programagestion.igu;

import com.programagestion.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static public void menuprincipal() {
        while (true) {
            System.out.println("* * * ¿QUE DESEAS HACER? * * *");
            System.out.println("1: Iniciar sesion");
            System.out.println("2: Registrarse");
            System.out.println("0: Salir");

            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                inicioSesion();
                break;
            }
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
    static public void inicioSesion() {
        while (true) {
            System.out.println("* * * INICIO DE SESION * * *");
            System.out.println("Usuario: ");
            String usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            String password = sc.nextLine();
            if (clientes.isEmpty()) {
                System.out.println("No existe el usuario");
                System.out.println("¿No tienes una cuenta?. Oprime cualquier boton para registrarte");
                sc.nextLine();
                registrarse();
            }
           for (Cliente cliente : clientes) {
               if (cliente.getUsuario().equals(usuario) && cliente.getContrasena().equals(password)) {
                   System.out.println("Todo bien mano");
                   MenuClientes();
                   break;
               } else {
                   System.out.println("No existe el usuario");
                   System.out.println("¿No tienes una cuenta?. Oprime cualquier boton para registrarte");
                   sc.nextLine();
                   registrarse();
               }
               break;
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
