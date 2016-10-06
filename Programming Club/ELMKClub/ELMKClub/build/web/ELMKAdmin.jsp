<%--
    Document   : ELMKAdmin.jsp
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="ELMKBanner.jsp"></jsp:include>

<body>
    <br>
    <h1>Admin : Data Maintenance</h1>
    <a href ="ELMKDisplayBooks">Maintain Books</a>
    <br>
    <a href="<c:url value='ELMKMemberAdmin?action=displayMembers'/>">Display Members</a>
</body>

<jsp:include page="ELMKFooter.jsp"></jsp:include>

