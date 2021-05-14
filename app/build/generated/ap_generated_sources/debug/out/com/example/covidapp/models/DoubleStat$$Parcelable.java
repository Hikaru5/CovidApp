
package com.example.covidapp.models;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class DoubleStat$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.covidapp.models.DoubleStat>
{

    private com.example.covidapp.models.DoubleStat doubleStat$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<DoubleStat$$Parcelable>CREATOR = new Creator<DoubleStat$$Parcelable>() {


        @Override
        public DoubleStat$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new DoubleStat$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public DoubleStat$$Parcelable[] newArray(int size) {
            return new DoubleStat$$Parcelable[size] ;
        }

    }
    ;

    public DoubleStat$$Parcelable(com.example.covidapp.models.DoubleStat doubleStat$$2) {
        doubleStat$$0 = doubleStat$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(doubleStat$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.covidapp.models.DoubleStat doubleStat$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(doubleStat$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(doubleStat$$1));
            parcel$$1 .writeString(doubleStat$$1 .statTitle2);
            parcel$$1 .writeString(doubleStat$$1 .stat2);
            parcel$$1 .writeString(doubleStat$$1 .statTitle1);
            parcel$$1 .writeString(doubleStat$$1 .stat1);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.covidapp.models.DoubleStat getParcel() {
        return doubleStat$$0;
    }

    public static com.example.covidapp.models.DoubleStat read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.covidapp.models.DoubleStat doubleStat$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            doubleStat$$4 = new com.example.covidapp.models.DoubleStat();
            identityMap$$1 .put(reservation$$0, doubleStat$$4);
            doubleStat$$4 .statTitle2 = parcel$$3 .readString();
            doubleStat$$4 .stat2 = parcel$$3 .readString();
            doubleStat$$4 .statTitle1 = parcel$$3 .readString();
            doubleStat$$4 .stat1 = parcel$$3 .readString();
            com.example.covidapp.models.DoubleStat doubleStat$$3 = doubleStat$$4;
            identityMap$$1 .put(identity$$1, doubleStat$$3);
            return doubleStat$$3;
        }
    }

}
