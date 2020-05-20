
package ClassVO;

import java.awt.Image;

public class ProductoVO {
    
   private int id;
   private String descripcion;
   private double precio;
   private byte[] imagen;
   private int idSubcategoria;

    public ProductoVO(int id, String descripcion, double precio, byte[] imagen, int idSubcategoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.idSubcategoria = idSubcategoria;
    }
    
    public ProductoVO() {
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return  id + " " + descripcion + " " + precio;
    }
   
   
}
