.class Lcom/google/android/gms/tagmanager/zzo$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/tagmanager/zzo$zza;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/tagmanager/zzo;->zzag(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzaxX:Lcom/google/android/gms/tagmanager/zzo;

.field final synthetic zzaxZ:Z


# direct methods
.method constructor <init>(Lcom/google/android/gms/tagmanager/zzo;Z)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/tagmanager/zzo$3;->zzaxX:Lcom/google/android/gms/tagmanager/zzo;

    iput-boolean p2, p0, Lcom/google/android/gms/tagmanager/zzo$3;->zzaxZ:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zzb(Lcom/google/android/gms/tagmanager/Container;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-boolean v2, p0, Lcom/google/android/gms/tagmanager/zzo$3;->zzaxZ:Z

    if-eqz v2, :cond_2

    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/Container;->getLastRefreshTime()J

    move-result-wide v2

    const-wide/32 v4, 0x2932e00

    add-long/2addr v2, v4

    iget-object v4, p0, Lcom/google/android/gms/tagmanager/zzo$3;->zzaxX:Lcom/google/android/gms/tagmanager/zzo;

    invoke-static {v4}, Lcom/google/android/gms/tagmanager/zzo;->zzg(Lcom/google/android/gms/tagmanager/zzo;)Lcom/google/android/gms/internal/zzlv;

    move-result-object v4

    invoke-interface {v4}, Lcom/google/android/gms/internal/zzlv;->currentTimeMillis()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/Container;->isDefault()Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method
