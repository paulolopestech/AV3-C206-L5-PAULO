import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public void escrever(Carrinho carrinho){

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        try{
            os = new FileOutputStream("Arquivo.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Carrinho");
            bw.newLine();
            bw.write(carrinho.getNomeJogador() + "\n");
            bw.write(carrinho.getChassi() + "\n");
            bw.write(carrinho.getVelocidade() + "\n");

        }catch(Exception e){
            System.out.println(e);
        }finally {

            try {
                bw.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    public ArrayList<Carrinho> ler(){

        ArrayList<Carrinho> carrinhos = new ArrayList<>();

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linhaLer;

        try{

            is = new FileInputStream("Arquivo.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();
            while(linhaLer != null){
                if(linhaLer.contains("Carrinho")){
                    Carrinho f = new Carrinho();
                    f.setNomeJogador(br.readLine());
                    f.setChassi(br.readLine());
                    f.setVelocidade(Integer.parseInt(br.readLine()));
                    carrinhos.add(f);
                }
                linhaLer = br.readLine();
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return carrinhos;
    }

}
