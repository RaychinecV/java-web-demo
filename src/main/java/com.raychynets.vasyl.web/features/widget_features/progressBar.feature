@progressbar
Feature: Progress bar

  Scenario: Stop progress bar at some mark and continue to run
    Given open site
    And hide commercial banner
    When navigate to WIDGETS
    And select in widgets submenu PROGRESS_BAR
    Then progress bar page is displayed
    When click on the start button
    And click on stop button at the mark 20
    Then validate that progress bar at the mark 20
    When click on the start button
    And wait until load bar will be at the mark 100
    Then validate that progress bar at the mark 100

  Scenario: Reset progress bar
    Given open site
    And hide commercial banner
    When navigate to WIDGETS
    And select in widgets submenu PROGRESS_BAR
    Then progress bar page is displayed
    When click on the start button
    And wait until load bar will be at the mark 100
    And click on the reset button
    Then validate that progress bar at the mark 0