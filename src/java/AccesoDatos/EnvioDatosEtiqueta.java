/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.net.*;
import java.io.*;

/**
 *
 * @author music
 */
public class EnvioDatosEtiqueta {

    final int port = 2500;
    Socket socket;
    DataOutputStream salida;
    DataInputStream entrada;

    public String EnviarDatosSocket(String datos, String IP) {
        String res = "0";
        try {
            Socket sc = new Socket(IP, port);
            salida = new DataOutputStream(sc.getOutputStream());
            salida.writeUTF(datos);
            entrada = new DataInputStream(sc.getInputStream());
            res = (String) entrada.readUTF();
            System.out.println(res);
        } catch (Exception e) {
        }
        return res;
    }

}
