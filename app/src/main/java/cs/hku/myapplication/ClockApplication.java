package cs.hku.myapplication;

import android.app.Application;
import android.content.Context;

import cs.hku.myapplication.protocol.BusinessService;
import cs.hku.myapplication.utils.Constants;
import cs.hku.myapplication.utils.DateModel;
import cs.hku.myapplication.utils.FileUtils;
import cs.hku.myapplication.utils.SharedPreferenceModel;

public class ClockApplication extends Application {
    private static ClockApplication sEndzoneBoxApp;
    private BusinessService mBusinessService = new BusinessService();

    public static ClockApplication getInstance() {
        return sEndzoneBoxApp;
    }

    @Override
    public void onCreate() {
        sEndzoneBoxApp = this;
        init();
        super.onCreate();
    }


    public void init() {
        if (!FileUtils.isExistsFile(Constants.SHARE_PERFERENCE_FILE)) {
            SharedPreferenceModel model = new SharedPreferenceModel();
            model.setTypeHourPower(Constants.TALKING_HALF_AN_HOUR);
            DateModel startTimeModel = new DateModel();
            startTimeModel.setTime(12, 31);
            DateModel stopTimeModel = new DateModel();
            stopTimeModel.setTime(14, 31);
            model.setStartHourPowerTime(startTimeModel);
            model.setStopHourPowerTime(stopTimeModel);
            model.setCity(getString(R.string.HongKong)); //
            model.save();
        }
    }

    public static Context getContext() {
        return ClockApplication.getInstance().getApplicationContext();
    }

    public BusinessService getBusinessService() {
        return mBusinessService;
    }

    private MainActivity mMainActivity;

    public void setMainActivity(MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
    }

    public MainActivity getMainActivity() {
        return mMainActivity;
    }

}
