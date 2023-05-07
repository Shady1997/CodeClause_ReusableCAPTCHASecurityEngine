package model;

import com.github.cage.Cage;
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
public class CaptchaModel {
    private String captchaText;

    public CaptchaModel() {
        generateCaptcha();
    }

    public void generateCaptcha() {
        Cage cage = new Cage(); // Initialize the CAPTCHA generator
        captchaText = cage.getTokenGenerator().next(); // Generate random CAPTCHA text
    }

    public String getCaptchaText() {
        return captchaText;
    }

    public boolean verifyCaptcha(String userText) {
        return userText.equals(captchaText);
    }
}

