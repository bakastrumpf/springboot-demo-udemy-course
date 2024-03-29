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

    // when we delete one, we delete all
    // @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    // to only delete instructor details, but not the instructor too
    // choose all cascade types other than ALL
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor theInstructor;

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

    public String getYtchannel() {
        return ytchannel;
    }

    public void setYtchannel(String ytchannel) {
        this.ytchannel = ytchannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getTheInstructor() {
        return theInstructor;
    }

    public void setTheInstructor(Instructor theInstructor) {
        this.theInstructor = theInstructor;
    }

}
