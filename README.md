#Greeps Interlude  

In this assignment we will be programming a gaming scenario in Greenfoot.  Greenfoot is a gaming simulation platform written by the same group that wrote BlueJ.  

In this environment, you program a series of "Actors" which are Java Classes that interact in a "World".

You can download the Greenfoot software from [here](http://www.greenfoot.org/download).
This scenario is part of the book 

    "Introduction to Programming with Greenfoot"
    (Second edition)
    by Michael Kölling
    ISBN: 0134054296


Improve the "Greeps" implementation to help the Greeps collect tomatoes!
It's important. (At least to them...)

Your task is to program the Greeps to collect as many tomatoes as possible.
You may ONLY CHANGE THE GREEP class. You may not change any other class.


##The rules are:

Rule 1. Only change the class 'Greep'. No other classes may be modified or 
    created.

Rule 2. No additional fields. You cannot extend the Greeps' memory. That is: 
    you are not allowed to add fields to the class (except final fields). You 
    can use the one byte memory that is provided.

Rule 3. You cannot move more than once per 'act' round.

Rule 4. You cannot communicate directly with other Greeps. That is: no field 
    accesses or method calls to other Greep objects are allowed. (Greeps can 
    communicate indirectly via the paint spots on the ground.)

Rule 5. No long vision. You are allowed to look at the world only at the 
    immediate location of the Greep. Greeps are almost blind, and cannot look 
    any further.

Rule 6. No creation of objects. You are not allowed to create any scenario 
    objects (instances of user-defined classes, such as Greep or Paint). Greeps 
    have no magic powers - they cannot create things out of nothing.

Rule 7. No televisionporting. Methods from Actor that cheat normal movement (such as 
    setLocation) may not be used.

