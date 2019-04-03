#!/usr/bin/env bash

echo "Categories (1-2)"

curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Theoretical Skills"}' localhost:8080/category
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Applied Skills"}' localhost:8080/category

echo "First Year SE (3-15)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Imperative Programming"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Pointer Math", "description": "Student is capable of calculating memory addresses given a struct."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Lists", "description": "Student can implement array & linked lists and can describe the advantages of both designs."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Fundamentals of Computer Systems"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Memory Maps", "description": "Student is capable of reading a memory map."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "x86 Assembly", "description": "Student is capable of writing a short program in x86 assembly."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Discrete Math I"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Set Theory", "description": "Student can reduce sets to lowest forms."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Calculus and Differential Equations"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Integration", "description": "Student can integrate polynomial, exponential, and logarithmic functions."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Optimization", "description": "Student can determine local minimums and maximums using calculus."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Newtonian Mechanics & Maxwells Equations"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Classical Mechanics", "description": "Student can understand the law of universal gravitation."}' localhost:8080/objective

echo "Second Year SE (16-27)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Object-Oriented Programming"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Class Associations", "description": "Student is can explain how classes relate (composition, subclass, interface, etc.)"}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Strategy Pattern", "description": "Student is able to implement strategy pattern."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Digital Electronics"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "State Reduction", "description": "Student can reduce state-based logic circuits to the lowest number of states"}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Verilog", "description": "Student is can describe simple logic circuits in Verilog."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Discrete Math II"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Primality Testing", "description": "Student can use various techniques to determine whether an input number is prime"}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Calculus and Differential Equations IN 3D!"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Multidimensional Integration", "description": "Student can integrate with multiple numbers."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Quantum Physics & Relativity"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Quantum Tunneling", "description": "Student can pretend to understand how quantum tunneling works."}' localhost:8080/objective

echo "Sixth Form Magic (28-43)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Conjuration"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Prime Elements", "description": "Student can explain the differences between prime elements and how they interact in composite objects"}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Basic Conjuration", "description": "Student can conjure objects of the prime elements."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Summoning"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Planar Geography", "description": "Student can explain the differences between the instrumental planes."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Planar Demographics", "description": "Student knows the denizens and their characteristics of the instrumental planes."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Ethereal Summoning", "description": "Student can summon non-sentient entities from the ethereal plane."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Discreet Math"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Arithmetic", "description": "Student can add and subtract discreet numbers (within 10% of actual value)."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Discreet Numbers", "description": "Student can identify discreet numbers for a given time of day."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Inapplicable Mathematics"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Fractional Coordinates", "description": "Student can calculate distances and angles in fractional dimensions."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Metaphysics & Thyme Manipulation"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Constant Manipulation", "description": "Student understands the mechanics of locally adjusting universal constants."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Thyme Speed", "description": "Student can calculate apparent speed of time, and understands how Thyme is defined."}' localhost:8080/objective

echo "First Year SE 2017 (45-46)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Fundamentals of Computer Systems"}' localhost:8080/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Pipelining", "description": "Student is capable of understanding the instruction pipeline."}' localhost:8080/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "ARM Assembly", "description": "Student is capable of writing a short program in ARM assembly."}' localhost:8080/objective

echo "Academic Years SE (46-47)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "First Year"}' localhost:8080/academicyear
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Second Year"}' localhost:8080/academicyear

echo "Academic Years SE 2017 (48-49)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "First Year"}' localhost:8080/academicyear
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Second Year"}' localhost:8080/academicyear

echo "Academic Years Magic (50)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Sixth Form"}' localhost:8080/academicyear

echo "Programs (51-53)"
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Software Engineering"}' localhost:8080/program
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Software Engineering"}' localhost:8080/program
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Applied Magic"}' localhost:8080/program

echo "Calendar Years (54-56)"
curl -i -X POST -H "Content-Type:application/json" -d '{"year": 2015}' localhost:8080/calendaryear
curl -i -X POST -H "Content-Type:application/json" -d '{"year": 2016}' localhost:8080/calendaryear
curl -i -X POST -H "Content-Type:application/json" -d '{"year": 2017}' localhost:8080/calendaryear

