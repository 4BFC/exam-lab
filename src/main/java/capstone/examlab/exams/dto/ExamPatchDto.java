package capstone.examlab.exams.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExamPatchDto {
    @NotNull
    private Map<String, List<String>> types;
}
