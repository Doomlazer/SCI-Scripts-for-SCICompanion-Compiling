# SCICompanion compiliable source code

These files are intended for use by translators, modders or anyone else who needs to alter and recompile SCI game scripts.

Based on Sluicebox's <a href="https://github.com/sluicebox/sci-scripts/tree/main/ra-dos-1.1">Sci-Scripts</a> repo of SCI game decompiles, these SCR files have been modified to compile in SCICompanion without generating errors. This does not mean that they are completely bug-free, as the SCICompanion compiler is not perfect and will still likely introduce a few new bugs. Please report any issues.

## Games ready for compilation

There are currently two games in this repo (more will be added over time, requests entertained):

- LB1
- LB2-floppy-v1.1
- PQ2-1.002.011

## Usage

Some games might require copying or importing additional patches (see individual readme files), but in general, follow these steps: 

1. Copy the SCR folder and game.ini into a retail copy of the corresponding game. 
2. Open SCICompanion, navagate to the game's folder and select resource.map.
3. In the SCICompanion menu, select Script > Compile all (No errors should be produced, warnings can be ignored).
4. In the SCICompanion menu, select Tools > Rebuild Resources.

The project is now ready for modifiying individual scripts as needed.

## Thanks to:

The Sierra game translation communities.

SCICompanion
https://scicompanion.com/

Kawa's nightly SCICompanion builds
https://github.com/Kawa-oneechan/SCICompanion/releases

Sluicebox's Sci-Scripts 
https://github.com/sluicebox/sci-scripts/tree/main/ra-dos-1.1

SCI Programmer's Wiki
http://sciwiki.sierrahelp.com/

EO's SCI-Decompilation-Archive
https://github.com/EricOakford/SCI-Decompilation-Archive
