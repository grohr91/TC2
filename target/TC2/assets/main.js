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

//function testConnection() {
//    $.ajax({
//        url: $("#url").val() + "/testConnection",
//        data: $("#connectionForm").serialize()
//    }).done(function (data) {
//        if (data.dsMessage == null || data.dsMessage == "") {
//            $("#message-div").empty().append(
//                    "<div class='alert alert-success' role='alert'>"
//                    + "Connection OK</div>");
//        } else {
//            $("#message-div").empty().append(data.dsMessage);
//        }
//    });
//}

function loadFields() {
    $.ajax({
        url: $("#url").val() + "/loadDatabase",
        data: $("#connectionForm").serialize(),
    }).done(function (data) {
        if (data.dsMessage == null || data.dsMessage == "") {
            $(".integration-panel").empty().append(data);
        } else {
            $("#message-div").empty().append(data.dsMessage);
        }
    });
}


function loadColumnByNmTable(obj) {
    $.ajax({
        url: $("#url").val() + "/loadTableByNmTable",
        data: {
            'nmTable': $(obj).val()
        }
    }).done(function (data) {
        if (data.dsMessage == null || data.dsMessage == "") {
            var combo = $(obj).parent().find('.field');
            combo.empty();
            $(data.columnList).each(function (index, column) {
                combo.append("<option>" + column + "</option>");
            });
        } else {
            $("#message-div").empty().append(data.dsMessage);
        }
    });
}

function toggleNmMapField(obj) {
    if($(obj).val() == '0') {
        $(".table-info")
    }
}

function saveMapping() {
    $.ajax({
        url: $("#url").val() + "/saveMapping",
        data: $("#mappingForm").serialize()
    }).done(function (data) {
        if (data.dsMessage == null || data.dsMessage == "") {
            alert("Sucesso! Recarregar tela...");
        } else {
            $("#message-div").empty().append(data.dsMessage);
        }
    });
}