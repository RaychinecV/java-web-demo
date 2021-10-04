package com.raychynets.vasyl.web.pages.navigation_menu;

public interface BaseMenu {

    <T extends BaseMenu> T openMenu();

    <T extends BaseMenu> T closeMenu();

}
