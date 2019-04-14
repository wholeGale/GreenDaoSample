package com.xzb.greendaosample;

import android.content.Context;

import com.xzb.greendaosample.model.entitys.WeatherCity;
import com.xzb.greendaosample.model.entitys.WeatherCityDao;

import java.util.List;

/**
 * @Author: xiangzhenbiao
 * @Date: 2019-04-14 17:31
 * @Description:
 */

public class WeatherCityDaoManager {

    /**
     * 单条插入
     * @param context
     * @param weatherCity
     */
    public void insertWeatherCity(Context context, WeatherCity weatherCity){
        GreenDaoManager.getInstance().getWeatherCityDao(context).insert(weatherCity);
    }

    /**
     * 批量插入，必须指定id？
     * @param context
     * @param weatherCitys
     */
    public void insertWeatherCitys(Context context, List<WeatherCity> weatherCitys){
        GreenDaoManager.getInstance().getWeatherCityDao(context).insertInTx(weatherCitys);
    }

    /**
     * 查询所有
     * @param context
     * @return
     */
    public List<WeatherCity> selectWeatherCityAll(Context context){
        List<WeatherCity> weatherCitys = GreenDaoManager.getInstance().getWeatherCityDao(context).queryBuilder().list();
        return weatherCitys;
    }

    /**
     * 条件查询
     * @param context
     * @param cityName
     * @return
     */
    public List<WeatherCity> selectWeatherCityByCityName(Context context,String cityName){
        return GreenDaoManager.getInstance().getWeatherCityDao(context)
                .queryBuilder().where(WeatherCityDao.Properties.City.eq(cityName)).list();
    }

    /**
     * 模糊查询需要对传人的值前后加"%"
     * @param context
     * @param cityName
     * @return
     */
    public List<WeatherCity> queryWeatherCityByCityText(Context context,String cityName){
        return GreenDaoManager.getInstance().getWeatherCityDao(context)
                .queryBuilder().where(WeatherCityDao.Properties.City.like("%"+ cityName + "%")).list();
    }

    public List<WeatherCity> queryWeatherCityByCityPinYin(Context context,String cityName){
        return GreenDaoManager.getInstance().getWeatherCityDao(context)
                .queryBuilder().where(WeatherCityDao.Properties.CityPinYin.like("%"+ cityName + "%")).list();
    }


    /**
     *
     * @param context
     * @param weatherCity
     */
    public void deleteWeatherCity(Context context,WeatherCity weatherCity){
        GreenDaoManager.getInstance().getWeatherCityDao(context).delete(weatherCity);
    }

    /**
     *
     * @param context
     * @param key
     */
    public void deleteWeatherCityByKey(Context context,Long key){
        GreenDaoManager.getInstance().getWeatherCityDao(context).deleteByKey(key);
    }

    /**
     * 批量删除指定集合数据
     * @param context
     * @param weatherCitys
     */
    public void deleteWeatherCitys(Context context,List<WeatherCity> weatherCitys){
        GreenDaoManager.getInstance().getWeatherCityDao(context).deleteInTx(weatherCitys);
    }

    /**
     * 批量删除所有
     * @param context
     */
    public void deleteWAllWeatherCitys(Context context){
        GreenDaoManager.getInstance().getWeatherCityDao(context).deleteAll();
    }

    /**
     * 更新一条数据
     * @param context
     * @param weatherCity
     */
    public void updateWeatherCity(Context context,WeatherCity weatherCity){
        GreenDaoManager.getInstance().getWeatherCityDao(context).update(weatherCity);
    }

    /**
     * 批量更新
     * @param context
     * @param weatherCitys
     */
    public void updateWeatherCitys(Context context,List<WeatherCity> weatherCitys){
        GreenDaoManager.getInstance().getWeatherCityDao(context).updateInTx(weatherCitys);
    }

}
