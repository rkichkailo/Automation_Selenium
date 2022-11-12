package com.it_academy.homework6.onliner.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage(){
        Configuration.browser = "Chrome";
        Configuration.pageLoadTimeout = 20000;
        //open();
    }

    public void navigate(String url) {
        open(url);
    }
}
