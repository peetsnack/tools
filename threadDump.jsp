<%@page import="java.io.PrintWriter,java.util.Date,java.text.SimpleDateFormat,org.jahia.bin.errors.ErrorFileDumper"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" 
%><c:if test="${param.file}"><%
response.setContentType("text/plain; charset=ISO-8859-1");
response.setHeader("Content-Disposition", "attachment; filename=\"thread-dump-"
        + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".out\"");
%>System Status Information at <%= new java.util.Date() %><% pageContext.getOut().append("\n"); %>
<% ErrorFileDumper.outputSystemInfo(new PrintWriter(pageContext.getOut()), false, false, false, false, false, true, false, false); %></c:if><c:if test="${not param.file}">

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="tools.css"/>
    <link rel="stylesheet" href="../modules/assets/css/admin-bootstrap.css"/>
    <title>Thread State Information</title>
    </head>
    <body>
    <h1>Thread State Information at <%= new Date() %></h1>
    <%@ include file="gotoIndex.jspf" %>&nbsp;<a class="btn btn-primary" href="?file=true" target="_blank">download as a file</a>
    <c:set var="dump"><% ErrorFileDumper.outputSystemInfo(new PrintWriter(pageContext.getOut()), false, false, false, false, false, true, false, false); %></c:set>
    <pre><c:out value="${dump}"/></pre>
    </body>
</html>
</c:if>