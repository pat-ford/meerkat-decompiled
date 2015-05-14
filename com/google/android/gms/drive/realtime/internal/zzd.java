package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzd extends IInterface
{
  public abstract void zza(ParcelableCollaborator paramParcelableCollaborator)
    throws RemoteException;

  public abstract void zzb(ParcelableCollaborator paramParcelableCollaborator)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzd
  {
    public static zzd zzah(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      if ((localIInterface != null) && ((localIInterface instanceof zzd)))
        return (zzd)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
        int j = paramParcel1.readInt();
        ParcelableCollaborator localParcelableCollaborator2 = null;
        if (j != 0)
          localParcelableCollaborator2 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(paramParcel1);
        zza(localParcelableCollaborator2);
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
      int i = paramParcel1.readInt();
      ParcelableCollaborator localParcelableCollaborator1 = null;
      if (i != 0)
        localParcelableCollaborator1 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(paramParcel1);
      zzb(localParcelableCollaborator1);
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzd
    {
      private IBinder zzle;

      zza(IBinder paramIBinder)
      {
        this.zzle = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.zzle;
      }

      public void zza(ParcelableCollaborator paramParcelableCollaborator)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
          if (paramParcelableCollaborator != null)
          {
            localParcel1.writeInt(1);
            paramParcelableCollaborator.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void zzb(ParcelableCollaborator paramParcelableCollaborator)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
          if (paramParcelableCollaborator != null)
          {
            localParcel1.writeInt(1);
            paramParcelableCollaborator.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}