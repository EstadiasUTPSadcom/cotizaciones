
package ClassVO;

public class EmpaquetadoVO {
    private int idProducto;
    private int idPaquete;

    public EmpaquetadoVO(int idProducto, int idPaquete) {
        this.idProducto = idProducto;
        this.idPaquete = idPaquete;
    }

    public EmpaquetadoVO() {
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public String toString() {
        return  idProducto + " " + idPaquete;
    }
    
    
}
