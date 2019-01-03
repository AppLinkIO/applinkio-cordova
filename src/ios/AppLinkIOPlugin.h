//
//  AppLinkIOPlugin.h
//
//  Copyright 2018 AppLinkIO.io Inc. All rights reserved.
//

#import <Cordova/CDVPlugin.h>

@interface AppLinkIOPlugin : CDVPlugin {
}

- (void)initAppLinkIO:(CDVInvokedUrlCommand *)command; 
- (void)initAppLinkIOWithOptions:(CDVInvokedUrlCommand *)command;
- (void)startSession:(CDVInvokedUrlCommand *)command;
- (void)stopSession:(CDVInvokedUrlCommand *)command;
- (void)linkUser:(CDVInvokedUrlCommand *)command;
- (void)unlinkUser:(CDVInvokedUrlCommand *)command;
- (void)setUserAttribute:(CDVInvokedUrlCommand *)command;
- (void)incrementUserAttribute:(CDVInvokedUrlCommand *)command;
- (void)decrementUserAttribute:(CDVInvokedUrlCommand *)command;
- (void)linkCompany:(CDVInvokedUrlCommand *)command; 
- (void)unlinkCompany:(CDVInvokedUrlCommand *)command;
- (void)setCompanyAttribute:(CDVInvokedUrlCommand *)command;
- (void)incrementCompanyAttribute:(CDVInvokedUrlCommand *)command;
- (void)decrementCompanyAttribute:(CDVInvokedUrlCommand *)command;
- (void)trackScreenView:(CDVInvokedUrlCommand *)command;
- (void)trackScreenViewWithAttributes:(CDVInvokedUrlCommand *)command;
- (void)trackEvent:(CDVInvokedUrlCommand *)command;
- (void)trackEventWithAttributes:(CDVInvokedUrlCommand *)command;

@end
