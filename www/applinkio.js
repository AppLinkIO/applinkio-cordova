
//
//  applinkio.js
//
//  Copyright 2019 AppLinkIO.io Inc. All rights reserved.
//
var exec = require('cordova/exec');

var PLUGIN_NAME = 'AppLinkIOPlugin';

var AppLinkIOPlugin = {

 initAppLinkIO: function(projectToken) {
    exec(null, null, PLUGIN_NAME, 'initAppLinkIO', [projectToken]);
  },
 initAppLinkIOWithOptions: function(projectToken, projectOptions) {
    exec(null, null, PLUGIN_NAME, 'initAppLinkIOWithOptions', [projectToken, projectOptions]);
  },
 startSession: function() {
    exec(null, null, PLUGIN_NAME, 'startSession', []);
  },
 stopSession: function() {
    exec(null, null, PLUGIN_NAME, 'stopSession', []);
  },
 linkUser: function(userIdentifier, identifierType) {
    exec(null, null, PLUGIN_NAME, 'linkUser', [userIdentifier, identifierType]);
  },
 unlinkUser: function() {
    exec(null, null, PLUGIN_NAME, 'unlinkUser', []);
  },
 setUserAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'setUserAttribute', [attribute, value]);
  }, 
 incrementUserAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'incrementUserAttribute', [attribute, value]);
  }, 
 decrementUserAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'decrementUserAttribute', [attribute, value]);
  }, 
 linkCompany: function(companyName) {
    exec(null, null, PLUGIN_NAME, 'linkCompany', [companyName]);
  },
 unlinkCompany: function() {
    exec(null, null, PLUGIN_NAME, 'unlinkCompany', []);
  },
 setCompanyAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'setCompanyAttribute', [attribute, value]);
  }, 
 incrementCompanyAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'incrementCompanyAttribute', [attribute, value]);
  }, 
 decrementCompanyAttribute: function(attribute, value) {
    exec(null, null, PLUGIN_NAME, 'decrementCompanyAttribute', [attribute, value]);
  }, 
 trackScreenView: function(screenName) {
    exec(null, null, PLUGIN_NAME, 'trackScreenView', [screenName]);
  },
 trackScreenViewWithAttributes: function(screenName, attributes) {
    exec(null, null, PLUGIN_NAME, 'trackScreenViewWithAttributes', [screenName, attributes]);
  },
 trackEvent: function(eventName) {
    exec(null, null, PLUGIN_NAME, 'trackEvent', [eventName]);
  },
 trackEventWithAttributes: function(eventName, attributes) {
    exec(null, null, PLUGIN_NAME, 'trackEventWithAttributes', [eventName, attributes]);
  } 
};

module.exports = AppLinkIOPlugin;
