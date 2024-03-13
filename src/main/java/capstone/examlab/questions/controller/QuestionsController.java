package capstone.examlab.questions.controller;

import capstone.examlab.questions.dto.QuestionsList;
import capstone.examlab.questions.dto.QuestionsOption;
import capstone.examlab.questions.service.QuestionsService;
import capstone.examlab.valid.ValidExamId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/exams/{examId}/questions")
public class QuestionsController {
    private final QuestionsService questionsService;
    @GetMapping
    public QuestionsList getExamQuestions(@PathVariable @ValidExamId Long examId, @ModelAttribute @Valid QuestionsOption questionsOption) {
        log.info("questionOptionDto = {}", questionsOption);
        return questionsService.findByDriverLicenseQuestions(examId, questionsOption);
    }
}
