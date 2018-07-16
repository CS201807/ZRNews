package party.hc.zrnews.UI;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;

import party.hc.zrnews.R;

public class SearchEditText extends AppCompatEditText {
    private Drawable searchDrawble,clearDrawble;

    public SearchEditText(Context context) {
        super(context);
        init();
    }


    public SearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        clearDrawble=getResources().getDrawable(R.drawable.delete);
        searchDrawble=getResources().getDrawable(R.drawable.search);
//        searchDrawble.setBounds(15,15,35,35);
        setCompoundDrawablesWithIntrinsicBounds(searchDrawble,null,null,null);

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearIconVisible(hasFocus()&&text.length()>0);
    }

    private void setClearIconVisible(boolean visible) {
        setCompoundDrawablesWithIntrinsicBounds(searchDrawble,null,visible?clearDrawble:null,null);


    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        setClearIconVisible(focused&&length()>0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                Drawable drawable=clearDrawble;
                if(drawable!=null&&event.getX()<=(getWidth()-getPaddingRight())&&event.getX()>=(getWidth()-getPaddingRight()-drawable.getBounds().width())){
                    setText("");
                    break;
                }
        }
        return super.onTouchEvent(event);
    }
}
