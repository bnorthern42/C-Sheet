# WIP

ToDo:

* Add POI and logging dependencies
* Get Spinner integers
* Populate a Text spinner of available sheets and select one.
* Create functions that will combine the CSV into XLSX 
* Make actual Documentation [here](https://bnorthern42.github.io/CSV-Merge-to-Excel/)
* Make code pretty and not Spaghetti!


# CSV-ME
CSV-ME, takes a CSV file from the user and inputs it into an existing spreadsheet. Written in Java 11 using Maven

## To install normally

Will be in Github releases, simple run .jar file

## Dependencies

* Apache POI - XLSX Access R/W
* Javax Swing - Implements GUI
* log4j2 - for logging


## Build from source

Open IDE pom.xml file. Once dependicies are all found and loaded. Should be able to run.


## How it works (so far)


Start of Program: 

![](https://github.com/bnorthern42/C-Sheet/blob/main/images/FirstOpen.JPG?raw=true)

Import CSV file:

![](https://github.com/bnorthern42/C-Sheet/blob/main/images/FileOpen_CSV.JPG?raw=true)

Import XLSX file:

![](https://github.com/bnorthern42/C-Sheet/blob/main/images/FileOpen_XLSX.JPG?raw=true)

Click the next button after you are happy with both imports:

![](https://github.com/bnorthern42/C-Sheet/blob/main/images/click_next_main.JPG?raw=true)

Old window closes and a new one opens to set the merging options

![](https://github.com/bnorthern42/C-Sheet/blob/main/images/starting_points_gui.JPG?raw=true)

