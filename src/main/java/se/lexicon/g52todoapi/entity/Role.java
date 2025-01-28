package se.lexicon.g52todoapi.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Role { // TODO Implement Comparable interface

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NonNull // Lombok
    @Column(nullable = false ,unique = true)
    private String name;

}
