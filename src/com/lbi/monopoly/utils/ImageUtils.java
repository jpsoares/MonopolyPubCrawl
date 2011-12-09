package com.lbi.monopoly.utils;

import android.content.Context;
import android.graphics.AvoidXfermode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageUtils {
    public static Bitmap getRoundedCornerBitmap(Context context, Bitmap bitmap, float upperLeft,
            float upperRight, float lowerRight, float lowerLeft, int endWidth,
            int endHeight) {
        float densityMultiplier = context.getResources().getDisplayMetrics().density;
    
        // scale incoming bitmap to appropriate px size given arguments and display dpi
        bitmap = Bitmap.createScaledBitmap(bitmap, 
                Math.round(endWidth * densityMultiplier),
                Math.round(endHeight * densityMultiplier), true);
    
        // create empty bitmap for drawing
        Bitmap output = Bitmap.createBitmap(
                Math.round(endWidth * densityMultiplier),
                Math.round(endHeight * densityMultiplier), Config.ARGB_8888);
    
        // get canvas for empty bitmap
        Canvas canvas = new Canvas(output);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
    
        // scale the rounded corners appropriately given dpi
        upperLeft *= densityMultiplier;
        upperRight *= densityMultiplier;
        lowerRight *= densityMultiplier;
        lowerLeft *= densityMultiplier;
    
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
    
        // fill the canvas with transparency
        canvas.drawARGB(0, 0, 0, 0);
    
        // draw the rounded corners around the image rect. clockwise, starting in upper left.
        canvas.drawCircle(upperLeft, upperLeft, upperLeft, paint);
        canvas.drawCircle(width - upperRight, upperRight, upperRight, paint);
        canvas.drawCircle(width - lowerRight, height - lowerRight, lowerRight, paint);
        canvas.drawCircle(lowerLeft, height - lowerLeft, lowerLeft, paint);
    
        // fill in all the gaps between circles. clockwise, starting at top.
        RectF rectT = new RectF(upperLeft, 0, width - upperRight, height / 2);
        RectF rectR = new RectF(width / 2, upperRight, width, height - lowerRight);
        RectF rectB = new RectF(lowerLeft, height / 2, width - lowerRight, height);
        RectF rectL = new RectF(0, upperLeft, width / 2, height - lowerLeft);
    
        canvas.drawRect(rectT, paint);
        canvas.drawRect(rectR, paint);
        canvas.drawRect(rectB, paint);
        canvas.drawRect(rectL, paint);
    
        // set up the rect for the image
        Rect imageRect = new Rect(0, 0, width, height);
    
        // set up paint object such that it only paints on Color.WHITE
        paint.setXfermode(new AvoidXfermode(Color.WHITE, 255, AvoidXfermode.Mode.TARGET));
    
        // draw resized bitmap onto imageRect in canvas, using paint as configured above
        canvas.drawBitmap(bitmap, imageRect, imageRect, paint);
    
        return output;
    }
    
    public static Bitmap getRoundedCornerBitmap(Context context, Bitmap input, int pixels , int w , int h , boolean squareTL, boolean squareTR, boolean squareBL, boolean squareBR  ) {

        Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, w, h);
        final RectF rectF = new RectF(rect);

        //make sure that our rounded corner is scaled appropriately
        final float roundPx = pixels*densityMultiplier;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);


        //draw rectangles over the corners we want to be square
        if (squareTL ){
            canvas.drawRect(0, 0, w/2, h/2, paint);
        }
        if (squareTR ){
            canvas.drawRect(w/2, 0, w, h/2, paint);
        }
        if (squareBL ){
            canvas.drawRect(0, h/2, w/2, h, paint);
        }
        if (squareBR ){
            canvas.drawRect(w/2, h/2, w, h, paint);
        }
        //paint.setXfermode(new AvoidXfermode(Color.WHITE, 255, AvoidXfermode.Mode.TARGET));
        
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(input, 0,0, paint);

        return output;
    }
}

