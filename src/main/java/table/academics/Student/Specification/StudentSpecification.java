package table.academics.Student.Specification;

import org.springframework.data.jpa.domain.Specification;
import table.academics.Student.Model.Student;

public class StudentSpecification {

    public static Specification<Student> textInAllColumns(String searchText){
        if(!searchText.contains("%")){
            searchText="%"+searchText+"%";

        }
        String finalText = "%" + searchText.toLowerCase() + "%";
        return(root,query,builder) -> builder.and (builder.or(builder.like(builder.lower(root.get("name")), finalText),
                        builder.like(builder.lower(root.get("classes")), finalText)
                ),
                builder.equal(root.get("isDeleted"),0));
    }
}
