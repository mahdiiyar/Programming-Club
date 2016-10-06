<%--
    Document   : ELMKDisplayBooks.jsp
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
        <section>
            <h1>List Of Books</h1>
            <table>
                <tr>
                    <th>
                        Code                    
                    </th>
                    <th>
                        Description                        
                    </th>
                    <th>
                        Quantity                        
                    </th>
                </tr>
                <c:forEach var="book" items="${bookList}">                
                <tr>
                    <td>
                       ${book.code}               
                    </td>
                    <td>
                       ${book.description}               
                    </td>
                    <td>
                       ${book.quantity}               
                    </td>
                </tr>
            </c:forEach>
            </table>
            <form action="ELMKAddBook.jsp" method="POST">
                <input type="submit" name="addBook" value="Add Book">
            </form>    
        </section>        
    </body>
<jsp:include page="ELMKFooter.jsp"></jsp:include>
