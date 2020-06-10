Project: CSVtoSQLite

Load CSV File into SQLite Database

The customer has just informed us that we need to churn out a small appalication ASAP to support a new project. 
Here is what they need:

1. We need a Java Application that will consume a CSV File, parse the data, and insert valid records into a SQLite Database.
	a. Dataname: csvtosqlite.db
	b. It should have 1 table with 10 columns A,B,C,D,E,F,G,H,I,J that correspond to the CSV file column header names.
2. Each records needs to be verified to contatin the right number of data elements to match the columns.
	a. Records that do not match the column count must be written to: data-bad.csv
3. At the end of the processing, write statistics to a log file: csvlogs.log
	a. # of records received
	b. # of records successful
	c. # of records failed


How to add SQLite-JDBC jar file -

You will need a SQLite-JDBC jar file which can be found from below link. To add this JAR file in your project follow below steps :

https://bitbucket.org/xerial/sqlite-jdbc/downloads/

    Right Click on your project
    Go to 'Build Path'
    Go to 'Configure Build Path'
    Go to 'Libraries' tab
    Click on 'Add External JARs'
    Select JAR file you downloaded and click apply.



How to use run it -

1. Change the 'path' in CSVtoSQLite.java Line 18. (Use the path where your .csv file is located)
2. Change the 'path' in CSVLoader.java Line 143. (Use the path where you want to save your bad-data.csv)
3. Change the 'path' in CSVLoader.java Line 165. (Use the path where you want to save your log file  csvlogs.logs)