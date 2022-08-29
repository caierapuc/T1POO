package Entities;

import java.util.ArrayList;

public class Alugavel {
    private int codigo;
    private String nome;
    private double precoDiario;
    private String marca;
    private String modelo;
    private ArrayList<Aluguel> alugueis;
    
    public Alugavel() {
        this.codigo =  0;
        this.nome = "";
        this.precoDiario = 10.0;
        this.marca = "";
        this.modelo = "";
        this.alugueis = new ArrayList<Aluguel>();
    }

    public Alugavel(int codigo, String nome, double precoDiario, String marca, String modelo) {
        this.codigo =  codigo;
        this.nome = nome;
        this.precoDiario = precoDiario;
        this.marca = marca;
        this.modelo = modelo;
        this.alugueis = new ArrayList<Aluguel>();
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPrecoDiario(){
        return this.precoDiario;
    }

    public void setPrecoDiario(double precoDiario){
        this.precoDiario = precoDiario;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public ArrayList<Aluguel> getAlugueis(){
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis){
        this.alugueis = alugueis;
    }

    public void addAluguel(Aluguel aluguel){
        this.alugueis.add(aluguel);
    }

    public String gerarDescricao(){
        String descricao = "Código: " + this.codigo + "\nNome: " + this.nome + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nPreço Diário: " + this.precoDiario + "\n\n";
        if (this.alugueis.size() > 0){
            int contador = 1;
            for (Aluguel aluguel: this.alugueis){
                descricao += "Aluguel #" + contador + "\n";
                descricao += aluguel.gerarDescricao();
                descricao += "\n\n";
                
                contador++;
            }
        }

        return descricao;
    }
}
