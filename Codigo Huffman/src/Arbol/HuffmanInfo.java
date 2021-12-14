/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Personal
 */
public class HuffmanInfo {
    private String simbolo;
    private Integer frecuencia;
    private Integer bit;

    public HuffmanInfo(String simbolo, Integer frecuencia, Integer bit) {
        this.simbolo = simbolo;
        this.frecuencia = frecuencia;
        this.bit = bit;
    }
    
    public HuffmanInfo(String simbolo,Integer frecuencia ) {
        this.simbolo = simbolo;
        this.frecuencia = frecuencia;
        this.bit = null;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setBit(Integer bit) {
        this.bit = bit;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public Integer getBit() {
        return bit;
    }


    
}
