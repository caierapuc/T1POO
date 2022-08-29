package Entities;

public class Aluguel {
    private String data;
    private int periodo;
    private String cpf;
    private String nome;
    private double valorFinal;
    private Alugavel alugavel;

    public Aluguel(String data, int periodo, String cpf, String nome, Alugavel alugavel){
        this.data = data;
        this.periodo = periodo;
        this.cpf = cpf;
        this.nome = nome;
        this.alugavel = alugavel;
        this.valorFinal =  this.calculaValorTotal();
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
    
    public void setPeriodo(int periodo){
        this.periodo = periodo;
    }
    
    public int getPeriodo(){
        return this.periodo;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setValorFinal(double valorFinal){
        this.valorFinal = valorFinal;
    }
    
    public double setValorFinal(){
        return this.valorFinal;
    }
    
    public double calculaValorTotal(){
        this.valorFinal = this.alugavel.getPrecoDiario() * this.periodo;

        if (periodo > 7)
            this.valorFinal *= 0.9;

        return this.valorFinal;
    }

    public String gerarDescricao(){
        return "Codigo do Item: " + alugavel.getCodigo() + "\nData: " + this.data + "\nPeríodo: " + this.periodo + " dias\nCPF: " + this.cpf + "\nNome: " + this.nome + "\nValor Final: " + this.valorFinal;
    }
}
