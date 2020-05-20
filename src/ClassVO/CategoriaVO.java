package ClassVO;

public class CategoriaVO {

    private int id;
    private String nombre;

    public CategoriaVO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaVO() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
