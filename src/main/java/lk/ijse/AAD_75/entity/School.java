package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    private Long school_id;
    private String school_name;
    private String school_location;


    /* In Hibernate if a one-to-many relationship exists, it must be mentioned on both relevant
    * entities as One to Many and Many to One */
    @OneToMany(mappedBy = "school",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Student> studentList;
}
