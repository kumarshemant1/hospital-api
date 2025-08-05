# hospital-api

<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://www.omg.org/spec/CMMN/20151109/MODEL"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             targetNamespace="http://flowable.org/cmmn">
    <case id="documentCase" name="Document Workflow">
        <casePlanModel id="casePlanModel" name="Document Workflow Case">
            <!-- Variables to store document and status -->
            <planItem id="uploadTask" name="Upload Document"
                      definitionRef="uploadTaskDef"/>
            <humanTask id="uploadTaskDef" name="Upload Document"
                       flowable:assignee="${initiator}"/>
            <planItem id="reviewTask" name="Review Document"
                      definitionRef="reviewTaskDef">
                <entryCriterion sentryRef="uploadCompleteSentry"/>
            </humanTask>
            <humanTask id="reviewTaskDef" name="Review Document"
                       flowable:assignee="reviewer"/>
            <planItem id="downloadTask" name="Download Document"
                      definitionRef="downloadTaskDef">
                <entryCriterion sentryRef="reviewApprovedSentry"/>
            </humanTask>
            <humanTask id="downloadTaskDef" name="Download Document"
                       flowable:assignee="${initiator}"/>
            <!-- Sentries for task transitions -->
            <sentry id="uploadCompleteSentry">
                <planItemOnPart sourceRef="uploadTask">
                    <standardEvent>complete</standardEvent>
                </planItemOnPart>
            </sentry>
            <sentry id="reviewApprovedSentry">
                <planItemOnPart sourceRef="reviewTask">
                    <standardEvent>complete</standardEvent>
                </planItemOnPart>
                <ifPart>
                    <condition>${reviewOutcome == 'approved'}</condition>
                </ifPart>
            </sentry>
            <sentry id="reviewRejectedSentry">
                <planItemOnPart sourceRef="reviewTask">
                    <standardEvent>complete</standardEvent>
                </planItemOnPart>
                <ifPart>
                    <condition>${reviewOutcome == 'rejected'}</condition>
                </ifPart>
            </sentry>
            <!-- Reactivate upload task if rejected -->
            <planItem id="repeatUploadTask" name="Re-Upload Document"
                      definitionRef="uploadTaskDef">
                <entryCriterion sentryRef="reviewRejectedSentry"/>
            </planItem>
        </casePlanModel>
    </case>
</definitions>