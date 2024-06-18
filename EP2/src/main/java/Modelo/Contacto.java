package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String foto;
    private List<Telefono> listaTel;

    public Contacto(int id, String nombre, String apellido, String email, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.foto = foto;
        this.listaTel = new ArrayList<>();
    }

    public void agregarTel(Telefono tel){
        this.listaTel.add(tel);
    }
    
    public void eliminarTel(Telefono tel){
        this.listaTel.remove(tel);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Telefono> getListaTel() {
        return listaTel;
    }

    public void setListaTel(List<Telefono> listaTel) {
        this.listaTel = listaTel;
    }
    
}
