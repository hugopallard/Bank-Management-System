package bank.mangement.system;

import GUI.BankGUI;
import GUI.ConnectGUI;

/**
 *
 * @author hugop
 */
public class Main {

    private static ConnectGUI connectInterface;
    private static Account account;
    private static BankGUI bankInterface;

    public static void main(String[] args) {

        connectInterface = new ConnectGUI();

    }

    public static ConnectGUI getConnectInterface() {
        return connectInterface;
    }

    public static void setAccount(Account account) {
        Main.account = account;
    }

    public static Account getAccount() {
        return account;
    }

    public static BankGUI getBankInterface() {
        return bankInterface;
    }

    public static void setBankInterface(BankGUI bankInterface) {
        Main.bankInterface = bankInterface;
    }

    public static void setConnectInterface(ConnectGUI connectInterface) {
        Main.connectInterface = connectInterface;
    }

}
