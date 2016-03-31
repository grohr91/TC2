$(function ($) {
    setUp();
});

function setUp() {
    $.blockUI.defaults.message = '<h3><i class="glyphicon glyphicon-refresh glyphicon-spin"></i> Processing</h3>';
    $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
}

function clearForm(formId) {
    $("#" + formId).find("input").val("");
}

function testConnection() {
    $.ajax({
        url: $("#url").val() + "/TC2/testConnection",
        data: $("#connectionForm").serialize()
    }).done(function (data) {
        if (data.dsMessage == null || data.dsMessage == "") {
            $("#message-div").empty().append(
                    "<div class='alert alert-success' role='alert'>"
                    + "Connection OK</div>");
        } else {
            $("#message-div").empty().append(data.dsMessage);
        }
    });
}