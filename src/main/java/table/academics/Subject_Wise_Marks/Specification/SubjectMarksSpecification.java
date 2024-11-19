package table.academics.Subject_Wise_Marks.Specification;


import org.springframework.data.jpa.domain.Specification;
import table.academics.Subject_Wise_Marks.Model.SubjectMarks;

public class SubjectMarksSpecification {
    public static Specification<SubjectMarks> textInAllColumns(String searchText){
        if(!searchText.contains("%")){
            searchText= "%"+searchText+"%";

        }
        String finalText = "%" + searchText.toLowerCase() + "%";
        return(root,query,builder) -> builder.and (builder.or(builder.like(builder.lower(root.get("studentId")), finalText)
                ),
                builder.equal(root.get("isDeleted"),0));
    }
}