public class Carrinho implements Comparable<Carrinho> {
    private String nomeJogador;
    private int velocidade;
    private String chassi;

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) throws InfoInvalidaException {
        if(velocidade < 0){
            throw new InfoInvalidaException(velocidade);
        } else {
            this.velocidade = velocidade;
        }
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) throws InfoInvalidaException {
        if(chassi.equals("Breakout") || chassi.equals("Merc") || chassi.equals("Octane")){
            this.chassi = chassi;
        } else {
            throw new InfoInvalidaException(chassi);
        }
    }

    public void mostraInfo(){
        System.out.println("Nome: " + this.nomeJogador);
        System.out.println("Velocidade: " + this.velocidade);
        System.out.println("Chassi: " + this.chassi);
    }

    @Override
    public int compareTo(Carrinho carrinho) {
        return Double.compare(this.velocidade, carrinho.velocidade);
    }
}
