package techmail.domain.question.service;

import techmail.domain.question.dto.QuestionResDto;
import techmail.domain.question.repository.QuestionRepository;
import techmail.global.exception.ErrorCode;
import techmail.global.exception.notfound.EntityNotFoundException;
import techmail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Cacheable(key = "#category", cacheNames = {"questions"})
    public List<QuestionResDto> getAllByCategory(String category) {
        return questionRepository.selectQuestionListByCategory(category);
    }
}
