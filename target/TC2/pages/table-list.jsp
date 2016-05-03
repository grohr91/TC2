<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!--Menu-->
<div class="col-md-3">
    <ul class="nav nav-tabs tabs-left">
        <li class="table-info"><a href="#table-info" data-toggle="tab">General Info</a></li>
            <s:iterator value="schema.tableList" status="st1">
            <!-- Nav tabs -->
            <li>
                <a href="#table<s:property value="key"/>" data-toggle="tab">
                    <s:property value="value.nmTable" />
                </a> 
            </li>
        </s:iterator>
    </ul>
</div>

<!--Fields-->
<div class="col-md-9">
    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane table-info" id="table-info">
            <div class="form-group">
                <label class="col-md-2 control-label" for="nmMap">
                    New Map Name
                </label>
                <div class="col-md-5">
                    <s:textfield id="nmMap" name="confMap.nmMap" cssClass="form-control" maxlength="50" />
                </div>
            </div>
        </div>
        <s:set var="counter" value="0"/>
        <s:iterator value="schema.tableList" status="st2">
            <div class="tab-pane" id="table<s:property value="key"/>">
                <h3><strong><s:property value="value.nmTable" /></strong></h3>
                <s:iterator value="value" status="status">
                    <s:iterator value="columnList">
                        <div class="input-group" style="width: 100%">
                            <s:property value="confMappingList[%{counter}].nmTableSource"/>
                            <s:select name="confMappingList[%{counter}].nmTableSource"
                                      list="schemaExport.tableList"
                                      listKey="value.nmTable"
                                      listValue="value.nmTable"
                                      cssClass="form-control" 
                                      cssStyle="width: 50%"
                                      emptyOption="true"
                                      onchange="loadColumnByNmTable(this);"/>

                            <s:if test="confMappingList.isEmpty()">
                                <s:select name="confMappingList[%{counter}].nmFieldSource"
                                          list="confMappingList"
                                          cssClass="form-control field" 
                                          cssStyle="width: 50%"/>
                            </s:if>
                            <s:else>
                                <s:select name="confMappingList[#counter].nmFieldSource"
                                          list="confMappingList[#counter].columnList"
                                          listKey="value"
                                          listValue="value"
                                          cssClass="form-control field" 
                                          cssStyle="width: 50%"/>
                            </s:else>
                            <span class="input-group-addon" style="width: 230px;">
                                <s:property value="value"/>
                                <input type="hidden" 
                                       name="confMappingList[<s:property value="#counter"/>].nmFieldDest" 
                                       value="<s:property value="nmTable"/>.<s:property value="value"/>"/>
                            </span>
                        </div>
                        <s:set var="counter" value="%{#counter+1}"/>
                    </s:iterator>
                </div>
            </s:iterator>
        </s:iterator>
    </div>
</div>