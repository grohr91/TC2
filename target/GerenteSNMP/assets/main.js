$(function ($) {
    $("#accordion").find("a").click();
});

function clearForm(formId) {
    $("#" + formId).find("input").val("");
}

function testConnection() {
    $.ajax({
        url: "http://localhost:8084/TC2/testConnection",
        data: $("#connectionForm").serialize()
    }).done(function (data) {
        if (console && console.log) {
            console.log("Sample of data: ", data.dsMessage);
        }
    });
}