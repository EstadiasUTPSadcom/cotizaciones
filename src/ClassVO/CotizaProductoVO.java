
package ClassVO;


public class CotizaProductoVO {
    
    private int idProducto;
    private int idCotizacion;
    private int cantidad;

    public CotizaProductoVO(int idProducto, int idCotizacion, int cantidad) {
        this.idProducto = idProducto;
        this.idCotizacion = idCotizacion;
        this.cantidad = cantidad;
    }

    public CotizaProductoVO() {
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
        return  idProducto + " " + idCotizacion + " " + cantidad;
    }
    
    
}
