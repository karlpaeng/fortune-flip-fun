package dev.karl.fortuneflipfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<CardsModel> cardsList;

    LayoutInflater inflater;

    public GridAdapter(Context context, ArrayList<CardsModel> list) {
        this.context = context;
        this.cardsList = list;
    }
    public void removeItem(Integer card){
        cardsList.remove(card);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cardsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }
        //

        ConstraintLayout ll = convertView.findViewById(R.id.LLgriditem);
        ImageView imageView = convertView.findViewById(R.id.ivImageGridItem);


        if (cardsList.get(position).isFlippedOpen){
            imageView.setImageResource(cardsList.get(position).resource);
        }else {
            imageView.setImageResource(R.drawable.cardx);
        }

        switch (cardsList.get(position).colorIndicator){
            case 1:
                ll.setBackgroundResource(R.color.white);
                break;
            case 2:
                ll.setBackgroundResource(R.color.green);
                break;
            default:
                ll.setBackgroundResource(R.color.white_50_percent);
                break;
        }




        return convertView;
    }
    public void flipOpen(int position){
        cardsList.set(position, new CardsModel(cardsList.get(position).resource, true, 0));
        notifyDataSetChanged();
    }

    public void flipClose(int position){
        cardsList.set(position, new CardsModel(cardsList.get(position).resource, false, 0));
        notifyDataSetChanged();
    }
    public void setColorIndicator(int pos, int colorIndicator){
        cardsList.set(
                pos,
                new CardsModel(
                        cardsList.get(pos).resource,
                        cardsList.get(pos).isFlippedOpen,
                        colorIndicator
                )
        );
        notifyDataSetChanged();

    }
}
