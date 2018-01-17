/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.usuarioRoot;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.net.Socket;

import com.sap.mw.jco.JCO;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;
/*import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;*/
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author AREConsulting
 */
public class Conexion {

    protected JCO.Client connection;
    private String user = "";
    private String pwd = "";
    private String host = "";
    private String port = "";
    private String dbase = "";
    private String lib = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "";
    private Connection con;
    private String ruta = "config.xml";

    public Connection ObtenerConexion() {
        String[] data = CargarDatos();
        this.user = data[0];
        this.pwd = data[1];
        this.host = data[2];
        this.port = data[3];
        this.dbase = data[4];
        this.url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbase;
        try {
            Class.forName(lib);
            con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error en la Conexion" + ex);
        }
        return con;
    }

    public boolean ProbarConexionLocal(usuarioRoot ur) {
        this.user = ur.getUsuarioSAM();
        this.pwd = ur.getPasswordSAM();
        this.host = ur.getServidorSAM();
        this.port = ur.getPuertoSAM();
        this.dbase = ur.getBaseDatosSAM();
        this.url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbase;
        try {
            Class.forName(lib);
            con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                CerrarConexion(con);
                return true;
            } else {
                CerrarConexion(con);
                return false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            CerrarConexion(con);
            System.err.println("Error en la Conexion" + ex);
        } finally {
            CerrarConexion(con);
        }
        return false;
    }

    public boolean GuardarConfiguracion(usuarioRoot us) {
        URL url = getClass().getResource(ruta);
        String arr[] = new String[5];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Document doc = db.parse(url.openStream());
            NodeList nList = doc.getElementsByTagName("config");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            eElement.getElementsByTagName("usuario").item(0).setTextContent(us.getUsuarioSAM());
            eElement.getElementsByTagName("clave").item(0).setTextContent(us.getPasswordSAM());
            eElement.getElementsByTagName("servidor").item(0).setTextContent(us.getServidorSAM());
            eElement.getElementsByTagName("puerto").item(0).setTextContent(us.getPuertoSAM());
            eElement.getElementsByTagName("basedatos").item(0).setTextContent(us.getBaseDatosSAM());
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(url.getPath()));
            transformer.transform(source, result);
            return true;
        } catch (SAXException | IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean GuardarWS(usuarioRoot us) {
        URL url = getClass().getResource(ruta);
        String arr[] = new String[5];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Document doc = db.parse(url.openStream());
            NodeList nList = doc.getElementsByTagName("config");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            eElement.getElementsByTagName("url_ws").item(0).setTextContent(us.getWebService());
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(url.getPath()));
            transformer.transform(source, result);
            return true;
        } catch (SAXException | IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String... args) {
        Conexion cnx = new Conexion();
        String[] d = cnx.CargarDatos();
        System.out.println(d[1]);
    }

    public String[] CargarDatos() {
        URL url = getClass().getResource(ruta);
        String arr[] = new String[6];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Document doc = db.parse(url.openStream());
            NodeList nList = doc.getElementsByTagName("config");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            String u = eElement.getElementsByTagName("usuario").item(0).getTextContent();
            String c = eElement.getElementsByTagName("clave").item(0).getTextContent();
            String s = eElement.getElementsByTagName("servidor").item(0).getTextContent();
            String p = eElement.getElementsByTagName("puerto").item(0).getTextContent();
            String b = eElement.getElementsByTagName("basedatos").item(0).getTextContent();
            String w = eElement.getElementsByTagName("url_ws").item(0).getTextContent();
            arr[0] = u;
            arr[1] = c;
            arr[2] = s;
            arr[3] = p;
            arr[4] = b;
            arr[5] = w;
        } catch (SAXException | IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void CerrarConexion(Connection cnx) {
        try {
            System.out.println(cnx);
            if (cnx != null) {

                cnx.close();
                System.out.println("Conexion Cerrada exitosamente");
            } else {
                System.err.println("Conexion no fue Cerrada");
            }

        } catch (SQLException ex) {
            System.err.println("No se pudo cerrar la conexion " + ex);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
