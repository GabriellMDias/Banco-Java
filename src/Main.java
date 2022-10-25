import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scan = new Scanner(System.in);
        int op=-1;



        System.out.println("-- "+ banco.getNOME() + " --\n");

        do {
            System.out.println("1 - Acessar conta");
            System.out.println("2 - Cadastrar conta");
            System.out.println("3 - Lista de clientes");
            System.out.println("4 - Fechar Programa\n");
            System.out.print("Digite a opção desejada: ");

            do {
                op = scan.nextInt();
                switch (op) {
                    case 1 -> banco.acessarConta();
                    case 2 -> banco.cadastrarCliente();
                    case 3 -> banco.imprimirClientes();
                    case 4 -> System.out.println("");
                    default -> {
                        op = -1;
                        System.out.println("Opção inválida!");
                    }
                }
            }while (op == -1);
        }while (op != 4);

    }

}
