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
public abstract class Pieza {

    protected String color;

    protected int colPos;

    protected int rowPos;

    protected int colDest;

    protected int rowDest;

    protected Tablero tablero;
    
    protected boolean equipo;
    
    abstract public void setMove();

    abstract public boolean canMove();
    
    abstract public boolean seek();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColPos() {
        return colPos;
    }

    public void setColPos(int colPos) {
        this.colPos = colPos;
    }

    public int getRowPos() {
        return rowPos;
    }

    public void setRowPos(int rowPos) {
        this.rowPos = rowPos;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getColDest() {
        return colDest;
    }

    public void setColDest(int colDest) {
        this.colDest = colDest;
    }

    public int getRowDest() {
        return rowDest;
    }

    public void setRowDest(int rowDest) {
        this.rowDest = rowDest;
    }
     public boolean isEquipo() {
        return equipo;
    }

    public void setEquipo(boolean equipo) {
        this.equipo = equipo;
    }
    

}
