package club.data;

import club.business.Member;
import club.data.DBUtil;
import club.data.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

public class MemberDB {

    public static int insert(Member member) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO member (FullName, EmailAddress, PhoneNumber, " +
                "ProgramName, YearLevel) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, member.getFullName());
            ps.setString(2, member.getEmailAddress());
            ps.setString(3, member.getPhoneNumber());
            ps.setString(4, member.getProgramName());
            ps.setInt(5, member.getYearLevel());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Member member) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE member SET "
                + "FullName = ?, "
                + "PhoneNumber = ?, "
                + "ProgramName = ?, "
                + "YearLevel = ? "
                + "WHERE EmailAddress = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, member.getFullName());
            ps.setString(2, member.getPhoneNumber());
            ps.setString(3, member.getProgramName());
            ps.setInt(4, member.getYearLevel());
            ps.setString(5, member.getEmailAddress());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
        
    public static int delete(Member member) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM member " +
                "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, member.getEmailAddress());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean emailExists(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT EmailAddress FROM member " +
                "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Member selectMember(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Member " +
                "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            Member member = null;
            if (rs.next()) {
                member = new Member();
                member.setFullName(rs.getString("FullName"));
                member.setEmailAddress(rs.getString("EmailAddress"));
                member.setPhoneNumber(rs.getString("PhoneNumber"));
                member.setProgramName(rs.getString("ProgramName"));
                member.setYearLevel(rs.getInt("YearLevel"));
            }
            return member;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Member> selectMembers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Member";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Member> members = new ArrayList<Member>();
            while (rs.next()) {
                Member member = new Member();
                member.setFullName(rs.getString("FullName"));
                member.setEmailAddress(rs.getString("EmailAddress"));
                member.setPhoneNumber(rs.getString("PhoneNumber"));
                member.setProgramName(rs.getString("ProgramName"));
                member.setYearLevel(rs.getInt("YearLevel"));
                members.add(member);
            }
            return members;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
