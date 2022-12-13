
package farmacia.modelo.bean;

import java.sql.Date;

public class ventaProducto {
    
    private int IDVENTAPRODUCTO;
    private int IDPRODUCTO;
    private int CANTIDAD;
    private float TOTALMONETARIO;
    private int IDUSUARIO;
    private Date FECHA;

    public ventaProducto(int IDVENTAPRODUCTO, int IDPRODUCTO, int CANTIDAD, float TOTALMONETARIO, int IDUSUARIO, Date FECHA) {
        this.IDVENTAPRODUCTO = IDVENTAPRODUCTO;
        this.IDPRODUCTO = IDPRODUCTO;
        this.CANTIDAD = CANTIDAD;
        this.TOTALMONETARIO = TOTALMONETARIO;
        this.IDUSUARIO = IDUSUARIO;
        this.FECHA = FECHA;
    }

    public ventaProducto() {
    }

    public int getIDVENTAPRODUCTO() {
        return IDVENTAPRODUCTO;
    }

    public void setIDVENTAPRODUCTO(int IDVENTAPRODUCTO) {
        this.IDVENTAPRODUCTO = IDVENTAPRODUCTO;
    }

    public int getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(int IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
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

    public int getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(int IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

}
