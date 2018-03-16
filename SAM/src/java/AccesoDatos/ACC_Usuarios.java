/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.usuarios;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 */
public class ACC_Usuarios {

    private static ACC_Usuarios Instance = null;

    public static ACC_Usuarios ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Usuarios();
        }

        return Instance;
    }

    public boolean UsuarioHabiltado(String User) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL CNF.Usuarios_QueryUserHabilitado(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en Metodo UsuarioHabilitado por: " + e);
        } finally {
            cnx.ObtenerConexion();
        }
        return false;
    }

    public int UsuarioVis(String User) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String proc = "{CALL PM.UsuarioDocVis(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error en Metodo UsuarioHabilitado por: " + e);
        } finally {
            cnx.ObtenerConexion();
        }
        return 0;
    }

    public boolean login(String Usuario, String Password) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcSt = "{CALL CNF.Usuarios_QueryLogin(?,?)}";
        try {
            ps = con.prepareStatement(ProcSt);
            ps.setString(1, Usuario);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en el login por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public String VerificarPermisos(String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String x = "";
        String Proc = "{CALL CNF.Usuarios_QueryPermisos(?)}";
        try {

            ps = con.prepareStatement(Proc);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                x = rs.getString("permisos");
            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return x;
    }

    public usuarios CargarDatosSesion(String User) {
        usuarios u = new usuarios();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL CNF.Usuarios_CargarDatosSession(?)}";
        try {
            ps = con.prepareCall(proc);
            ps.setString(1, User);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setUsuario(rs.getString("Usuario"));
                u.setCentro(rs.getString("Centro"));
                u.setPermisos(rs.getString("permisos"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo CargarDatosSesion por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return u;
    }

    public boolean ValidarUsuario(String User) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String proc = "{CALL  CNF.Usuarios_ValidarUsuario(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(proc);
            ps.setString(1, User);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public boolean InsertarUsuario(usuarios u) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String Pro = "{CALL CNF._Usuarios_InsertarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(Pro);
            ps.setString(1, u.getCentro());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getNombre());
            ps.setString(5, u.getApellidoPat());
            ps.setString(6, u.getApellidoMat());
            ps.setString(7, u.getRFC());
            ps.setString(8, u.getCorreo());
            ps.setString(9, u.getTelefono());
            ps.setString(10, u.getTelefono2());
            ps.setString(11, u.getCalle());
            ps.setInt(12, u.getNumeroInt());
            ps.setInt(13, u.getNumeroExt());
            ps.setString(14, u.getColonia());
            ps.setString(15, u.getPoblacion());
            ps.setString(16, u.getEstado());
            ps.setString(17, u.getPais());
            ps.setString(18, u.getPermisos());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarUsuario por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean ModificarUser(usuarios u) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        try {
            String sql = "{CALL CNF.ModificarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getCentro());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getNombre());
            ps.setString(5, u.getApellidoPat());
            ps.setString(6, u.getApellidoMat());
            ps.setString(7, u.getRFC());
            ps.setString(8, u.getCorreo());
            ps.setString(9, u.getTelefono());
            ps.setString(10, u.getTelefono2());
            ps.setString(11, u.getCalle());
            ps.setInt(12, u.getNumeroInt());
            ps.setInt(13, u.getNumeroExt());
            ps.setString(14, u.getColonia());
            ps.setString(15, u.getPoblacion());
            ps.setString(16, u.getEstado());
            ps.setString(17, u.getPais());
            ps.setString(18, u.getPermisos());
            ps.setInt(19, u.getHabilitado());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ModificarUser por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean ActualizarClaveDefault(String user, String clave) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL CNF.Usuario_ActualizarClaveDefault(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, clave);
            if (ps.executeUpdate() > 0) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en actualizarClaveDefauñt por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public usuarios CargarUsuario(String Usuario) {
        usuarios us = new usuarios();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL CNF.Usuarios_CargarUsuario(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString("Nombre"));
                us.setApellidoPat(rs.getString("ApellidoPat"));
                us.setApellidoMat(rs.getString("ApellidoMat"));
                us.setRFC(rs.getString("RFC"));
                us.setCorreo(rs.getString("Correo"));
                us.setTelefono(rs.getString("Telefono"));
                us.setTelefono2(rs.getString("Telefono2"));
                us.setCalle(rs.getString("Calle"));
                us.setNumeroInt(rs.getInt("NumeroInt"));
                us.setNumeroExt(rs.getInt("NumeroExt"));
                us.setColonia(rs.getString("Colonia"));
                us.setPoblacion(rs.getString("Poblacion"));
                us.setEstado(rs.getString("Estado"));
                us.setPais(rs.getString("Pais"));
                us.setHabilitado(rs.getInt("Habilitado"));
                us.setCentro(rs.getString("centro"));
            }

        } catch (Exception e) {
            System.err.println("Error en CargarUsuario por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return us;
    }

    public ArrayList<usuarios> ListaUsuarioMC(String User, int ctd) {
        ArrayList<usuarios> us = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL CNF.Usuarios_CargarMCUsuarios(?,?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            ps.setInt(2, ctd);
            ps.executeQuery();
            rs = ps.getResultSet();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setUsuario(rs.getString("Usuario"));
                u.setNombre(rs.getString("Nombre"));
                u.setRFC(rs.getString("RFC"));
                us.add(u);
            }
        } catch (Exception e) {
            System.err.println("Error en ListaUsuarioMC por:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return us;
    }
    
    public ArrayList<usuarios> ListaUsuarioAvisosQM(String User, String nombre, int ctd) {
        ArrayList<usuarios> us = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL QM.Usuarios_CargarUsuarios(?,?,?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            ps.setString(2, nombre);
            ps.setInt(3, ctd);
            ps.executeQuery();
            rs = ps.getResultSet();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setUsuario(rs.getString("Usuario"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellidoPat(rs.getString("ApellidoPat"));
                us.add(u);
            }
        } catch (Exception e) {
            System.err.println("Error en ListaUsuarioMC por:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return us;
    }

    public ArrayList<usuarios> ListaUsuarioNpm1(String User, String ctd, String na) {
        ArrayList<usuarios> us = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL CNF.NotifPM1_CargarMCUsuarios(?,?,?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            ps.setString(2, ctd);
            ps.setString(3, na);
            ps.executeQuery();
            rs = ps.getResultSet();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setUsuario(rs.getString("Usuario"));
                u.setNombre(rs.getString("Nombre"));
                u.setRFC(rs.getString("RFC"));
                us.add(u);
            }
        } catch (Exception e) {
            System.err.println("Error en ListaUsuarioMC por:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return us;
    }
    public boolean ValidaUsuarioQM(String User) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String proc = "{CALL QM.validaUsuarioQM(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, User);
            ps.executeQuery();
            rs = ps.getResultSet();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en ListaUsuarioMC por:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

//     public usuarios CargarDatosUsuario(String user) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        usuarios us = new usuarios();
//        String query = "SELECT * FROM usuarios WHERE Usuario='" + user + "'";
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                us.setNombre(rs.getString("Nombre"));
//                us.setApellidoPat(rs.getString("ApellidoPat"));
//                us.setApellidoMat(rs.getString("ApellidoMat"));
//                us.setRFC(rs.getString("RFC"));
//                us.setCorreo(rs.getString("Correo"));
//                us.setTelefono(rs.getString("Telefono"));
//                us.setTelefono2(rs.getString("Telefono2"));
//                us.setCalle(rs.getString("Calle"));
//                us.setNumeroInt(rs.getInt("NumeroInt"));
//                us.setNumeroExt(rs.getInt("NumeroExt"));
//                us.setColonia(rs.getString("Colonia"));
//                us.setPoblacion(rs.getString("Poblacion"));
//                us.setEstado(rs.getString("Estado"));
//                us.setPais(rs.getString("Pais"));
//                us.setHabilitado(rs.getInt("Habilitado"));
//                us.setCentro(rs.getString("centro"));
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error en metodobCargarDatosVisual ACC_Usuarios por " + e);
//        }
//        cnx.CerrarConexion(con);
//        return us;
//    }
//    public boolean ValidarUsuarioModVisual(String user) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        ResultSet rs;
//        String query = "SELECT Usuario FROM usuarios WHERE Usuario='" + user + "'";
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                String usuario = rs.getString("Usuario");
//                if (usuario.equals(user)) {
//                    cnx.CerrarConexion(con);
//                    return true;
//                } else {
//                    cnx.CerrarConexion(con);
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error en metodo VaidarUsuarioModVisual (ACC_Usuario) por:" + e);
//        }
//        cnx.CerrarConexion(con);
//        return false;
//    }
//    public LinkedList<usuarios> ConsultaMatchUsuario(String query) {
//        LinkedList<usuarios> usua = new LinkedList<>();
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        ResultSet rs;
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            String q = query;
//            while (rs.next()) {
//                usuarios us = new usuarios();
//                us.setUsuario(rs.getString("Usuario"));
//                us.setNombre(rs.getString("Nombre"));
//                us.setApellidoPat(rs.getString("ApellidoPat"));
//                us.setApellidoMat(rs.getString("ApellidoMat"));
//                us.setRFC(rs.getString("RFC"));
//                us.setCorreo(rs.getString("Correo"));
//                us.setTelefono(rs.getString("Telefono"));
//                us.setTelefono2(rs.getString("Telefono2"));
//                us.setCalle(rs.getString("Calle"));
//                us.setNumeroInt(rs.getInt("NumeroInt"));
//                us.setNumeroExt(rs.getInt("NumeroExt"));
//                us.setColonia(rs.getString("Colonia"));
//                us.setPoblacion(rs.getString("Poblacion"));
//                us.setEstado(rs.getString("Estado"));
//                us.setPais(rs.getString("Pais"));
//                us.setHabilitado(rs.getInt("Habilitado"));
//                us.setCentro(rs.getString("centro"));
//                usua.add(us);
//            }
//        } catch (Exception e) {
//            System.err.println("Error en metodo ConsultaMatchUsuario (ACC_Usuarios) " + e);
//        }
//        cnx.CerrarConexion(con);
//        return usua;
//    }
//
    public static void main(String[] args) {
        ACC_Usuarios u = new ACC_Usuarios();
        System.out.println(u.ListaUsuarioMC("ADMIN", 1));

    }
    public ArrayList<usuarios> ConsultarUsuarioNotTiemPP(){
        ArrayList<usuarios> us = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL PP.NotTiempo_ConsultarUsuariosPP}";
        try{
            ps = con.prepareStatement(proc);
            rs = ps.executeQuery();
            while(rs.next()){
                usuarios u = new usuarios();
                u.setUsuario(rs.getString("Usuario"));
                us.add(u);
            }
        }catch (Exception e) {
            System.err.println("Error en ConsultarUsuarios, ACC_Usuarios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return us;
    }    
}
