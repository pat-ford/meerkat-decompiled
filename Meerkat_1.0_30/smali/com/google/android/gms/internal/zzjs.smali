.class public abstract Lcom/google/android/gms/internal/zzjs;
.super Lcom/google/android/gms/internal/zzjt;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzjs$1;,
        Lcom/google/android/gms/internal/zzjs$zza;
    }
.end annotation


# instance fields
.field protected final mHandler:Landroid/os/Handler;

.field protected final zzKa:J

.field protected final zzKb:Ljava/lang/Runnable;

.field protected zzKc:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 2

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/zzjt;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjs;->mHandler:Landroid/os/Handler;

    new-instance v0, Lcom/google/android/gms/internal/zzjs$zza;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/zzjs$zza;-><init>(Lcom/google/android/gms/internal/zzjs;Lcom/google/android/gms/internal/zzjs$1;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzjs;->zzKb:Ljava/lang/Runnable;

    iput-wide p4, p0, Lcom/google/android/gms/internal/zzjs;->zzKa:J

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzjs;->zzK(Z)V

    return-void
.end method


# virtual methods
.method protected final zzK(Z)V
    .locals 4

    iget-boolean v0, p0, Lcom/google/android/gms/internal/zzjs;->zzKc:Z

    if-eq v0, p1, :cond_0

    iput-boolean p1, p0, Lcom/google/android/gms/internal/zzjs;->zzKc:Z

    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/zzjs;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjs;->zzKb:Ljava/lang/Runnable;

    iget-wide v2, p0, Lcom/google/android/gms/internal/zzjs;->zzKa:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/zzjs;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzjs;->zzKb:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public zzhm()V
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/zzjs;->zzK(Z)V

    return-void
.end method

.method protected abstract zzo(J)Z
.end method
