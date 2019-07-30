package com.knoxcorporation.knxbank.Entidades;



public class Cliente {
    private Integer ID,DNI,cuentaBancaria,Edad,Clave;
    private String Nombre,Apellidos;

    public Cliente(Integer ID, Integer DNI, Integer cuentaBancaria, Integer edad, Integer clave, String nombre, String apellidos) {
        this.ID = ID;
        this.DNI = DNI;
        this.cuentaBancaria = cuentaBancaria;
        Edad = edad;
        Clave = clave;
        Nombre = nombre;
        Apellidos = apellidos;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public Integer getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(Integer cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public Integer getClave() {
        return Clave;
    }

    public void setClave(Integer clave) {
        Clave = clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
}
