package Drivers;

import Entities.*;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AluguelDriver {
    @Test 
    public void getDataTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals("11/11/1111", aluguel.getData());
    }
    
    @Test 
    public void setDataTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        aluguel.setData("22/22/2222");

        assertEquals("22/22/2222", aluguel.getData());
    }
    
    @Test 
    public void getPeriodoTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals(5, aluguel.getPeriodo());
    }
    
    @Test 
    public void setPeriodoTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        aluguel.setPeriodo(8);

        assertEquals(8, aluguel.getPeriodo());
    }
    
    @Test 
    public void getCpfTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals("111.111.111-11", aluguel.getCpf());
    }
    
    @Test 
    public void setCpfTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        aluguel.setCpf("222.222.222-22");

        assertEquals("222.222.222-22", aluguel.getCpf());
    }
    
    @Test 
    public void getNomeTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals("NomeTeste", aluguel.getNome());
    }
    
    @Test 
    public void setNomeTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        aluguel.setNome("Neymar Júnior");

        assertEquals("Neymar Júnior", aluguel.getNome());
    }
    
    @Test 
    public void getValorFinalTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals(50, aluguel.getValorFinal());
    }
    
    @Test 
    public void setValorFinalTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        aluguel.setValorFinal(60);

        assertEquals(60, aluguel.getValorFinal());
    }
    
    @Test 
    public void getAlugavelTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        assertEquals(alugavel, aluguel.getAlugavel());
    }
    
    @Test 
    public void setAlugavelTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        Alugavel novoAlugavel = new Alugavel();
        novoAlugavel.setNome("TesteDeAlugavel");
        
        aluguel.setAlugavel(novoAlugavel);

        assertNotEquals(new Alugavel(), aluguel.getAlugavel());
        assertEquals(novoAlugavel, aluguel.getAlugavel());
    }

    @Test
    public void calculaValorTotalTeste(){
        Alugavel alugavel = new Alugavel();
        Aluguel aluguel = new Aluguel("11/11/1111", 5, "111.111.111-11", "NomeTeste", alugavel);
        
        alugavel.setPrecoDiario(100);

        assertEquals(5 * 100, aluguel.calculaValorTotal());

        aluguel.setPeriodo(8);

        assertEquals((8 * 100) * 0.9, aluguel.calculaValorTotal());
    }

    @Test
    public void gerarDescricaoTeste(){
        Alugavel alugavel = new Alugavel(10, "TesteNome", 50, "TesteMarca", "TesteModelo");
        Aluguel aluguel = new Aluguel("11/11/1111", 8, "111.111.111-..", "TesteNome", alugavel);
        String data = "Codigo do Item: " + alugavel.getCodigo() + "\nData: " + aluguel.getData() + "\nPeríodo: " + aluguel.getPeriodo() + " dias\nCPF: " + aluguel.getCpf() + "\nNome: " + aluguel.getNome() + "\nValor Final: " + aluguel.getValorFinal();
        
        assertEquals(data, aluguel.gerarDescricao());
    }
}