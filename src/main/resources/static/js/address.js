$(document).ready(function(url, id) {
    $.ajax({
        url: window.location.protocol + "//" + window.location.hostname + "/" + url + "?id=" + id
    }).then(function(data) {
        $('.courseInfo').append(data.toString());
    });
});