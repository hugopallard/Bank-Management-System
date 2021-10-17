/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Events.ConnectGUI_MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author hugop
 */
public class ConnectGUI {

    private final JFrame startFrame;
    private JLabel tittleLabel;
    private JLabel bottomLabel;
    private JLabel errorShowLabel;
    private JPanel contentPanel;
    private JPanel sidePanel;
    private final JPanel fieldPanel;
    private JPanel connectPanelTop;
    private JPanel connectPanel;

    private ImageIcon tittleLabelIcon;
    private JButton connectModeButton;
    private JButton createModeButton;
    private JButton connectButton;
    private final ImageIcon createButtonIcon;
    private final ImageIcon connectButtonIcon;
    private final ImageIcon connexionIcon;

    private final int connectPanelWidth;
    private final int sidePanelWidth;

    private final Color lightBlue;
    private final Color darkBlue;

    private final Font verdanaBig;
    private final Font helveticaLittle;
    private final Font errorFont;

    private final Dimension dim;
    private JTextField nameTxtField;
    private JTextField passwordTxtField;
    private JTextField emailTxtField;

    private boolean connectButtonMode = true;
    private boolean createButtonMode = false;
    private JTextField firstNameTxtField;
    private JTextField dateTxtField;
    private JTextField confirmEmailTxtField;
    private JTextField confirmPassTxtField;

    private String firstNameToSet;

    public ConnectGUI() {

        this.connectButtonIcon = new ImageIcon("Images\\connectButtonIcon.png");
        this.createButtonIcon = new ImageIcon("Images\\createButtonIcon.png");
        this.connexionIcon = new ImageIcon("Images\\connectionIcon.png");

        this.connectPanelWidth = 650;
        this.sidePanelWidth = 550;
        this.dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.lightBlue = new Color(1, 157, 250);
        this.darkBlue = new Color(13, 0, 75);

        this.verdanaBig = new Font("Verdana", Font.BOLD, 20);
        this.helveticaLittle = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        this.errorFont = new Font("Verdana", Font.BOLD, 18);

        this.fieldPanel = new JPanel(new GridLayout(9, 2, 0, 20));
        this.fieldPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        this.fieldPanel.setBackground(darkBlue);

        startFrame = new JFrame("Account manager");
        startFrame.setPreferredSize(new Dimension(dim.width - 200, dim.height - 60));
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TittleLabel();
        BottomLabel();
        Connect_FieldPanel();
        ConnectPanelTop();
        ConnectPanel();
        SidePanel();
        ContentPan();

        startFrame.add(contentPanel);
        startFrame.pack();
        startFrame.setLocation(dim.width / 2 - startFrame.getWidth() / 2, ((dim.height / 2) - 20) - startFrame.getHeight() / 2); // Le -20 pour corriger l'épaisseur de la barre d'application window
        startFrame.setVisible(true);
    }

    public final void TittleLabel() {

        this.tittleLabelIcon = new ImageIcon("Images\\gettingStartedIcon.jpg");
        this.tittleLabel = new JLabel("Let's get started !", tittleLabelIcon, JLabel.CENTER);
        this.tittleLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.tittleLabel.setVerticalTextPosition(JLabel.TOP);
        this.tittleLabel.setForeground(Color.WHITE);
        this.tittleLabel.setIconTextGap(50);
        this.tittleLabel.setFont(verdanaBig);

    }

    public final void BottomLabel() {

        this.bottomLabel = new JLabel("All © Rights Reserved, PALLARD", JLabel.CENTER);
        this.bottomLabel.setFont(helveticaLittle);
        this.bottomLabel.setForeground(Color.WHITE);

    }

