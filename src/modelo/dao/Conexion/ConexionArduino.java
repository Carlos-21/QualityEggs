/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.Conexion;

import gnu.io.CommPortIdentifier;
import static java.awt.TrayIcon.MessageType.ERROR;
import java.io.OutputStream;
import java.util.Enumeration;
import gnu.io.SerialPort;
import javax.swing.JFrame;

/**
 *
 * @author winny
 */
public class ConexionArduino {
    private JFrame vista;
    private OutputStream output = null;
    SerialPort serialPort;
    private static final String PUERTO = "COM3";
    private static final int TIMEOUT = 2000;
    private static final int DATA_RATE = 9600;

    public ConexionArduino(JFrame vista) {
        this.vista = vista;
    }

}
