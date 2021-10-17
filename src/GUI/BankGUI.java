/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Events.BankGUI_MouseListener;
import Others.RoundedBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hugop
 */
public class BankGUI {

    private final JFrame dashBoard;
    private final JPanel contentPan;
    private JPanel topPanel;
    private JPanel topRightPanel;
    private JPanel sidePanel;
    private JPanel sideMenuPanel;
    private JPanel centerPanel;
    private JPanel centerCardPanel;
    private JPanel accountSummaryPanel;
    private JPanel summaryPanel;
    private JPanel block_1_Panel;
    private JPanel block_2_Panel;

    private JLabel accountSummaryLabel;
    private JLabel topIconLabel;
    private JLabel topEmptyLabel;
    private JLabel notifLabel;
    private JLabel lastPayementLabel;
    private JLabel accountBalanceLabel;
    private JLabel transHistoryLabel;
    private JLabel photoLabel;
    private JLabel nameLabel;
    private JLabel myDashBoardLabel;
    private JLabel myAccountsLabel;
    private JLabel benefitsLabel;
    private JLabel offersLabel;
    private JLabel rewardsLabel;
    private JLabel insuranceLabel;
    private JLabel servicesLabel;
    private JLabel messageLabel;

    private JButton logOutButton;

    private final Dimension dim;
    private final int sidePanelWidth;
    private final int topPanelHeight;
    private final int centerCardPanelHeight;
    private final int accountSummaryLabelHeight;
    private final int sidePicturePanelHeight;
    private final int topIconLabelWidth;

    private final ImageIcon logo;
    private final ImageIcon notifIcon;
    private final ImageIcon logOutButtonIcon;

    private final Font helveticaBigBold;
    private final Font helveticaLittle;

    private final Color lightGrayColor;

    private final ArrayList<JLabel> labelArrayList;
    private final String name;
    private final String email;
    private final String firstName;
    private final String solde;
    
    private JLabel emailLabel;
    private JPanel sideTopPanel;
    private JPanel sideInfoPanel;

    public BankGUI(String name, String email, String firstName, String solde) {

        this.contentPan = new JPanel(new BorderLayout());
        this.sidePanelWidth = 300;
        this.topPanelHeight = 75;
        this.centerCardPanelHeight = 300;
        this.accountSummaryLabelHeight = 25;
        this.sidePicturePanelHeight = 100;
        this.topIconLabelWidth = 300;
        this.helveticaBigBold = new Font("Helvetica", Font.BOLD, 16);
        this.helveticaLittle = new Font("Helvetica", Font.PLAIN, 15);
        this.lightGrayColor = new Color(91, 91, 91, 25);
        this.labelArrayList = new ArrayList<>(8);
        this.name = name;
        this.email = email;
        this.firstName = firstName;
        this.solde = solde;

        this.logo = new ImageIcon("Images\\logo.png");
        this.notifIcon = new ImageIcon("Images\\notifIcon.png");
        this.logOutButtonIcon = new ImageIcon("Images\\createButtonIcon.png");

        this.dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.dashBoard = new JFrame("Account manager");
//        dim.width = 600;            // Pour tester l'UI en mode tel décommenter cette ligne et celle en dessous
//        dim.height = 750;

        dashBoard.setPreferredSize(new Dimension(dim.width - 200, dim.height - 50));
        TopPanel();
        SidePanel();
        CenterPanel();

        dashBoard.add(contentPan);
        dashBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashBoard.pack();
        dashBoard.setLocation(dim.width / 2 - dashBoard.getWidth() / 2, ((dim.height / 2) - 20) - dashBoard.getHeight() / 2); // Le -20 pour corriger l'épaisseur de la barre d'application window
        dashBoard.setVisible(true);

    }

