package in.purabtech.actuator;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
         // We used the Yamlpropertyfactory bean to convert the resources in yaml format
        //to the java.util.Properties object.
        YamlPropertiesFactoryBean factory=new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());

        Properties properties= factory.getObject();
        return new PropertiesPropertySource(resource.getResource().getFilename(), properties);
    }
}
