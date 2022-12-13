package farmaciaControlador;

import farmacia.modelo.DAO.compraProductoDAO;
import farmacia.modelo.DAO.productoDAO;
import farmacia.modelo.DAO.ventaProductoDAO;
import farmacia.modelo.bean.compraProducto;
import farmacia.modelo.bean.producto;
import farmacia.modelo.bean.ventaProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletProducto", urlPatterns = {"/servletProducto", "/listarProductos", "/editarProducto", 
    "/grabarProducto", "/eliminarProducto", "/nuevoProducto", "/listarProductosCliente", "/mostrarDatos", 
    "/agregarTransaccion", "/listarCompras", "/editarCompras", "/grabarCompras", "/eliminarCompras", "/listarFacturas", "/listarTransacciones"})
public class servletProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String path = request.getServletPath();

            if (path.equals("/listarProductos")) {
                request.setAttribute("productos", productoDAO.listar());
                request.getRequestDispatcher("/WEB-INF/productos.jsp").forward(request, response);
            }

            if (path.equals("/editarProducto")) {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("producto", productoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF/formularioProducto.jsp").forward(request, response);
            }

            if (path.equals("/grabarProducto")) {

                int id = Integer.parseInt(request.getParameter("IDPRODUCTO"));
                String NOMBRE = request.getParameter("NOMBRE");
                int CANTIDAD = Integer.parseInt(request.getParameter("CANTIDAD"));
                float PRECIO_VENTA = Float.parseFloat(request.getParameter("PRECIO_VENTA"));
                float PRECIO_COMPRA = Float.parseFloat(request.getParameter("PRECIO_COMPRA"));
                
                Date date = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                String fechastring = formato.format(date);
                java.sql.Date fechahoy = java.sql.Date.valueOf(fechastring);
                

                producto product = new producto();
                product.setNOMBRE(NOMBRE);
                product.setCANTIDAD(CANTIDAD);
                product.setPRECIO_VENTA(PRECIO_VENTA);
                product.setPRECIO_COMPRA(PRECIO_COMPRA);

                compraProducto compraP = new compraProducto();

                if (id > 0) {
                    product.setIDPRODUCTO(id);
                    producto product2 = productoDAO.buscar(id);
                    
                    int diferencia = CANTIDAD - product2.getCANTIDAD();
                    
                    float totalpago = PRECIO_COMPRA * (float)diferencia;
                    
                    compraP.setCANTIDAD(diferencia);
                    compraP.setTOTALMONETARIO(totalpago);
                    compraP.setFECHA(fechahoy);
                    compraP.setIDPRODUCTO(id);
                    
                    compraProductoDAO.agregar(compraP);
                    
                    productoDAO.editar(product);
                    
                } else {
                    
                    productoDAO.insertar(product);
                    
                    ArrayList<producto> productos = productoDAO.listar();
                    
                    producto pro = productos.get(productos.size() - 1);
                    
                    float totalpago = pro.getPRECIO_COMPRA() * pro.getCANTIDAD();
                    
                    compraP.setCANTIDAD(pro.getCANTIDAD());
                    compraP.setTOTALMONETARIO(totalpago);
                    compraP.setFECHA(fechahoy);
                    compraP.setIDPRODUCTO(pro.getIDPRODUCTO());
                    
                    compraProductoDAO.agregar(compraP);
                    
                }

                response.sendRedirect("listarProductos");

            }

            if (path.equals("/eliminarProducto")) {
                int id = Integer.parseInt(request.getParameter("id"));
                productoDAO.eliminar(id);
                response.sendRedirect("listarProductos");
            }

            if (path.equals("/nuevoProducto")) {
                request.setAttribute("producto", new producto());
                request.getRequestDispatcher("/WEB-INF/formularioProducto.jsp").forward(request, response);
            }

            //------------------------
            if (path.equals("/listarProductosCliente")) {
                request.setAttribute("productos", productoDAO.listar());
                request.getRequestDispatcher("/WEB-INF-CLIENTE/productosCliente.jsp").forward(request, response);
            }

            if (path.equals("/mostrarDatos")) {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("producto", productoDAO.buscar(id));
                request.getRequestDispatcher("/WEB-INF-CLIENTE/datosTransaccion.jsp").forward(request, response);
            }

            if (path.equals("/agregarTransaccion")) {
                int idPro = Integer.parseInt(request.getParameter("IDPRODUCTO"));
                int iduser = Integer.parseInt(request.getParameter("idUser"));
                int cant = Integer.parseInt(request.getParameter("cantidadComprar"));
                float precio = Float.parseFloat(request.getParameter("precio"));
                String fechastring = request.getParameter("fecha");

                java.sql.Date fechahoy = java.sql.Date.valueOf(fechastring);

                float pago = precio * (float) cant;

                ventaProducto proV = new ventaProducto();
                proV.setIDPRODUCTO(idPro);
                proV.setCANTIDAD(cant);
                proV.setTOTALMONETARIO(pago);
                proV.setIDUSUARIO(iduser);
                proV.setFECHA(fechahoy);

                //MODIFICAR STOCK PRODUCTO
                int cantidadTotal = Integer.parseInt(request.getParameter("cantidad"));
                int cantidadRestante = cantidadTotal - cant;
                productoDAO.modificarCantidad(idPro, cantidadRestante);
                //-----------------

                ventaProductoDAO.agregar(proV);
                response.sendRedirect("listarProductosCliente");
            }

            if (path.equals("/listarCompras")) {
                request.setAttribute("productos", ventaProductoDAO.listar());
                request.setAttribute("sumaTotal", ventaProductoDAO.sumaTotal());
                request.getRequestDispatcher("/WEB-INF-CLIENTE/transacciones.jsp").forward(request, response);
            }

            if (path.equals("/editarCompras")) {
                int ID1 = Integer.parseInt(request.getParameter("id1"));
                int ID2 = Integer.parseInt(request.getParameter("id2"));
                request.setAttribute("productoV", ventaProductoDAO.buscar(ID1));
                request.setAttribute("producto", productoDAO.buscar(ID2));
                request.getRequestDispatcher("/WEB-INF-CLIENTE/editarCompra.jsp").forward(request, response);
            }

            if (path.equals("/grabarCompras")) {
                int idvpro = Integer.valueOf(request.getParameter("IDPRO"));
                int cantidad = Integer.valueOf(request.getParameter("canti"));
                float precio = Float.parseFloat(request.getParameter("precio"));

                float pagoT = precio * (float) cantidad;

                ventaProducto ventaproduct = new ventaProductoDAO().buscar(idvpro);

                if (ventaproduct.getCANTIDAD() != cantidad) {

                    producto product = productoDAO.buscar(ventaproduct.getIDPRODUCTO());

                    int diferencia = cantidad - ventaproduct.getCANTIDAD();
                    int nuevacantidad = product.getCANTIDAD() - diferencia;

                    productoDAO.modificarCantidad(product.getIDPRODUCTO(), nuevacantidad);
                    ventaProductoDAO.editar(idvpro, cantidad, pagoT);
                    response.sendRedirect("listarCompras");

                } else {
                    response.sendRedirect("listarCompras");
                }

            }

            if (path.equals("/eliminarCompras")) {
                int idvpro = Integer.parseInt(request.getParameter("id"));
                int idpro = Integer.parseInt(request.getParameter("id2"));

                ventaProducto ventaproduct = ventaProductoDAO.buscar(idvpro);
                producto product = productoDAO.buscar(idpro);

                int nuevacantidad = product.getCANTIDAD() + ventaproduct.getCANTIDAD();
                productoDAO.modificarCantidad(idpro, nuevacantidad);

                ventaProductoDAO.eliminar(idvpro);
                response.sendRedirect("listarCompras");
            }
            
            
            
            //-----------------------------------------------------------------
            
            if (path.equals("/listarFacturas")) {
                request.setAttribute("facturas", compraProductoDAO.listar());
                request.getRequestDispatcher("/WEB-INF/Facturas.jsp").forward(request, response);
            }

            if (path.equals("/listarTransacciones")) {
                request.setAttribute("comprasC", ventaProductoDAO.listar());
                request.getRequestDispatcher("/WEB-INF/comprasClientes.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