    public final void TopPanel() {

        this.topPanel = new JPanel(new BorderLayout());
        this.topPanel.setPreferredSize(new Dimension(this.dashBoard.getWidth(), this.topPanelHeight));
        this.topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));

        this.topIconLabel = new JLabel(logo);
        this.topIconLabel.setBackground(Color.GRAY);
        this.topIconLabel.setOpaque(true);
        this.topIconLabel.setPreferredSize(new Dimension(this.topIconLabelWidth, this.topPanel.getHeight()));
        this.topEmptyLabel = new JLabel();
        this.topEmptyLabel.setBackground(Color.WHITE);
        this.topEmptyLabel.setOpaque(true);

        this.topRightPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.topRightPanel.setBackground(Color.WHITE);
        this.topRightPanel.setOpaque(true);
        this.notifLabel = new JLabel(notifIcon);
        this.logOutButton = new JButton("Déconnexion", logOutButtonIcon);
        this.logOutButton.addMouseListener(new BankGUI_MouseListener());
        this.logOutButton.setBorder(null);
        this.logOutButton.setBorderPainted(false);
        this.logOutButton.setContentAreaFilled(false);
        this.logOutButton.setFocusPainted(false);
        this.logOutButton.setOpaque(false);
        this.logOutButton.setHorizontalTextPosition(JButton.CENTER);
        this.logOutButton.setVerticalTextPosition(JButton.CENTER);

        this.topRightPanel.add(notifLabel);
        this.topRightPanel.add(logOutButton);

        this.topPanel.add(topIconLabel, BorderLayout.WEST);
        this.topPanel.add(topEmptyLabel, BorderLayout.CENTER);
        this.topPanel.add(topRightPanel, BorderLayout.EAST);

        this.contentPan.add(topPanel, BorderLayout.NORTH);
    }

    public final void SidePanel() {

        this.sidePanel = new JPanel(new BorderLayout());
        this.sidePanel.setPreferredSize(new Dimension(this.sidePanelWidth, (dashBoard.getHeight() - this.topPanel.getHeight())));
//        this.sidePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.LIGHT_GRAY));

        SidePicturePanel();
        SideMenuPanel();
        this.contentPan.add(sidePanel, BorderLayout.WEST);

    }

    public void SidePicturePanel() {

        this.sideTopPanel = new JPanel(new BorderLayout());

        this.sideInfoPanel = new JPanel(new GridLayout(2, 1));

        this.photoLabel = new JLabel(new ImageIcon("Images\\photo.png"));
        this.photoLabel.setBackground(Color.GRAY);
        this.photoLabel.setPreferredSize(new Dimension(this.sidePanel.getWidth(), this.sidePicturePanelHeight));
        this.photoLabel.setOpaque(true);

        this.nameLabel = new JLabel("<html>" + name + " " + firstName + "</html>", JLabel.CENTER);
        this.nameLabel.setFont(helveticaLittle);
        this.nameLabel.setBackground(Color.GRAY);
        this.nameLabel.setForeground(Color.WHITE);
        this.nameLabel.setOpaque(true);
        this.nameLabel.setVerticalTextPosition(JLabel.CENTER);

        this.emailLabel = new JLabel("<html>" + email + "</html>", JLabel.CENTER);
        this.emailLabel.setFont(helveticaLittle);
        this.emailLabel.setBackground(Color.GRAY);
        this.emailLabel.setForeground(Color.WHITE);
        this.emailLabel.setOpaque(true);
        this.emailLabel.setVerticalTextPosition(JLabel.CENTER);

        this.sideInfoPanel.add(nameLabel);
        this.sideInfoPanel.add(emailLabel);

        this.sideTopPanel.add(photoLabel, BorderLayout.NORTH);
        this.sideTopPanel.add(sideInfoPanel, BorderLayout.CENTER);

        this.sidePanel.add(sideTopPanel, BorderLayout.NORTH);

    }

    public void SideMenuPanel() {

        this.sideMenuPanel = new JPanel(new GridLayout(8, 1, 0, 20));
        this.sideMenuPanel.setBackground(Color.GRAY);
        this.sideMenuPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

        this.myDashBoardLabel = new JLabel("My Dashboard", JLabel.CENTER);
        this.myDashBoardLabel.setFont(helveticaLittle);
        this.myDashBoardLabel.setOpaque(true);
        this.myDashBoardLabel.setBackground(Color.GRAY);
        this.myDashBoardLabel.setForeground(Color.WHITE);
        this.myDashBoardLabel.addMouseListener(new BankGUI_MouseListener());

        this.myAccountsLabel = new JLabel("My Accounts", JLabel.CENTER);
        this.myAccountsLabel.setFont(helveticaLittle);
        this.myAccountsLabel.setOpaque(true);
        this.myAccountsLabel.setBackground(Color.GRAY);
        this.myAccountsLabel.setForeground(Color.WHITE);
        this.myAccountsLabel.addMouseListener(new BankGUI_MouseListener());

        this.benefitsLabel = new JLabel("Benefits", JLabel.CENTER);
        this.benefitsLabel.setFont(helveticaLittle);
        this.benefitsLabel.setOpaque(true);
        this.benefitsLabel.setBackground(Color.GRAY);
        this.benefitsLabel.setForeground(Color.WHITE);
        this.benefitsLabel.addMouseListener(new BankGUI_MouseListener());

        this.offersLabel = new JLabel("Offers", JLabel.CENTER);
        this.offersLabel.setFont(helveticaLittle);
        this.offersLabel.setOpaque(true);
        this.offersLabel.setBackground(Color.GRAY);
        this.offersLabel.setForeground(Color.WHITE);
        this.offersLabel.addMouseListener(new BankGUI_MouseListener());

        this.rewardsLabel = new JLabel("Rewards", JLabel.CENTER);
        this.rewardsLabel.setFont(helveticaLittle);
        this.rewardsLabel.setOpaque(true);
        this.rewardsLabel.setBackground(Color.GRAY);
        this.rewardsLabel.setForeground(Color.WHITE);
        this.rewardsLabel.addMouseListener(new BankGUI_MouseListener());

        this.insuranceLabel = new JLabel("Insurance", JLabel.CENTER);
        this.insuranceLabel.setFont(helveticaLittle);
        this.insuranceLabel.setOpaque(true);
        this.insuranceLabel.setBackground(Color.GRAY);
        this.insuranceLabel.setForeground(Color.WHITE);
        this.insuranceLabel.addMouseListener(new BankGUI_MouseListener());

        this.servicesLabel = new JLabel("Services", JLabel.CENTER);
        this.servicesLabel.setFont(helveticaLittle);
        this.servicesLabel.setOpaque(true);
        this.servicesLabel.setBackground(Color.GRAY);
        this.servicesLabel.setForeground(Color.WHITE);
        this.servicesLabel.addMouseListener(new BankGUI_MouseListener());

        this.messageLabel = new JLabel("Your Message(s)", JLabel.CENTER);
        this.messageLabel.setFont(helveticaLittle);
        this.messageLabel.setOpaque(true);
        this.messageLabel.setBackground(Color.GRAY);
        this.messageLabel.setForeground(Color.WHITE);
        this.messageLabel.addMouseListener(new BankGUI_MouseListener());

        this.sideMenuPanel.add(myDashBoardLabel);
        this.sideMenuPanel.add(myAccountsLabel);
        this.sideMenuPanel.add(benefitsLabel);
        this.sideMenuPanel.add(offersLabel);
        this.sideMenuPanel.add(rewardsLabel);
        this.sideMenuPanel.add(insuranceLabel);
        this.sideMenuPanel.add(servicesLabel);
        this.sideMenuPanel.add(messageLabel);

        this.labelArrayList.add(myDashBoardLabel);
        this.labelArrayList.add(myAccountsLabel);
        this.labelArrayList.add(benefitsLabel);
        this.labelArrayList.add(offersLabel);
        this.labelArrayList.add(rewardsLabel);
        this.labelArrayList.add(insuranceLabel);
        this.labelArrayList.add(servicesLabel);
        this.labelArrayList.add(messageLabel);

        this.sidePanel.add(sideMenuPanel, BorderLayout.CENTER);
    }

    public final void CenterPanel() {

        this.centerPanel = new JPanel(new BorderLayout());
        CenterCardPanel();
        AccountSummaryPanel();
        this.contentPan.add(centerPanel, BorderLayout.CENTER);

    }

    public final void CenterCardPanel() {

        this.centerCardPanel = new JPanel(new BorderLayout());
        this.centerCardPanel.setPreferredSize(new Dimension(this.centerPanel.getWidth(), this.centerCardPanelHeight));
        this.centerCardPanel.setBackground(Color.WHITE);
        this.centerCardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel creditCardLabel = new JLabel("Credit card", JLabel.CENTER);
        creditCardLabel.setBackground(Color.WHITE);
        creditCardLabel.setBorder(new RoundedBorder(Color.LIGHT_GRAY, 50));
        creditCardLabel.setOpaque(true);

        JLabel funPicture = new JLabel("Picture", JLabel.CENTER);
        funPicture.setBackground(lightGrayColor);
        funPicture.setPreferredSize(new Dimension(175, this.centerCardPanelHeight));
        funPicture.setOpaque(true);

        this.centerCardPanel.add(creditCardLabel, BorderLayout.CENTER);
        this.centerCardPanel.add(funPicture, BorderLayout.EAST);

        this.centerPanel.add(centerCardPanel, BorderLayout.NORTH);
    }

    public final void AccountSummaryPanel() {

        accountSummaryPanel = new JPanel(new BorderLayout());

        accountSummaryLabel = new JLabel("Your account summary as on 08/08/2021");
        this.accountSummaryLabel.setBackground(Color.WHITE);
        this.accountSummaryLabel.setOpaque(true);
        this.accountSummaryLabel.setFont(helveticaBigBold);
        this.accountSummaryLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
        this.accountSummaryLabel.setPreferredSize(new Dimension(this.accountSummaryPanel.getWidth(), this.accountSummaryLabelHeight));

        summaryPanel = new JPanel(new GridLayout(1, 2));

        lastPayementLabel = new JLabel("<html>Dernier Paiement<br> Valeur du dernier Paiement</html>", JLabel.LEFT);
        this.lastPayementLabel.setOpaque(true);
        this.lastPayementLabel.setBorder(new EmptyBorder(5, 20, 20, 20));
        this.lastPayementLabel.setBackground(lightGrayColor);
        this.lastPayementLabel.setVerticalAlignment(JLabel.TOP);

        accountBalanceLabel = new JLabel("Solde de votre compte: " + solde + "€", JLabel.LEFT);
        this.accountBalanceLabel.setOpaque(true);
        this.accountBalanceLabel.setBorder(new EmptyBorder(5, 20, 20, 20));
        this.accountBalanceLabel.setBackground(lightGrayColor);
        this.accountBalanceLabel.setVerticalAlignment(JLabel.TOP);

        transHistoryLabel = new JLabel("Historique des transactions", JLabel.CENTER);
        this.transHistoryLabel.setOpaque(true);
        this.transHistoryLabel.setBorder(new EmptyBorder(5, 20, 20, 20));
        this.transHistoryLabel.setBackground(lightGrayColor);
        this.transHistoryLabel.setVerticalAlignment(JLabel.TOP);

        block_1_Panel = new JPanel(new GridLayout(2, 1, 0, 30));
        this.block_1_Panel.setBackground(Color.WHITE);
        this.block_1_Panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.block_1_Panel.add(this.lastPayementLabel);
        this.block_1_Panel.add(this.accountBalanceLabel);

        block_2_Panel = new JPanel(new BorderLayout());
        this.block_2_Panel.setBackground(Color.WHITE);
        this.block_2_Panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.block_2_Panel.add(this.transHistoryLabel, BorderLayout.CENTER);

        this.summaryPanel.add(block_1_Panel);
        this.summaryPanel.add(block_2_Panel);
        this.accountSummaryPanel.add(accountSummaryLabel, BorderLayout.NORTH);
        this.accountSummaryPanel.add(summaryPanel, BorderLayout.CENTER);
        this.centerPanel.add(accountSummaryPanel, BorderLayout.CENTER);
    }

    public JLabel getMyDashBoardLabel() {
        return myDashBoardLabel;
    }

    public JLabel getMyAccountsLabel() {
        return myAccountsLabel;
    }

    public JLabel getBenefitsLabel() {
        return benefitsLabel;
    }

    public JLabel getOffersLabel() {
        return offersLabel;
    }

    public JLabel getRewardsLabel() {
        return rewardsLabel;
    }

    public JLabel getInsuranceLabel() {
        return insuranceLabel;
    }

    public JLabel getServicesLabel() {
        return servicesLabel;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public void setMyDashBoardLabel(JLabel myDashBoardLabel) {
        this.myDashBoardLabel = myDashBoardLabel;
    }

    public void setMyAccountsLabel(JLabel myAccountsLabel) {
        this.myAccountsLabel = myAccountsLabel;
    }

    public void setBenefitsLabel(JLabel benefitsLabel) {
        this.benefitsLabel = benefitsLabel;
    }

    public void setOffersLabel(JLabel offersLabel) {
        this.offersLabel = offersLabel;
    }

    public void setRewardsLabel(JLabel rewardsLabel) {
        this.rewardsLabel = rewardsLabel;
    }

    public void setInsuranceLabel(JLabel insuranceLabel) {
        this.insuranceLabel = insuranceLabel;
    }

    public void setServicesLabel(JLabel servicesLabel) {
        this.servicesLabel = servicesLabel;
    }

    public void setMessageLabel(JLabel messageLabel) {
        this.messageLabel = messageLabel;
    }

    public JFrame getDashBoard() {
        return dashBoard;
    }

    public ArrayList<JLabel> getLabelArrayList() {
        return labelArrayList;
    }
}
