
//
//  applinkio.js
//
//  Copyright 2018 AppLinkIO.io Inc. All rights reserved.
//
var exec = require('cordova/exec');

var PLUGIN_NAME = 'AppLinkIOPlugin';

var AppLinkIOPlugin = {

 initAppLinkIO: function(appToken) {
    exec(null, null, PLUGIN_NAME, 'initAppLinkIO', [appToken]);
  },
 initAppLinkIOWithOptions: function(appToken, appOptions) {
    exec(null, null, PLUGIN_NAME, 'initAppLinkIOWithOptions', [appToken, appOptions]);
  },
 unlinkAppLinkIO: function() {
    exec(null, null, PLUGIN_NAME, 'unlinkAppLinkIO', []);
  },
 linkUser: function(userEmailAddress) {
    exec(null, null, PLUGIN_NAME, 'linkUser', [userEmailAddress]);
  },
 setUserAttribute: function(attributeName, attributeValue) {
    exec(null, null, PLUGIN_NAME, 'setUserAttribute', [attributeName, attributeValue]);
  },
 trackScreenView: function(screenName) {
    exec(null, null, PLUGIN_NAME, 'trackScreenView', [screenName]);
  },
 trackScreenViewWithExtras: function(screenName, screenExtras) {
    exec(null, null, PLUGIN_NAME, 'trackScreenViewWithExtras', [screenName, screenExtras]);
  },
 trackEvent: function(eventName) {
    exec(null, null, PLUGIN_NAME, 'trackEvent', [eventName]);
  },
 trackEventWithExtras: function(eventName, eventExtras) {
    exec(null, null, PLUGIN_NAME, 'trackEventWithExtras', [eventName, eventExtras]);
  },
 trackImpression: function(displayDetails) {
    exec(null, null, PLUGIN_NAME, 'trackImpression', [displayDetails]);
  },
 trackInteraction: function(displayDetails, interactionType) {
    exec(null, null, PLUGIN_NAME, 'trackInteraction', [displayDetails, interactionType]);
  },
 trackConversion: function(displayDetails, conversionDetails) {
    exec(null, null, PLUGIN_NAME, 'trackConversion', [displayDetails, conversionDetails]);
  },
 trackSearch: function(searchDetails) {
    exec(null, null, PLUGIN_NAME, 'trackSearch', [searchDetails]);
  }
};

module.exports = AppLinkIOPlugin;
