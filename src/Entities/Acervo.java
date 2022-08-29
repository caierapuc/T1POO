package Entities;

import java.util.ArrayList;

public class Acervo {
    private ArrayList<Alugavel> acervo;

    public Acervo() {
        this.acervo = new ArrayList<Alugavel>();
    }

    public ArrayList<Alugavel> getAcervo(){
        return (ArrayList<Alugavel>)acervo.clone();
    }

    public boolean adicionaAlugavel(Alugavel alugavel){
        boolean success = true;

        for (Alugavel item: this.acervo){
            if (item.getCodigo() == alugavel.getCodigo())
                success = false;
        }

        if (success)
            this.acervo.add(alugavel);

        return success;
    }

    public Alugavel pesquisaAlugavel(int codigo){
        Alugavel retorno = null;

        for (Alugavel alugavel: acervo){
            if (alugavel.getCodigo() == codigo)
                retorno = alugavel;
        }

        return retorno;
    }

    public ArrayList<Alugavel> pesquisaAlugavel(String nome){
        ArrayList<Alugavel> retorno = (ArrayList<Alugavel>)acervo.clone();

        retorno.removeIf(x -> !x.getNome().equals(nome));

        return retorno.isEmpty() ? null : retorno;
    }

    public String gerarLista(){
        String lista = "";
        int contador = 1;
        int contadorAlugueis = 1;

        for (Alugavel item: acervo){
            lista += "Alugável #" + contador + "\n";
            lista += item.gerarDescricao();
            lista += "\n\n";

            contador++;
        }

        return lista;
    }
}
