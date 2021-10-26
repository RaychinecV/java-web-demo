@homepage
Feature: Navigation menu on the home page

  Scenario Outline: Redirection on the home page by navigation menu
    Given open site
    When navigate to <page>
    Then validate that user is redirected to <page>

    Examples:
      | page                   |
      | ELEMENTS               |
      | FORMS                  |
      | ALERTS_FRAME_WINDOWS   |
      | WIDGETS                |
      | INTERACTIONS           |
      | BOOK_STORE_APPLICATION |

