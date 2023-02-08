import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Arquivo {
    public static void createFileAluno(Aluno aluno) {
        // String file_name = Integer.toString(aluno.numeroDeMatricula) + "_" + aluno.nome;
        String file_name = Integer.toString(aluno.numeroDeMatricula);
        String file_content = AlunoCreator.getAlunoInfoAsString(aluno);

        try {
            FileWriter texto = new FileWriter(file_name);
            texto.write(file_content);
            texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNumeroMatriculaAluno(Aluno aluno) {
        try {
            Files.write(Paths.get("matriculas.txt"), Integer.toString(aluno.getNumeroDeMatricula()).getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeNumeroMatricula(int numeroDeMatricula) {

        String numeroDeMatriculaString = Integer.toString(numeroDeMatricula);

        File inputFile = new File("matriculas.txt");
        File tempFile = new File("matriculasTemp.txt");
        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            String lineToRemove = numeroDeMatriculaString;
            String currentLine;
    
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 
            boolean successful = tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }





    }

}