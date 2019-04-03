$(document).ready(function() {
	// Setup the url variable.
	var url = "http://localhost:8080";
	// Setup the calendar dropdown box.
	$.ajax({
		url: url + "/calendaryear/",
		data: {
			format: 'json'
		},
		error: function() {
			$('#outputForm').html("No calendar years exist.");
		},
		dataType: 'json',
		success: function(data) {
			if (data.length == 0) {
				$('#outputForm').html("No calendar years exist.");
			} else {
				var output = "<option value='none'>Select a calendar year</option>";
				for (var n = 0; n < data._embedded.calendaryear.length; n++) {
					output += "<option value='" + data._embedded.calendaryear[n]._links.self.href
								+ "'>" + data._embedded.calendaryear[n].year + "</option>";
				}
				$('#calendarDrop').html(output);
			}
		}
	});

	$("#calendarDrop").change(function() {
		if ($("#calendarDrop").children("option:selected").val() != 'none') {
			$("#programBox").removeClass("hidden");
			$("#academicBox").removeClass("hidden");
			$("#courseBox").removeClass("hidden");
			$("#categoryBox").removeClass("hidden");
		}

		reloadProgram();
		reloadCourse();
		reloadCategory();
		reloadTable();
	});

	$("#programDrop").change(function() {
		if ($("#programDrop").children("option:selected").val() != 'none') {
			$("#academicBox").removeClass("hidden");
		}
		reloadAcademic();
		reloadCourse();
		reloadTable();
	});

	$("#academicDrop").change(function() {
		reloadCourse();
		reloadTable();
	});

	$("#courseDrop").change(function() {
		reloadTable();
	});

	function reloadProgram() {
		if ($("#calendarDrop").children("option:selected").val() != 'none') {
			$.ajax({
				url: $("#calendarDrop").children("option:selected").val() + "/programs",
				data: {
					format: 'json'
				},
				error: function() {
					alert("No programs exist.");
				},
				dataType: 'json',
				success: function(data) {
					if (data.length == 0) {
						alert("No programs exist.");
					} else {
						var output = "<option value='none'>Select a program</option>";
						for (var n = 0; n < data._embedded.program.length; n++) {
							output += "<option value='" + data._embedded.program[n]._links.self.href
								+ "'>" + data._embedded.program[n].name + "</option>";
						}
						$('#programDrop').html(output);
					}
				}
			});
		} else {
			$("#programBox").addClass("hidden");
			$("#academicbox").addClass("hidden");
		}
	}

	function reloadAcademic() {
		if ($("#programDrop").children("option:selected").val() != 'none') {
			$.ajax({
				url: $("#programDrop").children("option:selected").val() + "/academicYears",
				data: {
					format: 'json'
				},
				error: function() {
					alert("No academic years exist.");
				},
				dataType: 'json',
				success: function(data) {
					if (data.length == 0) {
						alert("No academic years exist.");
					} else {
						var output = "<option value='none'>Select a academic year</option>";
						for (var n = 0; n < data._embedded.academicyear.length; n++) {
							output += "<option value='" + data._embedded.academicyear[n]._links.self.href
								+ "'>" + data._embedded.academicyear[n].name + "</option>";
						}
						$('#academicDrop').html(output);
					}
				}
			});
		} else {
			$("#academicbox").addClass("hidden");
		}
	}

	function reloadCategory() {
		if ($("#calendarDrop").children("option:selected").val() != 'none') {
			$.ajax({
				url: url + "/category",
				data: {
					format: 'json'
				},
				error: function() {
					alert("No categories exist.");
				},
				dataType: 'json',
				success: function(data) {
					if (data.length == 0) {
						alert("No categories exist.");
					} else {
						var output = "<option value='none'>Select a category</option>";
						for (var n = 0; n < data._embedded.category.length; n++) {
							output += "<option value='" + data._embedded.category[n]._links.self.href
								+ "'>" + data._embedded.category[n].name + "</option>";
						}
						$('#categoryDrop').html(output);
					}
				}
			});
		} else {
			$("#categoryBox").addClass("hidden");
		}
	}

	function reloadCourse() {
		if ($("#calendarDrop").children("option:selected").val() != 'none') {
			$.ajax({
				url: $("#calendarDrop").children("option:selected").val() +  "/courses",
				data: {
					format: 'json'
				},
				error: function() {
					alert("No courses exist.");
				},
				dataType: 'json',
				success: function(data) {
					if (data.length == 0) {
						alert("No courses exist.");
					} else {
						var set = new Set();
						for (var n = 0; n < data._embedded.course.length; n++) {
							set.add(data._embedded.course[n]._links.self.href);
						}

						if ($("#academicDrop").children("option:selected").val() != 'none') {
							var set2 = new Set();
							$.ajax({
								url: $("#academicDrop").children("option:selected").val() +  "/courses",
								data: {
									format: 'json'
								},
								error: function() {
									alert("No courses exist.");
								},
								dataType: 'json',
								success: function(data) {
									if (data.length == 0) {
										alert("No courses exist.");
									} else {
										for (var n = 0; n < data._embedded.course.length; n++) {
											set2.add(data._embedded.course[n]._links.self.href);
										}
									}
									updateCourseDrop(setIntersect(set, set2));
								}
							});
						} else {
							updateCourseDrop(set);
						}
					}
				}
			});
		} else {
			$("#courseBox").addClass("hidden");
		}
	}

	function updateCourseDrop(set) {
		$.ajax({
			url: url + "/course",
			data: {
				format: 'json'
			},
			error: function() {
				alert("No courses exist.");
			},
			dataType: 'json',
			success: function(data) {
				var output = "<option value='none'>Select a course</option>";
				for (var n = 0; n < data._embedded.course.length; n++) {
					if (set.has(data._embedded.course[n]._links.self.href)) {
						output += "<option value='" + data._embedded.course[n]._links.self.href
							+ "'>" + data._embedded.course[n].name + "</option>";
					}
				}
				$('#courseDrop').html(output);
			}
		})
	}

	function reloadTable() {

	}

	function setIntersect(setA, setB) {
		var _intersection = new Set();
		for (var elem of setB) {
			if (setA.has(elem)) {
				_intersection.add(elem);
			}
		}
		return _intersection;
	}
});