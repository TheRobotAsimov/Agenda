package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String foto;
    private List<String> telefonos;

    public Contacto(int id, String nombre, String apellido, String email, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.foto = foto;
        this.telefonos = new ArrayList<>();
    }
    
    public void agregarTelefono(String telefono) {
        this.telefonos.add(telefono);
    }

    public void eliminarTelefono(String telefono) {
        this.telefonos.remove(telefono);
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

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }
    
}
