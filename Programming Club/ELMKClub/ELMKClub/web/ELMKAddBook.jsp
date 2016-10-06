<%--
    Document   : ELMKAddBook.jsp
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="ELMKBanner.jsp"></jsp:include>
    <body>
        <form id="addBook" action="ELMKAddBook" method="POST">
            <br>
            <h1>Add a Book</h1>
            <br>   
            
            <c:if test="${message != null}">
                <p class="required"><i>${message}</i></p>
            </c:if>
            
            <label for="code">Code:</label>
            <input type="text" id="code" name="code">
            <br><br>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description">
            <br><br>
            <label for="quantity">Quantity:</label>
            <input type="text" id="quantity" name="quantity">
            <br><br>
            <input type="submit" name="save" value="Save" id="right">                      
        </form>
        <br>
        <a href="ELMKDisplayBooks"><button id="right">Cancel</button></a>  
    </body>
<jsp:include page="ELMKFooter.jsp"></jsp:include>