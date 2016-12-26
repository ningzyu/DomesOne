package com.nzy.dome1.entity;

import java.util.List;

/**
 * Created by NZY on 2016/12/26.
 */

public class Fujian {


    /**
     * name : 请选择
     * sub : [{"name":"请选择"}]
     * type : 1
     */

    private String name;
    private int type;
    private List<SubBean> sub;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SubBean> getSub() {
        return sub;
    }

    public void setSub(List<SubBean> sub) {
        this.sub = sub;
    }

    public static class SubBean {
        /**
         * name : 请选择
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
