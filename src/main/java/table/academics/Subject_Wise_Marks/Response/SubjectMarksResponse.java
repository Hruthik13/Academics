package table.academics.Subject_Wise_Marks.Response;


import lombok.Data;
import table.academics.Subject_Wise_Marks.DTO.SubjectMarksDTO;

import java.util.List;

@Data
public class SubjectMarksResponse {
    private SubjectMarksDTO subjectMarksDTO;

    private List<SubjectMarksDTO> data;

    private long totalPages;

    private long recordsTotal;

    private long currentRecords;

    private long recordsFiltered;

    private boolean success;

    private String error;
}
