package AccesoDatos;

import Entidades.texto_posicion_ordenes_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ACC_TextoPosicionOrdenesCrea {
    
    Conexion cnx = new Conexion();
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_TextoPosicionOrdenesCrea Instance = null;
    
    public static ACC_TextoPosicionOrdenesCrea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_TextoPosicionOrdenesCrea();
        }
        return Instance;
    }
    
    public boolean InsertTxtsOrdenes(texto_posicion_ordenes_crea tpoc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarTxtDescri(?, ?, ?, ?)}");
            cbst.setString(1, tpoc.getFolio_sam());
            cbst.setString(2, tpoc.getNum_operacion());
            cbst.setString(3, tpoc.getIndice());
            cbst.setString(4, tpoc.getTexto());
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
    
    public ArrayList ConsultaTxtDes(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList txts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        texto_posicion_ordenes_crea tx;
        String SP = "{CALL PM.Ordenes_ConsultarTxtDes(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                tx = new texto_posicion_ordenes_crea();
                tx.setFolio_sam(rs.getString("folio_sam"));
                tx.setNum_operacion(rs.getString("num_operacion"));
                tx.setIndice(rs.getString("indice"));
                tx.setTexto(rs.getString("texto"));
                txts.add(tx);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaTxtDes(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return txts;
    }
    
    public String TextoByNumOpe(ArrayList<texto_posicion_ordenes_crea> rs, String ope) {
        String txt = "";
        for (int x = 0; x < rs.size(); x++) {
            if (rs.get(x).getNum_operacion().equals(ope)) {
                txt += rs.get(x).getTexto();
            }
        }
        return txt;
    }
    
}
