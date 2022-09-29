package se331.rest.entity;

import lombok.*;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String telNo;
    @ManyToMany

    @Builder.Default
    List<Event> eventHistory = new ArrayList<>();
}
