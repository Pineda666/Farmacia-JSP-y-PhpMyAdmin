package farmacia.modelo.bean;

public class usuario {

    private int IDUSUARIO;
    private String NOMBRE;
    private String APEPATERNO;
    private String APEMATERNO;
    private String USUARIO;
    private String PASSWORD;
    private String GMAIL;
    private int IDRANGO;

    public usuario(int IDUSUARIO, String NOMBRE, String APEPATERNO, String APEMATERNO, String USUARIO, String PASSWORD, String GMAIL, int IDRANGO) {
        this.IDUSUARIO = IDUSUARIO;
        this.NOMBRE = NOMBRE;
        this.APEPATERNO = APEPATERNO;
        this.APEMATERNO = APEMATERNO;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
        this.GMAIL = GMAIL;
        this.IDRANGO = IDRANGO;
    }

    public usuario() {
    }

    public int getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(int IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPEPATERNO() {
        return APEPATERNO;
    }

    public void setAPEPATERNO(String APEPATERNO) {
        this.APEPATERNO = APEPATERNO;
    }

    public String getAPEMATERNO() {
        return APEMATERNO;
    }

    public void setAPEMATERNO(String APEMATERNO) {
        this.APEMATERNO = APEMATERNO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getGMAIL() {
        return GMAIL;
    }

    public void setGMAIL(String GMAIL) {
        this.GMAIL = GMAIL;
    }

    public int getIDRANGO() {
        return IDRANGO;
    }

    public void setIDRANGO(int IDRANGO) {
        this.IDRANGO = IDRANGO;
    }

}
