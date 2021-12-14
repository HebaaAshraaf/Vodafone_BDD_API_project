Feature: Getting The Number of the patterns views from
  the Color lover API XML Response and validate it it Greater than 4000

  Scenario: GET the Number of the patterns view
    Given Color Lover Patterns API endpoint exists
    When I send a valid Get Request to Get Patterns API XML File
    Then response status code should be 200
    And I should see the Number of Views of Pattern "0" Greater Than "4000"
#    Examples: | expectedCode | patternNumber | threshold |
#    | 200 | "0" | "4000" |