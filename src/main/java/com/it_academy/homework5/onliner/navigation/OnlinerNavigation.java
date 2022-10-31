package com.it_academy.homework5.onliner.navigation;

import com.it_academy.homework5.onliner.page_object.OnlinerHomePage;

public class OnlinerNavigation {

    public static void navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate("https://www.onliner.by/");
    }
}
