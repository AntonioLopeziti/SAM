/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_CentroCosto;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Reservas;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
import Entidades.folios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionGuardaReserva", urlPatterns = {"/PeticionGuardaReserva"})
public class PeticionGuardaReserva extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String us = request.getParameter("USUARIOCREA");
            String accion = request.getParameter("Action");
            String material = request.getParameter("MATERIAL");
            String cantidad = request.getParameter("CANTIDAD");
            String um = request.getParameter("UNIDADMEDIDA");
            String descripcion = request.getParameter("DESCRIPCION");
            String centro = request.getParameter("CENTRO");
            String almacen = request.getParameter("ALMACEN");
            String clase = request.getParameter("CLASE");
            String centroco = request.getParameter("CENTROCO");
            String orden = request.getParameter("ORDEN");
            String contador = request.getParameter("CONTADOR");
            String folio = request.getParameter("FOLIO");
            String movimiento = request.getParameter("MOVIMIENTO");
            String cont = request.getParameter("cont");

            String hora = request.getParameter("HORA");
            String fecha = request.getParameter("FECHA");
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("RE");
            //folios fo = ACC_Folios.ObtenerIstancia().ObtenerFolio("RE");
            int fa = fo.getFolioActual() + 1;
            String tabla = "CNF.folios";
            String campo = "folio_actual = '" + fa + "'";
            String condicion = "id_folio = 'RE'";

            //Correcto
            folios foli = ACC_Folios.ObtenerIstancia().CargarAllDatos("RE");
            int folact = foli.getFolioActual() + 1;
            int foli2 = foli.getFolioActual();
            String campo1 = "folio_actual = '" + folact + "'";

            String cne = request.getParameter("CENTI");
            String alm = request.getParameter("ALM");
            String cco = request.getParameter("CCO");
            String or = request.getParameter("OR");
            String alde = request.getParameter("alde");

            switch (accion) {  
                case "GuardarReserva":
                    String folactua = Integer.toString(folact);
                    int c = ACC_Reservas.ObtenerInstancia().ReservaPosC("RE" + folactua);
                    if(Integer.parseInt(cont) == c){
                        if (clase.equals("201")) {
                            orden = "";
                            alde = "";
                        } else if (clase.equals("261")) {
                            centroco = "";
                            alde = "";
                        } else if (clase.equals("311")) {
                            orden = "";
                            centroco = "";
                        }
                        String fech = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                        String ho = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                        ACC_Reservas.ObtenerInstancia().MMInsertarReservasCabeceraCrea("RE" + folactua, fech, ho, centro, clase, almacen, centroco, orden, alde, us);
                        ACC_Reservas.ObtenerInstancia().MMUpdateFolioReservas(folactua);
                        //Consultas.ObtenerInstancia().Update(tabla, campo1, condicion);
                        out.println("RE" + folactua);
                    }else{
                        ACC_Reservas.ObtenerInstancia().EliminaPosRes("RE" + folactua);
                        out.println(0);
                    }
                    
                    break;
                case "GuardarReservaPosiciones":
                    String folactul = "RE" + Integer.toString(folact);
                    if (ACC_Reservas.ObtenerInstancia().MMInsertarReservaPosicionesCreaUno(folactul, contador, material, centro, almacen, cantidad, um, centroco, orden, movimiento, descripcion, alde, "") == true) {
                        //out.println(foli.getFolioActual());
                        out.println("RE" + folact);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ActualizarFolio":
                    Consultas.ObtenerInstancia().Update(tabla, campo1, condicion);
                    break;
                case "ValidarCentro":
                    if (ACC_Centro.ObtenerInstancia().ValidaCampoCentro(cne) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAlmacen":
                    if (ACC_Almacenes.ObtenerInstancia().ValidaCampoAlmacen(alm) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCCO":
                    if (ACC_CentroCosto.ObtenerInstancia().ValidaMMCentroCoste(cco) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarOR":
                    if (ACC_Reservas.ObtenerInstancia().ValidarOrdMM(or) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
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
