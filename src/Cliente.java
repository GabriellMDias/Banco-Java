import java.util.Scanner;

public class Cliente {
    public String getNome() {
        return nome;
    }

    public Conta getCc() {
        return cc;
    }

    public Conta getCp() {
        return cp;
    }

    public String getSenha() {
        return senha;
    }

    private String nome;
    private Conta cc;
    private Conta cp;
    private String senha;

    public Cliente(String nome, ContaCorrente cc, ContaPoupanca cp, String senha) {
        this.nome = nome;
        this.cp = cp;
        this.cc = cc;
        this.senha = senha;
    }

    public void menuConta(Banco banco){
        Scanner scan = new Scanner(System.in);
        int agencia;
        int numConta;
        double valor;
        int op;

        System.out.println("-- Menu Conta --\n");

        System.out.println("1 - Saque - Conta corrente");
        System.out.println("2 - Saque - Conta poupança");
        System.out.println("3 - Deposito - Conta corrente");
        System.out.println("4 - Deposito - Conta poupanca");
        System.out.println("5 - Transferência - Conta corrente");
        System.out.println("6 - Transferência - Conta poupança");
        System.out.println("7 - Extrato - Conta corrente");
        System.out.println("8 - Extrato - Conta poupanca");
        System.out.println("9 - Sair\n");

        System.out.print("Selecione uma opção: ");

        op = scan.nextInt();

        switch (op) {
            case 1 -> {
                System.out.print("Qual o valor que deseja sacar? (Valor disponível: R$" + cc.getSaldo() + "): ");
                cc.sacar(scan.nextDouble());
            }
            case 2 -> {
                System.out.print("Qual o valor que deseja sacar? (Valor disponível: R$" + cp.getSaldo() + "): ");
                cp.sacar(scan.nextDouble());
            }
            case 3 -> {
                System.out.print("Qual o valor que deseja depositar?:");
                cc.depositar(scan.nextDouble());
            }
            case 4 -> {
                System.out.print("Qual o valor que deseja depositar?:");
                cp.depositar(scan.nextDouble());
            }
            case 5 -> {
                System.out.println("Para qual conta deseja transferir? (Valor disponível: R$" + cc.getSaldo() + "): ");
                System.out.print("Agência: ");
                agencia = scan.nextInt();
                System.out.print("Número: ");
                numConta = scan.nextInt();
                System.out.println("Valor: ");
                valor = scan.nextDouble();
                if (valor > cc.getSaldo()) System.out.println("Operação não realizada, Saldo insuficiente!");
                else cc.transferir(valor, banco.procuraConta(agencia, numConta));
            }
            case 6 -> {
                System.out.println("Para qual conta deseja transferir? (Valor disponível: R$" + cp.getSaldo() + "): ");
                System.out.print("Agência: ");
                agencia = scan.nextInt();
                System.out.print("Número: ");
                numConta = scan.nextInt();
                System.out.println("Valor: ");
                valor = scan.nextDouble();
                if (valor > cc.getSaldo()) System.out.println("Operação não realizada, Saldo insuficiente!");
                else cc.transferir(valor, banco.procuraConta(agencia, numConta));
            }
            case 7 -> cc.imprimirExtrato();
            case 8 -> cp.imprimirExtrato();
            case 9 -> System.out.println("");
            default -> {
                System.out.println("Opção Inválida!");
                menuConta(banco);
            }

        }
        if (op!=9) menuConta(banco);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cc=" + cc +
                ", cp=" + cp +
                '}';
    }
}
