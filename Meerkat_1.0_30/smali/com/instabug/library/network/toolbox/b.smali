.class public Lcom/instabug/library/network/toolbox/b;
.super Ljava/lang/Object;
.source "SSLUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/instabug/library/network/toolbox/b$a;
    }
.end annotation


# instance fields
.field public a:I

.field public b:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/instabug/library/network/toolbox/b$a;)V
    .locals 3

    .prologue
    .line 21
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/instabug/library/network/toolbox/c;

    invoke-direct {v1, p0, p1}, Lcom/instabug/library/network/toolbox/c;-><init>(Landroid/content/Context;Lcom/instabug/library/network/toolbox/b$a;)V

    const-string v2, "InstabugNetInit"

    invoke-direct {v0, v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 48
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 50
    return-void
.end method
