package apps.mobile.wael.androiddatabinding;

/**
 * Created by wael on 07/03/18.
 */

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class CustomImageBinding {
    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}