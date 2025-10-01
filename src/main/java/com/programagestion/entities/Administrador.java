package com.programagestion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

//Etiqueta de spring jpa, esto el nombre de la clase sea el nombre de la tabla y los atributos sean las columnas de la tabla
@Entity
//etiquetas de lombok, lombok es una libreria que permite acortar codigo resumiendo los getter, setter, tostring, hash, equals en solo @data
@Data
//eso crea el constructor con todos los atributos
@AllArgsConstructor(access = AccessLevel.PUBLIC)
//eso crea el constructor vacio
@NoArgsConstructor
//esto hace que funcione el patron builder
@Builder
//esto define el nivel de acceso de los atrbutos, es lo mismo para los constructores
public class Administrador {
    //clave primaria de la tabla
    @Id
    //tipo de secuencia de la clave primaria, en este caso IDENTITY que se encarga que la clave primaria sea unica
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String usuario;
    String contrasena;
}
