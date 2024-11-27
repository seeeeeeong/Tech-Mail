package bytemail.domain.admin.controller;

import bytemail.domain.admin.dto.CreateQuestionReqDto;
import bytemail.domain.admin.dto.SendNoticeReqDto;
import bytemail.domain.admin.dto.UpdateQuestionReqDto;
import bytemail.domain.admin.service.AdminService;
import bytemail.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin/question")
    public ApiResponse<Void> createQuestion(@RequestBody CreateQuestionReqDto request) {
        adminService.createQuestion(request);
        return ApiResponse.created(null);
    }

    @PutMapping("/admin/question")
    public ApiResponse<Void> updateQuestion(@RequestBody UpdateQuestionReqDto request) {
        adminService.updateQuestion(request);
        return ApiResponse.success(null);
    }

    @PostMapping("/admin/notice")
    public ApiResponse<Void> sendNotice(@RequestBody SendNoticeReqDto request) {
        adminService.sendNotice(request);
        return ApiResponse.success(null);
    }

}
