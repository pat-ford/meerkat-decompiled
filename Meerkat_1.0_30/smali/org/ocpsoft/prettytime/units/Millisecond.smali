.class public Lorg/ocpsoft/prettytime/units/Millisecond;
.super Lorg/ocpsoft/prettytime/impl/ResourcesTimeUnit;
.source "Millisecond.java"

# interfaces
.implements Lorg/ocpsoft/prettytime/TimeUnit;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 25
    invoke-direct {p0}, Lorg/ocpsoft/prettytime/impl/ResourcesTimeUnit;-><init>()V

    .line 26
    const-wide/16 v0, 0x1

    invoke-virtual {p0, v0, v1}, Lorg/ocpsoft/prettytime/units/Millisecond;->setMillisPerUnit(J)V

    .line 27
    return-void
.end method


# virtual methods
.method protected getResourceKeyPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    const-string v0, "Millisecond"

    return-object v0
.end method
