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

    final String IPHost = "192.168.0.9";
    final int port = 2500;
    Socket socket;
    DataOutputStream salida;
    DataInputStream entrada;

    public void EnviarDatosSocket(String datos) {
        try {
            Socket sc = new Socket(IPHost, port);
            salida = new DataOutputStream(sc.getOutputStream());
            salida.writeUTF(datos);
        } catch (Exception e) {
        }
    }

}
