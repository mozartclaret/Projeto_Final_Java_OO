package applications;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConverteArquivo {
    public static void main(String[] args) {
        String arquivoEntrada = "C:\\temp\\entrada.txt";
        String arquivoSaida = "C:\\temp\\saida.csv";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split("\\|");
                if (campos.length == 4) {
                    String codigo = campos[0];
                    String nome = campos[1];
                    String endereco = campos[2];
                    String telefone = campos[3];

                    // Escreve os campos separados por ";"
                    escritor.write(codigo + ";" + nome + ";" + endereco + ";" + telefone);
                    escritor.newLine();
                }
            }

            leitor.close();
            escritor.close();

            System.out.println("Arquivo de saída foi gerado com sucesso: " + arquivoSaida);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao processar os arquivos: " + e.getMessage());
        }
    }
}

