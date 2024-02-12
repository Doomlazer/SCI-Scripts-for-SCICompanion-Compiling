;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use dInvD)
(use Interface)
(use Print)
;(use PolyEdit)
;(use WriteFeature)
(use Feature)
(use Window)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
)

(local
	[local0 27]
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 10 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (localproc_1)
	(if (OneOf (gCurRoom style:) 11 12 13 14)
		(gCurRoom drawPic: (gCurRoom picture:) 100 style: 100)
	)
)

(instance debugHandler of Feature
	(properties)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
		(DisposeScript 974)
		(DisposeScript 10)
		(DisposeScript 25)
	)

	(method (handleEvent event &tmp [temp0 150] [temp150 10] temp160 temp161 temp162 temp163 temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 temp173 temp174 temp175 temp176 temp177 temp178)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp162 (gCast first:)))
							temp162
							((= temp162 (gCast next: temp162)))
							
							(= temp164 (NodeValue temp162))
							(Format ; "class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
								@temp0
								10
								1
								((temp164 -super-:) name:)
								(temp164 view:)
								(temp164 loop:)
								(temp164 cel:)
								(temp164 x:)
								(temp164 y:)
								(temp164 z:)
								(temp164 heading:)
								(temp164 priority:)
								(temp164 signal:)
								(if (temp164 isKindOf: Actor)
									(temp164 illegalBits:)
								else
									-1
								)
							)
							(if
								(not
									(Print
										addText: @temp0
										window: SysWindow
										title: (temp164 name:)
										addIcon:
											(temp164 view:)
											(temp164 loop:)
											(temp164 cel:)
										init:
									)
								)
								(break)
							)
						)
					)
;;;					(KEY_ALT_b
;;;						(PolyEdit doit:)
;;;					)
					(KEY_ALT_c
						(localproc_1)
						(Show 4)
					)
					(KEY_ALT_d
						(Print
							addText: {ADD to to total TriggerEvent}
							addEdit: @temp162 5 100 20 {$}
							init:
						)
						(= gMustDos (| gMustDos (ReadNumber @temp162)))
					)
					(KEY_ALT_e
						(Print
							addText: {SUBTRACT to to total TriggerEvent}
							addEdit: @temp162 5 100 20 {$}
							init:
						)
						(= gMustDos (& gMustDos (~ (ReadNumber @temp162))))
					)
