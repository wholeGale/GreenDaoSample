package com.xzb.greendaosample.model.entitys;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

/**
 * @Author: xiangzhenbiao
 * @Date: 2019-04-14 16:23
 * @Description:
 */
//@Property(nameInDb = "weather_city")
@Entity
public class WeatherCity {

    @Id(autoincrement = true)
    private long id;

    //国家
    @NotNull
    private String country;

    //省
    @NotNull
    private String province;

    //市
    @NotNull
    private String city;

    //乡，镇
    private String town;

    //nameInDb：在数据中使用的别名，默认使用的是成员变量名
    @Property(nameInDb = "area_code")
    private String areaCode;

    private String latitude;

    private String longitude;

    //城市类型，0为国内，1为国外
    @Property(nameInDb = "city_type")
    private int cityType;

    @Property(nameInDb = "city_pin_yin")
    private String cityPinYin;

    @Generated(hash = 1933828203)
    public WeatherCity(long id, @NotNull String country, @NotNull String province,
            @NotNull String city, String town, String areaCode, String latitude,
            String longitude, int cityType, String cityPinYin) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.town = town;
        this.areaCode = areaCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityType = cityType;
        this.cityPinYin = cityPinYin;
    }

    @Generated(hash = 187543502)
    public WeatherCity() {
    }

    @Override
    public String toString() {
        return "WeatherCity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", cityType=" + cityType +
                ", cityPinYin='" + cityPinYin + '\'' +
                '}';
    }
    //注：构造方法和setter/getter方法为编译工程时，greenrobot根据注解自动生成

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getCityType() {
        return this.cityType;
    }

    public void setCityType(int cityType) {
        this.cityType = cityType;
    }

    public String getCityPinYin() {
        return this.cityPinYin;
    }

    public void setCityPinYin(String cityPinYin) {
        this.cityPinYin = cityPinYin;
    }


}
