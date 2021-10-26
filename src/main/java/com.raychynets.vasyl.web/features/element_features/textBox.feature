@textbox
Feature: Text box

  Scenario: Create text box user with valid data
    Given open site
    When navigate to ELEMENTS
    And select in elements submenu TEXT_BOX
    And fill in user fields
      | fullName | email        | currentAddress | permanentAddress |
      | vasil    | 123@gmil.com | Ukraine        | USA              |
    And click on the submit button
    Then validate that user is created
      | fullName | email        | currentAddress | permanentAddress |
      | vasil    | 123@gmil.com | Ukraine        | USA              |

