
package ClassVO;


public class CotizaPaqueteVO {
    
    private int idPaquete;
    private int idCotizacion;
    private int cantidad;

    public CotizaPaqueteVO(int idPaquete, int idCotizacion, int cantidad) {
        this.idPaquete = idPaquete;
        this.idCotizacion = idCotizacion;
        this.cantidad = cantidad;
    }

    public CotizaPaqueteVO() {
    }

    
    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  idPaquete + " " + idCotizacion + " " + cantidad;
    }
    
    
}
