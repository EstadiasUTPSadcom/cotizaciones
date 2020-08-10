
package ClassVO;

public class PaqueteVO {
    
     private int id;
     private String descripcion;
     private double suma;
     private int descuento;
     private double precio;

    public PaqueteVO(int id, String descripcion, double suma, int descuento, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.suma = suma;
        this.descuento = descuento;
        this.precio = precio;
    }

    public PaqueteVO() {
    }

     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return id + " " + descripcion + " " + precio;
    }
     
    
    
         
}
