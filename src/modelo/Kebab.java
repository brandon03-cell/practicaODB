package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kebab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipoPan;
    private int cantidad;
    private double precio;
    private boolean tieneCosas;

    public Kebab(String tipoPan, int cantidad, double precio, boolean tieneCosas) {
        this.tipoPan = tipoPan;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tieneCosas = tieneCosas;
    }

    public Kebab(int id, String tipoPan, int cantidad, double precio, boolean tieneCosas) {
        this.id = id;
        this.tipoPan = tipoPan;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tieneCosas = tieneCosas;
    }

    public Kebab() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isTieneCosas() {
        return tieneCosas;
    }

    public void setTieneCosas(boolean tieneCosas) {
        this.tieneCosas = tieneCosas;
    }

    @Override
    public String toString() {
        return "Kebab{" +
                "id=" + id +
                ", tipoPan='" + tipoPan + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", tieneCosas=" + tieneCosas +
                '}';
    }
}
