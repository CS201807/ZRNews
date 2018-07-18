package party.hc.zrnews.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import party.hc.zrnews.R;

public class BitmapShaders extends View{
    private BitmapShader bitmapShader;
    private Bitmap bitmap;
    private ShapeDrawable shapeDrawable=null;
    private int BitmapWidth;
    private int BitmapHeight;



    private void init(){
        bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.h)).getBitmap();
        BitmapWidth=bitmap.getWidth();
        BitmapHeight=bitmap.getHeight();
        float scaleWidth = ((float) 300) /BitmapWidth;
        float scaleHeight = ((float) 300) / BitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, BitmapWidth, BitmapHeight, matrix, true);
        bitmapShader=new BitmapShader(newbm, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }
    public BitmapShaders(Context context) {
        super(context);
        init();
    }



    public BitmapShaders(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaders(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        shapeDrawable = new ShapeDrawable(new OvalShape());

        Paint paint=shapeDrawable.getPaint();
        paint.setShader(bitmapShader);

        shapeDrawable.setBounds(20,10,320,310);
        shapeDrawable.draw(canvas);
    }
}
