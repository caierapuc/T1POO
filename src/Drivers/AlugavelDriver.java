package Drivers;

import Entities.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class AlugavelDriver {

    @Test 
    public void getCodigoTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "Teste", "Teste");
        assertEquals(10, alugavel.getCodigo());
    }

    @Test 
    public void getNomeTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        assertEquals("TesteNome", alugavel.getNome());
    }

    @Test 
    public void getPrecoDiarioTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        assertEquals(500, alugavel.getPrecoDiario());
    }

    @Test 
    public void getMarcaTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        assertEquals("TesteMarca", alugavel.getMarca());
    }

    @Test 
    public void getModeloTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        assertEquals("TesteModelo", alugavel.getModelo());
    }

    @Test
    public void getAlugueisVazia(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        
        assertEquals(new ArrayList<Aluguel>(), alugavel.getAlugueis()); 
    }

    @Test
    public void addAndGetAlugueis(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        Aluguel aluguel = new Aluguel("00/00/0000", 10, "999.999.999-99", "TesteNomeAluguel", alugavel);
        alugavel.addAluguel(aluguel);

        ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
        resultado.add(aluguel);

        assertEquals(resultado, alugavel.getAlugueis()); 
    }

    @Test
    public void setCodigoTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");

        alugavel.setCodigo(11);

        assertEquals(11, alugavel.getCodigo());
    }

    @Test
    public void setNomeTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");

        alugavel.setNome("SetNomeTeste");

        assertEquals("SetNomeTeste", alugavel.getNome());
    }

    @Test
    public void setPrecoDiarioTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");

        alugavel.setPrecoDiario(1000.40);

        assertEquals(1000.40, alugavel.getPrecoDiario());
    }

    @Test
    public void setMarcaTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");

        alugavel.setMarca("SetMarcaTeste");

        assertEquals("SetMarcaTeste", alugavel.getMarca());
    }

    @Test
    public void setModeloTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");

        alugavel.setMarca("SetModeloTeste");

        assertEquals("SetModeloTeste", alugavel.getMarca());
    }

    @Test
    public void gerarDescricaoTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 500, "TesteMarca", "TesteModelo");
        Aluguel aluguel = new Aluguel("11/11/1111", 1, "111.111.111-11", "Neymar Junior", alugavel);
        alugavel.addAluguel(aluguel);
        
        assertEquals("Código: 10\nNome: TesteNome\nMarca: TesteMarca\nModelo: TesteModelo\nPreço Diário: 500.0\n\nAluguel #1\nCodigo do Item: 10\nData: 11/11/1111\nPeríodo: 1 dias\nCPF: 111.111.111-11\nNome: Neymar Junior\nValor Final: 500.0\n\n", alugavel.gerarDescricao());
    }
}
