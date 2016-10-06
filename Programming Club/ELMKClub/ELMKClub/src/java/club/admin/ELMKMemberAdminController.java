/*
    Document   : ELMKMemberAdminController.java
    Assignment : A4
    Project    : ELMKClub
    Created on : 04/04/2016
    Date Due   : 06/04/2016
    Programmers: Eric Lachapelle, Mohammad Khomeiri
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mkhomeiri6611
 */
public class ELMKMemberAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/ELMKDisplayMembers.jsp";
        String action = request.getParameter("action");

        if (action.equals("deleteMember")) {
            String email = request.getParameter("emailAddress");
            Member member = MemberDB.selectMember(email);
            MemberDB.delete(member);
        }
        if (action.equals("updateMember")) {
            String fullName = request.getParameter("fullName");
            String emailAddress = request.getParameter("emailAddress");
            String phoneNumber = request.getParameter("phoneNumber");
            String programName = request.getParameter("programName");
            String yearLevel = request.getParameter("yearLevel");

            Member member = new Member(fullName, emailAddress);
            if (member.isValid()) {
                if (MemberDB.emailExists(emailAddress)) {
                    member.setPhoneNumber(phoneNumber);
                    member.setProgramName(programName);
                    member.setYearLevel(Integer.parseInt(yearLevel));
                    MemberDB.update(member);
                } else {
                    member.setPhoneNumber(phoneNumber);
                    member.setProgramName(programName);
                    member.setYearLevel(Integer.parseInt(yearLevel));
                    MemberDB.insert(member);
                }
            } else {
                request.setAttribute("errorMessage",
                        "Information For Member is not valid. Please enter a valid Information"
                        + " for name and email.");
                url = "/ELMKMember.jsp";
            }
        }

        ArrayList<Member> members = MemberDB.selectMembers();
        request.setAttribute("members", members);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/ELMKDisplayMembers.jsp";
        String action = request.getParameter("action");

        if (action.equals("")) {
            action = "displayMembers";
        }

        if (action == null) {
            action = "displayMembers";
        }
        if (action.equals("displayMembers")) {
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        }
        if (action.equals("displayMember")) {
            String emailAddress = request.getParameter("emailAddress");
            Member member = MemberDB.selectMember(emailAddress);
            request.setAttribute("member", member);
            url = "/ELMKMember.jsp";
        }

        if (action.equals("confirmMemberDelete")) {
            String email = request.getParameter("emailAddress");
            Member member = MemberDB.selectMember(email);
            request.setAttribute("member", member);
            url = "/ELMKConfirmMemberDelete.jsp";
        }

        ArrayList<Member> members = MemberDB.selectMembers();
        request.setAttribute("members", members);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
