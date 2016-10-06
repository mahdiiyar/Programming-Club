<%--
    Document   : ELMKDisplayMember.jsp
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
        <form action="index.jsp">
            <h1>Thanks for joining our club!</h1>
            <br><p>Here is the information you entered:</p>
            <label><b>Full Name:</b></label>
            <span>${param.fullName}</span>
            <br><br>
            <label><b>Email:</b></label>
            <span>${param.email}</span>
            <br><br>
            <label><b>Email:</b></label>
            <span>${param.phone}</span>
            <br><br>
            <label><b>IT Program:</b></label>
            <span>${param.prog}</span>
            <br><br>
            <label><b>Year Level:</b></label>
            <span>${param.year}</span>
            <br><br>
            <p>To register another member, click on the back button
                in your browser or the return button shown below.</p>
            <input type="submit" value = "Return">
        </form>
    </body>
<jsp:include page="ELMKFooter.jsp"></jsp:include>
