package gestionefile;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner; // 
/**
 *
 * @author MC
 * @ 12/01/23
 */

/* public class Lettore extends Thread {
    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void leggi() {
        FileReader fr;
        int i;
        try {
            // Apri il file per la lettura
            fr = new FileReader(nomeFile);
            
            // Leggi il contenuto del file carattere per carattere e stampalo
            while ((i = fr.read()) != -1)
                System.out.print((char) i);

            System.out.print("\n\r");
            fr.close(); // Chiudi il file
            
            // Dopo aver letto il file, chiedi all'utente di inserire username e password
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci username: ");
            String username = scanner.nextLine();
            System.out.print("Inserisci password: ");
            String password = scanner.nextLine();
            
            // Esegui qualche azione con username e password se necessario
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }

    public void run() {
        leggi();
    }
}
*/

// issue 2-3

public class Lettore extends Thread {
    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void leggi() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nomeFile))) {
            // Controlla se ci sono dati disponibili prima di leggerli
            if (dis.available() > 0) {
                // Leggi i dati dal file binario
                String username = dis.readUTF();
                String password = dis.readUTF();

                // Stampa i dati letti
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                // Dopo aver letto i dati, chiedi all'utente di inserire altre informazioni se necessario
                Scanner scanner = new Scanner(System.in);
                System.out.print("Inserisci altre informazioni: ");
                String altreInformazioni = scanner.nextLine();
                System.out.println("Altre informazioni inserite: " + altreInformazioni);
            } else {
                System.out.println("Il file è vuoto o non contiene dati validi.");
            }

        } catch (IOException ex) {
            System.err.println("Errore in lettura: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        leggi();
    }
}