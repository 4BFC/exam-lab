package capstone.examlab.exams.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExamsResponseGetDto {
    private List<ExamDto> exams = new ArrayList<>();
}