echo "Category Associations"
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/4' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/7' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/10' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/12' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/15' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/17' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/20' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/23' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/25' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/27' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/29' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/32' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/33' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/36' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/39' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/42' localhost:8080/category/1/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/44' localhost:8080/category/1/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/5' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/8' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/13' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/18' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/21' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/30' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/34' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/37' localhost:8080/category/2/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/45' localhost:8080/category/2/learningObjectives

echo "Object-Course Associations"
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/4' localhost:8080/course/3/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/5' localhost:8080/course/3/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/7' localhost:8080/course/6/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/8' localhost:8080/course/6/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/10' localhost:8080/course/9/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/12' localhost:8080/course/11/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/13' localhost:8080/course/11/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/15' localhost:8080/course/14/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/17' localhost:8080/course/16/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/18' localhost:8080/course/16/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/20' localhost:8080/course/19/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/21' localhost:8080/course/19/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/23' localhost:8080/course/22/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/25' localhost:8080/course/24/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/27' localhost:8080/course/26/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/29' localhost:8080/course/28/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/30' localhost:8080/course/28/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/32' localhost:8080/course/31/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/33' localhost:8080/course/31/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/34' localhost:8080/course/31/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/36' localhost:8080/course/35/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/37' localhost:8080/course/35/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/39' localhost:8080/course/38/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/41' localhost:8080/course/40/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/42' localhost:8080/course/40/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/44' localhost:8080/course/43/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/45' localhost:8080/course/43/learningObjectives

echo "AcademicYear-Course Associations"
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/46' localhost:8080/course/3/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/46' localhost:8080/course/6/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/46' localhost:8080/course/9/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/46' localhost:8080/course/11/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/46' localhost:8080/course/14/academicYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/47' localhost:8080/course/16/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/47' localhost:8080/course/19/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/47' localhost:8080/course/22/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/47' localhost:8080/course/24/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/47' localhost:8080/course/26/academicYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/48' localhost:8080/course/43/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/48' localhost:8080/course/6/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/48' localhost:8080/course/9/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/48' localhost:8080/course/11/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/48' localhost:8080/course/14/academicYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/49' localhost:8080/course/16/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/49' localhost:8080/course/19/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/49' localhost:8080/course/22/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/49' localhost:8080/course/24/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/49' localhost:8080/course/26/academicYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/50' localhost:8080/course/28/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/50' localhost:8080/course/31/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/50' localhost:8080/course/35/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/50' localhost:8080/course/38/academicYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/academicyear/50' localhost:8080/course/40/academicYears

echo "AcademicYear-Program Associations"
curl -i -X PUT -H "Content-Type:text/uri-list" -d '/program/51' localhost:8080/academicyear/46/program
curl -i -X PUT -H "Content-Type:text/uri-list" -d '/program/51' localhost:8080/academicyear/47/program

curl -i -X PUT -H "Content-Type:text/uri-list" -d '/program/52' localhost:8080/academicyear/48/program
curl -i -X PUT -H "Content-Type:text/uri-list" -d '/program/52' localhost:8080/academicyear/49/program

curl -i -X PUT -H "Content-Type:text/uri-list" -d '/program/53' localhost:8080/academicyear/50/program

echo "calendaryear-Program Associations"
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/program/51/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/program/51/calendarYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/program/52/calendarYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/program/53/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/program/53/calendarYears

echo "calendaryear-Course Associations"

curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/3/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/6/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/9/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/11/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/14/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/16/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/19/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/22/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/24/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/26/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/54' localhost:8080/course/38/calendarYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/3/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/6/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/9/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/11/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/14/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/16/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/19/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/22/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/24/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/26/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/28/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/31/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/35/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/38/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/55' localhost:8080/course/40/calendarYears

curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/43/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/6/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/9/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/11/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/14/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/16/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/19/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/22/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/24/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/26/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/28/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/31/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/35/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/38/calendarYears
curl -i -X POST -H "Content-Type:text/uri-list" -d '/calendaryear/56' localhost:8080/course/40/calendarYears
