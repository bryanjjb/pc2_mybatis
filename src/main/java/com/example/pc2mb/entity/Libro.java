
package com.example.pc2mb.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {
    private static final long serialVersionUID = 3754851399214200439L;
    private int idlibro;
    private String nombre;
    private int idautor;
    private int ideditorial;
}
