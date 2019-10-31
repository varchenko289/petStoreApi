package io.swagger.tests.api.user.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.swagger.petstore.dto.user.User;
import io.swagger.tests.api.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.swagger.petstore.utils.UserUtil.createNewUserRequest;
import static io.swagger.petstore.utils.UserUtil.getUserByUserName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateUserTest extends BaseTest {


    @BeforeClass
    public static void loadFixtures() {
        FixtureFactoryLoader.loadTemplates("io.swagger.petstore.fixtures.templates");
    }

    @Test()
    public void createNewUser() {

        User validUser = Fixture.from(User.class).gimme("newUser");
        createNewUserRequest(validUser);
        var testUser = getUserByUserName(validUser.getUserName());

        assertThat(validUser.getId(), is(equalTo(testUser.getId())));

    }
}
