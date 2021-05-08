
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
public class State$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.covidapp.models.State>
{

    private com.example.covidapp.models.State state$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<State$$Parcelable>CREATOR = new Creator<State$$Parcelable>() {


        @Override
        public State$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new State$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public State$$Parcelable[] newArray(int size) {
            return new State$$Parcelable[size] ;
        }

    }
    ;

    public State$$Parcelable(com.example.covidapp.models.State state$$2) {
        state$$0 = state$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(state$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.covidapp.models.State state$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(state$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(state$$1));
            parcel$$1 .writeString(state$$1 .infectedCount);
            parcel$$1 .writeString(state$$1 .stateName);
            parcel$$1 .writeString(state$$1 .fullyVaccinated);
            parcel$$1 .writeString(state$$1 .fullStateName);
            parcel$$1 .writeString(state$$1 .deathCount);
            parcel$$1 .writeString(state$$1 .stateImage);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.covidapp.models.State getParcel() {
        return state$$0;
    }

    public static com.example.covidapp.models.State read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.covidapp.models.State state$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            state$$4 = new com.example.covidapp.models.State();
            identityMap$$1 .put(reservation$$0, state$$4);
            state$$4 .infectedCount = parcel$$3 .readString();
            state$$4 .stateName = parcel$$3 .readString();
            state$$4 .fullyVaccinated = parcel$$3 .readString();
            state$$4 .fullStateName = parcel$$3 .readString();
            state$$4 .deathCount = parcel$$3 .readString();
            state$$4 .stateImage = parcel$$3 .readString();
            com.example.covidapp.models.State state$$3 = state$$4;
            identityMap$$1 .put(identity$$1, state$$3);
            return state$$3;
        }
    }

}
