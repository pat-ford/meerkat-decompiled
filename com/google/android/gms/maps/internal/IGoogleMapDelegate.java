package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.IPolylineDelegate.zza;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;
import com.google.android.gms.maps.model.zza;
import com.google.android.gms.maps.model.zzw;

public abstract interface IGoogleMapDelegate extends IInterface
{
  public abstract com.google.android.gms.maps.model.internal.zzh addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;

  public abstract zzi addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;

  public abstract zzi addGroundOverlay2(GroundOverlayOptions paramGroundOverlayOptions, com.google.android.gms.maps.model.internal.zze paramzze)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.zzl addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.zzl addMarker2(MarkerOptions paramMarkerOptions, com.google.android.gms.maps.model.internal.zzp paramzzp)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.zzm addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;

  public abstract IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.zzn addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;

  public abstract void animateCamera(com.google.android.gms.dynamic.zzd paramzzd)
    throws RemoteException;

  public abstract void animateCamera2(com.google.android.gms.maps.model.internal.zzc paramzzc)
    throws RemoteException;

  public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.zzd paramzzd, zzb paramzzb)
    throws RemoteException;

  public abstract void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.zzc paramzzc, zzb paramzzb)
    throws RemoteException;

  public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd paramzzd, int paramInt, zzb paramzzb)
    throws RemoteException;

  public abstract void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.zzc paramzzc, int paramInt, zzb paramzzb)
    throws RemoteException;

  public abstract void clear()
    throws RemoteException;

  public abstract CameraPosition getCameraPosition()
    throws RemoteException;

  public abstract com.google.android.gms.maps.model.internal.zzj getFocusedBuilding()
    throws RemoteException;

  public abstract void getMapAsync(zzm paramzzm)
    throws RemoteException;

  public abstract int getMapType()
    throws RemoteException;

  public abstract float getMaxZoomLevel()
    throws RemoteException;

  public abstract float getMinZoomLevel()
    throws RemoteException;

  public abstract Location getMyLocation()
    throws RemoteException;

  public abstract IProjectionDelegate getProjection()
    throws RemoteException;

  public abstract IUiSettingsDelegate getUiSettings()
    throws RemoteException;

  public abstract boolean isBuildingsEnabled()
    throws RemoteException;

  public abstract boolean isIndoorEnabled()
    throws RemoteException;

  public abstract boolean isMyLocationEnabled()
    throws RemoteException;

  public abstract boolean isTrafficEnabled()
    throws RemoteException;

  public abstract void moveCamera(com.google.android.gms.dynamic.zzd paramzzd)
    throws RemoteException;

  public abstract void moveCamera2(com.google.android.gms.maps.model.internal.zzc paramzzc)
    throws RemoteException;

  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;

  public abstract void onDestroy()
    throws RemoteException;

  public abstract void onLowMemory()
    throws RemoteException;

  public abstract void onPause()
    throws RemoteException;

  public abstract void onResume()
    throws RemoteException;

  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;

  public abstract void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setContentDescription(String paramString)
    throws RemoteException;

  public abstract boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setInfoWindowAdapter(zzd paramzzd)
    throws RemoteException;

  public abstract void setInfoWindowRenderer(zze paramzze)
    throws RemoteException;

  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException;

  public abstract void setMapType(int paramInt)
    throws RemoteException;

  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setOnCameraChangeListener(zzf paramzzf)
    throws RemoteException;

  public abstract void setOnIndoorStateChangeListener(zzg paramzzg)
    throws RemoteException;

  public abstract void setOnInfoWindowClickListener(zzh paramzzh)
    throws RemoteException;

  public abstract void setOnMapClickListener(zzj paramzzj)
    throws RemoteException;

  public abstract void setOnMapLoadedCallback(zzk paramzzk)
    throws RemoteException;

  public abstract void setOnMapLongClickListener(zzl paramzzl)
    throws RemoteException;

  public abstract void setOnMarkerClickListener(zzn paramzzn)
    throws RemoteException;

  public abstract void setOnMarkerDragListener(zzo paramzzo)
    throws RemoteException;

  public abstract void setOnMyLocationButtonClickListener(zzp paramzzp)
    throws RemoteException;

  public abstract void setOnMyLocationChangeListener(zzq paramzzq)
    throws RemoteException;

  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;

  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void snapshot(zzv paramzzv, com.google.android.gms.dynamic.zzd paramzzd)
    throws RemoteException;

  public abstract void stopAnimation()
    throws RemoteException;

  public abstract boolean useViewLifecycleWhenInFragment()
    throws RemoteException;

  public static abstract class zza extends Binder
    implements IGoogleMapDelegate
  {
    public static IGoogleMapDelegate zzbu(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof IGoogleMapDelegate)))
        return (IGoogleMapDelegate)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        CameraPosition localCameraPosition = getCameraPosition();
        paramParcel2.writeNoException();
        if (localCameraPosition != null)
        {
          paramParcel2.writeInt(1);
          localCameraPosition.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f2 = getMaxZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f1 = getMinZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f1);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        moveCamera(com.google.android.gms.dynamic.zzd.zza.zzau(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCamera(com.google.android.gms.dynamic.zzd.zza.zzau(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithCallback(com.google.android.gms.dynamic.zzd.zza.zzau(paramParcel1.readStrongBinder()), zzb.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd.zza.zzau(paramParcel1.readStrongBinder()), paramParcel1.readInt(), zzb.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        stopAnimation();
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (PolylineOptions localPolylineOptions = PolylineOptions.CREATOR.zzdZ(paramParcel1); ; localPolylineOptions = null)
        {
          IPolylineDelegate localIPolylineDelegate = addPolyline(localPolylineOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder11 = null;
          if (localIPolylineDelegate != null)
            localIBinder11 = localIPolylineDelegate.asBinder();
          paramParcel2.writeStrongBinder(localIBinder11);
          return true;
        }
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (PolygonOptions localPolygonOptions = PolygonOptions.CREATOR.zzdY(paramParcel1); ; localPolygonOptions = null)
        {
          com.google.android.gms.maps.model.internal.zzm localzzm = addPolygon(localPolygonOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder10 = null;
          if (localzzm != null)
            localIBinder10 = localzzm.asBinder();
          paramParcel2.writeStrongBinder(localIBinder10);
          return true;
        }
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (MarkerOptions localMarkerOptions2 = MarkerOptions.CREATOR.zzdX(paramParcel1); ; localMarkerOptions2 = null)
        {
          com.google.android.gms.maps.model.internal.zzl localzzl2 = addMarker(localMarkerOptions2);
          paramParcel2.writeNoException();
          IBinder localIBinder9 = null;
          if (localzzl2 != null)
            localIBinder9 = localzzl2.asBinder();
          paramParcel2.writeStrongBinder(localIBinder9);
          return true;
        }
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (GroundOverlayOptions localGroundOverlayOptions2 = GroundOverlayOptions.CREATOR.zzdU(paramParcel1); ; localGroundOverlayOptions2 = null)
        {
          zzi localzzi2 = addGroundOverlay(localGroundOverlayOptions2);
          paramParcel2.writeNoException();
          IBinder localIBinder8 = null;
          if (localzzi2 != null)
            localIBinder8 = localzzi2.asBinder();
          paramParcel2.writeStrongBinder(localIBinder8);
          return true;
        }
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (TileOverlayOptions localTileOverlayOptions = TileOverlayOptions.CREATOR.zzef(paramParcel1); ; localTileOverlayOptions = null)
        {
          com.google.android.gms.maps.model.internal.zzn localzzn = addTileOverlay(localTileOverlayOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder7 = null;
          if (localzzn != null)
            localIBinder7 = localzzn.asBinder();
          paramParcel2.writeStrongBinder(localIBinder7);
          return true;
        }
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        clear();
        paramParcel2.writeNoException();
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i9 = getMapType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i9);
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setMapType(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool10 = isTrafficEnabled();
        paramParcel2.writeNoException();
        if (bool10);
        for (int i8 = 1; ; i8 = 0)
        {
          paramParcel2.writeInt(i8);
          return true;
        }
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i7 = paramParcel1.readInt();
        boolean bool9 = false;
        if (i7 != 0)
          bool9 = true;
        setTrafficEnabled(bool9);
        paramParcel2.writeNoException();
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool8 = isIndoorEnabled();
        paramParcel2.writeNoException();
        int i6 = 0;
        if (bool8)
          i6 = 1;
        paramParcel2.writeInt(i6);
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (boolean bool6 = true; ; bool6 = false)
        {
          boolean bool7 = setIndoorEnabled(bool6);
          paramParcel2.writeNoException();
          int i5 = 0;
          if (bool7)
            i5 = 1;
          paramParcel2.writeInt(i5);
          return true;
        }
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool5 = isMyLocationEnabled();
        paramParcel2.writeNoException();
        int i4 = 0;
        if (bool5)
          i4 = 1;
        paramParcel2.writeInt(i4);
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i3 = paramParcel1.readInt();
        boolean bool4 = false;
        if (i3 != 0)
          bool4 = true;
        setMyLocationEnabled(bool4);
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        Location localLocation = getMyLocation();
        paramParcel2.writeNoException();
        if (localLocation != null)
        {
          paramParcel2.writeInt(1);
          localLocation.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setLocationSource(ILocationSourceDelegate.zza.zzbx(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IUiSettingsDelegate localIUiSettingsDelegate = getUiSettings();
        paramParcel2.writeNoException();
        IBinder localIBinder6 = null;
        if (localIUiSettingsDelegate != null)
          localIBinder6 = localIUiSettingsDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder6);
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IProjectionDelegate localIProjectionDelegate = getProjection();
        paramParcel2.writeNoException();
        IBinder localIBinder5 = null;
        if (localIProjectionDelegate != null)
          localIBinder5 = localIProjectionDelegate.asBinder();
        paramParcel2.writeStrongBinder(localIBinder5);
        return true;
      case 27:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnCameraChangeListener(zzf.zza.zzbA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapClickListener(zzj.zza.zzbE(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLongClickListener(zzl.zza.zzbG(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerClickListener(zzn.zza.zzbI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerDragListener(zzo.zza.zzbJ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnInfoWindowClickListener(zzh.zza.zzbC(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowAdapter(zzd.zza.zzbv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (CircleOptions localCircleOptions = CircleOptions.CREATOR.zzdT(paramParcel1); ; localCircleOptions = null)
        {
          com.google.android.gms.maps.model.internal.zzh localzzh = addCircle(localCircleOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder4 = null;
          if (localzzh != null)
            localIBinder4 = localzzh.asBinder();
          paramParcel2.writeStrongBinder(localIBinder4);
          return true;
        }
      case 36:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationChangeListener(zzq.zza.zzbL(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 37:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationButtonClickListener(zzp.zza.zzbK(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 38:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        snapshot(zzv.zza.zzbR(paramParcel1.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzau(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 39:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setPadding(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 40:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool3 = isBuildingsEnabled();
        paramParcel2.writeNoException();
        int i2 = 0;
        if (bool3)
          i2 = 1;
        paramParcel2.writeInt(i2);
        return true;
      case 41:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i1 = paramParcel1.readInt();
        boolean bool2 = false;
        if (i1 != 0)
          bool2 = true;
        setBuildingsEnabled(bool2);
        paramParcel2.writeNoException();
        return true;
      case 42:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLoadedCallback(zzk.zza.zzbF(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        com.google.android.gms.maps.model.internal.zzj localzzj = getFocusedBuilding();
        paramParcel2.writeNoException();
        IBinder localIBinder3 = null;
        if (localzzj != null)
          localIBinder3 = localzzj.asBinder();
        paramParcel2.writeStrongBinder(localIBinder3);
        return true;
      case 45:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnIndoorStateChangeListener(zzg.zza.zzbB(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 53:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        getMapAsync(zzm.zza.zzbH(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 54:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          onCreate(localBundle2);
          paramParcel2.writeNoException();
          return true;
        }
      case 55:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onResume();
        paramParcel2.writeNoException();
        return true;
      case 56:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onPause();
        paramParcel2.writeNoException();
        return true;
      case 57:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        return true;
      case 58:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        return true;
      case 59:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool1 = useViewLifecycleWhenInFragment();
        paramParcel2.writeNoException();
        int n = 0;
        if (bool1)
          n = 1;
        paramParcel2.writeInt(n);
        return true;
      case 60:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
        {
          onSaveInstanceState(localBundle1);
          paramParcel2.writeNoException();
          if (localBundle1 == null)
            break;
          paramParcel2.writeInt(1);
          localBundle1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 61:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setContentDescription(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 64:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int m = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.zzc localzzc4 = null;
        if (m != 0)
          localzzc4 = com.google.android.gms.maps.model.internal.zzc.CREATOR.zzei(paramParcel1);
        moveCamera2(localzzc4);
        paramParcel2.writeNoException();
        return true;
      case 65:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int k = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.zzc localzzc3 = null;
        if (k != 0)
          localzzc3 = com.google.android.gms.maps.model.internal.zzc.CREATOR.zzei(paramParcel1);
        animateCamera2(localzzc3);
        paramParcel2.writeNoException();
        return true;
      case 66:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int j = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.zzc localzzc2 = null;
        if (j != 0)
          localzzc2 = com.google.android.gms.maps.model.internal.zzc.CREATOR.zzei(paramParcel1);
        animateCameraWithCallback2(localzzc2, zzb.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 67:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.zzc localzzc1 = null;
        if (i != 0)
          localzzc1 = com.google.android.gms.maps.model.internal.zzc.CREATOR.zzei(paramParcel1);
        animateCameraWithDurationAndCallback2(localzzc1, paramParcel1.readInt(), zzb.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 68:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        MarkerOptions localMarkerOptions1;
        if (paramParcel1.readInt() != 0)
        {
          localMarkerOptions1 = MarkerOptions.CREATOR.zzdX(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label2501;
        }
        for (com.google.android.gms.maps.model.internal.zzp localzzp = com.google.android.gms.maps.model.internal.zzp.CREATOR.zzek(paramParcel1); ; localzzp = null)
        {
          com.google.android.gms.maps.model.internal.zzl localzzl1 = addMarker2(localMarkerOptions1, localzzp);
          paramParcel2.writeNoException();
          IBinder localIBinder2 = null;
          if (localzzl1 != null)
            localIBinder2 = localzzl1.asBinder();
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
          localMarkerOptions1 = null;
          break;
        }
      case 69:
        label2501: paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowRenderer(zze.zza.zzbw(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 70:
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      GroundOverlayOptions localGroundOverlayOptions1;
      if (paramParcel1.readInt() != 0)
      {
        localGroundOverlayOptions1 = GroundOverlayOptions.CREATOR.zzdU(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label2613;
      }
      label2613: for (com.google.android.gms.maps.model.internal.zze localzze = com.google.android.gms.maps.model.internal.zze.CREATOR.zzej(paramParcel1); ; localzze = null)
      {
        zzi localzzi1 = addGroundOverlay2(localGroundOverlayOptions1, localzze);
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (localzzi1 != null)
          localIBinder1 = localzzi1.asBinder();
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
        localGroundOverlayOptions1 = null;
        break;
      }
    }

    private static class zza
      implements IGoogleMapDelegate
    {
      private IBinder zzle;

      zza(IBinder paramIBinder)
      {
        this.zzle = paramIBinder;
      }

      public com.google.android.gms.maps.model.internal.zzh addCircle(CircleOptions paramCircleOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramCircleOptions != null)
          {
            localParcel1.writeInt(1);
            paramCircleOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(35, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.zzh localzzh = com.google.android.gms.maps.model.internal.zzh.zza.zzbX(localParcel2.readStrongBinder());
            return localzzh;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public zzi addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramGroundOverlayOptions != null)
          {
            localParcel1.writeInt(1);
            paramGroundOverlayOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
            zzi localzzi = zzi.zza.zzbY(localParcel2.readStrongBinder());
            return localzzi;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public zzi addGroundOverlay2(GroundOverlayOptions paramGroundOverlayOptions, com.google.android.gms.maps.model.internal.zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramGroundOverlayOptions != null)
            {
              localParcel1.writeInt(1);
              paramGroundOverlayOptions.writeToParcel(localParcel1, 0);
              if (paramzze != null)
              {
                localParcel1.writeInt(1);
                paramzze.writeToParcel(localParcel1, 0);
                this.zzle.transact(70, localParcel1, localParcel2, 0);
                localParcel2.readException();
                zzi localzzi = zzi.zza.zzbY(localParcel2.readStrongBinder());
                return localzzi;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          localParcel1.writeInt(0);
        }
      }

      public com.google.android.gms.maps.model.internal.zzl addMarker(MarkerOptions paramMarkerOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramMarkerOptions != null)
          {
            localParcel1.writeInt(1);
            paramMarkerOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.zzl localzzl = com.google.android.gms.maps.model.internal.zzl.zza.zzcb(localParcel2.readStrongBinder());
            return localzzl;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.zzl addMarker2(MarkerOptions paramMarkerOptions, com.google.android.gms.maps.model.internal.zzp paramzzp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramMarkerOptions != null)
            {
              localParcel1.writeInt(1);
              paramMarkerOptions.writeToParcel(localParcel1, 0);
              if (paramzzp != null)
              {
                localParcel1.writeInt(1);
                paramzzp.writeToParcel(localParcel1, 0);
                this.zzle.transact(68, localParcel1, localParcel2, 0);
                localParcel2.readException();
                com.google.android.gms.maps.model.internal.zzl localzzl = com.google.android.gms.maps.model.internal.zzl.zza.zzcb(localParcel2.readStrongBinder());
                return localzzl;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          localParcel1.writeInt(0);
        }
      }

      public com.google.android.gms.maps.model.internal.zzm addPolygon(PolygonOptions paramPolygonOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramPolygonOptions != null)
          {
            localParcel1.writeInt(1);
            paramPolygonOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.zzm localzzm = com.google.android.gms.maps.model.internal.zzm.zza.zzcc(localParcel2.readStrongBinder());
            return localzzm;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramPolylineOptions != null)
          {
            localParcel1.writeInt(1);
            paramPolylineOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            IPolylineDelegate localIPolylineDelegate = IPolylineDelegate.zza.zzcd(localParcel2.readStrongBinder());
            return localIPolylineDelegate;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.zzn addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramTileOverlayOptions != null)
          {
            localParcel1.writeInt(1);
            paramTileOverlayOptions.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
            com.google.android.gms.maps.model.internal.zzn localzzn = com.google.android.gms.maps.model.internal.zzn.zza.zzce(localParcel2.readStrongBinder());
            return localzzn;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCamera(com.google.android.gms.dynamic.zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzd != null);
          for (IBinder localIBinder = paramzzd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCamera2(com.google.android.gms.maps.model.internal.zzc paramzzc)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzc != null)
          {
            localParcel1.writeInt(1);
            paramzzc.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(65, localParcel1, localParcel2, 0);
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

      public void animateCameraWithCallback(com.google.android.gms.dynamic.zzd paramzzd, zzb paramzzb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzd != null);
          for (IBinder localIBinder1 = paramzzd.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            IBinder localIBinder2 = null;
            if (paramzzb != null)
              localIBinder2 = paramzzb.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.zzle.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.zzc paramzzc, zzb paramzzb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramzzc != null)
            {
              localParcel1.writeInt(1);
              paramzzc.writeToParcel(localParcel1, 0);
              if (paramzzb != null)
              {
                localIBinder = paramzzb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.zzle.transact(66, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }

      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd paramzzd, int paramInt, zzb paramzzb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzd != null);
          for (IBinder localIBinder1 = paramzzd.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            localParcel1.writeInt(paramInt);
            IBinder localIBinder2 = null;
            if (paramzzb != null)
              localIBinder2 = paramzzb.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.zzle.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.zzc paramzzc, int paramInt, zzb paramzzb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramzzc != null)
            {
              localParcel1.writeInt(1);
              paramzzc.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (paramzzb != null)
              {
                localIBinder = paramzzb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.zzle.transact(67, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          IBinder localIBinder = null;
        }
      }

      public IBinder asBinder()
      {
        return this.zzle;
      }

      public void clear()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public CameraPosition getCameraPosition()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            CameraPosition localCameraPosition2 = CameraPosition.CREATOR.zzdS(localParcel2);
            localCameraPosition1 = localCameraPosition2;
            return localCameraPosition1;
          }
          CameraPosition localCameraPosition1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public com.google.android.gms.maps.model.internal.zzj getFocusedBuilding()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(44, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.maps.model.internal.zzj localzzj = com.google.android.gms.maps.model.internal.zzj.zza.zzbZ(localParcel2.readStrongBinder());
          return localzzj;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void getMapAsync(zzm paramzzm)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzm != null);
          for (IBinder localIBinder = paramzzm.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(53, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int getMapType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public float getMaxZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public float getMinZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Location getMyLocation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localLocation = (Location)Location.CREATOR.createFromParcel(localParcel2);
            return localLocation;
          }
          Location localLocation = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IProjectionDelegate getProjection()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IProjectionDelegate localIProjectionDelegate = IProjectionDelegate.zza.zzbQ(localParcel2.readStrongBinder());
          return localIProjectionDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public IUiSettingsDelegate getUiSettings()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IUiSettingsDelegate localIUiSettingsDelegate = IUiSettingsDelegate.zza.zzbV(localParcel2.readStrongBinder());
          return localIUiSettingsDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isBuildingsEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(40, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isIndoorEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isMyLocationEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean isTrafficEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void moveCamera(com.google.android.gms.dynamic.zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzd != null);
          for (IBinder localIBinder = paramzzd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void moveCamera2(com.google.android.gms.maps.model.internal.zzc paramzzc)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzc != null)
          {
            localParcel1.writeInt(1);
            paramzzc.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(64, localParcel1, localParcel2, 0);
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

      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(54, localParcel1, localParcel2, 0);
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

      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(57, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(58, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onPause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(56, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(55, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzle.transact(60, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
              paramBundle.readFromParcel(localParcel2);
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

      public void setBuildingsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzle.transact(41, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setContentDescription(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeString(paramString);
          this.zzle.transact(61, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean setIndoorEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramBoolean)
          {
            int j = i;
            localParcel1.writeInt(j);
            this.zzle.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int m = localParcel2.readInt();
            if (m == 0)
              break label80;
          }
          while (true)
          {
            return i;
            int k = 0;
            break;
            label80: i = 0;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setInfoWindowAdapter(zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzd != null);
          for (IBinder localIBinder = paramzzd.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(33, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setInfoWindowRenderer(zze paramzze)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzze != null);
          for (IBinder localIBinder = paramzze.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(69, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramILocationSourceDelegate != null);
          for (IBinder localIBinder = paramILocationSourceDelegate.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMapType(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt);
          this.zzle.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setMyLocationEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzle.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnCameraChangeListener(zzf paramzzf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzf != null);
          for (IBinder localIBinder = paramzzf.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnIndoorStateChangeListener(zzg paramzzg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzg != null);
          for (IBinder localIBinder = paramzzg.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(45, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnInfoWindowClickListener(zzh paramzzh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzh != null);
          for (IBinder localIBinder = paramzzh.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(32, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapClickListener(zzj paramzzj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzj != null);
          for (IBinder localIBinder = paramzzj.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapLoadedCallback(zzk paramzzk)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzk != null);
          for (IBinder localIBinder = paramzzk.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(42, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMapLongClickListener(zzl paramzzl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzl != null);
          for (IBinder localIBinder = paramzzl.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMarkerClickListener(zzn paramzzn)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzn != null);
          for (IBinder localIBinder = paramzzn.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(30, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMarkerDragListener(zzo paramzzo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzo != null);
          for (IBinder localIBinder = paramzzo.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(31, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMyLocationButtonClickListener(zzp paramzzp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzp != null);
          for (IBinder localIBinder = paramzzp.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(37, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setOnMyLocationChangeListener(zzq paramzzq)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzq != null);
          for (IBinder localIBinder = paramzzq.asBinder(); ; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            this.zzle.transact(36, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          this.zzle.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void setTrafficEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzle.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void snapshot(zzv paramzzv, com.google.android.gms.dynamic.zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          if (paramzzv != null);
          for (IBinder localIBinder1 = paramzzv.asBinder(); ; localIBinder1 = null)
          {
            localParcel1.writeStrongBinder(localIBinder1);
            IBinder localIBinder2 = null;
            if (paramzzd != null)
              localIBinder2 = paramzzd.asBinder();
            localParcel1.writeStrongBinder(localIBinder2);
            this.zzle.transact(38, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public void stopAnimation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean useViewLifecycleWhenInFragment()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.zzle.transact(59, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0)
            bool = true;
          return bool;
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