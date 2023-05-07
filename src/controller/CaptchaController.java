package controller;

import com.github.cage.Cage;
import model.CaptchaModel;
import view.CaptchaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CaptchaController {
    private CaptchaModel model;
    private CaptchaView view;

    public CaptchaController(CaptchaModel model, CaptchaView view) {
        this.model = model;
        this.view = view;

        // Set the initial CAPTCHA image
        view.setCaptchaImage(new Cage().drawImage(model.getCaptchaText()));

        // Add listeners to the refresh and verify buttons
        view.addRefreshButtonListener(new RefreshButtonListener());
        view.addVerifyButtonListener(new VerifyButtonListener());
    }

    class RefreshButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Generate a new CAPTCHA and set the CAPTCHA image
            model.generateCaptcha();
            view.setCaptchaImage(new Cage().drawImage(model.getCaptchaText()));
        }
    }

    class VerifyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Verify the user

            String userText = view.getCaptchaText();
            boolean result = model.verifyCaptcha(userText);

            if (result) {
                JOptionPane.showMessageDialog(view, "CAPTCHA verification successful!");
            } else {
                JOptionPane.showMessageDialog(view, "CAPTCHA verification failed!");
            }
        }
    }
    public static void main(String[] args) {
        CaptchaModel model = new CaptchaModel();
        CaptchaView view = new CaptchaView();
        CaptchaController controller = new CaptchaController(model, view);
        view.setVisible(true);
    }
}

