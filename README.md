# 4806project

Milestone 1 - Learning Outcomes Management System

In this milestone we implemented a simple version of the system, but there are many issues that remain. For starters, we don't 
actually access the DB now for the searches, we must add the courses, objectives and categories dynamically at the start. We also only 
have the searches for courses now; program search or category search are yet to be implemented. We also don't mention the 'year' 
that the course is offered in yet, so the search will show all the courses (if there were multiple over multiple years). The next steps
we must take are essentially to complete all the missing features that are mentioned previously. Currently we only have one test that is 
quite complex, so for the next milestone we should implement many smaller tests and also test all the features that will be implemented.
Lastly, we need to implement the ability to export the results as a CSV file.


Milestone 2 

In this iteration, all of the entities needed have been implemented. This included creating AcademicYear, CalendarYear, and Program classes. Last iteration we were missing the proper documentation diagrams which are now included, and we also added all necessary unit tests. The only test on the last iteration (httpTest) used to just be one large test but now it has been split into several smaller tests so it's easier to track errors. Repositories were added for most of the new entities, but we still need to include a CalendarYear repository. 
