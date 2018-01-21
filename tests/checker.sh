#!/bin/bash

function compile
{
	make -C ./.. build &>/dev/null
}

function check
{
	readFrom="./tests/input/input.in"
	imageName="cat.png"
	cd ./..	
	java Main $readFrom &>/dev/null
	cp drawing.png ./tests/output/$imageName

	if [ $? -eq 0 ]; then

		diff "drawing.png" "./tests/ref/$imageName" &>/dev/null
		if [ $? -eq 0 ]; then
			echo -ne "You succeeded in drawing a cat!\n"
		else
			echo -ne "FAILED!\n"
		fi
	else
		echo -ne "FAILED! Program error!\n"
	fi

}

## MAIN EXECUTION ##
compile
check

## Uncomment for proceeding to clean the binary files
## Backup fileio folder
## make clean
