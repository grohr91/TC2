<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!--Menu-->
<div class="col-md-3">
    <ul class="nav nav-tabs tabs-left">
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
        <s:set var="counter" value="0"/>
        <s:iterator value="schema.tableList" status="st2">
            <div class="tab-pane" id="table<s:property value="key"/>">
                <h3><strong><s:property value="value.nmTable" /></strong></h3>
                <s:iterator value="value" status="status">
                    <s:iterator value="columnList">
                        <div class="input-group" style="width: 100%">
                            <s:select name="mappingList[%{counter}].tableSource"
                                      list="schemaExport.tableList"
                                      listKey="value"
                                      listValue="value.nmTable"
                                      cssClass="form-control" 
                                      cssStyle="width: 50%"
                                      emptyOption="true"/>

                            <%-- TODO: CRIAR NOVA ACTION QUE RECEBE TABELA E CAMPO SELECIONADO e carregar list de campos da respectiva tabela --%>
                            <%-- ALTERNATIVA: carregar json com estrutura de tabelas e alterar a partir de hiddens de controle --%>
                            <s:select name="mappingList[%{counter}].fieldSource"
                                      list="schemaExport.tableList"
                                      listKey="value"
                                      listValue="value"
                                      cssClass="form-control" 
                                      cssStyle="width: 50%"
                                      emptyOption="true"/>
                            <span class="input-group-addon" style="width: 230px;">
                                <s:property value="value"/>
                                <s:hidden name="mappingList[%{counter}].fieldDest" />
                            </span>
                        </div>
                        <s:set var="counter" value="%{#counter+1}"/>
                    </s:iterator>
                </div>
            </s:iterator>
        </s:iterator>
    </div>
</div>