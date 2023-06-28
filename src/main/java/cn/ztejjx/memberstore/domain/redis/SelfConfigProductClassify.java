package cn.ztejjx.memberstore.domain.redis;

import cn.ztejjx.memberstore.domain.mysql.configProductBrands;

import java.util.List;

public class SelfConfigProductClassify {

    private String productClassifyid;

    private String productClassifyname;

    private List<configProductBrands> productBrandsList;


    public String getProductClassifyid() {
        return productClassifyid;
    }

    public void setProductClassifyid(String productClassifyid) {
        this.productClassifyid = productClassifyid;
    }

    public String getProductClassifyname() {
        return productClassifyname;
    }

    public void setProductClassifyname(String productClassifyname) {
        this.productClassifyname = productClassifyname;
    }

    public List<configProductBrands> getProductBrandsList() {
        return productBrandsList;
    }

    public void setProductBrandsList(List<configProductBrands> productBrandsList) {
        this.productBrandsList = productBrandsList;
    }
}
