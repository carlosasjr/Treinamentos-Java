/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Carlos-TP
 */
public class Romaria {
    
    private int codigo;

    private int quantidadeCasais;
    private int quantidadeSolteiros;
    private int quantidadeCriancas;
    
    private Lider lider;
    private Romaria romaria;

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    
    
    public Lider getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }

    public Romaria getRomaria() {
        return romaria;
    }

    public void setRomaria(Romaria romaria) {
        this.romaria = romaria;
    }    
        

    public int getQuantidadeCasais() {
        return quantidadeCasais;
    }

    public void setQuantidadeCasais(int quantidadeCasais) {
        this.quantidadeCasais = quantidadeCasais;
    }

    public int getQuantidadeSolteiros() {
        return quantidadeSolteiros;
    }

    public void setQuantidadeSolteiros(int quantidadeSolteiros) {
        this.quantidadeSolteiros = quantidadeSolteiros;
    }

    public int getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public void setQuantidadeCriancas(int quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
    }
    
    
    
    
}
