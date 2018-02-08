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
- (void)unlinkAppLinkIO:(CDVInvokedUrlCommand *)command;
- (void)linkUser:(CDVInvokedUrlCommand *)command;
- (void)setUserAttribute:(CDVInvokedUrlCommand *)command;
- (void)trackScreenView:(CDVInvokedUrlCommand *)command;
- (void)trackScreenViewWithExtras:(CDVInvokedUrlCommand *)command;
- (void)trackEvent:(CDVInvokedUrlCommand *)command;
- (void)trackEventWithExtras:(CDVInvokedUrlCommand *)command;
- (void)trackImpression:(CDVInvokedUrlCommand *)command;
- (void)trackInteraction:(CDVInvokedUrlCommand *)command;
- (void)trackConversion:(CDVInvokedUrlCommand *)command;
- (void)trackSearch:(CDVInvokedUrlCommand *)command;

@end
