package com.example.android.musicalstructureapp;

public class songs {

    // Name of the song
    private String mSongName;

    //name of the Artist
    private String mArtistName;

    // drawable resource id
    private int mImageResourceId;

    /*
     * Create a new songs object.
     *
     * @param sName is the name of the song
     * @param aName is the corresponding Artist name
     * @param image is drawable reference ID that corresponds to the name of the song
     * */
    public songs(String sName, String aName, int imageResourceId){
        mSongName = sName;
        mArtistName = aName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the Artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the image Resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    
}
