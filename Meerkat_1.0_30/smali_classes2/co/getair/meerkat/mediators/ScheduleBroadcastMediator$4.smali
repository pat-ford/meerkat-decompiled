.class Lco/getair/meerkat/mediators/ScheduleBroadcastMediator$4;
.super Ljava/lang/Object;
.source "ScheduleBroadcastMediator.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/getair/meerkat/mediators/ScheduleBroadcastMediator;->handleNotification(Lorg/puremvc/java/multicore/interfaces/INotification;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/getair/meerkat/mediators/ScheduleBroadcastMediator;


# direct methods
.method constructor <init>(Lco/getair/meerkat/mediators/ScheduleBroadcastMediator;)V
    .locals 0
    .param p1, "this$0"    # Lco/getair/meerkat/mediators/ScheduleBroadcastMediator;

    .prologue
    .line 170
    iput-object p1, p0, Lco/getair/meerkat/mediators/ScheduleBroadcastMediator$4;->this$0:Lco/getair/meerkat/mediators/ScheduleBroadcastMediator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichButton"    # I

    .prologue
    .line 172
    return-void
.end method
