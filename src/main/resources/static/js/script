$(document).ready(function() {
	$("form").submit(function(event) {
		event.preventDefault();
		event.returnValue = false;

		// do things
		$.ajax({
			url: window.location.protocol + "//" + window.location.hostname + "/book/" + document.getElementById('idBox').value +"/entries",
			data: {
				format: 'json'
			},
			error: function() {
				$('#results').html('Communication Error.');
			},
			dataType: 'json',
			success: function(data) {
				var id = document.getElementById('idBox').value;
				if (data.length == 0) {
					$('#results').html("Address Book " + id + " does not exist");
				} else {
					var output = "<header>Address Book #" + id + "</header>";
					output += "<table><tr><th>Name</th><th>Address</th><th>Phone</th></tr>";
					for (var n = 0; n < data._embedded.buddy.length; n++) {
						output += "<tr><td>" + data._embedded.buddy[n].name + "</td>";
						output += "<td>" + data._embedded.buddy[n].address + "</td>";
						output += "<td>" + data._embedded.buddy[n].phone + "</td></tr>";
					}
					output += "</table>";
					$('#results').html(output);
				}
			},
			type: 'GET'
		});
	});
});