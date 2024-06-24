These source files allow for compiling Laura Bow 2 Floppy v1.000 in SCICompanion.

To compile:

Copy game.ini and the 'scr' folder into the root of your LB2 game folder.

Open LB2 in SCICompanion by selecting the RESOURCE.MAP file.

File > Import the included 997.voc file and Rebuild Resources.

The game should now compile with no errors.



Importing 997.voc is essential, becaue it was removed by Sierra before shipping the floppy version. I've recreated it from scratch, so there is the possibility of human error. In fact, there are still several unidentifed names (unused) in the file.

The source code builds on the Sci-Scripts decompile of LB2, which generates thousands of erros if SCICompanion tries compiling it. Importing 997.voc removes all but a few issues which can be viewed in the commit history.



SCICompanion
https://scicompanion.com/

Sluicebox's Sci-Scripts 
https://github.com/sluicebox/sci-scripts/tree/main/ra-dos-1.1

SCI Programmer's Wiki
http://sciwiki.sierrahelp.com/

Thank you to the members of the SCIProgramming forum. 


Debugger

Scripts 10 & 25 are missing from the Floppy version of the game. I've ported them over with a few adjustments to allow debugging. Import 10.txt into SCICompanion.

To enable the debugger, a 10.scr patch file must exsits in the patch or root folder of the game (depending on resources.cfg). The following files must be rebuilt into the resouce file or be exported as patch files: 

10.scr 
10.hep
10.txt
25.scr
25.hep