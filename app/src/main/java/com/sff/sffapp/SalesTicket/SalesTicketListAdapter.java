package com.sff.sffapp.SalesTicket;
/*
created by hani,eyyad,abdo,mb
edited by mb
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sff.sffapp.R;
import java.util.ArrayList;
public class SalesTicketListAdapter extends BaseAdapter
{
    /********************************************************************************************/
    Context mContext;
    LayoutInflater inflater;
    ArrayList<SalesTicketAddItemCell> salesTicketListArrayList;
    private View view;
    /********************************************************************************************/
    public SalesTicketListAdapter(Context context , ArrayList<SalesTicketAddItemCell> salesTicketListArrayList )
    {
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
        this.salesTicketListArrayList = salesTicketListArrayList ;
    }
    /********************************************************************************************/
    public class ViewHolder
    {
        TextView txt_trans_ser_no,txt_mgrp_desc,txt_item_desc,txt_color_name,txt_note,txt_price;
    }
    /********************************************************************************************/
    @Override
    public int getCount()
    {
        return this.salesTicketListArrayList.size();
    }
    /********************************************************************************************/
    @Override
    public Object getItem(int position)
    {
        return this.salesTicketListArrayList.get(position);
    }
    /********************************************************************************************/
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    /********************************************************************************************/
    @Override
    public View getView(final int position, View view, ViewGroup parent)
    {
        final SalesTicketListAdapter.ViewHolder holder;
        if (view == null)
        {
            /********************************************************************************************/
            view = inflater.inflate(R.layout.sales_ticket_add_item_cell, null);
            /********************************************************************************************/
            holder = new SalesTicketListAdapter.ViewHolder();
            holder.txt_trans_ser_no = view.findViewById(R.id.txt_trans_ser_no);
            holder.txt_mgrp_desc    = view.findViewById(R.id.mess_fragment_txt_room_desc);
            holder.txt_item_desc    = view.findViewById(R.id.p8009_txt_item_desc);
            holder.txt_color_name   = view.findViewById(R.id.p8009_txt_color_name);
            holder.txt_note         = view.findViewById(R.id.p8009_txt_item_note);
            holder.txt_price        = view.findViewById(R.id.p8009_txt_price);
            view.setTag(holder);
            /********************************************************************************************/
        }
        else
        {
            holder = (SalesTicketListAdapter.ViewHolder)view.getTag();
        }
        /********************************************************************************************/
        holder.txt_trans_ser_no.setText(String.valueOf(this.salesTicketListArrayList.get(position).v_ser_no));
        holder.txt_mgrp_desc.setText(this.salesTicketListArrayList.get(position).v_mgrp_desc);
        holder.txt_item_desc.setText(this.salesTicketListArrayList.get(position).v_item_desc);
        holder.txt_color_name.setText(this.salesTicketListArrayList.get(position).v_color_name);
        holder.txt_note.setText(this.salesTicketListArrayList.get(position).v_note);
        holder.txt_price.setText(this.salesTicketListArrayList.get(position).v_item_price);
        /********************************************************************************************/
        return view;
    }
    /********************************************************************************************/
    public void BackPressed ()
    {
        notifyDataSetChanged();
    }
}
