package apps.mobile.wael.androiddatabinding;

/**
 * Created by wael on 07/03/18.
 */
public class CategoryObject {
    private String name;
    private int imageUrl;
    public CategoryObject(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }
    public int getImageUrl() {
        return imageUrl;
    }
}