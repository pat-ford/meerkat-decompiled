.class Lcom/google/android/gms/drive/internal/zzaa$zza;
.super Landroid/os/Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/drive/internal/zzaa;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "zza"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/os/Looper;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p2, p0, Lcom/google/android/gms/drive/internal/zzaa$zza;->mContext:Landroid/content/Context;

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Looper;Landroid/content/Context;Lcom/google/android/gms/drive/internal/zzaa$1;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/drive/internal/zzaa$zza;-><init>(Landroid/os/Looper;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/google/android/gms/drive/internal/zzaa$zza;->mContext:Landroid/content/Context;

    const-string v1, "EventCallback"

    const-string v2, "Don\'t know how to handle this event"

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/drive/internal/zzw;->zze(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/util/Pair;

    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Lcom/google/android/gms/drive/events/zzc;

    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/drive/events/DriveEvent;

    invoke-interface {v0}, Lcom/google/android/gms/drive/events/DriveEvent;->getType()I

    move-result v2

    packed-switch v2, :pswitch_data_1

    const-string v1, "EventCallback"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unexpected event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/google/android/gms/drive/internal/zzw;->zzr(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :pswitch_1
    check-cast v1, Lcom/google/android/gms/drive/events/ChangeListener;

    check-cast v0, Lcom/google/android/gms/drive/events/ChangeEvent;

    invoke-interface {v1, v0}, Lcom/google/android/gms/drive/events/ChangeListener;->onChange(Lcom/google/android/gms/drive/events/ChangeEvent;)V

    goto :goto_0

    :pswitch_2
    check-cast v1, Lcom/google/android/gms/drive/events/CompletionListener;

    check-cast v0, Lcom/google/android/gms/drive/events/CompletionEvent;

    invoke-interface {v1, v0}, Lcom/google/android/gms/drive/events/CompletionListener;->onCompletion(Lcom/google/android/gms/drive/events/CompletionEvent;)V

    goto :goto_0

    :pswitch_3
    check-cast v1, Lcom/google/android/gms/drive/events/zzf;

    invoke-interface {v1}, Lcom/google/android/gms/drive/events/zzf;->zzkD()V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public zza(Lcom/google/android/gms/drive/events/zzc;Lcom/google/android/gms/drive/events/DriveEvent;)V
    .locals 2

    const/4 v0, 0x1

    new-instance v1, Landroid/util/Pair;

    invoke-direct {v1, p1, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/drive/internal/zzaa$zza;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/drive/internal/zzaa$zza;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
