//
//  AppLinkIOPlugin.java
//
//  Copyright 2018 AppLinkIO.io Inc. All rights reserved.
//

package io.applink.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import java.util.Map;
import java.util.Date;


import io.applink.applinkio.AppLinkIO;


public class AppLinkIOPlugin extends CordovaPlugin {
  private static final String TAG = "AppLinkIOPlugin";


  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing AppLinkIOPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if (action.equals("initAppLinkIO")) {
        String appToken = optString(args, 0);
        AppLinkIO.initAppLinkIO(cordova.getActivity().getApplicationContext(), appToken);
        callbackContext.success();
        return true;
    } else if (action.equals("initAppLinkIOWithOptions")) {
      if (args.length() == 2) {
        String appToken = optString(args, 0);
        Map<String, String> appOptions = optStringMap(args, 1);
        AppLinkIO.initAppLinkIOWithOptions(cordova.getActivity().getApplicationContext(), appToken, appOptions);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String appToken, Map<String, String> appOptions.");
      }
      return true;
    } else if (action.equals("unlinkAppLinkIO")) {
      AppLinkIO.unlinkAppLinkIO();
      callbackContext.success();
      return true;
    } else if (action.equals("linkUser")) {
      String userEmailAddress = optString(args, 0);
      AppLinkIO.linkUser(userEmailAddress);
      callbackContext.success();
      return true;      
    } else if (action.equals("setUserAttribute")) {

      if (args.length() == 2) {
        String attributeName = optString(args, 0);
        String attributeValue = optString(args, 1);
        AppLinkIO.setUserAttribute(attributeName, attributeValue);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String attributeName, String attributeValue.");
      }
      return true;
    } else if (action.equals("trackScreenView")) {
      String screenName = optString(args, 0);
      AppLinkIO.trackScreenView(screenName);
      callbackContext.success();
      return true;
    } else if (action.equals("trackScreenViewWithExtras")) {
      if (args.length() == 2) {
        String screenName = optString(args, 0);
        Map<String, String> screenExtras = optStringMap(args, 1);
        AppLinkIO.trackScreenViewWithOptions(screenName, screenExtras);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String screenName, Map<String, String> screenExtras.");
      }
      return true;      
    } else if (action.equals("trackEvent")) {
      String eventName = optString(args, 0);
      AppLinkIO.trackEvent(eventName);
      callbackContext.success();
      return true;
    } else if (action.equals("trackEventWithExtras")) {
      if (args.length() == 2) {
        String eventName = optString(args, 0);
        Map<String, String> eventExtras = optStringMap(args, 1);
        AppLinkIO.trackEventWithOptions(eventName, eventExtras);
        callbackContext.success();
      } else {
        callbackContext.error("Requires String eventName, Map<String, String> eventExtras.");
      }
      return true;    
    } else if (action.equals("trackImpression")) {
      Map<String, String> displayDetails = optStringMap(args, 0);
      AppLinkIO.trackImpression(displayDetails);
      callbackContext.success();
      return true;      
    } else if (action.equals("trackInteraction")) {
      if (args.length() == 2) {
        Map<String, String> displayDetails = optStringMap(args, 0);
        String interactionType = optString(args, 1);
        AppLinkIO.trackInteraction(displayDetails, interactionType);
        callbackContext.success();
      } else {
        callbackContext.error("Requires Map<String, String> displayDetails, String interactionType.");
      }
      return true; 
    } else if (action.equals("trackConversion")) {
      if (args.length() == 2) {
        Map<String, String> displayDetails = optStringMap(args, 0);
        Map<String, String> conversionDetails = optStringMap(args, 1);
        AppLinkIO.trackConversion(displayDetails, conversionDetails);
        callbackContext.success();
      } else {
        callbackContext.error("Requires Map<String, String> displayDetails, Map<String, String> conversionDetails.");
      }
      return true; 
    } else if (action.equals("trackSearch")) {
      Map<String, String> searchDetails = optStringMap(args, 0);
      AppLinkIO.trackSearch(searchDetails);
      callbackContext.success();
      return true;      
    }
    return false;
  }

}
