package Entities;

import java.util.ArrayList;

public class Locacoes {
    private ArrayList<Aluguel> alugueis;

    public Locacoes() {
        this.alugueis = new ArrayList<Aluguel>();
    }

    public void adicionaAluguel(Aluguel aluguel){
        this.alugueis.add(aluguel);
    }

    public ArrayList<Aluguel> pesquisaAluguel(String cpf){
        ArrayList<Aluguel> retorno = (ArrayList<Aluguel>)this.alugueis.clone();

        retorno.removeIf(x -> !x.getCpf().equals(cpf));

        return retorno;
    }

    public String gerarLista(){
        String lista = "";
        int contador = 1;

        for (Aluguel item: alugueis){
            lista += "Aluguel #" + contador + "\n";
            lista += item.gerarDescricao();
            lista += "\n\n";

            contador++;
        }

        return lista;
    }
}
