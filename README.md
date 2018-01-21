# JCad
A simplyfied version of CAD (Computer-Aided Design) program written in Java. 
The program uses text files as an input and output a .png image.

## Getting Started
Clone this repo on your local machine and install the required packages.
For tests see the section below.

### Prerequisites
Installing JDK 8.
On UNIX like systems run:
```
sudo apt-get install oracle-java8-installer 
```
To set JDK 8 as default JDK run:
```
sudo apt-get install oracle-java8-set-default 
```

## Built with
Java - JDK 8

## Running Tests
In tests folder run the script checker.sh to trigger the proposed test.
Give execution permission
```
chmod u+x ./checker.sh
./checker.sh
```
Run script
```
./checker.sh
```

### Input file format

On the first line is a positive number N representing the number of shapes
that are going to be draw.
On the next N lines there will be the shapes and their descriptions as it follows:

  CANVAS height width color transparency
  LINE start position x start position y end position x end position y color transparency
  SQUARE upper-left corner x upper-left corner y dimension upper-left corner x upper-left corner y
  RECTANGLE upper-left corner x upper-left corner y  height width color transparency
  CIRCLE center position x center position y radius color transparency

!!
The canvas (background) must be the first shape draw on every input file.
The color is represented as an #RGB code.


## Author
Ocanoaia Andreia-Irina

## License
This project is licensed under the MIT License - see the <LICENSE.md> file for details
