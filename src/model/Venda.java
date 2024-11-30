package model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Venda {

    private Item[] itens;
    private LocalDateTime dataHora;
    private int quantidadeItens;

    public Venda(){
        itens = new Item[3];
        dataHora = LocalDateTime.now();
        quantidadeItens = 0;
    }

    public double getTotal(){
        double total = 0;
        for(int i=0;i<quantidadeItens; i++){
            if(itens[i] != null){
                total += itens[i].getSubtotal();
            }
        }
        return total;
    }

    public boolean adicionarItem(Item item){
        if(quantidadeItens == itens.length){
            itens = Arrays.copyOf(itens, itens.length+3);
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public Item[] getItens(){
        return Arrays.copyOf(itens, quantidadeItens);
    }

    public void removerProduto(int cod){

        for(int i=0; i<quantidadeItens; i++){
            if(itens[i] == null && itens[i].getCodigo() == cod){
                itens[i] = itens[i + 1];
                System.out.println("Item removido com sucesso!");
            }
            itens[--quantidadeItens] = null;


        }

    }
}
