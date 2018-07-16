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

//    /** 图片宽和高的比例 */
//    private float ratio = 1f;
//
//    public void setRatio(float ratio) {
//        this.ratio = ratio;
//    }


    public BitmapShaders(Context context) {
        super(context);
        bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.h)).getBitmap();
        BitmapWidth=bitmap.getWidth();
        BitmapHeight=bitmap.getHeight();
        float scaleWidth = ((float) 150) /BitmapWidth;
        float scaleHeight = ((float) 150) / BitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, BitmapWidth, BitmapHeight, matrix, true);
        bitmapShader=new BitmapShader(newbm, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }



    public BitmapShaders(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.h)).getBitmap();
        BitmapWidth=bitmap.getWidth();
        BitmapHeight=bitmap.getHeight();
        float scaleWidth = ((float) 150) /BitmapWidth;
        float scaleHeight = ((float) 150) / BitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, BitmapWidth, BitmapHeight, matrix, true);
        bitmapShader=new BitmapShader(newbm, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }

    public BitmapShaders(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.h)).getBitmap();
        BitmapWidth=bitmap.getWidth();
        BitmapHeight=bitmap.getHeight();

        float scaleWidth = ((float) 150) /BitmapWidth;
        float scaleHeight = ((float) 150 ) / BitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, BitmapWidth, BitmapHeight, matrix, true);
        bitmapShader=new BitmapShader(newbm, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//        // 父容器传过来的宽度方向上的模式
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        // 父容器传过来的高度方向上的模式
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//
//        // 父容器传过来的宽度的值
//        int width = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()
//                - getPaddingRight();
//        // 父容器传过来的高度的值
//        int height = MeasureSpec.getSize(heightMeasureSpec) - getPaddingLeft()
//                - getPaddingRight();
//
//        if (widthMode == MeasureSpec.EXACTLY
//                && heightMode != MeasureSpec.EXACTLY && ratio != 0.0f) {
//            // 判断条件为，宽度模式为Exactly，也就是填充父窗体或者是指定宽度；
//            // 且高度模式不是Exaclty，代表设置的既不是fill_parent也不是具体的值，于是需要具体测量
//            // 且图片的宽高比已经赋值完毕，不再是0.0f
//            // 表示宽度确定，要测量高度
//            height = (int) (width / ratio + 0.5f);
//            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
//                    MeasureSpec.EXACTLY);
//        } else if (widthMode != MeasureSpec.EXACTLY
//                && heightMode == MeasureSpec.EXACTLY && ratio != 0.0f) {
//            // 判断条件跟上面的相反，宽度方向和高度方向的条件互换
//            // 表示高度确定，要测量宽度
//            width = (int) (height * ratio + 0.5f);
//
//            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
//                    MeasureSpec.EXACTLY);
//        }
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }


    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        shapeDrawable = new ShapeDrawable(new OvalShape());

        Paint paint=shapeDrawable.getPaint();
        paint.setShader(bitmapShader);

        shapeDrawable.setBounds(20,10,170,160);
        shapeDrawable.draw(canvas);
    }
}
