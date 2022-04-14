package com.serviingo.serviingo.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.serviingo.serviingo.modelrepo.request.CartRequest;

import java.lang.reflect.Type;
import java.util.List;


public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private Context mCtx;
    private static final String SHARED_PREF_NAME = "my_shared_preff";
    private static final String SHARED_PREFStoreFirebase = "StoreFirebaseToken";


    private static final String SHARED_PREF_NAME2 = "my_shared_preff2";
    private static final String SHARED_PREF_NAME3 = "my_memebershippurchase";

    private static final String SHARED_PREF_NAME4 = "addon_service_Array_Id";

    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);

        }
        return mInstance;
    }

    public void saveuser(User_login user_login) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("loginid", user_login.getLoginid());

        editor.putString("id", user_login.getId());
        editor.putString("fullname", user_login.getFullname());
        editor.putString("phone", user_login.getPhone());
        editor.putString("email", user_login.getEmail());
        editor.putString("role", user_login.getRole());
        editor.putString("access_token", user_login.getAccess_token());
        editor.apply();

    }

    public void SlotTimeDate(String Date, String Time) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Date", Date);
        editor.putString("Time", Time);

        editor.apply();

    }
    public String getSlotDate() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Date", null);

    }
    public String getSlotTime() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Time", null);

    }

    public void OrderId(String idd, String addon_service_ids, String Quentiy) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("idd", idd);
        editor.putString("addon_service_ids", addon_service_ids);
        editor.putString("Quentiy", Quentiy);
        editor.apply();

    }

    public void OrderDetails(String package_id, String pack_quantity) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("package_id", package_id);
        editor.putString("pack_quantity", pack_quantity);
        editor.apply();
    }


    public String getpackage_id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("package_id", null);

    }

    public void PacckageDetails(String Addonsepackage_id,String  Addonsequantity) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Addonsepackage_id", Addonsepackage_id);
        editor.putString("Addonsequantity", Addonsequantity);
        editor.apply();
    }
    public void SetSerivceID(String Service_id) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Service_id", Service_id);
        editor.apply();
    }

    public String GetSerivceID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Service_id", null);

    }
    public void addon_service_Array_Id(String addon_service_Array_Id) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME4, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("addon_service_Array_Id", addon_service_Array_Id);
        editor.apply();
    }

    public String Get_addon_service_Array_Id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME4, Context.MODE_PRIVATE);
        return sharedPreferences.getString("addon_service_Array_Id", null);

    }
    public void CityIDDetails(String CityID) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CityID", CityID);
        editor.apply();
    }
    public void categoriesID(String categoriesID) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("categoriesID", categoriesID);

        editor.apply();
    }

    public String getcategoriesID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("categoriesID", null);

    }
    public String Addonsegetpackage_id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Addonsepackage_id", null);

    }

    public String GetCityid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("CityID", null);

    }
    public String Addonsequantityid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Addonsequantity", null);

    }
    public String getpack_quantity() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("pack_quantity", null);

    }

    public static synchronized SharedPrefManager getInstans(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public String getUserId() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("id", null);

    }

    public String getIdd() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("idd", null);

    }

    public String getaddon_service_ids() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("addon_service_ids", null);

    }

    public String getQuentiy() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Quentiy", null);

    }

    public String getNumber() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("phone", null);

    }

    public String getfullname() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("fullname", null);

    }

    public String getemail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("email", null);

    }

    public String getrole() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("role", null);

    }



    public void GetMemberShidata(String membership_id, String membership_cost,String Membershipname) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("membership_id", membership_id);
        editor.putString("membership_cost", membership_cost);
        editor.putString("Membershipname", Membershipname);

        editor.apply();

    }
    public void SetMembershipCost(String MembershipCost) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("MembershipDiscount", MembershipCost);

        editor.apply();
    }

    public String GetMembershipCost() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        return sharedPreferences.getString("MembershipDiscount", null);

    }
    public String GetMembershipname() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Membershipname", null);

    }

    public String getmembership_id() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        return sharedPreferences.getString("membership_id", null);

    }
    public String getmembership_cost() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        return sharedPreferences.getString("membership_cost", null);

    }
    public String getaccess_token() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("access_token", null);

    }

    public String GetUserID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("id", null);

    }
    public boolean isLoggedin() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("loginid", -1) != -1;
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public String isPacakgein() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Addonsepackage_id", null);

    }
  /*  public boolean isPacakgein() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("Addonsepackage_id", -1) != -1;
    }*/

    public void MembsershipClear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME3, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void AddonseClear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME4, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void pacakgeClear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    public  boolean StoreFirebaseToken(String token)
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREFStoreFirebase,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("StoreFirebaseToken",token);
        editor.apply();
        return true;
    }
    public String getFirebaseToken(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREFStoreFirebase,Context.MODE_PRIVATE);

        return sharedPreferences.getString("StoreFirebaseToken",null);

    }
}
