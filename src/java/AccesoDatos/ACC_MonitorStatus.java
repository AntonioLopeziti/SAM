/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.MonitorStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Eduardo Hernandez
 */
public class ACC_MonitorStatus {

    private static ACC_MonitorStatus Instance = null;

    //*******Instancia*********
    public static ACC_MonitorStatus ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_MonitorStatus();
        }
        return Instance;
    }

    public LinkedList<MonitorStatus> ConsultaRelacion(String modo, String centro, String ubitec, String equipo, String jerarq, String sfi, String eq, String pue) {
        Conexion con = new Conexion();
        LinkedList<MonitorStatus> Mont = new LinkedList<>();
        switch (modo) {
            case "Alerta": {
                modo = "@0A\\QStatus@";
            }
            break;

            case "Advertencia": {
                modo = "@09\\QStatus@";
            }
            break;

            case "NoAdvertencia": {
                modo = "@08\\QStatus@";
            }
            break;

            case "NoContador": {
                modo = "@0K\\QStatus@";
            }
            break;

            default: {
                modo = "";
            }
            break;
        }
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        String query = "{call PM.relacion_ConsultaRelacion(?,?,?,?,?,?,?,?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, modo);
            pst.setString(2, centro);
            pst.setString(3, ubitec);
            pst.setString(4, equipo);
            pst.setString(5, jerarq);
            pst.setString(6, sfi);
            pst.setString(7, eq);
            pst.setString(8, pue);
            rs = pst.executeQuery();

            while (rs.next()) {
                MonitorStatus ms = new MonitorStatus();
                ms.setJerarquia(rs.getString("jerarquia"));
                ms.setNivel(rs.getString("nivel"));
                ms.setId_ubitec(rs.getString("id_ubitec"));
                ms.setNum_equipo(rs.getString("num_equipo"));
                ms.setMaterial(rs.getString("material"));
                ms.setLote(rs.getString("lote"));
                ms.setCentro(rs.getString("centro"));
                ms.setAlmacen(rs.getString("almacen"));
                ms.setSerie(rs.getString("serie"));
                if (rs.getString("doc_medicion").equals("")) {
                    ms.setDoc_medicion(rs.getString("doc_medicion"));
                } else {
                    ms.setDoc_medicion(Integer.parseInt(rs.getString("doc_medicion")) + "");
                }
                if (rs.getString("punto_medida").equals("")) {
                    ms.setPunto_medida(rs.getString("punto_medida"));
                } else {
                    ms.setPunto_medida(Integer.parseInt(rs.getString("punto_medida")) + "");
                }
                ms.setValor_medido_unidadentrada(rs.getString("valor_medido_unidadentrada"));

                switch (rs.getString("unidad_medida_entradadoc")) {
                    case "STD": {
                        ms.setUnidad_medida_entradadoc("HRA");
                    }
                    break;
                    default: {
                        ms.setUnidad_medida_entradadoc("");
                    }
                    break;
                }
                ms.setDen_objtec(rs.getString("den_objtec"));
                ms.setElem_ref_pmps(rs.getString("elem_ref_pmps").replace("\\", ""));
                ms.setIndicador_posicion(rs.getString("indicador_posicion"));
                ms.setUlt_med_anexada(rs.getString("ult_med_anexada"));
                ms.setStatus_contador(rs.getString("status_contador"));
                System.out.println(rs.getString("nivel"));
                switch (Integer.parseInt(rs.getString("nivel"))) {
                    case 0: {
                        ms.setEquipo(rs.getString("num_equipo"));
                    }
                    break;
                    case 1: {
                        ms.setEquipo(rs.getString("equipo1"));
                    }
                    break;
                    case 2: {
                        ms.setEquipo(rs.getString("equipo2"));
                    }
                    break;
                    case 3: {
                        ms.setEquipo(rs.getString("equipo3"));
                    }
                    break;
                    case 4: {
                        ms.setEquipo(rs.getString("equipo4"));
                    }
                    break;
                    case 5: {
                        ms.setEquipo(rs.getString("equipo5"));
                    }
                    break;
                    case 6: {
                        ms.setEquipo(rs.getString("equipo6"));
                    }
                    break;
                    case 7: {
                        ms.setEquipo(rs.getString("equipo7"));
                    }
                    break;
                    case 8: {
                        ms.setEquipo(rs.getString("equipo8"));
                    }
                    break;
                    case 9: {
                        ms.setEquipo(rs.getString("equipo9"));
                    }
                    break;
                    case 10: {
                        ms.setEquipo(rs.getString("equipo10"));
                    }
                    break;
                    case 11: {
                        ms.setEquipo(rs.getString("equipo11"));
                    }
                    break;
                    case 12: {
                        ms.setEquipo(rs.getString("equipo12"));
                    }
                    break;
                    case 13: {
                        ms.setEquipo(rs.getString("equipo13"));
                    }
                    break;
                    case 14: {
                        ms.setEquipo(rs.getString("equipo14"));
                    }
                    break;
                    case 15: {
                        ms.setEquipo(rs.getString("equipo15"));
                    }
                    break;
                    case 16: {
                        ms.setEquipo(rs.getString("equipo16"));
                    }
                    break;
                    case 17: {
                        ms.setEquipo(rs.getString("equipo17"));
                    }
                    break;
                    case 18: {
                        ms.setEquipo(rs.getString("equipo18"));
                    }
                    break;
                    case 19: {
                        ms.setEquipo(rs.getString("equipo19"));
                    }
                    break;
                    case 20: {
                        ms.setEquipo(rs.getString("equipo20"));
                    }
                    break;
                }
                /*
                int c = rs.getString("num_equipo").length();
                if(rs.getString("num_equipo").equals(rs.getString("equipo1").substring(0, c)))
                 */
                if (pue.equals("")) {
                    Mont.add(ms);
                } else if (ValidarPuesto(ms.getEquipo(), pue)) {
                    Mont.add(ms);
                }
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
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
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return Mont;
    }

    public boolean ValidarPuesto(String eq, String pue) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{call PM.puestoTabajoME(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, eq);
            ps.setString(2, pue);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCentroSP, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public LinkedList<MonitorStatus> ConsultaRelacionEq(String modo, String centro, String ubitec, String equipo, String jerarq, String sfi, String eq, String pue) {
        Conexion con = new Conexion();
        LinkedList<MonitorStatus> Mont = new LinkedList<>();
        LinkedList<String> ee = new LinkedList<>();
        switch (modo) {
            case "Alerta": {
                modo = "@0A\\QStatus@";
            }
            break;

            case "Advertencia": {
                modo = "@09\\QStatus@";
            }
            break;

            case "NoAdvertencia": {
                modo = "@08\\QStatus@";
            }
            break;

            case "NoContador": {
                modo = "@0K\\QStatus@";
            }
            break;

            default: {
                modo = "";
            }
            break;
        }
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String q = "{call PM.relacionEq(?,?)}";
        try {

            pst = conn.prepareStatement(q);
            pst.setString(1, equipo);
            pst.setString(2, eq);
            rs = pst.executeQuery();

            while (rs.next()) {
                ee.add(rs.getString("num_equipo"));
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }

        String query = "{call PM.relacion_ConsultaRelacion(?,?,?,?,?,?,?,?)}";

        try {
            for (String ne : ee) {
                pst = conn.prepareStatement(query);
                pst.setString(1, modo);
                pst.setString(2, centro);
                pst.setString(3, ubitec);
                pst.setString(4, ne);
                pst.setString(5, jerarq);
                pst.setString(6, sfi);
                pst.setString(7, "");
                pst.setString(8, pue);
                rs = pst.executeQuery();

                while (rs.next()) {
                    MonitorStatus ms = new MonitorStatus();
                    ms.setJerarquia(rs.getString("jerarquia"));
                    ms.setNivel(rs.getString("nivel"));
                    ms.setId_ubitec(rs.getString("id_ubitec"));
                    ms.setNum_equipo(rs.getString("num_equipo"));
                    ms.setMaterial(rs.getString("material"));
                    ms.setLote(rs.getString("lote"));
                    ms.setCentro(rs.getString("centro"));
                    ms.setAlmacen(rs.getString("almacen"));
                    ms.setSerie(rs.getString("serie"));
                    if (rs.getString("doc_medicion").equals("")) {
                        ms.setDoc_medicion(rs.getString("doc_medicion"));
                    } else {
                        ms.setDoc_medicion(Integer.parseInt(rs.getString("doc_medicion")) + "");
                    }
                    if (rs.getString("punto_medida").equals("")) {
                        ms.setPunto_medida(rs.getString("punto_medida"));
                    } else {
                        ms.setPunto_medida(Integer.parseInt(rs.getString("punto_medida")) + "");
                    }
                    ms.setValor_medido_unidadentrada(rs.getString("valor_medido_unidadentrada"));

                    switch (rs.getString("unidad_medida_entradadoc")) {
                        case "STD": {
                            ms.setUnidad_medida_entradadoc("HRA");
                        }
                        break;
                        default: {
                            ms.setUnidad_medida_entradadoc("");
                        }
                        break;
                    }
                    ms.setDen_objtec(rs.getString("den_objtec"));
                    ms.setElem_ref_pmps(rs.getString("elem_ref_pmps").replace("\\", ""));
                    ms.setIndicador_posicion(rs.getString("indicador_posicion"));
                    ms.setUlt_med_anexada(rs.getString("ult_med_anexada"));
                    ms.setStatus_contador(rs.getString("status_contador"));
                    System.out.println(rs.getString("nivel"));
                    switch (Integer.parseInt(rs.getString("nivel"))) {
                        case 0: {
                            ms.setEquipo(rs.getString("num_equipo"));
                        }
                        break;
                        case 1: {
                            ms.setEquipo(rs.getString("equipo1"));
                        }
                        break;
                        case 2: {
                            ms.setEquipo(rs.getString("equipo2"));
                        }
                        break;
                        case 3: {
                            ms.setEquipo(rs.getString("equipo3"));
                        }
                        break;
                        case 4: {
                            ms.setEquipo(rs.getString("equipo4"));
                        }
                        break;
                        case 5: {
                            ms.setEquipo(rs.getString("equipo5"));
                        }
                        break;
                        case 6: {
                            ms.setEquipo(rs.getString("equipo6"));
                        }
                        break;
                        case 7: {
                            ms.setEquipo(rs.getString("equipo7"));
                        }
                        break;
                        case 8: {
                            ms.setEquipo(rs.getString("equipo8"));
                        }
                        break;
                        case 9: {
                            ms.setEquipo(rs.getString("equipo9"));
                        }
                        break;
                        case 10: {
                            ms.setEquipo(rs.getString("equipo10"));
                        }
                        break;
                        case 11: {
                            ms.setEquipo(rs.getString("equipo11"));
                        }
                        break;
                        case 12: {
                            ms.setEquipo(rs.getString("equipo12"));
                        }
                        break;
                        case 13: {
                            ms.setEquipo(rs.getString("equipo13"));
                        }
                        break;
                        case 14: {
                            ms.setEquipo(rs.getString("equipo14"));
                        }
                        break;
                        case 15: {
                            ms.setEquipo(rs.getString("equipo15"));
                        }
                        break;
                        case 16: {
                            ms.setEquipo(rs.getString("equipo16"));
                        }
                        break;
                        case 17: {
                            ms.setEquipo(rs.getString("equipo17"));
                        }
                        break;
                        case 18: {
                            ms.setEquipo(rs.getString("equipo18"));
                        }
                        break;
                        case 19: {
                            ms.setEquipo(rs.getString("equipo19"));
                        }
                        break;
                        case 20: {
                            ms.setEquipo(rs.getString("equipo20"));
                        }
                        break;
                    }
                    /*
                int c = rs.getString("num_equipo").length();
                if(rs.getString("num_equipo").equals(rs.getString("equipo1").substring(0, c)))
                     */
                    if (pue.equals("")) {
                        Mont.add(ms);
                    } else if (ValidarPuesto(ms.getEquipo(), pue)) {
                        Mont.add(ms);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
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
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return EquiposRepetidos(Mont);
    }

    public LinkedList<MonitorStatus> EquiposRepetidos(LinkedList<MonitorStatus> Mont) {
        int c;
        try {
            for (int i = 0; i < Mont.size(); i++) {
                c = 0;
                for (int j = 0; j < Mont.size(); j++) {
                    if (i != j) {
                        try{
                            if (Mont.get(i).getJerarquia().equals(Mont.get(j).getJerarquia())) {
                                Mont.remove(j);
                                j--;
                            }
                        }catch(Exception e){
                            System.err.println("Error:" + e);
                        }
                        
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }

        return Mont;
    }

    public int ConsultaRelacion(String jerarquia) {
        Conexion cnx = new Conexion();
        String query = "SELECT * FROM PM.relacion WHERE jerarquia='" + jerarquia + "'";
        double val;
        String vw = "";
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                vw = rs.getString("status_contador");

            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
        val = Double.parseDouble(vw);
        return 0 + (int) val;
    }

    public LinkedList<Integer> Contadores() {
        Conexion cnx = new Conexion();
        LinkedList<Integer> cc = new LinkedList<>();
        String query = "{call PM.relaciondoc_medicion}";
        Connection con = cnx.ObtenerConexion();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()) {
                cc.add(Integer.parseInt(rs.getString("doc_medicion") + ""));
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return cc;
    }

    public LinkedList<MonitorStatus> CARgarSEgTabla(String centr, String Equipo) {
        Conexion con = new Conexion();
        LinkedList<MonitorStatus> Mont = new LinkedList<>();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.relacion_CARgarSEgTabla(?,?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, centr);
            pst.setString(2, Equipo);
            rs = pst.executeQuery();

            while (rs.next()) {
                MonitorStatus ms = new MonitorStatus();
                ms.setJerarquia(rs.getString("jerarquia"));
                ms.setNivel(rs.getString("nivel"));
                ms.setId_ubitec(rs.getString("id_ubitec"));
                ms.setNum_equipo(rs.getString("num_equipo"));
                ms.setMaterial(rs.getString("material"));
                ms.setLote(rs.getString("lote"));
                ms.setCentro(rs.getString("centro"));
                ms.setAlmacen(rs.getString("almacen"));
                ms.setSerie(rs.getString("serie"));
                if (rs.getString("doc_medicion").equals("")) {
                    ms.setDoc_medicion(rs.getString("doc_medicion"));
                } else {
                    ms.setDoc_medicion(Integer.parseInt(rs.getString("doc_medicion")) + "");
                }
                if (rs.getString("punto_medida").equals("")) {
                    ms.setPunto_medida(rs.getString("punto_medida"));
                } else {
                    ms.setPunto_medida(Integer.parseInt(rs.getString("punto_medida")) + "");
                }
                ms.setValor_medido_unidadentrada(rs.getString("valor_medido_unidadentrada"));

                switch (rs.getString("unidad_medida_entradadoc")) {
                    case "STD": {
                        ms.setUnidad_medida_entradadoc("HRA");
                    }
                    break;
                    default: {
                        ms.setUnidad_medida_entradadoc("");
                    }
                    break;
                }
                ms.setDen_objtec(rs.getString("den_objtec"));
                ms.setElem_ref_pmps(rs.getString("elem_ref_pmps").replace("\\", ""));
                ms.setIndicador_posicion(rs.getString("indicador_posicion"));
                ms.setUlt_med_anexada(rs.getString("ult_med_anexada"));
                ms.setStatus_contador(rs.getString("status_contador"));

                switch (rs.getInt("nivel")) {
                    case 0: {
                        ms.setEquipo(rs.getString("num_equipo"));
                    }
                    break;
                    case 1: {
                        ms.setEquipo(rs.getString("equipo1"));
                    }
                    break;
                    case 2: {
                        ms.setEquipo(rs.getString("equipo2"));
                    }
                    break;
                    case 3: {
                        ms.setEquipo(rs.getString("equipo3"));
                    }
                    break;
                    case 4: {
                        ms.setEquipo(rs.getString("equipo4"));
                    }
                    break;
                    case 5: {
                        ms.setEquipo(rs.getString("equipo5"));
                    }
                    break;
                    case 6: {
                        ms.setEquipo(rs.getString("equipo6"));
                    }
                    break;
                    case 7: {
                        ms.setEquipo(rs.getString("equipo7"));
                    }
                    break;
                    case 8: {
                        ms.setEquipo(rs.getString("equipo8"));
                    }
                    break;
                    case 9: {
                        ms.setEquipo(rs.getString("equipo9"));
                    }
                    break;
                    case 10: {
                        ms.setEquipo(rs.getString("equipo10"));
                    }
                    break;
                    case 11: {
                        ms.setEquipo(rs.getString("equipo11"));
                    }
                    break;
                    case 12: {
                        ms.setEquipo(rs.getString("equipo12"));
                    }
                    break;
                    case 13: {
                        ms.setEquipo(rs.getString("equipo13"));
                    }
                    break;
                    case 14: {
                        ms.setEquipo(rs.getString("equipo14"));
                    }
                    break;
                    case 15: {
                        ms.setEquipo(rs.getString("equipo15"));
                    }
                    break;
                    case 16: {
                        ms.setEquipo(rs.getString("equipo16"));
                    }
                    break;
                    case 17: {
                        ms.setEquipo(rs.getString("equipo17"));
                    }
                    break;
                    case 18: {
                        ms.setEquipo(rs.getString("equipo18"));
                    }
                    break;
                    case 19: {
                        ms.setEquipo(rs.getString("equipo19"));
                    }
                    break;
                    case 20: {
                        ms.setEquipo(rs.getString("equipo20"));
                    }
                    break;
                }
                /*
                int c = rs.getString("num_equipo").length();
                if(rs.getString("num_equipo").equals(rs.getString("equipo1").substring(0, c)))
                 */
                Mont.add(ms);
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
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
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return Mont;
    }

    public boolean relacionACTUALI(String cant, int mayor, String stat, String valor) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int val;
        String query = "{call PM.relacionACTUALIZARCANT(?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, cant);
            pst.setInt(2, mayor);
            pst.setString(3, stat);
            pst.setString(4, valor);
            val = pst.executeUpdate();
            if (val > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return false;
    }

    public boolean Insertcontadores_c(String folco, String Ult_med, String Fact, String Hact, int niv, String sta, String equ, String den, String Punto_medida, String Doc_me, String us_con, String entradadoc, String Mate, String cntr, String Ser, String Alma, String lot, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int val;
        String query = "{call PM.contadores_creainsertarCON(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folco);
            pst.setString(2, Ult_med);
            pst.setString(3, Fact);
            pst.setString(4, Hact);
            pst.setInt(5, niv);
            pst.setString(6, sta);
            pst.setString(7, equ);
            pst.setString(8, den);
            pst.setString(9, Punto_medida);
            pst.setString(10, Doc_me);
            pst.setString(11, us_con);
            pst.setString(12, entradadoc);
            pst.setString(13, Mate);
            pst.setString(14, cntr);
            pst.setString(15, Ser);
            pst.setString(16, Alma);
            pst.setString(17, lot);
            pst.setString(18, usu);
            val = pst.executeUpdate();
            if (val > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return false;
    }

}
