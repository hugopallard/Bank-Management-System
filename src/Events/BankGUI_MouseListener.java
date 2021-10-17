/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import GUI.ConnectGUI;
import bank.mangement.system.Main;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hugop
 */
public class BankGUI_MouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == Main.getBankInterface().getLogOutButton()) {
            if(JOptionPane.showConfirmDialog(null, "Se déconnecter ?", "Se déconnecter", JOptionPane.YES_NO_OPTION) == 0){
                Main.setConnectInterface(new ConnectGUI());
                Main.getBankInterface().getDashBoard().dispose();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == Main.getBankInterface().getMyDashBoardLabel()) {
            Main.getBankInterface().setMyDashBoardLabel(paintSelectedLabel(Main.getBankInterface().getMyDashBoardLabel()));
        }
        if (e.getSource() == Main.getBankInterface().getMyAccountsLabel()) {
            Main.getBankInterface().setMyAccountsLabel(paintSelectedLabel(Main.getBankInterface().getMyAccountsLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getBenefitsLabel()) {
            Main.getBankInterface().setBenefitsLabel(paintSelectedLabel(Main.getBankInterface().getBenefitsLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getOffersLabel()) {
            Main.getBankInterface().setOffersLabel(paintSelectedLabel(Main.getBankInterface().getOffersLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getRewardsLabel()) {
            Main.getBankInterface().setRewardsLabel(paintSelectedLabel(Main.getBankInterface().getRewardsLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getInsuranceLabel()) {
            Main.getBankInterface().setInsuranceLabel(paintSelectedLabel(Main.getBankInterface().getInsuranceLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getServicesLabel()) {
            Main.getBankInterface().setServicesLabel(paintSelectedLabel(Main.getBankInterface().getServicesLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getMessageLabel()) {
            Main.getBankInterface().setMessageLabel(paintSelectedLabel(Main.getBankInterface().getMessageLabel()));

        }

        Main.getBankInterface().getDashBoard().repaint();
        Main.getBankInterface().getDashBoard().revalidate();
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == Main.getBankInterface().getMyDashBoardLabel()) {
            Main.getBankInterface().setMyDashBoardLabel(unPaintSelectedLabel(Main.getBankInterface().getMyDashBoardLabel()));
        }
        if (e.getSource() == Main.getBankInterface().getMyAccountsLabel()) {
            Main.getBankInterface().setMyAccountsLabel(unPaintSelectedLabel(Main.getBankInterface().getMyAccountsLabel()));
        }
        if (e.getSource() == Main.getBankInterface().getBenefitsLabel()) {
            Main.getBankInterface().setBenefitsLabel(unPaintSelectedLabel(Main.getBankInterface().getBenefitsLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getOffersLabel()) {
            Main.getBankInterface().setOffersLabel(unPaintSelectedLabel(Main.getBankInterface().getOffersLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getRewardsLabel()) {
            Main.getBankInterface().setRewardsLabel(unPaintSelectedLabel(Main.getBankInterface().getRewardsLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getInsuranceLabel()) {
            Main.getBankInterface().setInsuranceLabel(unPaintSelectedLabel(Main.getBankInterface().getInsuranceLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getServicesLabel()) {
            Main.getBankInterface().setServicesLabel(unPaintSelectedLabel(Main.getBankInterface().getServicesLabel()));

        }
        if (e.getSource() == Main.getBankInterface().getMessageLabel()) {
            Main.getBankInterface().setMessageLabel(unPaintSelectedLabel(Main.getBankInterface().getMessageLabel()));

        }

        Main.getBankInterface().getDashBoard().repaint();
        Main.getBankInterface().getDashBoard().revalidate();
    }

    public JLabel paintSelectedLabel(JLabel labelToPaint) {

        labelToPaint.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < Main.getBankInterface().getLabelArrayList().size(); i++) {
            if (Main.getBankInterface().getLabelArrayList().get(i) != labelToPaint) {
                Main.getBankInterface().getLabelArrayList().get(i).setBackground(Color.GRAY);
            }
        }
        return labelToPaint;
    }

    public JLabel unPaintSelectedLabel(JLabel labelToPaint) {

        labelToPaint.setBackground(Color.GRAY);

        return labelToPaint;
    }
}
