# RONAS

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An app that allows for users to view COVID-19 statistics for the whole of the United States as well as each individual state. 

### App Evaluation

- **Category: Statistics Tracker**
- **Mobile: Android**
- **Story: Due to the unprecedented global pandemic, our team decided to collaborate and produce a simple, easy, accessible application to view the impact COVID-19 has had on our daily lives for the past year.**
- **Market: This app was created to be applicable to all, as COVID-19 is a devastating global health crisis which has afflicted and impacted all of us in numerous ways. The common person can and should utilize this app to get daily updates and information regarding the pandemic, and how it is either getting better or worse.**
- **Scope: We hope this app reaches civilians far and wide and allows for them to receive real-time data regarding the pandemic.**

## Product Spec

### 1. User Stories 

**Required Stories**

* Statistics for total United States nation cases as well as cases per state
* Includes total cases, total recoveries, total deaths, active cases, critical cases, deaths and cases per day, etc. 
* Navigate between screens
* Refresh statistics at any time
* Display all relevant information regarding COVID-19
* Display information regarding creators of the application
* Back button to reroute to home page

**Optional Stories**

* Picture of state next to state name
* Updates regarding new information about the pandemic

### 2. Screen Archetypes

* HOME
   * Allows for the user to view the name of the application, as well as navigate between future screens with the buttons categorized by the United States' total statistics, a list of states users can click on to view individual cases for, the individual states' statistics, general information about the pandemic, as well as an about us page for the creators of this application. 
   
* UNITED STATES STATISTICS
   * Allows for the user to see how many people in the United States have had the coronavirus since the start of the pandemic, total recovered, total dead, those in critical condition, active cases, cases reported today, as well as deaths reported today. 
   
* STATE STATISTICS
   * A list of all fifty states in the US where people can find statistics on. 
   
* SPECIFIC STATE STATISTICS
   * Statistics regarding each individual state such as how many people have had the coronavirus since the start of the pandemic, total recovered, total dead, those in critical condition, active cases, cases reported today, as well as deaths reported today. 
   
* GENERAL INFORMATION
   * Basic information about the pandemic such as the origin, the spread, the mandates, the vaccines and production, etc. 
   
* ABOUT US 
   * Creators of the application!

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* United States Statistics
* State Statistics
* Specific State Statistics
* General Information
* About Us 

**Flow Navigation** (Screen to Screen)

* Home --> United States Statistics --> Home
* Home --> State Statistics --> Specific State Statistics --> State Statistics --> Home
* Home --> General Information --> Home
* Home --> About Us --> Home

## Digital Wireframe
https://www.figma.com/file/ypbDUkkW79ZF84t9FPFSCq/covid-stats-app?node-id=0%3A1&frame-preset-name=iPhone%2011%20Pro%20Max

## Schema 
### Models
#### DoubleStat

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | statTitle1         | String     | Title of the first statistic                        |
   | statTitle2     | String   | Title of the second statistic                             |
   | stat1        | Number   | The first statistic   |
   | stat2      | Number   | The second statistic |
   
   #### State

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | stateName         | String     | Title of the first statistic                        |
   | deathCount     | Number   | Number of deaths                             |
   | recoveredCount        | Number   | Number of patients recovered   |
   | infectedCount      | Number   | Number of patients infected |
   | stateImage | Image | An image of the state |
   
### Networking

* UNITED STATES STATISTICS
  * http://covidtracking.com/api/us
  * (READ / GET) Transfers information of statistics regarding the novel coronavirus in the entirety of the US including regions, positive cases, negative cases, pending cases, those hospitalized currently and cumulatively, those hospitalized in the ICU currently and cumulatively, those on the ventilator currently and cumulatively, deaths, total hospitalized, total test results, death increase, hospitalized increase, negative tests increase, positive tests increase, and total tests increase 
* STATE STATISTICS
  * https://covidtracking.com/api/states
  * (READ / GET) Transfers information of statistics regarding the novel coronavirus in all 50 states and other regions attached to the US including deaths, recoveries, and infections 
* SPECIFIC STATE STATISTICS
  * https://covidtracking.com/api/states
  * (READ / GET) Transfers information of statistics regarding the novel coronavirus in all 50 states and other regions attached to the US including regions, positive cases, negative cases, pending cases, those hospitalized currently and cumulatively, those hospitalized in the ICU currently and cumulatively, those on the ventilator currently and cumulatively, deaths, total hospitalized, total test results, death increase, hospitalized increase, negative tests increase, positive tests increase, and total tests increase  
   
### Resources 
- https://covidtracking.com/data/api
- https://hackmd.io/PjNl4T_PSzaDQ6LGA5tPuQ?both
- https://covid-19-apis.postman.com/
- https://www.geeksforgeeks.org/how-to-create-a-covid-19-tracker-android-app/
