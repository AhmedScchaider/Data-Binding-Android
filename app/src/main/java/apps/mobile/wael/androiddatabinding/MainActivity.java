package apps.mobile.wael.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import apps.mobile.wael.androiddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding bindings = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = findViewById(R.id.food_category);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);
        CategoryAdapter mAdapter = new CategoryAdapter(this, bindings, testData());
        recyclerView.setAdapter(mAdapter);
    }

    private List<CategoryObject> testData() {
        List<CategoryObject> categoryList = new ArrayList<>();
        categoryList.add(new CategoryObject("Hot dog", R.drawable.food));
        categoryList.add(new CategoryObject("Bulgar", R.drawable.bulgar));
        categoryList.add(new CategoryObject("Potato", R.drawable.potato));
        categoryList.add(new CategoryObject("Soup", R.drawable.soup));
        categoryList.add(new CategoryObject("Couscous", R.drawable.couscous));
        categoryList.add(new CategoryObject("Macaroni", R.drawable.macaroni));
        return categoryList;
    }
}