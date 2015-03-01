package com.marverenic.music.instances;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Song implements Parcelable {

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String songName;
    public String artistName;
    public String albumName;
    public int songDuration;
    public String location;
    public long albumId;
    public long artistId;

    public Song(final String songName, final String artistName, final String albumName, final int songDuration, final String location, final long albumId, final long artistId) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.songDuration = songDuration;
        this.location = location;
        this.albumId = albumId;
        this.artistId = artistId;
    }

    private Song(Parcel in) {
        albumName = in.readString();
        artistName = in.readString();
        songDuration = in.readInt();
        location = in.readString();
        albumId = in.readLong();
        artistId = in.readLong();
    }

    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        return TextUtils.equals(albumName, other.albumName) && TextUtils.equals(artistName, other.artistName) && songDuration != other.songDuration && TextUtils.equals(songName, other.songName);
    }

    public String toString() {
        return songName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(albumName);
        dest.writeString(artistName);
        dest.writeInt(songDuration);
        dest.writeString(location);
        dest.writeLong(albumId);
        dest.writeLong(artistId);
    }
}