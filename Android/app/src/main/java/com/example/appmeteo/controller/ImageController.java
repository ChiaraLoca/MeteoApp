package com.example.appmeteo.controller;

import android.widget.ImageView;

import com.example.appmeteo.R;

public class ImageController {
    private static ImageController instance=null;

    public static ImageController getInstance() {
        if(instance==null)
            instance= new ImageController();
        return instance;
    }

    private ImageController() {
    }


    public void setImage(ImageView image, String imageId)
    {
        switch(imageId)
        {
            case "01d": {image.setImageResource(R.drawable.image01d);break;}
            case "01n": {image.setImageResource(R.drawable.image01n);break;}
            case "02d": {image.setImageResource(R.drawable.image02d);break;}
            case "02n": {image.setImageResource(R.drawable.image02n);break;}
            case "03d": {image.setImageResource(R.drawable.image03d);break;}
            case "03n": {image.setImageResource(R.drawable.image03n);break;}
            case "04d": {image.setImageResource(R.drawable.image04d);break;}
            case "04n": {image.setImageResource(R.drawable.image04n);break;}
            case "09d": {image.setImageResource(R.drawable.imge09d);break;}
            case "09n": {image.setImageResource(R.drawable.imge09n);break;}
            case "10d": {image.setImageResource(R.drawable.image10d);break;}
            case "10n": {image.setImageResource(R.drawable.image10n);break;}
            case "11d": {image.setImageResource(R.drawable.image11d);break;}
            case "11n": {image.setImageResource(R.drawable.image11n);break;}
            case "13d": {image.setImageResource(R.drawable.image13d);break;}
            case "13n": {image.setImageResource(R.drawable.image13n);break;}
            case "50d": {image.setImageResource(R.drawable.image50d);break;}
            case "50n": {image.setImageResource(R.drawable.image50n);break;}
            default:{image.setImageResource(R.drawable.ic_launcher_background);break;}


        }


    }


}
