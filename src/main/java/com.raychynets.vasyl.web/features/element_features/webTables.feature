@webtables
Feature: Web tables

  Scenario: Add user
    Given open site
    And hide commercial banner
    When navigate to ELEMENTS
    And select in elements submenu WEB_TABLES
    And click on the add user button
    And web tables registration popup is displayed
    And fill in web table user fields
      | firstName | lastName | email         | age | salary | department |
      | create    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And click on the submit button in the web table page
    Then validate that user is present in the users list
      | firstName | lastName | email         | age | salary | department |
      | create    | user     | 123@gmail.com | 28  | 50000  | QA         |

  Scenario: Update user
    Given open site
    And hide commercial banner
    When navigate to ELEMENTS
    And select in elements submenu WEB_TABLES
    And click on the add user button
    And web tables registration popup is displayed
    And fill in web table user fields
      | firstName | lastName | email         | age | salary | department |
      | create    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And click on the submit button in the web table page
    And click on the update user button
      | firstName | lastName | email         | age | salary | department |
      | create    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And web tables registration popup is displayed
    And fill in web table user fields
      | firstName | lastName | email            | age | salary | department |
      | update    | user     | update@gmail.com | 30  | 90000  | QA lead    |
    And click on the submit button in the web table page
    Then validate that user is present in the users list
      | firstName | lastName | email            | age | salary | department |
      | update    | user     | update@gmail.com | 30  | 90000  | QA lead    |

  Scenario: Delete user
    Given open site
    And hide commercial banner
    When navigate to ELEMENTS
    And select in elements submenu WEB_TABLES
    And click on the add user button
    And web tables registration popup is displayed
    And fill in web table user fields
      | firstName | lastName | email         | age | salary | department |
      | delete    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And click on the submit button in the web table page
    Then validate that user is present in the users list
      | firstName | lastName | email         | age | salary | department |
      | delete    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And delete user
      | firstName | lastName | email         | age | salary | department |
      | delete    | user     | 123@gmail.com | 28  | 50000  | QA         |
    Then validate that user is not present in the users list
      | firstName | lastName | email         | age | salary | department |
      | delete    | user     | 123@gmail.com | 28  | 50000  | QA         |

  Scenario Outline: Search user by filter <field>
    Given open site
    And hide commercial banner
    When navigate to ELEMENTS
    And select in elements submenu WEB_TABLES
    And click on the add user button
    And web tables registration popup is displayed
    And fill in web table user fields
      | firstName | lastName | email         | age | salary | department |
      | search    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And click on the submit button in the web table page
    Then validate that user is present in the users list
      | firstName | lastName | email         | age | salary | department |
      | search    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And search user by field <field>
      | firstName | lastName | email         | age | salary | department |
      | search    | user     | 123@gmail.com | 28  | 50000  | QA         |
    Then validate that user is present in the users list
      | firstName | lastName | email         | age | salary | department |
      | search    | user     | 123@gmail.com | 28  | 50000  | QA         |
    And delete user
      | firstName | lastName | email         | age | salary | department |
      | search    | user     | 123@gmail.com | 28  | 50000  | QA         |

    Examples:
      | field      |
      | FIRST_NAME |
      | LAST_NAME  |
      | EMAIL      |
      | AGE        |
      | SALARY     |
      | DEPARTMENT |
