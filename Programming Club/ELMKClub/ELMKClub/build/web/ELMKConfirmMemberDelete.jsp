<%--
    Document   : ELMKConfirmMemberDelete.jsp
    Assignment : A4
    Project    : ELMKClub
    Created on : 04/04/2016
    Date Due   : 06/04/2016
    Programmers: Mohammad Khomeiri, Eric Lachapelle
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="ELMKBanner.jsp"></jsp:include>

    <h2>Do you want to delete this member?</h2>
    <label>Full Name:</label>
    <span>${member.fullName}</span>
    <br>
    <label>Email:</label>
    <span>${member.emailAddress}</span>
    <br>
    <label>Phone:</label>
    <span>${member.phoneNumber}</span>
    <br>
    <label>IT Program:</label>
    <span>${member.programName}</span>
    <br>
    <label>Year Level:</label>
    <span>${member.yearLevel}</span>
    <br>
    
    <form action="ELMKMemberAdmin" method="post">
        <input type="hidden" name = "action" value="deleteMember"/>
        <input type="hidden" name="emailAddress" value="${member.emailAddress}"/>
        <input type="submit" value="Yes">
    </form>
        
    <form action="ELMKMemberAdmin" method="get"> 
        <input type="hidden" name = "action" value="displayMembers"/>
        <input type="submit" value="No"></form>

<jsp:include page="ELMKFooter.jsp"></jsp:include>
