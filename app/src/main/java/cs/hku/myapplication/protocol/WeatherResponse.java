package cs.hku.myapplication.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherResponse extends ResponseBase {
    private int mErrorCode;
    private String mCurrentCity;
    private int mPM25;
    private Weather todayWeather;

    public class Weather {
        public String date;
        public String weather;
        public String wind;
        public String temperature;

        public void parse(JSONObject jsonObject) {
            try {
                date = jsonObject.getString("date");
                weather = jsonObject.getString("weather");
                wind = jsonObject.getString("wind");
                temperature = jsonObject.getString("temperature");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public int getmErrorCode() {
        return mErrorCode;
    }

    public void setmErrorCode(int mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public String getmCurrentCity() {
        return mCurrentCity;
    }

    public void setmCurrentCity(String mCurrentCity) {
        this.mCurrentCity = mCurrentCity;
    }

    public int getmPM25() {
        return mPM25;
    }

    public void setmPM25(int mPM25) {
        this.mPM25 = mPM25;
    }

    public Weather getTodayWeather() {
        return todayWeather;
    }

    public void setTodayWeather(Weather todayWeather) {
        this.todayWeather = todayWeather;
    }

    public WeatherResponse(JSONObject response) {
        super.parseResponse(response);
    }

    @Override
    protected boolean parse(JSONObject object) throws JSONException {
        mErrorCode = object.getInt("error");
        if (mErrorCode == 0) {
            JSONArray results = object.getJSONArray("results");
            JSONObject summary = (JSONObject) results.get(0);
            mCurrentCity = summary.getString("currentCity");
            mPM25 = summary.getInt("pm25");
            JSONArray weathers = summary.getJSONArray("weather_data");
            todayWeather = new Weather();
            JSONObject todayJsonObject = (JSONObject) weathers.get(0);
            todayWeather.parse(todayJsonObject);
        }
        return true;
    }
}
