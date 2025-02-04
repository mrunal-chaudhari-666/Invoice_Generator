package com.example.invoicegenerator.task.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;


@Setter
@Getter
@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false)
    private String name;
   // @Column(nullable = false)
    private String address;
   // @Column(nullable = false)
    private String contact;


}

