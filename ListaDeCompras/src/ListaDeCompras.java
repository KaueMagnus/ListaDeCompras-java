import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {

    public static void main(String[] args) {

        //Criando a lista de compras.
        ArrayList<String> listaDeCompras = new ArrayList<>();

        //Scanner para receber as entradas do usuário.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==========LISTA DE COMPRAS==========");
            System.out.println("1- Adicionar item.");
            System.out.println("2- Remover item.");
            System.out.println("3- Editar item.");
            System.out.println("4- Visualizar lista.");
            System.out.println("5- Sair.");

            System.out.print("Qual opção você deseja? ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarItem(listaDeCompras, scanner);
                    break;
                case 2:
                    removerItem(listaDeCompras, scanner);
                    break;
                case 3:
                    editarItem(listaDeCompras, scanner);
                    break;
                case 4:
                    exibirLista(listaDeCompras);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            // Pausa antes de voltar ao menu
            System.out.println("Pressione Enter para voltar ao menu...");
            scanner.nextLine();  // Aguarda o usuário pressionar Enter

            // Código para exibir linhas em branco, assim, uma maneira de "limpar" o console
            for (int i = 0; i < 65; ++i) {
                System.out.println();
            }
        }

    }

    // Função feita para adicionar itens na lista.
    private static void adicionarItem(ArrayList<String> listaDeCompras, Scanner scanner) {
        System.out.println("Digite o nome do item para adicionar a lista: ");
        String item = scanner.nextLine();
        if (listaDeCompras.contains(item)) {
            System.out.println("Esse item já está na lista!");
        }
        else {
            listaDeCompras.add(item);
            System.out.println(item + " foi adicionado à lista de compras!");
        }
    }

    // Função feita para remover um item presente na lista
    private static void removerItem(ArrayList<String> listaDeCompras, Scanner scanner) {
        if (listaDeCompras.isEmpty()) {
            System.out.println("A lista de compras está vazia. Nada para remover!");
            return;
        }

        System.out.println("Digite o nome do item para remover da lista: ");
        String item = scanner.nextLine();
        if (listaDeCompras.contains(item)) {
            listaDeCompras.remove(item);
            System.out.println(item + " foi removido da lista de compras!");
        } else {
            System.out.println(item + " não foi encontrado na lista de compras!");
        }

    }

    // Função feita para editar um item presente na lista
    private static void editarItem(ArrayList<String> listaDeCompras, Scanner scanner) {
        if (listaDeCompras.isEmpty()) {
            System.out.println("A lista de compras está vazia. Nada para editar!");
            return;
        }
        System.out.println("Digite o nome do item que deseja editar: ");
        String itemAntigo = scanner.nextLine();

        if (listaDeCompras.contains(itemAntigo)) {
            System.out.println("Digite o novo nome do item: ");
            String novoItem = scanner.nextLine();
            listaDeCompras.set(listaDeCompras.indexOf(itemAntigo), novoItem);
            System.out.println(itemAntigo + " foi editado para " + novoItem + "!");
        } else {
            System.out.println(itemAntigo + " não foi encontrado na lista de compras!");
        }
    }

    // Função feita para exibir a lista com todos os itens.
    private static void exibirLista(ArrayList<String> listaDeCompras) {
        System.out.println("==========LISTA DE COMPRAS==========");
        for (String item : listaDeCompras) {
            System.out.println("- " + item);
        }
    }
}

