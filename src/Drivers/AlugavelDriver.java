package Drivers;

import Entities.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.*;

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
}
