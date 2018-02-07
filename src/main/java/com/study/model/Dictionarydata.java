package com.study.model;

import javax.persistence.*;

public class Dictionarydata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dictdata_name")
    private String dictdataName;

    @Column(name = "dictdata_code")
    private String dictdataCode;

    @Column(name = "dictdata_mark")
    private String dictdataMark;

    @Column(name = "dict_id")
    private Integer dictId;

    @Column(name = "parent_id")
    private Integer parentId;
    
    @Transient
    private String parentName;
    @Transient
    private String parentdataName;
    

    public String getParentdataName() {
      return parentdataName;
    }

    public void setParentdataName(String parentdataName) {
      this.parentdataName = parentdataName;
    }

    public String getParentName() {
      return parentName;
    }

    public void setParentName(String parentName) {
      this.parentName = parentName;
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
     * @return dictdata_name
     */
    public String getDictdataName() {
        return dictdataName;
    }

    /**
     * @param dictdataName
     */
    public void setDictdataName(String dictdataName) {
        this.dictdataName = dictdataName;
    }

    /**
     * @return dictdata_code
     */
    public String getDictdataCode() {
        return dictdataCode;
    }

    /**
     * @param dictdataCode
     */
    public void setDictdataCode(String dictdataCode) {
        this.dictdataCode = dictdataCode;
    }

    /**
     * @return dictdata_mark
     */
    public String getDictdataMark() {
        return dictdataMark;
    }

    /**
     * @param dictdataMark
     */
    public void setDictdataMark(String dictdataMark) {
        this.dictdataMark = dictdataMark;
    }

    /**
     * @return dict_id
     */
    public Integer getDictId() {
        return dictId;
    }

    /**
     * @param dictId
     */
    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    /**
     * @return parent_id
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