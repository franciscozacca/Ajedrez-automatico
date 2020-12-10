/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachessfranciscozacca.elementos.piezas;

import megaches.elementos.Pieza;
import megaches.elementos.Tablero;
public class Peon extends Pieza {

    public Peon(Tablero tablero) {
        super();
        this.tablero = tablero;
    }

    @Override
    public void setMove() {

        if (this.color.equals("white")) {
            this.colDest = colPos;
            if (rowPos == 12 || rowPos == 13) {
                this.rowDest = rowPos - 2;
            } else {
                this.rowDest = rowPos - 1;
            }
        } else {
            this.colDest = colPos;
            if (rowPos == 2 || rowPos == 3) {
                this.rowDest = rowPos + 2;
            } else {
                this.rowDest = rowPos + 1;
            }
        }
    }

    @Override
    public boolean canMove() {
        if (this.color.equals("white")) {
            return tablero.getCuadricula()[rowPos - 1][colPos] == ' ';
        } else {
            return tablero.getCuadricula()[rowPos + 1][colPos] == ' ';
        }
    }

    @Override
    public boolean seek() {
        try {
            if (this.color.equals("white")) {
                if (tablero.getCuadricula()[rowPos - 1][colPos - 1] >= 'a' && tablero.getCuadricula()[rowPos - 1][colPos - 1] <= 'z') {
                    this.rowDest = rowPos - 1;
                    this.colDest = colPos - 1;
                    return true;
                } else if (tablero.getCuadricula()[rowPos - 1][colPos + 1] >= 'a' && tablero.getCuadricula()[rowPos - 1][colPos + 1] <= 'z') {
                    this.rowDest = rowPos - 1;
                    this.colDest = colPos + 1;
                    return true;
                }
            } else {
                if (tablero.getCuadricula()[rowPos + 1][colPos - 1] >= 'A' && tablero.getCuadricula()[rowPos + 1][colPos - 1] <= 'Z') {
                    this.rowDest = rowPos + 1;
                    this.colDest = colPos - 1;
                    return true;
                } else if (tablero.getCuadricula()[rowPos + 1][colPos + 1] >= 'A' && tablero.getCuadricula()[rowPos + 1][colPos + 1] <= 'Z') {
                    this.rowDest = rowPos + 1;
                    this.colDest = colPos + 1;
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;

    }
}
