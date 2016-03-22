$(function ($) {
    $("#accordion").find("a").click();
});

function clearForm(formId){
    $("#" + formId).find("input").val("");
}