package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.service.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PropertiesController {

    Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping(path = "/properties")
    public ResponseEntity<Resource> download(@RequestParam String teamName) throws IOException {

        ByteArrayResource propertiesResource = propertiesService.getProperties(teamName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + teamName + ".properties")
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(propertiesResource);
    }

}
