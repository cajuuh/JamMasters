/**
 * Created by Pedro on 17/09/2015.
 */
var my_custom_options = {
    "no-spacebar" : true,
    "case-sensitive" : false,
    "edit-on-delete" : false
}

$(document).ready(function(){
    $("#tagBox").tagging(my_custom_options);
    var instrumentos = $("#tagBox").tagging("getTags");

    $('btn btn-primary').click(function(){
        $.ajax({
            url: "/",
            type: "POST",
            data: {myArray : instrumentos}
        }).done(function(data,text,jQxhr){
            alert("success");
        });
    });

});

