<%-- 
    Document   : ELMKDisplayMembers.jsp
    Assignment : A4
    Project    : ELMKClub
    Created on : 04/04/2016
    Date Due   : 06/04/2016
    Programmers: Mohammad Khomeiri, Eric Lachapelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="ELMKBanner.jsp"/>
    <section>
        <h1>List of Members</h1>
        <table>
            <tr>
                <th>Email</th>
                <th>Program</th>
                <th>Year</th>
            </tr>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="member" items="${members}">
             <tr>
                <td>${member.emailAddress}</td>
                <td>${member.programName}</td>
                <td>${member.yearLevel}</td>
                <td><a href="<c:url value='ELMKMemberAdmin?action=displayMember&emailAddress=${member.emailAddress}'/>">Update</a></td>
                <td><a href="<c:url value='ELMKMemberAdmin?action=confirmMemberDelete&emailAddress=${member.emailAddress}'/>">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
            
        <!--<a href="<c:url value='ELMKMemberAdmin?action=addMember'/>"><input type="submit" value="Add Member"></a>-->
        <a href="<c:url value='ELMKMemberAdmin?action=displayMember'/>"><input type="submit" value="Add Member"></a>
        <!--<a href="<c:url value='ELMKMemberAdmin?action=updateMember'/>"><input type="submit" value="Add Member"></a>-->     
    </section>
<jsp:include page="ELMKFooter.jsp"/>