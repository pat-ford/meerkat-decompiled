.class public Lorg/ocpsoft/prettytime/units/Century;
.super Lorg/ocpsoft/prettytime/impl/ResourcesTimeUnit;
.source "Century.java"

# interfaces
.implements Lorg/ocpsoft/prettytime/TimeUnit;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 24
    invoke-direct {p0}, Lorg/ocpsoft/prettytime/impl/ResourcesTimeUnit;-><init>()V

    .line 25
    const-wide v0, 0x2debdefb0deL

    invoke-virtual {p0, v0, v1}, Lorg/ocpsoft/prettytime/units/Century;->setMillisPerUnit(J)V

    .line 26
    return-void
.end method


# virtual methods
.method protected getResourceKeyPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    const-string v0, "Century"

    return-object v0
.end method
