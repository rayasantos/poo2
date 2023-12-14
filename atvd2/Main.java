import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroProdutos cadastro = new CadastroProdutos();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Atualizar Produto por ID");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = scanner.nextDouble();
                    Produto novoProduto = new Produto(nomeProduto, precoProduto);
                    cadastro.adicionarProduto(novoProduto);
                    break;
                case 2:
                    cadastro.listarProdutos();
                    break;
                case 3:
                    System.out.print("Digite o ID do produto a ser buscado: ");
                    int idBusca = scanner.nextInt();
                    Produto produtoEncontrado = cadastro.buscarProduto(idBusca);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado:");
                        produtoEncontrado.mostrarDetalhes();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto a ser atualizado: ");
                    int idAtualizacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o novo nome do produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo preço do produto: ");
                    double novoPreco = scanner.nextDouble();
                    cadastro.atualizarProduto(idAtualizacao, novoNome, novoPreco);
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
