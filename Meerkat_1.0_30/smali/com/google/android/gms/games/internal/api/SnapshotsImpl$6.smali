.class Lcom/google/android/gms/games/internal/api/SnapshotsImpl$6;
.super Lcom/google/android/gms/games/internal/api/SnapshotsImpl$LoadImpl;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/games/internal/api/SnapshotsImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzafA:Ljava/lang/String;

.field final synthetic zzafB:Ljava/lang/String;

.field final synthetic zzafy:Z


# virtual methods
.method protected bridge synthetic zza(Lcom/google/android/gms/common/api/Api$zza;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/games/internal/GamesClientImpl;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$6;->zza(Lcom/google/android/gms/games/internal/GamesClientImpl;)V

    return-void
.end method

.method protected zza(Lcom/google/android/gms/games/internal/GamesClientImpl;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$6;->zzafA:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$6;->zzafB:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$6;->zzafy:Z

    invoke-virtual {p1, p0, v0, v1, v2}, Lcom/google/android/gms/games/internal/GamesClientImpl;->zzc(Lcom/google/android/gms/common/api/zza$zzb;Ljava/lang/String;Ljava/lang/String;Z)V

    return-void
.end method
