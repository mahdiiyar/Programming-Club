package club.business;

import java.io.Serializable;

public class Member implements Serializable {

    private String fullName = "";
    private String emailAddress = "";
    private String phoneNumber = "";
    private String programName = "";
    private int yearLevel = 0;
    private boolean valid = false;

    public Member() {
        fullName = "";
        emailAddress = "";
        phoneNumber = "";
        programName = "";
        yearLevel = 0;
    }

    public Member(String full, String email) {
        fullName = full;
        emailAddress = email;
    }

    public String getFullName() {
        if (fullName == null) {
            fullName = "";
        }
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        if (emailAddress == null) {
            emailAddress = "";
        }
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = "";
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProgramName() {
        if (programName == null) {
            programName = "";
        }
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public boolean isValid() {
        if ((getFullName().length() > 0) && (getEmailAddress().length() > 0)) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

}
