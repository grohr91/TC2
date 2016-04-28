$(function ($) {
    setUp();
    //TODO: REMOVER linha abaixo
    loadFields();
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

function loadFields() {
    var confMapParam = '&confMap.idMap='+ $("[name='confMap.idMap']").val();
    $.ajax({
        url: $("#url").val() + "/loadDatabase",
        data: $("#connectionForm").serialize() + confMapParam,
    }).done(function (data) {
        if (data.dsMessage == null || data.dsMessage == "") {
            $(".integration-panel").empty().append(data);
            $('[href="#collapseConfig"]').addClass('collapsed').attr('aria-expanded', false);
            $("#collapseConfig").addClass("collapse").removeClass('in');
            $(".table-info a").click();
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
                combo.append("<option value='" + column + "'>" + column + "</option>");
            });
        } else {
            $("#message-div").empty().append(data.dsMessage);
        }
    });
}

function saveMapping() {
    if ($("#nmMap").val() == "") {
        $(".table-info a").click();
        alert("Type a name for this map");
    } else {
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
}