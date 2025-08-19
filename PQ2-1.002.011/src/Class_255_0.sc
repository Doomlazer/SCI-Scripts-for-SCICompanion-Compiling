;;; Sierra Script 1.0 - (do not remove this comment)
(script# 255)
(include sci.sh)
(use Main)
(use Obj)

(public
	proc255_0 0
	proc255_1 1
	proc255_2 2
	proc255_3 3
	proc255_4 4
	proc255_5 5
	proc255_6 6
)

(local
	local0
	[local1 20]
)
(procedure (proc255_0 param1 &tmp newDialog newDText newDIcon newDEdit temp4 temp5 temp6 temp7 temp8 theGTheNewDialog temp10 temp11 [newDButton 6] temp18 temp19 temp20 [temp21 1000])
	(= temp11 (GetPort))
	(= temp6 (= temp7 -1))
	(= theGTheNewDialog
		(= temp8
			(= temp18 (= newDIcon (= newDEdit (= temp19 0))))
		)
	)
	((= newDialog (Dialog new:))
		window: gNewSysWindow
		name: {PrintD}
	)
	(= newDText (DText new:))
	(cond 
		((u< [param1 0] 1000) (GetFarText [param1 0] [param1 1] @temp21) (= temp5 2))
		([param1 0] (StrCpy @temp21 [param1 0]) (= temp5 1))
		(else (= temp21 0) (= temp5 0))
	)
	(newDText
		text: @temp21
		moveTo: 4 4
		font: global22
		setSize:
	)
	(newDialog add: newDText)
	(= temp5 temp5)
	(while (< temp5 argc)
		(switch [param1 temp5]
			(30
				(++ temp5)
				(newDText mode: [param1 temp5])
			)
			(33
				(++ temp5)
				(newDText font: [param1 temp5] setSize: temp8)
			)
			(70
				(= temp8 [param1 (++ temp5)])
				(newDText setSize: temp8)
			)
			(25
				(++ temp5)
				(newDialog time: [param1 temp5])
			)
			(80
				(++ temp5)
				(newDialog text: [param1 temp5])
			)
			(67
				(= temp6 [param1 (++ temp5)])
				(= temp7 [param1 (++ temp5)])
			)
			(83
				(Animate (gCast elements?) 0)
			)
			(41
				(++ temp5)
				((= newDEdit (DEdit new:)) text: [param1 temp5])
				(++ temp5)
				(newDEdit max: [param1 temp5] setSize:)
			)
			(81
				((= [newDButton temp19] (DButton new:))
					text: [param1 (++ temp5)]
					value: [param1 (++ temp5)]
					setSize:
				)
				(= temp18 (+ temp18 ([newDButton temp19] nsRight?) 4))
				(++ temp19)
			)
			(82
				(if (not newDIcon) (= newDIcon (DIcon new:)))
				(newDIcon
					view: [param1 (+ temp5 1)]
					loop: [param1 (+ temp5 2)]
					cel: [param1 (+ temp5 3)]
					setSize:
				)
				(= temp5 (+ temp5 3))
			)
			(88
				(if gTheNewDialog (gTheNewDialog dispose:))
				(= theGTheNewDialog newDialog)
			)
			(35
				(++ temp5)
				(newDialog window: [param1 temp5])
			)
		)
		(++ temp5)
	)
	(if newDIcon
		(newDIcon moveTo: 4 4)
		(newDText
			moveTo: (+ 4 (newDIcon nsRight?)) (newDText nsTop?)
		)
		(newDialog add: newDIcon)
	)
	(newDialog setSize:)
	(if newDEdit
		(newDEdit
			moveTo: (newDText nsLeft?) (+ 4 (newDText nsBottom?))
		)
		(newDialog add: newDEdit setSize:)
	)
	(= temp20
		(if (> temp18 (newDialog nsRight?))
			4
		else
			(- (newDialog nsRight?) temp18)
		)
	)
	(= temp5 0)
	(while (< temp5 temp19)
		([newDButton temp5] moveTo: temp20 (newDialog nsBottom?))
		(newDialog add: [newDButton temp5])
		(= temp20 (+ 4 ([newDButton temp5] nsRight?)))
		(++ temp5)
	)
	(newDialog setSize: center:)
	(if (and newDIcon (not (StrLen @temp21)))
		(newDIcon
			moveTo:
				(/
					(-
						(- (newDialog nsRight?) (newDialog nsLeft?))
						(- (newDIcon nsRight?) (newDIcon nsLeft?))
					)
					2
				)
				4
		)
	)
	(newDialog
		moveTo:
			(if (== -1 temp6) (newDialog nsLeft?) else temp6)
			(if (== -1 temp7) (newDialog nsTop?) else temp7)
	)
	(newDialog
		open: (if (newDialog text?) 4 else 0) (if theGTheNewDialog 15 else -1)
	)
	(if theGTheNewDialog
		(= local0 (GetPort))
		(SetPort temp11)
		(return (= gTheNewDialog theGTheNewDialog))
	)
	(if
		(and
			(= temp10 (newDialog firstTrue: #checkState 1))
			(not (newDialog firstTrue: #checkState 2))
		)
		(temp10 state: (| (temp10 state?) $0002))
	)
	(if (== (= temp4 (newDialog doit: temp10)) -1)
		(= temp4 0)
	)
	(= temp5 0)
	(while (< temp5 temp19)
		(if (== temp4 [newDButton temp5])
			(= temp4 (temp4 value?))
			(break)
		)
		(++ temp5)
	)
	(if (not (newDialog theItem?)) (= temp4 1))
	(newDialog dispose:)
	(return temp4)
)

(procedure (proc255_1 param1 param2 param3 param4)
	(proc255_0 param1 82 param2 param3 param4 &rest)
)

(procedure (proc255_2 param1 param2 param3 &tmp [temp0 4])
	(if
		(proc255_0
			(if (>= argc 3) param3 else {})
			41
			param1
			param2
			&rest
		)
		(StrLen param1)
	)
)

(procedure (proc255_3 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1) (Format @temp0 255 0 param2))
	(return
		(if (proc255_2 @temp0 5 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (proc255_4 &tmp [temp0 500])
	(Format @temp0 &rest)
	(proc255_0 @temp0)
)

(procedure (proc255_5 param1 param2 param3)
	(cond 
		((!= (param2 type?) 1) 0)
		(
			(and
				(>= argc 3)
				param3
				(== (& (param2 modifiers?) param3) 0)
			)
			0
		)
		((param1 respondsTo: #nsLeft)
			(__proc999_4
				(param1 nsLeft?)
				(param1 nsTop?)
				(param1 nsRight?)
				(param1 nsBottom?)
				param2
			)
		)
	)
)

(procedure (proc255_6 &tmp newEvent temp1)
	(= temp1 (!= ((= newEvent (Event new:)) type?) 2))
	(newEvent dispose:)
	(return temp1)
)

(class Class_255_0 of Obj
	(properties
		state $0000
	)
	
	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)
	
	(method (hide)
		(DrawMenuBar 0)
	)
	
	(method (handleEvent pEvent)
		(return (if state (MenuSelect pEvent &rest) else 0))
	)
	
	(method (add)
		(AddMenu &rest)
	)
)

(class Class_255_1 of Obj
	(properties
		type $0000
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)
	
	(method (doit)
		(return value)
	)
	
	(method (enable param1)
		(if param1
			(= state (| state $0001))
		else
			(= state (& state $fffe))
		)
	)
	
	(method (select param1)
		(if param1
			(= state (| state $0008))
		else
			(= state (& state $fff7))
		)
		(self draw:)
	)
	
	(method (handleEvent pEvent &tmp temp0 pEventType temp2)
		(if (pEvent claimed?) (return 0))
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= pEventType (pEvent type?)) 128)
						(Said said)
					)
					(and
						(== pEventType evKEYBOARD)
						(== (pEvent message?) key)
					)
					(and (== pEventType evMOUSEBUTTON) (self check: pEvent))
				)
			)
			(pEvent claimed: 1)
			(= temp0 (self track: pEvent))
		)
		(return temp0)
	)
	
	(method (check param1)
		(return
			(if
				(and
					(>= (param1 x?) nsLeft)
					(>= (param1 y?) nsTop)
					(< (param1 x?) nsRight)
				)
				(< (param1 y?) nsBottom)
			else
				0
			)
		)
	)
	
	(method (track param1 &tmp temp0 temp1)
		(return
			(if (== 1 (param1 type?))
				(= temp1 0)
				(repeat
					(= param1 (Event new: -32768))
					(GlobalToLocal param1)
					(if (!= (= temp0 (self check: param1)) temp1)
						(HiliteControl self)
						(= temp1 temp0)
					)
					(param1 dispose:)
					(breakif (not (proc255_6)))
				)
				(if temp0 (HiliteControl self))
				(return temp0)
			else
				(return self)
			)
		)
	)
	
	(method (setSize)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (draw)
		(DrawControl self)
	)
	
	(method (isType param1)
		(return (== type param1))
	)
	
	(method (checkState param1)
		(return (& state param1))
	)
)

(class DText of Class_255_1
	(properties
		type $0002
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 1
		mode 0
	)
	
	(method (new &tmp temp0)
		((super new:) font: global22 yourself:)
	)
	
	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft [temp0 3]))
	)
)

