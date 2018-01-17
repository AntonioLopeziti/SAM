/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_UnidadesMedida;
import AccesoDatos.ACC_Usuario_grupo_materiales;
import Entidades.materiales;
import Entidades.usuario_grupo_materiales;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
@WebServlet(name = "peticionReservasListMaterial", urlPatterns = {"/peticionReservasListMaterial"})
public class peticionReservasListMaterial extends HttpServlet {

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
           String idioma = (String) session.getAttribute("Idioma"); 
           String Accion = request.getParameter("Accion");
           String valis = request.getParameter("valis");
           String alm1 = request.getParameter("alm1");
           String alm2 = request.getParameter("alm2");
           String centro = request.getParameter("centro");
           String Nombre = request.getParameter("usua");
           String deno = "descripcion_" + idioma;
           switch(Accion){
               case "conlis":
                LinkedList <materiales> mart = ACC_Usuario_grupo_materiales.ObtenerInstancia().CargaDatosLisMatReserva(deno,valis,alm1,alm2,centro);   
                  for (int i = 0; i < mart.size(); i++) {
                      materiales mat = ACC_Material.ObtenerInstancia().MMCargaDatosMatReserva(mart.get(i).getMaterial(), deno);    
                        out.println("<tr name=\"posi\" >\n"
                        + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"posicion\" value=" + i + " id=\"posicion" + i + "\"></td>\n"
                        + "                <td><input type=\"text\" name=\"material\" value=\""+mart.get(i).getMaterial()+"\" maxlength=\"40\" id=\"material" + i + "\" onblur=\"ValMateReserva(" + i + ")\" onclick=\"BtnShow(" + i + ")\" style=\"text-transform: uppercase;\"><button id=\"match_MA" + i + "\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"MatchMaterial('" + i + "')\"></button></td>\n"
                        + "                <td><input type=\"text\" min=\"1\"  value=\"0.000\"  name=\"cantidad\" id=\"cantidad" + i + "\" onfocus=\"BtnHide()\"  onblur=\"this.value = checkDec(this.value, 3,'" + i + "')\"  onKeyUp=\"this.value = check99(this.value, '999999', 7 ,'" + i + "')\"  ></td>\n"
                        + "                <td><input type=\"text\" name=\"unidadmedida\" value=\""+mat.getUnidad_medida()+"\" maxlength=\"2\" id=\"unidadmedida" + i + "\" disabled style=\"text-transform: uppercase;\"></td>\n"
                        + "                <td style=\"width: 40%;\"><input name=\"descripcion\" value=\""+mat.getDescripcion()+"\" maxlength=\"50\" id=\"descripcion" + i + "\" disabled style=\"width: 100%; text-transform: uppercase;\"/></td>\n"
                        + "           </tr>");
                    }
               break;
               case"verList":
                   LinkedList <usuario_grupo_materiales> mat = ACC_Usuario_grupo_materiales.ObtenerInstancia().CargaLIsta(Nombre);
                   out.println("<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lista&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
                   for(int i = 0; i < mat.size(); i++){
                        out.println("<tr ondblclick=\"PutValue('"+mat.get(i).getGrupo_usuario_lista_material()+"')\">");
                        out.println("<td>"+mat.get(i).getGrupo_usuario_lista_material()+"</td>");
                        out.println("</tr>");
                    }
               break; 
               case"verListinp":
                   usuario_grupo_materiales mate = ACC_Usuario_grupo_materiales.ObtenerInstancia().CargaLIsta2(Nombre);
                    out.println(mate.getGrupo_usuario_lista_material());                 
               break;    
               default:
               break;    
           }
        }
    }
    
//    public String Obtenerval(String val){
//     String lob="";
//     String rrs = ACC_UnidadesMedida.ObtenerInstancia().DecimalUnidadMedida(val);
//     
//     return lob;
//    }

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
