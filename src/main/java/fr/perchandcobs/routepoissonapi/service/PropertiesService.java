package fr.perchandcobs.routepoissonapi.service;

import fr.perchandcobs.routepoissonapi.exception.NotFoundException;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class PropertiesService {

    public ByteArrayResource getProperties(String teamName) throws IOException {
        InputStream templatePropertiesInputStream = getClass().getClassLoader().getResourceAsStream("template.properties");
        if(Objects.isNull(templatePropertiesInputStream)) {
            throw new NotFoundException("Le fichier template.properties n'a pas été trouvé.");
        }
        String fileContent = IOUtils.toString(templatePropertiesInputStream, StandardCharsets.UTF_8.name());
        fileContent = fileContent.replace("{{teamName}}", teamName);
        return new ByteArrayResource(fileContent.getBytes());
    }

}
