package co.com.arrendamientosnutibara.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

import java.util.List;

import co.com.arrendamientosnutibara.entities.Section;
import co.com.arrendamientosnutibara.entities.Element;
import co.com.arrendamientosnutibara.main.R;
import co.com.arrendamientosnutibara.widgets.CenturyBoldTextView;
import co.com.arrendamientosnutibara.widgets.CenturyRegularTextView;

/**
 * Created by jva807 on 22/07/2017.
 */

public class InventoryAdapter extends ExpandableRecyclerAdapter<Section, Element, InventoryAdapter.SectionViewHolder, InventoryAdapter.ElementViewHolder>{

    private Context context;
    private List<Section> sections;

    public InventoryAdapter(Context context, @NonNull List<Section> sections) {
        super(sections);
        this.context = context;
        this.sections = sections;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chapter, parentViewGroup, false);
        return new SectionViewHolder(view);
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_element, childViewGroup);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(@NonNull SectionViewHolder parentViewHolder, int parentPosition, @NonNull Section parent) {

    }

    @Override
    public void onBindChildViewHolder(@NonNull ElementViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Element child) {

    }

    class ElementViewHolder extends ChildViewHolder{

        private CenturyRegularTextView titleLabel;

        ElementViewHolder(@NonNull View view) {
            super(view);
            titleLabel = view.findViewById(R.id.title_label);
        }

        public void bind(Element element){
            titleLabel.setText(element.getElement());
        }
    }

    class SectionViewHolder extends ParentViewHolder{

        private CenturyBoldTextView titleLabel;

        SectionViewHolder(@NonNull View view) {
            super(view);
            titleLabel = view.findViewById(R.id.title_label);
        }

        public void bind(Section section){
            titleLabel.setText(section.getSection());
        }
    }

}
