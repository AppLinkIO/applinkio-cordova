//
//  AppLinkIOPlugin.java
//
//  Copyright 2018 AppLinkIO.io Inc. All rights reserved.
//

package io.applink.cordova;


import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.util.Log;

import io.applink.applinkio.AppLinkIO;


public class AppLinkIOPlugin extends CordovaPlugin {
  private static final String TAG = "AppLinkIOPlugin";


  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing AppLinkIOPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if (action.equals("initAppLinkIO")) {

      cordova.getThreadPool().execute(new Runnable() {
            public void run() {
              String projectToken = optString(args, 0);
              AppLinkIO.initAppLinkIO(cordova.getActivity().getApplicationContext(), projectToken);
              callbackContext.success();              
            }
        }); 
        return true;
    } else if (action.equals("initAppLinkIOWithOptions")) {
      
      if (args.length() == 2) {

          cordova.getThreadPool().execute(new Runnable() {
              public void run() {
                 // Thread-safe.
                String projectToken = optString(args, 0);
                Map<String, String> appOptions = optStringMap(args, 1);
                AppLinkIO.initAppLinkIOWithOptions(cordova.getActivity().getApplicationContext(), projectToken, projectOptions);
                callbackContext.success();              
              }
          }); 
      } else {
        callbackContext.error("Requires String projectToken, Map<String, String> projectOptions.");
      }
      return true;
    } else if (action.equals("startSession")) {
      AppLinkIO.startSession();
      callbackContext.success();
      return true;
    } else if (action.equals("stopSession")) {
      AppLinkIO.stopSession();
      callbackContext.success();
      return true;
    } else if (action.equals("linkUser")) {

      if (args.length() == 2) {
        String userIdentifier = optString(args, 0);
        String identifierType = optString(args, 1);
        AppLinkIO.linkUser(userIdentifier, identifierType);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String userIdentifier, String identifierType.");
      }
      return true;
    } else if (action.equals("unlinkUser")) {
      AppLinkIO.unlinkUser();
      callbackContext.success();
      return true;
    } else if (action.equals("setUserAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        String value = optString(args, 1);
        AppLinkIO.setUserAttribute(attribute, value);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    } else if (action.equals("incrementUserAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        String value = optString(args, 1);
        AppLinkIO.incrementUserAttribute(attribute, Integer.valueOf(value));
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    } else if (action.equals("decrementUserAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        String value = optString(args, 1);
        AppLinkIO.decrementUserAttribute(attribute, Integer.valueOf(value));
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    }  else if (action.equals("linkCompany")) {

      if (args.length() == 1) {
        String companyName = optString(args, 0); 
        AppLinkIO.linkCompany(companyName);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String companyName.");
      }
      return true;
    } else if (action.equals("unlinkCompany")) {
      AppLinkIO.unlinkCompany();
      callbackContext.success();
      return true;
    } else if (action.equals("setCompanyAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        String value = optString(args, 1);
        AppLinkIO.setCompanyAttribute(attribute, value);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    } else if (action.equals("incrementCompanyAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        String value = optString(args, 1);
        AppLinkIO.incrementCompanyAttribute(attribute, Integer.valueOf(value));
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    } else if (action.equals("decrementCompanyAttribute")) {

      if (args.length() == 2) {
        String attribute = optString(args, 0);
        Integer value = optString(args, 1);
        AppLinkIO.decrementCompanyAttribute(attribute, Integer.valueOf(value));
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attribute, String value.");
      }
      return true;
    } else if (action.equals("trackScreenView")) {
      String screenName = optString(args, 0);
      AppLinkIO.trackScreenView(screenName);
      callbackContext.success();
      return true;
    } else if (action.equals("trackScreenViewWithAttributes")) {
      if (args.length() == 2) {
        String screenName = optString(args, 0);
        Map<String, String> attributes = optStringMap(args, 1);
        AppLinkIO.trackScreenView(screenName, attributes);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String screenName, Map<String, String> attributes.");
      }
      return true;      
    } else if (action.equals("trackEvent")) {
      String eventName = optString(args, 0);
      AppLinkIO.trackEvent(eventName);
      callbackContext.success();
      return true;
    } else if (action.equals("trackEventWithAttributes")) {
      if (args.length() == 2) {
        String eventName = optString(args, 0);
        Map<String, String> attributes = optStringMap(args, 1);
        AppLinkIO.trackEvent(eventName, attributes);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String eventName, Map<String, String> attributes.");
      }
      return true;    
    }  
    return false;
  }

    /*******************
     * Private Methods
     ******************/
    private boolean isNotNull(JSONArray jsonArray, int index) throws JSONException {
        return jsonArray != null && jsonArray.length() > index && !jsonArray.isNull(index);
    }



    private String optString(JSONArray jsonArray, int index) throws JSONException {
        if (isNotNull(jsonArray, index)) {
            return jsonArray.getString(index);
        }

        return null;
    }



    private HashMap<String, String> optStringMap(JSONArray jsonArray, int index) throws JSONException {
        if (isNotNull(jsonArray, index)) {
            return convertToStringMap(jsonArray.getJSONObject(index));
        }

        return null;
    }


    private HashMap<String, String> convertToStringMap(JSONObject jsonObject) throws JSONException {
        HashMap<String, String> map = null;
        if (jsonObject != null && jsonObject.length() > 0) {
            map = new HashMap<String, String>();
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = jsonObject.getString(key);
                map.put(key, value);
            }
        }

        return map;
    }

        


}
