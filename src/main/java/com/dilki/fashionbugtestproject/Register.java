/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dilki.fashionbugtestproject;

import com.dilki.fashionbugtestproject.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author DELL
 */
public class Register {
    public void registerMembers(){
        DBConnection con = new DBConnection();
        Connection conn = con.connect();

        String inputFirstname = "Adithya";
        String inputLastName = "Saranga";
        String inputEmail = "Butamene@fleckens.hu";
        String inputPassword = "12345";

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saaraketha.com//");

        // Register 
        WebElement pressRegister = driver.findElement(By.cssSelector("a[href='/account/register']"));
        pressRegister.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.click();
        Actions firstNameInputTxt = new Actions(driver);
        firstNameInputTxt.sendKeys(inputFirstname);
        firstNameInputTxt.perform();

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.click();
        Actions lastNameInputTxt = new Actions(driver);
        lastNameInputTxt.sendKeys(inputLastName);
        lastNameInputTxt.perform();

        List<WebElement> emails = driver.findElements(By.id("email"));
        emails.get(0).click();
        Actions emailInputTxt = new Actions(driver);
        emailInputTxt.sendKeys(inputEmail);
        emailInputTxt.perform();

        List<WebElement> password = driver.findElements(By.id("password"));
        password.get(0).click();
        Actions passwordInputTxt = new Actions(driver);
        passwordInputTxt.sendKeys(inputPassword);
        passwordInputTxt.perform();

        List<WebElement> submit = driver.findElements(By.cssSelector("button[class='btn btn-1']"));
        submit.get(0).click();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        System.out.println("url : " + driver.getCurrentUrl());

        if (driver.getCurrentUrl().equals("https://www.saaraketha.com/")) {
            System.out.println("first if success");
            List<WebElement> myAccountElement = driver.findElements(By.cssSelector("a[href='/account']"));
            
            if (!myAccountElement.isEmpty()) {
                System.out.println("Successfully insert");
                try {
                    PreparedStatement insertMembersStmt = conn.prepareStatement("insert into registerdemembers values(?,?,?,?)");
                    insertMembersStmt.setString(1, inputFirstname);
                    insertMembersStmt.setString(2, inputLastName);
                    insertMembersStmt.setString(3, inputEmail);
                    insertMembersStmt.setString(4, inputPassword);
                    insertMembersStmt.execute();

                } catch (SQLException ex) {
                    Logger.getLogger(FashionBugTestProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("array size : " +myAccountElement.size() );
            }

        } else {
            System.out.println("Insert Failed");
        }
    } 
}
