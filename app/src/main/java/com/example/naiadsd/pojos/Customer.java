package com.example.naiadsd.pojos;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customer {

   /* @SerializedName("Id")
    private int Id;*/
   @SerializedName("data")
   private List<Data> data;
    @SerializedName("CustomerId")
    private String CustomerId;
    @SerializedName("ShiptoAddressLineOne")
    private String ShiptoAddressLineOne;

    @SerializedName("CustomerName")
    private String CustomerName;

    public String getShiptoAddressLineOne() {
        return ShiptoAddressLineOne;
    }

    public void setShiptoAddressLineOne(String shiptoAddressLineOne) {
        ShiptoAddressLineOne = shiptoAddressLineOne;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    /* @SerializedName("CustomerName")
    private String CustomerName;

    @SerializedName("BilltoAddressLineOne")
    private String BilltoAddressLineOne;

    @SerializedName("BilltoAddressLineTwo")
    private String BilltoAddressLineTwo;

    @SerializedName("BilltoCity")
    private String BilltoCity;

    @SerializedName("BilltoState")
    private String BilltoState;


    @SerializedName("BilltoZip")
    private String BilltoZip;

    @SerializedName("BillFName")
    private String BillFName;

    @SerializedName("BillLName")
    private String BillLName;

    @SerializedName("ShiptoAddressLineOne")
    private String ShiptoAddressLineOne;

    @SerializedName("ShiptoAddressLineTwo")
    private String ShiptoAddressLineTwo;

    @SerializedName("ShiptoState")
    private String ShiptoState;

    @SerializedName("ShiptoCity")
    private String ShiptoCity;

    @SerializedName("ShiptoZip")
    private String ShiptoZip;

    @SerializedName("Phone")
    private String Phone;

    @SerializedName("IsInactive")
    private boolean IsInactive;

    @SerializedName("PricingLevel")
    private String PricingLevel;


    @SerializedName("UseStandradTerms")
    private String UseStandradTerms;

    @SerializedName("CODTerms")
    private String CODTerms;

    @SerializedName("DueDays")
    private String DueDates;

      @SerializedName("DiscountDays")
    private String DiscountDays;

    @SerializedName("DiscountPercentage")
    private String DiscountPercentage;

    @SerializedName("CreditLimit")
    private String CreditLimit;

    @SerializedName("PrepaidTerms")
    private String PrepaidTerms;

    @SerializedName("RouteCode")
    private String RouteCode;

    @SerializedName("ServiceFrequency")
    private String ServiceFrequency;

       @SerializedName("ServiceSequence")
    private String ServiceSequence;


    @SerializedName("ServiceDays")
    private String ServiceDays;
*/

   /* public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }*/

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }



   /* public String getBilltoAddressLineOne() {
        return BilltoAddressLineOne;
    }

    public void setBilltoAddressLineOne(String billtoAddressLineOne) {
        BilltoAddressLineOne = billtoAddressLineOne;
    }

    public String getBilltoAddressLineTwo() {
        return BilltoAddressLineTwo;
    }

    public void setBilltoAddressLineTwo(String billtoAddressLineTwo) {
        BilltoAddressLineTwo = billtoAddressLineTwo;
    }

    public String getBilltoCity() {
        return BilltoCity;
    }

    public void setBilltoCity(String billtoCity) {
        BilltoCity = billtoCity;
    }

    public String getBilltoState() {
        return BilltoState;
    }

    public void setBilltoState(String billtoState) {
        BilltoState = billtoState;
    }

    public String getBilltoZip() {
        return BilltoZip;
    }

    public void setBilltoZip(String billtoZip) {
        BilltoZip = billtoZip;
    }

    public String getBillFName() {
        return BillFName;
    }

    public void setBillFName(String billFName) {
        BillFName = billFName;
    }

    public String getBillLName() {
        return BillLName;
    }

    public void setBillLName(String billLName) {
        BillLName = billLName;
    }

    public String getShiptoAddressLineOne() {
        return ShiptoAddressLineOne;
    }

    public void setShiptoAddressLineOne(String shiptoAddressLineOne) {
        ShiptoAddressLineOne = shiptoAddressLineOne;
    }

    public String getShiptoAddressLineTwo() {
        return ShiptoAddressLineTwo;
    }

    public void setShiptoAddressLineTwo(String shiptoAddressLineTwo) {
        ShiptoAddressLineTwo = shiptoAddressLineTwo;
    }

    public String getShiptoState() {
        return ShiptoState;
    }

    public void setShiptoState(String shiptoState) {
        ShiptoState = shiptoState;
    }

    public String getShiptoCity() {
        return ShiptoCity;
    }

    public void setShiptoCity(String shiptoCity) {
        ShiptoCity = shiptoCity;
    }

    public String getShiptoZip() {
        return ShiptoZip;
    }

    public void setShiptoZip(String shiptoZip) {
        ShiptoZip = shiptoZip;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public boolean isInactive() {
        return IsInactive;
    }

    public void setInactive(boolean inactive) {
        IsInactive = inactive;
    }

    public String getPricingLevel() {
        return PricingLevel;
    }

    public void setPricingLevel(String pricingLevel) {
        PricingLevel = pricingLevel;
    }

    public String getUseStandradTerms() {
        return UseStandradTerms;
    }

    public void setUseStandradTerms(String useStandradTerms) {
        UseStandradTerms = useStandradTerms;
    }

    public String getCODTerms() {
        return CODTerms;
    }

    public void setCODTerms(String CODTerms) {
        this.CODTerms = CODTerms;
    }

    public String getDueDates() {
        return DueDates;
    }

    public void setDueDates(String dueDates) {
        DueDates = dueDates;
    }

    public String getDiscountDays() {
        return DiscountDays;
    }

    public void setDiscountDays(String discountDays) {
        DiscountDays = discountDays;
    }

    public String getDiscountPercentage() {
        return DiscountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        DiscountPercentage = discountPercentage;
    }

    public String getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        CreditLimit = creditLimit;
    }

    public String getPrepaidTerms() {
        return PrepaidTerms;
    }

    public void setPrepaidTerms(String prepaidTerms) {
        PrepaidTerms = prepaidTerms;
    }

    public String getRouteCode() {
        return RouteCode;
    }

    public void setRouteCode(String routeCode) {
        RouteCode = routeCode;
    }

    public String getServiceFrequency() {
        return ServiceFrequency;
    }

    public void setServiceFrequency(String serviceFrequency) {
        ServiceFrequency = serviceFrequency;
    }

    public String getServiceSequence() {
        return ServiceSequence;
    }

    public void setServiceSequence(String serviceSequence) {
        ServiceSequence = serviceSequence;
    }

    public String getServiceDays() {
        return ServiceDays;
    }

    public void setServiceDays(String serviceDays) {
        ServiceDays = serviceDays;
    }*/
}
