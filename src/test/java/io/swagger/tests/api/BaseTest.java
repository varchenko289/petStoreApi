package io.swagger.tests.api;

import org.junit.Before;

import static io.swagger.petstore.config.RequestSpecificationUtil.setSpecification;

public class BaseTest {

    @Before
    public void setUp() {
        setSpecification();
    }


}
