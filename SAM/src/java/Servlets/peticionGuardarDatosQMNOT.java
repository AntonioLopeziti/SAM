/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Qm_cabecera;
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

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionGuardarDatosQMNOT", urlPatterns = {"/peticionGuardarDatosQMNOT"})
public class peticionGuardarDatosQMNOT extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");
           String caso = request.getParameter("caso");
           String ord = request.getParameter("ord");
           String ope = request.getParameter("ope");
           String usu = request.getParameter("usu");
           String creapor = request.getParameter("creapor");
           String lotins = request.getParameter("lotins");
           String txtbr = request.getParameter("txtbr");
           String cent = request.getParameter("cent");
           String ultmod = request.getParameter("ultmod");
           String fecc = request.getParameter("fecc");
           String fecm = request.getParameter("fecm");
           String horc =request.getParameter("horc");
           String horm =request.getParameter("horm");
           folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("QN");
           int fa = fo.getFolioActual();
           String folsa = "QN"+fa;
           String feh = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
           String hoh = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
           
           
           String nucain = request.getParameter("nucain");
           String texbre = request.getParameter("texbre");
           String destex = request.getParameter("destex");
           String Entraca = request.getParameter("Entraca");
           String unimed1 = request.getParameter("unimed1");
           String cata1 = request.getParameter("cata1");
           
           String numdef1 = request.getParameter("numdef1");
           String resu1 = request.getParameter("resu1");
           String valo1 = request.getParameter("valo1"); 
           String codi1 = request.getParameter("codi1"); 
           String note1 = request.getParameter("note1");
           String ids = request.getParameter("ids");
           
           switch(caso){
               case "GuaCAb":
               if (ACC_Qm_cabecera.ObtenerInstancia().INSERTcabecera_QM_crea(folsa,lotins,feh,hoh,ord,ope,txtbr,cent,creapor,fecc,horc,ultmod,fecm,horm,usu)) {
                     out.println(1);
                   } else {
                        out.println(0);
                    }    
               break;
               case"GuaPosQM":                   
               if (ACC_Qm_cabecera.ObtenerInstancia().INSERTPOS_QM_crea(folsa,lotins,nucain,feh,hoh,texbre,destex,Entraca,numdef1,resu1,valo1,codi1,unimed1,note1,cata1)) {
                     out.println(1);
                   } else {
                        out.println(0);
                    }
               break;
               case "DatMatcVa":
                   out.println("<table>");
                   out.println("<tbody>");
                    out.println("<tr ondblclick=\"seleccionar('A','valo1"+ids+"','VentanaModalValora')\" >"
                            + "<td>Valoración aceptación</td>"
                            + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
                    out.println("<tr ondblclick=\"seleccionar('R','valo1"+ids+"','VentanaModalValora')\">"
                            + "<td>Valoración rechazo</td><"
                            + "td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;R&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                break;   
               case "DatMatcCo":
                    out.println("<table>");
                    out.println("<tbody>");
                     out.println("<tr ondblclick=\"seleccionar('TGX1','codi1"+ids+"','VentanaModalCodig')\" >"
                             + "<td>TGX1</td>"
                             + "<td>Bien</td></tr>");
                     out.println("<tr ondblclick=\"seleccionar('TGX2','codi1"+ids+"','VentanaModalCodig')\">"
                             + "<td>TGX2</td><"
                             + "td>Mal</td></tr>");
                     out.println("</tbody>");
                     out.println("</table>");   
               break;  
               case "CONfol":
                if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("QN",fa)) {
                      int foac = fo.getFolioActual();
                        out.println(1+","+foac);
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
