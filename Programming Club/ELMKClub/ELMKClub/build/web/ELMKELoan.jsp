<%-- 
    Document   : ELMKELoan.jsp
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="ELMKBanner.jsp" />
    <body>
        <section>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>QOH</th>
                    <th>Action</th>
                </tr>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:forEach var="book" items="${applicationScope.loanitems}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity}</td>
                    <td>
                        <c:if test="${book.quantity==0}">
                            <p>N/A</p>
                        </c:if>
                        <c:if test="${book.quantity>0}">
                            <a href="ELMKCart?action=reserve&amp;code=${book.code}">Reserve</a>
                        </c:if>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </section>
    </body>
<jsp:include page="ELMKFooter.jsp" />            
