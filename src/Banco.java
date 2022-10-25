import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Banco {
    private final String NOME = "Banco Java";
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public String getNOME() {
        return NOME;
    }

    public Conta procuraConta(int agencia, int numConta){
        Iterator<Cliente> iterator = clientes.iterator();
        Cliente next;

        while (iterator.hasNext()){
            next = iterator.next();
            if((next.getCc().getAgencia() == agencia && next.getCc().getNumero() == numConta)){
                return next.getCc();
            }else if ((next.getCp().getAgencia() == agencia && next.getCp().getNumero() == numConta))
                return next.getCp();
        }
        return null;
    }
    void acessarConta(){
        Scanner scan = new Scanner(System.in);
        int ag;
        int numConta;
        String senha;

        Iterator<Cliente> iterator = clientes.iterator();
        Cliente next;
        boolean logado = false;

        do {
            System.out.print("Digite a sua agência: ");
            ag = scan.nextInt();
            System.out.print("Digite o número da conta: ");
            numConta = scan.nextInt();
            scan.nextLine();

            if (!iterator.hasNext()) System.out.println("Conta Inexistente!\n\n");

            while (iterator.hasNext()){
                next = iterator.next();
                if((next.getCc().getAgencia() == ag && next.getCc().getNumero() == numConta)
                        || (next.getCp().getAgencia() == ag && next.getCp().getNumero() == numConta)){
                    do {
                        System.out.print("Digite sua senha: ");
                        senha = scan.nextLine();
                        if (next.getSenha().equals(senha)){
                            logado = true;
                            System.out.println("Bem vindo " + next.getNome() +"!");
                            next.menuConta(this);
                        }else System.out.println("Senha incorreta!");
                    }while (!logado);
                }
            }
            if (!logado) System.out.println("Conta inexistente! ");
        }while (!logado);
    }

    void cadastrarCliente(){
        Scanner scan = new Scanner(System.in);
        String nome;
        String senha;

        System.out.print("Digite o seu nome: ");
        nome = scan.nextLine();
        System.out.print("Digite uma senha de 6 dígitos: ");
        do {
            senha = scan.nextLine();
            if (senha.length() != 6)
                System.out.println("A senha deve conter 6 dígitos!: ");
        }while (senha.length()!=6 );

        clientes.add(new Cliente(nome, new ContaCorrente(), new ContaPoupanca(), senha));


    }

    void imprimirClientes(){
        for (Cliente cliente: clientes) {
            System.out.println(cliente);
        }
    }


}
