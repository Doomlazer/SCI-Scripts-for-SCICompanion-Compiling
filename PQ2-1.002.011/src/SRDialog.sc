;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DSelector)

(public
	proc990_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	newDSelector
	[local6 4] = [{Restore} {__Save__} {Replace} {Replace}]
	[local10 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 40])
	(asm
code_06bc:
		pushi    13
		pushi    990
		pushi    1
		pushi    33
		pushi    0
		pushi    41
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    81
		lofsa    {OK}
		push    
		pushi    1
		pushi    81
		lofsa    {Cancel}
		push    
		pushi    0
		calle    proc255_0,  26
		sat      temp0
		not     
		bnt      code_06ef
		ldi      0
		ret     
code_06ef:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_0703
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_0703:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_071e
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_06bc
code_071e:
		pushi    3
		pushi    4
		lea      @temp34
		push    
		pushi    990
		pushi    2
		lea      @temp1
		push    
		callk    Format,  8
		push    
		pushi    33
		pushi    0
		calle    proc255_0,  6
		jmp      code_06bc
		ret     
	)
)

(procedure (localproc_041f)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_073d) 1)
			(local2 2)
			(else 3)
		)
	)
)

(procedure (localproc_073d)
	(if (< local2 20) (CheckFreeSpace global30))
)

(procedure (localproc_074c)
	(proc255_0 990 3 33 0)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
	
	(method (init param1 param2 param3)
		(= window SysWindow)
		(= nsBottom 0)
		(if
			(==
				(= local2 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local4 (localproc_041f)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		((= newDSelector (DSelector new:))
			x: 36
			y: 8
			text: param2
			font: global23
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= local1 (+ (newDSelector nsRight?) 4))
		(okI
			text: [local6 local4]
			setSize:
			moveTo: local1 (newDSelector nsTop?)
			state: (if (== local4 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: local1 (+ (okI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: local1 (+ (cancelI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)
		(self add: newDSelector okI cancelI changeDirI setSize:)
		(textI
			text: [local10 local4]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local1)
		(self add: textI setSize: center: open: 4 15)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 [temp4 361] [temp365 21] [temp386 40])
		(asm
			pushSelf
			lofsa    Restore
			eq?     
			bnt      code_01e5
			lap      argc
			bnt      code_01e5
			lap      param1
			bnt      code_01e5
			pushi    1
			pushi    4
			lea      @temp386
			push    
			pushi    990
			pushi    0
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    Format,  8
			push    
			callk    FOpen,  2
			sat      temp1
			push    
			ldi      65535
			eq?     
			bnt      code_01df
			ret     
code_01df:
			pushi    1
			lst      temp1
			callk    FClose,  2
code_01e5:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     10
			not     
			bnt      code_0205
			pushi    1
			pushi    975
			callk    DisposeScript,  2
			ldi      65535
			ret     
code_0205:
			lsl      local4
			dup     
			ldi      0
			eq?     
			bnt      code_021f
			lal      local2
			bnt      code_023c
			lofsa    okI
			jmp      code_023c
			lofsa    changeDirI
			jmp      code_023c
code_021f:
			dup     
			ldi      1
			eq?     
			bnt      code_022c
			lofsa    editI
			jmp      code_023c
code_022c:
			dup     
			ldi      2
			eq?     
			bnt      code_0239
			lofsa    okI
			jmp      code_023c
code_0239:
			lofsa    changeDirI
code_023c:
			toss    
			sal      local0
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local1
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lal      newDSelector
			send     4
			push    
			lal      newDSelector
			send     6
			sal      local3
			push    
			ldi      18
			mul     
			sat      temp3
			lsl      local1
			lofsa    changeDirI
			eq?     
			bnt      code_0300
			pushi    1
			lsg      global30
			call     proc990_0,  2
			bnt      code_0205
			pushi    3
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp4
			push    
			lea      @temp365
			push    
			callk    GetSaveFiles,  6
			sal      local2
			push    
			ldi      65535
			eq?     
			bnt      code_0299
			ldi      65535
			sat      temp2
			jmp      code_0410
code_0299:
			lal      local4
			sat      temp0
			pushi    0
			call     localproc_041f,  0
			sal      local4
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_02af
			jmp      code_02f5
code_02af:
			dup     
			lat      temp0
			eq?     
			bnt      code_02e0
			pushi    #contains
			pushi    1
			lofsa    editI
			push    
			self     6
			bnt      code_02f5
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lea      @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_02f5
code_02e0:
			pushi    #dispose
			pushi    0
			pushi    87
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     14
code_02f5:
			toss    
			pushi    #draw
			pushi    0
			lal      newDSelector
			send     4
			jmp      code_0205
code_0300:
			lsl      local4
			ldi      2
			eq?     
			bnt      code_0336
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_0336
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_0205
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_0410
			jmp      code_0205
code_0336:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_03b7
			lsl      local1
			lofsa    okI
			eq?     
			bt       code_0350
			lsl      local1
			lofsa    editI
			eq?     
			bnt      code_03b7
code_0350:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0365
			pushi    0
			call     localproc_074c,  0
			jmp      code_0205
code_0365:
			ldi      65535
			sat      temp2
			ldi      0
			sal      local1
code_036d:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_038f
			pushi    2
			lsp      param1
			lsl      local1
			ldi      18
			mul     
			leai     @temp4
			push    
			callk    StrCmp,  4
			sat      temp2
			not     
			bnt      code_038a
code_038a:
			+al      local1
			jmp      code_036d
code_038f:
			lat      temp2
			not     
			bnt      code_039d
			lal      local1
			lati     temp365
			jmp      code_03af
code_039d:
			lsl      local2
			ldi      20
			eq?     
			bnt      code_03ad
			lal      local3
			lati     temp365
			jmp      code_03af
code_03ad:
			lal      local2
code_03af:
			sat      temp2
			jmp      code_0410
			jmp      code_0205
code_03b7:
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_03cd
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_0410
			jmp      code_0205
code_03cd:
			lsl      local1
			ldi      0
			eq?     
			bt       code_03de
			lsl      local1
			lofsa    cancelI
			eq?     
			bnt      code_03e8
code_03de:
			ldi      65535
			sat      temp2
			jmp      code_0410
			jmp      code_0205
code_03e8:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_0205
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0205
code_0410:
			pushi    #dispose
			pushi    0
			self     4
			pushi    1
			pushi    975
			callk    DisposeScript,  2
			lat      temp2
			ret     
		)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
		text {Restore a Game}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text {Save a Game}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0)
		(= window SysWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 15)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_074c)
			(= temp0 0)
		)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties
		text { Cancel_}
	)
)

(instance changeDirI of DButton
	(properties
		text {Change\0D\nDirectory}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {Replace}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {with:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {Replace}
	)
)

(instance button2 of DButton
	(properties
		text {Cancel}
	)
)
