.class public final Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;
.super Ljava/lang/Object;
.source "AddGeofenceResult.java"


# instance fields
.field private final statusCode:I


# direct methods
.method constructor <init>(I)V
    .locals 0
    .param p1, "statusCode"    # I

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput p1, p0, Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;->statusCode:I

    .line 15
    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget v0, p0, Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;->statusCode:I

    invoke-static {v0}, Lcom/google/android/gms/location/GeofenceStatusCodes;->getStatusCodeString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 18
    iget v0, p0, Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;->statusCode:I

    return v0
.end method

.method public isSuccess()Z
    .locals 2

    .prologue
    .line 26
    iget v0, p0, Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;->statusCode:I

    if-eqz v0, :cond_0

    iget v0, p0, Lpl/charmas/android/reactivelocation/observables/geofence/AddGeofenceResult;->statusCode:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
