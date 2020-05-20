
package ClassVO;

import java.sql.Date;


public class CotizacionVO {
    
    private int id;
    private String descripcion;
    private java.sql.Date fecha;
    private double subtotal;
    private double total;
    private String lugar;
    private boolean comprado;

    public CotizacionVO(int id, String descripcion, Date fecha, double subtotal, double total, String lugar, boolean comprado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.lugar = lugar;
        this.comprado = comprado;
    }

    public CotizacionVO() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Override
    public String toString() {
        return descripcion + " " + total + " " + lugar;
    }
    
    
}
