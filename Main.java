import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        LeitorTxt leitor = new LeitorTxt("teste.txt");
        Dicionario dic = new Dicionario();
        String[] line;
        String binary = "";

        while((line = leitor.proximaLinha())!=null){
            binary += dic.search(line) + "\n";
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resultado.txt"));
            bufferedWriter.write(binary, 0, binary.length());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
