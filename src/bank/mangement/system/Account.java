/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.mangement.system;

import GUI.BankGUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hugop
 */
public class Account {

    private final String name;
    private String firstName;
    private int age;
    private int montantIni;
    private final String eMail;
    private int phoneNum;
    private String adresse;
    private final String password;
    private String date;

    private final String fileName;

    private final ArrayList<String> accountInfoList;
    private FileWriter fich;
    private final boolean existingFile;
    private final File file;
    private String id;
    private String solde;
    private Random randomno;

    public Account(String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.eMail = email;
        this.accountInfoList = new ArrayList<>();
        this.solde = "0";

        this.accountInfoList.add(name);
        this.accountInfoList.add(password);
        this.accountInfoList.add(eMail);

        this.fileName = "C:\\Users\\hugop\\Desktop\\A mettre ds one drive\\Projets(1)\\Projets en Java\\Bank Mangement System\\Accounts\\accountsFile.txt";
        file = new File(fileName);
        existingFile = file.exists();

    }

    public Account(String name, String firstName, String password, String email, String date) {

        this.name = name;
        this.firstName = firstName;
        this.password = password;
        this.eMail = email;
        this.date = date;
        this.solde = "0";

        this.accountInfoList = new ArrayList<>();

        this.accountInfoList.add(name);
        this.accountInfoList.add(password);
        this.accountInfoList.add(email);
        this.accountInfoList.add(firstName);
        this.accountInfoList.add(date);
        this.accountInfoList.add(solde);

        this.fileName = "C:\\Users\\hugop\\Desktop\\A mettre ds one drive\\Projets(1)\\Projets en Java\\Bank Mangement System\\Accounts\\accountsFile.txt";
        file = new File(fileName);
        existingFile = file.exists();

    }

    public boolean AccountCreator() {

        int elementAccount = 0;

        try {

            if (existingFile == false) {
                fich = new FileWriter(file);
            } else {
                fich = new FileWriter(file, true);
            }

            FileReader read = new FileReader(file);
            BufferedReader br = new BufferedReader(read);
            String line = br.readLine();
            fich.write("--------------- \n");

            if (existingFile) {
                System.out.println("Le fichier existe et je commence le procédé d'écriture");
                while (line != null) {

                    if (line.equals(this.accountInfoList.get(3))) {     // le compte existe déjà lors du processus de création 2 comptes ne peuvent pas avoir le meme email

                        throw new UnsupportedOperationException();

                    } else {        // le compte n'existe pas

                        line = br.readLine();
                        System.out.println("Contenu de la ligne" + line);

                        while (line == null && elementAccount < this.accountInfoList.size()) {
                            fich.write(String.valueOf(this.accountInfoList.get(elementAccount) + "\n"));
                            elementAccount++;
                            line = br.readLine();
                        }
                    }
                }

            } else {        // Le fichier des comptes existe pas, on utilise cette loop pour écrire le compte : c'est le premier compte créé
                System.out.println("Le fichier existe pas et je commence le procédé d'écriture");

                while (elementAccount < this.accountInfoList.size()) {

                    fich.write(String.valueOf(this.accountInfoList.get(elementAccount) + "\n"));
                    elementAccount++;

                }
            }

            System.out.println("\nCréation du compte effectuée avec succès !");
            System.out.println(accountInfoList);
            fich.close();

        } catch (IOException ex) {
            System.out.println("Le compte n'a pas pu être créé");
        } catch (UnsupportedOperationException e) {
            System.out.println("Le compte que vous essayer de créer existe déjà, veuillez vous conecter.");
            return false;
        }
        return true;
    }

    public boolean AccountVerificator() {

        try ( FileReader read = new FileReader(file)) {
            BufferedReader br = new BufferedReader(read);
            String line;
            line = br.readLine();

            while (line != null && !line.equals(accountInfoList.get(0))) {  // On vérifie parmis les comptes existants que le compte qui se connecte existe
                line = br.readLine();
            }
            if (line != null) { // Si on arrive ici, c'est que le compte existe, ou que l'on est à la fin des comptes existants (on vérifie donc le !=null pour la fin du fichier)

                if (line.equals(accountInfoList.get(0))) {  // vérification du 1er champ rempli par rapport au fichier
                    line = br.readLine();

                    if (line.equals(accountInfoList.get(1))) {      // ...
                        line = br.readLine();

                        if (line.equals(accountInfoList.get(2))) {
                            firstName = br.readLine();  // On Récupère le prénom pour l'affichage
                            br.readLine();
                            solde = br.readLine();
                            read.close();
                            return true;        // Si on arrive la, les 3 choix remplis existent consécutivement dans le fichier : le comtpe existe
                        }
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Il y a eu une erreur dans la lecture du fichier des comptes");
        }
        return false;
    }

    public void AccountConnector_CONNECT() {

        if (AccountVerificator()) {
            Main.setBankInterface(new BankGUI(name, eMail, firstName, solde));
            Main.getConnectInterface().getStartFrame().dispose();
        }
    }

    public void AccountConnector_CREATE() {
        if (AccountCreator()) {
            Main.setBankInterface(new BankGUI(name, eMail, firstName, solde));
            Main.getConnectInterface().getStartFrame().dispose();
        }

    }
}