;;;					(KEY_ALT_f
;;;						(gFeatures eachElementDo: #perform (ScriptID 25 2) 0) ; showFeatureCode
;;;						(gCast eachElementDo: #perform (ScriptID 25 2) 1) ; showFeatureCode
;;;						(NameFeatureCode init:)
;;;					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 6 {Variable No.})
						(= temp162 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 6 {Value})
						(= [gEgo temp162] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(Print
							addText: {Global number:}
							addEdit: @temp0 6 0 12
							init:
						)
						(= temp162 (ReadNumber @temp0))
						(if (IsObject [gEgo temp162])
							(Format
								@temp0
								{ Global %d: %s }
								temp162
								([gEgo temp162] name:)
							)
						else
							(Format
								@temp0
								{ Global %d: %d }
								temp162
								[gEgo temp162]
							)
						)
						(Prints @temp0)
					)
					(KEY_ALT_i
						((ScriptID 25 0) doit:) ; dInvD
					)
;;;					(KEY_ALT_j
;;;						(JustifyText init:)
;;;					)
					(KEY_ALT_k
						(= temp160 (GetPort))
						(SetPort 0)
						(= temp171 5)
						(= temp172 16)
						(= temp167 15)
						(= temp168 80)
						(= temp170 (+ temp167 (* 34 temp171)))
						(= temp169 (+ temp168 (* 10 temp172)))
						(= temp165 (Graph grSAVE_BOX temp167 temp168 temp170 temp169 1))
						(Graph grFILL_BOX temp167 temp168 temp170 temp169 1 255)
						(for ((= temp166 0)) (< temp166 256) ((++ temp166))
							(Graph
								grFILL_BOX
								(+ temp167 temp171 (* temp171 (/ temp166 8)))
								(+ temp168 temp172 (* 16 (mod temp166 8)))
								(+
									temp167
									temp171
									temp171
									(* temp171 (/ temp166 8))
								)
								(+
									temp168
									temp172
									temp172
									(* temp172 (mod temp166 8))
								)
								1
								temp166
							)
						)
						(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
						(repeat
							(= temp161 (Event new:))
							(if
								(or
									(== (temp161 type:) evMOUSEBUTTON)
									(== (temp161 type:) evKEYBOARD)
								)
								(break)
							)
							(temp161 dispose:)
						)
						(temp161 dispose:)
						(Graph grRESTORE_BOX temp165)
						(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
						(SetPort temp160)
					)
					(KEY_ALT_l
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(SetFlag temp162)
					)
					(KEY_ALT_m
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(ClearFlag temp162)
					)
					(KEY_ALT_n
						(= temp0 0)
						(= temp162 (GetNumber {Flag No.}))
						(Format @temp0 {%d} (IsFlag temp162))
						(Prints @temp0)
					)
					(KEY_ALT_o
						((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_q
						(gGame detailLevel: 1)
					)
					(KEY_ALT_r
						(Format ; "name: %s number: %d current pic: %d style: %d horizon: %d north: %d south: %d east: %d west: %d script: %s"
							@temp0
							10
							2
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom curPic:)
							(gCurRoom style:)
							(gCurRoom horizon:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(if (IsObject (gCurRoom script:))
								((gCurRoom script:) name:)
							else
								{..none..}
							)
						)
						(Print width: 120 addText: @temp0 init:)
						(gGame showMem:)
					)
					(KEY_ALT_s
						(= temp0 0)
						(if
							(Print
								addText: {Which Format?}
								addButton: 0 {String} 0 12
								addButton: 1 {Message} 50 12
								init:
							)
							(= temp174 (GetNumber {Noun?} 0))
							(= temp175 (GetNumber {Verb?} 0))
							(= temp176 (GetNumber {Case?} 0))
							(= temp177 (GetNumber {Sequence?} 0))
							(Message msgGET temp174 temp175 temp176 temp177 @temp0)
						else
							(GetInput @temp0 50 {String to display?})
						)
						(= temp167 (GetNumber {Y Parameter?} 0))
						(= temp168 (GetNumber {X Parameter?} 0))
						(= temp162 (GetNumber {Box Width?} 0))
						(if (not (= temp163 (GetNumber {Font Number?} 0)))
							(= temp163 gUserFont)
						)
						(Print
							posn: temp168 temp167
							width: temp162
							font: temp163
							addText: @temp0
							init:
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp162 (GetNumber {Teleport to})) 0)
							(gCurRoom newRoom: temp162)
						)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 4 5 6)
					)
					(KEY_ALT_v
						(Show 1)
						(gAddToPics doit:)
					)
;;;					(KEY_ALT_w
;;;						(WriteCode doit:)
;;;					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_y
						(if
							(Print
								addText: {Which subject?}
								addEdit: @temp150 7 100 0 {$}
								addText: {Whatcha wanna do with it?} 0 12
								addButton: 0 { Stuff it } 0 26
								addButton: 1 {Unstuff it} 75 26
								init:
							)
							((ScriptID 21 1) doit: (ReadNumber @temp150)) ; dropCluesCode
						else
							((ScriptID 21 0) doit: (ReadNumber @temp150)) ; addCluesCode
						)
					)
					(KEY_QUESTION
						(Prints
							{Debug options:      (Page 1 of 5)\n\n   A - Show cast\n   B - Polygon editor\n   C - Show control map\n   D - Place an actor\n   E - Show ego info\n   F - Show feature outlines\n   G - Set global\n}
						)
						(Prints
							{Debug options:      (Page 2 of 5)\n\n   H - Show global\n   I - Get inventory item\n   J - Justify text on screen\n   K - Show palette\n   L - Set flag\n   M - Clear flag\n   N - Show flag\n}
						)
						(Prints
							{Debug options:      (Page 3 of 5)\n\n   O - QA Note Logger\n   P - Show priority map\n   Q - Set Detail to 1\n   R - Show room info/free memory\n   S - Show a string or message\n   T - Teleport\n   U - Give HandsOn\n}
						)
						(Prints
							{Debug options:      (Page 4 of 5)\n\n   V - Show visual map\n   W - Feature writer\n   Y - Stuff or Unstuff a clue\n   X,Z - Quick quit\n}
						)
						(Prints
							{Debug options:      (Page 5 of 5)\n\n  A=Alt, C=Ctrl, L=Left shift, R=Right shift\n\n  Left click:\n    A       Move ego\n    CL      Show ego\n    CR      Show room\n    CA      Show position\n}
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
					($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
					($000c ; emALT | emCTRL
						(event claimed: 1)
						(Format @temp0 10 3 (event x:) (event y:)) ; "%d/%d"
						(= temp160
							(Print
								posn: 160 10
								font: 999
								modeless: 1
								addText: @temp0
								init:
							)
						)
						(while (!= evMOUSERELEASE ((= temp161 (Event new:)) type:))
							(temp161 dispose:)
						)
						(temp161 dispose:)
						(temp160 dispose:)
					)
					($0005 ; emCTRL | emRIGHT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_r)
						(self handleEvent: event)
					)
					($0006 ; emCTRL | emLEFT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_e)
						(self handleEvent: event)
					)
					($0009 0) ; emALT | emRIGHT_SHIFT
					($000a 0) ; emALT | emLEFT_SHIFT
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(event claimed: 1)
						(= temp178 (gGame setCursor: 996))
						(= temp173
							(if global122
								global122
							else
								(User alterEgo:)
							)
						)
						(= temp162 (temp173 signal:))
						(temp173 startUpd:)
						(while (!= evMOUSERELEASE ((= temp161 (Event new:)) type:))
							(temp173 x: (temp161 x:) y: (- (temp161 y:) 10))
							(Animate (gCast elements:) 0)
							(temp161 dispose:)
						)
						(temp161 dispose:)
						(gGame setCursor: temp178)
						(temp173 signal: temp162)
					)
				)
			)
		)
	)
)