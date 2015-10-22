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
    $("#tagBox").tagging("getTags");
});
