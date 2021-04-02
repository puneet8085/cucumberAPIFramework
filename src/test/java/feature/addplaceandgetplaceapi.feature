Feature: add new place


  @AddPlace
  Scenario Outline: add a new place and check name from response of get place api
    Given payload in Json format with "<Name>" "<Language>" "<Address>"
    When user calls "addPlaceApi" api with "post" http request
    Then i got response status code as 200
    And "status" in response is "OK"
    And "scope" in response is "APP"
    And verify "<Name>" present in response of "getPlaceApi" based on placeid
    Examples:
    |Name   |Language   |Address      |
    |KPM    |English    | B windfield |
 #   |PNG    |English UK | A whitefield|

    @DeletePlace
  Scenario: delete a place
    Given delete place api payload
    When user calls "deletePlaceApi" api with "post" http request
    Then i got response status code as 200
    And "status" in response is "OK"
