package com.mycompany.prueba1.apache.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private Boolean activo;
    
    public Usuario(int id, String nombre, String clave, Boolean estado) {
    this.id = id;
    this.nombre= nombre;
    this.clave= clave;
    this.activo= true;
    }
    
    public int getId() { return id;}
    
    public void setId(int id) {this.id = id;}
    
    public String getNombre() { return nombre;}
    
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getClave() { return clave;}
    
    public void setClave(String clave) { this.clave = clave;}
    
    public Boolean isActive() { return this.activo;}
    
    public void setActivo(Boolean activo) { this.activo = activo;}
}
