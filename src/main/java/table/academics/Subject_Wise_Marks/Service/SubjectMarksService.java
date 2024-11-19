package table.academics.Subject_Wise_Marks.Service;



import table.academics.Subject_Wise_Marks.Response.SubjectMarksResponse;
import table.academics.Subject_Wise_Marks.Model.SubjectMarks;

import java.util.Map;
import java.util.Optional;

public interface SubjectMarksService {

    SubjectMarksResponse saveSubjectMarks(SubjectMarks subjectMarks)throws Exception;

    SubjectMarksResponse moveToTrash(Map<String, String> formData)throws Exception;

    Optional<SubjectMarks> findById(String id)throws Exception;

    SubjectMarks save(SubjectMarks subjectMarks)throws  Exception;

    SubjectMarksResponse get(Map<String, String> formData)throws Exception;

    SubjectMarksResponse getAll() throws Exception;

    SubjectMarksResponse getDeleted()throws Exception;

    SubjectMarksResponse getPaginated(Map<String, String> formData);

    SubjectMarksResponse searchPaginated(Map<String, String> formData)throws Exception;

   SubjectMarksResponse searchPaginatedThroughRepository(Map<String,String> formData) throws Exception;


}
