package com.mycompany.prueba1.apache.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private Boolean activo;
    private String correo;
    private Rol rol;
    
    
    public Usuario(int id, String nombre, String clave, Boolean estado, String correo, Rol rol) {
    this.id = id;
    this.nombre= nombre;
    this.clave= clave;
    this.activo= true;
    this.correo= correo;
    this.rol= rol;
    }
    
    public int getId() { return id;}
    
    public void setId(int id) {this.id = id;}
    
    public String getNombre() { return nombre;}
    
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getClave() { return clave;}
    
    public void setClave(String clave) { this.clave = clave;}
    
    public Boolean isActive() { return this.activo;}
    
    public void setActivo(Boolean activo) { this.activo = activo;}
    
    public String getCorreo() { return correo;}
    
    public void setCorreo(String correo) {this.correo = correo;}
    
    public Rol getRol() { return rol;}
    
    public void setRol(Rol rol) {this.rol = rol;}
}
