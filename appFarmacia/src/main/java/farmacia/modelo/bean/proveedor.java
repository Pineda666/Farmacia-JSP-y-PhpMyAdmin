package farmacia.modelo.bean;

public class proveedor {

    private int IDPROVEEDOR;
    private String NOMBRE;
    private String CODIGO;

    public proveedor(int IDPROVEEDOR, String NOMBRE, String CODIGO) {
        this.IDPROVEEDOR = IDPROVEEDOR;
        this.NOMBRE = NOMBRE;
        this.CODIGO = CODIGO;
    }

    public proveedor() {
    }

    public int getIDPROVEEDOR() {
        return IDPROVEEDOR;
    }

    public void setIDPROVEEDOR(int IDPROVEEDOR) {
        this.IDPROVEEDOR = IDPROVEEDOR;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

}
