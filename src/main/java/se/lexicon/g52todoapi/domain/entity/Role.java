package se.lexicon.g52todoapi.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
public class Role implements Comparable<Role> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NonNull // Lombok
    @Column(nullable = false, unique = true)
    private String name;

    @Override
    public int compareTo(Role o) {
        return this.id.compareTo(o.id);
    }
}
