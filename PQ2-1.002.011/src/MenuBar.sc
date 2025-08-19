;;; Sierra Script 1.0 - (do not remove this comment)
(script# 997)
(include sci.sh)
(use Main)
(use rm13)
(use rm33)
(use Class_255_0)
(use Sound)
(use User)


(class MenuBar of Class_255_0
	(properties
		state $0000
	)
	
	(method (init)
		(AddMenu { \01_} {About PQ2 `^a:Help`#1})
		(AddMenu
			{ File_}
			{Save Game`#5:Restore Game`#7:--! :Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Action_}
			{Pause Game`^p:Inventory`^I:Repeat`#3:--! :Load Gun`#6:Draw/Holster Gun`#8:Fire Gun`#0:--! :Enter/Exit Car`#4}
		)
		(AddMenu
			{ Speed_}
			{Set Speed`^s:--!:Faster`+:Normal`=:Slower`-}
		)
		(AddMenu { Sound_} {Volume...`^v:Turn Off`#2=1})
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
		(SetMenu 1028 109 'normal[/speed]')
		(SetMenu 773 109 'load,load[/9mm]')
		(SetMenu 774 109 'draw,gunbelt[/9mm]')
		(SetMenu 775 109 'fire[/9mm]')
		(= global105 777)
	)
	
	(method (handleEvent pEvent &tmp [temp0 3] temp3 [temp4 320] temp324)
		(switch (super handleEvent: pEvent)
			(257
				(proc255_0
					(Format @temp4 997 0 global28)
					80
					{__Police Quest II Credits__}
					30
					1
					70
					160
					33
					global23
					82
					999
					2
					0
				)
				(proc255_0
					(Format @temp4 997 1)
					80
					{And last, but not least...}
					30
					1
					70
					180
					33
					global23
					82
					999
					2
					0
				)
			)
			(258
				(proc255_0 997 2 33 global23)
			)
			(513
				(if (proc0_4 1200)
					(Load rsSCRIPT 990)
					(Load rsSCRIPT 975)
					(gGame save:)
				else
					(proc255_0 997 3)
				)
			)
			(514
				(if (proc0_4 1200)
					(Load rsSCRIPT 990)
					(Load rsSCRIPT 975)
					(gGame restore:)
				else
					(proc255_0 997 3)
				)
			)
			(516
				(if
					(proc255_0
						997
						4
						81
						{Restart}
						1
						81
						{Continue}
						0
						82
						999
						0
						0
					)
					(gGame restart:)
				)
			)
			(517
				(= global4
					(proc255_0 997 5 81 {Quit} 1 81 {Continue} 0 82 999 0 0)
				)
			)
			(769
				(= temp324 (Sound pause: 1))
				(proc255_0
					997
					6
					80
					{Game Paused}
					82
					999
					1
					0
					81
					{Let's roll.}
					1
				)
				(Sound pause: temp324)
			)
			(770
				(gInv
					carrying: {You are carrying...}
					empty:
						{You have only your diving equipment.\nYou left everything else in the van.}
					showSelf: gEgo
				)
			)
			(771
				(pEvent claimed: 0 type: 4 message: (User echo?))
			)
			(773
				(pEvent claimed: 0 type: 4 message: 16384)
			)
			(774
				(pEvent claimed: 0 type: 4 message: 16896)
			)
			(775
				(pEvent claimed: 0 type: 4 message: 17408)
			)
			(777
				(cond 
					((== gNumber 13) (proc13_1))
					((== gNumber 33) (proc33_1))
					((not global106) (= global132 1))
				)
			)
			(1025
				(if
					(!=
						(= temp3 (proc255_3 {Speed (1 - 16)?} gNewSpeed))
						-1
					)
					(if (< temp3 1) (= temp3 1))
					(if (> temp3 16) (= temp3 16))
					(gGame setSpeed: temp3)
				)
			)
			(1027
				(if (> gNewSpeed 1) (gGame setSpeed: (-- gNewSpeed)))
			)
			(1028 (gGame setSpeed: 6))
			(1029
				(if (< gNewSpeed 20) (gGame setSpeed: (++ gNewSpeed)))
			)
			(1281
				(if
					(!=
						(= temp3
							(proc255_3 {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
						)
						-1
					)
					(if (< (-- temp3) 0) (= temp3 0))
					(if (> temp3 15) (= temp3 15))
					(DoSound sndVOLUME temp3)
				)
			)
			(1282
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 {Turn on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 {Turn off})
				)
			)
		)
	)
)
