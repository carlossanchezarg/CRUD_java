/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Carlos
 */
public class alumnos {
    private int idalumno;
    private String nombre;
    private String apellido;
    private String email;

    public alumnos(int idalumno, String nombre, String apellido, String email) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }


    
    public int getId() {
        return idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }



}