    public final void Connect_FieldPanel() {

        this.errorShowLabel = new JLabel("", JLabel.RIGHT);
        this.errorShowLabel.setForeground(Color.RED);
        this.errorShowLabel.setFont(errorFont);

        JLabel nameLabel = new JLabel("Votre nom");
        nameLabel.setPreferredSize(new Dimension(450, 20));
        nameLabel.setFont(helveticaLittle);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBackground(darkBlue);
        nameLabel.setOpaque(true);
        this.nameTxtField = new JTextField("Pallard");
        this.nameTxtField.setBackground(darkBlue);
        this.nameTxtField.setForeground(Color.WHITE);
        this.nameTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel passwordLabel = new JLabel("Votre mot de passe");
        passwordLabel.setPreferredSize(new Dimension(450, 20));
        passwordLabel.setFont(helveticaLittle);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBackground(darkBlue);
        passwordLabel.setOpaque(true);
        this.passwordTxtField = new JTextField("24Doudou");
        this.passwordTxtField.setBackground(darkBlue);
        this.passwordTxtField.setForeground(Color.WHITE);
        this.passwordTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel emailLabel = new JLabel("Votre Email");
        emailLabel.setPreferredSize(new Dimension(450, 40));
        emailLabel.setFont(helveticaLittle);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBackground(darkBlue);
        emailLabel.setOpaque(true);
        this.emailTxtField = new JTextField("hugopallard2@yahoo.fr");
        this.emailTxtField.setBackground(darkBlue);
        this.emailTxtField.setForeground(Color.WHITE);
        this.emailTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        this.connectButton = new JButton("Connexion", connexionIcon);
        this.connectButton.addMouseListener(new ConnectGUI_MouseListener());
        this.connectButton.setBorder(null);
        this.connectButton.setBorderPainted(false);
        this.connectButton.setContentAreaFilled(false);
        this.connectButton.setFocusPainted(false);
        this.connectButton.setOpaque(false);
        this.connectButton.setHorizontalTextPosition(JButton.CENTER);
        this.connectButton.setVerticalTextPosition(JButton.CENTER);

        this.fieldPanel.add(nameLabel);
        this.fieldPanel.add(nameTxtField);
        this.fieldPanel.add(passwordLabel);
        this.fieldPanel.add(passwordTxtField);
        this.fieldPanel.add(emailLabel);
        this.fieldPanel.add(emailTxtField);
        this.fieldPanel.add(errorShowLabel);
        this.fieldPanel.add(connectButton);

    }

