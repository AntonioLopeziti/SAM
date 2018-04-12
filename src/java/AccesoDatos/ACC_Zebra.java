/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Zebra_noti_PT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author Panda
 */
public class ACC_Zebra {

    private static ACC_Zebra Instance = null;

    public static ACC_Zebra ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Zebra();
        }
        return Instance;
    }

    public void PrintTargetPT(Zebra_noti_PT z) {
        String texto = "^XA\n"
                + "^MMT\n"
                + "^PW759\n"
                + "^LL0416\n"
                + "^LS0\n"
                + "^FO608,320^GFA,01536,01536,00016,:Z64:\n"
                + "eJzdkz+LE0EYxt/JECeKmjIW4qUUbK4QtMixexCw9LpU4QJ+gSk2TmFwJ1yhIJIvIMd1HtdcZ2GTsTKNXLq7ImMi6d1VkCznJuOsuzuzgcsH0HdJ8eOZ998zE4B/P+r6gxLUSxt0nvwqcFTiV+sVSIVN+Ucfj+GkdHLj9HXKdOGhz/gDOe+k3FvEKDg4fD8MU743bqCzT29lby/latR4EMwHqnc/5Rp9yJ4+I8TL6vuLpfo+Hxw62Xzhr+WPsxev3pGsXhg53wLnIIYo5T36aPdJDXlAU778OfwdVPtRIzvfPpfyC+lfbGXsqNgPMI+2ZlnDZhOaAG55w75XWVTh2iYbZeat6S+xmhUQCfAnBcYcnFWB7wIQ5lru6CPFAgILLCNbjuMRVpYJYBdadoJrgAUoZfgO+AL2pWWk9ECK57yNdXNmB6jjeaKbATrlvs5fGh6RNyNdf5Y74JJdFxYtarbFSiBlBtTjTgWS0wvDoPQRq//doct6Vk8uScVFfUfK3MHria7WdcKYuYIk31nhNX1ngkx+ouvmxf6IUbdLrY5USH1jsAC8DLvtseWqiqoqzNkF0vIQ6xj/tL4C69823JJT0RY5P9b6ZehzMEEYBWboZlIf7P0RIHKCvhrGXLs3iO0DFEivTw3CTLtvx0sewL6UwvJtru0ttMdQY8+hEBEppuu/7HhqoaIbD4/X3v9/E38AZBbf1w==:BCF9\n"
                + "^FT566,354^A0I,25,24^FB172,1,0^FH\\^FD" + z.getPuesto_trabajo() + "^FS\n"
                + "^FT742,290^A0I,25,24^FB696,1,0^FH\\^FD" + z.getDescripcion() + "^FS\n"
                + "^FT319,372^A0I,21,21^FB66,1,0^FH\\^FDFECHA:^FS\n"
                + "^FT315,332^A0I,21,21^FB135,1,0^FH\\^FDHORA: " + z.getHora() + "^FS\n"
                + "^FT331,72^A0I,21,21^FB121,1,0^FH\\^FDA:" + z.getAncho() + "^FS\n"
                + "^FT331,142^A0I,21,21^FB155,1,0^FH\\^FDORDEN:" + z.getOrden() + "^FS\n"
                + "^FT332,108^A0I,21,21^FB164,1,0^FH\\^FDLOTE:" + z.getLote() + "^FS\n"
                + "^FT696,99^A0I,23,24^FB296,1,0^FH\\^FDCANTIDAD:" + z.getCantidad() + "METROS^FS\n"
                + "^BY2,3,72^FT719,193^BCI,,Y,N\n"
                + "^FD>;" + z.getNro_material() + ">6-" + z.getLote() + "->51>6" + z.getCantidad() + "^FS\n"
                + "^FT738,24^A0I,23,21^FB682,1,0^FH\\^FD" + z.getCliente() + "^FS\n"
                + "^FT242,374^A0I,21,21^FB93,1,0^FH\\^FD" + z.getFecha() + "^FS\n"
                + "^XZ";
        PrintService ps = PrintServiceLookup.lookupDefaultPrintService();

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        DocPrintJob dj = ps.createPrintJob();
        Doc doc = new SimpleDoc(texto.getBytes(), flavor, null);
        try {
            dj.print(doc, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Zebra_noti_PT DatosFaltantesCabecera(String orden){
        Zebra_noti_PT zb = new Zebra_noti_PT();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        
        String query = "{call PP.DatosEtiqueta_PT(?)}";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                zb.setCliente(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        
        return zb;
    }
    public Zebra_noti_PT DatosFaltantesPosiciones(String orden, String operacion){
        Zebra_noti_PT zb = new Zebra_noti_PT();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        
        String query = "{call PP.DatosEtiquetaP_PT(?,?)}";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, orden);
            ps.setString(2, operacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                zb.setPuesto_trabajo(rs.getString("puesto_trabajo"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        
        return zb;
    }

    public static void main(String[] args) {
//        Zebra_noti_PT zb = new Zebra_noti_PT();
//        zb.setPuesto_trabajo("BK03");
//        zb.setDescripcion("Material XXXXXXXXXXXXXXXXXXXXXX");
//        zb.setFecha("09/04/2018");
//        zb.setHora("18:37:00");
//        zb.setAncho("1234.000");
//        zb.setOrden("1000005");
//        zb.setLote("NUEVOPR");
//        zb.setCantidad("1.00");
//        zb.setCliente("TEXTO DEL CLIENTE DE SANPER DE LEON DEL CENTRO DE MEXICO");
//        zb.setNro_material("1234567890");
//        ACC_Zebra.ObtenerInstancia().PrintTargetPT(zb);

    }
}
