/*
    Document   : ELMKMemberTest.java
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
package club.business;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mkhomeiri6611
 */
public class ELMKMemberTest {
    
    public ELMKMemberTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Member instance = new Member();
        String expResult = "Mohammad";
        instance.setFullName(expResult);
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member instance = new Member();
        String expResult = "CP";
        instance.setProgramName(expResult);
        String result = instance.getProgramName();
        assertEquals(expResult, result);
    }
        
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        String expResult = "mkhomeiri6611@conestogac.on.ca";
        instance.setEmailAddress(expResult);
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member instance = new Member();
        int expResult = 2;
        instance.setYearLevel(expResult);
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
    }
        
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidNegative() {
        System.out.println("isValidNegative");
        Member instance = new Member();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidPositive() {
        System.out.println("isValidPositive");
        Member member = new Member("name", "email");
        boolean expResult = true;
        boolean result = member.isValid();
        assertEquals(expResult, result);
    }
}
