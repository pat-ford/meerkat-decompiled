.class public Lcom/digits/sdk/android/PhoneNumberActivity;
.super Lcom/digits/sdk/android/DigitsActivity;
.source "PhoneNumberActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/digits/sdk/android/DigitsActivity;-><init>()V

    return-void
.end method


# virtual methods
.method getActivityDelegate()Lcom/digits/sdk/android/DigitsActivityDelegate;
    .locals 1

    .prologue
    .line 11
    new-instance v0, Lcom/digits/sdk/android/PhoneNumberActivityDelegate;

    invoke-direct {v0}, Lcom/digits/sdk/android/PhoneNumberActivityDelegate;-><init>()V

    return-object v0
.end method
