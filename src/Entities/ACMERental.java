package Entities;

import java.util.Scanner;
import java.util.ArrayList;

public class ACMERental {
    private Acervo acervo;
    private Locacoes locacoes;
    private Scanner entrada;

    public ACMERental(){
        this.acervo = new Acervo();
        this.locacoes = new Locacoes();
        this.entrada = new Scanner(System.in);
    }

    public void preCadastra(){
        Alugavel alugavel = new Alugavel(1, "Projetor", 50, "LG", "SPLG1");
        Aluguel aluguel = new Aluguel("19/07/2022", 15,"111.111.111-11", "Neymar Junior", alugavel);
        alugavel.addAluguel(aluguel);
        this.acervo.adicionaAlugavel(alugavel);
        this.locacoes.adicionaAluguel(aluguel);

        alugavel = new Alugavel(2, "Notebook", 100, "Dell", "Inspiron 15");
        aluguel = new Aluguel("25/05/2022", 4,"111.111.111-11", "Neymar Junior", alugavel);
        alugavel.addAluguel(aluguel);
        this.acervo.adicionaAlugavel(alugavel);
        this.locacoes.adicionaAluguel(aluguel);

        alugavel = new Alugavel(3, "Caixa de Som", 150, "JBL", "BoomBox");
        aluguel = new Aluguel("22/04/2022", 3,"222.222.222-22", "Vinicius Junior", alugavel);
        alugavel.addAluguel(aluguel);
        this.locacoes.adicionaAluguel(aluguel);
        aluguel = new Aluguel("18/06/2022", 6,"333.333.333-33", "Richarlison", alugavel);
        alugavel.addAluguel(aluguel);
        this.locacoes.adicionaAluguel(aluguel);
        aluguel = new Aluguel("20/08/2022", 1,"444.444.444-44", "Gabriel Jesus", alugavel);
        alugavel.addAluguel(aluguel);
        this.locacoes.adicionaAluguel(aluguel);        
        this.acervo.adicionaAlugavel(alugavel);
    }

    public void executa(){
        int opcao = 0;
        do {
            System.out.println("=========================================\n");
            System.out.println("Opcoes:");
            System.out.println("[1] Mostrar todos os dados cadastrados.");
            System.out.println("[2] Pesquisar item alugável pelo código.");
            System.out.println("[3] Pesquisar itens alugáveis pelo nome.");
            System.out.println("[4] Pesquisar aluguéis de um cliente.");
            System.out.println("[0] Sair.");
            System.out.print("Digite a opção desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    this.mostrarTodosOsDados();
                    break;
                case 2:
                    this.pesquisarAlugavelPorCodigo();
                    break;
                case 3:
                    this.pesquisarAlugavelPorNome();
                    break;
                case 4:
                    this.pesquisarAlugueisDoCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao inválida.");
                }
        }
        while(opcao != 0);
    }

    //Mostrar todos os dados Cadastrados
    public void mostrarTodosOsDados(){
        if (acervo.getAcervo().isEmpty()){
            System.out.println("\n=========================================\n\nNenhum item alugável cadastrado no sistema.\n");
        }
        else{
            String lista = "";

            for (Alugavel item: acervo.getAcervo()){
                lista += item.gerarDescricao();
            }
            System.out.println("\n=========================================\n\n");
            System.out.println(lista);
        }
    }
    
    //Pesquisar item alugavel pelo codigo
    public void pesquisarAlugavelPorCodigo(){
        System.out.println("\n=========================================\n");
        System.out.print("Insira o código a ser buscado: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        Alugavel alugavel = this.acervo.pesquisaAlugavel(codigo);

        if (alugavel!= null)
            System.out.println("\n\n" + alugavel.gerarDescricao());
        else
            System.out.println("\n\n" + "Nenhum item alugável encontrado com este código." + "\n\n");
    }
    
    //Pesquisar itens alugaveis pelo nome
    public void pesquisarAlugavelPorNome(){
        System.out.println("\n=========================================\n");
        System.out.print("Insira o nome a ser buscado: ");
        String nome = entrada.nextLine();

        ArrayList<Alugavel> resultado = this.acervo.pesquisaAlugavel(nome);

        if (resultado == null || resultado.size() <= 0)
            System.out.println("\n\n" + "Nenhum item alugável encontrado com este nome." + "\n\n");
        else{
            for (Alugavel item: resultado){
                System.out.println("\n\n" + item.gerarDescricao());
            }
        }
    }

    //Pesquisar alugueis de um cliente
    public void pesquisarAlugueisDoCliente(){
        System.out.println("\n=========================================\n");
        System.out.print("Insira o CPF a ser buscado (000.000.000-00): ");
        String cpf = entrada.nextLine();
        entrada.nextLine();

        while (cpf.length() != 14){
            System.out.print("Formato incorreto, tente novamente: ");
            cpf = entrada.nextLine();
            entrada.nextLine();
        }

        cpf = cpf.replace(",", ".");

        ArrayList<Aluguel> resultado = this.locacoes.pesquisaAluguel(cpf);
        
        if (resultado != null&& resultado.size() != 0){
            String lista = "\n";
            int contador = 1;
            for (Aluguel item: resultado){
                lista += "Aluguel #" + contador + "\n";
                lista += item.gerarDescricao();
                lista += "\n\n";
                contador++;
            }
            System.out.println(lista);
        }
        else
            System.out.println("\n\n" + "Nenhum aluguel encontrado com este CPF." + "\n\n");
    }
}