    public final void Create_FieldPanel() {

        this.errorShowLabel = new JLabel("", JLabel.RIGHT);
        this.errorShowLabel.setForeground(Color.RED);
        this.errorShowLabel.setFont(errorFont);

        JLabel emptyLabel_1 = new JLabel();
        JLabel emptyLabel_2 = new JLabel();

        JLabel nameLabel = new JLabel("Votre nom");
        nameLabel.setFont(helveticaLittle);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBackground(darkBlue);
        nameLabel.setOpaque(true);
        this.nameTxtField = new JTextField("qzdqdzqzd");
        this.nameTxtField.setBackground(darkBlue);
        this.nameTxtField.setForeground(Color.WHITE);
        this.nameTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel firstNameLabel = new JLabel("Votre prénom");
        firstNameLabel.setFont(helveticaLittle);
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setBackground(darkBlue);
        firstNameLabel.setOpaque(true);
        this.firstNameTxtField = new JTextField("qzdqzdqzd");
        this.firstNameTxtField.setBackground(darkBlue);
        this.firstNameTxtField.setForeground(Color.WHITE);
        this.firstNameTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel emailLabel = new JLabel("Votre Email");
        emailLabel.setFont(helveticaLittle);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBackground(darkBlue);
        emailLabel.setOpaque(true);
        this.emailTxtField = new JTextField("qzdzqdqz@mail.com");
        this.emailTxtField.setBackground(darkBlue);
        this.emailTxtField.setForeground(Color.WHITE);
        this.emailTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel confirmEmailLabel = new JLabel("Confirmation");
        confirmEmailLabel.setFont(helveticaLittle);
        confirmEmailLabel.setForeground(Color.WHITE);
        confirmEmailLabel.setBackground(darkBlue);
        confirmEmailLabel.setOpaque(true);
        this.confirmEmailTxtField = new JTextField("qzdzqdqz@mail.com");
        this.confirmEmailTxtField.setBackground(darkBlue);
        this.confirmEmailTxtField.setForeground(Color.WHITE);
        this.confirmEmailTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel passwordLabel = new JLabel("Votre mot de passe");
        passwordLabel.setFont(helveticaLittle);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBackground(darkBlue);
        passwordLabel.setOpaque(true);
        this.passwordTxtField = new JTextField("zqdzdzqdqzd");
        this.passwordTxtField.setBackground(darkBlue);
        this.passwordTxtField.setForeground(Color.WHITE);
        this.passwordTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel confirmPassLabel = new JLabel("Confirmation");
        confirmPassLabel.setFont(helveticaLittle);
        confirmPassLabel.setForeground(Color.WHITE);
        confirmPassLabel.setBackground(darkBlue);
        confirmPassLabel.setOpaque(true);
        this.confirmPassTxtField = new JTextField("zqdzdzqdqzd");
        this.confirmPassTxtField.setBackground(darkBlue);
        this.confirmPassTxtField.setForeground(Color.WHITE);
        this.confirmPassTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        JLabel dateLabel = new JLabel("Votre date de naissance");
        dateLabel.setFont(helveticaLittle);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBackground(darkBlue);
        dateLabel.setOpaque(true);
        this.dateTxtField = new JTextField("24/11/0000");
        this.dateTxtField.setBackground(darkBlue);
        this.dateTxtField.setForeground(Color.WHITE);
        this.dateTxtField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        this.connectButton = new JButton("Connexion", connexionIcon);
        this.connectButton.addMouseListener(new ConnectGUI_MouseListener());
        this.connectButton.setBorder(null);
        this.connectButton.setBorderPainted(false);
        this.connectButton.setContentAreaFilled(false);
        this.connectButton.setFocusPainted(false);
        this.connectButton.setOpaque(false);
        this.connectButton.setHorizontalTextPosition(JButton.CENTER);
        this.connectButton.setVerticalTextPosition(JButton.CENTER);

        this.fieldPanel.add(nameLabel);
        this.fieldPanel.add(nameTxtField);
        this.fieldPanel.add(firstNameLabel);
        this.fieldPanel.add(firstNameTxtField);
        this.fieldPanel.add(emailLabel);
        this.fieldPanel.add(emailTxtField);
        this.fieldPanel.add(confirmEmailLabel);
        this.fieldPanel.add(confirmEmailTxtField);
        this.fieldPanel.add(passwordLabel);
        this.fieldPanel.add(passwordTxtField);
        this.fieldPanel.add(confirmPassLabel);
        this.fieldPanel.add(confirmPassTxtField);
        this.fieldPanel.add(dateLabel);
        this.fieldPanel.add(dateTxtField);
        this.fieldPanel.add(emptyLabel_1);
        this.fieldPanel.add(emptyLabel_2);
        this.fieldPanel.add(errorShowLabel);
        this.fieldPanel.add(connectButton);

    }

