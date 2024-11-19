package table.academics.Subject_Wise_Marks.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import table.academics.Subject_Wise_Marks.DTO.SubjectMarksDTO;
import table.academics.Subject_Wise_Marks.Model.SubjectMarks;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectMarksRepository extends JpaRepository<SubjectMarks, String> {



    List<SubjectMarks> findAllByIsDeleted(int isDeleted);

    List<SubjectMarks> findAllByIsDeleted(int i, Sort sort);

    List<SubjectMarks> findAllByIsDeletedAndStudentId(int i, String studentId);

    List<SubjectMarks> findAllByIsDeletedAndStudentIdAndIdIsNot(int i, String studentId, String id);

    Page<SubjectMarks> findAllByIsDeleted(int isDeleted, Pageable page);

    Page<SubjectMarks> findAll(Specification<SubjectMarks> textInAllColumns, Pageable pageable);


    @Query(
            "SELECT new table.academics.Subject_Wise_Marks.DTO.SubjectMarksDTO(" +
                    "subjectMarks.id, " +
                    "subjectMarks.studentId, " +
                    "subjectMarks.subject_1, " +
                    "subjectMarks.subject_2, " +
                    "subjectMarks.subject_3, " +
                    "subjectMarks.marks_1, " +
                    "subjectMarks.marks_2, " +
                    "subjectMarks.marks_3, " +
                    "subjectMarks.created_by, " +
                    "subjectMarks.creation_time, " +
                    "subjectMarks.last_Modified_by, " +
                    "subjectMarks.last_Modification_time, " +
                    "subjectMarks.isDeleted, " +
                    "subjectMarks.deleted_by, " +
                    "subjectMarks.deletion_time, " +
                    "student.name " +
                    " )" +
                    " FROM SubjectMarks as subjectMarks" +
                    " LEFT JOIN Student student on subjectMarks.studentId=student.id" +
                    " WHERE LOWER(student.name) like LOWER(:searchText) AND subjectMarks.isDeleted=0 "
    )
    Page<SubjectMarksDTO> searchPaginated(@Param("searchText") String searchText, Pageable pageable);
}