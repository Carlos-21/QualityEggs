/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.Conexion;


import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author winny
 */
public class ConexionArduino implements SerialPortEventListener{ 
    private PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final String PUERTO = "COM3";
    private static final int TIMEOUT = 2000;
    private static final int DATA_RATE = 9600;
    private JLabel mensaje;
    private JProgressBar barra;
    private int cantidad;

    public ConexionArduino(JLabel mensaje, JProgressBar barra, int cantidad) {
        this.mensaje = mensaje;
        this.barra = barra;
        this.cantidad = cantidad;
    }

    public void conectar(){
        try {
            ino.arduinoRXTX(PUERTO, DATA_RATE, this);
        } catch (ArduinoException ex) {
            //
        }
    }
    
    public void enviarDato(String dato){
        try{
            ino.sendData(dato);
        } catch (ArduinoException | SerialPortException ex) {
            //
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            if (ino.isMessageAvailable()) {
                String texto = ino.printMessage();
                int cant = Integer.parseInt(texto);
                int porcentaje = (cant/cantidad)*100;
                mensaje.setText(porcentaje + "%");
                barra.setValue(porcentaje);
            }
        } catch (SerialPortException | ArduinoException ex) {
            //
        }
    }

}
