/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachesfranciscozacca;

import com.google.gson.Gson;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

/**
 *
 * @author franc
 */
public class Cliente extends WebSocketClient {

    private static final String AUTH_TOKEN = "ea0a8411-3eca-4489-bf68-bf27b777676f";
    private static final String HOST = "ws://megachess.herokuapp.com/service?authtoken=" + AUTH_TOKEN; //Host para la conexión
    private static Cliente cliente;
    private ResponseProcessor responseProcessor = ResponseProcessor.getResponseProcessor();

    /*
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
     */
    private Cliente(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    private Cliente(URI serverURI) throws URISyntaxException {
        super(serverURI);
    }

    public static Cliente getCliente() throws URISyntaxException {
        if (cliente == null) {
            cliente = new Cliente(new URI(HOST));
        }
        return cliente;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {

        System.out.println("el message: ".concat(message));
    
        
        Gson gson = new Gson();

        Map response = gson.fromJson(message, Map.class);

        try {
            // ResponseProcessor.procesar(response);
            responseProcessor.procesar(response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onMessage(ByteBuffer message) {
        System.out.println("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }
}
