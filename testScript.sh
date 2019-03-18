#!/usr/bin/env bash
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Negotiate with Demons", "description": "Student is capable of negotiating favourable terms with demons."}' http://random4806.herokuapp.com/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Identifying Items", "description": "Student is capable of identifying magical items by touch, spell, and eBay valuation."}' http://random4806.herokuapp.com/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Imperative Programming", "description": "Student is capable of writing with if statements and loops."}' http://random4806.herokuapp.com/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Pointer Math", "description": "Student is capable of getting to the correct locations in memory given a type definition."}' http://random4806.herokuapp.com/objective
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Requirements Engineering", "description": "Student is capable of writing well-defined and clear requirements."}' http://random4806.herokuapp.com/objective

curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Magic"}' http://random4806.herokuapp.com/course
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Introduction to Programming"}' http://random4806.herokuapp.com/course

curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Communication Skills"}' http://random4806.herokuapp.com/category
curl -i -X POST -H "Content-Type:application/json" -d '{"name": "Technical Skills"}' http://random4806.herokuapp.com/category

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/1' http://random4806.herokuapp.com/course/6/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/2' http://random4806.herokuapp.com/course/6/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/3' http://random4806.herokuapp.com/course/7/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/4' http://random4806.herokuapp.com/course/7/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/5' http://random4806.herokuapp.com/course/7/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/1' http://random4806.herokuapp.com/category/8/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/5' http://random4806.herokuapp.com/category/8/learningObjectives

curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/2' http://random4806.herokuapp.com/category/9/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/3' http://random4806.herokuapp.com/category/9/learningObjectives
curl -i -X POST -H "Content-Type:text/uri-list" -d '/objective/4' http://random4806.herokuapp.com/category/9/learningObjectives