$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/viewCourses?id=1"
    }).then(function(data) {
        $('.courseInfo').append(data.toString());
    });
});