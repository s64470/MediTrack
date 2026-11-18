package com.meditrack;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DocsController {

    @GetMapping("/test")
    public String test() {
        return "DocsController funktioniert!";
    }

    @GetMapping("/docs/{folder}/{filename:.+}")
    public ResponseEntity<Resource> getPdf(
            @PathVariable String folder,
            @PathVariable String filename) {

        Path docsPath = Paths.get("..", "docs")
                .toAbsolutePath()
                .normalize();

        Path filePath = docsPath.resolve(folder)
                .resolve(filename)
                .normalize();

        if (!filePath.startsWith(docsPath)
                || !filename.toLowerCase().endsWith(".pdf")
                || !Files.isRegularFile(filePath)) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(filePath);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}