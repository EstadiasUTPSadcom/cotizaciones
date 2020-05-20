
package ClassVO;


public class SubcategoriaVO {
    
    private int id;
    private int idCategoria;
    private String nombre;

    public SubcategoriaVO(int id, int idCategoria, String nombre) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public SubcategoriaVO() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
