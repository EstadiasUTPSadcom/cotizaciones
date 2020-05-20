
package ClassVO;


public class UsuarioVO {
    
    private String usr;
    private String pass;

    public UsuarioVO(String usr, String pass) {
        this.usr = usr;
        this.pass = pass;
    }

    public UsuarioVO() {
    }
    

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
