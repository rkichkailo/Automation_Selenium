package com.it_academy.homework5.onliner.framework;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CommonWebElementUtils {

    public static List<String> getTextsFromWebElements(List <WebElement> webElements){
        return webElements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
