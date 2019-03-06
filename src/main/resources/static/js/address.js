$(document).ready(function() {
    $.ajax({
        url: window.location.protocol + "//" + window.location.hostname + "/viewCourses"
    }).then(function(data) {
        $('.courseInfo').append(data.toString());
    });
});