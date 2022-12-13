package farmacia.modelo.bean;

import java.sql.Date;

public class compraProducto {

    private int IDCOMPRAPRODUCTO;
    private int CANTIDAD;
    private float TOTALMONETARIO;
    private Date FECHA;
    private int IDPRODUCTO;

    public compraProducto(int IDCOMPRAPRODUCTO, int CANTIDAD, float TOTALMONETARIO, Date FECHA, int IDPRODUCTO) {
        this.IDCOMPRAPRODUCTO = IDCOMPRAPRODUCTO;
        this.CANTIDAD = CANTIDAD;
        this.TOTALMONETARIO = TOTALMONETARIO;
        this.FECHA = FECHA;
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public compraProducto() {
    }

    public int getIDCOMPRAPRODUCTO() {
        return IDCOMPRAPRODUCTO;
    }

    public void setIDCOMPRAPRODUCTO(int IDCOMPRAPRODUCTO) {
        this.IDCOMPRAPRODUCTO = IDCOMPRAPRODUCTO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public float getTOTALMONETARIO() {
        return TOTALMONETARIO;
    }

    public void setTOTALMONETARIO(float TOTALMONETARIO) {
        this.TOTALMONETARIO = TOTALMONETARIO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public int getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(int IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

}
