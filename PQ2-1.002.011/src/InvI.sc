;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Obj)


(local
	local0
)
(class InvI of Obj
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
	)
	
	(method (showSelf)
		(proc255_1 (if description else name) view loop cel)
	)
	
	(method (saidMe)
		(Said said)
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner theOwner)
		(return self)
	)
)

(class Inv of Set
	(properties
		elements 0
		size 0
		carrying {You are carrying:}
		empty {You are carrying nothing!}
	)
	
	(method (init)
		(= gInv self)
	)
	
	(method (showSelf param1 &tmp temp0 [temp1 30] [temp31 301] gInvFirst temp333)
		(StrCpy @temp31 carrying)
		(= temp0 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			((= temp333 (NodeValue gInvFirst)) ownedBy: param1)
				(if temp0 (StrCat @temp31 {,}))
				(++ temp0)
				(StrCat @temp31 (Format @temp1 995 0 (temp333 name?)))
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(if temp0
			(StrCat @temp31 {.})
			(proc255_0 @temp31)
		else
			(proc255_0 empty)
		)
	)
	
	(method (saidMe param1)
		(self firstTrue: #saidMe param1)
	)
	
	(method (ownedBy param1)
		(self firstTrue: #ownedBy param1)
	)
)
