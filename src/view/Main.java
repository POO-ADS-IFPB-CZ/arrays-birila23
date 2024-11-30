package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Venda venda = new Venda();

        int opcao;
        int codigoI, codigoP;
        String descricao;
        double preco;
        int quantidade;
        int cod;

        do {
            System.out.println(
                    "--------------Menu de vendas---------------\n"+
                            "         1- Adicionar um produto: \n" +
                            "         2- Remover produto: \n" +
                            "         3- Mostrar total da compra: \n" +
                            "         4- Sair do programa:\n" +
                            "-------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("\nAdicionar o código do item: ");
                    codigoI = scanner.nextInt();
                    System.out.println("Adicionar o código do produto: ");
                    codigoP = scanner.nextInt();
                    System.out.println("Adionar descrição do produto: ");
                    descricao = scanner.next();
                    System.out.println("Adicionar o preço do produto: ");
                    preco = scanner.nextDouble();
                    System.out.println("Adicionar o quantidade do produto: ");
                    quantidade = scanner.nextInt();

                if(venda.adicionarItem(new Item(codigoI,
                        new Produto(codigoP, descricao,
                                preco, Categoria.ALIMENTICIO),
                        quantidade)) ){
                System.out.println("Produto adicionado com sucesso!");
                }
                else{
                    System.out.println("Produto não adicionado");
                }
                break;
                case 2:
                    System.out.println("Digite o código do produto para excluir:");
                    cod = scanner.nextInt();

                    venda.removerProduto(cod);
                    System.out.println("O valor ficará: "+ venda.getTotal());
                    break;
                case 3:
                    System.out.println("O preço total da venda é: " + venda.getTotal());
                    break;
                case 4:
                    System.out.println("\nSaindo do programa.\n");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while (opcao != 4);

    }
}