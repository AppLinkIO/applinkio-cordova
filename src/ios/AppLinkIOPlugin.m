//
//  AppLinkIOPlugin.m
//
//  Copyright 2018 AppLinkIO.io Inc. All rights reserved.
//

#import <objc/runtime.h>
#import "AppDelegate.h"
#import "AppLinkIOPlugin.h"

#import <Cordova/CDVAvailability.h>


#import <AppLinkIO/AppLinkIO.h>

@implementation AppLinkIOPlugin



- (void)initAppLinkIO:(CDVInvokedUrlCommand *)command {
    NSString *projectToken = nil;

    if ([command argumentAtIndex:0]) {
        projectToken = [command argumentAtIndex:0];
    }

    if (projectToken) {
        [AppLinkIO initAppLinkIO:projectToken];
    }
}

/*
- (void)initAppLinkIOWithOptions:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *appToken = [command argumentAtIndex:0];
        NSDictionary *appOptions = [command argumentAtIndex:1];

        [AppLinkIO initAppLinkIO:appToken withOptions:appOptions];
    }
}

- (void)unlinkAppLinkIO:(CDVInvokedUrlCommand *)command {

  [AppLinkIO unlinkAppLinkIO];
}

- (void)linkUser:(CDVInvokedUrlCommand *)command {
    NSString *userEmailAddress = nil;

    if ([command argumentAtIndex:0]) {
        userEmailAddress = [command argumentAtIndex:0];
    }

    if (userEmailAddress) {
        [AppLinkIO linkUser:userEmailAddress];
    }
}


- (void)setUserAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attributeName = [command argumentAtIndex:0];
        NSString *attributeValue = [command argumentAtIndex:1];

        [AppLinkIO setUserAttribute:attributeName withValue:attributeValue];
    }
}


- (void)trackScreenView:(CDVInvokedUrlCommand *)command {
    NSString *screenName = nil;

    if ([command argumentAtIndex:0]) {
        screenName = [command argumentAtIndex:0];
    }

    if (screenName) {
        [AppLinkIO trackScreenView:screenName];
    }
}

- (void)trackScreenViewWithExtras:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *screenName = [command argumentAtIndex:0];
        NSDictionary *screenExtras = [command argumentAtIndex:1];

        [AppLinkIO trackScreenView:screenName withExtras:screenExtras];
    }
}

- (void)trackEvent:(CDVInvokedUrlCommand *)command {
    NSString *eventName = nil;

    if ([command argumentAtIndex:0]) {
        eventName = [command argumentAtIndex:0];
    }

    if (eventName) {
        [AppLinkIO trackEvent:eventName];
    }
}

- (void)trackEventWithExtras:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *eventName = [command argumentAtIndex:0];
        NSDictionary *eventExtras = [command argumentAtIndex:1];

        [AppLinkIO trackEvent:eventName withExtras:eventExtras];
    }
}

- (void)trackImpression:(CDVInvokedUrlCommand *)command {
    NSDictionary *displayDetails = nil;

    if ([command argumentAtIndex:0]) {
        displayDetails = [command argumentAtIndex:0];
    }

    if (displayDetails) {
        [AppLinkIO trackImpression:displayDetails];
    }
}

- (void)trackInteraction:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSDictionary *displayDetails = [command argumentAtIndex:0];
        NSString *interactionType = [command argumentAtIndex:1];

        [AppLinkIO trackInteraction:displayDetails :interactionType];
    }
}

- (void)trackConversion:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSDictionary *displayDetails = [command argumentAtIndex:0];
        NSDictionary *conversionDetails = [command argumentAtIndex:1];

        [AppLinkIO trackConversion:displayDetails :conversionDetails];
    }
}

- (void)trackSearch:(CDVInvokedUrlCommand *)command {

    NSDictionary *searchDetails = nil;

    if ([command argumentAtIndex:0]) {
        searchDetails = [command argumentAtIndex:0];
    }

    if (searchDetails) {
        [AppLinkIO trackSearch:searchDetails];
    }
}
*/


@end
