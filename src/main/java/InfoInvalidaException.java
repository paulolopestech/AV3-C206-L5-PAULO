public class InfoInvalidaException extends Exception {
    public InfoInvalidaException(int velocidade){
        System.out.println("A velocidade não pode ser menor que zero");
    }

    public InfoInvalidaException(String chassi){
        System.out.println("O chassi " + chassi + " não é um chassi válido");
    }
}
