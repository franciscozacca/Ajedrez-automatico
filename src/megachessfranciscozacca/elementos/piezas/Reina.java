/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megachessfranciscozacca.elementos.piezas;

import megaches.elementos.Pieza;
import megaches.elementos.Tablero;

public class Reina extends Pieza {

    public Reina(Tablero tablero) {
        super();
        this.tablero = tablero;
    }

    @Override
    public void setMove() {
        this.seek();
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean seek() {

        try {
            for (int i = (rowPos); i <= 0; i--) {

                if (this.color.equals("white")) {
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos - i][this.colPos] >= 'A' && tablero.getCuadricula()[this.rowPos - i][this.colPos] <= 'Z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos - i][this.colPos] >= 'a' && tablero.getCuadricula()[this.rowPos - i][this.colPos] <= 'z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos - i;
                        this.colDest = this.colPos;
                        return true;
                    }

                }

            }
            for (int i = (colPos); i == 0; i--) {
                if (this.color.equals("white")) {
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos][this.colPos - i] >= 'A' && tablero.getCuadricula()[this.rowPos][this.colPos - i] <= 'Z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos][this.colPos - i] >= 'a' && tablero.getCuadricula()[this.rowPos][this.colPos - i] <= 'z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos;
                        this.colDest = this.colPos - i;
                        return true;
                    }

                }
            }
            for (int i = (colPos); i <= 15; i++) { //para que se mueva a la derecha 
                if (this.color.equals("white")) {
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos][this.colPos + i] >= 'A' && tablero.getCuadricula()[this.rowPos][this.colPos + i] <= 'Z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos][this.colPos + i] >= 'a' && tablero.getCuadricula()[this.rowPos][this.colPos + i] <= 'z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos;
                        this.colDest = this.colPos + i;
                        return true;
                    }

                }
            }
            for (int i = (rowPos); i <= 0; i++) { //mover de forma vertical

                if (this.color.equals("black")) {
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos + i][this.colPos] >= 'a' && tablero.getCuadricula()[this.rowPos + i][this.colPos] <= 'z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos + i][this.colPos] >= 'A' && tablero.getCuadricula()[this.rowPos + i][this.colPos] <= 'Z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos + i;
                        this.colDest = this.colPos;
                        return true;
                    }
                }
            }

            for (int i = (colPos); i <= 14; i++) { //mover a la derecha
                if (this.color.equals("black")) {
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos][this.colPos + i] >= 'a' && tablero.getCuadricula()[this.rowPos][this.colPos + i] <= 'z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos][this.colPos + i] >= 'A' && tablero.getCuadricula()[this.rowPos][this.colPos + i] <= 'Z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos;
                        this.colDest = this.colPos + i;
                        return true;
                    }
                }
            }
            for (int i = (colPos); i == 15; i--) {
                if (this.color.equals("black")) { //mover a la izquierda
                    System.out.println("EL COLOR");

                    if (tablero.getCuadricula()[this.rowPos][this.colPos - i] >= 'a' && tablero.getCuadricula()[this.rowPos][this.colPos - i] <= 'z') {
                        return false;
                    } else if (tablero.getCuadricula()[this.rowPos][this.colPos - i] >= 'A' && tablero.getCuadricula()[this.rowPos][this.colPos - i] <= 'Z') {
                        System.out.println("TRUE");
                        this.rowDest = this.rowPos;
                        this.colDest = this.colPos - i;
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR EN BUSQUEDA REINA");
            return false;
        }
        return false;
    }

//    public boolean haciaDerecha() {
//        int fromCol = 0;
//        int fromRow = 0;
//
//        for (int i = fromCol; i = < 15;i++){
////            if (isEnemy()) {
////                return false;
//////                break;
////            }
////            if (aliado()) {
////                return false;
//////                break;
////            }
//        }
//
//        int toCol = 15;
//        int toRow = fromRow;
//
//        return true;
//
//    }
}
