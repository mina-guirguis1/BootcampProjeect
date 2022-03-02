function editAppts(id){
    var parent = $(this).parent().parent();
	var apptName = parent.children("td:nth-child(1)");
	var apptType = parent.children("td:nth-child(2)");
	var desc = parent.children("td:nth-child(3)");
	var startTime = parent.children("td:nth-child(4)");
	var endTime = parent.children("td:nth-child(5)");
	var buttons = parent.children("td:nth-child(6)");

	console.log("Got variables : " + apptName + " " + endTime)

	$.ajax({
	    type: "GET",

	})
}


function deleteThis(id){
				if (window.confirm('Do you really want to delete record?')) {
					var id = $(this).attr('value');
					var parent = $(this).parent().parent();
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8082/api/v1/appointments/" + id,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							location.reload(true)
						},
						error: function() {
							$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
								$(this).remove();
							});
						}
					});
				}
}
