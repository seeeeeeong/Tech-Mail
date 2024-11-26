package bytemail.domain.question.service;

import bytemail.domain.question.dto.QuestionResponse;
import bytemail.domain.question.repository.QuestionRepository;
import bytemail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    public PageResponse<QuestionResponse> getQuestions(String category, Pageable pageable) {
        Page<QuestionResponse> questionResponse = questionRepository.findQuestions(category, pageable);
        return new PageResponse<>(questionResponse);
    }
}
