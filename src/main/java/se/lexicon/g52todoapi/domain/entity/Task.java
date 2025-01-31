package se.lexicon.g52todoapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    private String description;
    private LocalDate deadline;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
