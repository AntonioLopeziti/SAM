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
public class Pruebas_Test {

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

}
