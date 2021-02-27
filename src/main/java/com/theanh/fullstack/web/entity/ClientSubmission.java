package com.theanh.fullstack.web.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_submissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientSubmission {
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @NotBlank
    @Pattern(regexp = EMAIL_PATTERN)
    private String email;

    @NotBlank
    @Column(name = "message")
    private String message;

    @Column(name = "submit_date_time")
    private LocalDateTime submitDateTime;
}
