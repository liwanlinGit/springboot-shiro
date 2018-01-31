package com.study.util;


public class PageBeanUtil {
    public static Boolean pageBeanIsNotEmpty(PageBean bean){
      Boolean delault=false;
      if(bean!=null&&bean.getPage()!=null&&bean.getRows()!=null){
        delault=true;
      }
      return delault;
    }
}
