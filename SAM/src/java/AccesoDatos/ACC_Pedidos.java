package AccesoDatos;

import Entidades.pedido_detalle;
import Entidades.pedido_historial;
import Entidades.pedido_servicios;
import Entidades.pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Pedidos {

    private static ACC_Pedidos Instance = null;

    public static ACC_Pedidos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pedidos();
        }
        return Instance;
    }

    public ArrayList<pedido_detalle> ConsultarMCPedidos(String Ped, String Solp, String SAM, int Ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_detalle> pd = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.PedidosEstandar_ConsultaMCPedidos(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Ped);
            ps.setString(2, Solp);
            ps.setString(3, SAM);
            ps.setInt(4, Ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setFolio_sam(rs.getString("folio_sam_solped"));
                pd.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pd;
    }

    public String cantidad(String pedido, String pos) {
        String ct = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.ObtenerCantidadPedidosDetalle_MOM(?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, pedido);
            sp.setString(2, pos);

            rs = sp.executeQuery();
            while (rs.next()) {
                ct = rs.getString("cantidad_pedido");
            }
        } catch (Exception e) {
            System.err.println("Error por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ct;
    }

    public LinkedList<pedido_detalle> ConsultaPedidos(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setFolio_sam(rs.getString("folio_sam_solped"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaPedidos ACC_Orden ");
        }
        cnx.CerrarConexion(con);
        return ped;
    }

    public ArrayList<pedido_detalle> ConsultaPedidos(String PD, String PS, String CN) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_detalle> ped = new ArrayList<>();
        String n = "";
        String SP;
        PreparedStatement ps;
        ResultSet rs;
        if (!PS.equals("")) {

            for (int i = PS.length(); i < 5; i++) {
                n += "0";
            }
            n += PS;
        }
        Float val;
        try {
            SP = "{CALL MM.Movimientos_ConsultarPedidos(?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, PD);
            ps.setString(2, CN);
            ps.setString(3, n);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setMaterial(rs.getString("num_material"));
                p.setAlmacen(rs.getString("almacen"));
                p.setCantidad(rs.getString("cantidad"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setCentro(rs.getString("centro"));
                p.setTipo_doc_compras(rs.getString("tipo_doc_compras"));
                p.setClase_pedido(rs.getString("clase_pedido"));
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setDescripcion(rs.getString("texto_breve"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setFecha_entrega_posicion(rs.getString("fecha_entrega_posicion"));
                Float c1 = Float.parseFloat(p.getCantidad_pedido()) - Float.parseFloat(p.getCantidad()) - Float.parseFloat(p.getUltima_cantidad());
                if (c1 > 0.000) {
                    ped.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaPedidos " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ped;
    }

    public boolean ConsultaPedidoExiste(String PD, String CN) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String SP;
        PreparedStatement ps;
        ResultSet rs;
        try {
            SP = "{CALL MM.Movimientos_PedidoExistente(?,?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, PD);
            ps.setString(2, CN);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaPedidos " + e);
            return false;
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public ArrayList<pedido_detalle> ConsultaPedido(String numDoc, String fecha, String solpe, String folioSAM, int can) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_detalle> ped = new ArrayList<>();
        String query = "{call MM.pedidos_detalleMatch_MOM(?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, numDoc);
            sp.setString(2, fecha);
            sp.setString(3, solpe);
            sp.setString(4, folioSAM);
            sp.setInt(5, can);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setPedido(rs.getString("num_doc_compras"));
                p.setG_nombre(rs.getString("nombre"));
                p.setCentro(rs.getString("centro"));
                p.setNum_posicion(rs.getString("num_posicion_doc_compras"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setFolio_sam(rs.getString("folio_sam_solped"));
                p.setFecha_doc_compras(rs.getString("fecha_doc_compras"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ped;
    }

    public pedido_detalle ObtenerDatosCab(String queryc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        pedido_detalle p = new pedido_detalle();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryc);
            while (rs.next()) {
                p.setTipo_doc_compras(rs.getString("tipo_doc_compras"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setFecha_doc_compras(rs.getString("fecha_doc_compras"));
                p.setNombre(rs.getString("nombre"));
                p.setOrganizacion_compras(rs.getString("organizacion_compras"));
                p.setDenominacion_orga_compras(rs.getString("denominacion_orga_compras"));
                p.setGrupo_compras(rs.getString("grupo_compras"));
                p.setDenominacion_grupo_compras(rs.getString("denominacion_grupo_compras"));
                p.setSociedad(rs.getString("sociedad"));
                p.setDenominacion_sociedad(rs.getString("denominacion_sociedad"));
                p.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                p.setNum_material(rs.getString("num_material"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setFecha_entrega_posicion(rs.getString("fecha_entrega_posicion"));
                p.setCentro(rs.getString("centro"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_lote(rs.getString("num_lote"));
                p.setSolicitante(rs.getString("solicitante"));
                p.setNum_registro_info(rs.getString("num_registro_info"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                p.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                p.setGrupo_articulos(rs.getString("grupo_articulos"));
                p.setMaterial_utili_proveedor(rs.getString("material_utili_proveedor"));
                p.setNum_articulo_europeo(rs.getString("num_articulo_europeo"));
                p.setLote_proveedor(rs.getString("lote_proveedor"));
                p.setClase_pedido(rs.getString("clase_pedido"));
                p.setDenominacion_clase_doc_compras(rs.getString("denominacion_clase_doc_compras"));
                p.setNombre_pos(rs.getString("nombre_pos"));
                p.setNum_paquete(rs.getString("num_paquete"));
                p.setNum_subpaquete(rs.getString("num_subpaquete"));
                p.setClase_movimiento(rs.getString("clase_movimiento"));
                p.setCantidad(rs.getString("cantidad"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setGrupo_liberacion(rs.getString("grupo_liberacion"));
                p.setEstrategia_liberacion(rs.getString("estrategia_liberacion"));
                p.setInd_liberacion_doc_compras(rs.getString("ind_liberacion_doc_compras"));
                p.setEstado_liberacion(rs.getString("estado_liberacion"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosCab ACC_Pedidos por" + e);
        }
        cnx.CerrarConexion(con);
        return p;
    }

    public ArrayList<pedido_detalle> CargarTablaPedidoStandar(String pedido) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_detalle> pd = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.PedidoEstandar_CargarPedidosEstandar(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                p.setNum_material(rs.getString("num_material"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setFecha_entrega_posicion(rs.getString("fecha_entrega_posicion"));
                p.setCentro(rs.getString("centro"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_lote(rs.getString("num_lote"));
                p.setSolicitante(rs.getString("solicitante"));
                p.setNum_registro_info(rs.getString("num_registro_info"));
                p.setFolio_sam(rs.getString("folio_sam_solped"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                p.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                ///obtener Datos para cabecera
                p.setDenominacion_clase_doc_compras(rs.getString("denominacion_clase_doc_compras"));
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setFecha_doc_compras(rs.getString("fecha_doc_compras"));
                p.setNombre(rs.getString("nombre"));
                p.setOrganizacion_compras(rs.getString("organizacion_compras"));
                p.setDenominacion_orga_compras(rs.getString("denominacion_orga_compras"));
                p.setGrupo_compras(rs.getString("grupo_compras"));
                p.setDenominacion_grupo_compras(rs.getString("denominacion_grupo_compras"));
                p.setSociedad(rs.getString("sociedad"));
                p.setDenominacion_sociedad(rs.getString("denominacion_sociedad"));
                p.setGrupo_liberacion(rs.getString("grupo_liberacion"));
                p.setEstrategia_liberacion(rs.getString("estrategia_liberacion"));
                p.setInd_liberacion_doc_compras(rs.getString("ind_liberacion_doc_compras"));
                pd.add(p);
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(con);
        }
        return pd;
    }

    public pedido_detalle GetDataPos(String pedido, String pos) {
        pedido_detalle p = new pedido_detalle();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.PedidoEstandar_CargarPedidoPosicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setGrupo_articulos(rs.getString("grupo_articulos"));
                p.setMaterial_utili_proveedor(rs.getString("material_utili_proveedor"));
                p.setNum_articulo_europeo(rs.getString("num_articulo_europeo"));
                p.setLote_proveedor(rs.getString("lote_proveedor"));
                p.setNombre_pos(rs.getString("nombre_pos"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setSociedad(rs.getString("sociedad"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
            }
        } catch (Exception e) {
            System.err.println("Error en GetDataPos");
        } finally {
            cnx.CerrarConexion(con);
        }
        return p;
    }

    public boolean ValidarLibePed(String pedido) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ban = false;
        String sql = "MM.PedidoEstandar_ValidarLiberacionPedid(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarLibePed por  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public LinkedList<pedido_detalle> ObtenerPosPedidos(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<pedido_detalle>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setTipo_doc_compras(rs.getString("tipo_doc_compras"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setFecha_doc_compras(rs.getString("fecha_doc_compras"));
                p.setNombre(rs.getString("nombre"));
                p.setOrganizacion_compras(rs.getString("organizacion_compras"));
                p.setDenominacion_orga_compras(rs.getString("denominacion_orga_compras"));
                p.setGrupo_compras(rs.getString("grupo_compras"));
                p.setDenominacion_grupo_compras(rs.getString("denominacion_grupo_compras"));
                p.setSociedad(rs.getString("sociedad"));
                p.setDenominacion_sociedad(rs.getString("denominacion_sociedad"));
                p.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                p.setNum_material(rs.getString("num_material"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setFecha_entrega_posicion(rs.getString("fecha_entrega_posicion"));
                p.setCentro(rs.getString("centro"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_lote(rs.getString("num_lote"));
                p.setSolicitante(rs.getString("solicitante"));
                p.setNum_registro_info(rs.getString("num_registro_info"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                p.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                p.setGrupo_articulos(rs.getString("grupo_articulos"));
                p.setMaterial_utili_proveedor(rs.getString("material_utili_proveedor"));
                p.setNum_articulo_europeo(rs.getString("num_articulo_europeo"));
                p.setLote_proveedor(rs.getString("lote_proveedor"));
                p.setClase_pedido(rs.getString("clase_pedido"));
                p.setDenominacion_clase_doc_compras(rs.getString("denominacion_clase_doc_compras"));
                p.setNombre_pos(rs.getString("nombre_pos"));
                p.setNum_paquete(rs.getString("num_paquete"));
                p.setNum_subpaquete(rs.getString("num_subpaquete"));
                p.setClase_movimiento(rs.getString("clase_movimiento"));
                p.setCantidad(rs.getString("cantidad"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setGrupo_liberacion(rs.getString("grupo_liberacion"));
                p.setEstrategia_liberacion(rs.getString("estrategia_liberacion"));
                p.setInd_liberacion_doc_compras(rs.getString("ind_liberacion_doc_compras"));
                p.setEstado_liberacion(rs.getString("estado_liberacion"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setFolio_sam(rs.getString("folio_sam_solped"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerPosPedidos ACC_Pedidos por: " + e);
        }
        cnx.CerrarConexion(con);
        return ped;
    }

    public ArrayList<pedido_servicios> ObtenerServiciosPedido(String ped, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_servicios> ps = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "{CALL MM.PedidoEstandar_GetPosPedServ(?,?)}";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, ped);
            pst.setString(2, pos);
            rs = pst.executeQuery();
            while (rs.next()) {
                pedido_servicios p = new pedido_servicios();
                p.setNum_linea(rs.getString("num_linea"));
                p.setNum_servicio(rs.getString("num_servicio"));
                p.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setPrecio_bruto(rs.getString("precio_bruto"));
                p.setClave_moneda(rs.getString("clave_moneda"));
                p.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                p.setPedido_cantidad_entrada(rs.getString("pedido_cantidad_entrada"));
                p.setNum_orden(rs.getString("num_orden"));
                ps.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerServiciosPedido por " + e);
        }
        cnx.CerrarConexion(con);
        return ps;
    }

    public ArrayList<pedido_historial> CargarPedidoHistorial(String ped, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<pedido_historial> ph = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.PedidoEstandar_CargarHistorialPed(?, ?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_historial p = new pedido_historial();
                p.setTipo_historial_pedido(rs.getString("tipo_historial_pedido"));
                p.setClase_movimiento(rs.getString("clase_movimiento"));
                p.setNum_doc_material(rs.getString("num_doc_material"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                p.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_base2(rs.getString("unidad_medida_base2"));
                ph.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarPedidoHistorial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ph;
    }

    public LinkedList<pedido_historial> Cargartablahistorial(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_historial> pd = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pedido_historial p = new pedido_historial();
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                p.setNum_material(rs.getString("num_material"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setTipo_historial_pedido(rs.getString("tipo_historial_pedido"));
                p.setClase_movimiento(rs.getString("clase_movimiento"));
                p.setNum_doc_material(rs.getString("num_doc_material"));
                p.setNum_apunte_contable(rs.getString("num_apunte_contable"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUnidad_medida_base2(rs.getString("unidad_medida_base2"));
                p.setFecha_entrega_posicion(rs.getString("fecha_entraga_posicion"));
                p.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                pd.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en Cargartablahistorial en ACC_Pedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pd;
    }

    public boolean ExistPosServicio(String Ped) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.PedidoEstandar_VerPedidoServ(?)}";
        boolean ban = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Ped);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ExistPosServicio en ACC_Pedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

//    public void VaciarTempt() {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        String query = "truncate table pedidos_detalle_temp";
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo verSolPed () por: " + e);
//        }
//        cnx.CerrarConexion(con);
//    }
//    public void GuardaTempt(String ps) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        String query = "delete from pedidos_detalle_temp where num_doc_compras='" + ps + "'";
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo verSolPed () por: " + e);
//        }
//        cnx.CerrarConexion(con);
//    }
//    public void MovimientoTempt(String ps) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        String query = "delete from pedidos_detalle_temp where tipo_mov<>'" + ps + "'";
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo verSolPed () por: " + e);
//        }
//        cnx.CerrarConexion(con);
//    }
//    public LinkedList<pedido_detalle> Ingresa200(pedido_detalle pd) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        LinkedList<pedido_detalle> ped = new LinkedList<>();
//
//        String query = "insert into pedidos_detalle_temp values ("
//                + "'', '',"
//                + "'', '', '', '', '', '',"
//                + "'','','','', '" + pd.getNum_posicion() + "', '','', '" + pd.getMaterial() + "',"
//                + "'" + pd.getDescripcion() + "' ,'',"
//                + "'" + pd.getUnidad_medida_base() + "',"
//                + "'', '" + pd.getCentro() + "', '','','','','','','','','',"
//                + "'', '',"
//                + "'','','','','','',"
//                + "'','" + pd.getCentro_coste() + "','','','','','','',"
//                + "'0','" + pd.getLote() + "','" + pd.getCantidad() + ".000',"
//                + "'" + pd.getTipo_mov() + "')";
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo por: " + e);
//        }
//        String query2 = "select * from pedidos_detalle_temp";
//
//        try {
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(query2);
//            while (rs.next()) {
//                pedido_detalle p = new pedido_detalle();
//                p.setMaterial(Integer.parseInt(rs.getString("num_material")) + "");
//                p.setCantidad(rs.getString("cantidad"));
//                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
//                p.setPor_recibir(rs.getString("por_recibir"));
//                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
//                p.setLote(rs.getString("num_lote"));
//                p.setNuevo_lote(rs.getString("nuevo_lote"));
//                p.setDescripcion(rs.getString("texto_breve"));
//                p.setNum_orden(rs.getString("num_orden"));
//                p.setCentro_coste(rs.getString("centro_coste"));
//                p.setCentro(rs.getString("centro"));
//                p.setClase_coste(rs.getString("clase_coste"));
//                p.setPedido(rs.getString("num_doc_compras"));
//                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
//                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
//                ped.add(p);
//            }
//        } catch (Exception ex) {
//            System.err.println("Error en metodo por: " + ex);
//        }
//        cnx.CerrarConexion(con);
//        return ped;
//    }
//    public LinkedList<pedido_detalle> ActualizaTempt(pedido_detalle pd) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        LinkedList<pedido_detalle> ped = new LinkedList<>();
//        String n = "";
//        for (int i = pd.getNum_posicion().length(); i < 5; i++) {
//            n += "0";
//        }
//        n += pd.getNum_posicion();
//        String query = "insert into pedidos_detalle_temp values ("
//                + "'" + pd.getTipo_doc_compras() + "', '" + pd.getPedido() + "',"
//                + "'" + pd.getNum_cuenta_proveedor() + "', '', '', '', '', '',"
//                + "'','','','', '" + n + "', '','', '" + pd.getMaterial() + "',"
//                + "'" + pd.getDescripcion() + "' ,'" + pd.getCantidad_pedido() + ".000',"
//                + "'" + pd.getUnidad_medida_base() + "',"
//                + "'', '" + pd.getCentro() + "', '','','','','','','','','',"
//                + "'" + pd.getNum_articulo_europeo() + "', '" + pd.getLote_proveedor() + "',"
//                + "'" + pd.getClase_pedido() + "','','','','','',"
//                + "'" + pd.getCantidad() + ".000','','','','','','','',"
//                + "'" + pd.getUltima_cantidad() + "','" + pd.getLote() + "','" + pd.getPor_recibir() + ".000',"
//                + "'" + pd.getTipo_mov() + "')";
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo por: " + e);
//        }
//        String query2 = "select * from pedidos_detalle_temp where num_doc_compras='" + pd.getPedido() + "'";
//        try {
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(query2);
//            while (rs.next()) {
//                Double val;
//                pedido_detalle p = new pedido_detalle();
//                try {
//                    p.setMaterial(Integer.parseInt(rs.getString("num_material")) + "");
//                } catch (Exception e) {
//                    p.setMaterial(rs.getString("num_material"));
//                }
//                val = Double.parseDouble(rs.getString("cantidad_pedido"));
//                p.setCantidad_pedido(val.intValue() + "");
//                p.setCantidad(rs.getString("cantidad"));
//                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
//                p.setPor_recibir(rs.getString("por_recibir"));
//                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
//                p.setLote(rs.getString("num_lote"));
//                p.setNuevo_lote(rs.getString("nuevo_lote"));
//                p.setDescripcion(rs.getString("texto_breve"));
//                p.setNum_orden(rs.getString("num_orden"));
//                p.setCentro_coste(rs.getString("centro_coste"));
//                p.setClase_coste(rs.getString("clase_coste"));
//                p.setPedido(rs.getString("num_doc_compras"));
//                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
//                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
//                ped.add(p);
//            }
//        } catch (Exception ex) {
//            System.err.println("Error en metodo por: " + ex);
//        }
//        cnx.CerrarConexion(con);
//        return ped;
//    }
//    public LinkedList<pedido_detalle> EliminaTempt(String v1, String v2) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        int l = 0;
//        LinkedList<pedido_detalle> ped = new LinkedList<>();
//        String n = "";
//        for (int i = v1.length(); i < 5; i++) {
//            n += "0";
//        }
//        n += v1;
//        String query = "";
//        switch (v2) {
//            case "101":
//            case "102":
//                query = "delete from pedidos_detalle_temp "
//                        + "WHERE num_posicion_doc_compras='" + n + "'";
//                break;
//            case "201":
//            case "202":
//                query = "delete from pedidos_detalle_temp "
//                        + "WHERE num_posicion_doc_compras='" + v1 + "'";
//                break;
//        }
//
//        try {
//            st = con.createStatement();
//            l = st.executeUpdate(query);
//        } catch (Exception e) {
//            System.err.println("Error en metodo por: " + e);
//        }
//        String query2 = "select * from pedidos_detalle_temp";
//        try {
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(query2);
//            while (rs.next()) {
//                Double val;
//                pedido_detalle p = new pedido_detalle();
//                try {
//                    p.setMaterial(Integer.parseInt(rs.getString("num_material")) + "");
//                } catch (Exception e) {
//                    p.setMaterial(rs.getString("num_material"));
//                }
//                try {
//                    val = Double.parseDouble(rs.getString("cantidad_pedido"));
//                    p.setCantidad_pedido(val.intValue() + "");
//                } catch (Exception e) {
//                }
//                p.setCantidad(rs.getString("cantidad"));
//                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
//                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
//                p.setLote(rs.getString("num_lote"));
//                p.setDescripcion(rs.getString("texto_breve"));
//                p.setNum_orden(rs.getString("num_orden"));
//                p.setCentro_coste(rs.getString("centro_coste"));
//                p.setClase_coste(rs.getString("clase_coste"));
//                p.setPedido(rs.getString("num_doc_compras"));
//                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
//                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
//                p.setPor_recibir(rs.getString("por_recibir"));
//                p.setNuevo_lote(rs.getString("nuevo_lote"));
//                ped.add(p);
//            }
//        } catch (Exception ex) {
//            System.err.println("Error en metodo por: " + ex);
//        }
//        cnx.CerrarConexion(con);
//        return ped;
//    }
    ////// MOVIMIENTOS
    public void GuardaTempt(String ps, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call BorrarMovMateriales_MOM(?,?)}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.setString(1, ps);
            pss.setString(2, us);
            pss.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en metodo verSolPed () por: " + e);
        }
        cnx.CerrarConexion(con);
    }
    public int VerificarRagistros(String us, String mov) {
        int c = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call verificarRegistros(?,?)}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.setString(1, us);
            pss.setString(2, mov);
            ResultSet rs = pss.executeQuery();

            while (rs.next()) {
                c++;
            }
        } catch (Exception e) {
            System.err.println("Error en metodo verSolPed () por: " + e);
        }
        cnx.CerrarConexion(con);
        return c;
    }
    
    

    public void VaciarTempt(String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call BorrarUsuario_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, us);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en metodo verSolPed () por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void MovimientoTempt(String pss, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call BorrarTipoMov_MOM(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pss);
            ps.setString(2, us);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en metodo verSolPed () por: " + e);
        }
        cnx.CerrarConexion(con);
    }

    public LinkedList<pedido_detalle> ActualizaTempt(pedido_detalle pd, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();
        String n = "";
        for (int i = pd.getNum_posicion().length(); i < 5; i++) {
            n += "0";
        }
        n += pd.getNum_posicion();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, pd.getTipo_doc_compras());
            sp.setString(2, pd.getPedido());
            sp.setString(3, pd.getNum_cuenta_proveedor());
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, n);
            sp.setString(14, pd.getTipo_imputacion());
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, pd.getCantidad_pedido());
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, pd.getCentro());
            sp.setString(22, pd.getAlmacen());
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, "");
            sp.setString(26, "");
            sp.setString(27, "");
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, pd.getNum_articulo_europeo());
            sp.setString(32, pd.getLote_proveedor());
            sp.setString(33, pd.getClase_pedido());
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, pd.getCantidad());
            sp.setString(40, pd.getCentro_coste());
            sp.setString(41, pd.getNum_orden());
            sp.setString(42, pd.getClase_coste());
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, pd.getUltima_cantidad());
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getPor_recibir());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();

            while (rs.next()) {
                Double val;
                pedido_detalle p = new pedido_detalle();
                try {
                    p.setMaterial(Integer.parseInt(rs.getString("num_material")) + "");
                } catch (Exception e) {
                    p.setMaterial(rs.getString("num_material"));
                }
                val = Double.parseDouble(rs.getString("cantidad_pedido"));
                p.setCantidad_pedido(val.intValue() + "");
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setLote_proveedor(rs.getString("lote_proveedor"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNum_articulo_europeo(rs.getString("num_articulo_europeo"));
                p.setAlmacen(rs.getString("almacen"));
                ped.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo por: " + ex);
        }
        cnx.CerrarConexion(con);
        return ped;
    }

    public LinkedList<pedido_detalle> EliminaTempt(String v1, String v2, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();
        String n = "", numDoc = "", posDoc = "", nn = "", centro = "";
        for (int i = v1.length(); i < 5; i++) {
            n += "0";
        }
        n += v1;
        String query = "";
        String query3 = "{call MM.SDetalles_doc_Mat_MOM(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query3);
            ps.setString(1, v1);
            ps.setString(2, us);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                numDoc = rs.getString("num_doc_compras");
                posDoc = rs.getString("num_cuenta_proveedor");
                centro = rs.getString("centro");
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo por: " + ex);
        }

        for (int i = posDoc.length(); i < 5; i++) {
            nn += "0";
        }
        nn += posDoc;
//        String tabla = "detalles_doc_materiales";
//        String campos = "status=''";
//        String condicion = "num_doc_material = '" + numDoc + "' and "
//                + "num_posicion_doc_compras = '" + nn + "' and "
//                + "centro = '" + centro + "' and "
//                + "clase_movimiento = '303'";
//        Consultas.ObtenerInstancia().Update(tabla, campos, condicion);

        try {
            query = "{call MM.DDetalles_doc_Mat_MOM(?,?)}";
            PreparedStatement ps = con.prepareStatement(query);
            switch (v2) {
                case "101":
                case "102":
                    ps.setString(1, n);
                    break;
                case "201":
                case "202":
                case "261":
                case "262":
                case "303":
                case "305":
                case "311":
                case "312":
                case "301":
                case "313":
                case "315":
                    ps.setString(1, v1);
                    break;
            }
            ps.setString(2, us);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        }
        String query2 = "{call MM.SU_mov_mat_MOM(?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query2);
            sp.setString(1, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                Double val;
                pedido_detalle p = new pedido_detalle();
                try {
                    p.setMaterial(Integer.parseInt(rs.getString("num_material")) + "");
                } catch (Exception e) {
                    p.setMaterial(rs.getString("num_material"));
                }
                try {
                    val = Double.parseDouble(rs.getString("cantidad_pedido"));
                    p.setCantidad_pedido(val.intValue() + "");
                } catch (Exception e) {
                }
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setNum_articulo_europeo(rs.getString("num_articulo_europeo"));
                p.setTipo_imputacion(rs.getString("tipo_imputacion"));
                p.setCentro(rs.getString("centro"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                ped.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo por: " + ex);
        }
        cnx.CerrarConexion(con);
        return ped;
    }

    public LinkedList<pedido_detalle> Ingresa200(pedido_detalle pd, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, "");
            sp.setString(2, "");
            sp.setString(3, "");
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, pd.getNum_posicion());
            sp.setString(14, "");
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, "");
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, pd.getCentro());
            sp.setString(22, "");
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, "");
            sp.setString(26, "");
            sp.setString(27, pd.getNum_posicion_solped());
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, "");
            sp.setString(32, "");
            sp.setString(33, "");
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, "");
            sp.setString(40, pd.getCentro_coste());
            sp.setString(41, "");
            sp.setString(42, "");
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, "0");
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getCantidad());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setMaterial(rs.getString("num_material"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setCentro(rs.getString("centro"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ped;
    }

    public LinkedList<pedido_detalle> Ingresa260(pedido_detalle pd, String us, String doc, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, "");
            sp.setString(2, "");
            sp.setString(3, "");
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, pd.getNum_posicion());
            sp.setString(14, "");
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, "");
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, pd.getCentro());
            sp.setString(22, "");
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, pos);
            sp.setString(26, doc);
            sp.setString(27, pd.getNum_posicion_solped());
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, "");
            sp.setString(32, "");
            sp.setString(33, "");
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, "");
            sp.setString(40, "");
            sp.setString(41, pd.getNum_orden());
            sp.setString(42, "");
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, "0");
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getCantidad());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setMaterial(rs.getString("num_material"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setCentro(rs.getString("centro"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                p.setNum_subpaquete(rs.getString("num_solped"));
                p.setNum_registro_info(rs.getString("num_registro_info"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ped;
    }

    public LinkedList<pedido_detalle> Ingresa300(pedido_detalle pd, String cd, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        int l = 0;
        LinkedList<pedido_detalle> ped = new LinkedList<>();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, "");
            sp.setString(2, pd.getNum_doc_compras());
            sp.setString(3, pd.getNum_cuenta_proveedor());
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, pd.getNum_posicion());
            sp.setString(14, "");
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, "");
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, cd);
            sp.setString(22, "");
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, "");
            sp.setString(26, "");
            sp.setString(27, "");
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, "");
            sp.setString(32, "");
            sp.setString(33, "");
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, "");
            sp.setString(40, "");
            sp.setString(41, "");
            sp.setString(42, "");
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, "0");
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getCantidad());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setMaterial(rs.getString("num_material"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setCentro(rs.getString("centro"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ped.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo por: " + ex);
        }
        cnx.CerrarConexion(con);
        return ped;
    }

    public LinkedList<pedido_detalle> Ingresa310(pedido_detalle pd, String us, String doc, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<pedido_detalle> ped = new LinkedList<>();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, "");
            sp.setString(2, "");
            sp.setString(3, "");
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, pd.getNum_posicion());
            sp.setString(14, "");
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, "");
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, pd.getCentro());
            sp.setString(22, pd.getAlmacen());
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, "");
            sp.setString(26, doc);
            sp.setString(27, pos);
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, "");
            sp.setString(32, "");
            sp.setString(33, "");
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, "");
            sp.setString(40, "");
            sp.setString(41, "");
            sp.setString(42, "");
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, "0");
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getCantidad());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setMaterial(rs.getString("num_material"));
                p.setCantidad(rs.getString("cantidad"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setLote(rs.getString("num_lote"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setCentro_coste(rs.getString("centro_coste"));
                p.setCentro(rs.getString("centro"));
                p.setClase_coste(rs.getString("clase_coste"));
                p.setPedido(rs.getString("num_doc_compras"));
                p.setNum_posicion(Integer.parseInt(rs.getString("num_posicion_doc_compras")) + "");
                p.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ped;
    }

    public boolean checkLiberacion(String PD, String PS, String CN, String AL) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String SP;
        PreparedStatement ps;
        ResultSet rs;
        try {
            SP = "{CALL MM.Movimientos_PedidoLiberacion(?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, PD);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("error en checkLiberacion por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean veriPediServ(String ped) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String SP;
        PreparedStatement ps;
        ResultSet rs;
        try {
            SP = "{CALL MM.Movimientos_PedidoExistenteServi(?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ped);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public static void main(String[] args) {
        ACC_Pedidos a = new ACC_Pedidos();
        int aa = a.CheckOrdenLibPedido("4500000001");
        System.out.println(aa);
    }

    public int CheckOrdenLibPedido(String pedido) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int res = 1;
        String ord = "";
        String SP;
        PreparedStatement ps;
        ResultSet rs;
        try {
            SP = "{CALL MM.Movimientos_PedidoOrdenLib(?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                ord = rs.getString("num_orden");
                if (!(ord.equals(""))) {
                    if (ordlib(ord)) {
                        res = 1;
                    } else {
                        res = 3;
                    }
                }

            }
        } catch (Exception e) {
            res = 1;
        } finally {
            cnx.CerrarConexion(con);
        }
        return res;
    }

    static boolean ordlib(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "{call PM.plan_ordenValida_MOM(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String a = rs.getString("status_sistema");
                String us = rs.getString("num_orden");
                if (a.substring(0, 4).equals("LIB.")) {
                    if (id.equals(us)) {
                        return true;
                    }
                } else {
                    return false;
                }

            }
            cnx.CerrarConexion(con);
        } catch (Exception E) {
            System.err.println("Error" + E);
        }
        return false;
    }
    public LinkedList<String> ObtenerProv(String pedido) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<String> prov = new LinkedList<>();

        String query = "{call MM.ObtenerProveedor(?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, pedido);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                prov.add(rs.getString("num_cuenta_proveedor"));
                prov.add(rs.getString("nombre1"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return prov;
    }
    public LinkedList<String> ObtenerSAM(String material, String centro, String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<String> sam = new LinkedList<>();

        String query = "{call MM.ObtenerDatosSAM(?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, material);
            sp.setString(2, centro);
            sp.setString(3, almacen);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                sam.add(rs.getString("grupo_articulos"));
                sam.add(rs.getString("descripcion"));
                sam.add(rs.getString("descripcion_ES"));
                sam.add(rs.getString("descripcion_EN"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    public String obtenerPos(String folio, String pos)
    {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sam = "";

        String query = "{call MM.PosicionPedido(?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, folio);
            sp.setString(2, pos);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                return rs.getString("num_posicion_doc_compras");
            }
        } catch (Exception e) {
            System.err.println("Error en metodo por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    public ArrayList<pedido_detalle> Ingresa30131315(pedido_detalle pd,  String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        int l = 0;
        ArrayList<pedido_detalle> ped = new ArrayList<>();

        String query = "{call TablaMovimientos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, "");
            sp.setString(2, "");
            sp.setString(3, "");
            sp.setString(4, "");
            sp.setString(5, "");
            sp.setString(6, "");
            sp.setString(7, "");
            sp.setString(8, "");
            sp.setString(9, "");
            sp.setString(10, "");
            sp.setString(11, "");
            sp.setString(12, "");
            sp.setString(13, pd.getNum_posicion());
            sp.setString(14, "");
            sp.setString(15, "");
            sp.setString(16, pd.getMaterial());
            sp.setString(17, pd.getDescripcion());
            sp.setString(18, "");
            sp.setString(19, pd.getUnidad_medida_base());
            sp.setString(20, "");
            sp.setString(21, pd.getCentro());
            sp.setString(22, pd.getAlmacen());
            sp.setString(23, "");
            sp.setString(24, "");
            sp.setString(25, "");
            sp.setString(26, pd.getNum_solped());
            sp.setString(27, pd.getNum_posicion_solped());
            sp.setString(28, "");
            sp.setString(29, "");
            sp.setString(30, "");
            sp.setString(31, "");
            sp.setString(32, "");
            sp.setString(33, "");
            sp.setString(34, "");
            sp.setString(35, "");
            sp.setString(36, "");
            sp.setString(37, "");
            sp.setString(38, "");
            sp.setString(39, "");
            sp.setString(40, "");
            sp.setString(41, "");
            sp.setString(42, "");
            sp.setString(43, "");
            sp.setString(44, "");
            sp.setString(45, "");
            sp.setString(46, "");
            sp.setString(47, "0");
            sp.setString(48, pd.getLote());
            sp.setString(49, pd.getCantidad());
            sp.setString(50, pd.getTipo_mov());
            sp.setString(51, us);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setNum_posicion(rs.getString("num_posicion_doc_compras"));
                p.setMaterial(rs.getString("num_material"));
                p.setDescripcion(rs.getString("texto_breve"));
                p.setUltima_cantidad(rs.getString("ultima_cantidad"));
                p.setPor_recibir(rs.getString("por_recibir"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                p.setNuevo_lote(rs.getString("nuevo_lote"));
                p.setCentro(rs.getString("centro"));
                p.setAlmacen(rs.getString("almacen"));
                p.setNum_solped(rs.getString("num_solped"));
                p.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                ped.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo por: " + ex);
        }
        cnx.CerrarConexion(con);
        return ped;
    }

}
