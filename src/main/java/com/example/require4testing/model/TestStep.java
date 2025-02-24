package com.example.require4testing.model;

import jakarta.persistence.*;

@Entity
public class TestStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testcase_id")
    private TestCase testcase;
    private int step;
    private String title;
    private String description;

    public TestStep() {
    }

    public TestStep(Long id, TestCase testcase, int step, String title, String description) {
        this.id = id;
        this.testcase = testcase;
        this.step = step;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestCase getTestcase() {
        return testcase;
    }

    public void setTestcase(TestCase testcase) {
        this.testcase = testcase;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
