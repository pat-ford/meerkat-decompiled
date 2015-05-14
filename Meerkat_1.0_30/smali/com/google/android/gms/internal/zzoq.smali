.class public Lcom/google/android/gms/internal/zzoq;
.super Lcom/google/android/gms/common/internal/zzk;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/zzoq$zza;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/common/internal/zzk",
        "<",
        "Lcom/google/android/gms/internal/zzos;",
        ">;"
    }
.end annotation


# instance fields
.field private final mTheme:I

.field private final zzHg:Ljava/lang/String;

.field private zzalt:Lcom/google/android/gms/internal/zzoq$zza;

.field private zzoi:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;Ljava/lang/String;I)V
    .locals 6

    const/16 v3, 0xc

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/common/internal/zzk;-><init>(Landroid/content/Context;Landroid/os/Looper;ILcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)V

    iput-object p5, p0, Lcom/google/android/gms/internal/zzoq;->zzHg:Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/internal/zzoq;->zzoi:Landroid/app/Activity;

    iput p6, p0, Lcom/google/android/gms/internal/zzoq;->mTheme:I

    return-void
.end method


# virtual methods
.method public disconnect()V
    .locals 2

    const/4 v1, 0x0

    invoke-super {p0}, Lcom/google/android/gms/common/internal/zzk;->disconnect()V

    iget-object v0, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/zzoq$zza;->zza(Lcom/google/android/gms/internal/zzoq$zza;Landroid/app/Activity;)V

    iput-object v1, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    :cond_0
    return-void
.end method

.method public zza(Lcom/google/android/gms/identity/intents/UserAddressRequest;I)V
    .locals 5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzoq;->zzpn()V

    new-instance v0, Lcom/google/android/gms/internal/zzoq$zza;

    iget-object v1, p0, Lcom/google/android/gms/internal/zzoq;->zzoi:Landroid/app/Activity;

    invoke-direct {v0, p2, v1}, Lcom/google/android/gms/internal/zzoq$zza;-><init>(ILandroid/app/Activity;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    :try_start_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzoq;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzoq;->zzHg:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "com.google.android.gms.identity.intents.EXTRA_ACCOUNT"

    new-instance v2, Landroid/accounts/Account;

    iget-object v3, p0, Lcom/google/android/gms/internal/zzoq;->zzHg:Ljava/lang/String;

    const-string v4, "com.google"

    invoke-direct {v2, v3, v4}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    :cond_0
    const-string v1, "com.google.android.gms.identity.intents.EXTRA_THEME"

    iget v2, p0, Lcom/google/android/gms/internal/zzoq;->mTheme:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzoq;->zzpm()Lcom/google/android/gms/internal/zzos;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    invoke-interface {v1, v2, p1, v0}, Lcom/google/android/gms/internal/zzos;->zza(Lcom/google/android/gms/internal/zzor;Lcom/google/android/gms/identity/intents/UserAddressRequest;Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "AddressClientImpl"

    const-string v2, "Exception requesting user address"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "com.google.android.gms.identity.intents.EXTRA_ERROR_CODE"

    const/16 v2, 0x22b

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    iget-object v1, p0, Lcom/google/android/gms/internal/zzoq;->zzalt:Lcom/google/android/gms/internal/zzoq$zza;

    const/4 v2, 0x1

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/internal/zzoq$zza;->zzi(ILandroid/os/Bundle;)V

    goto :goto_0
.end method

.method protected zzbd(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzos;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/internal/zzos$zza;->zzbf(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzos;

    move-result-object v0

    return-object v0
.end method

.method protected zzcF()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.identity.service.BIND"

    return-object v0
.end method

.method protected zzcG()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.identity.intents.internal.IAddressService"

    return-object v0
.end method

.method protected synthetic zzp(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzoq;->zzbd(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzos;

    move-result-object v0

    return-object v0
.end method

.method protected zzpm()Lcom/google/android/gms/internal/zzos;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/DeadObjectException;
        }
    .end annotation

    invoke-super {p0}, Lcom/google/android/gms/common/internal/zzk;->zzjb()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzos;

    return-object v0
.end method

.method protected zzpn()V
    .locals 0

    invoke-super {p0}, Lcom/google/android/gms/common/internal/zzk;->zzfc()V

    return-void
.end method
