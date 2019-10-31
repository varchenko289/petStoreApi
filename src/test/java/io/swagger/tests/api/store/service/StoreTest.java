package io.swagger.tests.api.store.service;

import io.swagger.tests.api.BaseTest;
import org.junit.Test;

import static io.swagger.petstore.utils.StoreUtil.getInventoryList;

public class StoreTest extends BaseTest {


    @Test
    public void userCanGetListOfOrdersInStore(){
        getInventoryList();
    }

}
