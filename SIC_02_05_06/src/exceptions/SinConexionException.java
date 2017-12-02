/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.StreamingNotifiable;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import static javax.swing.JOptionPane.showMessageDialog;
//import com.mysql.jdbc.StreamingNotifiable;
//import java.sql.SQLRecoverableException;

/**
 *
 * @author Administrator
 */
public class SinConexionException extends CommunicationsException implements StreamingNotifiable {

    /**
     * Creates a new instance of <code>SinConexionException</code> without
     * detail message.
     */
    
    

    /**
     * Constructs an instance of <code>SinConexionException</code> with the
     * specified detail message.
     *
     * @param conn
     * @param lastPacketSentTimeMs
     * @param lastPacketReceivedTimeMs
     * @param underlyingException
     * @param msg the detail message.
     */
    //public SinConexionException(String msg) {
        //super(msg);
    //}

    public SinConexionException(ConnectionImpl conn, long lastPacketSentTimeMs, long lastPacketReceivedTimeMs, Exception underlyingException) {
        super(conn, lastPacketSentTimeMs, lastPacketReceivedTimeMs, underlyingException);
        showMessageDialog(null, "Error");
    }

    /**
     * Creates a new instance of <code>SinConexionException</code> without
     * detail message.
     */
    
    

    /**
     * Constructs an instance of <code>SinConexionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    //public SinConexionException(String msg) {
        //super(msg);
    //}
}
