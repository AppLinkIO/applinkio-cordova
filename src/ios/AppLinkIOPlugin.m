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

       [self.commandDelegate runInBackground:^{

            if ([command argumentAtIndex:0]) {
                projectToken = [command argumentAtIndex:0];
            }

            if (projectToken) {
                [AppLinkIO initAppLinkIO:projectToken];
            }        
        }];


}

- (void)initAppLinkIOWithOptions:(CDVInvokedUrlCommand *)command {

       [self.commandDelegate runInBackground:^{

            if ([command.arguments count] == 2) {
                NSString *projectToken = [command argumentAtIndex:0];
                NSDictionary *projectOptions = [command argumentAtIndex:1];

                [AppLinkIO initAppLinkIO:projectToken withOptions:projectOptions];
            }    
        }]; 
} 

- (void)startSession:(CDVInvokedUrlCommand *)command {

  [AppLinkIO startSession];
}
 
- (void)stopSession:(CDVInvokedUrlCommand *)command {

  [AppLinkIO stopSession];
}

- (void)linkUser:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *userIdentifier = [command argumentAtIndex:0];
        NSString *identifierType = [command argumentAtIndex:1];

        [AppLinkIO linkUser:userIdentifier byType:identifierType];
    }
}

- (void)unlinkUser:(CDVInvokedUrlCommand *)command {

  [AppLinkIO unlinkUser];
}


- (void)setUserAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSString *value = [command argumentAtIndex:1];

        [AppLinkIO setUserAttribute:attribute byType:value];
    }
}
 
- (void)incrementUserAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSNumber *value = [command argumentAtIndex:1];

        [AppLinkIO incrementUserAttribute:attribute withValue:value];
    }
}
 
- (void)decrementUserAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSNumber *value = [command argumentAtIndex:1];

        [AppLinkIO decrementUserAttribute:attribute withValue:value];
    }
}



- (void)linkCompany:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 1) {
        NSString *companyName = [command argumentAtIndex:0]; 

        [AppLinkIO linkCompany:companyName];
    }
}

- (void)unlinkCompany:(CDVInvokedUrlCommand *)command {

  [AppLinkIO unlinkCompany];
}


- (void)setCompanyAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSString *value = [command argumentAtIndex:1];

        [AppLinkIO setCompanyAttribute:attribute byType:value];
    }
}
 
- (void)incrementCompanyAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSNumber *value = [command argumentAtIndex:1];

        [AppLinkIO incrementCompanyAttribute:attribute withValue:value];
    }
}
 
- (void)decrementCompanyAttribute:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *attribute = [command argumentAtIndex:0];
        NSNumber *value = [command argumentAtIndex:1];

        [AppLinkIO decrementCompanyAttribute:attribute withValue:value];
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

- (void)trackScreenViewWithAttributes:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *screenName = [command argumentAtIndex:0];
        NSDictionary *attributes = [command argumentAtIndex:1];

        [AppLinkIO trackScreenView:screenName withAttributes:attributes];
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

- (void)trackEventWithAttributes:(CDVInvokedUrlCommand *)command {

    if ([command.arguments count] == 2) {
        NSString *eventName = [command argumentAtIndex:0];
        NSDictionary *attributes = [command argumentAtIndex:1];

        [AppLinkIO trackEvent:eventName withAttributes:attributes];
    }
}


@end
