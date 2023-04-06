package cs.hku.myapplication.protocol;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WeatherRequest extends RequestBase{
    private String mCity;

    @Override
    public String getUrl() {
        String url = null;
        try {
            String WEATHER_URL = "http://api.map.baidu.com/telematics/v3/weather?location=%s&output=json&ak=vEWCgIndW4S8U6ANY3CIs2Wo"; //重新申请
            url = String.format(WEATHER_URL, URLEncoder.encode(mCity, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    @Override
    protected void buildRequest(JSONObject object) throws JSONException {
    }
}
