## The Colonel's Bequest (LB1 DOS-1.000.046) 

Compiles without errors or warnings, but has not been thoroughly tested.

Base decompile from: https://github.com/sluicebox/sci-scripts/tree/main/cb-dos-1.000.046

The DOS, Atari and Amiga versions of The Colonel's Bequest seem to have not included two scripts, SortCopy & Sight. The missing scripts were ported from https://github.com/EricOakford/SCI-Decompilation-Archive/tree/master/lb1


## Copy Protection Note:

There are cracked version of The Colonel's Bequest floating around. Unfortunately, the crack doesn't just bypass copy protection - it disables the game interpreter's random function entirely. This acutally breaks many features throught the game. Source: https://www.benshoof.org/blog/case-cracked

To check if your game is broken, run the game several times in DOSBox. If the answer to the fingerprint question is always the first name, Celie, then you need to either purchase a legitamate copy of the game or modify the game's SCIV.EXE file with a hexeditor by changingthe byte at 0x88DF from 75 to EB.

This crack doesn't break the ScummVM version becaues that doesn't use sierra's interperter.

If you want to bypass the copy protection during testing, I've included instructions in the myCopy.sc (script 414) procedure 'WrongAnswer'.