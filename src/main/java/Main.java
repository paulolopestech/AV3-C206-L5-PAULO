import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InfoInvalidaException {
        Scanner sc = new Scanner (System.in);

        Arquivo carrinhosSalvos = new Arquivo();

        ArrayList<Carrinho> carrinhos = new ArrayList<>();

        Arquivo a = new Arquivo();

        int op = 0;

        while (op != 10){
            Carrinho carrinho = new Carrinho();
            System.out.println(" "); // pular uma linha a cada execução
            System.out.println("Selecione uma opcao: ");
            System.out.println("1 - Cadastrar Carrinho");
            System.out.println("2 - Mostrar Informações dos Carrinhos salvos");
            System.out.println("3 - Ordenar Carrinhos (Velocidade crescente)");
            System.out.println("4 - Ordenar Carrinhos (Velocidade decrescente)");
            System.out.println("5 - Encerrar programa");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("Digite o Nome do Jogador: ");
                    carrinho.setNomeJogador(sc.nextLine());

                    System.out.println("Digite o Chassi do Carrinho: ");
                    try {
                        carrinho.setChassi(sc.nextLine());
                    } catch (InfoInvalidaException e) {
                        break;
                    }

                    System.out.println("Digite a Velocidade do Carrinho: ");
                    try {
                        carrinho.setVelocidade(sc.nextInt());
                    } catch (InfoInvalidaException e) {
                        break;
                    }

                    carrinhosSalvos.escrever(carrinho);
                    sc.nextLine();
                    break;

                case 2:
                    ArrayList<Carrinho> carrinhosLer = a.ler(); // leitura do arquivo

                    for(Carrinho lerCarrinho: carrinhosLer){
                        lerCarrinho.mostraInfo();
                        System.out.println(" ");
                    }
                    break;

                case 3:
                    System.out.println("Ordenando carrinhos pela velocidade de maneira crescente");

                    carrinhos = a.ler(); // leitura do arquivo
                    Collections.sort(carrinhos); // ordenação

                    for(Carrinho lerCarrinho: carrinhos){
                        lerCarrinho.mostraInfo();
                        System.out.println(" ");
                    }
                    break;

                case 4:
                    System.out.println("Ordenando carrinhos pela velocidade de maneira decrescente");

                    carrinhos = a.ler(); // leitura do arquivo
                    Collections.sort(carrinhos); // ordenação
                    Collections.reverse(carrinhos); // inversão

                    for(Carrinho lerCarrinho: carrinhos){
                        lerCarrinho.mostraInfo();
                        System.out.println(" ");
                    }
                    break;

                case 5:
                    System.out.println("Fim");
                    op = 10;
                    break;

                default:
                    System.out.println("Opcao inexistente");
                    break;
            }
//            sc.nextLine();
        }
    }
}
