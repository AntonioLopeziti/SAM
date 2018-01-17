package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.reportes_entradas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "PeticionVisualizarReportesEntradas", urlPatterns = {"/PeticionVisualizarReportesEntradas"})
public class PeticionVisualizarReportesEntradas extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String cen = request.getParameter("cen");
            String sam = request.getParameter("sam");
            String sam2 = request.getParameter("sam2");
            String sap = request.getParameter("sap");
            String sap2 = request.getParameter("sap2");
            String fec = request.getParameter("fec");
            String fec2 = request.getParameter("fec2");
            String radio = request.getParameter("radio");
            Consultas con = new Consultas();
            switch (Accion) {
                case "CargarCentros":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"centro\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "ConsultaSAM":
                    ArrayList<reportes_entradas> re = ACC_Reportes.ObtenerInstancia().MM_MatchEntFolioSam();
                    if (re.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_entradas k : re) {
                            out.println("<tr ondblclick=\"seleccionar('" + k.getFolio_sam() + "','SAM')\">");
                            out.println("<td>" + k.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaSAM2":
                    ArrayList<reportes_entradas> re2 = ACC_Reportes.ObtenerInstancia().MM_MatchEntFolioSam();
                    if (re2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_entradas k : re2) {
                            out.println("<tr ondblclick=\"seleccionar('" + k.getFolio_sam() + "','SAM2')\">");
                            out.println("<td>" + k.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaSAP":
                    ArrayList<reportes_entradas> as = ACC_Reportes.ObtenerInstancia().MM_MatchEntFolioSap();
                    if (as.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_entradas k : as) {
                            out.println("<tr ondblclick=\"seleccionar('" + k.getFolio_sap() + "','SAP')\">");
                            out.println("<td>" + k.getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaSAP2":
                    ArrayList<reportes_entradas> as2 = ACC_Reportes.ObtenerInstancia().MM_MatchEntFolioSap();
                    if (as2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_entradas k : as2) {
                            out.println("<tr ondblclick=\"seleccionar('" + k.getFolio_sap() + "','SAP2')\">");
                            out.println("<td>" + k.getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    int sab = ACC_Reportes.ObtenerInstancia().ValidarSamEntradas(sam);
                    out.println(sab);
                    break;
                case "ValidarSAP":
                    int spb = ACC_Reportes.ObtenerInstancia().ValidarSapklEntradas(sap);
                    out.println(spb);
                    break;
                case "ValidarQuery":
                    String ff1 = con.DateFormatGuion(fec);
                    String ff2 = con.DateFormatGuion(fec2);
                    String data[] = {cen, sam, sam2, sap, sap2, ff1, ff2, radio};
                    ArrayList<reportes_entradas> rep = ACC_Reportes.ObtenerInstancia().CargarTablaEntradass(data);
                    out.println(rep.size());
                    break;
                case "CargarTabla":
                    String ff11 = con.DateFormatGuion(fec);
                    String ff22 = con.DateFormatGuion(fec2);
                    String data1[] = {cen, sam, sam2, sap, sap2, ff11, ff22, radio};
                    ArrayList<reportes_entradas> rep1 = ACC_Reportes.ObtenerInstancia().CargarTablaEntradass(data1);
                     Collections.sort(rep1, new Comparator<reportes_entradas>() {
                        public int compare(reportes_entradas o1, reportes_entradas o2) {
                            return o1.getFecha().compareTo(o2.getFecha());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for(reportes_entradas r : rep1){
                        out.println("<tr>");
                        out.println("<td>"+r.getCentro()+"</td>");
                        out.println("<td>"+r.getFolio_sap()+"</td>");
                        out.println("<td>"+r.getFolio_sam()+"</td>");
                        out.println("<td>"+r.getNum_doc_compras()+"</td>");
                        out.println("<td>"+con.DateFormat(r.getFecha())+"</td>");
                        out.println("<td>"+r.getHora_dia()+"</td>");
                        out.println("<td>"+r.getRecibido()+"</td>");
                        out.println("<td>"+r.getProcesado()+"</td>");
                        out.println("<td>"+r.getError()+"</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }
public int compare(reportes_entradas o1, reportes_entradas o2) {
        return o1.getFecha().compareTo(o2.getFecha());
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
