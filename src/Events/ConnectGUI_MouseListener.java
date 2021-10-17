/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import GUI.BankGUI;
import bank.mangement.system.Account;
import bank.mangement.system.Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author hugop
 */
public class ConnectGUI_MouseListener implements MouseListener {

    private String name;
    private String password;
    private String email;
    private String date;
    private String confirmPassword;
    private String confirmEmail;
    private String firstName;

    private boolean correctFilling = false;
    private boolean error = false;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == Main.getConnectInterface().getConnectModeButton()) {

            // Changement de l'interface en mode création de compte
            Main.getConnectInterface().getFieldPanel().removeAll();
            Main.getConnectInterface().Connect_FieldPanel();

            // Selection du mode renforcée
            Main.getConnectInterface().getConnectModeButton().setIcon(Main.getConnectInterface().getConnectButtonIcon());
            Main.getConnectInterface().getCreateModeButton().setIcon(Main.getConnectInterface().getCreateButtonIcon());
            Main.getConnectInterface().setConnectButtonMode(true);
            Main.getConnectInterface().setCreateButtonMode(false);

            // Reset des paramètres
            Main.getConnectInterface().getErrorShowLabel().setText(null);
            Main.getConnectInterface().getFieldPanel().repaint();
            Main.getConnectInterface().getStartFrame().revalidate();

        }
        if (e.getSource() == Main.getConnectInterface().getCreateModeButton()) {

            // Changement de l'interface en mode création de compte
            Main.getConnectInterface().getFieldPanel().removeAll();
            Main.getConnectInterface().Create_FieldPanel();

            // Selection du mode renforcée
            Main.getConnectInterface().getConnectModeButton().setIcon(Main.getConnectInterface().getCreateButtonIcon());
            Main.getConnectInterface().getCreateModeButton().setIcon(Main.getConnectInterface().getConnectButtonIcon());
            Main.getConnectInterface().setConnectButtonMode(false);
            Main.getConnectInterface().setCreateButtonMode(true);

            // Reset des paramètres
            Main.getConnectInterface().getErrorShowLabel().setText(null);
            Main.getConnectInterface().getStartFrame().repaint();
            Main.getConnectInterface().getStartFrame().revalidate();

        }
        if (e.getSource() == Main.getConnectInterface().getConnectButton()) {

            if (Main.getConnectInterface().isConnectButtonMode()) {                     // Vérification des champs en mode connection
                this.name = Main.getConnectInterface().getNameTxtField().getText();
                this.password = Main.getConnectInterface().getPasswordTxtField().getText();
                this.email = Main.getConnectInterface().getEmailTxtField().getText();

                if (!name.equals("Dupond") && !password.equals("************") && !email.equals("xyz@mail.com")) {
                    this.correctFilling = true;
                }
                if (name == null || name.equals("Dupond")) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un nom valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((password == null || password.length() < 8 || password.equals("************")) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un mot de passe valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((email == null || !email.contains("@") || email.equals("xyz@mail.com")) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un email valideeeeeeeeee");
                    this.correctFilling = false;
                }
                this.error = false;

            } else if (Main.getConnectInterface().isCreateButtonMode()) {       // Vérification des champs en mode création

                this.name = Main.getConnectInterface().getNameTxtField().getText();
                this.firstName = Main.getConnectInterface().getFirstNameTxtField().getText();
                this.email = Main.getConnectInterface().getEmailTxtField().getText();
                this.confirmEmail = Main.getConnectInterface().getConfirmEmailTxtField().getText();
                this.password = Main.getConnectInterface().getPasswordTxtField().getText();
                this.confirmPassword = Main.getConnectInterface().getConfirmPassTxtField().getText();
                this.date = Main.getConnectInterface().getDateTxtField().getText();

                if (!name.equals("Dupond") && !password.equals("************") && !email.equals("xyz@mail.com")) {
                    this.correctFilling = true;
                }
                if (name == null || name.equals("Dupond")) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un nom valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((firstName == null || firstName.equals("Nicolas")) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un prénom valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((email == null || !email.contains("@") || email.equals("xyz@mail.com")) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un email valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if (!confirmEmail.equals(email) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Les emails ne correspondent pas");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((password == null || password.length() < 8 || password.equals("************")) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez un mot de passe valide");
                    this.correctFilling = false;
                    this.error = true;
                }
                if (!confirmPassword.equals(password) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Les mots de passe ne correspondent pas");
                    this.correctFilling = false;
                    this.error = true;
                }
                if ((date == null || date.equals("01/01/1202") || !date.contains("/") || date.length() != 10) && error == false) {
                    Main.getConnectInterface().getErrorShowLabel().setText("Entrez une date valide");
                    this.correctFilling = false;
                }
                this.error = false;

            }
            if (correctFilling) {       // Les champs ont été correctement remplis, on regarde le mode choisi puis on fait des vérifications appropriées : le comtpe existe t'il déjà ?
                System.out.println("correct filling");
                if (Main.getConnectInterface().isCreateButtonMode()) {
                    Account accountCreator = new Account(name, firstName, password, email, date);
                    Main.setAccount(accountCreator);
                    accountCreator.AccountConnector_CREATE();
                }
                if (Main.getConnectInterface().isConnectButtonMode()) {
                    Account accountConnection = new Account(name, password, email);
                    Main.setAccount(accountConnection);
                    accountConnection.AccountConnector_CONNECT();
                }
            }

        }
        Main.getConnectInterface().getStartFrame().repaint();
        Main.getConnectInterface().getStartFrame().revalidate();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
