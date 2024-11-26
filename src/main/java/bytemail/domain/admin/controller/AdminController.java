package bytemail.domain.admin.controller;

import bytemail.domain.admin.dto.CreateQuestionRequest;
import bytemail.domain.admin.dto.SendNoticeRequest;
import bytemail.domain.admin.dto.UpdateQuestionRequest;
import bytemail.domain.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin/question")
    public ResponseEntity<Void> createQuestion(@RequestBody CreateQuestionRequest request) {
        adminService.createQuestion(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/admin/question")
    public ResponseEntity<Void> updateQuestion(@RequestBody UpdateQuestionRequest request) {
        adminService.updateQuestion(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/admin/notice")
    public ResponseEntity<Void> sendNotice(@RequestBody SendNoticeRequest request) {
        adminService.sendNotice(request);
        return ResponseEntity.noContent().build();
    }
}
