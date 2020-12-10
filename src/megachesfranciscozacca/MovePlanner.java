/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachesfranciscozacca;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;
import megaches.elementos.Pieza;
import megaches.elementos.Tablero;
import megachessfranciscozacca.elementos.piezas.Peon;
import megachessfranciscozacca.elementos.piezas.Reina;
public class MovePlanner {
    private static MovePlanner movePlanner;

    private Tablero tablero = new Tablero();

    private Pieza pieza;

    private Map movement = new HashMap();

    private MovePlanner() {
    }

    public static MovePlanner getMovePlanner() {
        if (movePlanner == null) {
            movePlanner = new MovePlanner();
        }
        return movePlanner;
    }

    public Map plan(String tablero, String color) {
        System.out.println("EL COLOR: ".concat(color));
        this.tablero.mapearTablero(tablero);
        selectPieza(color);
        this.movement.put("from_row", this.pieza.getRowPos());
        this.movement.put("from_col", this.pieza.getColPos());
        this.movement.put("to_row", this.pieza.getRowDest());
        this.movement.put("to_col", this.pieza.getColDest());
        return movement;
    }

    private void selectPieza(String color) {

        boolean f = false;

        this.pieza = null;

        if(buscarReina(color)){
            return;
        } else if(buscarPeon(color)) {
            return;
        }

    }

    public boolean buscarReina(String color) {
        if (color.equals("white")) {
            return this.buscarPiezaBlanca('Q');
        } else {
            return this.buscarPiezaNegra('q');
        }
    }

    public boolean buscarPeon(String color) {
        if (color.equals("white")) {
            return this.buscarPiezaBlanca('P');
        } else {
            return this.buscarPiezaNegra('p');
        }
    }

    public boolean buscarPiezaBlanca(char c) {

        boolean found = false;

        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                if (this.tablero.getCuadricula()[i][j] == c) {
                    switch (c) {
                        case 'P':
                            this.pieza = new Peon(this.tablero);
                            break;
                        case 'Q':
                            this.pieza = new Reina(this.tablero);
                            break;
                    }
                    this.pieza.setColor("white");
                    this.pieza.setRowPos(i);
                    this.pieza.setColPos(j);
                    if (this.pieza.seek()) {
                        found = true;
                        return true;
                    } else if (this.pieza.canMove()) {
                        this.pieza.setMove();
                        found = true;
                        return true;
                    }
                }
            }

        }
        pieza = null;
        return false;
    }

    public boolean buscarPiezaNegra(char c) {

        boolean found = false;

        for (int i = 15; i >= 0; i--) {
            for (int j = 0; j <= 15; j++) {
                if (this.tablero.getCuadricula()[i][j] == c) {

                    switch (c) {
                        case 'p':
                            this.pieza = new Peon(this.tablero);
                            break;
                        case 'q':
                            this.pieza = new Reina(this.tablero);
                            break;
                    }

                    this.pieza.setColor("black");
                    this.pieza.setRowPos(i);
                    this.pieza.setColPos(j);
                    if (this.pieza.seek()) {
                        found = true;
                        return true;
                    } else if (this.pieza.canMove()) {
                        this.pieza.setMove();
                        found = true;
                        return true;
                    }
                }
            }
        }
        pieza = null;
        return false;
    }
}
