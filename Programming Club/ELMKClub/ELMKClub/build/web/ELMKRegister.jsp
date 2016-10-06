<%--
    Document   : ELMKRegister.jsp
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
        <h2>New Member Registration Form</h2><br><br>
        <form action = "ELMKDisplayMember.jsp" method = "post">
            <input type = "hidden" name = "action" value = "add">
            <label>Full Name:</label>
            <input type = "text" name = "fullName" required style="width:200px;">
            <br>
            <label>Email:</label>
            <input type = "text" name = "email" required style="width:300px;">
            <br>
            <label>Phone:</label>
            <input type = "tel" name = "phone" style="width:100px;"><br>
            <label>IT Program:</label>
            <select name = "prog">
                <option value = "CAD">CAD</option>
                <option value = "CP">CP</option>
                <option value = "CPA">CPA</option>
                <option value = "ITID">ITID</option>
                <option value = "ITSS">ITSS</option>
                <option value = "MSD">MSD</option>
                <option value = "Others">Others</option>
            </select><br>
            <label>Year Level:</label>
            <select name = "year">
                <option value = "1">1</option>
                <option value = "2">2</option>
                <option value = "3">3</option>
                <option value = "4">4</option>
            </select><br><br>
            <input type = "submit" value = "Register Now!" id = "submit">
            <input type = "reset" value = "Reset" id = "reset">
        </form>
    </body>
<jsp:include page="ELMKFooter.jsp"></jsp:include>
