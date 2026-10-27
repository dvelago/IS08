package com.ucv.model;

public class Cliente {
    private int id;
    private String dni;
    private String apellidos;
    private String nombres;
    private String email;
    private String celular;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int id, String dni, String apellidos, String nombres, String email, String celular, String direccion) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
    }

    public Cliente(String dni, String apellidos, String nombres, String email, String celular, String direccion) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}