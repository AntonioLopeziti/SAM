/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.entrada_servicios_crea;
import Entidades.pedido_historial;
import Entidades.pedido_servicios;
import Entidades.textos_entrada_servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_PedidoServicios {

    public static ACC_PedidoServicios Instance = null;

    public static ACC_PedidoServicios ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_PedidoServicios();
        }
        return Instance;
    }

    public ArrayList<pedido_servicios> CargarTablaServicios(String pedido, int posi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_servicios> pese = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String pr = "{CALL MM.PedidoServicios_CargarDatosEntradaServ(?,?)}";
        try {
            pst = con.prepareStatement(pr);
            pst.setString(1, pedido);
            pst.setInt(2, posi);
            rs = pst.executeQuery();
            while (rs.next()) {
                pedido_servicios ps = new pedido_servicios();
                ps.setId_ps(rs.getInt("id_ps"));
                ps.setNum_doc_compras(rs.getString("num_doc_compras"));
                ps.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                ps.setNum_linea(rs.getString("num_linea"));
                ps.setNum_servicio(rs.getString("num_servicio"));
                ps.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                ps.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                ps.setTexto_breve(rs.getString("texto_breve"));
                ps.setPrecio_bruto(rs.getString("precio_bruto"));
                ps.setClave_moneda(rs.getString("clave_moneda"));
                ps.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                ps.setPedido_cantidad_entrada(rs.getString("pedido_cantidad_entrada"));
                ps.setNum_orden(rs.getString("num_orden"));
                if (Float.parseFloat(ps.getPedido_cantidad_entrada()) < Float.parseFloat(ps.getCantidad_con_signo())) {
                    pese.add(ps);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error de Obtener Tabla: " + ex);
        }
        return pese;
    }

    public boolean InsertarEntradaServicio(entrada_servicios_crea en) {
        boolean ban = false;
        PreparedStatement ps = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String prco = "{call MM.EntradasServicio_InsertarEnSer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(prco);
            ps.setString(1, en.getFolio_sam());
            ps.setString(2, en.getNum_doc_compras());
            ps.setString(3, en.getNum_posicion_doc_compras());
            ps.setString(4, String.valueOf(en.getIndice_registro_no_valido()));
            ps.setString(5, en.getCentro());
            ps.setString(6, en.getNum_servicio());
            ps.setString(7, en.getCantidad());
            ps.setString(8, en.getTexto_breve());
            ps.setString(9, en.getPrecio_bruto());
            ps.setString(10, en.getCantidad_base());
            ps.setString(11, en.getFecha());
            ps.setString(12, en.getHora_dia());
            ps.setString(13, en.getPosicion_servicio());
            ps.setString(14, en.getTexto_documento());
            ps.setString(15, en.getTexto_referencia());
            ps.setString(16, en.getUsuario());
            ps.setString(17, en.getNota_calidad_prestacion());
            ps.setString(18, en.getNota_cumplim_prestacion());
            if (ps.executeUpdate()> 0) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en EntradaServicio por:  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean ActualizarCantidadPedidoSer(String Doc, String Pos, String Linea, String Serv, String Cantidad) {
        PreparedStatement ps = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String pro = "{CALL  MM.PedidosServicios_ActualizarCantidadPedSer(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(pro);
            ps.setString(1, Doc);
            ps.setString(2, Pos);
            ps.setString(3, Linea);
            ps.setString(4, Serv);
            ps.setString(5, Cantidad);
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ActualizarCantidadPedidoSer por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean InsertResgitroPedidoHistorial(pedido_historial p, String pos) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.PedidosServicios_InsertarPedidoHistorial(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNum_doc_compras());
            ps.setString(2, pos);
            ps.setString(3, p.getTexto_breve());
            ps.setString(4, p.getCantidad_pedido());
            ps.setString(5, p.getUnidad_medida_base());
            ps.setString(6, p.getNum_doc_material());
            ps.setString(7, p.getCantidad());
            ps.setString(8, p.getUnidad_medida_base2());
            ps.setString(9, p.getFecha_entrega_posicion());
            ps.setString(10, p.getFecha_contabilizacion_doc());
            ps.setString(11, p.getFolio_sam());
            if(ps.executeUpdate() == 1){
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertResgitroPedidoHistorial por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    
    public boolean InsertartextEntradaServicio(textos_entrada_servicios tes) {
        boolean ban = false;
        PreparedStatement ps = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String prco = "{CALL MM.textos_entrada_serviciosINSERT(?,?,?,?)}";
        try {
            ps = con.prepareStatement(prco);
            ps.setString(1, tes.getFolio_sam());
            ps.setString(2, tes.getContador_posicion());
            ps.setString(3, tes.getFormato());
            ps.setString(4, tes.getTexto());
            
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en EntradaServicio por:  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

//    public static void main(String[] args) {
//        String doccom = "4500000016";
//        String queryGetTabla = "SELECT * FROM pedido_servicios WHERE num_doc_compras = '" + doccom + "'";
//        LinkedList<pedido_servicios> pse = ACC_PedidoServicios.ObtenerInstancia().CargarTablaServicios(queryGetTabla);
//        String dato = pse.get(0).getPedido_cantidad_entrada();
//        String dato2 = pse.get(1).getPedido_cantidad_entrada();
//        double a = 0;
//        double b = 0;
//        a = Double.parseDouble(dato);
//        b = Double.parseDouble(dato2);
//        double result = a-b;
//        System.out.println("Resultado :" + result);
//    }
}
