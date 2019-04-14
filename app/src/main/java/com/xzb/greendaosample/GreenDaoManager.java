package com.xzb.greendaosample;

import android.content.Context;

import com.xzb.greendaosample.constants.Constant;
import com.xzb.greendaosample.model.entitys.DaoMaster;
import com.xzb.greendaosample.model.entitys.DaoSession;
import com.xzb.greendaosample.model.entitys.WeatherCityDao;
import com.xzb.greendaosample.model.entitys.WheatherCityDao;

/**
 * @Author: xiangzhenbiao
 * @Date: 2019-04-14 16:57
 * @Description:
 */

public class GreenDaoManager {

    private static volatile GreenDaoManager instance;

    private WeatherCityDao weatherCityDao;

    private GreenDaoManager(){

    }

    public static GreenDaoManager getInstance(){
        if(instance == null){
            synchronized (GreenDaoManager.class){
                if(instance == null){
                    instance = new GreenDaoManager();
                }
            }
        }
        return instance;
    }

    private void initWeatherCityDao(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context.getApplicationContext(),
                Constant.WEATHER_DB_NAME,null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        weatherCityDao = daoSession.getWeatherCityDao();
    }

    public WeatherCityDao getWeatherCityDao(Context context){
        if(weatherCityDao == null){
            synchronized (GreenDaoManager.class){
                if(weatherCityDao == null){
                    initWeatherCityDao(context);
                }
            }
        }
        return weatherCityDao;
    }

}
