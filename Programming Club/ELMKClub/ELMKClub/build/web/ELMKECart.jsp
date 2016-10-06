<%-- 
    Document   : ELMKECart.jsp
    Assignment : A3
    Project    : ELMKClub
    Created on : 03/17/2016
    Date Due   : 03/23/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ELMKBanner.jsp" />
    <body>
        <section>
            <table>
                <h3 style= "text-align: left; padding-left: 20px;">Your Loan Cart</h3>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>Quantity</th>
                </tr>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:set var="cartTotal" value="${0}"/>
                <c:forEach var="book" items="${sessionScope.cart.items}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity}</td>
                </tr>
                <c:set var="cartTotal" value="${cartTotal + book.quantity}"/>
                </c:forEach>
                <tr>
                    <td></td>
                    <td align="right">Total:</td>
                    <td> ${cartTotal}</td>
                </tr>
            </table>
                <a href="ELMKClearCart">Clear the cart</a><br>
                <a href="ELMKLoan">Return to eLoan</a>
        </section>
    </body>
<jsp:include page="ELMKFooter.jsp" />            


