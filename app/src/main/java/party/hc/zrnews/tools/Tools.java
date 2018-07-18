package party.hc.zrnews.tools;

import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * Created by ubuntu on 18-7-15.
 */

public class Tools {

    public static void share(Context context,String title,String link) {
        Intent share_intent = new Intent();
        share_intent.setAction(Intent.ACTION_SEND);
        share_intent.setType("text/html");
        share_intent.putExtra(Intent.EXTRA_SUBJECT, "f分享");
        share_intent.putExtra(Intent.EXTRA_TEXT, "HI 推荐您看一条新闻:" + link);
        share_intent = Intent.createChooser(share_intent, "分享");
        context.startActivity(share_intent);
    }

}
