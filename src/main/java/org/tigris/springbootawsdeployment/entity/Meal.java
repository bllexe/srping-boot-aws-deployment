package org.tigris.springbootawsdeployment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Meal {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title",length = 64)
    private String title;
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdDate;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedDate;
    @Column(name = "author")
    private String author;

}
