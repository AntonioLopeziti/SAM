/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import Entidades.folios;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author JaroMX
 */
@WebServlet(name = "GuardarArchivos", urlPatterns = {"/GuardarArchivos"})
public class GuardarArchivos extends HttpServlet {

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
     
        
        /*************/
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> imgs = new ArrayList<>();
        File raiz = new File("C:\\Archivos\\");
        raiz.mkdir();
        File alma = new File("C:\\Archivos\\Avisos\\");
        alma.mkdir();
        try{
            List items = sfu.parseRequest(request);
                for (int i = 0; i < items.size(); i++){
                    FileItem item = (FileItem) items.get(i);
                        if(!item.isFormField()){
                           imgs.add("img/productos/"+item.getName());
                        } else {
                            campos.add(item.getString());
                        }
                }
            for (int i = 0; i < campos.size(); i++){
                System.out.println(campos.get(i));
            }
            int cantidad = campos.size();
            int valor = cantidad - 1;
            String sap = campos.get(valor);
                    File folder = new File("C:\\Archivos\\Avisos\\"+sap+"\\");
                        folder.mkdir();
        
                try {
               
                    for (int i = 0; i < items.size(); i++){
                        FileItem item = (FileItem) items.get(i);
                            if(!item.isFormField()){ 
                                File archivo = new File("C:\\Archivos\\Avisos\\"+sap+"\\"+item.getName());
                                item.write(archivo);
                            imgs.add("Avisos/"+sap+"/"+item.getName());
                            System.out.println(3);
                    } else {
                        System.err.println("no es un archivo input file");
                        System.out.println(3);
                    }
                    }
                    }catch(Exception ex){
                        System.err.println("Error al guardar los archivos por:" + ex);
                    }
          
            
        }catch (Exception ex){
            System.err.println("Error" +ex);
            System.out.println(3);
        }
        
        /*----------*/
        
        
        
        
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
