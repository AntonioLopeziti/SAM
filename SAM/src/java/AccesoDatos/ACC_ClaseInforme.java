package AccesoDatos;

import Entidades.clase_informe;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ACC_ClaseInforme {

    private static ACC_ClaseInforme Instance = null;

    public static ACC_ClaseInforme ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ClaseInforme();
        }
        return Instance;
    }

    public ArrayList<clase_informe> ConsultaClsInf(String idioma) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ArrayList<clase_informe> clsInf = new ArrayList<>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Movimientos_MatchClaseInforme}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                clase_informe cl = new clase_informe();
                cl.setClase_informe(rs.getString("clase_informe"));
                cl.setTexto_breve(rs.getString("texto_breve_" + idioma));
                cl.setTexto_esquema_informe(rs.getString("texto_esquema_informe_" + idioma));
                clsInf.add(cl);
            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return clsInf;
    }

    public clase_informe DataClsInforme(String numCl, String idi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        clase_informe response = new clase_informe();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL QM.Movimientos_ValidarClsInf(?,?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numCl);
            ps.setString(2, idi);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("x")) {
                response.setClase_informe("x");
            } else {
                response.setClase_informe(rs.getString("clase_informe"));
                response.setTexto_breve(rs.getString("texto_breve_" + idi));
                response.setTexto_esquema_informe(rs.getString("texto_esquema_informe_" + idi));
                response.setPerfil_catalogo(rs.getString("perfil_catalogo"));
            }

        } catch (Exception ex) {
            System.err.println("Error en el metodo DataClsInforme(ACC_ClaseInforme por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return response;
    }

}
