/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachesfranciscozacca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class ResponseProcessor {
     private static final Gson gsonBuilder = new GsonBuilder().create();

    private static ResponseProcessor responseProcessor;

    private MovePlanner movePlanner = MovePlanner.getMovePlanner();

    private ResponseProcessor() {
    }

    public static ResponseProcessor getResponseProcessor() {
        if (responseProcessor == null) {
            responseProcessor = new ResponseProcessor();
        }
        return responseProcessor;
    }

    public void procesar(Map response) throws URISyntaxException {

        String outJson;

        switch (response.get("event").toString()) {
            case "update_user_list":
                System.out.println("LISTA DE USUARIOS ACTUALIZADA");
                break;
            case "ask_challenge":
                System.out.println("ACEPTAR DESAFIO");
                outJson = modelarAccept(response);
                ActionDispatcher.dispatch(outJson);
                break;
            case "your_turn":
                System.out.println("MI TURNO: ".concat(response.get("data").toString()));
                outJson = modelarMove(response);
                ActionDispatcher.dispatch(outJson);
                break;
            case "gameover":
                System.out.println("EL GAME ESTA OVER");
                break;
            default:
                System.out.println("EL DEFAULT: ".concat(response.get("event").toString()));
                break;
        }
    }

    public String modelarAccept(Map response) {

        Map incomingData = gsonBuilder.fromJson(response.get("data").toString(), Map.class);

        Map outObject = new HashMap();

        Map outData = new HashMap();

        outObject.put("action", "accept_challenge");

        outObject.put("data", outData);

        outData.put("board_id", incomingData.get("board_id").toString());

        return gsonBuilder.toJson(outObject);
    }

    public String modelarMove(Map response) {

        String jsonData = gsonBuilder.toJson(response.get("data"));

        Map incomingData = gsonBuilder.fromJson(jsonData, Map.class);

        Map outObject = new HashMap();

        Map outData = new HashMap();

        Map movement;

        outObject.put("action", "move");

        outObject.put("data", outData);

        outData.put("board_id", incomingData.get("board_id").toString());

        outData.put("turn_token", incomingData.get("turn_token").toString());

        movement = this.movePlanner.plan(incomingData.get("board").toString(), incomingData.get("actual_turn").toString());

        outData.putAll(movement);

        System.out.println("OUTOBJECT: ".concat(outObject.toString()));

        System.out.println("OUTOBJECT JSON: ".concat(gsonBuilder.toJson(outObject)));

        return gsonBuilder.toJson(outObject);

    }
}
