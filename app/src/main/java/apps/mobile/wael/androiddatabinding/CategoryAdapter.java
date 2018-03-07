package apps.mobile.wael.androiddatabinding;

/**
 * Created by wael on 07/03/18.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apps.mobile.wael.androiddatabinding.databinding.ActivityMainBinding;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private HashMap<String, Integer> choiceUserMap;
    private Context context;
    private List<CategoryObject> categoryObjectList;
    private ActivityMainBinding bindings;

    public CategoryAdapter(Context context, ActivityMainBinding bindings, List<CategoryObject> categoryObjectList) {
        this.context = context;
        this.bindings = bindings;
        this.categoryObjectList = categoryObjectList;
        choiceUserMap = new HashMap<>();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_list, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final CategoryObject categoryObject = categoryObjectList.get(position);
        holder.getBindings().setVariable(BR.category, categoryObject);
        holder.getBindings().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return categoryObjectList.size();
    }

    /**
     * Show in the number of user clicks of each item in the list after every ItemClick
     *
     * @param position
     */
    private void performChoiceUser(int position) {
        String categoryName = categoryObjectList.get(position).getName();
        if (!choiceUserMap.containsKey(categoryName)) {
            choiceUserMap.put(categoryName, 1);
        } else {
            Integer countClick = choiceUserMap.get(categoryName);
            choiceUserMap.put(categoryName, ++countClick);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : choiceUserMap.entrySet()) {
            String row = entry.getKey() + " : " + entry.getValue() + " ,";
            stringBuilder.append(row);
        }
        bindings.setUserChoice(new UserChoice(stringBuilder.toString()));
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ViewDataBinding bindings;

        CategoryViewHolder(View itemView) {
            super(itemView);
            bindings = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        ViewDataBinding getBindings() {
            return bindings;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            performChoiceUser(position);
        }
    }
}