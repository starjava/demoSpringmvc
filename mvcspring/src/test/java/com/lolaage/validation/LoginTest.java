package com.lolaage.validation;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lolaage.entity.Login;

public class LoginTest
{
    private static Validator validator;
    
    @BeforeClass
    public static void setUp()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void manufacturerIsNull()
    {
        Login login = new Login();
        login.setUsername("ada");
        login.setPassword("1111111");
        Set<ConstraintViolation<Login>> constraintViolations = validator.validate(login);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }
}
