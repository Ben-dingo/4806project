$(document).ready(function() {
	function getUrlVars()
	{
		var vars = [], hash;
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			vars.push(hash[0]);
			vars[hash[0]] = hash[1];
		}
		return vars;
	}

	function drawTable(contents) {
		var output = "<header>Address Book #" + id + "</header>";
		output += "<table>\n" +
			"<tr>" +
			"<th>Name</th>" +
			"<th>Address</th>" +
			"<th>Phone</th>" +
			"</tr>"
		output += contents;
		output += "</table>";
		output += "<form id=\"addBuddy\">" +
			"Name: <input id=nameInput type=\"text\" name=\"buddyName\"><br>" +
			"Phone: <input id=phoneInput type=\"text\" name=\"buddyPhone\"><br>" +
			"Address: <input id=addressInput type=\"text\" name=\"buddyAddress\"><br>" +
			"<input type=\"submit\" value=\"Add Buddy\">" +
			"</form>";
		$('#results').html(output);
		attachBuddyInputForm();
	}

	function reloadTable() {
		$.ajax({
			url: window.location.protocol + "//" + window.location.hostname + "/book/" + id + "/entries",
			data: {
				format: 'json'
			},
			error: function() {
				$('#results').html("Address Book " + id + " does not exist");
			},
			dataType: 'json',
			success: function(data) {
				if (data.length == 0) {
					$('#results').html("Address Book " + id + " does not exist");
				} else {
					var contents = "";
					for (var n = 0; n < data._embedded.buddy.length; n++) {
						contents += "<tr><td>" + data._embedded.buddy[n].name + "</td>";
						contents += "<td>" + data._embedded.buddy[n].address + "</td>";
						contents += "<td>" + data._embedded.buddy[n].phone + "</td></tr>";
					}
					drawTable(contents);
				}
			},
			type: 'GET'
		});
	}

	var id = getUrlVars()["id"];
	$("#viewBook").submit(function(event) {
		event.preventDefault();
		event.returnValue = false;
		id = $("#idBoxView").val();

		// do things
		reloadTable();
	});

	$("#addBook").submit(function(event) {
        event.preventDefault();
        event.returnValue = false;

        // do things
        $.ajax({
            url: window.location.protocol + "//" + window.location.hostname + "/book",
            data: '{}',
			processData: false,
			contentType: "application/json",
			type: 'POST',
            error: function() {
                $('#results').html('Failed to create new address book.');
            },
            dataType: 'json',
            success: function(data) {
                if (data.length == 0) {
                    $('#results').html("Failed to create new address book.");
                } else {
					returnURL = data._links.self.href.split("/");
					for (var n = 0; n < returnURL.length; n++) {
						id = returnURL[n];
					}
					drawTable("");
                }
            }
        });
    });

	function attachBuddyInputForm() {
		$("#addBuddy").submit(function(event) {
			event.preventDefault();
			event.returnValue = false;

			// do things
			$.ajax({
				url: window.location.protocol + "//" + window.location.hostname + "/buddy",
				data: '{' +
					'"name": "' + $("#nameInput").val() +'",' +
					'"phone": "' + $("#phoneInput").val() +'",' +
					'"address": "' + $("#phoneInput").val() +
					'}',
				processData: false,
				contentType: "application/json",
				type: 'POST',
				error: function() {
					$('#results').html('Failed to add buddy.');
				},
				dataType: 'json',
				success: function(data) {
					if (data.length == 0) {
						$('#results').html('Failed to add buddy.');
					} else {
						returnURL = data._links.self.href.split("/");
						var buddyID;
						for (var n = 0; n < returnURL.length; n++) {
							buddyID = returnURL[n];
						}
						$.ajax({
							url: window.location.protocol + "//" + window.location.hostname + "/book" + id,
							data: '/buddy/' + buddyID,
							processData: false,
							contentType: "text/uri-list",
							type: 'POST',
							error: function() {
								$('#results').html('Failed to associate buddy.');
							},
							dataType: 'json',
							success: function(data) {
								if (data.length == 0) {
									$('#results').html('Failed to associate buddy.');
								} else {
									reloadTable();
								}
							}
						});
					}
				}
			});
		});
	}
});