    public final void ConnectPanelTop() {

        this.connectPanelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, -50, 0));
        this.connectPanelTop.setBackground(darkBlue);
        this.connectPanelTop.setPreferredSize(new Dimension(connectPanelWidth, 75));

        this.connectModeButton = new JButton("Sign in", connectButtonIcon);
        this.connectModeButton.addMouseListener(new ConnectGUI_MouseListener());
        this.connectModeButton.setBorder(null);
        this.connectModeButton.setBorderPainted(false);
        this.connectModeButton.setContentAreaFilled(false);
        this.connectModeButton.setFocusPainted(false);
        this.connectModeButton.setOpaque(false);
        this.connectModeButton.setSelected(true);
        this.connectModeButton.setHorizontalTextPosition(JButton.CENTER);
        this.connectModeButton.setVerticalTextPosition(JButton.CENTER);
        System.out.println("Etat du bouton connection par defaut  " + connectModeButton.isSelected());

        this.createModeButton = new JButton("Sign Up", createButtonIcon);
        this.createModeButton.addMouseListener(new ConnectGUI_MouseListener());
        this.createModeButton.setBorder(null);
        this.createModeButton.setBorderPainted(false);
        this.createModeButton.setContentAreaFilled(false);
        this.createModeButton.setFocusPainted(false);
        this.createModeButton.setOpaque(false);
        this.createModeButton.setSelected(false);
        this.createModeButton.setHorizontalTextPosition(JButton.CENTER);
        this.createModeButton.setVerticalTextPosition(JButton.CENTER);
        System.out.println("Etat du bouton creation par defaut  " + createModeButton.isSelected());

        this.connectPanelTop.add(connectModeButton);
        this.connectPanelTop.add(createModeButton);

        this.connectPanelTop.setBorder(new EmptyBorder(10, 0, 10, 75));

    }

    public final void ConnectPanel() {

        this.connectPanel = new JPanel(new BorderLayout());
        this.connectPanel.add(connectPanelTop, BorderLayout.NORTH);
        this.connectPanel.add(fieldPanel, BorderLayout.CENTER);

    }

    public final void SidePanel() {

        this.sidePanel = new JPanel(new BorderLayout());
        this.sidePanel.setBackground(lightBlue);
        this.sidePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        this.sidePanel.setPreferredSize(new Dimension(sidePanelWidth, startFrame.getHeight()));
        this.sidePanel.add(tittleLabel, BorderLayout.CENTER);
        this.sidePanel.add(bottomLabel, BorderLayout.SOUTH);

    }

    public final void ContentPan() {

        this.contentPanel = new JPanel(new BorderLayout());
        this.contentPanel.add(sidePanel, BorderLayout.WEST);
        this.contentPanel.add(connectPanel, BorderLayout.CENTER);

    }

    public JButton getConnectModeButton() {
        return connectModeButton;
    }

    public JButton getCreateModeButton() {
        return createModeButton;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JFrame getStartFrame() {
        return startFrame;
    }

    public ImageIcon getCreateButtonIcon() {
        return createButtonIcon;
    }

    public ImageIcon getConnectButtonIcon() {
        return connectButtonIcon;
    }

    public JPanel getConnectPanelTop() {
        return connectPanelTop;
    }

    public JPanel getFieldPanel() {
        return fieldPanel;
    }

    public JTextField getNameTxtField() {
        return nameTxtField;
    }

    public JTextField getPasswordTxtField() {
        return passwordTxtField;
    }

    public JTextField getEmailTxtField() {
        return emailTxtField;
    }

    public JTextField getFirstNameTxtField() {
        return firstNameTxtField;
    }

    public JTextField getDateTxtField() {
        return dateTxtField;
    }

    public JTextField getConfirmEmailTxtField() {
        return confirmEmailTxtField;
    }

    public JTextField getConfirmPassTxtField() {
        return confirmPassTxtField;
    }

    public JLabel getErrorShowLabel() {
        return errorShowLabel;
    }

    public void setCreateButtonMode(boolean createButtonMode) {
        this.createButtonMode = createButtonMode;
    }

    public void setConnectButtonMode(boolean connectButtonMode) {
        this.connectButtonMode = connectButtonMode;
    }

    public boolean isConnectButtonMode() {
        return connectButtonMode;
    }

    public boolean isCreateButtonMode() {
        return createButtonMode;
    }

    public String getFirstNameToSet() {
        return firstNameToSet;
    }

    public void setFirstNameToSet(String firstNameToSet) {
        this.firstNameToSet = firstNameToSet;
    }

}
