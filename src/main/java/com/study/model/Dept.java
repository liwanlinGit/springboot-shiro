package com.study.model;

import javax.persistence.*;

public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    @Column(name = "parent_Id")
    private Integer parentId;
    
    @Transient
    private String parentName;
    

    public String getParentName() {
      return parentName;
    }

    public void setParentName(String parentName) {
      this.parentName = parentName;
    }
    @Transient
    private String text;
    
    @Transient
    private Integer pId;
    

    public Integer getpId() {
      return getParentId();
    }

    public void setpId(Integer pId) {
      this.pId = pId;
    }

    public String getText() {
      return getName();
    }


    public void setText(String text) {
      this.text = text;
    }

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return parent_Id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}