package farmaciaControlador;

import farmacia.modelo.DAO.proveedoresDAO;
import farmacia.modelo.bean.proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletProveedores", urlPatterns = {"/servletProveedores", "/listarProveedores", "/nuevoProveedor", "/grabarProveedor", "/editarProveedor", "/eliminarProveedor"})
public class servletProveedores extends HttpServlet {

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

            if (path.equals("/listarProveedores")) {
                request.setAttribute("proveedor", proveedoresDAO.listar());
                request.getRequestDispatcher("WEB-INF/proveedores.jsp").forward(request, response);
            }

            if (path.equals("/nuevoProveedor")) {
                request.setAttribute("proveedor", new proveedor());
                request.getRequestDispatcher("WEB-INF/proveedoresForm.jsp").forward(request, response);
            }

            if (path.equals("/grabarProveedor")) {

                int id = Integer.parseInt(request.getParameter("id"));

                String nom = (String) request.getParameter("nombre");
                String cog = (String) request.getParameter("codigo");

                if (id > 0) {
                    proveedor pro = new proveedor();
                    pro.setIDPROVEEDOR(id);
                    pro.setNOMBRE(nom);
                    pro.setCODIGO(cog);
                    proveedoresDAO.modificar(pro);
                } else {
                    proveedor pro = new proveedor();
                    pro.setNOMBRE(nom);
                    pro.setCODIGO(cog);
                    proveedoresDAO.agregar(pro);
                }

                response.sendRedirect("listarProveedores");
            }

            if (path.equals("/editarProveedor")) {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("proveedor", proveedoresDAO.buscar(id));
                request.getRequestDispatcher("WEB-INF/proveedoresForm.jsp").forward(request, response);
            }

            if (path.equals("/eliminarProveedor")) {
                int id = Integer.parseInt(request.getParameter("id"));
                proveedoresDAO.eliminar(id);
                response.sendRedirect("listarProveedores");
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
