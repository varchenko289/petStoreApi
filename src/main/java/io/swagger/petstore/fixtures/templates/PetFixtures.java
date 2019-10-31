package io.swagger.petstore.fixtures.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import io.swagger.petstore.dto.pet.Pet;
import io.swagger.petstore.utils.PetUtil;

import static io.swagger.petstore.utils.PetUtil.getListOfTags;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

public class PetFixtures implements TemplateLoader {

    private PetUtil petUtil = new PetUtil();
    private String id = randomNumeric(7);

    @Override
    public void load() {
        Fixture.of(Pet.class).addTemplate("newPet", new Rule() {{
            add("id", id);
            add("category", petUtil.getCategory());
            add("name", regex("Test_Pet_" + "[A-Z]{1}[A-Z a-z]{9,29}"));
            add("photoUrls", petUtil.getListOfPhotos(2));
            add("tags", getListOfTags(5));
            add("status", random("available", "sold", "new"));
        }});

        Fixture.of(Pet.class).addTemplate("newWithNoPhotos", new Rule() {{
            add("id", id);
            add("category", null);
            add("name", regex("Test_Pet_" + "[A-Z]{1}[A-Z a-z]{9,29}"));
            add("photoUrls", null);
            add("tags", getListOfTags(10));
            add("status", random("available", "sold", "new"));
        }});
    }
}
