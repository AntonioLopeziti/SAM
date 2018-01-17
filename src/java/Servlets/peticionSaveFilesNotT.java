/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zil
 */
@WebServlet(name = "peticionSaveFilesNotT", urlPatterns = {"/peticionSaveFilesNotT"})
public class peticionSaveFilesNotT extends HttpServlet {

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

            String centro, ruta;
            int count;
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);
            JSONArray js = new JSONArray();
            List items = sfu.parseRequest(request);
            count = items.size();
            FileItem c = (FileItem) items.get((count - 1));
            centro = c.getFieldName();

            File raiz = new File("C:\\Archivos\\");
            raiz.mkdir();

            File dms = new File("C:\\Archivos\\DMS\\");
            dms.mkdir();

            File cen = new File("C:\\Archivos\\DMS\\" + centro + "\\");
            cen.mkdir();

            File evc = new File("C:\\Archivos\\DMS\\" + centro + "\\EVS\\");
            evc.mkdir();

//            File folder = new File("C:\\Archivos\\DMS\\" + centro + "\\EVC\\" + "MO" + fa + "\\");
//            folder.mkdir();
            try {

                for (int i = 0; i < items.size(); i++) {
                    FileItem item = (FileItem) items.get(i);

                    if (!item.isFormField()) {
                        ruta = "C:\\Archivos\\DMS\\" + centro + "\\EVS\\" + item.getName();
                        File archivo = new File(ruta);
                        item.write(archivo);
                        if (js.contains(ruta)) {
                        } else {
                            js.add(ruta);
                        }

                    } else {
                        System.err.println("error al subir los archivos");
                    }

                }
                out.println(js);
            } catch (Exception ex) {
                js.add("0");
                out.println(js);
                System.err.println("Error al guardar los archivos por:" + ex);
            }

        } catch (FileUploadException ex) {
            Logger.getLogger(archivosMovimiento101.class.getName()).log(Level.SEVERE, null, ex);
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
