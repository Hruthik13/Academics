package table.academics.Student.Response;


import lombok.Data;
import table.academics.Student.DTO.StudentDTO;
import java.util.List;

@Data
public class StudentResponse {
    private StudentDTO studentDTO;

    private List<StudentDTO> data;

    private long totalPages;

    private long recordsTotal;

    private long currentRecords;

    private long recordsFiltered;

    private boolean success;

    private String error;
}
