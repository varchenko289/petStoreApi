package io.swagger.petstore.config;

        import io.swagger.petstore.dto.ConfigProperties;

        import java.io.FileInputStream;

        import static java.lang.String.format;
        import static java.lang.System.getProperty;

public class PropertiesConfig {

    ConfigProperties configProperties;

    public PropertiesConfig() {
        if (configProperties != null) {
            System.out.println("ALL READY LOAD CONFIG FILE");
        } else {
            configProperties = new ConfigProperties();
            java.util.Properties prop = new java.util.Properties();

            try {
                prop.load(new FileInputStream("/Users/user/IdeaProjects/petStoreApi/src/main/resources/config.properties"));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            configProperties.setBaseUrl(prop.getProperty("baseUrl"));
            configProperties.setApiKey(prop.getProperty("apiKey"));

        }
    }

    public String getBaseUrl() {
        return configProperties.getBaseUrl();
    }

    public String getApiKey() {
        return configProperties.getApiKey();
    }
}
