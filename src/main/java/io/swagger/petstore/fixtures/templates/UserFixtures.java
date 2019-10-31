package io.swagger.petstore.fixtures.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import io.swagger.petstore.dto.user.User;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;


public class UserFixtures implements TemplateLoader {

    private String id = randomNumeric(7);
    private String phone = randomNumeric(10);


    @Override
    public void load() {
        Fixture.of(User.class).addTemplate("newUser", new Rule() {{
            add("id", id);
            add("userName", regex("[A-Z]{1}[A-Z a-z]{9,29}"));
            add("firstName", "Anderson");
            add("lastName", "Parra");
            add("email", "${firstName}.${lastName}@test.com");
            add("password", "Password1");
            add("phone", phone);
            add("userStatus", "0");
        }});
    }
}
