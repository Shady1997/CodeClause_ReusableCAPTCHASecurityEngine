package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
/*
 * Copyright (c) 2023 Shady Ahmed.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Shady Ahmed. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with Shady Ahmed.
 *
 * Created on May 7, 2023 at 10:30 PM
 */
public class CaptchaView extends JFrame {
    private JLabel captchaLabel;
    private JTextField captchaField;
    private JButton refreshButton;
    private JButton verifyButton;
    private JPanel captchaPanel;
    private JPanel buttonPanel;
    private JLabel messageLabel;

    public CaptchaView() {
        // Set the basic window properties
        setTitle("Captcha Security Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);

        // Set window icon
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/"+"resources/image-icon.png");
        setIconImage(icon.getImage());

        // Set the background color of the captcha and button panels
        Color backgroundColor = new Color(248, 249, 250);
        captchaPanel = new JPanel(new BorderLayout());
        captchaPanel.setBackground(backgroundColor);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(backgroundColor);

        // Create the captcha label and add it to the captcha panel
        captchaLabel = new JLabel();
        captchaPanel.add(captchaLabel, BorderLayout.CENTER);

        // Create the captcha field and add it to the captcha panel
        captchaField = new JTextField();
        captchaField.setPreferredSize(new Dimension(150, 30));
        captchaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        captchaField.setHorizontalAlignment(JTextField.CENTER);
        captchaField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        captchaPanel.add(captchaField, BorderLayout.EAST);

        // Create the refresh and verify buttons and add them to the button panel
        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        verifyButton = new JButton("Verify");
        verifyButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonPanel.add(refreshButton);
        buttonPanel.add(verifyButton);

        // Create the message label and add it to the captcha panel
        messageLabel = new JLabel();
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        captchaPanel.add(messageLabel, BorderLayout.NORTH);

        // Set the layout managers to arrange the captcha and button panel components
        captchaPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add the captcha and button panels to the content pane
        getContentPane().add(captchaPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    public void setCaptchaImage(BufferedImage captchaImage) {
        captchaLabel.setIcon(new ImageIcon(captchaImage));
    }

    public String getCaptchaText() {
        return captchaField.getText();
    }

    public void setMessageText(String message) {
        messageLabel.setText(message);
    }

    public void setMessageColor(Color color) {
        messageLabel.setForeground(color);
    }

    public void addRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public void addVerifyButtonListener(ActionListener listener) {
        verifyButton.addActionListener(listener);
    }
}
