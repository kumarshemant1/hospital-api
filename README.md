package com.example.flowablecmmndemo.controller;

import com.example.flowablecmmndemo.model.Document;
import com.example.flowablecmmndemo.service.DocumentWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/workflow")
public class DocumentWorkflowController {

    @Autowired
    private DocumentWorkflowService documentWorkflowService;

    @PostMapping("/start")
    public String startWorkflow(@RequestParam String initiator) {
        return documentWorkflowService.startCase(initiator);
    }

    @PostMapping("/upload/{caseInstanceId}/{taskId}")
    public void uploadDocument(@PathVariable String caseInstanceId,
                              @PathVariable String taskId,
                              @RequestParam("file") MultipartFile file) throws Exception {
        documentWorkflowService.uploadDocument(caseInstanceId, taskId, file);
    }

    @PostMapping("/review/{taskId}")
    public void reviewDocument(@PathVariable String taskId,
                               @RequestParam String outcome) {
        documentWorkflowService.reviewDocument(taskId, outcome);
    }

    @GetMapping("/download/{documentId}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long documentId) {
        Document document = documentWorkflowService.downloadDocument(documentId);
        ByteArrayResource resource = new ByteArrayResource(document.getContent());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}