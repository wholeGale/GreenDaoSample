package com.xzb.greendaosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.xzb.greendaosample.model.entitys.WeatherCity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    private static final String TAG = "greendaoMainActivity";

    WeatherCityDaoManager weatherCityDaoManager;
    List<WeatherCity> weatherCityList = new ArrayList<>();

    EditText et_city_text;
    private String cityText;

    private String[] provinces = {"北京", "上海", "广东", "湖北"};
    private String[] citys = {"北京市", "上海市", "深圳市", "恩施州"};
    //区，县
//    private String[] provinces = {"东城区", "静安区", "南山区", "利川市"};
    //乡镇
    private String[] towns = {"三里屯", "临汾", "新安", "都亭"};

    private String[] cityPinYin = {"beijing_bj_shanlitun_slt", "shanghai_sh_linfen_lf","guangdong_gd_shenzhen_sz_xinan_xa","hubei_hb_enshi_es_duting_dt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_city_text = findViewById(R.id.et_city_text);
        et_city_text.addTextChangedListener(this);

        weatherCityDaoManager = new WeatherCityDaoManager();
    }

    public void onClickInsert(View view){
        Log.d(TAG, "onClickInsert: ");
        for (int i = 0; i < provinces.length; i++) {
            WeatherCity weatherCity = new WeatherCity();
            weatherCity.setId(i);//怎么不能自增呢？？
            weatherCity.setCountry("中国");
            weatherCity.setProvince(provinces[i]);
            weatherCity.setCity(citys[i]);
            weatherCity.setTown(towns[i]);
            weatherCity.setCityType(1);
            weatherCity.setCityPinYin(cityPinYin[i]);

            weatherCityList.add(weatherCity);
            weatherCityDaoManager.insertWeatherCity(this, weatherCity);
        }

//        weatherCityDaoManager.insertWeatherCitys(this, weatherCityList);
    }

    public void onClickSelect(View view){
        Log.d(TAG, "onClickSelect: ");
//        List<WeatherCity> temps = weatherCityDaoManager.selectWeatherCityByCityName(this, citys[1]);
//        String cityText = "市";
//        String cityText = "施";
//        String cityText = "en";
//        List<WeatherCity> temps = weatherCityDaoManager.queryWeatherCityByCityText(this, cityText);
        List<WeatherCity> temps = weatherCityDaoManager.queryWeatherCityByCityPinYin(this, cityText);
        for (int i = 0; i < temps.size(); i++) {
            Log.d(TAG, "查询结果: " + temps.get(i).toString());
        }
    }

    public void onClickUpdate(View view){
        Log.d(TAG, "onClickUpdate: ");
        for (int i = 0; i < weatherCityList.size(); i++) {
            weatherCityList.get(i).setCityType(0);
        }
        weatherCityDaoManager.updateWeatherCitys(this, weatherCityList);
    }

    public void onClickDelete(View view){
        Log.d(TAG, "onClickDelete: ");
        weatherCityDaoManager.deleteWeatherCityByKey(this, 0L);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        cityText = s.toString().trim();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
