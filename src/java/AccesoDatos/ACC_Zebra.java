/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Zebra_noti_PT;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
    String txt = "";

    public void PrintTargetPT(Zebra_noti_PT z) throws IOException {
        String texto;
        if (z.getDescripcion().length() < 74) {
            texto = "^XA\n"
                    + "^MMT\n"
                    + "^PW807\n"
                    + "^LL0408\n"
                    + "^LS0\n"
                    + "^FO704,320^GFA,01152,01152,00012,:Z64:\n"
                    + "eJzVk7Fr20AUxt9ZISoUZAcKCU2wMoYMJqPAIaf/ImNDxg6poUshhVNqSIeWLFkLMXQMmIyGM9ih/0C2rJdOpi0XeygIJPT6TndSl5QUOvXJoJ8/7t777jsE8A/Vood+sXk9UDGLzatRC89gCf6wtq69bsHuvbE/mQK0ifH8Yl/MAYKtAPS7Mz1TAP64zfDLBaakN0fP+eXnD+2U9vKsQHz9/pMg7mxrrQ9PP7YTgN0uLlD0xz7tjaL1u+/r/REQ70bhAsN++ob6dL5pPQxO1CvSw6wQ6J/MOXloZgW/9xIVJn+fCx/UGN7itDpxB7RyyKYgcsc+wFPpeIP+4tRyRNFVG3pMeTh3W9mAybxixTAvB1DMCrQu9WUQCgQ6xgEIO2CDodHLAWsNpeBIlxx510Yvh+0YPs4cL1QL7eBNGJr+5dFi6sOcHgNXnpxcWV4h/1Y3jQOtZxULxLTibCIrXsHfOi2v1/Oc1Xp3BHJk+wM1F24uxXlwVPo8AIbznnA+PXnFnX9Yxdy3frYozR8u0DXjMrE5PAFfTlQ3MbxE+s+ecLk19GzzZcke6TkUNvPEk2OWVvkjrtr8ycRwaOMx90jHdfcYwLGUiWUfONproVKBPa2pt86lqeZXdMvpY3lx03rki/mv6xduwusD:C017\n"
                    + "^FT695,344^A0I,28,28^FB108,1,0^FH\\^FDPto Tbjo:^FS\n"
                    + "^FT424,368^A0I,27,26^FB79,1,0^FH\\^FDFECHA:^FS\n"
                    + "^FT334,369^A0I,27,26^FB120,1,0^FH\\^FD" + z.getFecha() + "^FS\n"
                    + "^FT198,370^A0I,27,26^FB70,1,0^FH\\^FDHORA:^FS\n"
                    + "^FT114,370^A0I,27,26^FB94,1,0^FH\\^FD" + z.getHora() + "^FS\n"
                    + "^FT698,29^A0I,25,24^FB693,1,0^FH\\^FD" + z.getCliente() + "^FS\n"
                    + "^FT796,257^A0I,21,21^FB787,1,0^FH\\^FD^FS\n"
                    + "^FT796,290^A0I,21,21^FB787,1,0^FH\\^FD" + z.getDescripcion().substring(0, z.getDescripcion().length()) + "^FS\n"
                    + "^BY2,3,99^FT744,139^BCI,,Y,N\n"
                    + "^FD>;" + z.getNro_material() + ">6-" + z.getLote() + "->51>6" + z.getCantidad() + "^FS\n"
                    + "^FT423,328^A0I,27,26^FB121,1,0^FH\\^FDCANTIDAD:^FS\n"
                    + "^FT291,328^A0I,27,26^FB126,1,0^FH\\^FD" + z.getCantidad() + "^FS\n"
                    + "^FT797,75^A0I,28,28^FB94,1,0^FH\\^FDORDEN:^FS\n"
                    + "^FT692,75^A0I,28,28^FB141,1,0^FH\\^FD" + z.getOrden() + "^FS\n"
                    + "^FT515,75^A0I,28,28^FB70,1,0^FH\\^FDLOTE:^FS\n"
                    + "^FT429,75^A0I,28,28^FB157,1,0^FH\\^FD" + z.getLote() + "^FS\n"
                    + "^FT209,75^A0I,28,28^FB25,1,0^FH\\^FDA:^FS\n"
                    + "^FT174,75^A0I,28,28^FB135,1,0^FH\\^FD" + z.getAncho() + "^FS\n"
                    + "^FO449,335^GB126,0,7^FS\n"
                    + "^FO36,65^GB139,0,5^FS\n"
                    + "^FO272,64^GB157,0,5^FS\n"
                    + "^FO552,64^GB141,0,5^FS\n"
                    + "^FO26,318^GB125,0,5^FS\n"
                    + "^FO166,318^GB125,0,5^FS\n"
                    + "^FO15,359^GB101,0,6^FS\n"
                    + "^FO213,358^GB120,0,6^FS\n"
                    + "^FT573,347^A0I,28,28^FB120,1,0^FH\\^FD" + z.getPuesto_trabajo() + "^FS\n"
                    + "^FT798,29^A0I,25,24^FB90,1,0^FH\\^FDCLIENTE:^FS\n"
                    + "^FT150,327^A0I,27,26^FB91,1,0^FH\\^FD" + z.getUm() + "^FS\n"
                    + "^XZ";

        } else {
            texto = "^XA\n"
                    + "^MMT\n"
                    + "^PW807\n"
                    + "^LL0408\n"
                    + "^LS0\n"
                    + "^FO704,320^GFA,01152,01152,00012,:Z64:\n"
                    + "eJzVk7Fr20AUxt9ZISoUZAcKCU2wMoYMJqPAIaf/ImNDxg6poUshhVNqSIeWLFkLMXQMmIyGM9ih/0C2rJdOpi0XeygIJPT6TndSl5QUOvXJoJ8/7t777jsE8A/Vood+sXk9UDGLzatRC89gCf6wtq69bsHuvbE/mQK0ifH8Yl/MAYKtAPS7Mz1TAP64zfDLBaakN0fP+eXnD+2U9vKsQHz9/pMg7mxrrQ9PP7YTgN0uLlD0xz7tjaL1u+/r/REQ70bhAsN++ob6dL5pPQxO1CvSw6wQ6J/MOXloZgW/9xIVJn+fCx/UGN7itDpxB7RyyKYgcsc+wFPpeIP+4tRyRNFVG3pMeTh3W9mAybxixTAvB1DMCrQu9WUQCgQ6xgEIO2CDodHLAWsNpeBIlxx510Yvh+0YPs4cL1QL7eBNGJr+5dFi6sOcHgNXnpxcWV4h/1Y3jQOtZxULxLTibCIrXsHfOi2v1/Oc1Xp3BHJk+wM1F24uxXlwVPo8AIbznnA+PXnFnX9Yxdy3frYozR8u0DXjMrE5PAFfTlQ3MbxE+s+ecLk19GzzZcke6TkUNvPEk2OWVvkjrtr8ycRwaOMx90jHdfcYwLGUiWUfONproVKBPa2pt86lqeZXdMvpY3lx03rki/mv6xduwusD:C017\n"
                    + "^FT695,344^A0I,28,28^FB108,1,0^FH\\^FDPto Tbjo:^FS\n"
                    + "^FT424,368^A0I,27,26^FB79,1,0^FH\\^FDFECHA:^FS\n"
                    + "^FT334,369^A0I,27,26^FB120,1,0^FH\\^FD" + z.getFecha() + "^FS\n"
                    + "^FT198,370^A0I,27,26^FB70,1,0^FH\\^FDHORA:^FS\n"
                    + "^FT114,370^A0I,27,26^FB94,1,0^FH\\^FD" + z.getHora() + "^FS\n"
                    + "^FT698,29^A0I,25,24^FB693,1,0^FH\\^FD" + z.getCliente() + "^FS\n"
                    + "^FT796,257^A0I,21,21^FB787,1,0^FH\\^FD" + z.getDescripcion().substring(73, z.getDescripcion().length()) + "^FS\n"
                    + "^FT796,290^A0I,21,21^FB787,1,0^FH\\^FD" + z.getDescripcion().substring(0, 73) + "^FS\n"
                    + "^BY2,3,99^FT744,139^BCI,,Y,N\n"
                    + "^FD>;" + z.getNro_material() + ">6-" + z.getLote() + "->51>6" + z.getCantidad() + "^FS\n"
                    + "^FT423,328^A0I,27,26^FB121,1,0^FH\\^FDCANTIDAD:^FS\n"
                    + "^FT291,328^A0I,27,26^FB126,1,0^FH\\^FD" + z.getCantidad() + "^FS\n"
                    + "^FT797,75^A0I,28,28^FB94,1,0^FH\\^FDORDEN:^FS\n"
                    + "^FT692,75^A0I,28,28^FB141,1,0^FH\\^FD" + z.getOrden() + "^FS\n"
                    + "^FT515,75^A0I,28,28^FB70,1,0^FH\\^FDLOTE:^FS\n"
                    + "^FT429,75^A0I,28,28^FB157,1,0^FH\\^FD" + z.getLote() + "^FS\n"
                    + "^FT209,75^A0I,28,28^FB25,1,0^FH\\^FDA:^FS\n"
                    + "^FT174,75^A0I,28,28^FB135,1,0^FH\\^FD" + z.getAncho() + "^FS\n"
                    + "^FO449,335^GB126,0,7^FS\n"
                    + "^FO36,65^GB139,0,5^FS\n"
                    + "^FO272,64^GB157,0,5^FS\n"
                    + "^FO552,64^GB141,0,5^FS\n"
                    + "^FO26,318^GB125,0,5^FS\n"
                    + "^FO166,318^GB125,0,5^FS\n"
                    + "^FO15,359^GB101,0,6^FS\n"
                    + "^FO213,358^GB120,0,6^FS\n"
                    + "^FT573,347^A0I,28,28^FB120,1,0^FH\\^FD" + z.getPuesto_trabajo() + "^FS\n"
                    + "^FT798,29^A0I,25,24^FB90,1,0^FH\\^FDCLIENTE:^FS\n"
                    + "^FT150,327^A0I,27,26^FB91,1,0^FH\\^FD" + z.getUm() + "^FS"
                    + "^XZ";
        }

//        PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
        PrintService ps = impresoras(impresora(z.getPuesto_trabajo()));
        txt += "-" + impresora(z.getPuesto_trabajo());
        try (FileWriter writer = new FileWriter("C:\\Users\\Portal Sap\\Desktop\\foo.txt")) {
            writer.write(txt);
            writer.flush();
            // do more stuff with writer
        }
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        DocPrintJob dj = ps.createPrintJob();
        Doc doc = new SimpleDoc(texto.getBytes(), flavor, null);
        try {
            dj.print(doc, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PrintService impresoras(String nombre) throws IOException {
        txt = "IP_dir: " + nombre;
        System.out.println("IP: " + nombre);
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null); //Obtenemos los servicios de impresion del sistema 
        for (PrintService impresora : printServices) { //Recorremos el array de servicios de impresion
            System.out.println("Printer: " + impresora.getName());
            txt += "\nPrinter: " + impresora.getName();

            if (impresora.getName().contentEquals(nombre)) { // Si el nombre del servicio es el mismo que el que buscamos
                return impresora; // Nos devuelve el servicio 
            }
        }
        return null;    // Si no lo encuentra nos devuelve un null
    }

    public Zebra_noti_PT DatosFaltantesCabecera(String orden) {
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
                zb.setRuta(rs.getString("ruta"));
                zb.setStock(rs.getString("stock"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);

        return zb;
    }

    public String impresora(String puesto) {
        String zb = "";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;

        String query = "{call PP.impresora_etiqueta(?)}";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, puesto);
            rs = ps.executeQuery();
            while (rs.next()) {
                zb = rs.getString("dir_ip");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);

        return zb;
    }

    public String DatosFaltantesPosiciones(String orden, String operacion) {
        String pto = "";
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
                pto = rs.getString("puesto_trabajo");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);

        return pto;
    }

    public void guardaEtiquetaDB(Zebra_noti_PT zl) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PP.guarda_etiquetaPT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, zl.getOrden());
            ps.setString(2, zl.getPuesto_trabajo());
            ps.setString(3, zl.getFol_sam());
            ps.setString(4, zl.getLote());
            ps.setString(5, zl.getCentro());
            ps.setString(6, zl.getAncho());
            ps.setString(7, zl.getFecha());
            ps.setString(8, zl.getHora());
            ps.setString(9, zl.getCantidad());
            ps.setString(10, zl.getUm());
            ps.setString(11, zl.getCliente());
            ps.setString(12, zl.getDescripcion());
            ps.setString(13, "");
            ps.setString(14, zl.getNro_material());
            ps.setString(15, zl.getRuta());
            ps.setString(16, zl.getStock());
            ps.setString(17, zl.getUsuario());
            ps.setString(18, zl.getClmovi());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public String[] getImp(String pto) {
        String[] prop = new String[2];
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call cnf.GetDirImp(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pto);
            rs = ps.executeQuery();
            while (rs.next()) {
                prop[0] = rs.getString("dir_ip");
                prop[1] = rs.getString("tipo");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return prop;
    }

    public static void main(String[] args) throws IOException {
//        Zebra_noti_PT zb = new Zebra_noti_PT();
//        zb.setPuesto_trabajo("BB05");
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

    public String ConvertCodeZebra(Zebra_noti_PT z) {
        String Concatedes = "";
        if (z.getDescripcion().length() < 70) {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + z.getDescripcion().substring(0, z.getDescripcion().length()).replace("°", "_C2_B0") + "^FS\n";
        } else {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD" + z.getDescripcion().substring(69, z.getDescripcion().length()).replace("°", "_C2_B0") + "^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + z.getDescripcion().substring(0, 69).replace("°", "_C2_B0") + "^FS\n";
        }
        return "^XA\n"
                + "^MMT\n"
                + "^PW807\n"
                + "^LL0408\n"
                + "^LS0\n"
                + "^FO704,320^GFA,01152,01152,00012,:Z64:\n"
                + "eJzVk7Fr20AUxt9ZISoUZAcKCU2wMoYMJqPAIaf/ImND"
                + "xg6poUshhVNqSIeWLFkLMXQMmIyGM9ih/0C2rJdOpi0Xe"
                + "ygIJPT6TndSl5QUOvXJoJ8/7t777jsE8A/Vood+sXk9UD"
                + "GLzatRC89gCf6wtq69bsHuvbE/mQK0ifH8Yl/MAYKtAPS7"
                + "Mz1TAP64zfDLBaakN0fP+eXnD+2U9vKsQHz9/pMg7mxrrQ9"
                + "PP7YTgN0uLlD0xz7tjaL1u+/r/REQ70bhAsN++ob6dL5pPQx"
                + "O1CvSw6wQ6J/MOXloZgW/9xIVJn+fCx/UGN7itDpxB7RyyKYgc"
                + "sc+wFPpeIP+4tRyRNFVG3pMeTh3W9mAybxixTAvB1DMCrQu9WUQC"
                + "gQ6xgEIO2CDodHLAWsNpeBIlxx510Yvh+0YPs4cL1QL7eBNGJr+5dF"
                + "i6sOcHgNXnpxcWV4h/1Y3jQOtZxULxLTibCIrXsHfOi2v1/Oc1Xp3BHJ"
                + "k+wM1F24uxXlwVPo8AIbznnA+PXnFnX9Yxdy3frYozR8u0DXjMrE5PAFfTl"
                + "Q3MbxE+s+ecLk19GzzZcke6TkUNvPEk2OWVvkjrtr8ycRwaOMx90jHdfcYwLGUiWUfONproVKBPa2pt86lqeZXdMvpY3lx03rki/mv6xduwusD:C017\n"
                + "^FT704,322^A0I,28,28^FB108,1,0^FH\\^FDPto Tbjo:^FS\n"
                + "^FT424,368^A0I,27,26^FB79,1,0^FH\\^FDFECHA:^FS\n"
                + "^FT334,369^A0I,27,26^FB120,1,0^FH\\^FD " + z.getFecha() + "^FS\n"
                + //// Fecha
                "^FT198,370^A0I,27,26^FB70,1,0^FH\\^FDHORA:^FS\n"
                + "^FT114,370^A0I,27,26^FB94,1,0^FH\\^FD" + z.getHora() + "^FS\n"
                + "^FT707,28^A0I,23,24^FB700,1,0^FH\\^FD" + z.getCliente() + "^FS\n"
                + "^BY2,3,99^FT744,139^BCI,,Y,N\n"
                + "^FD>;" + z.getNro_material() + ">6-" + z.getLote() + "->5123456>" + z.getCantidad() + "^FS\n"
                + "^FT423,328^A0I,27,26^FB121,1,0^FH\\^FDCANTIDAD:^FS\n"
                + "^FT291,328^A0I,27,26^FB126,1,0^FH\\^FD" + z.getCantidad() + "^FS\n"
                + "^FT797,75^A0I,28,28^FB94,1,0^FH\\^FDORDEN:^FS\n"
                + "^FT692,75^A0I,28,28^FB141,1,0^FH\\^FD" + z.getOrden() + "^FS\n"
                + "^FT515,75^A0I,28,28^FB70,1,0^FH\\^FDLOTE:^FS\n"
                + "^FT429,75^A0I,28,28^FB157,1,0^FH\\^FD" + z.getLote() + "^FS\n"
                + "^FT209,75^A0I,28,28^FB25,1,0^FH\\^FDA:^FS\n"
                + "^FT174,75^A0I,28,28^FB135,1,0^FH\\^FD" + z.getAncho() + "^FS\n"
                + "^FO462,316^GB126,0,7^FS\n"
                + "^FO36,65^GB139,0,5^FS\n"
                + "^FO272,64^GB157,0,5^FS\n"
                + "^FO552,64^GB141,0,5^FS\n"
                + "^FO54,317^GB99,0,4^FS\n"
                + "^FO166,318^GB125,0,5^FS\n"
                + "^FO15,359^GB101,0,6^FS\n"
                + "^FO213,358^GB120,0,6^FS\n"
                + "^FT588,367^A0I,28,28^FB145,1,0^FH\\^FD" + z.getRuta() + "^FS\n"
                + "^FT703,367^A0I,28,28^FB96,1,0^FH\\^FD" + z.getStock() + "^FS\n"
                + "^FT583,324^A0I,28,28^FB120,1,0^FH\\^FD" + z.getPuesto_trabajo() + "^FS\n"
                + "^FT150,327^A0I,27,26^FB91,1,0^FH\\^FD" + z.getUm() + "^FS\n"
                + "^FT797,28^A0I,21,21^FB81,1,0^FH\\^FDCLIENTE:^FS\n"
                + Concatedes
                + "^XZ";
    }

    public String ConvertCodeZebraTLP(Zebra_noti_PT z) {
        String Concatedes = "";
        if (z.getDescripcion().length() < 70) {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + z.getDescripcion().substring(0, z.getDescripcion().length()).replace("°", "_C2_B0") + "^FS\n";
        } else {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD" + z.getDescripcion().substring(69, z.getDescripcion().length()).replace("°", "_C2_B0") + "^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + z.getDescripcion().substring(0, 69).replace("°", "_C2_B0") + "^FS\n";
        }
        return "N\n"
                + "A677,362,2,4,1,1,N,\"LEON01\"";
    }

    public int ValidarDatos(String tipo, String variable) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  pp.ValidarDatosEtiqueta(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setString(2, variable);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<Zebra_noti_PT> ConsultaOrdenReporte() {
        ArrayList<Zebra_noti_PT> ord = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call pp.ReporteEtiquetasConsultaOrden}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zebra_noti_PT o = new Zebra_noti_PT();
                o.setOrden(rs.getString("num_orden"));
                ord.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ord;
    }

    public ArrayList<Zebra_noti_PT> ConsultaSAMReporte() {
        ArrayList<Zebra_noti_PT> ord = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call pp.ReporteEtiquetasConsultaFolioSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zebra_noti_PT o = new Zebra_noti_PT();
                o.setFol_sam(rs.getString("folio_sam"));
                ord.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ord;
    }

    public ArrayList<Zebra_noti_PT> ConsultaPuestoReporte() {
        ArrayList<Zebra_noti_PT> ord = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call pp.ReporteEtiquetasConsultaPuesto}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zebra_noti_PT o = new Zebra_noti_PT();
                o.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                ord.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ord;
    }

    public ArrayList<Zebra_noti_PT> CargarTablaEtiqueta(String ord, String sam, String pto, String fecha) {
        ArrayList<Zebra_noti_PT> orde = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call pp.ReporteEtiquetasCargarTabla(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ord);
            ps.setString(2, sam);
            ps.setString(3, pto);
            ps.setString(4, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zebra_noti_PT o = new Zebra_noti_PT();
                o.setOrden(rs.getString("num_orden"));
                o.setFol_sam(rs.getString("folio_sam"));
                o.setFecha(rs.getString("fecha"));
                o.setHora(rs.getString("hora"));
                o.setNro_material(rs.getString("material"));
                o.setDescripcion(rs.getString("descripcion"));
                o.setCliente(rs.getString("cliente"));
                o.setCentro(rs.getString("centro"));
                o.setLote(rs.getString("lote"));
                o.setCantidad(rs.getString("cantidad"));
                o.setUm(rs.getString("unidad_medida"));
                o.setAncho(rs.getString("ancho"));
                o.setRuta(rs.getString("ruta"));
                o.setStock(rs.getString("stock"));
                o.setUsuario(rs.getString("usuario"));
                o.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                orde.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return orde;
    }

}
