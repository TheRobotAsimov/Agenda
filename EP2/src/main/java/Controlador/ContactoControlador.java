package Controlador;

import Modelo.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactoControlador {
    private List<Contacto> contactos;
    private int IdActual;

    public ContactoControlador() {
        this.contactos = new ArrayList<>();
        this.IdActual = 1;
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Inicializar con al menos tres contactos y cada uno con al menos tres teléfonos
        Contacto contacto1 = new Contacto(1, "Juan", "Perez", "juan@example.com", "./src/main/java/Imagenes/gatito.jpg");
        contacto1.agregarTelefono("123456789");
        contacto1.agregarTelefono("987654321");
        contacto1.agregarTelefono("555666777");

        Contacto contacto2 = new Contacto(2, "Maria", "Lopez", "maria@example.com", "./src/main/java/Imagenes/hollowknight.jpg");
        contacto2.agregarTelefono("222333444");
        contacto2.agregarTelefono("111222333");
        contacto2.agregarTelefono("333444555");

        Contacto contacto3 = new Contacto(3, "Carlos", "Sanchez", "carlos@example.com", "./src/main/java/Imagenes/zorro.jpg");
        contacto3.agregarTelefono("444555666");
        contacto3.agregarTelefono("666777888");
        contacto3.agregarTelefono("888999000");

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
    }

    // Métodos para agregar, buscar, eliminar y modificar contactos
    public void agregarContacto(int id, String nombre, String apellido, String correo, String foto, String tel1, String tel2, String tel3) {
        
        Contacto nuevoContacto = new Contacto(id, nombre, apellido, correo, foto);
        
        if(!tel1.isEmpty())
            nuevoContacto.agregarTelefono(tel1);
        if(!tel2.isEmpty())
            nuevoContacto.agregarTelefono(tel2);
        if(!tel3.isEmpty())
            nuevoContacto.agregarTelefono(tel3);
        
        contactos.add(nuevoContacto);
    }
    
    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
    
    public void modificarContacto(int id, String nombre, String apellido, String email, String foto, List<String> telefonos) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                contacto.setNombre(nombre);
                contacto.setApellido(apellido);
                contacto.setEmail(email);
                contacto.setFoto(foto);
                contacto.setTelefonos(telefonos);
                break;
            }
        }
    }
    
    public int siguienteId() {
        return IdActual++;
    }
    
    // Validaciones y búsquedas

    public List<Contacto> buscarContactoPorNombre(String nombre) {
        return contactos.stream()
                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
    
    public List<Contacto> buscarContactoPorApellido(String apellido) {
        return contactos.stream()
                .filter(contacto -> contacto.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }
    
    public Contacto buscarContactoPorCorreo(String correo) {
        for (Contacto contacto : contactos) {
            if (contacto.getEmail().equals(correo)) {
                return contacto;
            }
        }
        return null;
    }
    
    public Contacto buscarContactoPorTelefono(String telefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getTelefonos().contains(telefono)) {
                return contacto;
            }
        }
        return null;
    }
    
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public int getIdActual() {
        return IdActual;
    }

    public void setIdActual(int IdActual) {
        this.IdActual = IdActual;
    }
}
