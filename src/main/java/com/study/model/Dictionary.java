package com.study.model;

import javax.persistence.*;

public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dict_name")
    private String dictName;

    @Column(name = "dict_code")
    private String dictCode;

    @Column(name = "dict_mark")
    private String dictMark;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return dict_name
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * @param dictName
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * @return dict_code
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * @param dictCode
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * @return dict_mark
     */
    public String getDictMark() {
        return dictMark;
    }

    /**
     * @param dictMark
     */
    public void setDictMark(String dictMark) {
        this.dictMark = dictMark;
    }
}