/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author Panda
 */
public class Pruebas_Test {

    private static Pruebas_Test instance = null;

    public static Pruebas_Test ObtenerInstancia() {
        if (instance == null) {
            instance = new Pruebas_Test();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException {
//        String texto = muestraContenido("C:\\Users\\ORG\\Downloads\\etiqueta.txt");
        String fecha = "09/04/2018";
        String puestoT = "Roko";

        String texto = "^XA\n"
                + "^MMT\n"
                + "^PW759\n"
                + "^LL0416\n"
                + "^LS0\n"
                + "^FO672,320^GFA,00768,00768,00008,:Z64:\n"
                + "eJzVkbFKA0EQhv+9DbmQi3cWNhLIpkynYBMN6AnWvoCFj2DAxkLJmXQR9AFSKKaxEsvDa9bqulhaKthclQTSJOS4dXZjIShYWbjFfszOzr/zzwL/bC2v0Ma+nuRygP/t3m2t2K7eA8enXtx8ldioF/uNnkSj5E12ZhJrpWxSuwNaZ2p+cA30N7u98kWA96WrZ8EkcThwV6XOx66guvpWx3J+bMlfPO88LsJmS2qwoPKmacObahbAQ2PA5Uqz6rKRLvb3mZIkEBQRBVR2nkGRALMyZCTA+ABqDFi8i+hB85KZ2MrYKCH3uxlT9AANgUehofcZV4aJYUuZBhDNTZ4pYfI88Si/B3tqU2zBCduUz0NMX7Q+Ksk2kUOk3liPvBx1brQtMYu1sUAkeW3UF6mtWXVCM551Txl/hXw2NN9jq1TTMu2RwJMyc8HJUWD8H6a//fkfrg+dOXSn:F348\n"
                + "^FT629,366^A0I,23,24^FB171,1,0^FH\\^FD" + puestoT + "^FS\n"
                + "^FT731,300^A0I,28,28^FB161,1,0^FH\\^FDDESCRIPCION^FS\n"
                + "^FT270,362^A0I,23,24^FB189,1,0^FH\\^FDFECHA: " + fecha + "^FS\n"
                + "^FT729,258^A0I,23,24^FB207,1,0^FH\\^FDCANTIDAD: 1234.000^FS\n"
                + "^FT741,41^A0I,23,21^FB80,1,0^FH\\^FDCLIENTE:^FS\n"
                + "^FT653,42^A0I,23,24^FB197,1,0^FH\\^FDEMPAQUES SANPER^FS\n"
                + "^FT472,263^A0I,23,24^FB83,1,0^FH\\^FDMETROS^FS\n"
                + "^FT562,301^A0I,28,28^FB178,1,0^FH\\^FDDEL MATERIAL^FS\n"
                + "^FT378,302^A0I,28,28^FB143,1,0^FH\\^FDA IMPRIMIR^FS\n"
                + "^FT449,42^A0I,23,24^FB185,1,0^FH\\^FDDEL CENTRO LEON^FS\n"
                + "^FT258,44^A0I,23,24^FB180,1,0^FH\\^FD123456789012345^FS\n"
                + "^BY2,3,78^FT716,110^BCI,,Y,N\n"
                + "^FD>;1234567890>6-lotemate->51234>65.000^FS\n"
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

//        System.out.println(muestraContenido("C:\\Users\\ORG\\Downloads\\etiqueta.txt"));
    }

    public static String muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena, texto = "";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
//            System.out.println(cadena);
            texto += cadena + "\n";
        }
        b.close();
        return texto;
    }

