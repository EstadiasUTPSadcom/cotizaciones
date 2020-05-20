
package ClassVO;

public class PaqueteVO {
    
    private int id;
    private String descripcion;
    private double suma;
    private double precio;
    //Descuento

    public PaqueteVO(int id, String descripcion, double suma, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.suma = suma;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  id + " " + descripcion + " " + suma + " " + precio;
    }
    
    
         
}
