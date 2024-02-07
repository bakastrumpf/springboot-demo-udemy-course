package com.springframework.advancedjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate getters and setters

    // generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String ytchannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail() {}

    public InstructorDetail(String ytchannel, String hobby) {
        this.ytchannel = ytchannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", ytchannel='" + ytchannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}