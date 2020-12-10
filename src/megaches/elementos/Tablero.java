/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaches.elementos;

/**
 *
 * @author franc
 */
public class Tablero {

    private char[][] cuadricula = new char[16][16];

    public char[][] getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(char[][] cuadricula) {
        this.cuadricula = cuadricula;
    }

    public void mapearTablero(String tablero) {
        char[] tableroArray = tablero.toCharArray();
        int x = 0;
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                this.cuadricula[i][j] = tableroArray[x];
                x++;
            }
        }
    }
    
}
