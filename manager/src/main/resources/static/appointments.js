function editAppts(id){

	console.log("Editing the id : " + id)
	document.getElementById("putmodalhere").innerHTML = '<div class="my-modal-wrapper row justify-content-center">'
                                                            + '<div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">'
                                                                + ' <div class="modal-dialog">'
                                                                 + '    <div class="modal-content">'
                                                                 + '        <div class="modal-header">'
                                                                 + '            <h5 class="modal-title">Add New Appointment</h5>'
                                                                 + '            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>'
                                                                 + '        </div>'
                                                                 + '        <div class="modal-body">'
                                                                 + '            <form id="add3" action="#"  class="add_form">'
                                                                 + '                <div class="mb-3">'
                                                                 + '                    <label for="appt2" class="form-label">Appointment</label>'
                                                                 + '                    <input type="text" class="form-control" id="appt2">'
                                                                 + '                    <label for="type2" class="form-label">Type</label>'
                                                                 + '                    <input type="text" class="form-control" id="type2">'
                                                                 + '                    <label for="desc2" class="form-label">Description</label>'
                                                                 + '                    <input type="text" class="form-control" id="desc2">'
                                                                 + '                    <label for="startTime2" class="form-label">Start Time</label>'
                                                                 + '                    <input type="text" class="form-control" id="startTime2">'
                                                                 + '                    <label for="endTime2" class="form-label">End Time</label>'
                                                                 + '                    <input type="text" class="form-control" id="endTime2">'
                                                                 + '                </div>'
                                                                 + '                <button type="submit" onClick="editAppts()" class="btn btn-primary">Submit</button>'
                                                                 + '            </form>'
                                                                 + '        </div>'
                                                                 + '        <div class="modal-footer">'
                                                                 + '            <!--<button type="submit" id="addNew" class="btn btn-primary">Submit</button>-->'
                                                                 + '        </div>'
                                                                 + '    </div>'
                                                                 + '</div>'
                                                             + '</div>'
                                                         + '</div>';

	/*$.ajax({
	    type: "GET",
	    url: "",
	    cache: false,
	    success : function(){
	        document.getElementById('Id').value='new value';

	    },

	})*/
}

function newAppt(){
    var id = localStorage.getItem("userID");
    var appt = $("#appt").val();
    var type = $("#type").val();
    var desc = $("#desc").val();
    var start = $("#startTime").val();
    var end = $("#endTime").val();
        $.ajax({
            type:"POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8082/api/v1/appointments/",
            data: JSON.stringify(
                {
                    "apptName": appt,
                    "apptType": type,
                    "description": desc,
                    "startTime": start,
                    "endTime": end,
                    "metaData": id
                }),
            cache: false,
            success: function() {
            console.log("Post worked");
            },

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

function editUser(id){
    var id = localStorage.getItem("userID");
      $.getJSON("http://localhost:8081/api/v1/user/id/" + id, function(json){
                      console.log("Got User info!");
                      $("#firstName").val(json.firstName);
                      $("#lastName").val(json.lastName);
                      $("#age").val(json.age);
                      $("#email").val(json.email);
                      $("#gender").val(json.gender);
                      $("#phoneNumber").val(json.phoneNumber);
      })
}

function updateUser(){
        var id = localStorage.getItem("userID");
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var age = $("#age").val();
        var gender = $("#gender").val();
        var email = $("#email").val();
        var phoneNumber = $("#phoneNumber").val();

        $.ajax({
            type:"PUT",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8081/api/v1/" + id,
            data: JSON.stringify(
                {
                    "firstName": firstName,
                    "lastName": lastName,
                    "gender": gender,
                    "age": age,
                    "email": email,
                    "phoneNumber": phoneNumber
                }),
            cache: false,
            success: function() {
            console.log("Put worked");
            },

        })

        }

        $(document).ready(function() {
            var id = localStorage.getItem("userID");

            $.getJSON('http://localhost:8082/api/v1/appointments/findAllByMetaData/' + id, function(json) {
                var tr=[];
                for (var i = 0; i < json.length; i++) {
                tr.push('<tr>');
                tr.push('<td>' + json[i].apptName + '</td>');
                tr.push('<td>' + json[i].apptType + '</td>');
                tr.push('<td>' + json[i].description + '</td>');
                tr.push('<td>' + json[i].startTime + '</td>');
                tr.push('<td>' + json[i].endTime + '</td>');
                tr.push('<td><button type="Submit" value= '+ json[i].id +' id="edit" onclick="editAppts(this.value)" class="btn btn-secondary">Edit</button>&nbsp;&nbsp;<button class="btn btn-warning" id="delete" onclick="deleteThis(this.value)" value='+ json[i].id +'>Delete</button></td>');
                tr.push('</tr>');
                }
                $('table').append($(tr.join('')));
            })});


