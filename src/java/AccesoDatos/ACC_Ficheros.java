package AccesoDatos;

import Entidades.DocumentosDMSenvio;
import Entidades.DmsDocs;
import Entidades.Ficheros;
import Entidades.cabecera_ordenes_crea;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Panda
 */
public final class ACC_Ficheros {

    private static ACC_Ficheros Instance = null;

    public static ACC_Ficheros ObtenerInstancia() throws IOException {
        if (Instance == null) {
            Instance = new ACC_Ficheros();
        }
        return Instance;
    }

    public static void main(String[] args) throws IOException {
        ACC_Ficheros mm = new ACC_Ficheros();
        mm.DirectorioFolder("C:\\Archivos\\Equipos");
//        mm.MostrarFicheros("C:/Prueba/Creado/");
//        mm.MostrarFichero("C:/Prueba/Creado/Android.jpg");

    }

    public void MostrarFichero(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while ((cadena = b.readLine()) != null) {
                System.out.println(cadena);
            }
        }
    }

    public boolean SendFile(String ruta, String ipClient) throws IOException {
//        corutinaCMD();
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;

        final String filename = ruta.replace("\\", "/");

        try {
            final File localFile = new File(filename);
            Socket client = new Socket(ipClient, 4400);
            bis = new BufferedInputStream(new FileInputStream(localFile));
            bos = new BufferedOutputStream(client.getOutputStream());

            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(localFile.getName());

            byteArray = new byte[8192];
            while ((in = bis.read(byteArray)) != -1) {
                bos.write(byteArray, 0, in);
            }
            bis.close();
            bos.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    public boolean SendMod(String ruta, String ipClient) throws IOException {
//        corutinaCMD();
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;

        final String filename = ruta.replace("\\", "/");

        try {
            final File localFile = new File(filename);
            Socket client = new Socket(ipClient, 4410);
            bis = new BufferedInputStream(new FileInputStream(localFile));
            bos = new BufferedOutputStream(client.getOutputStream());

            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(localFile.getName());

            byteArray = new byte[8192];
            while ((in = bis.read(byteArray)) != -1) {
                bos.write(byteArray, 0, in);
            }
            bis.close();
            bos.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public boolean corutinaCMD() {
        try {
            String command = "java -jar C:\\conexionconfig\\DMS_Server.jar";
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
        }
        return true;
    }

    public File[] DirectorioFolder(String ruta) {
        File[] folder = null;
        try {
            File f = new File(ruta);
            folder = f.listFiles();
//            folder = new File(ruta).listFiles(File::isDirectory);
            //        System.out.println(Arrays.toString(directories));
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return folder;
    }

    public List<File> DirectorioFoldersB(String ruta, String B) {
        File[] folder;
        LinkedList<File> nfol = new LinkedList<>();
        try {
            File f = new File(ruta);
            folder = f.listFiles();
//            folder = new File(ruta).listFiles(File::isDirectory);
            for (File folder1 : folder) {
                int pos = folder1.getAbsolutePath().lastIndexOf(File.separator);
                String gg = folder1.getAbsolutePath().substring(pos + 1, folder1.toString().length());
                if (gg.equals(B)) {
                    nfol.add(folder1);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return nfol;
    }
    
    public ArrayList<DmsDocs> MostEqVisOrd(String equip){
        ArrayList<DmsDocs> dc = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisOrd_ObEqq(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(pr);
            ps.setString(1, equip);
            rs = ps.executeQuery();
            while (rs.next()){
                DmsDocs dca = new DmsDocs();
                dca.setNum_documento(rs.getString("num_documento"));
                dca.setDocumento_parcial(rs.getString("documento_parcial"));
                dca.setVersion_documento(rs.getString("version_documento"));
                dca.setClase_documento(rs.getString("clase_documento"));
                dca.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                dc.add(dca);
            }   
        }catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);            
        } finally {
            cnx.CerrarConexion(con);
        }
        return dc;
    }

    //Metodo para Visualizar Equipos
    public ArrayList<DmsDocs> MostClassDoc(String equip) {
        ArrayList<DmsDocs> clss = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisEq_ObClasDoc(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, equip);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs edf = new DmsDocs();
                edf.setNum_documento(rs.getString("num_documento"));
                edf.setDocumento_parcial(rs.getString("documento_parcial"));
                edf.setVersion_documento(rs.getString("version_documento"));
                edf.setClase_documento(rs.getString("clase_documento"));
                edf.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                clss.add(edf);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return clss;
    }

    //Metodo para Visualizar Ubicaciones Tecnicas
    public ArrayList<DmsDocs> MostClassDocEq(String ubtec) {
        ArrayList ute = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisEq_ObClasUbTec(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, ubtec);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs edf = new DmsDocs();
                edf.setNum_documento(rs.getString("num_documento"));
                edf.setDocumento_parcial(rs.getString("documento_parcial"));
                edf.setVersion_documento(rs.getString("version_documento"));
                edf.setClase_documento(rs.getString("clase_documento"));
                edf.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                ute.add(edf);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ute;
    }
    //Metodo para Visualizar Avisos
    public ArrayList<DmsDocs> MostClassDocAv(String avi) {
        ArrayList ute = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisEq_ObClasAv(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, avi);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs edf = new DmsDocs();
                edf.setNum_documento(rs.getString("num_documento"));
                edf.setDocumento_parcial(rs.getString("documento_parcial"));
                edf.setVersion_documento(rs.getString("version_documento"));
                edf.setClase_documento(rs.getString("clase_documento"));
                edf.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                ute.add(edf);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ute;
    }
    //Metodo para Visualizar Lotes de Inspección
    public ArrayList<DmsDocs> MostClassDocLI(String loi) {
        ArrayList ute = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisEq_ObClasLoi(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, loi);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs edf = new DmsDocs();
                edf.setNum_documento(rs.getString("num_documento"));
                edf.setDocumento_parcial(rs.getString("documento_parcial"));
                edf.setVersion_documento(rs.getString("version_documento"));
                edf.setClase_documento(rs.getString("clase_documento"));
                edf.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                ute.add(edf);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ute;
    }
    //Metodo para Visualizar Clases de MAterial
    public ArrayList<DmsDocs> MostClassDocCM(String cmv) {
        ArrayList ute = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL DMS.VisEq_ObClasCMV(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, cmv);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs edf = new DmsDocs();
                edf.setNum_documento(rs.getString("num_documento"));
                edf.setDocumento_parcial(rs.getString("documento_parcial"));
                edf.setVersion_documento(rs.getString("version_documento"));
                edf.setClase_documento(rs.getString("clase_documento"));
                edf.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                ute.add(edf);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ute;
    }

    public ArrayList<Ficheros> MostrarFicheros(String path) throws FileNotFoundException, IOException {
        ArrayList<Ficheros> files = new ArrayList<>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                Ficheros file = new Ficheros();
                double rr = (double) listOfFile.length() / 1048576;
                DecimalFormat nf = new DecimalFormat("#.###");
                String m = nf.format(rr);
                String arch = listOfFile.getPath();
                String ext = "";
                int i = arch.lastIndexOf('.');
                if (i > 0) {
                    ext = arch.substring(i + 1);
                }
                switch (ext) {
                    case "jpg":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/JPG-48.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Visor de Imágenes JPG");
                        break;
                    case "xml":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/XML-64.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Bloc de notas");
                        break;
                    case "txt":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/TXT-48.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Bloc de notas");
                        break;
                    case "xlsx":
                    case "xls":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/MS Excel-48.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Microsoft Excel");
                        break;
                    case "pdf":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/PDF 2-48.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Acrobat Reader");
                        break;
                    case "docx":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/MS Word-48.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Microsoft Word");
                        break;
                    case "pptx":
                        file.setApl("&nbsp;&nbsp;&#8226;&nbsp;<img style='vertical-align:middle' width='25' height='25' src='images/ms_powerpoint.png' /> " + ext);
                        file.setAplicacion("&nbsp;&nbsp;&nbsp;Microsoft PowerPoint");
                        break;
                    default:
                        file.setApl(ext);
                        break;
                }
                file.setName(listOfFile.getName());
                file.setExtencion(ext);
                file.setFichero(listOfFile.getAbsolutePath());
                file.setTamanio(m);
                files.add(file);
            }

        }
        return files;
    }

    public String GetCtrDMS() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.CentroDMS(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("centro");
            }
        } catch (Exception e) {
            System.out.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
    public String GetDAviso(String av) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call PM.getDAvisos(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, av);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("descripcion");
            }
        } catch (Exception e) {
            System.out.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
    public String GetDUbicTec(String av) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call PM.getDUbicTec(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, av);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("denominacion_ES");
            }
        } catch (Exception e) {
            System.out.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
    public String GetDEquipo(String av) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call PM.getDEquipo(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, av);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("denominacion_es");
            }
        } catch (Exception e) {
            System.out.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
    public int VisDoccPorEq(String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call DMS.VisEq_ObClasDoc(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en VisDoccPorEq, ACC_Ficheros por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int VisDoccPorUb(String ubte) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call DMS.VisEq_ObClasUbTec(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ubte);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en VisDoccPorEq, ACC_Ficheros por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int VisDoccPorAv(String avi){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban=0;
        String sql = "{call DMS.VisEq_ObClasAv(?)}";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1, avi);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        }catch (Exception e) {
            System.out.println("Error en VisDoccPorAv, ACC_Ficheros por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int VisDoccPorLi(String loi){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban=0;
        String sql = "{call DMS.VisEq_ObClasLoi(?)}";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1, loi);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        }catch (Exception e) {
            System.out.println("Error en VisDoccPorAv, ACC_Ficheros por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int VisDoccPorCM(String cmv){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban=0;
        String sql = "{call DMS.VisEq_ObClasCMV(?)}";
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1, cmv);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        }catch (Exception e) {
            System.out.println("Error en VisDoccPorAv, ACC_Ficheros por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean InsertDataFiles(DocumentosDMSenvio doc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL DMS.Movimientos_InsertarDataFiles(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, doc.getFolio_dms());
            cbst.setString(2, doc.getTabix());
            cbst.setString(3, doc.getFecha());
            cbst.setString(4, doc.getHora_dia());
            cbst.setString(5, doc.getAplicacion());
            cbst.setString(6, doc.getClase_documento());
            cbst.setString(7, doc.getDescripcion_documento());
            cbst.setString(8, doc.getPersona_responsable());
            cbst.setString(9, doc.getOriginal_documento());

            confirmacion = cbst.execute();
            if (confirmacion == true) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error PS: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
}
