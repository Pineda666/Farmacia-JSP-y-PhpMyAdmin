package farmaciaControlador;

import farmacia.modelo.DAO.productoDAO;
import farmacia.modelo.DAO.usuarioDAO;
import farmacia.modelo.bean.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletUsuario", urlPatterns = {"/servletUsuario", "/validarUsuario", "/cerrarSesion"})
public class servletUsuario extends HttpServlet {

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

            if (path.equals("/validarUsuario")) {

                String user = (String) request.getParameter("usuario");
                String clave = (String) request.getParameter("password");

                usuario us = usuarioDAO.validar(user, clave);

                if (us != null) {
                    // request.getSession().setAttribute("empleado", empleadoDAO.BUSCAR(us.getIDEMPLEADO()));
                    //request.setAttribute("articulos", articuloDAO.listar());
                    if (us.getIDRANGO() == 1) {
                        request.getSession().setAttribute("user", us);
                        request.getRequestDispatcher("WEB-INF-CLIENTE/principalCliente.jsp").forward(request, response);
                    }
                    if (us.getIDRANGO() == 2) {
                        request.getSession().setAttribute("user", us);
                        request.getRequestDispatcher("WEB-INF/principalAdmin.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("msg", "Usuario o Contraseña incorrectos");
                    request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
                }
            }

            if (path.equals("/cerrarSesion")) {
                request.getSession().invalidate();
                request.getRequestDispatcher("/LOGIN.jsp").forward(request, response);
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
