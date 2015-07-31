package com.lolaage.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lolaage.entity.Login;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
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
        login.setUsername("adm");
        login.setPassword("asd");
        /* 将类型装载效验 */
        Set<ConstraintViolation<Login>> constraintViolations = validator.validate(login);
        /* 将类型装载效验 */
        
        for (ConstraintViolation<Login> constraintViolation : constraintViolations)
            System.out.println(constraintViolation.getPropertyPath() + "错误：" + constraintViolation.getMessage());
        
    }
}
