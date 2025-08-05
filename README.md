package com.example.flowablecmmndemo.service;

import com.example.flowablecmmndemo.model.Document;
import com.example.flowablecmmndemo.repository.DocumentRepository;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.CmmnTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentWorkflowService {

    @Autowired
    private CmmnRuntimeService cmmnRuntimeService;

    @Autowired
    private CmmnTaskService cmmnTaskService;

    @Autowired
    private DocumentRepository documentRepository;

    public String startCase(String initiator) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("initiator", initiator);
        return cmmnRuntimeService.startCaseInstanceByKey("documentCase", variables).getId();
    }

    public void uploadDocument(String caseInstanceId, String taskId, MultipartFile file) throws IOException {
        // Save file to database
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setContent(file.getBytes());
        document.setCaseInstanceId(caseInstanceId);
        documentRepository.save(document);

        // Complete upload task
        Map<String, Object> variables = new HashMap<>();
        variables.put("documentId", document.getId());
        cmmnTaskService.complete(taskId, variables);
    }

    public void reviewDocument(String taskId, String outcome) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("reviewOutcome", outcome);
        cmmnTaskService.complete(taskId, variables);
    }

    public Document downloadDocument(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }
}