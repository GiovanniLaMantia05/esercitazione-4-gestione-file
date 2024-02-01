package gestionefile;

import java.util.Scanner;


/**
 *
 * @author MC
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1) LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        
        // Dopo aver letto il file user.json
        Scanner scanner = new Scanner(System.in);
        
        // Chiedi all'utente di inserire username
        System.out.print("Inserisci username: ");
        String username = scanner.nextLine();
        
        // Chiedi all'utente di inserire password
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();
        
        //2) ELABORAZIONE
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv");
        scrittore.setUsernamePassword(username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
}