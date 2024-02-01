package gestionefile;

/*import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
*/

// necessari sotto
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MC
 * @version 12/01/23
 */
/*
public class Scrittore implements Runnable {

    String nomeFile;
    String username;
    String password;

    public Scrittore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void setUsernamePassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        scrivi();
        copiaFile();
    }

    // Scrive nel file nel formato username;password
    public void scrivi() {
        BufferedWriter br = null;

        try {
            // Apri il file per la scrittura
            br = new BufferedWriter(new FileWriter(nomeFile));
            
            // Scrivi nel file nel formato username;password
            br.write(username + ";" + password);
            br.write("\n\r");
            br.flush(); // Svuota il buffer e salva nel file i dati
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null)
                try {
                    br.close(); // Chiudi lo stream in uscita
                } catch (IOException ex) {
                    Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    // Copia il file output.csv in copia.csv
    public void copiaFile() {
        try {
            Path sourcePath = Path.of(nomeFile);
            Path destinationPath = Path.of("copia.csv");
            
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("File copiato con successo.");
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
*/

// issue 2-3

public class Scrittore implements Runnable {

    String nomeFile;
    String username;
    String password;

    public Scrittore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void setUsernamePassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        scrivi();
    }

    // Scrivi nel file binario usando DataOutputStream
    public void scrivi() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomeFile))) {
            // Scrivi i dati nel formato binario
            dos.writeUTF(username);
            dos.writeUTF(password);

            // Altri dati possono essere aggiunti secondo necessità
            

            System.out.println("Dati scritti con successo nel file binario.");

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}