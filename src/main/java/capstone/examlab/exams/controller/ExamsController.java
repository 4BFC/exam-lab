package capstone.examlab.exams.controller;

import capstone.examlab.exams.dto.ExamList;
import capstone.examlab.exams.dto.QuestionsList;
import capstone.examlab.exams.dto.QuestionsOption;
import capstone.examlab.exams.service.ExamsService;
import capstone.examlab.exams.dto.ExamType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/exams")
public class ExamsController {

    private final ExamsService examsService;

    @GetMapping
    public ExamList getExams() {
        ExamList examList = examsService.getExamList();
        return examList;
    }

    @GetMapping("/{id}/type")
    public ExamType getExamType(@PathVariable("id") Long id) {
        ExamType examType = examsService.getExamType(id);
        return examType;
    }

    @GetMapping("/{id}/questions")
    public QuestionsList getExamQuestions(@PathVariable("id") Long id, @ModelAttribute QuestionsOption questionsOption) {
        log.info("questionOptionDto = {}", questionsOption);
        QuestionsList questionsList = examsService.getQuestionsList(questionsOption);
        return questionsList;
    }
}