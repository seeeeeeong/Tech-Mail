package bytemail.domain.question.service;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.question.repository.QuestionRepository;
import bytemail.domain.user.entity.User;
import bytemail.global.exception.ErrorCode;
import bytemail.global.exception.notfound.EntityNotFoundException;
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

    public PageResponse<QuestionResDto> getQuestionList(Pageable pageable) {
        Page<QuestionResDto> questionPageList = questionRepository.selectQuestionPageList(pageable);
        return new PageResponse<>(questionPageList);
    }

    public QuestionResDto getQuestionDetail(Long questionId) {
        return questionRepository.selectQuestionDetail(questionId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.QUESTION_NOT_FOUND));
    }

    public QuestionResDto getQuestionListNotIn(User user) {
        return questionRepository.selectQuestionListNotIn(user).orElseThrow(() -> new EntityNotFoundException(ErrorCode.QUESTION_NOT_FOUND));
    }
}
