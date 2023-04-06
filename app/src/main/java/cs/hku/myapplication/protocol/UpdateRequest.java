package cs.hku.myapplication.protocol;

import org.json.JSONException;
import org.json.JSONObject;

import cs.hku.myapplication.utils.FuncUnit;

public class UpdateRequest extends RequestBase {
    @Override
    public String getUrl() {
        return "http://www.socoolby.com/clock/update";
        //renew
    }

    @Override
    protected void buildRequest(JSONObject object) throws JSONException {
        object.put("version", FuncUnit.getVersionName(FuncUnit.getBoxPackageName()));
    }
}
