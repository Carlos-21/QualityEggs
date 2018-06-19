/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.Conexion;

import gnu.io.CommPortIdentifier;
import java.io.OutputStream;
import java.util.Enumeration;
import gnu.io.SerialPort;
import javax.swing.JOptionPane;

/**
 *
 * @author winny
 */
public class ConexionArduino {
    private OutputStream output = null;
    private SerialPort serialPort;
    private static final String PUERTO = "COM3";
    private static final int TIMEOUT = 2000;
    private static final int DATE_RATE = 9600;

    public void Conectar(){
        CommPortIdentifier puertoID = null;
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
    
        while(puertoEnum.hasMoreElements()){
            CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            if(PUERTO.equals(actualPuertoID.getName())){
                puertoID = actualPuertoID;
                break;
            }
        }
        
        if(puertoID == null){
            JOptionPane.showMessageDialog(null, "No se puedo conectar con arduino");
        }
        
        try{
            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
            serialPort.setSerialPortParams(DATE_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_2, SerialPort.PARITY_NONE);
            output = serialPort.getOutputStream();
        }catch(Exception e){
            
        }
    }
    
    public void enviarDatos(String datos){
        try{
            output.write(datos.getBytes());
        }catch(Exception e){
            System.out.println("error");
        }
    }
}
