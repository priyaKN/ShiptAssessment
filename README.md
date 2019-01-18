# ShiptAssessment
Shipt - QA - Software Test Engineer - Interview Exercise


**Getting Started**
1. Navigate to www.shipt.com. Choose a feature of the site and write a description or test
case to describe how to test the feature. By navigating to the Login page, you can
complete the Create Account flow in order to test inside the web app.

	Ans: ShiptAssessment\assessmentQuestion1\Assessment Question 1 -TestLoginPage.xlsx - link to the above question in project

	After navigating to www.shipt.com, i choose to test login feature which will be used by almost every user who access Shipt website. 
	
	I have prepared a testplan which can be used for both Manual testing and Automation (For the framework i have developed in this project, this test plan is compatible to be used directly without any modifications). 
	
	Following ISTQB best practices like Boundary value analysis, Equivalence class partitioning, State transition, Error Guessing, Decision table, i have come up with the 12 effective scenarios which has a good test coverage. TestLoginPage.xlsx explains all the scenarios with input details, expected outputs etc.,
	
	Note# I have harcoded username and password in TestLoginPage.xlsx, but if have to do the same in my actual project, i will encrypt it instead of hardcoding inorder to follow security constraints. 
 
 
 2. Locate one bug or bad workflow within the app.
    a. Explain the behavior you are seeing
    b. Include any useful errors or screenshots
    c. Explain why and how it needs to be corrected
    d. What are the steps you would take to report the issue?
    e. What priority would you give this bug (Scale of 1-5, 1 being highest) and why?
 
    Ans: ShiptAssessment\assessmentQuestion2\Assessment Question 2.docx - link to the above question in project
    
    I play around with the shipt web application for sometime, and identified some issues/bad workflows in the application. The Assessment Question 2.docx explains my findings and i have also given reasoning on why it seems to be a bad work flow or bug to me.
    
 
 3. What are the possible reasons for the following defect? How would you go about
    debugging the problem and gathering more information?
    On a web application, a user adds a phone number to their account. The user
    then changes the phone number. Upon trying to re-enter the first phone number,
    the user is allowed to click Save, and it seems to work, but the saved number
    remains the second number rather than updating to the more recently entered
    number. A page refresh does not change the result.
    
    Ans: ShiptAssessment\assessmentQuestion3\Assessment Question 3.docx - link to the above question in project
    
    This document explains the few out of many, what could be the possible reasons  for the above mentioned bug according to me.
    
    
 4. 1. List the stores allowed to sell alcohol
    2. Give the product name of the 2 most expensive items based on their price at store id 1
    3. List the products that are not sold in the store id 2
    4. What is the most popular item sold?
    5. Write a SQL statement to update the line_total field
    
    Ans: ShiptAssessment\sQL\SQL.docx or
         ShiptAssessment\sQL\SQL.sql - link to the above question in project
    
    This document explains the stored procedures or SQL queries for the questions asked above based on the scheme provided in the Questionnaire.
    
    
 5. API Automation
 
    Navigate to https://shipt.com/login to find exact url for the login endpoint. Write a custom API
    test framework that does the following:
    Send an invalid username/password to the token endpoint.
    Asserts the failure message is “Invalid Username or Password”
    Runs the same test with more than 1 username/password combination
    Feel free to use any language or helper package, but refrain from using tools such as Postman.
    Recommended languages we use are below:
    Python/Pytest
    Ruby/Rspec
    Go/Testify
    
    Ans:  #https://github.com/priyaKN/API-Automation - link to the above question in project
    
    This link has a seperate customized project created for API Automation part of the assessment, that does all the specified requirements. 
    
    Considering above requirement as a user story, all the acceptance criteria is met for the above requirement with the project specified in above link.
    
    
 6. Automation Assessment
    1. If you chose to use a tool or language other than the recommended, briefly explain why.
    2. How do you debug a failed test in your test framework?
    3. What do you believe are the most common causes for instability in UI automation?
    4. How do you make your tests consistent and easy to debug?
       
    Ans:  ShiptAssessment\automationAssessment-Last Part\Automation Assessment.docx - link to the above question in project
    
    **This document gives reasoning on:**
    why did i choose to use the different tool fromt he recommended. 
    How do i debug a failed test case in my test framework vs remote server
    What could be the possible reasons for instability of UI Automation
    **Best practices for :** How do i make my tests consistent and easy to debug
    
    
    
 This completes the assessment.
 
 Thanks
 Nandini
    
    
    
    
    
    
    
    