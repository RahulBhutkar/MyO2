Feature: Test MyO2 simple flow
Scenario: Visit the O2 Site
Given Open Chrome & launch O2 site
When I valid "username" and valid "password"
Then Get the Details from the page