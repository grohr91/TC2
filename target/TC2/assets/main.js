$(function ($) {
    setUp();
});

function setUp() {
    $.blockUI.defaults.message = '<h3><i class="glyphicon glyphicon-refresh glyphicon-spin"></i> Processing</h3>';
    $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
    $('[href="#table0"]').click();
}

function clearForm(formId) {
    if (confirm("Are you sure?")) {
        $("#" + formId).find("input").val("");
    }
}

function testConnection() {
    $.ajax({
        url: $("#url").val() + "/testConnection",
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

function loadFields() {
    alert("TODO: load fields from database connction");
//    $.ajax({
//        url: $("#url").val() + "/loadDatabase",
//    }).done(function (data) {
//        if (data.dsMessage == null || data.dsMessage == "") {
//            $(".integration-panel").empty().append(data);
//        } else {
//            $("#message-div").empty().append(data.dsMessage);
//        }
//    });
}