(class DIcon of Class_255_1
	(properties
		type $0004
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		view 0
		loop 0
		cel 0
	)
	
	(method (setSize &tmp [temp0 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of Class_255_1
	(properties
		type $0001
		state $0003
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] text font)
		(= [temp0 2] (+ [temp0 2] 2))
		(= [temp0 3] (+ [temp0 3] 2))
		(= nsBottom (+ nsTop [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= nsRight (+ [temp0 3] nsLeft))
	)
)

(class DEdit of Class_255_1
	(properties
		type $0003
		state $0001
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
		max 0
		cursor 0
	)
	
	(method (track param1)
		(EditControl self param1)
		(return self)
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft (/ (* [temp0 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class Dialog of List
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
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(asm
			ldi      0
			sat      temp0
			ldi      1
			aTop     busy
			pToa     theItem
			bnt      code_05e9
			pushi    #select
			pushi    1
			pushi    0
			send     6
code_05e9:
			lap      argc
			bnt      code_05f8
			lap      param1
			bnt      code_05f8
			lap      param1
			jmp      code_0601
code_05f8:
			pushi    #firstTrue
			pushi    2
			pushi    146
			pushi    1
			self     8
code_0601:
			aTop     theItem
			pToa     theItem
			bnt      code_060f
			pushi    #select
			pushi    1
			pushi    1
			send     6
code_060f:
			pToa     theItem
			not     
			bnt      code_0622
			ldi      60
			sat      temp3
			pushi    0
			callk    GetTime,  0
			sat      temp4
			jmp      code_0626
code_0622:
			ldi      0
			sat      temp3
code_0626:
			ldi      0
			sat      temp2
code_062a:
			lat      temp2
			not     
			bnt      code_06aa
			pushi    1
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp1
			push    
			callk    GlobalToLocal,  2
			lat      temp3
			bnt      code_0671
			-at      temp3
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_065b
			pushi    #type
			pushi    1
			pushi    0
			lat      temp1
			send     6
code_065b:
			lst      temp4
			pushi    0
			callk    GetTime,  0
			eq?     
			bnt      code_066b
			jmp      code_065b
			jmp      code_065b
code_066b:
			pushi    0
			callk    GetTime,  0
			sat      temp4
code_0671:
			pushi    #handleEvent
			pushi    1
			lst      temp1
			self     6
			sat      temp2
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			pToa     timer
			bnt      code_068b
			pushi    #doit
			pushi    0
			send     4
code_068b:
			lst      temp2
			ldi      65535
			eq?     
			bt       code_0699
			pToa     busy
			not     
			bnt      code_062a
code_0699:
			ldi      0
			sat      temp2
			pushi    2
			pTos     theItem
			pushi    0
			callk    EditControl,  4
			jmp      code_06aa
			jmp      code_062a
code_06aa:
			ldi      0
			aTop     busy
			lat      temp2
			ret     
		)
	)
	
	(method (dispose)
		(if (== self gTheNewDialog)
			(SetPort local0)
			(= gTheNewDialog 0)
			(= local0 0)
		)
		(if window (window dispose:))
		(= window 0)
		(if timer (timer dispose: delete:))
		(= theItem 0)
		(super dispose:)
	)
	
	(method (open param1 param2)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements?) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open:
		)
		(if time (Timer setReal: self time))
		(self draw:)
	)
	
	(method (draw)
		(self eachElementDo: #draw)
	)
	
	(method (cue)
		(if (not busy) (self dispose:) else (= busy 0))
	)
	
	(method (advance &tmp temp0 dialogFirst)
		(if theItem
			(theItem select: 0)
			(= dialogFirst (self contains: theItem))
			(repeat
				(if (not (= dialogFirst (self next: dialogFirst)))
					(= dialogFirst (self first:))
				)
				(= theItem (NodeValue dialogFirst))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
		)
	)
	
	(method (retreat &tmp temp0 dialogLast)
		(if theItem
			(theItem select: 0)
			(= dialogLast (self contains: theItem))
			(repeat
				(if (not (= dialogLast (self prev: dialogLast)))
					(= dialogLast (self last:))
				)
				(= theItem (NodeValue dialogLast))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
		)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (center)
		(self
			moveTo:
				(+
					(window brLeft?)
					(/
						(-
							(- (window brRight?) (window brLeft?))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop?)
					(/
						(-
							(- (window brBottom?) (window brTop?))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)
	
	(method (setSize &tmp dialogFirst temp1 [theNsTop 4])
		(if text
			(TextSize @[theNsTop 0] text 0 -1)
			(= nsTop [theNsTop 0])
			(= nsLeft [theNsTop 1])
			(= nsBottom [theNsTop 2])
			(= nsRight [theNsTop 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(= dialogFirst (self first:))
		(while dialogFirst
			(if
			(< ((= temp1 (NodeValue dialogFirst)) nsLeft?) nsLeft)
				(= nsLeft (temp1 nsLeft?))
			)
			(if (< (temp1 nsTop?) nsTop) (= nsTop (temp1 nsTop?)))
			(if (> (temp1 nsRight?) nsRight)
				(= nsRight (temp1 nsRight?))
			)
			(if (> (temp1 nsBottom?) nsBottom)
				(= nsBottom (temp1 nsBottom?))
			)
			(= dialogFirst (self next: dialogFirst))
		)
		(= nsRight (+ nsRight 4))
		(= nsBottom (+ nsBottom 4))
		(self moveTo: 0 0)
	)
	
	(method (handleEvent pEvent &tmp theTheItem)
		(if
			(or
				(pEvent claimed?)
				(== (pEvent type?) evNULL)
				(and
					(!= evMOUSEBUTTON (pEvent type?))
					(!= evKEYBOARD (pEvent type?))
					(!= evJOYSTICK (pEvent type?))
					(!= evJOYDOWN (pEvent type?))
				)
			)
			(EditControl theItem pEvent)
			(return 0)
		)
		(if
		(= theTheItem (self firstTrue: #handleEvent pEvent))
			(EditControl theItem 0)
			(if (not (theTheItem checkState: 2))
				(if theItem (theItem select: 0))
				((= theItem theTheItem) select: 1)
				(theTheItem doit:)
				(= theTheItem 0)
			)
		else
			(= theTheItem 0)
			(cond 
				(
					(and
						(or
							(== (pEvent type?) evJOYDOWN)
							(and
								(== evKEYBOARD (pEvent type?))
								(== KEY_RETURN (pEvent message?))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= theTheItem theItem)
					(EditControl theItem 0)
					(pEvent claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (pEvent type?))
									(== KEY_RETURN (pEvent message?))
								)
								(== evMOUSEBUTTON (pEvent type?))
								(== evJOYDOWN (pEvent type?))
							)
						)
						(and
							(== evKEYBOARD (pEvent type?))
							(== KEY_ESCAPE (pEvent message?))
						)
					)
					(pEvent claimed: 1)
					(= theTheItem -1)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(== KEY_TAB (pEvent message?))
					)
					(pEvent claimed: 1)
					(self advance:)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(== KEY_SHIFTTAB (pEvent message?))
					)
					(pEvent claimed: 1)
					(self retreat:)
				)
				(else (EditControl theItem pEvent))
			)
		)
		(return theTheItem)
	)
)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority -1
		window 0
		type $0000
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)
	
	(method (dispose)
		(DisposeWindow window)
		(super dispose:)
	)
	
	(method (open)
		(= window
			(NewWindow
				top
				left
				bottom
				right
				title
				type
				priority
				color
				back
			)
		)
	)
)
