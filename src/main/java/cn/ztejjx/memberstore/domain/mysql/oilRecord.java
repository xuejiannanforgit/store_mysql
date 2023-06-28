package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("oil_record")
public class oilRecord {
    private String oilrecordId;

    private String employeeId;

    private String employeeName;

    private String employeeIdcard;

    private String employeePhone;

    private String employeeDept;

    private String makeoutDept;

    private String oilClass;

    private BigDecimal applicationOilnum;

    private BigDecimal applicationOilamount;

    private BigDecimal actualOilnum;

    private BigDecimal actualOilamount;

    private String photo;

    private BigDecimal restOilnum;

    private String drawer;

    private String drawerDept;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date createdDate;

    private String createdBy;

    private Integer enabledFlag;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date drawerDate;

    private String vehiclesType;

    private String licensePlate;

    private String oilcardNum;

    private String area;

    private String oilType;

    private BigDecimal oilprice;

    private Integer status;

    private String imageCar;

    private String oilcardstation;

    private String oilcardaddr;



    private BigDecimal carMiles;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date completeDate;

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public BigDecimal getCarMiles() {
        return carMiles;
    }

    public void setCarMiles(BigDecimal carMiles) {
        this.carMiles = carMiles;
    }

    public String getOilcardstation() {
        return oilcardstation;
    }

    public void setOilcardstation(String oilcardstation) {
        this.oilcardstation = oilcardstation;
    }

    public String getOilcardaddr() {
        return oilcardaddr;
    }

    public void setOilcardaddr(String oilcardaddr) {
        this.oilcardaddr = oilcardaddr;
    }

    @Override
    public String toString() {
        return "oilRecord{" +
                "oilrecordId='" + oilrecordId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeIdcard='" + employeeIdcard + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeDept='" + employeeDept + '\'' +
                ", makeoutDept='" + makeoutDept + '\'' +
                ", oilClass='" + oilClass + '\'' +
                ", applicationOilnum=" + applicationOilnum +
                ", applicationOilamount=" + applicationOilamount +
                ", actualOilnum=" + actualOilnum +
                ", actualOilamount=" + actualOilamount +
                ", photo='" + photo + '\'' +
                ", restOilnum=" + restOilnum +
                ", drawer='" + drawer + '\'' +
                ", drawerDept='" + drawerDept + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", drawerDate=" + drawerDate +
                ", vehiclesType='" + vehiclesType + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", oilcardNum='" + oilcardNum + '\'' +
                ", area='" + area + '\'' +
                ", oilType='" + oilType + '\'' +
                ", oilprice=" + oilprice +
                ", status=" + status +
                ", imageCar='" + imageCar + '\'' +
                '}';
    }

    public String getOilrecordId() {
        return oilrecordId;
    }

    public void setOilrecordId(String oilrecordId) {
        this.oilrecordId = oilrecordId == null ? null : oilrecordId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getEmployeeIdcard() {
        return employeeIdcard;
    }

    public void setEmployeeIdcard(String employeeIdcard) {
        this.employeeIdcard = employeeIdcard == null ? null : employeeIdcard.trim();
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone == null ? null : employeePhone.trim();
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept == null ? null : employeeDept.trim();
    }

    public String getMakeoutDept() {
        return makeoutDept;
    }

    public void setMakeoutDept(String makeoutDept) {
        this.makeoutDept = makeoutDept == null ? null : makeoutDept.trim();
    }

    public String getOilClass() {
        return oilClass;
    }

    public void setOilClass(String oilClass) {
        this.oilClass = oilClass == null ? null : oilClass.trim();
    }

    public BigDecimal getApplicationOilnum() {
        return applicationOilnum;
    }

    public void setApplicationOilnum(BigDecimal applicationOilnum) {
        this.applicationOilnum = applicationOilnum;
    }

    public BigDecimal getApplicationOilamount() {
        return applicationOilamount;
    }

    public void setApplicationOilamount(BigDecimal applicationOilamount) {
        this.applicationOilamount = applicationOilamount;
    }

    public BigDecimal getActualOilnum() {
        return actualOilnum;
    }

    public void setActualOilnum(BigDecimal actualOilnum) {
        this.actualOilnum = actualOilnum;
    }

    public BigDecimal getActualOilamount() {
        return actualOilamount;
    }

    public void setActualOilamount(BigDecimal actualOilamount) {
        this.actualOilamount = actualOilamount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public BigDecimal getRestOilnum() {
        return restOilnum;
    }

    public void setRestOilnum(BigDecimal restOilnum) {
        this.restOilnum = restOilnum;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer == null ? null : drawer.trim();
    }

    public String getDrawerDept() {
        return drawerDept;
    }

    public void setDrawerDept(String drawerDept) {
        this.drawerDept = drawerDept == null ? null : drawerDept.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Date getDrawerDate() {
        return drawerDate;
    }

    public void setDrawerDate(Date drawerDate) {
        this.drawerDate = drawerDate;
    }

    public String getVehiclesType() {
        return vehiclesType;
    }

    public void setVehiclesType(String vehiclesType) {
        this.vehiclesType = vehiclesType == null ? null : vehiclesType.trim();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate == null ? null : licensePlate.trim();
    }

    public String getOilcardNum() {
        return oilcardNum;
    }

    public void setOilcardNum(String oilcardNum) {
        this.oilcardNum = oilcardNum == null ? null : oilcardNum.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType == null ? null : oilType.trim();
    }

    public BigDecimal getOilprice() {
        return oilprice;
    }

    public void setOilprice(BigDecimal oilprice) {
        this.oilprice = oilprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageCar() {
        return imageCar;
    }

    public void setImageCar(String imageCar) {
        this.imageCar = imageCar == null ? null : imageCar.trim();
    }
}