package com.retrofitclient.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("user")
public class User {

    @Id
    @Column("id")
    private Long id;

    @Column("user_id")
    private String userId;

    @Column("tittle")
    private String tittle;

    @Column("body")
    private String body;
}
