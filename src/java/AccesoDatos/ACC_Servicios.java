package AccesoDatos;

import Entidades.SolpedServicios;
import Entidades.servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Servicios {

    private static ACC_Servicios Instance = null;

    public static ACC_Servicios ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Servicios();
        }
        return Instance;
    }

    public ArrayList<servicios> CargarMCServicios(String ser, String des, String descampo, String ctd) {
        ArrayList<servicios> se = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection cn = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_CargarServicios(?,?,?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, ser);
            ps.setString(2, des);
            ps.setString(3, descampo);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                servicios s = new servicios();
                s.setServicio(rs.getString("servicio"));
                s.setDescripcion(rs.getString(descampo));
                s.setUnidad_medida(rs.getString("unidad_medida"));
                se.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarMCServicios por " + e);
        } finally {
            cnx.CerrarConexion(cn);
        }
        return se;
    }

    public void InsertarServiciosTemp(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14) {
        Conexion cnx = new Conexion();
        Connection cn = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_InsertServiciosTemp(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(cn);
        }
    }

    public void InsertarServiciosTempMod(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String folio) {
        Conexion cnx = new Conexion();
        Connection cn = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_InsertServiciosTempMod(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(cn);
        }
    }

    public void EliminarPosSerTemporal(String user, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.SolpedEliminarSerPos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pos);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void EliminarPosSerTemporalMod(String user, String pos, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.SolpedEliminarSerPosMod(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pos);
            ps.setString(3, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void EliminarSerTemporal(String user,String ipsf) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.SolpedEliminarServTem(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, ipsf);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<SolpedServicios> CargarServiciosMOD(String Folio, String pos, String user) {
        ArrayList<SolpedServicios> solp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.solped_servicios_creaSOLPOS(?,?,?)}";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, Folio);
            st.setString(2, pos);
            st.setString(3, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SolpedServicios s = new SolpedServicios();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_posicion_solped2(rs.getString("num_posicion_solped2"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                solp.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServicios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return solp;
    }

    public ArrayList<SolpedServicios> CargarServicios(String user, String pos) {
        ArrayList<SolpedServicios> solp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_CargarServTemp(?,?)}";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pos);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SolpedServicios s = new SolpedServicios();
                s.setId_sps(rs.getInt("id_sps"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_posicion_solped2(rs.getString("num_posicion_solped2"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setFecha(rs.getString("fecha"));
                s.setHora(rs.getString("hora_dia"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setCantidad_base(rs.getString("cantidad_base"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orde(rs.getString("num_orden"));
                s.setNum_solped(rs.getString("num_solped"));
                s.setRecibido(rs.getString("recibido"));
                s.setProcesado(rs.getString("procesado"));
                s.setError(rs.getString("error"));
                solp.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServicios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return solp;
    }

    public void InsertarSolpedServicios(ArrayList<SolpedServicios> sl, String folio, String user, String hora) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_InsertServicios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedServicios s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, folio);
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getNum_posicion_solped2());
                ps.setString(4, s.getNum_servicio());
                ps.setString(5, s.getFecha());
                ps.setString(6, hora);
                ps.setString(7, s.getTexto_breve());
                ps.setString(8, s.getCantidad());
                ps.setString(9, s.getUnidad_medida_base());
                ps.setString(10, s.getPrecio_bruto());
                ps.setString(11, s.getGrupo_articulos());
                ps.setString(12, s.getNum_cuenta_mayor());
                ps.setString(13, s.getCentro_coste());
                ps.setString(14, s.getNum_orde());
                ps.setString(15, user);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public LinkedList<servicios> CargarServicioSP(String query, String descr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<servicios> ser = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                servicios s = new servicios();
                s.setServicio(rs.getString("servicio"));
                s.setDescripcion(rs.getString(descr));
                s.setUnidad_medida(rs.getString("unidad_medida"));
                ser.add(s);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en el metodo CargarServicioSP (ACC_Servicios) por: " + e);
        }
        return ser;
    }

    public ArrayList ConsultaMatchServicioOrden(String numS, String descri, String campoDes, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList sers = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        servicios s;
        String SP = "{CALL PM.Ordenes_ConsultarServicio(?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numS);
            ps.setString(2, descri);
            ps.setString(3, campoDes);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new servicios();
                s.setServicio(rs.getString("servicio"));
                s.setDescripcion(rs.getString(campoDes));
                sers.add(s);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sers;
    }

    public int CheckPosServicios(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int r = 0;
        String query = "SELECT COUNT (folio_sam) folio_sam FROM solped_servicios_crea WHERE folio_sam='" + id + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                r = rs.getInt("folio_sam");
            }
        } catch (Exception e) {
            System.err.println("Error en ChecPosServicios por " + e);
        }
        return r;
    }

    public int ValidarServicio(String servi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT servicio FROM servicios WHERE servicio='" + servi + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String un = rs.getString("servicio");
                if (un.equals(servi)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidadUnidadMedida");
        }
        return 0;
    }

    public servicios ObtenerServici(String id, String idio) {
        String des = "descripcion_" + idio;
        String sql = "{CALL MM.Solped_ValidarServicio(?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        servicios s = new servicios();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setServicio(rs.getString("servicio"));
                s.setDescripcion(rs.getString(des));
                s.setUnidad_medida(rs.getString("unidad_medida"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public String GetCavalor(String Ser) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String quer = "SELECT categoria_valoracion FROM servicios WHERE servicio = '" + Ser + "'";
        String s = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(quer);
            while (rs.next()) {
                s = rs.getString("categoria_valoracion");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }
}
