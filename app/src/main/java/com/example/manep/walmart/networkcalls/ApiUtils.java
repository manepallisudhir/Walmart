package com.example.manep.walmart.networkcalls;


import android.content.Context;
import android.util.Log;

import com.example.manep.walmart.R;

public class ApiUtils {

    public static APIInterface walmartServiceCall(Context context){
        Log.i("newbasedomain", "bassProServiceCall: " + context.getResources().getString(R.string.newBaseDomain));
        return APIClient.getRetrofit(context.getResources().getString(R.string.newBaseDomain),context).create(APIInterface.class);
    }
}
