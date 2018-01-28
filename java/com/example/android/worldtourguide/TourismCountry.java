package com.example.android.worldtourguide;

class TourismCountry {

    // Name of the Tourism Place in India
    private String mPlaceName;

    // Name of the Place or city of tourism
    private String mCityName;

    // Drawable resource ID
    private int mImageResourceId;

    TourismCountry(String vPlaceName, String vCityName, int imageResourceId) {
        mPlaceName = vPlaceName;
        mCityName = vCityName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Tourism Place in India
     */
    String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the Place or city of tourism
     */
    String getCityName() {
        return mCityName;
    }

    /**
     * Get the image resource ID
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

}