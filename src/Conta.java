public abstract class Conta implements iConta {
    private static final int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;

    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    protected int agencia;
    protected int numero;

    public double getSaldo() {
        return saldo;
    }

    protected double saldo;

    public Conta() {
        this.agencia = 1;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo){
            System.out.println("Operação não realizada, Saldo insuficiente!");
        }else
            saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }



    protected void imprimirInfoConta(){
        System.out.printf("Agência: %d%n", this.agencia);
        System.out.printf("Número: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }



    @Override
    public String toString() {
        return "{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
