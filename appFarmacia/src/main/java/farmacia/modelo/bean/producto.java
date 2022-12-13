package farmacia.modelo.bean;

import java.sql.Blob;

public class producto {

    private int IDPRODUCTO;
    private String NOMBRE;
    private int CANTIDAD;
    private float PRECIO_VENTA;
    private float PRECIO_COMPRA;

    public producto(int IDPRODUCTO, String NOMBRE, int CANTIDAD, float PRECIO_VENTA, float PRECIO_COMPRA) {
        this.IDPRODUCTO = IDPRODUCTO;
        this.NOMBRE = NOMBRE;
        this.CANTIDAD = CANTIDAD;
        this.PRECIO_VENTA = PRECIO_VENTA;
        this.PRECIO_COMPRA = PRECIO_COMPRA;
    }

    public producto() {
    }

    public int getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(int IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public float getPRECIO_VENTA() {
        return PRECIO_VENTA;
    }

    public void setPRECIO_VENTA(float PRECIO_VENTA) {
        this.PRECIO_VENTA = PRECIO_VENTA;
    }

    public float getPRECIO_COMPRA() {
        return PRECIO_COMPRA;
    }

    public void setPRECIO_COMPRA(float PRECIO_COMPRA) {
        this.PRECIO_COMPRA = PRECIO_COMPRA;
    }

}
