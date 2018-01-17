///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package AccesoDatos;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import testiventws.TestIventWS;
//
///**
// *
// * @author Panda
// */
//public class CallWS {
//
//    private static CallWS Instance = null;
//
//    public static CallWS ObtenerInstancia() {
//        if (Instance == null) {
//            Instance = new CallWS();
//        }
//        return Instance;
//    }
//
//    public String ConsumirWS311(String folio, String material, String des, String almacen, String centro, String cantidad) {
//        Conexion cnx = new Conexion();
//        String[] data = cnx.CargarDatos();
//        String rq = "", wh, ag, can;
//        String msj = "";
//        String fecha = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
//        String hora = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
//        can = CallWS.ObtenerInstancia().ConvertUMMaterial(material, cantidad);
//        wh = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(almacen, centro);
//        ag = ACC_Almacenes.ObtenerInstancia().verificaIventWH(almacen, centro);
//        try {
//            TestIventWS ws = new TestIventWS();
//            msj = ws.CallWS(material, Double.parseDouble(can), wh, 0.0, ag, data[5]);
//
//        } catch (Exception e) {
//            msj = "No-Enviado";
//        }
//        String dt[] = {folio, material, des, cantidad, can, ag, wh, fecha, hora, msj};
//        CallWS.ObtenerInstancia().GuardarLogIvend(dt);
//        return msj;
//    }
//
//    public String EnviaWS311(String[][] data, String folio, String lang, String mov, String fecha, String hora) {
//        String rq = "", wh, ag;
//        try {
//            for (int i = 0; i < data.length; i++) {
//                wh = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(data[i][5], data[i][3]);
//                ag = ACC_Almacenes.ObtenerInstancia().verificaIventWH(data[i][5], data[i][3]);
//                if (!wh.trim().equals("")) {
//                    String des = ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(data[i][2], lang);
//                    TestIventWS ws = new TestIventWS();
//
////                    String msj = ws.CallWS(data[i][2], Double.parseDouble(data[i][1]), wh, 0.0, ag);
////                    String msj = ws.CallWS(data[i][2], Double.parseDouble(data[i][1]), wh, 0.0, ag) + " "
////                        + " Quantity: " + Double.parseDouble(data[i][1]) + "  Wharehouse: " + wh;
////                    rq+=msj + "\n";
//                    Consultas.ObtenerInstancia().reporte_ivent(i + "", folio, data[i][2], des, data[i][1], "", mov, fecha, hora, data[i][5]);
//
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e);
//        }
//        return rq;
//    }
//
//    public String EnviaWS312(String[][] data, String folio, String lang, String mov, String fecha, String hora) {
//        String rq = "", wh, ag;
//        try {
//            for (int i = 0; i < data.length; i++) {
//                wh = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(data[i][4], data[i][3]);
//                ag = ACC_Almacenes.ObtenerInstancia().verificaIventWH(data[i][5], data[i][3]);
//                if (!wh.trim().equals("")) {
//                    String des = ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(data[i][2], lang);
//                    TestIventWS ws = new TestIventWS();
//
////                    String msj = ws.CallWS(data[i][2], 0.0, wh, Double.parseDouble(data[i][1]), ag) + " "
////                            + " Quantity: " + Double.parseDouble(data[i][1]) + "  Wharehouse: " + wh;
////                    rq += msj + "\n";
////                    Consultas.ObtenerInstancia().reporte_ivent(i + "", folio, data[i][2], des, data[i][1], msj, mov, fecha, hora, data[i][4]);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e);
//        }
//        return rq;
//    }
//
//    public String ConvertUMMaterial(String material, String cantidad) {
//        String can = "";
//        String num1 = "";
//        String num2 = "";
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "{Call MM.ConverirUMIvend(?)}";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, material);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                num1 = rs.getString("numerador_conversion_ub");
//                num2 = rs.getString("numerador_conversion_um_base");
//                Double mcan = Double.parseDouble(cantidad) * Double.parseDouble(num2);
//                Double cant = mcan / Double.parseDouble(num1);
//                can = String.valueOf(cant);
//            } else {
//                can = cantidad;
//            }
//
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        return can;
//    }
//
//    public void GuardarLogIvend(String data[]) {
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        PreparedStatement ps = null;
//        String sql = "{call  MM.Ivend_InsertarLogIvend(?,?,?,?,?,?,?,?,?,?)}";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, data[0]);
//            ps.setString(2, data[1]);
//            ps.setString(3, data[2]);
//            ps.setString(4, data[3]);
//            ps.setString(5, data[4]);
//            ps.setString(6, data[5]);
//            ps.setString(7, data[6]);
//            ps.setString(8, data[7]);
//            ps.setString(9, data[8]);
//            ps.setString(10, data[9]);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.err.println(e);
//        } finally {
//            cnx.CerrarConexion(con);
//        }
//    }
//}
