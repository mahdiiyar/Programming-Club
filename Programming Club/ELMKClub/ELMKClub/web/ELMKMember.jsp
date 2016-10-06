<%-- 
    Document   : ELMKMember.jsp
    Assignment : A4
    Project    : ELMKClub
    Created on : 04/04/2016
    Date Due   : 06/04/2016
    Programmers: Mohammad Khomeiri, Eric Lachapelle
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="ELMKBanner.jsp"></jsp:include>
    <section>
        <c:choose>
            <c:when test="${member.emailAddress == null}">
                <h2>New Member Registration Form</h2><br>
            </c:when>
            <c:otherwise>
                <h2>Edit Registration Form</h2><br>
            </c:otherwise>
        </c:choose>
        <br>
        <p style="color: red">${errorMessage}</p>
        <form action="ELMKMemberAdmin" method="post">
            <input type="hidden" name="action" value="updateMember">
            <label>Full Name:</label>
            <input type="text" name="fullName" style="width:200px" value="${member.fullName}">
            <br>
            <label>Email:</label>
            <input type="text" name="emailAddress" style="width:300px" value="${member.emailAddress}">
            <br>
            <label>Phone:</label>
            <input type="text" name="phoneNumber" style="width:100px" value="${member.phoneNumber}">
            <br>
            <label>IT Program:</label>
            <select name="programName">
                
                <c:if test="${member.programName!=null}">
                    <option value="${member.programName}">${member.programName}</option>
                </c:if>
                    
                <c:if test="${member.programName!='CAD'}"><option value="CAD">CAD</option></c:if>
                <c:if test="${member.programName!='CP'}"><option value="CP">CP</option></c:if>
                <c:if test="${member.programName!='CPA'}"><option value="CPA">CPA</option></c:if>
                <c:if test="${member.programName!='ITID'}"><option value="ITID">ITID</option></c:if>
                <c:if test="${member.programName!='ITSS'}"><option value="ITSS">ITSS</option></c:if>
                <c:if test="${member.programName!='MSD'}"><option value="MSD">MSD</option></c:if>
                <c:if test="${member.programName!='Others'}"><option value="Others">Others</option></c:if>
            </select>
            <br>
            <label>Year Level:</label>
            <select name="yearLevel" ${param["year"]}>
                <c:if test="${member.yearLevel!=null}">
                    <option value="${member.yearLevel}" selected>${member.yearLevel}</option>
                </c:if>
                <c:if test="${member.yearLevel !='1'}">
                    <option value="1" >1</option>
                </c:if>
                <c:if test="${member.yearLevel !='2'}">
                    <option value="2">2</option>
                </c:if>
                <c:if test="${member.yearLevel !='3'}">     
                    <option value="3">3</option>
                </c:if>
                <c:if test="${member.yearLevel !='4'}">  
                    <option value="4">4</option>
                </c:if>
           </select>
           <br>
           <input type="submit" name="submit" value="Update Member">
        </form>
    </section>        
<jsp:include page="ELMKFooter.jsp"></jsp:include>
