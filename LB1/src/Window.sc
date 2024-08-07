;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 981)
(include sci.sh)
(use System)

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
		type 0
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (dispose)
		(DisposeWindow window)
		(super dispose:)
	)
)

(class Window of SysWindow
	(properties
		underBits 0
	)

	(method (center)
		(self
			moveTo:
				(/ (- (- brRight left) (- right left)) 2)
				(/ (- (- brBottom top) (- bottom top)) 2)
		)
	)

	(method (move h v)
		(= left (+ left h))
		(= right (+ right v))
		(= right (+ right h))
		(= bottom (+ bottom v))
	)

	(method (moveTo h v)
		(self move: (- h left) (- v top))
	)

	(method (inset h v)
		(= top (+ top v))
		(= left (+ left h))
		(= bottom (- bottom v))
		(= right (- right h))
	)

	(method (setMapSet &tmp mapSet)
		(= mapSet 0)
		(if (!= -1 color)
			(= mapSet (| mapSet $0001))
		)
		(if (!= -1 priority)
			(= mapSet (| mapSet $0002))
		)
		(return mapSet)
	)

	(method (show)
		(kernel_112 grUPDATE_BOX top left bottom right (self setMapSet:))
	)

	(method (draw v p)
		(if (>= argc 1)
			(= color v)
		)
		(if (>= argc 2)
			(= priority p)
		)
		(kernel_112 grFILL_BOX top left bottom right (self setMapSet:) color priority)
	)

	(method (save)
		(= underBits (kernel_112 grSAVE_BOX top left bottom right (self setMapSet:)))
	)

	(method (restore)
		(if underBits
			(kernel_112 grRESTORE_BOX underBits)
		)
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (doit))

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(self restore:)
		(if window
			(DisposeWindow window)
		)
		(super dispose:)
	)

	(method (erase)
		(self draw: back -1)
	)
)

