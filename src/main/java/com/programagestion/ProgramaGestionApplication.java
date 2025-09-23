package com.programagestion;

import com.programagestion.entities.Cliente;
import com.programagestion.entities.Producto;
import com.programagestion.repository.ClienteRepository;
import com.programagestion.repository.ProductoRepository;
import com.programagestion.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ProgramaGestionApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private LoginServices loginServices;
    @Autowired
    private ProductoRepository productoRepository;

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
                Optional<Cliente> usuarioExiste = clienteRepository.findByUsuario(usuario);

                if (usuarioExiste.isEmpty()) {
                    System.out.println("Usuario no encontrado");
                    System.out.println("¿Desea registrarse con este nombre de usuario? (s/n): ");
                    String opcionSesion = sc.nextLine();

                    if (opcionSesion.equalsIgnoreCase("s")) {
                        clienteRepository.save(Cliente.builder().usuario(usuario).contrasena(contrasena).build());
                        System.out.println("Usuario registrado");
                    }

                    if (opcionSesion.equalsIgnoreCase("n")) {
                        System.out.println("Intentalo de nuevo con otro usuario");
                    }

                }

                if (!loginServices.login(usuario, contrasena)) {
                    System.out.println("Inicio de sesion exitoso");
                    System.out.println("Bienvenido al sistema");
                    productoRepository.save(Producto.builder().nombre("Manzana roja").descripcion("Manzana roja").precio("2000").build());
                    String[] headers = {"Nombre", "Descripcion", "Precio"};
                    while (true) {
                        System.out.println("""
                                1. Ver productos
                                2. Comprar productos
                                3. Ver carrito
                                4. Dejar productos
                                5. Salir
                                """);

                        String opcionCliente = sc.nextLine();

                        if (opcionCliente.equals("1")) {
                            List<Producto> productos = productoRepository.findAll();

                            if (productos.isEmpty()) {
                                System.out.println("No hay productos");
                            }

                            for (Producto producto : productos) {
                                System.out.println("* * * PRODUCTOS * * *");
                                System.out.printf("| %-10s | %-5s | %-10s |\n", headers[0], headers[1], headers[2]);
                                System.out.printf("| %-10s | %-5s | %-10s |\n", producto.getNombre(), producto.getDescripcion(), producto.getPrecio());
                            }
                        }

                        if (opcionCliente.equals("2")) {
                            
                        }

                        if (opcionCliente.equals("5")) {
                            break;
                        }
                    }
                }
            }

            if (opcion.equals("2")) {
                System.out.println("Usuario: ");
                String usuario = sc.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = sc.nextLine();

                Optional<Cliente> usuarioExiste = clienteRepository.findByUsuario(usuario);
                if (usuarioExiste.isEmpty()) {
                    clienteRepository.save(Cliente.builder().usuario(usuario).contrasena(contrasena).build());
                    System.out.println("Usuario registrado");
                }

                if (usuarioExiste.isPresent()){
                    System.out.println("Usuario ya registrado");
                    System.out.println("Intenta iniciar sesion");
                }
            }

            if (opcion.equals("0")) {
                System.out.println("Cerrado aplicacion...");
                break;
            }
        }
    }
}
