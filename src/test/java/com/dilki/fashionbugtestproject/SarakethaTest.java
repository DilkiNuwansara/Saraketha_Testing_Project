/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.dilki.fashionbugtestproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class SarakethaTest {
    
    public SarakethaTest() {
    }

    /**
     * Test of registerMembers method, of class Register.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterMembers() {
        
        Register instance = new Register();
        boolean status = instance.registerMembers();
        
        assertTrue(status);
       
       
    }
    
}
