# Setting Up the Project from GitHub

Follow these steps to set up the project from GitHub to your local machine:

## Step 1: Clone the Repository

1. **Open Terminal or Command Prompt.**
   
2. **Run the following command to clone the repository:**

```bash
$ git clone https://github.com/username/FanCodeTestAutomation.git
```
## Step 2: Navigate to the Project Directory

After cloning the repository, navigate to the project directory:
```bash
cd FanCodeTestAutomation
```
## Step 3: Build the Project
Use Maven to build the project:

```bash
mvn clean install
```

## Step 4: Run the Tests
Execute the tests to ensure everything is set up correctly:

```bash
mvn -Dtest=TestFanCodeUser test
```

## Step 5: View Test Output

Check the console output for results after running the tests.
