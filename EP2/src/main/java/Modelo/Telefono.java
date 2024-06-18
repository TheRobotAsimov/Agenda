package Modelo;

public class Telefono {
    private String numero;
    private String compania;

    public Telefono(String numero, String compania) {
        this.numero = numero;
        this.compania = compania;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
    
}
