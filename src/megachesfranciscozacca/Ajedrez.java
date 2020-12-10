/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachesfranciscozacca;

import java.net.URISyntaxException;

/**
 *
 * @author franc
 */
public class Ajedrez {

    public static void main(String[] args) throws URISyntaxException {
        
        Cliente cliente = Cliente.getCliente();
        
        cliente.connect();
    }

}
