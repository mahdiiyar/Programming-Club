<%--
    Document   : index.jsp
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="ELMKBanner.jsp"></jsp:include>
    <body>
        <br>
        <h2>Java Web Technologies: Section 4</h2><br>
        <p>Pair Programming Team: Eric Lachapelle, Mohammad Khomeiri</p><br>
        <h2>Assignment 4<br><br>Driver: MKhomeiri<br>
        <br>Observer: ELachapelle<br><br><br></h2>
        <p>Current Date & Time:</p><br>
        <b><%=new java.util.Date()%></b>
        <br>
    </body>
<jsp:include page="ELMKFooter.jsp"></jsp:include>
