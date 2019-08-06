Feature: New User Registration

Scenario: Invalid UserName 
Given User is on 'register' Page
When user enters invalid UserName
Then display 'Please Enter UserName' 

Scenario: Invalid Address
Given User is on 'register' Page
When user enters invalid address
Then display 'Please Enter Address' 

Scenario: Invalid Marks
Given User is on 'register' Page
When user enters invalid marks
Then display 'Please Enter Marks' 


Scenario: Invalid Details
Given User is on 'register' Page
When user enters invalid details
Then display 'Invalid Register Please try again'

Scenario: Valid Details
Given User is on 'register' Page
When user enters valid details
Then display 'Success' Page