    public String getImp(String pto) {
        String ip = null;
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
                ip = rs.getString("dir_ip");
            }
        } catch (Exception e) {
            ip = null;
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ip;
    }

    public int PrintDoc(String[] datos, String ip) {
        int ban = 0;
        Pruebas_Test gift = new Pruebas_Test();
        String code = gift.ConvertCodeZebra(datos);
        try {
            int ret = gift.getPrint(code, ip);
            ban = ret;
        } catch (IOException ex) {
            Logger.getLogger(Pruebas_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }

    public String ConvertCodeZebra(String[] datos) {
        String Concatedes = "";
        if (datos[12].length() < 70) {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + datos[12].substring(0, datos[12].length()).replace("°", "_C2_B0") + "^FS\n";
        } else {
            Concatedes = "^FT799,253^A0I,21,21^FB793,1,0^FH\\^FD" + datos[12].substring(69, datos[12].length()).replace("°", "_C2_B0") + "^FS\n"
                    + "^FT799,285^A0I,21,21^FB792,1,0^FH\\^FD" + datos[12].substring(0, 69).replace("°", "_C2_B0") + "^FS\n";
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
                + "^FT334,369^A0I,27,26^FB120,1,0^FH\\^FD " + datos[0] + "^FS\n"
                + //// Fecha
                "^FT198,370^A0I,27,26^FB70,1,0^FH\\^FDHORA:^FS\n"
                + "^FT114,370^A0I,27,26^FB94,1,0^FH\\^FD" + datos[1] + "^FS\n"
                + "^FT707,28^A0I,23,24^FB700,1,0^FH\\^FD" + datos[2] + "^FS\n"
                + "^BY2,3,99^FT744,139^BCI,,Y,N\n"
                + "^FD>;" + datos[3] + ">6-" + datos[4] + "->5123456>" + datos[5] + "^FS\n"
                + "^FT423,328^A0I,27,26^FB121,1,0^FH\\^FDCANTIDAD:^FS\n"
                + "^FT291,328^A0I,27,26^FB126,1,0^FH\\^FD" + datos[5] + "^FS\n"
                + "^FT797,75^A0I,28,28^FB94,1,0^FH\\^FDORDEN:^FS\n"
                + "^FT692,75^A0I,28,28^FB141,1,0^FH\\^FD" + datos[6] + "^FS\n"
                + "^FT515,75^A0I,28,28^FB70,1,0^FH\\^FDLOTE:^FS\n"
                + "^FT429,75^A0I,28,28^FB157,1,0^FH\\^FD" + datos[4] + "^FS\n"
                + "^FT209,75^A0I,28,28^FB25,1,0^FH\\^FDA:^FS\n"
                + "^FT174,75^A0I,28,28^FB135,1,0^FH\\^FD" + datos[7] + "^FS\n"
                + "^FO462,316^GB126,0,7^FS\n"
                + "^FO36,65^GB139,0,5^FS\n"
                + "^FO272,64^GB157,0,5^FS\n"
                + "^FO552,64^GB141,0,5^FS\n"
                + "^FO54,317^GB99,0,4^FS\n"
                + "^FO166,318^GB125,0,5^FS\n"
                + "^FO15,359^GB101,0,6^FS\n"
                + "^FO213,358^GB120,0,6^FS\n"
                + "^FT588,367^A0I,28,28^FB145,1,0^FH\\^FD" + datos[8] + "^FS\n"
                + "^FT703,367^A0I,28,28^FB96,1,0^FH\\^FD" + datos[9] + "^FS\n"
                + "^FT583,324^A0I,28,28^FB120,1,0^FH\\^FD" + datos[10] + "^FS\n"
                + "^FT150,327^A0I,27,26^FB91,1,0^FH\\^FD" + datos[11] + "^FS\n"
                + "^FT797,28^A0I,21,21^FB81,1,0^FH\\^FDCLIENTE:^FS\n"
                + Concatedes
                + "^XZ";
    }

    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
                null, null);
        for (PrintService printService : printServices) {
             System.out.println("Impresora: " + printService.getName());
            if (printService.getName().equals(printerName)) {
                System.out.println("Se encontro la impresora: " + printService);
                return printService;
            }else{
                System.out.println("No Se encontro la impresora: " + printerName);
            }
        }
        return null;
    }

    public int getPrint(String zpl_data, String printer) throws IOException {
        int resp = 0;

        PrintService myPrintService = findPrintService(printer);
        if (myPrintService == null) {
            resp = 1; ///// no hay Servicio Impresora
        } else {

            DocPrintJob job = myPrintService.createPrintJob();
            DocFlavor flvr = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(zpl_data.getBytes(), flvr, null);
            try {
                job.print(doc, null);
                resp = 2; //// Correcto
                System.out.println("Print Done!");
            } catch (PrintException e) {
                resp = 3; //// Error al imprimir
                System.out.println("Error en la impresion: "+e.getCause() + "  -  " + e.getMessage());
            }
        }
        return resp;
    }
}
