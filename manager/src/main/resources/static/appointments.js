function editAppts(id){

	console.log("Editing the id : " + id)

	$.ajax({
	    type: "GET",
	    url: "",
	    cache: false,
	    success : function(){
	        document.getElementById('Id').value='new value';

	    },+

	})
}

function deleteThis(id){
				if (window.confirm('Do you really want to delete record?')) {
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8082/api/v1/appointments/" + id,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							location.reload(true)
						}
					});
				}
}


