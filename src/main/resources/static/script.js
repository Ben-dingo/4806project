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
			$("#courseBox").removeClass("hidden");
			$("#categoryBox").removeClass("hidden");
			$("#academicBox").addClass("hidden");
		} else {
			$("#academicBox").addClass("hidden");
			$("#programBox").addClass("hidden");
			$("#courseBox").addClass("hidden");
			$("#categoryBox").addClass("hidden");
		}

		reloadProgram();
		reloadAcademic();
		reloadCategory();
		reloadCourse(updateCourseDrop);
		reloadCourse(reloadTable);
	});

	$("#programDrop").change(function() {
		if ($("#programDrop").children("option:selected").val() != 'none') {
			$("#academicBox").removeClass("hidden");
		} else {
			$("#academicBox").addClass("hidden");
		}

		reloadAcademic();
		reloadCourse(updateCourseDrop);
		reloadCourse(reloadTable);
	});

	$("#academicDrop").change(function() {
		reloadCourse(updateCourseDrop);
		reloadCourse(reloadTable);
	});

	$("#courseDrop").change(function() {
		reloadCourse(reloadTable);
	});

	$("#categoryDrop").change(function() {
		reloadCourse(reloadTable);
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
			$('#programDrop').html("<option value='none'>Select a program</option>");
			$('#academicDrop').html("<option value='none'>Select an academic year</option>");
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
			$('#academicDrop').html("<option value='none'>Select an academic year</option>");
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
			$('#categoryDrop').html("<option value='none'>Select a category</option>");
		}
	}

	function reloadCourse(callback) {
		if ($("#academicDrop").children("option:selected").val() != 'none') {
			var set = new Set();
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
							set.add(data._embedded.course[n]._links.self.href);
						}
					}
					callback(set);
				}
			});
		} else {
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
							var academicYears = [];
							for (var n = 0; n < data._embedded.academicyear.length; n++) {
								academicYears.push(data._embedded.academicyear[n]._links.self.href);
							}

							$.when.apply($, academicYears.map(function(url) {
								return $.ajax(url + "/courses");
							})).done(function() {
								var results = new Set();
								if (academicYears.length == 1) {
									for (var n = 0; n < arguments[0]._embedded.course.length; n++) {
										results.add(arguments[0]._embedded.course[n]._links.self.href);
									}
									callback(results);
								} else if (academicYears.length > 1) {
									for (var i = 0; i < arguments.length; i++) {
										for (var n = 0; n < arguments[i][0]._embedded.course.length; n++) {
											results.add(arguments[i][0]._embedded.course[n]._links.self.href);
										}
									}
									callback(results);
								}
							});
						}
					}
				});
			} else {
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
								callback(set);
							}
						}
					});
				}
			}
		}
	}

	function updateCourseDrop(set) {
		if (set.size == 0) {
			$("#courseBox").addClass("hidden");
			$('#courseDrop').html("<option value='none'>Select a course</option>");
			return;
		}
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

	function reloadTable(set) {
		var courses;
		if ($("#courseDrop").children("option:selected").val() == 'none') {
			courses = Array.from(set);
		} else {
			courses = [];
			courses.push($("#courseDrop").children("option:selected").val());
		}
		$.when.apply($, courses.map(function(url) {
			return $.ajax(url + "/learningObjectives");
		})).done(function() {
			var courseObjectives = new Set();
			if (courses.length == 1) {
				for (var n = 0; n < arguments[0]._embedded.objective.length; n++) {
					courseObjectives.add(arguments[0]._embedded.objective[n]._links.self.href);
				}
			} else if (courses.length > 1) {
				for (var i = 0; i < arguments.length; i++) {
					for (var n = 0; n < arguments[i][0]._embedded.objective.length; n++) {
						courseObjectives.add(arguments[i][0]._embedded.objective[n]._links.self.href);
					}
				}
			} else {
				return;
			}

			if ($("#categoryDrop").children("option:selected").val() != 'none') {
				$.ajax({
					url: $("#categoryDrop").children("option:selected").val() + "/learningObjectives",
					data: {
						format: 'json'
					},
					error: function() {
						alert("No objectives exist.");
					},
					dataType: 'json',
					success: function(data) {
						if (data.length == 0) {
							alert("No objectives exist.");
						} else {
							var categoryObjectives =  new Set();
							for (var n = 0; n < data._embedded.objective.length; n++) {
								categoryObjectives.add(data._embedded.objective[n]._links.self.href);
							}
							updateTable(setIntersect(courseObjectives, categoryObjectives));
						}
					}
				});
			} else {
				updateTable(courseObjectives);
			}
		});


	}

	function updateTable(input) {
		var objectives = Array.from(input);
		$.when.apply($, objectives.map(function (url) {
			return $.ajax(url);
		})).done(function () {
			var output = "<table><th>Objective</th><th>Description</th>"
			if (objectives.length == 1) {
				output += "<tr><td>" + arguments[0].name +"</td><td>" + arguments[0].description + "</td></tr>"
			} else if (objectives.length > 1) {
				for (var i = 0; i < arguments.length; i++) {
					output += "<tr><td>" + arguments[i][0].name +"</td><td>" + arguments[i][0].description + "</td></tr>"
				}
			}
			output += "</table>";
			$('#outputForm').html(output);
		});
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