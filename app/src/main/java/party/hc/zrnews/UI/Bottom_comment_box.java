package party.hc.zrnews.UI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.w3c.dom.Comment;

import party.hc.zrnews.R;

/**
 * Created by ubuntu on 18-7-15.
 */

public class Bottom_comment_box extends LinearLayout{

    public Bottom_comment_box(Context context) {
        super(context);
        init();
    }

    public Bottom_comment_box(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Bottom_comment_box(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Bottom_comment_box(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.bottom_comment_box,this,true);
        EditText comment_editText=findViewById(R.id.editText);
        ImageButton jumpToCommentButton=findViewById(R.id.comment_button);
        ImageButton starButton=findViewById(R.id.button2);
        ImageButton shareButton=findViewById(R.id.button3);

    }
}
